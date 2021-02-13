package by.freebook.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@With
@Data
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private String binding;

    @Column(nullable = false, length = 3)
    private String ageRestrictions;

    @Column(nullable = false)
    private String isbn;

    @Column(precision = 4)
    private Integer publishingYear;

    @Column(nullable = false)
    private String description;

}
