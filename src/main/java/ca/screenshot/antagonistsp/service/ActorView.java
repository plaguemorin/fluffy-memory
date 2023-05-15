package ca.screenshot.antagonistsp.service;

import ca.screenshot.antagonistsp.Constants;
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

    public static Skills MakeSkills(Attributes attributes, ActorSkill actorSkill) {
        Skills ret = new Skills();;
        ret.putAll(Map.ofEntries(
                // Physical Skills
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_ACROBATICS, attributes.agility + attributes.constitution, actorSkill.acrobatics, actorSkill.acrobaticsFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_ATHLETICS, attributes.constitution + attributes.strength, actorSkill.athletics, actorSkill.athleticsFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_BRUTALFIGHTING, attributes.agility + attributes.strength, actorSkill.brutalFighting, actorSkill.brutalFightingFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_FINESSEFIGHTING, attributes.agility + attributes.reflex, actorSkill.finesseFighting, actorSkill.finesseFightingFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_MUSCULAR, attributes.constitution + attributes.strength, actorSkill.muscular, actorSkill.muscularFlagged),

                // Action Skills
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_DRIVE, attributes.perception + attributes.reflex, actorSkill.drive, actorSkill.driveFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_LONGARMS, attributes.constitution + attributes.perception, actorSkill.longArms, actorSkill.longArmsFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_SLEIGHTOFHANDS, attributes.agility + attributes.reflex, actorSkill.sleightOfHands, actorSkill.sleightOfHandsFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_SMALLARMS, attributes.perception + attributes.reflex, actorSkill.smallArms, actorSkill.smallArmsFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_STEALTH, attributes.agility + attributes.intelligence, actorSkill.stealth, actorSkill.stealthFlagged),

                // Social Skills
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_CHARM, attributes.charisma + attributes.constitution, actorSkill.charm, actorSkill.charmFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_DECEPTION, attributes.charisma + attributes.intelligence, actorSkill.deception, actorSkill.deceptionFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_INSIGHT, attributes.charisma + attributes.perception, actorSkill.insight, actorSkill.insightFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_INTIMIDATE, attributes.charisma + attributes.strength, actorSkill.intimidate, actorSkill.intimidateFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_PERSUADE, attributes.charisma + attributes.reflex, actorSkill.persuade, actorSkill.persuadeFlagged),

                // Mental Skills
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_INVESTIGATE, attributes.intelligence + attributes.perception, actorSkill.investigate, actorSkill.investigateFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_KNOWLEDGE, attributes.intelligence + attributes.reflex, actorSkill.knowledge, actorSkill.knowledgeFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_MEDICINE, attributes.agility + attributes.intelligence, actorSkill.medicine, actorSkill.medicineFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_SURVIVAL, attributes.constitution + attributes.perception, actorSkill.survival, actorSkill.survivalFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_TECHNICAL, attributes.intelligence + attributes.strength, actorSkill.technical, actorSkill.technicalFlagged)
        ));
        return ret;
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

            ret.skills = MakeSkills(ret.attributes, actor.actorSkill);

            ret.powers = actor.powers.stream().collect(
                            Collectors.groupingBy(amp1 -> amp1.power.parent))
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

            ret.healthy_movement = new ActorMovement();
            ret.healthy_movement.crawl = 1;
            ret.healthy_movement.combat = 8 + (ret.skills.getAcrobatics().getRating());
            ret.healthy_movement.run = 8 + (ret.skills.getAthletics().getRating());
            ret.healthy_movement.swim = Math.max(1, 2 + (ret.skills.getAthletics().getRating() / 2));
            ret.healthy_movement.travel = Math.max(1, 2 + (ret.skills.getAthletics().getRating() / 2));

            ret.half_movement = new ActorMovement();
            ret.half_movement.crawl = 1;
            ret.half_movement.combat = Math.round(ret.healthy_movement.combat / 2.f);
            ret.half_movement.run = Math.round(ret.healthy_movement.run / 2.f);
            ret.half_movement.swim = Math.round(ret.healthy_movement.swim / 2.f);
            ret.half_movement.travel = Math.round(ret.healthy_movement.travel / 2.f);

            ret.initiative = ret.skills.getSleightOfHands().getRating();
            ret.brutalHit = ret.skills.getBrutalFighting().getRating();
            ret.finesseHit = ret.skills.getFinesseFighting().getRating();
            ret.meleeImpact = ret.skills.getMuscular().getRating();
            ret.dodge = ret.skills.getAcrobatics().getRating();
            ret.resistance = ret.skills.getAthletics().getRating();
            ret.health = 4;

            return ret;
        });
    }

}
