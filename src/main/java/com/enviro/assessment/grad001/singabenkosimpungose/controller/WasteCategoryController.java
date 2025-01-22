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

import jakarta.validation.*;


/**
 * REST Controller for managing waste category.
 */
@RestController
@RequestMapping("/wasteCategory")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;


     /**
     * Retrieves all waste categories.
     * 
     * @return ResponseEntity containing a list of WasteCategory objects and an HTTP status code.
     */
    @GetMapping("/all")
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories(){

        try{
            List<WasteCategory> listOfWasteCategories = new ArrayList<>();
            wasteCategoryRepository.findAll().forEach(listOfWasteCategories::add);

            if (listOfWasteCategories.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(listOfWasteCategories, HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


     /**
     * Retrieves a specific waste category by its ID.
     * 
     * @param id The ID of the waste category to retrieve.
     * @return ResponseEntity containing the WasteCategory object and an HTTP status code.
     */
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id){
        try{
        Optional<WasteCategory> wantedWasteCategory = wasteCategoryRepository.findById(id);

        if (wantedWasteCategory.isPresent()){
            return new ResponseEntity<>((WasteCategory) wantedWasteCategory.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception error){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }


     /**
     * Adds a new waste category.
     * 
     * @param newWasteCategory The WasteCategory object to add.
     * @return ResponseEntity containing the added WasteCategory object and an HTTP status code.
     */
    @PostMapping("/add")
    public ResponseEntity<WasteCategory> addWasteCategory(@Valid @RequestBody WasteCategory newWasteCategory){
        try{
            WasteCategory wasteCategory = wasteCategoryRepository.save(newWasteCategory);
            return new ResponseEntity<>(wasteCategory, HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Updates an existing waste category.
     * 
     * @param id The ID of the waste category to update.
     * @param newData The new data to update the category with.
     * @return ResponseEntity containing the updated WasteCategory object and an HTTP status code.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategoryData(@PathVariable Long id, @Valid @RequestBody WasteCategory newData){
        try{
        Optional oldData = wasteCategoryRepository.findById(id);

        if (oldData.isPresent()){
            WasteCategory updatedData = (WasteCategory) oldData.get();
            updatedData.setName(newData.getName());
            updatedData.setDescription(newData.getDescription());

            return new ResponseEntity<>(updatedData, HttpStatus.OK);
        } 

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }


      /**
     * Deletes a waste category by its ID.
     * 
     * @param id The ID of the waste category to delete.
     * @return ResponseEntity containing an HTTP status code.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<WasteCategory> deleteWasteCategory(@PathVariable Long id){
        try{
        wasteCategoryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
