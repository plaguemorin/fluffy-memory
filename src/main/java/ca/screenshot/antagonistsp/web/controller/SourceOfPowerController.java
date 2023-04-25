package ca.screenshot.antagonistsp.web.controller;

import ca.screenshot.antagonistsp.entity.Mastery;
import ca.screenshot.antagonistsp.entity.MasteryPower;
import ca.screenshot.antagonistsp.repository.SourceOfPowers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/source")
public class SourceOfPowerController {
    SourceOfPowers sourceOfPowersRepository;

    public SourceOfPowerController(SourceOfPowers sourceOfPowersRepository) {
        this.sourceOfPowersRepository = sourceOfPowersRepository;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("sources", sourceOfPowersRepository.findAll());

        return "power-list";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable("id") String id, Model model) {
        UUID uuid = UUID.fromString(id);

        SourceOfPowerDetailView viewModel = sourceOfPowersRepository
                .findById(uuid)
                .map(power -> {
                    SourceOfPowerDetailView vm = new SourceOfPowerDetailView();
                    vm.id = power.id.toString();
                    vm.name = power.name;

                    vm.masteryGroups = power.masteryGroups.stream()
                            .map(grp -> {
                                SourceOfPowerDetailView.Group group = new SourceOfPowerDetailView.Group();
                                group.id = grp.id.toString();
                                group.displayOrder = grp.displayOrder;
                                group.powers = grp.powersAvailable
                                        .stream()
                                        .sorted(Comparator.comparingInt(o -> o.level))
                                        .collect(Collectors.groupingBy(m -> m.parent));
                                return group;
                            })
                            .sorted(Comparator.comparingInt(o -> o.displayOrder))
                            .collect(Collectors.toList());
                    return vm;
                })
                .orElse(null);

        model.addAttribute("source", viewModel);

        return "power-show";
    }

    public static class SourceOfPowerDetailView {
        public String id;
        public String name;
        public Collection<Group> masteryGroups;

        public static class Group {
            public String id;
            public int displayOrder;
            public Map<Mastery, List<MasteryPower>> powers;
        }
    }
}
