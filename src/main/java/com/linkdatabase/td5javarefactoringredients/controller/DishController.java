package com.linkdatabase.td5javarefactoringredients.controller;

import com.linkdatabase.td5javarefactoringredients.entity.Dish;
import com.linkdatabase.td5javarefactoringredients.entity.Ingredient;
import com.linkdatabase.td5javarefactoringredients.repository.DishRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {

    private final DishRepository dishRepository = new DishRepository();

    @GetMapping("/dishes")
    public List<Dish> getAllDishes() {
        return dishRepository.findAllWithIngredients();
    }

    @PutMapping("/dishes/{id}/ingredients")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDishIngredients(@PathVariable int id,
                                      @RequestBody(required = false) List<Ingredient> ingredients) {
        if (ingredients == null) {
            throw new BadRequestException("Request body is required");
        }
        Dish dish = dishRepository.findById(id);
        if (dish == null) {
            throw new NotFoundException("Dish.id=" + id + " is not found");
        }
        dishRepository.updateIngredients(id, ingredients);
    }
}