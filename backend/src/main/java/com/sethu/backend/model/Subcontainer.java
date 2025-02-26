package com.sethu.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sub_container")
public class Subcontainer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String subContainerId;
    @Column(name = "sub_container_name",length = 100)
    private String subContainerName;
    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    @ManyToOne
    Container container;

}
