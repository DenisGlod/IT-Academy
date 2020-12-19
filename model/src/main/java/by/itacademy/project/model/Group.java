package by.itacademy.project.model;

import java.util.List;
import java.util.Objects;

public class Group {
    private Long id;
    private List<Long> users;
    private List<Long> topics;
    private Long teacherId;

    public Group(Long id) {
    }

    public Group(Long id, List<Long> users, List<Long> topics, Long teacherId) {
        this.id = id;
        this.users = users;
        this.topics = topics;
        this.teacherId = teacherId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id) && Objects.equals(users, group.users) && Objects.equals(topics, group.topics) && Objects.equals(teacherId, group.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, users, topics, teacherId);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Group{");
        sb.append("id=").append(id);
        sb.append(", users=").append(users);
        sb.append(", topics=").append(topics);
        sb.append(", teacherId=").append(teacherId);
        sb.append('}');
        return sb.toString();
    }
}
