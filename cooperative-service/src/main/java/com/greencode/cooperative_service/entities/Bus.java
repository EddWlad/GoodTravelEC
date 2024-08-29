package com.greencode.cooperative_service.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36, updatable = false, nullable = false)
    private UUID id;

    private String numberUnit;

    private Integer numberSeating;

    private Byte state;

    @ManyToOne
    @JoinColumn(name = "cooperative_id", referencedColumnName = "id")
    private Cooperative cooperative;

    @OneToOne
    @JoinColumn(name = "personal_id", referencedColumnName = "id")
    private Personal personal;

    @OneToMany(mappedBy = "bus")
    private List<Programming> programming;
}