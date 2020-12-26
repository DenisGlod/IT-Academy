package by.itacademy.app;

import by.itacademy.app.bean.GroupBean;
import by.itacademy.filter.util.Attributes;
import by.itacademy.filter.util.Pages;
import by.itacademy.model.Topic;
import by.itacademy.model.User;
import by.itacademy.repository.factory.RepositoryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/login.do", name = "LoginController")
public class LoginController extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute(Attributes.USER.getName());
        if (Objects.isNull(user)) {
            resp.sendError(401, "Для доступа к запрашиваемому ресурсу требуется аутентификация!");
            LOGGER.info("Authorization 401 Unauthorized");
        }
        LOGGER.info(user.toString());
        switch (user.getRole()) {
            case STUDENT:
                LOGGER.info("Go STUDENT Pages");
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
                session.setAttribute(Attributes.GROUPS.getName(), groupBeans);
                resp.sendRedirect(Pages.USER.getName());
                break;
            case TEACHER:
                LOGGER.info("Go TEACHER Pages");
                resp.sendRedirect(Pages.TEACHER.getName());
                break;
            case ADMIN:
                LOGGER.info("Go ADMIN Pages");
                resp.sendRedirect(Pages.ADMIN.getName());
                break;
        }
    }
}
