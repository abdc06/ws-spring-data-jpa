package me.abdc.jparelationship.app;

import me.abdc.jparelationship.common.TableName;
import me.abdc.jparelationship.common.service.IdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    IdsService idsService;

    @Override
    public void run(String... args) throws Exception {
        idsService.getNextId(TableName.BOARD);
        idsService.getNextId(TableName.BOARD);
        idsService.getNextId(TableName.BOARD);
        idsService.getNextId(TableName.POST);
        idsService.getNextId(TableName.POST);
        idsService.getNextId(TableName.COMMENT);
        idsService.getNextId(TableName.COMMENT);
        idsService.getNextId(TableName.COMMENT);
        idsService.getNextId(TableName.COMMENT);
    }
}
