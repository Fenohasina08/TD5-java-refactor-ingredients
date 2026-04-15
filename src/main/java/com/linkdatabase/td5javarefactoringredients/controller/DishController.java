package com.linkdatabase.td5javarefactoringredients.controller;

import com.linkdatabase.td5javarefactoringredients.entity.Dish;
import com.linkdatabase.td5javarefactoringredients.entity.Ingredient;
import com.linkdatabase.td5javarefactoringredients.service.DishService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DishController {

    private final DishService dishService;

    @GetMapping("/dishes")
    public ResponseEntity<?> getDishes() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(dishService.findAll().stream()
                            .map(dish -> new DishRest(dish.getId(),
                                    dish.getPrice(),
                                    dish.getName(),
                                    dish.getDishIngredients().stream()
                                            .map(dishIngredient ->
                                            {
                                                var ingredient = dishIngredient.getIngredient();
                                                return new DishIngredientRest(ingredient.getId(), ingredient.getName(), ingredient.getCategory(), ingredient.getPrice());
                                            }).toList()
                            ))
                            .toList());
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
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