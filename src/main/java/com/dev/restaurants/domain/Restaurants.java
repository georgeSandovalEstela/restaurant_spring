package com.dev.restaurants.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "restaurants", schema = "public")
public class Restaurants implements Serializable {
    private static final long seriaVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String ruc;
    private String name;
    private String description;
    private String address;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "deleted_at")
    private Date deletedAt;
    private Integer state;
}
