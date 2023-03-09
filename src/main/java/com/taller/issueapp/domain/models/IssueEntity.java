package com.taller.issueapp.domain.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_issues")
public class IssueEntity {
    @Id
    private Integer id;
    @Column(name = "issue_name")
    private String issueName;
    private String state;
    private Integer count;
    @Column(name = "create_date")
    private LocalDateTime createDate;
    @PrePersist
    public void prePersist() {
        this.createDate = LocalDateTime.now();
        this.state = "Pendiente";
    }
}
