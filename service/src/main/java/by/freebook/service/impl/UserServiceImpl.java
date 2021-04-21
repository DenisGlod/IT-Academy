package by.freebook.service.impl;

import by.freebook.dao.repository.UserRepository;
import by.freebook.service.UserService;
import by.freebook.service.bean.UserBean;
import by.freebook.service.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public List<UserBean> getAllUser() {
        var userList = repository.findAll();
        return Converter.userEntityToUserBean(userList);
    }

    @Override
    public Optional<UserBean> findUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<UserBean> login(UserBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<UserBean> save(UserBean bean) {
        return Optional.empty();
    }

    @Override
    public Optional<UserBean> delete(UserBean bean) {
        return Optional.empty();
    }
}
