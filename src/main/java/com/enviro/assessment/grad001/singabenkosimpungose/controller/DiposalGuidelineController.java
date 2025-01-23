package com.enviro.assessment.grad001.singabenkosimpungose.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import jakarta.validation.Valid;

import com.enviro.assessment.grad001.singabenkosimpungose.model.DisposalGuideline;
import com.enviro.assessment.grad001.singabenkosimpungose.repository.DisposalGuidelinesRepository;

/**
 * REST Controller for managing disposal guidelines.
 */
@RestController
@RequestMapping("/disposalGuideline")
public class DiposalGuidelineController {

    @Autowired
    private DisposalGuidelinesRepository disposalGuidelinesRepository;

    /**
     * Retrieves all disposal guidelines.
     * 
     * @return ResponseEntity containing a list of DisposalGuideline objects and an HTTP status code.
     */
    @GetMapping("/all")
    public ResponseEntity<List<DisposalGuideline>> getAllDisposalGuidelines(){
        try{
            List<DisposalGuideline> listOfDisposalGuidelines = new ArrayList<>();
            disposalGuidelinesRepository.findAll().forEach(listOfDisposalGuidelines::add);

            if (listOfDisposalGuidelines.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(listOfDisposalGuidelines, HttpStatus.OK);

        } catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


     /**
     * Retrieves a specific disposal guideline by its ID.
     * 
     * @param id The ID of the disposal guideline to retrieve.
     * @return ResponseEntity containing the DisposalGuideline object and an HTTP status code.
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long id){
        try{
            Optional disposalGuideline = disposalGuidelinesRepository.findById(id);

            if (disposalGuideline.isPresent()){
                return new ResponseEntity<>((DisposalGuideline) disposalGuideline.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Retrieves a list of disposal guidelines by waste category.
     * 
     * @param wasteCategory The waste category to filter by.
     * @return ResponseEntity containing a list of DisposalGuideline objects and an HTTP status code.
     */
    @GetMapping("/category/{wasteCategory}")
    public ResponseEntity<List<DisposalGuideline>> getDisposalGuideLine(@PathVariable String wasteCategory){

        try{
            List<DisposalGuideline> listOfDisposalGuidelines = new ArrayList<>();
            disposalGuidelinesRepository.findAllByWasteCategory(wasteCategory).forEach(listOfDisposalGuidelines::add);
            
            if (listOfDisposalGuidelines.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listOfDisposalGuidelines, HttpStatus.OK);

        } catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


     /**
     * Adds a new disposal guideline.
     * 
     * @param newDisposalGuideline The DisposalGuideline object to add.
     * @return ResponseEntity containing the added DisposalGuideline object and an HTTP status code.
     */
    @PostMapping("/add")
    public ResponseEntity<DisposalGuideline> addNewDisposalGuideline(@Valid @RequestBody DisposalGuideline newDisposalGuideline){
        try{
            DisposalGuideline disposalGuideline = disposalGuidelinesRepository.save(newDisposalGuideline);
            return new ResponseEntity<>(disposalGuideline, HttpStatus.OK);

        } catch(Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Updates an existing disposal guideline.
     * 
     * @param id The ID of the disposal guideline to update.
     * @param newData The new data to update the guideline with.
     * @return ResponseEntity containing the updated DisposalGuideline object and an HTTP status code.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<DisposalGuideline> updateDisposalGuideline(@PathVariable Long id,@Valid @RequestBody DisposalGuideline newData){
        try{

            Optional oldData = disposalGuidelinesRepository.findById(id);

            if (oldData.isPresent()){
                DisposalGuideline updatedData = (DisposalGuideline) oldData.get();
                updatedData.setWasteCategory(newData.getWasteCategory());
                updatedData.setDisposalGuideline(newData.getDisposalGuideline());

                return new ResponseEntity<>(updatedData, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch(Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


      /**
     * Deletes a disposal guideline by its ID.
     * 
     * @param id The ID of the disposal guideline to delete.
     * @return ResponseEntity containing an HTTP status code.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DisposalGuideline> deleteDisposalGuideline(@PathVariable Long id){
        try{
            disposalGuidelinesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
