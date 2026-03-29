package com.linkdatabase.td5javarefactoringredients.controller;

import com.linkdatabase.td5javarefactoringredients.entity.Ingredient;
import com.linkdatabase.td5javarefactoringredients.entity.StockValue;
import com.linkdatabase.td5javarefactoringredients.exception.BadRequestException;
import com.linkdatabase.td5javarefactoringredients.exception.NotFoundException;
import com.linkdatabase.td5javarefactoringredients.repository.IngredientRepository;
import com.linkdatabase.td5javarefactoringredients.repository.StockMovementRepository;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.format.DateTimeParseException;
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
            throw new NotFoundException("Ingredient.id={" + id + "} is not found");
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

        Instant instant;
        try {
            instant = Instant.parse(at);
        } catch (DateTimeParseException e) {
            throw new BadRequestException("Invalid date format for 'at'. Expected ISO 8601 (e.g., 2023-01-01T00:00:00Z)");
        }

        StockValue stock = stockMovementRepository.getStockValueAt(id, instant, unit);

        return Map.of("unite", stock.getUnit().toString(), "valeur", stock.getQuantity());
    }
}