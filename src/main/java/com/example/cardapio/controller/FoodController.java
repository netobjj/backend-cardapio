package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food") // essa classe "public class FoodController" controla o endpoint "food"
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping // Quando forem no endpoint /food com o metodo Get (@GetMapping) você vai para a public abaixo dele: getAll
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public FoodResponseDTO updateFood(@PathVariable Long id, @RequestBody FoodRequestDTO data) {
        Food existingFood = repository.findById(id).orElseThrow(() -> new RuntimeException(("Food not found!")));
         existingFood.setTitle(data.title());
         existingFood.setDescription(data.description());
         existingFood.setImage(data.image());
         existingFood.setPrice(data.price());

         Food updatedFood = repository.save(existingFood);

        return new FoodResponseDTO(updatedFood);
    }

//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @DeleteMapping("/{id}")
//    public void deleteFood(@PathVariable Long id) {
//        repository.deleteById(id);
//    }


}
