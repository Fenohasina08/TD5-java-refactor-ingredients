package com.linkdatabase.td5javarefactoringredients.controller;

import com.linkdatabase.td5javarefactoringredients.entity.Dish;
import com.linkdatabase.td5javarefactoringredients.entity.Ingredient;
import com.linkdatabase.td5javarefactoringredients.service.DishService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DishController {

    private final DishService dishService;

    @GetMapping("/dishes")
    public List<Dish> getAllDishes() {
        return dishService.findAllWithIngredients();
    }

    @GetMapping("/dishes/{id}")
    public Dish getDishById(@PathVariable int id) {
        return dishService.findById(id);
    }

    @PutMapping("/dishes/{id}/ingredients")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDishIngredients(@PathVariable int id,
                                      @RequestBody(required = false) List<Ingredient> ingredients) {
        dishService.updateDishIngredients(id, ingredients);
    }
}