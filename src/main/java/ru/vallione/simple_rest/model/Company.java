package ru.vallione.simple_rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "t_companies")
public class Company {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ceo_id", unique = true, nullable = false)
    private int ceoId;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="creation_date")
    private Date creationDate;

}
