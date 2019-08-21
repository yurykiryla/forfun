package com.example.cucumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.example.cucumber.services.FoodOrderService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

@ContextConfiguration(classes = SpringTestConfig.class)
public class ItemStepdefs {
  
  @Autowired
  ItemOrderInfo itemOrderInfo;
  
  @Given("I have not yet ordered anything")
  public void no_order_yet() {
    itemOrderInfo.foodOrderService = new FoodOrderService();
  }
  
  @When("I go to the {string} category")
  public void i_go_to_category(String category) {
    this.itemOrderInfo.category = category;
  }
}
