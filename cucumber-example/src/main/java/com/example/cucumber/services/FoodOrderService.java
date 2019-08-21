package com.example.cucumber.services;

import java.util.Optional;
import com.example.cucumber.pojo.Item;
import com.example.cucumber.pojo.Order;
import com.example.cucumber.repository.BasicItemRepository;
import com.example.cucumber.repository.ItemRepository;

public class FoodOrderService {
  
  private Order order = new Order();
  
  private final ItemRepository itemRepository;
  
  public FoodOrderService() {
    itemRepository = new BasicItemRepository();
  }
  
  public Optional<Order> getOrder() {
    return Optional.ofNullable(order);
  }

  public void addItem(Item item) {
    if (order == null) {
      order = new Order();
    }
    
    order.getItems().add(item);
    order.setPrice(order.getPrice().add(itemRepository.getItemPrice(item)));
  }
  
  public void removeItem(Item item) {
    getOrder().ifPresent(order -> {
      order.getItems().remove(item);
      order.setPrice(order.getPrice().subtract(itemRepository.getItemPrice(item)));
    });
  }
}
