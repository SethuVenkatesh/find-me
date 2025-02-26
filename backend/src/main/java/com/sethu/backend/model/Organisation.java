package com.sethu.backend.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "organisation")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String organisationId;
    @Column(name = "organisation_name",unique = true,length = 50)
    private String organisationName;
    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
