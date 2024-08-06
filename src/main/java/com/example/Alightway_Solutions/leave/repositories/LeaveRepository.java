package com.example.Alightway_Solutions.leave.repositories;

import com.example.Alightway_Solutions.leave.entities.LeaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveEntity, Long> {
    List<LeaveEntity> findByEmployeeId(String employeeId);

    LeaveEntity findByLeaveId(Long leaveId);
}
