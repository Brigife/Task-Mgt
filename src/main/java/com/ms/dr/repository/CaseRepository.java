package com.ms.dr.repository;

import com.ms.dr.model.Cases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Cases, String> {}
