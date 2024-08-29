package com.greencode.cooperative_service.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name= "cooperative")
public class Cooperative {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36, updatable = false, nullable = false)
    private UUID id;

    @NotNull
    private String name;

    private String address;
    private String phone;

    @Email
    private String email;

    private String image;

    @Temporal(TemporalType.DATE)
    private Date dateFundation;

    private Byte state;

    @OneToMany(mappedBy = "cooperative")
    private List<Bus> buses;

    @ManyToMany
    @JoinTable(
        name = "cooperative_destinity",
        joinColumns = @JoinColumn(name = "cooperative_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "destinity_id", referencedColumnName = "id")
    )
    private List<Destinity> destinations;
}
