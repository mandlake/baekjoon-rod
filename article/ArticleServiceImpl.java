package com.rod.api.article;


import com.rod.api.common.AbstractService;
import com.rod.api.messanger.Messenger;

import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl extends AbstractService<Article> {

    private final ArticleRepository repository;

    @Override
    public Messenger save(Article t) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Article> findAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Optional<Article> findById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public String count() {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public Optional<Article> getOne(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @Override
    public String delete(Article t) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }


}