package by.itacademy.service.bean;

import java.util.Map;

public class GroupBean {
    private Long id;
    private Map<String, Integer> rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, Integer> getRating() {
        return rating;
    }

    public void setRating(Map<String, Integer> rating) {
        this.rating = rating;
    }
}
