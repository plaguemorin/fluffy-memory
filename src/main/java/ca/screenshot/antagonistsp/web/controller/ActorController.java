package ca.screenshot.antagonistsp.web.controller;

import ca.screenshot.antagonistsp.service.ActorView;
import ca.screenshot.antagonistsp.service.views.ActorDetailView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/actor")
public class ActorController {
    private ActorView actors;

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
}
