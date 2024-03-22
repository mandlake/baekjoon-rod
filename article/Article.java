package com.rod.api.article;

import com.rod.api.border.Board;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "articles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Article {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "writer")
    private String writer;

    @Column(name = "date")
    private String registerDate;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder(builderMethodName = "builder")
    public Article(Long id, String title, String content, String writer, String registerDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.registerDate = registerDate;
    }
}
