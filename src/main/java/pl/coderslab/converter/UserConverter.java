package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserDao;

@Component
public class UserConverter implements Converter<String, User>{

    @Autowired
    private UserDao userDao;

    public UserConverter() {
    }

    @Override
    public User convert(String source) {
        User user = userDao.findById(Long.valueOf(source));
        return user;
    }
}
