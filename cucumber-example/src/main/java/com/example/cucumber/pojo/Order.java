package com.example.cucumber.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
  List<Item> items = new ArrayList<Item>();
  BigDecimal price = BigDecimal.ZERO;
}
