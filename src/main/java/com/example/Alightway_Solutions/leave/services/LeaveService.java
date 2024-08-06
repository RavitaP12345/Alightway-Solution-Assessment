package com.example.Alightway_Solutions.leave.services;

import com.example.Alightway_Solutions.event.entities.EventEntity;
import com.example.Alightway_Solutions.leave.entities.LeaveEntity;
import com.example.Alightway_Solutions.leave.models.LeaveModel;
import com.example.Alightway_Solutions.leave.repositories.LeaveRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository repository;
    @Autowired
    private EntityManager em;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ResponseEntity<?> saveLeaveDetails(LeaveModel model) {
        try{
            LeaveEntity leave = new LeaveEntity();
            leave.setLeaveStatus("Submitted");
            leave.setLeaveSubmissionDate(new Date());
            leave.setLeaveType(model.getLeaveType());
            leave.setApprovalStatus("Pending");
            leave.setEmployeeId(model.getEmployeeId());
            leave.setApprovalId(model.getApprovalId());
            leave.setFormDate(sdf.parse(model.getFormDate()));
            leave.setToDate(sdf.parse(model.getToDate()));
            leave.setCreatedBy(model.getCreatedBy());
            leave.setLastUpdatedBy(model.getLastUpdatedBy());
            leave.setStatus("Active");
            leave.setLastUpdatedDate(new Date());
            leave.setApprovalDate(new Date());
            repository.save(leave);
            return new ResponseEntity<>("Saved", HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>("Failed", HttpStatus.FORBIDDEN);
        }
    }

    public List<LeaveModel> getAllLeaveDetails() {
        List<LeaveEntity> leaveEntities = repository.findAll();
        List<LeaveModel> leaveModels = new ArrayList<>();
        leaveEntities.forEach(data->{
            LeaveModel model = new LeaveModel();
            model.setLeaveId(data.getLeaveId());
            model.setApprovalDate(sdf.format(data.getApprovalDate()));
            model.setLeaveStatus(data.getLeaveStatus());
            model.setLeaveType(data.getLeaveType());
            model.setApprovalStatus(data.getApprovalStatus());
            model.setCreatedBy(data.getCreatedBy());
            model.setLeaveSubmissionDate(sdf.format(data.getLeaveSubmissionDate()));
            model.setStatus(data.getStatus());
            model.setFormDate(sdf.format(data.getFormDate()));
            model.setToDate(sdf.format(data.getToDate()));
            model.setLastUpdatedBy(data.getLastUpdatedBy());
            model.setEmployeeId(data.getEmployeeId());
            model.setApprovalId(data.getApprovalId());
            leaveModels.add(model);
        });
        return leaveModels;
    }

    public List<LeaveModel> getAllLeaveDetailsByEmployeeId(String employeeId) {
        List<LeaveEntity> leaveEntities = repository.findByEmployeeId(employeeId);
        List<LeaveModel> leaveModels = new ArrayList<>();
        leaveEntities.forEach(data->{
            LeaveModel model = new LeaveModel();
            model.setLeaveId(data.getLeaveId());
            model.setApprovalDate(sdf.format(data.getApprovalDate()));
            model.setLeaveStatus(data.getLeaveStatus());
            model.setLeaveType(data.getLeaveType());
            model.setApprovalStatus(data.getApprovalStatus());
            model.setCreatedBy(data.getCreatedBy());
            model.setLeaveSubmissionDate(sdf.format(data.getLeaveSubmissionDate()));
            model.setStatus(data.getStatus());
            model.setFormDate(sdf.format(data.getFormDate()));
            model.setToDate(sdf.format(data.getToDate()));
            model.setLastUpdatedBy(data.getLastUpdatedBy());
            model.setEmployeeId(data.getEmployeeId());
            model.setApprovalId(data.getApprovalId());
            leaveModels.add(model);
        });
        return leaveModels;
    }

    public LeaveModel getLeaveDetailsByLeaveId(Long leaveId) {
        LeaveModel model = new LeaveModel();
        try{
            LeaveEntity entity = repository.findByLeaveId(leaveId);

            model.setLeaveId(entity.getLeaveId());
            model.setApprovalDate(sdf.format(entity.getApprovalDate()));
            model.setLeaveStatus(entity.getLeaveStatus());
            model.setLeaveType(entity.getLeaveType());
            model.setApprovalStatus(entity.getApprovalStatus());
            model.setCreatedBy(entity.getCreatedBy());
            model.setLeaveSubmissionDate(sdf.format(entity.getLeaveSubmissionDate()));
            model.setStatus(entity.getStatus());
            model.setFormDate(sdf.format(entity.getFormDate()));
            model.setToDate(sdf.format(entity.getToDate()));
            model.setLastUpdatedBy(entity.getLastUpdatedBy());
            model.setEmployeeId(entity.getEmployeeId());
            model.setApprovalId(entity.getApprovalId());
            return model;
        }catch (Exception e){
            return model;
        }

    }


    public ResponseEntity<?> changeLeaveStatusByEmployeeIdAndLeaveId(String employeeId, Long leaveId) {
        LeaveEntity entity = repository.findByLeaveId(leaveId);
        entity.setLastUpdatedBy(employeeId);
        entity.setLastUpdatedDate(new Date());
        entity.setLeaveStatus("Canceled");
        repository.save(entity);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<?> changeLeaveStatusByApprovalIdAndLeaveIdAndStatus(String approvalId, Long leaveId, String status) {
        LeaveEntity entity = repository.findByLeaveId(leaveId);
        entity.setLastUpdatedBy(approvalId);
        entity.setLastUpdatedDate(new Date());
        entity.setApprovalDate(new Date());
        entity.setApprovalStatus(status);
        repository.save(entity);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public Integer getTotalLeaveCountInCurrentMonth(){
        Date currentDate = new Date();
        System.out.println("currentDate====>" + currentDate);

        // Get the start and end dates of the current month
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startOfMonth = calendar.getTime();
        System.out.println("startOfMonth===>"+startOfMonth);

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date endOfMonth = calendar.getTime();
        System.out.println("endOfMonth===>"+endOfMonth);
        List<LeaveEntity> leaveEntities = em.createNativeQuery("select * from leave_details where from_date >=:startDate and from_date <=:endDate ", LeaveEntity.class)
                .setParameter("startDate", startOfMonth)
                .setParameter("endDate", endOfMonth).getResultList();
        System.out.println("leaveEntities.size===>"+leaveEntities.size());
        int noOfLeaveDays = 0;
        final int[] totalEventInMonth = {0};
        for (LeaveEntity data : leaveEntities) {
            LocalDate startDate = convertToLocalDate(data.getFormDate());
            LocalDate endDate = convertToLocalDate(data.getToDate());
            List<LocalDate> dateList = getDatesBetween(startDate, endDate);

            dateList.forEach(date->{
                List<EventEntity> eventEntities = em.createNativeQuery("select * from event_details where event_date =:eventDate ", EventEntity.class)
                        .setParameter("eventDate", date).getResultList();
                totalEventInMonth[0] = totalEventInMonth[0] +eventEntities.size();

            });
            System.out.println("totalEventInMonth====>"+ totalEventInMonth[0]);

            // Ensure both dates are non-null
            if (data.getFormDate() != null && data.getToDate() != null) {
                long numberOfDays = ChronoUnit.DAYS.between(data.getFormDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        data.getToDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()) + 1;
                noOfLeaveDays += (int) numberOfDays;
            }
        }
        return noOfLeaveDays- totalEventInMonth[0];
    }
    public static List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> dates = new ArrayList<>();
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            dates.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }

        return dates;
    }
    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
