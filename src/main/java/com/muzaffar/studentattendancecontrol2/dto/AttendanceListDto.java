package com.muzaffar.studentattendancecontrol2.dto;

import lombok.Data;

import java.util.List;

@Data
public class AttendanceListDto {
    private List<AttendanceDto> list;
}
