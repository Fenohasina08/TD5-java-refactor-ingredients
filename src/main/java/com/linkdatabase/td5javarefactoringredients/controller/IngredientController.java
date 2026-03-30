package com.linkdatabase.td5javarefactoringredients.controller;

import com.linkdatabase.td5javarefactoringredients.entity.Ingredient;
import com.linkdatabase.td5javarefactoringredients.entity.StockValue;
import com.linkdatabase.td5javarefactoringredients.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients() {
        return ingredientService.findAll();
    }

    @GetMapping("/ingredients/{id}")
    public Ingredient getIngredientById(@PathVariable int id) {
        return ingredientService.getIngredientById(id);
    }

    @GetMapping("/ingredients/{id}/stock")
    public Map<String, Object> getStock(@PathVariable int id,
                                        @RequestParam String at,
                                        @RequestParam String unit) {
        StockValue stock = ingredientService.getStockValue(id, at, unit);
        return Map.of("unite", stock.getUnit().toString(), "valeur", stock.getQuantity());
    }
}