package com.rod.api.article;

import com.rod.api.common.AbstractService;
import com.rod.api.messanger.Messenger;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl extends AbstractService<Article> {
    private final ArticleRepository repository;

    @Override
    public Messenger save(Article o) {
        return null;
    }

    @Override
    public List<Article> findAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Article> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Article o) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}