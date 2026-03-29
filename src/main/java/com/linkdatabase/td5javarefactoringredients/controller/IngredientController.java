package com.linkdatabase.td5javarefactoringredients.controller;

import com.linkdatabase.td5javarefactoringredients.entity.Ingredient;
import com.linkdatabase.td5javarefactoringredients.entity.StockValue;
import com.linkdatabase.td5javarefactoringredients.repository.IngredientRepository;
import com.linkdatabase.td5javarefactoringredients.repository.StockMovementRepository;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
public class IngredientController {

    private final IngredientRepository ingredientRepository = new IngredientRepository();
    private final StockMovementRepository stockMovementRepository = new StockMovementRepository();

    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @GetMapping("/ingredients/{id}")
    public Ingredient getIngredientById(@PathVariable int id) {
        Ingredient ing = ingredientRepository.findById(id);
        if (ing == null) {
            throw new NotFoundException("Ingredient.id=" + id + " is not found");
        }
        return ing;
    }

    @GetMapping("/ingredients/{id}/stock")
    public Map<String, Object> getStock(@PathVariable int id,
                                        @RequestParam String at,
                                        @RequestParam String unit) {
        if (at == null || unit == null) {
            throw new BadRequestException("Either mandatory query parameter `at` or `unit` is not provided.");
        }
        Ingredient ing = ingredientRepository.findById(id);
        if (ing == null) {
            throw new NotFoundException("Ingredient.id=" + id + " is not found");
        }
        Instant instant = Instant.parse(at); // format ISO 8601
        StockValue stock = stockMovementRepository.getStockValueAt(id, instant);
        return Map.of("unite", unit, "valeur", stock.getQuantity());
    }
}