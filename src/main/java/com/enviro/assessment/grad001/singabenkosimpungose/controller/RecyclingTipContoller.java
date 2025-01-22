package com.enviro.assessment.grad001.singabenkosimpungose.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.enviro.assessment.grad001.singabenkosimpungose.model.RecyclingTip;
import com.enviro.assessment.grad001.singabenkosimpungose.repository.RecyclingTipRepository;;


@RestController
@RequestMapping("recyclingTip")
public class RecyclingTipContoller {

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    @GetMapping("/all")
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips(){
        try{
            List<RecyclingTip> recyclingTipsList = new ArrayList<>();
            recyclingTipRepository.findAll().forEach(recyclingTipsList::add);

            if (recyclingTipsList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);


        }catch(Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
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

    @GetMapping("/{wasteCategory}")
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

    @PostMapping("/add")
    public ResponseEntity<RecyclingTip> addRecyclingTip(@RequestBody RecyclingTip newRecyclingTip){
        try{
            RecyclingTip recyclingTip = recyclingTipRepository.save(newRecyclingTip);
            return new ResponseEntity<>(recyclingTip, HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id, @RequestBody RecyclingTip newData){
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

    @DeleteMapping("/delele/{id}")
    public ResponseEntity<RecyclingTip> deleteRecyclingTip(@PathVariable Long id){
    
        try{
            recyclingTipRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
