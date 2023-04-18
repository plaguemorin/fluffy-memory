package ca.screenshot.antagonistsp;

import ca.screenshot.antagonistsp.repository.Actors;
import ca.screenshot.antagonistsp.repository.Categories;
import ca.screenshot.antagonistsp.repository.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AntagonistSpApplication {
    private static final Logger log = LoggerFactory.getLogger(AntagonistSpApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AntagonistSpApplication.class, args);
    }

    @Bean
    TestBean createTestBean(Items itemRepo, Categories categories, Actors actors) {
        TestBean b = new TestBean();
        b.setItemsRepository(itemRepo);
        b.setCategoriesRepository(categories);
        b.setActorsRepository(actors);
        b.execute();
        return b;
    }
}
