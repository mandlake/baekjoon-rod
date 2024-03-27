package com.rod.api.article;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class ArticleRepository {
    private final Connection conn;

    public ArticleRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/roddb",
                "roddb",
                "roddb");
    }

    public List<Article> findAll() throws SQLException {
        List<Article> ls = new ArrayList<>();
        String sql = "select * from articles";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            do {
                ls.add(Article.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .writer(rs.getString("writer"))
                        .build());
            } while (rs.next());
        } else {
            System.out.println("No Data");
        }
        rs.close();
        ps.close();
        conn.close();
        return ls;
    }
}
