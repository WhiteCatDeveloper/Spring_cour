package org.example.spring;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:myApp.properties")
//@ComponentScan("org.example.spring")
public class MyConfig {

    @Bean
    @Scope("singleton")
    public Pet catBean () {
        return  new Cat();
    }

    @Bean
    public Person personBean() {
        return new Person(catBean());
    }
}
