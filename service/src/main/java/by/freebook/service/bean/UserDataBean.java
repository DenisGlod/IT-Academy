package by.freebook.service.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@With
@Data
public class UserDataBean extends Bean {
    private String firstName;
    private String lastName;
    private String middleName;
    private Date age;

    public UserDataBean withId(Integer id) {
        setId(id);
        return this;
    }

}
