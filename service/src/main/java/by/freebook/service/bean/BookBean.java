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
public class BookBean extends Bean {
    private String name;
    private String author;
    private String publisher;
    private String binding;
    private String ageRestrictions;
    private String isbn;
    private String description;
    private Integer publishingYear;

    public BookBean withId(Integer id) {
	setId(id);
	return this;
    }

}
