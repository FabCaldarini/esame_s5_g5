
package com.example.Esame;

import com.example.Esame.config.ApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInitializerRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DataInitializerRunner.class);

    private final ApplicationConfig applicationConfig;

    @Autowired
    public DataInitializerRunner(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        applicationConfig.initializeTestData();
    }
}



