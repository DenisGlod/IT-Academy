package by.itacademy.service.impl;

import by.itacademy.model.Topic;
import by.itacademy.model.User;
import by.itacademy.repository.factory.RepositoryFactory;
import by.itacademy.service.UserService;
import by.itacademy.service.bean.GroupBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public List<GroupBean> findRatingByUserId(User user) {
        List<GroupBean> groupBeans = new ArrayList<>();
        var ratingRepository = RepositoryFactory.getFactory().getRatingRepository();
        var topicRepository = RepositoryFactory.getFactory().getTopicRepository();
        RepositoryFactory.getFactory().getGroupRepository().findGroupByUserId(user.getId()).forEach(groupItem -> {
            var bean = new GroupBean();
            bean.setId(groupItem.getId());
            var ratingMap = new HashMap<String, Integer>();
            groupItem.getTopics().forEach(topicId -> {
                Optional<Topic> item = topicRepository.findById(topicId);
                if (item.isPresent()) {
                    var topic = item.get();
                    var rating = ratingRepository.findByUserIdAndTopicId(user.getId(), topicId);
                    ratingMap.put(topic.getName(), rating.getMark());
                }
            });
            bean.setRating(ratingMap);
            groupBeans.add(bean);
        });
        return groupBeans;
    }
}
