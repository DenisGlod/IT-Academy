package by.freebook.dao.model;

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
public class User extends Entity {
    private String email;
    private String password;
    private Role role;
    private UserData userData;

    public User withId(Integer id) {
        setId(id);
        return this;
    }

}
