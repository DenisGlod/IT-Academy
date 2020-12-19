package by.itacademy.project.model;

import java.util.Objects;

public class Rating extends AbstractModel {
    private Long userId;
    private Long topicId;
    private Byte mark;

    public Rating() {
    }

    public Rating(Long userId, Long topicId, Byte mark) {
        this.userId = userId;
        this.topicId = topicId;
        this.mark = mark;
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
        sb.append("userId=").append(userId);
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
        return Objects.equals(userId, rating.userId) && Objects.equals(topicId, rating.topicId) && Objects.equals(mark, rating.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, topicId, mark);
    }
}