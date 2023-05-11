package ca.screenshot.antagonistsp.web.controller;

import ca.screenshot.antagonistsp.service.ActorView;
import ca.screenshot.antagonistsp.service.views.ActorDetailView;
import ca.screenshot.antagonistsp.service.views.Skill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/actor")
public class ActorController {
    private final ActorView actors;

    public ActorController(ActorView actors) {
        this.actors = actors;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("actors", actors.list());
        return "actor-list";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable("id") String id, Model model) {
        Optional<ActorDetailView> mastery = actors.byId(id);
        mastery.ifPresent(m -> model.addAttribute("actor", m));
        return "actor-show";
    }

    @GetMapping("/{id}/roll/{type}/")
    public String roll(@PathVariable("id") String id, @PathVariable("type") String type, Model model) {
        Optional<ActorDetailView> mastery = actors.byId(id);
        model.addAttribute("type", type);
        model.addAttribute("actorid", id);

        mastery.ifPresent(a -> {
            Skill skill = a.skills.get(UUID.fromString(type));
            model.addAttribute("skill", skill);
        });

        return "actor-roll";
    }
}
