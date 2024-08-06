package com.example.Alightway_Solutions.leave.resources;

import com.example.Alightway_Solutions.leave.models.LeaveModel;
import com.example.Alightway_Solutions.leave.services.LeaveService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/lev")
public class LeaveResource {
    @Autowired
    private LeaveService leaveService;

    @PostMapping("/saveLeaveDetails")
    public ResponseEntity<?> saveLeaveDetails(@RequestBody @Valid LeaveModel model, BindingResult result){
        HashMap<String, String> map = new HashMap<>();
        if(result.hasErrors()){
            for(FieldError error : result.getFieldErrors()){
                map.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(map, HttpStatus.FORBIDDEN);
        }else {
            return leaveService.saveLeaveDetails(model);
        }
    }

    @GetMapping("/getAllLeaveDetails")
    public List<LeaveModel> getAllLeaveDetails(){
        return leaveService.getAllLeaveDetails();
    }
    @GetMapping("/getAllLeaveDetailsByEmployeeId/{employeeId}")
    public List<LeaveModel> getAllLeaveDetailsByEmployeeId(@PathVariable String employeeId){
        return leaveService.getAllLeaveDetailsByEmployeeId(employeeId);
    }

    //to get the  list of leave details by leave id
    @GetMapping("/getLeaveDetailsByLeaveId/{leaveId}")
    public LeaveModel getLeaveDetailsByLeaveId(@PathVariable Long leaveId){
        return leaveService.getLeaveDetailsByLeaveId(leaveId);
    }
    //To cancel the applied leave request.
    @PostMapping("/changeLeaveStatusByEmployeeIdAndLeaveId/{employeeId}/{leaveId}")
    public ResponseEntity<?> changeLeaveStatusByEmployeeIdAndLeaveId(@PathVariable String employeeId, @PathVariable Long leaveId){
        return leaveService.changeLeaveStatusByEmployeeIdAndLeaveId(employeeId, leaveId);
    }

    //To Change the leave status of leave request by approval
    @PostMapping("/changeLeaveStatusByApprovalIdAndLeaveIdAndStatus/{approvalId}/{leaveId}/{status}")
    public ResponseEntity<?> changeLeaveStatusByApprovalIdAndLeaveIdAndStatus(@PathVariable String approvalId, @PathVariable Long leaveId, @PathVariable String status){
        return leaveService.changeLeaveStatusByApprovalIdAndLeaveIdAndStatus(approvalId, leaveId, status);
    }





}
