package com.example.cucumber.repository;

import java.math.BigDecimal;
import com.example.cucumber.pojo.Item;

public class BasicItemRepository implements ItemRepository {

  @Override
  public BigDecimal getItemPrice(Item item) {
    if (item.getName().equalsIgnoreCase("Chicken Sandwich")) {
      return new BigDecimal(9);
    } else if (item.getName().equalsIgnoreCase("Oreo Cheesecake")) {
      return new BigDecimal(7);
    } else if (item.getName().equalsIgnoreCase("Cheeseburger")) {
      return new BigDecimal(9);
    }
    throw new IllegalArgumentException("Unknown item " + item.getName());
  }

}
