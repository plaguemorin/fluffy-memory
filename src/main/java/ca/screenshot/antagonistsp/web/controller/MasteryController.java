package ca.screenshot.antagonistsp.web.controller;

import ca.screenshot.antagonistsp.entity.Mastery;
import ca.screenshot.antagonistsp.repository.Masteries;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/mastery")
public class MasteryController {
    private Masteries masteryRepository;

    public MasteryController(Masteries masteryRepository) {
        this.masteryRepository = masteryRepository;
    }

    @GetMapping("/{id}")
    public String get(@PathVariable("id") String id, Model model) {
        UUID theId = UUID.fromString(id);
        Optional<Mastery> mastery = masteryRepository.findById(theId);

        mastery.ifPresent(m -> model.addAttribute("mastery", m));

        return "mastery-show";
    }
}
