package com.rod.api.user;

import com.rod.api.common.AbstractService;
import com.rod.api.messanger.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl  extends AbstractService<User> {

    private final UserRepository repository;
    @Override
    public Messenger save(User user) {
        return null;
    }

    @Override
    public List<User> findAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() throws SQLException {
        return null;
    }

    @Override
    public Optional<User> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(User user) {
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
