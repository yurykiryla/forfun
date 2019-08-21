# https://blog.gruntwork.io/an-introduction-to-terraform-f17df9c6d180

provider "aws" {
  shared_credentials_file = "$HOME/.aws/credentials"
  profile                 = "default"
  region                  = "us-east-1"
}

resource "aws_instance" "example" {
  ami                    = "ami-0378588b4ae11ec24"
  instance_type          = "t2.micro"
  vpc_security_group_ids = [aws_security_group.instance.id]
  
  user_data = <<-EOF
              #!/bin/bash
              echo "Hello, World" > index.html
              nohup busybox httpd -f -p "${var.server_port}" &
              EOF
  
  tags          = {
    Name = "terraform-example"
  }
}

resource "aws_security_group" "instance" {
  name = "terraform-example-instance"
  
  ingress {
    from_port   = var.server_port
	to_port     = var.server_port
	protocol    = "tcp"
	cidr_blocks = ["0.0.0.0/0"]
  }
}

output "public_ip" {
  value       = aws_instance.example.public_ip
  description = "The public IP of the web server"
}

variable "server_port" {
  description = "The port the server will use for HTTP requests"
  type        = number
  default     = 8080
}

resource "aws_launch_configuration" "example" {
  image_id        = "ami-0378588b4ae11ec24"
  instance_type   = "t2.micro"
  security_groups = [aws_security_group.instance.id]
  
  user_data = <<-EOF
              #!/bin/bash
              echo "Hello, World" > index.html
              nohup busybox httpd -f -p "${var.server_port}" &
              EOF
  
  lifecycle {
	create_before_destroy = true
  }
}

resource "aws_autoscaling_group" "example" {
  launch_configuration = aws_launch_configuration.example.id
  availability_zones   = data.aws_availability_zones.all.names
  
  min_size = 2
  max_size = 10
  
  load_balancers    = [aws_elb.example.name]
  health_check_type = "ELB"
  
  tag {
    key                 = "Name"
	value               = "terraform-asg-example"
	propagate_at_launch = true
  }
}

data "aws_availability_zones" "all" {}

resource "aws_elb" "example" {
  name               = "terraform-asg-example"
  security_groups    = [aws_security_group.elb.id]
  availability_zones = data.aws_availability_zones.all.names
  
  health_check {
    target              = "HTTP:${var.server_port}/"
	interval            = 30
	timeout             = 3
	healthy_threshold   = 2
	unhealthy_threshold = 2
  }
  
  # This adds a listener for incoming HTTP requests.
  listener {
    lb_port           = 80
	lb_protocol       = "http"
	instance_port     = var.server_port
	instance_protocol = "http"
  }
}

resource "aws_security_group" "elb" {
  name = "terraform-example-elb"
  
  #Allow all outbound
  egress {
    from_port   = 0
	to_port     = 0
	protocol    = "-1"
	cidr_blocks = ["0.0.0.0/0"]
  }
  
  #Inbound http from anywhere
  ingress {
    from_port   = 80
	to_port     = 80
	protocol    = "tcp"
	cidr_blocks = ["0.0.0.0/0"]
  }
}

output "clb_dns_name" {
  value       = aws_elb.example.dns_name
  description = "The domain name of the load balancer"
}