package com.linkdatabase.td5javarefactoringredients.entity;

import java.util.List;

public class Ingredient {
    private Integer id;
    private String name;
    private CategoryEnum category;
    private Double price;
    private List<StockMovement> stockMovementList;

    public Ingredient() {}
    public Ingredient(Integer id, String name, CategoryEnum category, Double price, List<StockMovement> stockMovements) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockMovementList = stockMovements;
    }
    // Getters et setters (à générer)
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public CategoryEnum getCategory() { return category; }
    public void setCategory(CategoryEnum category) { this.category = category; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public List<StockMovement> getStockMovementList() { return stockMovementList; }
    public void setStockMovementList(List<StockMovement> stockMovementList) { this.stockMovementList = stockMovementList; }
}