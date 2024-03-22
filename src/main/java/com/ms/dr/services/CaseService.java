package com.ms.dr.services;

import com.ms.dr.exception.ResourceNotFoundException;
import com.ms.dr.model.Cases;
import com.ms.dr.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {
    @Autowired
    private CaseRepository caseRepository;

    public Cases createCase(Cases caseDetails) {
        return caseRepository.save(caseDetails);
    }

    public List<Cases> getAllCases() {
        return caseRepository.findAll();
    }

    public Cases getCaseById(String caseNumber) {
        return caseRepository.findById(caseNumber).orElseThrow(() -> new ResourceNotFoundException("Case not found"));
    }

    public Cases updateCase(String caseNumber, Cases caseDetails) {
        Cases cases = getCaseById(caseNumber);
        cases.setDocuments(caseDetails.getDocuments());
        cases.setEvents(caseDetails.getEvents());
        return caseRepository.save(cases);
    }

    public void deleteCase(String caseNumber) {
        Cases cases = getCaseById(caseNumber);
        caseRepository.delete(cases);
    }
}

