package com.rod.api.order;

import com.rod.api.product.Game;
import com.rod.api.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "baskets")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Basket {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private String price;

    @Column(name = "buyer")
    private String buyer;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder(builderMethodName = "builder")
    public Basket(Long id, String price, String buyer) {
        this.id = id;
        this.price = price;
        this.buyer = buyer;
    }
}
