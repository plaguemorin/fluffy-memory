package ca.screenshot.antagonistsp.service.views;

import ca.screenshot.antagonistsp.Constants;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ActorDetailView {
    public String id;
    public String displayName;
    public SourceOfPowerListing sourceOfPower;
    public Attributes attributes;

    public List<PowerByMastery> powers;
    public Map<UUID, Skill> skills;
    public Map<UUID, Skill> skillsLevel;
    public Modifier modifierAge;
    public Modifier modifierSize;
    public Modifier handiness;
    public List<Modifier> quirksTalents;
    public List<Modifier> quirksFlaws;
    public List<Modifier> characterDescriptors;
    public List<QuestLog> logs;

    public int totalCost;
    public int availableXp;

    public ActorMovement healthy_movement;
    public ActorMovement half_movement;

    public int initiative;
    public int brutalHit;
    public int finesseHit;
    public int meleeImpact;
    public int dodge;
    public int resistance;
    public int health;

    public int getAcrobaticsRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_ACROBATICS, new Skill(skillID, level, flagged)).level;
    }

    public int getAcrobaticsLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_ACROBATICS, new Skill(skillID, level, flagged)).level;
    }

    public int getAthleticsRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_ATHLETICS, new Skill(skillID, level, flagged)).level;
    }

    public int getAthleticsLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_ATHLETICS, new Skill(skillID, level, flagged)).level;
    }

    public int getBrutalFightingRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_BRUTALFIGHTING, new Skill(skillID, level, flagged)).level;
    }

    public int getBrutalFightingLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_BRUTALFIGHTING, new Skill(skillID, level, flagged)).level;
    }

    public int getFinesseFightingRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_FINESSEFIGHTING, new Skill(skillID, level, flagged)).level;
    }

    public int getFinesseFightingLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_FINESSEFIGHTING, new Skill(skillID, level, flagged)).level;
    }


    public int getMuscularRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_MUSCULAR, new Skill(skillID, level, flagged)).level;
    }

    public int getMuscularLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_MUSCULAR, new Skill(skillID, level, flagged)).level;
    }

    public int getDriveRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_DRIVE, new Skill(skillID, level, flagged)).level;
    }

    public int getDriveLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_DRIVE, new Skill(skillID, level, flagged)).level;
    }

    public int getLongArmsRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_LONGARMS, new Skill(skillID, level, flagged)).level;
    }

    public int getLongArmsLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_LONGARMS, new Skill(skillID, level, flagged)).level;
    }

    public int getSleightOfHandsRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_SLEIGHTOFHANDS, new Skill(skillID, level, flagged)).level;
    }

    public int getSleightOfHandsLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_SLEIGHTOFHANDS, new Skill(skillID, level, flagged)).level;
    }


    public int getSmallArmsRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_SMALLARMS, new Skill(skillID, level, flagged)).level;
    }

    public int getSmallArmsLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_SMALLARMS, new Skill(skillID, level, flagged)).level;
    }


    public int getStealthRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_STEALTH, new Skill(skillID, level, flagged)).level;
    }

    public int getStealthLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_STEALTH, new Skill(skillID, level, flagged)).level;
    }


    public int getCharmRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_CHARM, new Skill(skillID, level, flagged)).level;
    }

    public int getCharmLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_CHARM, new Skill(skillID, level, flagged)).level;
    }


    public int getDeceptionRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_DECEPTION, new Skill(skillID, level, flagged)).level;
    }

    public int getDeceptionLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_DECEPTION, new Skill(skillID, level, flagged)).level;
    }


    public int getInsightRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_INSIGHT, new Skill(skillID, level, flagged)).level;
    }

    public int getInsightLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_INSIGHT, new Skill(skillID, level, flagged)).level;
    }


    public int getIntimidateRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_INTIMIDATE, new Skill(skillID, level, flagged)).level;
    }

    public int getIntimidateLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_INTIMIDATE, new Skill(skillID, level, flagged)).level;
    }


    public int getPersuadeRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_PERSUADE, new Skill(skillID, level, flagged)).level;
    }

    public int getPersuadeLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_PERSUADE, new Skill(skillID, level, flagged)).level;
    }


    public int getInvestigateRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_INVESTIGATE, new Skill(skillID, level, flagged)).level;
    }

    public int getInvestigateLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_INVESTIGATE, new Skill(skillID, level, flagged)).level;
    }


    public int getKnowledgeRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_KNOWLEDGE, new Skill(skillID, level, flagged)).level;
    }

    public int getKnowledgeLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_KNOWLEDGE, new Skill(skillID, level, flagged)).level;
    }


    public int getMedicineRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_MEDICINE, new Skill(skillID, level, flagged)).level;
    }

    public int getMedicineLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_MEDICINE, new Skill(skillID, level, flagged)).level;
    }


    public int getSurvivalRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_SURVIVAL, new Skill(skillID, level, flagged)).level;
    }

    public int getSurvivalLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_SURVIVAL, new Skill(skillID, level, flagged)).level;
    }


    public int getTechnicalRating() {
        return this.skills.getOrDefault(Constants.KNOWN_ID_SKILL_TECHNICAL, new Skill(skillID, level, flagged)).level;
    }

    public int getTechnicalLevel() {
        return this.skillsLevel.getOrDefault(Constants.KNOWN_ID_SKILL_TECHNICAL, new Skill(skillID, level, flagged)).level;
    }


}
