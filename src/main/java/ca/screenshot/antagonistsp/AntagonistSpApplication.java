package ca.screenshot.antagonistsp;

import ca.screenshot.antagonistsp.controller.SourceOfPowerController;
import ca.screenshot.antagonistsp.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;

@SpringBootApplication
public class AntagonistSpApplication {
    private static final Logger log = LoggerFactory.getLogger(AntagonistSpApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AntagonistSpApplication.class, args);
    }


    @Bean
    TestBean createTestBean(Descriptors itemRepo, Categories categories, Actors actors, SourceOfPowers sourceOfPowerRepo, Masteries masteriesRepo, MasteryPowers masteryPowersRepo) {
        TestBean b = new TestBean();
        b.setMasteryPowersRepository(masteryPowersRepo);
        b.setMasteriesRepository(masteriesRepo);
        b.setSourceOfPowersRepository(sourceOfPowerRepo);
        b.setItemsRepository(itemRepo);
        b.setCategoriesRepository(categories);
        b.setActorsRepository(actors);
        b.execute();
        return b;
    }

}
