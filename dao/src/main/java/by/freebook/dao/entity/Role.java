package by.freebook.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@With
@Data
@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleEnum role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

}
