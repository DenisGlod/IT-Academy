package by.freebook.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@With
@Data
@Entity
public class UserData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(length = 50)
    private String middleName;

    @Temporal(TemporalType.DATE)
    private Date age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}
