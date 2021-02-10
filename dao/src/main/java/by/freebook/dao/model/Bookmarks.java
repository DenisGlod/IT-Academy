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
public class Bookmarks extends Entity {
    private Book book;
    private User user;

    public Bookmarks withId(Integer id) {
	setId(id);
	return this;
    }
}
