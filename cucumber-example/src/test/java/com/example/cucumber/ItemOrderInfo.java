package com.example.cucumber;

import org.springframework.stereotype.Component;
import com.example.cucumber.services.FoodOrderService;

@Component
public class ItemOrderInfo {
  String category;
  FoodOrderService foodOrderService;
}
