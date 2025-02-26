package com.sethu.backend.model;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "container")
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String containerId;
    @Column(name = "container_name",length = 100)
    private String containerName;
    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    @ManyToOne
    private Organisation organisation;
}
