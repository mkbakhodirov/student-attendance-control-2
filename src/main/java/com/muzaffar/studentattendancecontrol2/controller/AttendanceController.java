package com.muzaffar.studentattendancecontrol2.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.muzaffar.studentattendancecontrol2.dto.AttendanceDto;
import com.muzaffar.studentattendancecontrol2.entity.Attendance;
import com.muzaffar.studentattendancecontrol2.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/attendances")
@RequiredArgsConstructor
public class AttendanceController {
    private final RestTemplate restTemplate;
    private final AttendanceService attendanceService;

    @PostMapping("list")
    public ResponseEntity<?> addAll(@RequestBody List<AttendanceDto> attendances) {
        try {
            List<Attendance> saved  = attendanceService.addAll(attendances);
            if (saved != null)
                return ResponseEntity.status(201).build();
            return ResponseEntity.status(HttpStatus.CONFLICT).body("ID is not unique");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody AttendanceDto attendanceDto) {
        Integer attendanceId = attendanceService.add(attendanceDto).getId();
        URI uri =
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(attendanceId).toUri();
        return ResponseEntity.created(uri).build();
    }
}
