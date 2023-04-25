package ca.screenshot.antagonistsp.service;

import ca.screenshot.antagonistsp.entity.*;
import ca.screenshot.antagonistsp.repository.Actors;
import ca.screenshot.antagonistsp.repository.Categories;
import ca.screenshot.antagonistsp.service.views.Attributes;
import ca.screenshot.antagonistsp.service.views.*;

import java.util.*;
import java.util.stream.Collectors;

public class ActorView {
    private final Actors repositoryActors;
    private final Categories repositoryCategories;

    public ActorView(Actors repositoryActors, Categories repositoryCategories) {
        this.repositoryActors = repositoryActors;
        this.repositoryCategories = repositoryCategories;
    }

    private static int MasteryTypeToPriority(Mastery.Type type) {
        return switch (type) {
            case MAJOR -> 0;
            case MINOR -> 1;
            case SPECIALIZE -> 2;
        };
    }

    public static ActorListing MakeActorListingFromActor(Actor a) {
        ActorListing listing = new ActorListing();
        listing.id = a.id.toString().toLowerCase();
        listing.displayName = a.name;
        return listing;
    }

    public static Modifier MakeModifier(Descriptor descriptor) {
        Modifier modifier = new Modifier();
        modifier.id = descriptor.descriptorId.toString().toLowerCase();
        modifier.displayName = descriptor.name;
        modifier.cost = descriptor.cost;
        modifier.attributes = new Attributes();
        modifier.attributes.add(descriptor.attributes.attributes);
        return modifier;
    }

    public static Skills MakeSkills(Attributes attributes, Skills skillsLevel) {
        Skills skills = new Skills();

        // Physical Skills
        skills.acrobatics = attributes.agility + attributes.constitution + skillsLevel.acrobatics;
        skills.athletics = attributes.constitution + attributes.strength + skillsLevel.athletics;
        skills.brutalFighting = attributes.agility + attributes.strength + skillsLevel.brutalFighting;
        skills.finesseFighting = attributes.agility + attributes.reflex + skillsLevel.finesseFighting;
        skills.muscular = attributes.constitution + attributes.strength + skillsLevel.muscular;

        // Action Skills
        skills.drive = attributes.perception + attributes.reflex + skillsLevel.drive;
        skills.longArms = attributes.constitution + attributes.perception + skillsLevel.longArms;
        skills.sleightOfHands = attributes.agility + attributes.reflex + skillsLevel.sleightOfHands;
        skills.smallArms = attributes.perception + attributes.reflex + skillsLevel.smallArms;
        skills.stealth = attributes.agility + attributes.intelligence + skillsLevel.stealth;

        // Social Skills
        skills.charm = attributes.charisma + attributes.constitution + skillsLevel.charm;
        skills.deception = attributes.charisma + attributes.intelligence + skillsLevel.deception;
        skills.insight = attributes.charisma + attributes.perception + skillsLevel.insight;
        skills.intimidate = attributes.charisma + attributes.strength + skillsLevel.intimidate;
        skills.persuade = attributes.charisma + attributes.reflex + skillsLevel.persuade;

        // Mental Skills
        skills.investigate = attributes.intelligence + attributes.perception + skillsLevel.investigate;
        skills.knowledge = attributes.intelligence + attributes.reflex + skillsLevel.knowledge;
        skills.medicine = attributes.agility + attributes.intelligence + skillsLevel.medicine;
        skills.survival = attributes.constitution + attributes.perception + skillsLevel.survival;
        skills.technical = attributes.intelligence + attributes.strength + skillsLevel.technical;

        return skills;
    }

    private static Skills MakeSkills(ActorSkill actorSkill) {
        Skills levels = new Skills();
        levels.acrobatics = actorSkill.acrobatics;
        levels.athletics = actorSkill.athletics;
        levels.brutalFighting = actorSkill.brutalFighting;
        levels.finesseFighting = actorSkill.finesseFighting;
        levels.muscular = actorSkill.muscular;
        levels.drive = actorSkill.drive;
        levels.longArms = actorSkill.longArms;
        levels.sleightOfHands = actorSkill.sleightOfHands;
        levels.smallArms = actorSkill.smallArms;
        levels.stealth = actorSkill.stealth;
        levels.charm = actorSkill.charm;
        levels.deception = actorSkill.deception;
        levels.insight = actorSkill.insight;
        levels.intimidate = actorSkill.intimidate;
        levels.persuade = actorSkill.persuade;
        levels.investigate = actorSkill.investigate;
        levels.knowledge = actorSkill.knowledge;
        levels.medicine = actorSkill.medicine;
        levels.survival = actorSkill.survival;
        levels.technical = actorSkill.technical;
        return levels;
    }

    public List<ActorListing> list() {
        Iterable<Actor> allActors = repositoryActors.findAll();
        List<ActorListing> ret = new ArrayList<>();
        for (Actor actor : allActors) {
            ret.add(MakeActorListingFromActor(actor));
        }
        return ret;
    }

    public Optional<ActorDetailView> byId(String id) {
        UUID theId;
        try {
            theId = UUID.fromString(id);
        } catch (IllegalArgumentException ignored) {
            return Optional.empty();
        }

        Optional<Actor> byId = repositoryActors.findById(theId);
        return byId.map(actor -> {
            ActorDetailView ret = new ActorDetailView();
            ret.id = actor.id.toString().toLowerCase();
            ret.displayName = actor.name;
            ret.sourceOfPower = SourceOfPowerView.MakeListing(actor.power);
            ret.attributes = new Attributes();
            ret.quirksTalents = new ArrayList<>();
            ret.quirksFlaws = new ArrayList<>();
            ret.characterDescriptors = new ArrayList<>();
            ret.handiness = new Modifier();

            ret.attributes.weight = ret.attributes.height = 20;

            ret.availableXp = actor.logItems.stream()
                    .map(actorQuestLogItem -> actorQuestLogItem.xp)
                    .reduce(0, Integer::sum);

            ret.logs = actor.logItems.stream()
                    .sorted(Comparator.comparingInt(o -> o.displayOrder))
                    .map(actorQuestLogItem -> {
                        QuestLog questLog = new QuestLog();
                        questLog.xp = actorQuestLogItem.xp;
                        questLog.display = actorQuestLogItem.description;
                        return questLog;
                    })
                    .toList();

            Category categoryAge = repositoryCategories.findByName("Age");
            Category categorySize = repositoryCategories.findByName("Size");
            Category categoryHandiness = repositoryCategories.findByName("Handiness");

            for (Descriptor descriptor : actor.descriptors) {
                ret.totalCost += descriptor.cost;
                ret.attributes.add(descriptor.attributes.attributes);

                if (descriptor.category.categoryId == categoryAge.categoryId) {
                    ret.modifierAge = MakeModifier(descriptor);
                } else if (descriptor.category.categoryId == categorySize.categoryId) {
                    ret.modifierSize = MakeModifier(descriptor);
                } else if (descriptor.category.categoryId == categoryHandiness.categoryId) {
                    ret.handiness = MakeModifier(descriptor);
                } else {
                    ret.characterDescriptors.add(MakeModifier(descriptor));
                }
            }

            ret.skillsLevel = MakeSkills(actor.actorSkill);
            ret.skills = MakeSkills(ret.attributes, ret.skillsLevel);


            ret.powers = actor.powers.stream().collect(
                            Collectors.groupingBy(actorMasteryPower1 -> actorMasteryPower1.power.parent))
                    .entrySet().stream()
                    .map(entry -> {
                        PowerByMastery powerByMastery = new PowerByMastery();

                        powerByMastery.mastery = entry.getKey();
                        powerByMastery.powers = entry.getValue().stream()
                                .map(actorMasteryPower -> actorMasteryPower.power)
                                .sorted(Comparator.comparingInt(o -> o.level))
                                .toList();

                        if (!powerByMastery.powers.isEmpty()) {
                            powerByMastery.level = powerByMastery.powers.get(powerByMastery.powers.size() - 1).level;
                        }

                        return powerByMastery;
                    })
                    .sorted(Comparator.comparingInt(o -> MasteryTypeToPriority(o.mastery.type)))
                    .toList();

            return ret;
        });
    }

}
