package com.example.demo;

import javax.persistence.*;

import lombok.*;
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(query = "select s from UserEntity s where s.lastName= :lastName", name = UserEntity.Find_By_lastName)
})

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserEntity {

    public static final String Find_By_lastName = "UserEntity.Find_By_lastName";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}

