package com.example.cucumber.pojo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@EqualsAndHashCode(of = "name")
@AllArgsConstructor
@Getter
@Setter
public class Item {

  @NonNull
  String name;

  @NonNull
  String category;

}
