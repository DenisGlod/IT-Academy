package by.freebook.service;

import by.freebook.service.bean.UserBean;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserBean> getAllUser();

    UserBean findUserById(Long id);

    UserBean login(UserBean bean);

    UserBean save(UserBean bean);

    UserBean delete(UserBean bean);
}
