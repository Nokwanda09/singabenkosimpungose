package com.enviro.assessment.grad001.singabenkosimpungose.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import jakarta.validation.Valid;

import com.enviro.assessment.grad001.singabenkosimpungose.model.DisposalGuideline;
import com.enviro.assessment.grad001.singabenkosimpungose.repository.DisposalGuidelinesRepository;

@RestController
@RequestMapping("/disposalGuideline")
public class DiposalGuidelineController {

    @Autowired
    private DisposalGuidelinesRepository disposalGuidelinesRepository;

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

    @GetMapping("id/{id}")
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

    @GetMapping("category/{wasteCategory}")
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

    @PostMapping("/add")
    public ResponseEntity<DisposalGuideline> addNewDisposalGuideline(@Valid @RequestBody DisposalGuideline newDisposalGuideline){
        try{
            DisposalGuideline disposalGuideline = disposalGuidelinesRepository.save(newDisposalGuideline);
            return new ResponseEntity<>(disposalGuideline, HttpStatus.OK);

        } catch(Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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
