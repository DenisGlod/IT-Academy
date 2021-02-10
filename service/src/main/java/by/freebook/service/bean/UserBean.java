package by.freebook.service.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@With
@Data
public class UserBean extends Bean {
    private String email;
    private String password;
    private RoleBean role;
    private UserDataBean userData;

    public UserBean withId(Integer id) {
	setId(id);
	return this;
    }

}
