package by.itacademy.model;

import java.util.List;
import java.util.Objects;

public class Group extends AbstractModel {
    private List<Long> users;
    private List<Long> topics;
    private Long teacherId;

    public Group() {
    }

    public Group(List<Long> users, List<Long> topics, Long teacherId) {
        this.users = users;
        this.topics = topics;
        this.teacherId = teacherId;
    }

    public List<Long> getUsers() {
        return users;
    }

    public void setUsers(List<Long> users) {
        this.users = users;
    }

    public List<Long> getTopics() {
        return topics;
    }

    public void setTopics(List<Long> topics) {
        this.topics = topics;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Group{");
        sb.append("users=").append(users);
        sb.append(", topics=").append(topics);
        sb.append(", teacherId=").append(teacherId);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(users, group.users) && Objects.equals(topics, group.topics) && Objects.equals(teacherId, group.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users, topics, teacherId);
    }
}
