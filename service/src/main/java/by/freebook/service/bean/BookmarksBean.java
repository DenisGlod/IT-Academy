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
public class BookmarksBean extends Bean {
    private BookBean book;
    private UserBean user;

    public BookmarksBean withId(Integer id) {
	setId(id);
	return this;
    }
}
