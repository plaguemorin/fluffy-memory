package ca.screenshot.antagonistsp.controller;

import ca.screenshot.antagonistsp.entity.Actor;
import ca.screenshot.antagonistsp.entity.Mastery;
import ca.screenshot.antagonistsp.repository.Actors;
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
    private Actors actors;

    public ActorController(Actors actors) {
        this.actors = actors;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("actors", actors.findAll());

        return "actor-list";
    }


    @GetMapping("/{id}")
    public String get(@PathVariable("id") String id, Model model) {
        UUID theId = UUID.fromString(id);
        Optional<Actor> mastery = actors.findById(theId);

        mastery.ifPresent(m -> model.addAttribute("actor", m));

        return "actor-show";
    }
}
