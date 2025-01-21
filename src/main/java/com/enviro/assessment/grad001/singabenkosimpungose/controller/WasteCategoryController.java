package com.enviro.assessment.grad001.singabenkosimpungose.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.enviro.assessment.grad001.singabenkosimpungose.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.singabenkosimpungose.model.WasteCategory;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/wasteCategory")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    @GetMapping("/wasteCategories")
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories(){

        try{
            List<WasteCategory> listOfWasteCategories = new ArrayList<>();
            wasteCategoryRepository.findAll().forEach(listOfWasteCategories::add);

            if (listOfWasteCategories.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(listOfWasteCategories, HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("/wasteCategory/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id){

        Optional<WasteCategory> wantedWasteCategory = wasteCategoryRepository.findById(id);

        if (wantedWasteCategory.isPresent()){
            return new ResponseEntity<>((WasteCategory) wantedWasteCategory.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("addWasteCategory")
    public ResponseEntity<WasteCategory> addWasteCategory(@RequestBody WasteCategory newWasteCategory){
        try{
            WasteCategory wasteCategory = wasteCategoryRepository.save(newWasteCategory);
            return new ResponseEntity<>(wasteCategory, HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
