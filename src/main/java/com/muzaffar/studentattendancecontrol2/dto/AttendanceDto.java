package com.muzaffar.studentattendancecontrol2.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttendanceDto {
    private Integer id;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private Integer studentId;
}
