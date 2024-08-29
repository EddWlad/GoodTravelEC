package com.greencode.cooperative_service.entities;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "destinity")
public class Destinity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36, updatable = false, nullable = false)
    private UUID id;

    private Time departureTime;
    private Time arrivalTime;

    private Byte state;

    @ManyToOne
    @JoinColumn(name = "city_destinity_id", referencedColumnName = "id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "route_destinity_id", referencedColumnName = "id")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "price_id", referencedColumnName = "id")
    private Price price;

    @ManyToMany(mappedBy = "destinations")
    private List<Cooperative> cooperatives;

    @OneToMany(mappedBy = "destinity")
    private List<Programming> programming;
}