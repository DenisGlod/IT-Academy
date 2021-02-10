package by.freebook.service.util;

import by.freebook.dao.model.Book;
import by.freebook.dao.model.Role;
import by.freebook.dao.model.User;
import by.freebook.dao.model.UserData;
import by.freebook.service.bean.BookBean;
import by.freebook.service.bean.RoleBean;
import by.freebook.service.bean.UserBean;
import by.freebook.service.bean.UserDataBean;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class Converter {

    public static User userBeanToUserEntity(UserBean bean) {
        log.info("UserBean -> {}", bean.toString());
        User user = new User()
                .withEmail(bean.getEmail())
                .withPassword(bean.getPassword());
        if (bean.getRole() != null) {
            user.setRole(roleBeanToRoleEntity(bean.getRole()));
        }
        if (bean.getUserData() != null) {
            user.setUserData(userDataBeanToUserDataEntity(bean.getUserData()));
        }
        user = user.withId(bean.getId());
        log.info("UserEntity -> {}", user.toString());
        return user;
    }

    public static Role roleBeanToRoleEntity(RoleBean bean) {
        Role role = new Role()
                .withRole(bean.getRole())
                .withId(bean.getId());
        return role;
    }

    public static UserData userDataBeanToUserDataEntity(UserDataBean bean) {
        UserData userData = new UserData()
                .withFirstName(bean.getFirstName())
                .withLastName(bean.getLastName())
                .withMiddleName(bean.getMiddleName());
        if (Objects.nonNull(bean.getAge())) {
            userData = userData.withAge(new Date(bean.getAge().getTime()));
        }
        userData = userData.withId(bean.getId());
        return userData;
    }

    public static UserBean userEntityToUserBean(User entity) {
        log.info("UserEntity -> {}", entity.toString());
        UserBean user = new UserBean()
                .withEmail(entity.getEmail())
                .withPassword(entity.getPassword())
                .withRole(
                        new RoleBean()
                                .withId(entity.getRole().getId()))
                .withUserData(
                        new UserDataBean()
                                .withId(entity.getUserData().getId()))
                .withId(entity.getId());
        log.info("UserBean -> {}", user.toString());
        return user;
    }

    public static RoleBean roleEntityToRoleBean(Role entity) {
        RoleBean role = new RoleBean()
                .withRole(entity.getRole())
                .withId(entity.getId());
        return role;
    }

    public static UserDataBean userDataEntityToUserDataBean(UserData entity) {
        UserDataBean userData = new UserDataBean()
                .withFirstName(entity.getFirstName())
                .withLastName(entity.getLastName())
                .withMiddleName(entity.getMiddleName());
        if (Objects.nonNull(entity.getAge())) {
            userData = userData.withAge(new java.util.Date(entity.getAge().getTime()));
        }
        userData = userData.withId(entity.getId());
        return userData;
    }

    public static List<BookBean> bookEntityListToBookBeanList(List<Book> listBookEntity) {
        var resultList = new ArrayList<BookBean>();
        listBookEntity.forEach(bookEntity -> {
            resultList.add(bookEntityToBookBean(bookEntity));
        });
        return resultList;
    }

    public static BookBean bookEntityToBookBean(Book bookEntity) {
        BookBean bookBean = new BookBean()
                .withName(bookEntity.getName())
                .withAuthor(bookEntity.getAuthor())
                .withPublisher(bookEntity.getPublisher())
                .withBinding(bookEntity.getBinding())
                .withAgeRestrictions(bookEntity.getAgeRestrictions())
                .withIsbn(bookEntity.getIsbn())
                .withDescription(bookEntity.getDescription())
                .withPublishingYear(bookEntity.getPublishingYear())
                .withId(bookEntity.getId());
        return bookBean;
    }

    public static Book bookBeanToBookEntity(BookBean bookBean) {
        Book bookEntity = new Book()
                .withName(bookBean.getName())
                .withAuthor(bookBean.getAuthor())
                .withPublisher(bookBean.getPublisher())
                .withBinding(bookBean.getBinding())
                .withAgeRestrictions(bookBean.getAgeRestrictions())
                .withIsbn(bookBean.getIsbn())
                .withDescription(bookBean.getDescription())
                .withPublishingYear(bookBean.getPublishingYear())
                .withId(bookBean.getId());
        return bookEntity;
    }

}
