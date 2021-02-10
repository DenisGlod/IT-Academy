package by.freebook.dao.model;

import java.sql.Date;

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
public class UserData extends Entity {
    private String firstName;
    private String lastName;
    private String middleName;
    private Date age;

    public UserData withId(Integer id) {
	setId(id);
	return this;
    }

}
