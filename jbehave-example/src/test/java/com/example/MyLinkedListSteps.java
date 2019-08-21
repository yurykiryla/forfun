package com.example;

import static org.junit.Assert.assertEquals;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class MyLinkedListSteps {
  private int numOfNodes;
  private String nodeVal;
  private MyLinkedList myLinkedList;
  
  @Given("$nnum nodes")
  public void numOfNodes(int num) {
    this.numOfNodes = num;
    myLinkedList = new MyLinkedList();
    System.out.println("Number of nodes going to add in list ===> " + num);
  }
  
  @When("node value as $val")
  public void addNodeValues(String val) {
    System.out.println(">>>> adding the values in the list as -- " + val);
    nodeVal = val;
  }
  
  @When("add them in the list")
  public void addThemInList() {
    System.out.println(">>>> adding into the list...");
    myLinkedList.addNodeInLast(new Node(nodeVal, null));
  }
  
  @Then("get the size as $size")
  public void getTheListSize(int size) {
    System.out.println(">>>> Expected list size is - " + size);
    assertEquals(size, myLinkedList.getSize());
  }
}
