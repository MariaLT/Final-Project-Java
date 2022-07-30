package com.ironhack.edgeservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "role_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;



    @ManyToOne
    private User user;
}
