package com.example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import com.example.cucumber.pojo.Item;
import com.example.cucumber.services.FoodOrderService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {

  FoodOrderService foodOrderService;
  String category;

//  @Given("I have not yet ordered anything")
//  public void no_order_yet() {
//    foodOrderService = new FoodOrderService();
//  }
//
//  @When("I go to the {string} category")
//  public void i_go_to_category(String category) {
//    this.category = category;
//  }

  @When("I select a/an {string}")
  public void i_select_item(String itemName) {
    foodOrderService.addItem(new Item(itemName, category));
  }

  @Then("I have a new order")
  public void i_have_new_order() {
    assertTrue("Order was null", foodOrderService.getOrder().isPresent());
  }

  @Then("the order has {int} item(s) in it")
  public void order_has_n_items_in_it(int itenCount) {
    assertEquals("Wrong number of items in order", itenCount,
        foodOrderService.getOrder().get().getItems().size());
  }

  @Then("my current order total is {int}")
  public void current_order_total_is(int price) {
    assertEquals("Wrong order price", new BigDecimal(price),
        foodOrderService.getOrder().get().getPrice());
  }
}
