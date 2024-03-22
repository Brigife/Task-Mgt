package com.ms.dr.controller;

import com.ms.dr.model.Cases;
import com.ms.dr.services.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
public class CaseController {

    @Autowired
    private CaseService caseService;

    @PostMapping
    public Cases createCase(@RequestBody Cases caseDetails) {
        return caseService.createCase(caseDetails);
    }

    @GetMapping
    public List<Cases> getAllCases() {
        return caseService.getAllCases();
    }

    @GetMapping("/{caseNumber}")
    public Cases getCaseById(@PathVariable String caseNumber) {
        return caseService.getCaseById(caseNumber);
    }

    @PutMapping("/{caseNumber}")
    public Cases updateCase(@PathVariable String caseNumber, @RequestBody Cases caseDetails) {
        return caseService.updateCase(caseNumber, caseDetails);
    }

    @DeleteMapping("/{caseNumber}")
    public ResponseEntity<?> deleteCase(@PathVariable String caseNumber) {
        caseService.deleteCase(caseNumber);
        return ResponseEntity.ok().build();
    }
}
