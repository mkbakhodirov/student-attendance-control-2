package com.muzaffar.studentattendancecontrol2.repository;

import com.muzaffar.studentattendancecontrol2.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
}
