package miu.edu.lab.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
public class Logger {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    int id;
    private String principle;
    private String operation;
    private Date date;
    private String executionTime;
}
