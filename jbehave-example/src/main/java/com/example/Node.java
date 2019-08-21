package com.example;

public class Node {
  
  private String data;
  private Node next;
  Node(String data, Node next) {
    super();
    this.data = data;
    this.next = next;
  }
  public String getData() {
    return data;
  }
  public void setData(String data) {
    this.data = data;
  }
  public Node getNext() {
    return next;
  }
  public void setNext(Node next) {
    this.next = next;
  }
  @Override
  public String toString() {
    return "Node [data=" + data + "]";
  }

}
