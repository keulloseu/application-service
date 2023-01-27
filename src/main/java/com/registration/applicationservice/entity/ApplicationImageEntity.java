package com.registration.applicationservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "application_image")
public class ApplicationImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private String imagePath;
    private String imageFileName;
    @OneToOne(mappedBy = "applicationImage")
    private ApplicationEntity application;
}
