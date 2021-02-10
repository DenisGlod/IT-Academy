package by.freebook.service;

import java.util.List;
import java.util.Optional;

import by.freebook.service.bean.UserBean;

public interface UserService {
    List<UserBean> getAllUser();

    Optional<UserBean> findById(Integer id);

    Optional<UserBean> login(UserBean bean);

    Optional<UserBean> save(UserBean bean);

    Optional<UserBean> delete(UserBean bean);
}
