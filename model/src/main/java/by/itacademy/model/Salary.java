package by.itacademy.model;

import java.util.Date;
import java.util.Objects;

public class Salary extends AbstractModel {
    private Long teacherId;
    private Date date;
    private Integer value;

    public Salary() {
    }

    public Salary(Long teacherId, Date date, Integer value) {
        this.teacherId = teacherId;
        this.date = date;
        this.value = value;
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
    public String toString() {
        final StringBuffer sb = new StringBuffer("Salary{");
        sb.append("teacherId=").append(teacherId);
        sb.append(", date=").append(date);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return Objects.equals(teacherId, salary.teacherId) && Objects.equals(date, salary.date) && Objects.equals(value, salary.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, date, value);
    }
}
