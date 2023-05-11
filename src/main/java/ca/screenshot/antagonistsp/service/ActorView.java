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

    public static Map<UUID, Skill> MakeSkills(Attributes attributes, Map<UUID, Skill> skillsLevel) {
        return Skill.Add(Map.ofEntries(
                // Physical Skills
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_ACROBATICS, attributes.agility + attributes.constitution, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_ATHLETICS, attributes.constitution + attributes.strength, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_BRUTALFIGHTING, attributes.agility + attributes.strength, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_FINESSEFIGHTING, attributes.agility + attributes.reflex, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_MUSCULAR, attributes.constitution + attributes.strength, false),

                // Action Skills
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_DRIVE, attributes.perception + attributes.reflex, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_LONGARMS, attributes.constitution + attributes.perception, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_SLEIGHTOFHANDS, attributes.agility + attributes.reflex, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_SMALLARMS, attributes.perception + attributes.reflex, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_STEALTH, attributes.agility + attributes.intelligence, false),

                // Social Skills
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_CHARM, attributes.charisma + attributes.constitution, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_DECEPTION, attributes.charisma + attributes.intelligence, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_INSIGHT, attributes.charisma + attributes.perception, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_INTIMIDATE, attributes.charisma + attributes.strength, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_PERSUADE, attributes.charisma + attributes.reflex, false),

                // Mental Skills
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_INVESTIGATE, attributes.intelligence + attributes.perception, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_KNOWLEDGE, attributes.intelligence + attributes.reflex, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_MEDICINE, attributes.agility + attributes.intelligence, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_SURVIVAL, attributes.constitution + attributes.perception, false),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_TECHNICAL, attributes.intelligence + attributes.strength, false)
        ), skillsLevel);
    }

    private static Map<UUID, Skill> MakeSkills(ActorSkill actorSkill) {
        return Map.ofEntries(
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_ACROBATICS, actorSkill.acrobatics, actorSkill.acrobaticsFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_ATHLETICS, actorSkill.athletics, actorSkill.athleticsFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_BRUTALFIGHTING, actorSkill.brutalFighting, actorSkill.brutalFightingFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_FINESSEFIGHTING, actorSkill.finesseFighting, actorSkill.finesseFightingFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_MUSCULAR, actorSkill.muscular, actorSkill.muscularFlagged),

                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_DRIVE, actorSkill.drive, actorSkill.driveFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_LONGARMS, actorSkill.longArms, actorSkill.longArmsFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_SLEIGHTOFHANDS, actorSkill.sleightOfHands, actorSkill.sleightOfHandsFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_SMALLARMS, actorSkill.smallArms, actorSkill.smallArmsFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_STEALTH, actorSkill.stealth, actorSkill.stealthFlagged),

                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_CHARM, actorSkill.charm, actorSkill.charmFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_DECEPTION, actorSkill.deception, actorSkill.deceptionFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_INSIGHT, actorSkill.insight, actorSkill.insightFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_INTIMIDATE, actorSkill.intimidate, actorSkill.intimidateFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_PERSUADE, actorSkill.persuade, actorSkill.persuadeFlagged),

                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_INVESTIGATE, actorSkill.investigate, actorSkill.investigateFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_KNOWLEDGE, actorSkill.knowledge, actorSkill.knowledgeFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_MEDICINE, actorSkill.medicine, actorSkill.medicineFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_SURVIVAL, actorSkill.survival, actorSkill.survivalFlagged),
                Skill.MakeSkillEntry(Constants.KNOWN_ID_SKILL_TECHNICAL, actorSkill.technical, actorSkill.technicalFlagged)
        );
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

            ret.healthy_movement = new ActorMovement();
            ret.healthy_movement.crawl = 1;
            ret.healthy_movement.combat = 8 + (ret.getAcrobaticsRating());
            ret.healthy_movement.run = 8 + (ret.getAthleticsRating());
            ret.healthy_movement.swim = Math.max(1, 2 + (ret.getAthleticsRating() / 2));
            ret.healthy_movement.travel = Math.max(1, 2 + (ret.getAthleticsRating() / 2));

            ret.half_movement = new ActorMovement();
            ret.half_movement.crawl = 1;
            ret.half_movement.combat = Math.round(ret.healthy_movement.combat / 2.f);
            ret.half_movement.run = Math.round(ret.healthy_movement.run / 2.f);
            ret.half_movement.swim = Math.round(ret.healthy_movement.swim / 2.f);
            ret.half_movement.travel = Math.round(ret.healthy_movement.travel / 2.f);

            ret.initiative = ret.getSleightOfHandsRating();
            ret.brutalHit = ret.getBrutalFightingRating();
            ret.finesseHit = ret.getFinesseFightingRating();
            ret.meleeImpact = ret.getMuscularRating();
            ret.dodge = ret.getAcrobaticsRating();
            ret.resistance = ret.getAthleticsRating();
            ret.health = 4;

            return ret;
        });
    }

}
