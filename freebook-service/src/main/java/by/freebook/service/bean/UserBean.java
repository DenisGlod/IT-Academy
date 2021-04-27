package by.freebook.service.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserBean {
    private Long id;
    private String email;
    private String password;
    private RoleBean role;
    private UserDataBean userData;

}
