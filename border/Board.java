package com.rod.api.border;

import com.rod.api.article.Article;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "boards")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Board {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="boardName")
    private String boardName;

    @Column(name="boardType")
    private String boardType;

    @OneToMany(mappedBy = "board")
    private List<Article> articles;

    @Builder(builderMethodName = "builder")
    public Board(Long id, String boardName, String boardType) {
        this.id = id;
        this.boardName = boardName;
        this.boardType = boardType;
    }
}
