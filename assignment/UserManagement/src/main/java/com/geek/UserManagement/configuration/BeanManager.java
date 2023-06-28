package com.geek.UserManagement.configuration;


import com.geek.UserManagement.model.Type;
import com.geek.UserManagement.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
class BeanManager {

    @Bean
    public List<User> getInitializedList()
    {
        User initUser = new User(0,"ahmed","ahmed@geekster.com","abed","9898989898",26, LocalDate.of(1996,12,12), Type.ADMIN,LocalDate.now(), LocalTime.now());
        List<User> initList = new ArrayList<>();
        initList.add(initUser);

        return initList;
    }
}
