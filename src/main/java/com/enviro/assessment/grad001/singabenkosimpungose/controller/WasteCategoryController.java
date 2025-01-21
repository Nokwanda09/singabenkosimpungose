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

    @PostMapping("/addWasteCategory")
    public ResponseEntity<WasteCategory> addWasteCategory(@RequestBody WasteCategory newWasteCategory){
        try{
            WasteCategory wasteCategory = wasteCategoryRepository.save(newWasteCategory);
            return new ResponseEntity<>(wasteCategory, HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateWasteCategory/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategoryData(@PathVariable Long id, @RequestBody WasteCategory newData){
        Optional oldData = wasteCategoryRepository.findById(id);

        if (oldData.isPresent()){
            WasteCategory updatedData = (WasteCategory) oldData.get();
            updatedData.setName(newData.getName());
            updatedData.setDescription(newData.getDescription());

            return new ResponseEntity<>(updatedData, HttpStatus.OK);
        } 

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteWasteCategory/{id}")
    public ResponseEntity<WasteCategory> deleteWasteCategory(@PathVariable Long id){
        wasteCategoryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
