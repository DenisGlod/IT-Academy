package by.freebook.view.controller;

import by.freebook.service.UserService;
import by.freebook.service.bean.UserBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/users", produces = "application/json;charset=UTF-8")
@ResponseBody
public class UserController {
    private final UserService service;

    @GetMapping("/getAll")
    public List<UserBean> getAllUsers() {
        return service.getAllUser();
    }

    @GetMapping("/get")
    public UserBean getUserById(@RequestParam(name = "id") Long id) {
        return service.findUserById(id);
    }

}
