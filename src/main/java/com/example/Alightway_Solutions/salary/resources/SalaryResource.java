package com.example.Alightway_Solutions.salary.resources;

import com.example.Alightway_Solutions.salary.models.SalarySlip;
import com.example.Alightway_Solutions.salary.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sal")
public class SalaryResource {
    @Autowired
    private SalaryService salaryService;
    @GetMapping("/getSalarySlipByEmployeeIdAndMonthAndYear/{employeeId}/{month}/{year}")
    public SalarySlip getSalarySlipByEmployeeIdAndMonthAndYear(@PathVariable String employeeId, @PathVariable String month, @PathVariable String year){
        return salaryService.getSalarySlipByEmployeeIdAndMonthAndYear(employeeId, month, year);

    }
}
