package com.dev.restaurants.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "personals", schema = "public")
public class Personals implements Serializable {
    private static final Long seriaVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "restaurants_id", referencedColumnName = "id")
    @ManyToOne
    private Restaurants restaurants;

    @JoinColumn(name = "persons_id", referencedColumnName = "id")
    @ManyToOne
    private Persons persons;

    @JoinColumn(name = "personals_type_id", referencedColumnName = "id")
    @ManyToOne
    private PersonalsTypes personalsTypes;

    @Column(name = "salary_date")
    private Date salaryDate;

    @Column(name = "contract_at")
    private Date contractAt;

    @Column(name = "renovation_contract_at")
    private Date renovationContractAt;

    @Column(name = "final_contract_at")
    private Date finalContractAt;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted_at")
    private Date deletedAt;

    private Integer state;


}
