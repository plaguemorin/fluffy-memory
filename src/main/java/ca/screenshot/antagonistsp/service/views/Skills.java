package ca.screenshot.antagonistsp.service.views;

import ca.screenshot.antagonistsp.Constants;

import java.util.*;

public class Skills implements Map<UUID, Skill> {
    private final Map<UUID, Skill> backingImplementation;

    public Skills() {
        backingImplementation = new HashMap<>(20);
        clear();
    }

    private void initSkills() {
        backingImplementation.put(Constants.KNOWN_ID_SKILL_ACROBATICS, new Skill(Constants.KNOWN_ID_SKILL_ACROBATICS));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_ATHLETICS, new Skill(Constants.KNOWN_ID_SKILL_ATHLETICS));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_BRUTALFIGHTING, new Skill(Constants.KNOWN_ID_SKILL_BRUTALFIGHTING));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_FINESSEFIGHTING, new Skill(Constants.KNOWN_ID_SKILL_FINESSEFIGHTING));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_MUSCULAR, new Skill(Constants.KNOWN_ID_SKILL_MUSCULAR));

        backingImplementation.put(Constants.KNOWN_ID_SKILL_DRIVE, new Skill(Constants.KNOWN_ID_SKILL_DRIVE));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_LONGARMS, new Skill(Constants.KNOWN_ID_SKILL_LONGARMS));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_SLEIGHTOFHANDS, new Skill(Constants.KNOWN_ID_SKILL_SLEIGHTOFHANDS));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_SMALLARMS, new Skill(Constants.KNOWN_ID_SKILL_SMALLARMS));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_STEALTH, new Skill(Constants.KNOWN_ID_SKILL_STEALTH));

        backingImplementation.put(Constants.KNOWN_ID_SKILL_CHARM, new Skill(Constants.KNOWN_ID_SKILL_CHARM));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_DECEPTION, new Skill(Constants.KNOWN_ID_SKILL_DECEPTION));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_INSIGHT, new Skill(Constants.KNOWN_ID_SKILL_INSIGHT));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_INTIMIDATE, new Skill(Constants.KNOWN_ID_SKILL_INTIMIDATE));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_PERSUADE, new Skill(Constants.KNOWN_ID_SKILL_PERSUADE));

        backingImplementation.put(Constants.KNOWN_ID_SKILL_INVESTIGATE, new Skill(Constants.KNOWN_ID_SKILL_INVESTIGATE));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_KNOWLEDGE, new Skill(Constants.KNOWN_ID_SKILL_KNOWLEDGE));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_MEDICINE, new Skill(Constants.KNOWN_ID_SKILL_MEDICINE));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_SURVIVAL, new Skill(Constants.KNOWN_ID_SKILL_SURVIVAL));
        backingImplementation.put(Constants.KNOWN_ID_SKILL_TECHNICAL, new Skill(Constants.KNOWN_ID_SKILL_TECHNICAL));
    }

    @Override
    public int size() {
        return backingImplementation.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        if (!(key instanceof UUID)) {
            return false;
        }

        return backingImplementation.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        if (!(value instanceof Skill)) {
            return false;
        }

        return containsKey(((Skill) value).getId());
    }

    @Override
    public Skill get(Object key) {
        return backingImplementation.get(key);
    }

    @Override
    public Skill put(UUID key, Skill value) {
        Skill i = get(key);
        if (i != null) {
            i.setAttributeTotal(value.getAttributeTotal());
            i.setFlagged(value.isFlagged());
            i.setLevel(value.getLevel());
            return i;
        }

        return null;
    }

    @Override
    public Skill remove(Object key) {
        Skill i = get(key);
        if (i != null) {
            i.setLevel(0);
            i.setAttributeTotal(0);
            i.setFlagged(false);
            return i;
        }

        return null;
    }

    @Override
    public void putAll(Map<? extends UUID, ? extends Skill> m) {
        for (Entry<? extends UUID, ? extends Skill> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        backingImplementation.clear();
        initSkills();
    }

    @Override
    public Set<UUID> keySet() {
        return backingImplementation.keySet();
    }

    @Override
    public Collection<Skill> values() {
        return backingImplementation.values();
    }

    @Override
    public Set<Entry<UUID, Skill>> entrySet() {
        return backingImplementation.entrySet();
    }

    public Collection<Skill> getActionSkills() {
        return List.of(
                getDrive(),
                getLongArms(),
                getSleightOfHands(),
                getSmallArms(),
                getStealth()
        );
    }

    public Collection<Skill> getMentalSkills() {
        return List.of(
                getInvestigate(),
                getKnowledge(),
                getMedicine(),
                getSurvival(),
                getTechnical()
        );
    }

    public Collection<Skill> getPhysicalSkills() {
        return List.of(
                getAcrobatics(),
                getAthletics(),
                getBrutalFighting(),
                getFinesseFighting(),
                getMuscular()
        );
    }

    public Collection<Skill> getSocialSkills() {
        return List.of(
                getCharm(),
                getDeception(),
                getInsight(),
                getIntimidate(),
                getPersuade()
        );
    }

    public Skill getAcrobatics() {
        return this.get(Constants.KNOWN_ID_SKILL_ACROBATICS);
    }

    public Skill getAthletics() {
        return this.get(Constants.KNOWN_ID_SKILL_ATHLETICS);
    }

    public Skill getBrutalFighting() {
        return this.get(Constants.KNOWN_ID_SKILL_BRUTALFIGHTING);
    }

    public Skill getFinesseFighting() {
        return this.get(Constants.KNOWN_ID_SKILL_FINESSEFIGHTING);
    }

    public Skill getMuscular() {
        return this.get(Constants.KNOWN_ID_SKILL_MUSCULAR);
    }

    public Skill getDrive() {
        return this.get(Constants.KNOWN_ID_SKILL_DRIVE);
    }

    public Skill getLongArms() {
        return this.get(Constants.KNOWN_ID_SKILL_LONGARMS);
    }

    public Skill getSleightOfHands() {
        return this.get(Constants.KNOWN_ID_SKILL_SLEIGHTOFHANDS);
    }

    public Skill getSmallArms() {
        return this.get(Constants.KNOWN_ID_SKILL_SMALLARMS);
    }

    public Skill getStealth() {
        return this.get(Constants.KNOWN_ID_SKILL_STEALTH);
    }

    public Skill getCharm() {
        return this.get(Constants.KNOWN_ID_SKILL_CHARM);
    }

    public Skill getDeception() {
        return this.get(Constants.KNOWN_ID_SKILL_DECEPTION);
    }

    public Skill getInsight() {
        return this.get(Constants.KNOWN_ID_SKILL_INSIGHT);
    }

    public Skill getIntimidate() {
        return this.get(Constants.KNOWN_ID_SKILL_INTIMIDATE);
    }

    public Skill getPersuade() {
        return this.get(Constants.KNOWN_ID_SKILL_PERSUADE);
    }

    public Skill getInvestigate() {
        return this.get(Constants.KNOWN_ID_SKILL_INVESTIGATE);
    }

    public Skill getKnowledge() {
        return this.get(Constants.KNOWN_ID_SKILL_KNOWLEDGE);
    }

    public Skill getMedicine() {
        return this.get(Constants.KNOWN_ID_SKILL_MEDICINE);
    }

    public Skill getSurvival() {
        return this.get(Constants.KNOWN_ID_SKILL_SURVIVAL);
    }

    public Skill getTechnical() {
        return this.get(Constants.KNOWN_ID_SKILL_TECHNICAL);
    }
}
