package com.linkdatabase.td5javarefactoringredients.entity;

import java.util.List;

public class Dish {
    private Integer id;
    private String name;
    private DishTypeEnum dishType;
    private Double price;
    private List<DishIngredient> dishIngredients;

    // Getters et setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public DishTypeEnum getDishType() { return dishType; }
    public void setDishType(DishTypeEnum dishType) { this.dishType = dishType; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public List<DishIngredient> getDishIngredients() { return dishIngredients; }
    public void setDishIngredients(List<DishIngredient> dishIngredients) { this.dishIngredients = dishIngredients; }
}