package com.yusufalicezik.OPSapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Park")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Park {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "placeName", length = 100)
    private String placeName;

    @Column(name = "amount")
    private int amount;

    @Column(name = "isPaid", columnDefinition = "boolean default false")
    private boolean isPaid;


}

