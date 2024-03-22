package com.rod.api.product;

import com.rod.api.order.Basket;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "games")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Game {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gameName")
    private String gameName;

    @Column(name = "price")
    private String price;

    @OneToMany(mappedBy = "game")
    private List<Basket> baskets;

    @Builder(builderMethodName = "builder")
    public Game(Long id, String gameName, String price) {
        this.id = id;
        this.gameName = gameName;
        this.price = price;
    }
}
