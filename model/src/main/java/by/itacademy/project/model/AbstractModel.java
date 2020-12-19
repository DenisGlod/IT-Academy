package by.itacademy.project.model;

import java.io.Serializable;

public abstract class AbstractModel {
    private Long id;

    public AbstractModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
