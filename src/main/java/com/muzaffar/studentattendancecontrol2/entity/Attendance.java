package com.muzaffar.studentattendancecontrol2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Attendance {
    @Id
    private String id;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private String studentId;

    {
        id = UUID.randomUUID().toString();
    }
}
