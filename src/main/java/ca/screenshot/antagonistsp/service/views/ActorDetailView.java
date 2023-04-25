package ca.screenshot.antagonistsp.service.views;

import java.util.List;

public class ActorDetailView {
    public String id;
    public String displayName;
    public SourceOfPowerListing sourceOfPower;
    public Attributes attributes;

    public List<PowerByMastery> powers;
    public Skills skills;
    public Skills skillsLevel;
    public Modifier modifierAge;
    public Modifier modifierSize;
    public Modifier handiness;
    public List<Modifier> quirksTalents;
    public List<Modifier> quirksFlaws;
    public List<Modifier> characterDescriptors;

    public int totalCost;
}
