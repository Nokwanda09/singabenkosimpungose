package com.enviro.assessment.grad001.singabenkosimpungose.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import jakarta.validation.Valid;

import com.enviro.assessment.grad001.singabenkosimpungose.model.SustainabilityQuote;
import com.enviro.assessment.grad001.singabenkosimpungose.repository.QuotesRepository;


/**
 * REST Controller for managing sustainability qoutes.
 */
@RestController
@RequestMapping("/quotes")
public class QoutesController {

    @Autowired
    private QuotesRepository quotesRepository;


     /**
     * Retrieves all sustainability qoutes.
     * 
     * @return ResponseEntity containing a list of SustainabilityQoute objects and an HTTP status code.
     */
    @GetMapping("all")
    public ResponseEntity<List<SustainabilityQuote>> getAllQoutes(){
        try{
            List<SustainabilityQuote> quotes = new ArrayList<>();
            quotesRepository.findAll().forEach(quotes::add);

            if (quotes.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(quotes, HttpStatus.OK);

        } catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


     /**
     * Retrieves a specific sustainability qoute by its ID.
     * 
     * @param id The ID of the sustainability qoute to retrieve.
     * @return ResponseEntity containing the SustainabilityQoute object and an HTTP status code.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SustainabilityQuote> findQouteById(@PathVariable Long id){
        try{
            Optional qoute = quotesRepository.findById(id);

            if (qoute.isPresent()){
                return new ResponseEntity<>((SustainabilityQuote) qoute.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch(Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


     /**
     * Adds a new sustainability qoute.
     * 
     * @param newQoute The SustainabilityQoute object to add.
     * @return ResponseEntity containing the added SustainabilityQoute object and an HTTP status code.
     */
    @PostMapping("/add")
    public ResponseEntity<SustainabilityQuote> addNewQoute(@Valid @RequestBody SustainabilityQuote newQoute){
        try{
            SustainabilityQuote qoute = quotesRepository.save(newQoute);
            return new ResponseEntity<>(qoute, HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Updates an existing sustainability qoute.
     * 
     * @param id The ID of the sustainability qoute to update.
     * @param newData The new data to update the qoute with.
     * @return ResponseEntity containing the updated SustainabilityQoute object and an HTTP status code.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<SustainabilityQuote> updateQoute(@PathVariable Long id, @Valid @RequestBody SustainabilityQuote newData){

        try{
            Optional oldData = quotesRepository.findById(id);

            if (oldData.isPresent()){
                SustainabilityQuote updatedData = (SustainabilityQuote) oldData.get();
                updatedData.setAuthor(newData.getAuthor());
                updatedData.setQuote(newData.getQuote());
                return new ResponseEntity<>(updatedData, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


      /**
     * Deletes a sustainability qoute by its ID.
     * 
     * @param id The ID of the sustaiinability qoute to delete.
     * @return ResponseEntity containing an HTTP status code.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SustainabilityQuote> deleteQoute(@PathVariable Long id){
        try{
            quotesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
