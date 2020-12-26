package by.itacademy.service;

import by.itacademy.model.User;
import by.itacademy.service.bean.GroupBean;

import java.util.List;

public interface UserService {
    List<GroupBean> findRatingByUserId(User user);
}
