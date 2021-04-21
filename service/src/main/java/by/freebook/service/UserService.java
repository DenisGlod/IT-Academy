package by.freebook.service;

import by.freebook.service.bean.UserBean;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserBean> getAllUser();

    Optional<UserBean> findUserById(Long id);

    Optional<UserBean> login(UserBean bean);

    Optional<UserBean> save(UserBean bean);

    Optional<UserBean> delete(UserBean bean);
}
