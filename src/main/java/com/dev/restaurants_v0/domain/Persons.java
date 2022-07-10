package com.dev.restaurants_v0.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "persons", schema = "public")
public class Persons implements Serializable {
    private static final long seriaVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "document_type_id", referencedColumnName = "id")
    @ManyToOne
    private DocumentsTypes documentsTypes;

    @Column(name = "documentnumber")
    private String documentNumber;

    private String name;
    private String lastname;
    private String fullname;
    private Date birthday;
    private String email;
    private String sex;
    private String address;
    private String country;
    private String city;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "deleted_at")
    private Date deletedAt;

    private Integer state;
}
