package com.example.Alightway_Solutions.salary.services;

import com.example.Alightway_Solutions.event.repositories.EventRepository;
import com.example.Alightway_Solutions.leave.repositories.LeaveRepository;
import com.example.Alightway_Solutions.leave.services.LeaveService;
import com.example.Alightway_Solutions.salary.entities.SalaryEntity;
import com.example.Alightway_Solutions.salary.models.SalarySlip;
import com.example.Alightway_Solutions.salary.repositories.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private LeaveService leaveService;

    public SalarySlip getSalarySlipByEmployeeIdAndMonthAndYear(String employeeId, String month, String year) {
        SalarySlip salarySlip = new SalarySlip();
        SalaryEntity salaryEntity = salaryRepository.findByEmployeeIdAndMonthAndYear(employeeId, month, year);
        Integer leaveCountWithEventAdjustment = leaveService.getTotalLeaveCountInCurrentMonth();
        Double count = Double.valueOf(leaveCountWithEventAdjustment);
        Double totalSalary = salaryEntity.getSalary()-count;
        salarySlip.setFinalSalary(totalSalary);
        salarySlip.setEmployeeId(salaryEntity.getEmployeeId());
        salarySlip.setWorkingDays(Double.valueOf(salaryEntity.getWorkingDays()));
        return new SalarySlip();


    }
}
