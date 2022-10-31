package me.abdc.jparelation.app;

import me.abdc.jparelation.common.service.IdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    IdsService idsService;

    @Override
    public void run(String... args) throws Exception {
        idsService.getNextId("TEST");
        idsService.getNextId("TEST");
        idsService.getNextId("TEST");
    }
}
