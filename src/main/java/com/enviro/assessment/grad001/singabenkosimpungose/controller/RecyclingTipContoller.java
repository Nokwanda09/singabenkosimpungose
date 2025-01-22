package com.enviro.assessment.grad001.singabenkosimpungose.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import jakarta.validation.Valid;

import com.enviro.assessment.grad001.singabenkosimpungose.model.RecyclingTip;
import com.enviro.assessment.grad001.singabenkosimpungose.repository.RecyclingTipRepository;;

/**
 * REST Controller for recycling tips.
 */
@RestController
@RequestMapping("recyclingTip")
public class RecyclingTipContoller {

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    /**
     * Retrieves all recycling tips.
     * 
     * @return ResponseEntity containing a list of RecyclingTip objects and an HTTP status code.
     */
    @GetMapping("/all")
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips(){
        try{
            List<RecyclingTip> recyclingTipsList = new ArrayList<>();
            recyclingTipRepository.findAll().forEach(recyclingTipsList::add);

            if (recyclingTipsList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(recyclingTipsList, HttpStatus.OK);


        }catch(Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     /**
     * Retrieves a specific recycling tip by its ID.
     * 
     * @param id The ID of the recycling tip to retrieve.
     * @return ResponseEntity containing the RecyclingTip object and an HTTP status code.
     */
    @GetMapping("id/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id){
        try{
        Optional recyclingTipData = recyclingTipRepository.findById(id);

        if (recyclingTipData.isPresent()){
            return new ResponseEntity<>((RecyclingTip) recyclingTipData.get(), HttpStatus.OK);
        } 
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception error){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    /**
     * Retrieves a list of recycling tips by waste category.
     * 
     * @param wasteCategory The waste category to filter by.
     * @return ResponseEntity containing a list of RecyclingTip objects and an HTTP status code.
     */
    @GetMapping("wasteCategory/{wasteCategory}")
    public ResponseEntity<List<RecyclingTip>> getRecyclingTipsByWasteCategory(@PathVariable String wasteCategory){
        try{
        List<RecyclingTip> recyclingTips = new ArrayList<>();
        recyclingTipRepository.findAllByWasteCategory(wasteCategory).forEach(recyclingTips::add);

        if (recyclingTips.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(recyclingTips, HttpStatus.OK);
    } catch (Exception error){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }

     /**
     * Adds a new recycling tip.
     * 
     * @param newRecyclingTip The RecyclingTip object to add.
     * @return ResponseEntity containing the added RecyclingTip object and an HTTP status code.
     */
    @PostMapping("/add")
    public ResponseEntity<RecyclingTip> addRecyclingTip(@Valid @RequestBody RecyclingTip newRecyclingTip){
        try{
            RecyclingTip recyclingTip = recyclingTipRepository.save(newRecyclingTip);
            return new ResponseEntity<>(recyclingTip, HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Updates an existing recycling tip.
     * 
     * @param id The ID of the recycling tip to update.
     * @param newData The new data to update the tip with.
     * @return ResponseEntity containing the updated RecyclingTip object and an HTTP status code.
     */
    @PutMapping("update/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip newData){
        try{
            Optional oldData = recyclingTipRepository.findById(id);

            if (oldData.isPresent()){
                RecyclingTip updatedData = (RecyclingTip) oldData.get();
                updatedData.setWasteCategory(newData.getWasteCategory());
                updatedData.setRecyclingTip(newData.getRecyclingTip());
                
                return new ResponseEntity<>(updatedData, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


      /**
     * Deletes a recycling tip by its ID.
     * 
     * @param id The ID of the recycling tip to delete.
     * @return ResponseEntity containing an HTTP status code.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RecyclingTip> deleteRecyclingTip(@PathVariable Long id){
    
        try{
            recyclingTipRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
