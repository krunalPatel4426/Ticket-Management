package com.example.TicketManagement.model;

import com.example.TicketManagement.Enum.Priority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@ToString
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @CreationTimestamp
    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_deleted")
    private Integer isDeleted = 0;

    @Column(name = "l1_approved")
    private Integer l1Approved = 0;

    @Column(name = "l2_approved")
    private Integer l2Approved = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority;

    @Column(name = "reporting_manager")
    private String reportingManager;

    @Column(name = "reporting_manager_id")
    private Long reportingManagerId;

    @Column(name = "status")
    private String status;

    @Column(name = "sub_type")
    private String subType;

    @Column(name = "sub_type_id")
    private Long subTypeId;

    @Column(name = "ticket_preffix")
    private String ticketPrefix;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "user_front_id")
    private Long userFrontId;

    @Column(name = "signed_src", columnDefinition = "TEXT")
    private String signedSrc;

    @Column(name = "src")
    private String src;

    @Column(name = "getit_approved")
    private Integer getItApproved = 0;

    @Column(name = "managedby_id")
    private Integer managedById = 0;

    @Column(name = "submitted_on")
    private LocalDateTime submittedOn;

    @Column(name = "assigned_to")
    private Integer assignedTo;

    @Column(name = "dead_line")
    private String deadLine;

    @Column(name = "planned")
    private String planned;

    @Column(name = "re_open")
    private Integer reOpen = 0;
}
