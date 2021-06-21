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
        var userOptional = repository.findUserById(id);
        return userOptional.map(Converter::userEntityToUserBean);
    }

    @Override
    public Optional<UserBean> login(String email, String password) {
        var userOptional = repository.findUserByEmailAndPassword(email, password);
        return userOptional.map(Converter::userEntityToUserBean);
    }

    @Override
    public UserBean save(UserBean bean) {
        var user = repository.save(Converter.userBeanToUserEntity(bean));
        return Converter.userEntityToUserBean(user);
    }

    @Override
    public Optional<UserBean> delete(UserBean bean) {
        return Optional.empty();
    }
}
