package by.freebook.service.impl;

import by.freebook.dao.repository.UserRepository;
import by.freebook.service.UserService;
import by.freebook.service.bean.UserBean;
import by.freebook.service.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public UserBean findUserById(Long id) {
        var userOptional = repository.findUserById(id);
        return userOptional.map(Converter::userEntityToUserBean).orElse(null);
    }

    @Override
    public UserBean login(UserBean bean) {
        return null;
    }

    @Override
    public UserBean save(UserBean bean) {
        var user = repository.save(Converter.userBeanToUserEntity(bean));
        return Converter.userEntityToUserBean(user);
    }

    @Override
    public UserBean delete(UserBean bean) {
        return null;
    }
}
