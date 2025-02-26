package com.sethu.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "design")
public class Design {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String designId;
    @Column(name = "name",length = 100)
    private String name;
    @Column(name = "image_id",length = 100)
    private String imageId;
    @ManyToOne
    private Subcontainer subcontainer;

}
