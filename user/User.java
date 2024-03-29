package com.rod.api.user;

import com.rod.api.order.Basket;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString(exclude = {"id"})
public class User {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "job")
    private String job;

    @Column(name = "height")
    private double height;

    @Column(name = "weight")
    private double weight;

    @OneToMany(mappedBy = "user")
    private List<Basket> baskets;

    @Builder(builderMethodName = "builder")
    public User(Long id, String username, String password,
                String name, String phoneNumber,
                String address, String job,
                double height, double weight, List<Basket> baskets) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.job = job;
        this.height = height;
        this.weight = weight;
        this.baskets = baskets;
    }
}
