package com.geekster.UserManagement.configuration;



import com.geekster.UserManagement.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
class BeanManager {

    @Bean
    public List<User> getInitializedList()
    {
        User initUser = new User(0,"ahmed","ah6377","9898989898","bikaner");
        List<User> initList = new ArrayList<>();
        initList.add(initUser);

        return initList;
    }
}
