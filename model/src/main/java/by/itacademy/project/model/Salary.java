package by.itacademy.project.model;

import java.util.Date;
import java.util.Objects;

public class Salary {
    private Long id;
    private Long teacherId;
    private Date date;
    private Integer value;

    public Salary() {
    }

    public Salary(Long id, Long teacherId, Date date, Integer value) {
        this.id = id;
        this.teacherId = teacherId;
        this.date = date;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return Objects.equals(id, salary.id) && Objects.equals(teacherId, salary.teacherId) && Objects.equals(date, salary.date) && Objects.equals(value, salary.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teacherId, date, value);
    }
}
