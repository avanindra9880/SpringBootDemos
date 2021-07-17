package com.avanindra.springdemos.javaConfig;

import com.avanindra.springdemos.utils.MyLoggerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.avanindra.springdemos")
@PropertySource("classpath:myLogger.properties")
@PropertySource("classpath:application.properties")
public class SportConfig {

    @Bean
    public MyLoggerConfig myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
                                         @Value("${printed.logger.level}") String printedLoggerLevel) {

        MyLoggerConfig myLoggerConfig = new MyLoggerConfig(rootLoggerLevel, printedLoggerLevel);

        return myLoggerConfig;
    }

    // define bean for our happy fortune service
    @Bean
    public FortuneService happyFortuneService() {
        return new HappyFortuneService();
    }

    // define bean for our swim coach AND inject dependency
    @Bean
    public Coach swimCoach() {
        TennisCoach mySwimCoach = new TennisCoach(happyFortuneService());

        return mySwimCoach;
    }


}
