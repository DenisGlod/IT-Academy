package by.itacademy.project.model;

import java.util.Objects;

public class Rating {
    private Long id;
    private Long userId;
    private Long topicId;
    private Byte mark;

    public Rating() {
    }

    public Rating(Long id, Long userId, Long topicId, Byte mark) {
        this.id = id;
        this.userId = userId;
        this.topicId = topicId;
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Byte getMark() {
        return mark;
    }

    public void setMark(Byte mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Rating{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", topicId=").append(topicId);
        sb.append(", mark=").append(mark);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return id.equals(rating.id) && userId.equals(rating.userId) && topicId.equals(rating.topicId) && mark.equals(rating.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, topicId, mark);
    }
}