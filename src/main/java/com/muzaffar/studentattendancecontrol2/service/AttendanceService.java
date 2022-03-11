package com.muzaffar.studentattendancecontrol2.service;

import com.muzaffar.studentattendancecontrol2.dto.AttendanceDto;
import com.muzaffar.studentattendancecontrol2.entity.Attendance;
import com.muzaffar.studentattendancecontrol2.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final ModelMapper modelMapper;

    public Attendance add(AttendanceDto attendanceDto) {
        Attendance attendance = new Attendance();
        attendance.setStudentId(attendanceDto.getStudentId());
        attendance.setArrivalTime(attendanceDto.getArrivalTime());
        attendance.setDepartureTime(attendanceDto.getDepartureTime());
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> addAll(List<AttendanceDto> list) {
        try {
            List<Attendance> attendances = new ArrayList<>();
            for (AttendanceDto attendanceDto : list) {
                Attendance attendance = modelMapper.map(attendanceDto, Attendance.class);
                attendances.add(attendance);
            }
            return attendanceRepository.saveAll(attendances);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
