package com.example.dailyTracking.controller;

import com.example.dailyTracking.dto.ExpenceDto;
import com.example.dailyTracking.mapper.ExpenceMapper;
import com.example.dailyTracking.model.Expence;
import com.example.dailyTracking.service.ExpenceService;
import com.example.dailyTracking.util.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/expence")
public class ExpenseController {

    private final ExpenceService expenseService;

     ExpenseController(ExpenceService expenseService) {
        this.expenseService = expenseService;
    }

    private ExpenceMapper expenceMapper;

    /**
     * used to create new Expence
     * @param expenceDto
     * @return
     */
     @PostMapping({"/create"})
     public ResponseEntity<?>save(@RequestBody ExpenceDto expenceDto) {
         Expence expence = expenceMapper.toExpence((expenceDto));
         expenseService.create(expence);
         return ResponseEntity.ok(expence);
     }

    /**
     * used to update existing Expence
     * @param expenceDto
     * @return
     */
    @PutMapping ({"/update"})
    public ResponseEntity<?>update(@RequestBody ExpenceDto expenceDto) {
        Expence expence = expenceMapper.toExpence((expenceDto));
        expenseService.update(expence);
        return ResponseEntity.ok(expence);
    }

    /**
     * used to delete Expence
     * @param id
     * @return
     */
    @DeleteMapping({"/delete/{id}"})
    public ResponseEntity<?>delete(@PathVariable("id") Integer id) {
         expenseService.delete(id);
         return ResponseEntity.ok(id);
    }

    /**
     * used to get all Expence
     * @return
     */
    @GetMapping  ({"/findAll"})
    public ResponseEntity<?> findAll() {
        ResponseMessage expenceList = expenseService.findAll();
        return ResponseEntity.ok(expenceList);
    }

}
