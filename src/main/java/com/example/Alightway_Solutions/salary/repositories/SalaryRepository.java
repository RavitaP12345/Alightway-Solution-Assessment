package com.example.Alightway_Solutions.salary.repositories;

import com.example.Alightway_Solutions.salary.entities.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<SalaryEntity, Long> {
    SalaryEntity findByEmployeeIdAndMonthAndYear(String employeeId, String month, String year);
}
