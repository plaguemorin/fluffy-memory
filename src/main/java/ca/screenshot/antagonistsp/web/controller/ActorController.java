package ca.screenshot.antagonistsp.web.controller;

import ca.screenshot.antagonistsp.service.ActorView;
import ca.screenshot.antagonistsp.service.views.ActorDetailView;
import ca.screenshot.antagonistsp.service.views.Skill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/actor")
public class ActorController {
    private final ActorView actors;

    public ActorController(ActorView actors) {
        this.actors = actors;
    }

    private static int diceCount(int delta) {
        int absdelta = Math.abs(delta);
        boolean negative = delta < 0;

        if (absdelta == 0) {
            return 1;
        }

        if (absdelta == 1 || absdelta == 2) {
            return negative ? -2 : 2;
        }

        return negative ? -3 : 3;
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
    public String roll(
            @PathVariable("id") String id,
            @PathVariable("type") String type,
            @RequestParam(value = "difficulty", required = false) String difficulty,
            Model model) {
        Optional<ActorDetailView> mastery = actors.byId(id);
        model.addAttribute("type", type);
        model.addAttribute("actorid", id);

        mastery.ifPresent(a -> {
            Skill skill = a.skills.get(UUID.fromString(type));
            model.addAttribute("skill", skill);

            if (difficulty != null && !difficulty.isEmpty()) {
                try {
                    Integer diff = Integer.parseInt(difficulty);
                    int nbDie = diceCount(skill.getAttributeTotal() - diff);

                    final List<Integer> dice = new ArrayList<>();
                    for (int i = 0; i < Math.abs(nbDie); i++) {
                        dice.add((int) Math.floor(Math.random() * 10) + 1);
                    }

                    int result = dice.stream().sorted(
                            (o1, o2) -> {
                                if (nbDie > 0) return Integer.max(o1, o2);
                                return Integer.min(o1, o2);
                            }
                    ).findFirst().orElse(0);


                    return "actor-roll-result";
                } catch (NumberFormatException e) {

                }
            }
        });


        return "actor-roll";
    }

}
