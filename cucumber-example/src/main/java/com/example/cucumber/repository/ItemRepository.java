package com.example.cucumber.repository;

import java.math.BigDecimal;
import com.example.cucumber.pojo.Item;

public interface ItemRepository {

  BigDecimal getItemPrice(Item item);
}
