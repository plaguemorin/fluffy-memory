package ca.screenshot.antagonistsp;

import ca.screenshot.antagonistsp.repository.*;
import ca.screenshot.antagonistsp.service.ActorView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.Locale;
import java.util.TimeZone;

@SpringBootApplication
public class AntagonistSpApplication {
    private static final Logger log = LoggerFactory.getLogger(AntagonistSpApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AntagonistSpApplication.class, args);
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        localeResolver.setDefaultTimeZone(TimeZone.getTimeZone("UTC"));
        return localeResolver;
    }

    @Bean
    ActorView createActorService(Actors actors, Categories categories) {
        return new ActorView(actors, categories);
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
