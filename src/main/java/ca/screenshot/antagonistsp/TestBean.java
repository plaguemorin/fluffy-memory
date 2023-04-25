package ca.screenshot.antagonistsp;

import ca.screenshot.antagonistsp.entity.*;
import ca.screenshot.antagonistsp.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestBean {
    private static final Logger log = LoggerFactory.getLogger(TestBean.class);
    private Descriptors descriptorsRepository;
    private Categories categoriesRepository;
    private Actors actorsRepository;
    private SourceOfPowers sourceOfPowersRepository;
    private Masteries masteriesRepository;
    private MasteryPowers masteryPowersRepository;

    private static <T> Set<T> newHashSet(T... objs) {
        Set<T> set = new HashSet<>(objs.length);
        Collections.addAll(set, objs);
        return set;
    }

    private static <T> Set<T> combine(Set<T>... sets) {
        Set<T> set = new HashSet<>();
        for (Set<T> ts : sets) {
            set.addAll(ts);
        }
        return set;
    }

    public void setItemsRepository(Descriptors descriptorsRepository) {
        this.descriptorsRepository = descriptorsRepository;
    }

    public void setCategoriesRepository(Categories categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public void setActorsRepository(Actors actorsRepository) {
        this.actorsRepository = actorsRepository;
    }

    public void setSourceOfPowersRepository(SourceOfPowers sourceOfPowersRepository) {
        this.sourceOfPowersRepository = sourceOfPowersRepository;
    }

    public void setMasteriesRepository(Masteries masteriesRepository) {
        this.masteriesRepository = masteriesRepository;
    }

    public void setMasteryPowersRepository(MasteryPowers masteryPowersRepository) {
        this.masteryPowersRepository = masteryPowersRepository;
    }

    public void execute() {
        actorsRepository.deleteAll();
        descriptorsRepository.deleteAll();
        categoriesRepository.deleteAll();
        sourceOfPowersRepository.deleteAll();
        masteriesRepository.deleteAll();

        masteriesRepository.save(new Mastery("ac0ebf87-afb6-44d8-b55c-bd205266b010", "Animalism", Mastery.Type.MAJOR, Stream.of(
                new MasteryPower("400aa4af-2636-40fc-855a-fce419bb4cff", 1, "Speak With Creatures", MasteryPower.Obviousness.HIGH, MasteryPower.Range.VOICE),
                new MasteryPower("bb30283b-da02-4b47-b757-c824d680a48e", 1, "Beast Affinity", MasteryPower.Obviousness.LOW, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("0f1a277c-565a-46c0-8e49-0af59416acee", 2, "Call Beasts", MasteryPower.Obviousness.HIGH, MasteryPower.Range.VOICE),
                new MasteryPower("4f5069df-8c34-4740-8996-8d78594662f1", 3, "Bind with a Beast", MasteryPower.Obviousness.LOW, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("b1b757a6-ab76-4570-9f4f-82a52232755b", 4, "Merge into a Beast", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("1f5dee82-a8ee-4eaa-874b-cfc67ae19f08", 5, "Alpha", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.LINE_OF_SIGHT)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("a9060482-f630-48f1-a6e6-989f1f2589fb", "Mind Control", Mastery.Type.MAJOR, Stream.of(
                new MasteryPower("3bf4cf06-e4e7-4237-bfb6-ebb7020e0897", 1, "Forget", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.TOUCH),
                new MasteryPower("3edb2f28-31c1-492d-a56d-601323d1f22a", 1, "Insomnia", MasteryPower.Obviousness.LOW, MasteryPower.Range.TOUCH),
                new MasteryPower("59f9d2eb-f81b-4ef7-a2ff-bdc5cccfbcdd", 1, "Break the Weak", MasteryPower.Obviousness.HIGH, MasteryPower.Range.VOICE, MasteryPower.Duration.WEEK),
                new MasteryPower("807fb29e-610f-4787-a2fd-e378b8576dde", 2, "Close the Mind", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.TOUCH, MasteryPower.Duration.SCENE),
                new MasteryPower("e05d8494-cb05-4372-8d6a-48cb7a284d20", 2, "A Little Push", MasteryPower.Obviousness.HIGH, MasteryPower.Range.VOICE, MasteryPower.Duration.ROUND),
                new MasteryPower("a71b1a9d-ce80-4d36-b32f-bdee6f5ea50b", 3, "Command the Weak", MasteryPower.Obviousness.HIGH, MasteryPower.Range.VOICE, MasteryPower.Duration.ROUND),
                new MasteryPower("5a9b5d29-ac5a-4d3f-b67b-ded9549f3e18", 3, "Read Memory", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("8dd9c793-fa9d-48c7-8e9d-eb7d9db67f3e", 3, "Trap Mind", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH, MasteryPower.Duration.PERMANENT),
                new MasteryPower("5f631c25-fc97-4c3a-a853-bababcca3b79", 3, "Remember", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("d0c137ef-2c2d-4a1b-8192-c3382c5583cc", 4, "Open the Mind", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH, MasteryPower.Duration.PERMANENT),
                new MasteryPower("f32a7d0a-7ff7-45f6-b2c6-4037acd475a3", 4, "Summon the Mindless", MasteryPower.Obviousness.LOW, MasteryPower.Range.SPECIAL),
                new MasteryPower("0f8a7e0d-63b7-4e5c-ae30-44a1344bcf60", 5, "Alter Memories", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH, MasteryPower.Duration.PERMANENT),
                new MasteryPower("73caa402-4137-4ee9-9d31-577946ddbab0", 5, "Corruption", MasteryPower.Obviousness.HIGH, MasteryPower.Range.VOICE, MasteryPower.Duration.PERMANENT)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("05866b4f-38e3-4add-b134-86fa15f1b7c7", "Metamorphosis", Mastery.Type.MAJOR, Stream.of(
                new MasteryPower("e68fd64f-d34a-46cc-a250-522441361f92", 1, "Faceless Man", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SELF, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("40c0426e-60e8-4305-aaa6-a3cc05f3fe7c", 2, "Change Size", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SELF, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("8b1a1aed-13c0-4237-95b7-2e956c1fe4ac", 3, "The Dark Half", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SELF, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("1b5fd277-804a-48d4-bbee-3b3d0af70bb8", 4, "Body Ivory", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SELF, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("b9e5d239-d97d-4165-b3d8-356ee4425ccb", 5, "Monstrous Form", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SELF, MasteryPower.Duration.PERMANENT)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("60f77f5e-6c61-4e2c-92ed-0b1f2922e05c", "Thanatology", Mastery.Type.MAJOR, Stream.of(
                new MasteryPower("21b045ce-ea8f-4556-b404-161792ef2484", 1, "Chemicals", MasteryPower.Obviousness.LOW, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("772716e4-d57c-4382-81da-cd48d85c3f70", 1, "Dead Eye", MasteryPower.Obviousness.LOW, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("57f46091-a810-4275-9648-53a9c7927bd4", 1, "Move Wounds", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.TOUCH),
                new MasteryPower("f7530509-42c1-4e1d-b977-e058c7abc5e0", 1, "Preservation", MasteryPower.Obviousness.LOW, MasteryPower.Range.TOUCH),
                new MasteryPower("d32c16e2-7517-4f84-841d-28f137995442", 1, "Rigor Mortis", MasteryPower.Obviousness.LOW, MasteryPower.Range.SELF, MasteryPower.Duration.PERMANENT),
                new MasteryPower("5a903c40-6070-4fc1-96ab-d540d94f836f", 2, "Transfer Wounds", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.TOUCH),
                new MasteryPower("ed6a95e4-b4e1-43b9-a9e0-57ecc32aa10c", 2, "Dead Memory", MasteryPower.Obviousness.LOW, MasteryPower.Range.TOUCH),
                new MasteryPower("c8c6dfe3-a1bf-4a36-aa0d-9940d8be3c04", 2, "Command Corpse", MasteryPower.Obviousness.HIGH, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("978645a6-fad8-41f0-b6a9-44521275de7f", 2, "Destroy Corpse", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("7017958a-1e6c-4655-8f9f-9ebf8748f865", 3, "Absorb Defection", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("41f804fb-8956-459c-9f7f-01caab2220be", 3, "Corpse Explosion", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("65ec4fb4-c0e7-416c-b3b9-89b8a74d61d6", 4, "Shatter Bones", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("40c1a7b6-7201-4235-801e-52e7de8c5232", 4, "Spare Parts", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("99199371-57fb-4328-99a5-e0e2abbfa989", 5, "Sharing Life", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.LINE_OF_SIGHT, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("cc5c235e-0057-46f1-94d8-4ec4cd9e4939", 5, "Black Plague", MasteryPower.Obviousness.LOW, MasteryPower.Range.TOUCH, MasteryPower.Duration.SCENE)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("afac2fb1-36c9-4e45-8b7f-1a233954bad9", "Elementalism", Mastery.Type.MAJOR, Stream.of(
                new MasteryPower("6be3660a-c2e8-49f9-a0a8-7ec6ca94feb7", 1, "Control Over Light", MasteryPower.Obviousness.VERY_HIGH, MasteryPower.Range.SELF, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("5c6ceec7-2c84-4e1b-aaa8-0d088aa5c9d4", 1, "Control Over Earth", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("b54dbbf9-c8d9-4444-959f-ab0e13f67aa6", 2, "Control Over Water", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.LINE_OF_SIGHT, MasteryPower.Duration.SUSTAIN_QUICK_ACTION),
                new MasteryPower("6e6ddda1-935b-4020-a3dc-58e061fc2291", 2, "Control Over Plants", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.TOUCH),
                new MasteryPower("df408128-779c-4e0f-90ae-d64813c2150d", 2, "Control Over Body", MasteryPower.Obviousness.LOW, MasteryPower.Range.SELF),
                new MasteryPower("9b77c1db-050a-4936-9252-6eaa80f55ad6", 3, "Control Over Air", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.TOUCH, MasteryPower.Duration.SUSTAIN_QUICK_ACTION),
                new MasteryPower("89129adc-065f-418f-b3c1-3aa112b96e61", 4, "Control Over Fire", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SHORT, MasteryPower.Duration.SUSTAIN_QUICK_ACTION),
                new MasteryPower("e7d75011-a073-48c8-8f5c-bd7d5d7f4100", 5, "Control Over Tectonic Plates", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SPECIAL, MasteryPower.Duration.ROUND)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("ecde40c8-2941-44a9-a733-6d0a27471975", "Psychometry", Mastery.Type.MAJOR, Stream.of(
                new MasteryPower("5b80dc27-6ab7-4eee-afa8-abe0b5903eb4", 1, "Fragile Object", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("30424f00-245f-4370-afc6-53dd7ed4ba7d", 1, "Object Reading", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("1fb12e0d-4957-46e9-8760-4bd82b00a96d", 1, "Seal Item", MasteryPower.Obviousness.LOW, MasteryPower.Range.TOUCH),
                new MasteryPower("13f114aa-0330-4e39-81f2-e8349dc6a4de", 2, "Transmutation", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("308d6488-d98c-4d73-b3cc-6ed77649e93e", 2, "Scry", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.TOUCH),
                new MasteryPower("fcbe5ddd-db00-4a17-a5c3-ce56f5f446eb", 2, "True Meaning", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SPECIAL),
                new MasteryPower("ad694d73-6823-46da-8212-a90ad298990f", 3, "Feel the Other Side", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("a2d9be22-0e36-4cec-ab47-c595fdccc53a", 3, "Ward", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("cccec433-f2f0-4515-9415-f51d880357dc", 4, "Ghostly Object", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("b61104c9-888c-45e8-baf3-d888c857e2d8", 4, "Blacksmith", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("1e45a87e-9569-46bc-931b-7f8ecb6769dc", 5, "Hide the Stain", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("f06753fb-d2f4-4768-b48d-225daba5629e", "Lure", Mastery.Type.MAJOR, Stream.of(
                new MasteryPower("9b5cebc5-6f44-4828-ab9e-27105af68156", 1, "Repulse", MasteryPower.Obviousness.LOW, MasteryPower.Range.SHORT),
                new MasteryPower("b8888192-8c95-4b35-980e-3136d44606d1", 1, "Sadness", MasteryPower.Obviousness.LOW, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("0439f73a-4dd2-4aca-b6f7-db78f4e03846", 1, "Silence", MasteryPower.Obviousness.HIGH, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("3f4e1756-4a2e-4ff0-ad5c-1b358845368b", 1, "Laugh of Madness", MasteryPower.Obviousness.HIGH, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("d4aeade9-6b23-4d5e-a22b-9de5f731dad6", 2, "Awe", MasteryPower.Obviousness.LOW, MasteryPower.Range.SHORT),
                new MasteryPower("d88ea25a-f24d-49ff-ac63-5339d924d6ef", 2, "Fatal Attraction", MasteryPower.Obviousness.LOW, MasteryPower.Range.UNLIMITED),
                new MasteryPower("4a57c26b-520e-4c7f-8f8e-b8f29190a9ad", 2, "Curse", MasteryPower.Obviousness.LOW, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("bf8e087c-43ca-4e22-b1e7-e4dc809572d6", 2, "Body Reading", MasteryPower.Obviousness.LOW, MasteryPower.Range.TOUCH),
                new MasteryPower("6095e95a-0ea4-4674-95af-25ca0acd391f", 3, "Hysteria", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("e8ebf393-1688-4447-9909-e6b57160d2d8", 3, "Object of Desire", MasteryPower.Obviousness.LOW, MasteryPower.Range.TOUCH),
                new MasteryPower("fea91b61-8759-49bb-8211-233370fca652", 3, "Mirror Emotion", MasteryPower.Obviousness.LOW, MasteryPower.Range.SELF),
                new MasteryPower("1c60baaa-a3b4-4d4a-a037-12b3ef9621d1", 3, "Sleep", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.TOUCH),
                new MasteryPower("6042697e-989c-484c-8004-d2be274d631a", 3, "Witch’s Curse", MasteryPower.Obviousness.LOW, MasteryPower.Range.TOUCH),
                new MasteryPower("8daa45ed-d743-495f-9dac-64d7240a98ff", 4, "Inspire", MasteryPower.Obviousness.LOW, MasteryPower.Range.SHORT, MasteryPower.Duration.SCENE),
                new MasteryPower("dcf57a5c-6848-4db1-93d1-b772b84c8087", 4, "Kiss of Death", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("b87697fc-5538-4e88-8972-e18c6fee3a39", 5, "I Heard a Rumor", MasteryPower.Obviousness.LOW, MasteryPower.Range.UNLIMITED, MasteryPower.Duration.SCENE),
                new MasteryPower("a200d55c-ee4c-49c1-8650-3ead0769f177", 5, "Song of Death", MasteryPower.Obviousness.VERY_HIGH, MasteryPower.Range.VOICE, MasteryPower.Duration.SUSTAIN_COMPLEX_ACTION)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("37ef2117-982c-4612-bc7f-ba030241f117", "Smoke and Mirrors", Mastery.Type.MAJOR, Stream.of(
                new MasteryPower("f5ced186-2777-46fb-ad15-8198136da982", 1, "Special Effects", MasteryPower.Obviousness.LOW, MasteryPower.Range.LINE_OF_SIGHT, MasteryPower.Duration.ROUND),
                new MasteryPower("3f2ebae7-6421-47dc-99dd-627f96bce236", 2, "Illusory Object", MasteryPower.Obviousness.LOW, MasteryPower.Range.LINE_OF_SIGHT, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("e9d2b89a-8d90-4803-80e4-5de749da3a4e", 3, "Theatrical Scene", MasteryPower.Obviousness.LOW, MasteryPower.Range.LINE_OF_SIGHT, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("eed10597-d324-4840-a03b-e2c62037461c", 4, "Clone", MasteryPower.Obviousness.HIGH, MasteryPower.Range.LINE_OF_SIGHT, MasteryPower.Duration.SUSTAIN_QUICK_ACTION),
                new MasteryPower("fef9225b-e887-4784-8c32-9a47832bd265", 5, "Monstrous Illusion", MasteryPower.Obviousness.LOW, MasteryPower.Range.SPECIAL, MasteryPower.Duration.ENCOUNTER)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("7d01206c-d9e7-4eef-9eb6-f0e969daf74e", "Flesh Craft", Mastery.Type.MAJOR, Stream.of(
                new MasteryPower("551531ff-1b11-4eac-8170-6344bf0bbffa", 1, "Flesh Crafting 1", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SHORT, 5),
                new MasteryPower("e164dfa4-a8cf-4fe1-b906-f3c68dfd37c4", 2, "Flesh Crafting 2", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SHORT, 10),
                new MasteryPower("7c73c12f-e6ee-4aca-94af-a8b1635cd392", 3, "Flesh Crafting 3", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SHORT, 15),
                new MasteryPower("6aa1cd3f-a27c-45d2-9667-21cd0ce13197", 4, "Flesh Crafting 4", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SHORT, 20),
                new MasteryPower("0c9a7d59-8e4e-4b38-ba4a-f66e1cc171f1", 5, "Flesh Crafting 5", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SHORT, 25)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("4cbbb5c3-850f-483b-8916-e42c962dd6f8", "Thorn", Mastery.Type.MAJOR, Stream.of(
                new MasteryPower("20335206-ffed-479e-82cf-65503b3f25fd", 1, "Grow Red Vines", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SHORT),
                new MasteryPower("8506e1b6-eeb7-46a1-a2e8-48ceabdd51c4", 1, "Ram", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SHORT),
                new MasteryPower("7fce66fe-d749-4a5f-a5ad-db18524c290a", 2, "Entangle", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SHORT),
                new MasteryPower("f5f3bbc0-a338-4950-86f7-274850812cf1", 2, "Hide in Vines", MasteryPower.Obviousness.HIGH, MasteryPower.Range.TOUCH),
                new MasteryPower("f445f3ba-e4c8-4979-abd3-d7950b99049f", 2, "Poison Ivy", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.SELF),
                new MasteryPower("fe6fd60d-52fb-45d9-941e-419e6e2eb668", 3, "Shelter of Vines", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SHORT),
                new MasteryPower("3cea2e68-f9cb-4fae-bc4e-49e9f412acb3", 3, "Tunnelling", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SHORT),
                new MasteryPower("5f537efa-c9b1-45a0-89de-e56dd8704be8", 4, "Grow Back", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SELF),
                new MasteryPower("d2122110-f889-4648-8966-3be1403e938b", 5, "Wall of Vines", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SHORT)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("dd346a4e-d53a-467c-b168-412d94d0582f", "Unfold", Mastery.Type.MAJOR, Stream.of(
                new MasteryPower("832eeff9-207d-4327-8a95-f9fa824cede6", 1, "Citizen of the Gloom", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.SPECIAL),
                new MasteryPower("164d2df9-a3a1-4c52-a28c-d27593d2280e", 1, "Feel the Gloom", MasteryPower.Obviousness.LOW, MasteryPower.Range.SELF),
                new MasteryPower("c875c326-fbfe-4e47-a58f-1b59ec238692", 1, "Hide in the Gloom", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SELF),
                new MasteryPower("42b26db1-3b0c-44f0-91b9-10e748cc361b", 2, "Walk the Gloom", MasteryPower.Obviousness.LOW, MasteryPower.Range.SELF),
                new MasteryPower("051ac646-f4b1-4961-8b31-74f703d38abf", 3, "Repulse the Gloom", MasteryPower.Obviousness.LOW, MasteryPower.Range.SPECIAL, MasteryPower.Duration.WEEK),
                new MasteryPower("37a91c73-35fe-45d8-be98-d48dd35efa3d", 3, "The Whisperer in the Gloom", MasteryPower.Obviousness.LOW, MasteryPower.Range.SELF),
                new MasteryPower("1c2222fc-0c36-422d-bc18-ffb9382c1059", 4, "Tear Off the Gloom", MasteryPower.Obviousness.LOW, MasteryPower.Range.CLOSE),
                new MasteryPower("9be4004e-449c-41ab-b9eb-cb3de5f61556", 5, "Banish", MasteryPower.Obviousness.LOW, MasteryPower.Range.LINE_OF_SIGHT, MasteryPower.Duration.ENCOUNTER)
        ).collect(Collectors.toSet())));


        masteriesRepository.save(new Mastery("04186931-4502-4ebf-92f0-8ab2cb8820d7", "Dream Weaver", Mastery.Type.MINOR, Stream.of(
                new MasteryPower("18214bf0-1b9b-4ca5-89e2-784892c7947b", 1, "Enter Dream", MasteryPower.Obviousness.LOW, MasteryPower.Range.SHORT),
                new MasteryPower("8e7694a0-276a-4447-a064-e8dad1a50838", 2, "Circle of Dreamers", MasteryPower.Obviousness.LOW, MasteryPower.Range.SHORT),
                new MasteryPower("f3d386d1-b7b0-4951-8a2b-408b7434a121", 2, "Healing Dream", MasteryPower.Obviousness.LOW, MasteryPower.Range.SPECIAL),
                new MasteryPower("ca941f06-cba3-4c8d-8b46-208d5a6bd6a9", 2, "Sleepwalker", MasteryPower.Obviousness.LOW, MasteryPower.Range.DREAM),
                new MasteryPower("e39729dc-44ba-4422-ad53-56bb698d179d", 2, "Sweet Dream", MasteryPower.Obviousness.LOW, MasteryPower.Range.DREAM),
                new MasteryPower("5d8a774a-8259-4c58-b7d3-f879ed53ecfa", 3, "Krueger’s Effect", MasteryPower.Obviousness.LOW, MasteryPower.Range.DREAM),
                new MasteryPower("455ed7c6-a982-4aec-9f92-3b3b4e267ce2", 3, "Never Ending Dream", MasteryPower.Obviousness.LOW, MasteryPower.Range.DREAM),
                new MasteryPower("9a6fbf82-455b-4d50-b613-0eddf1a11998", 3, "Nightmarish", MasteryPower.Obviousness.LOW, MasteryPower.Range.DREAM)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("6d6cd004-c958-4dba-b145-77c7d57949b5", "Seer", Mastery.Type.MINOR, Stream.of(
                new MasteryPower("93e6049b-d5d0-4f70-96a6-4d5dde42f01d", 1, "Altering Aura", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("a28b349a-4123-4320-a406-57d7b8c91fb8", 1, "Detect the Supernatural", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SELF, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("33ee75be-73fa-4b08-b449-2cccd637a5bf", 1, "Piggyback", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SELF, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("d58b5ffa-ab28-42e3-8364-4ca0ee3a513b", 2, "Aura Reading", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SPECIAL),
                new MasteryPower("4c1fda38-44d8-443a-b376-7a099faedec5", 2, "Direction", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SPECIAL),
                new MasteryPower("e9f321e4-80f9-4b37-bb03-ad623d6b6c13", 2, "Tongues of fire", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SELF),
                new MasteryPower("8fd18695-e7e3-4ded-8f76-14b27303a7a2", 3, "Astral Projection", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SPECIAL, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("10db3bb5-667b-4e3b-84ec-541fdefd38f0", 4, "See the Future", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SPECIAL)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("93a9a8bf-59e9-47c9-9b47-e99427386503", "Storm Chaser", Mastery.Type.MINOR, Stream.of(
                new MasteryPower("caab51de-9b32-4391-bd7d-77e05a9b1dae", 1, "Change Weather", MasteryPower.Obviousness.LOW, MasteryPower.Range.LONG, MasteryPower.Duration.SCENE),
                new MasteryPower("914312bb-317f-4897-856b-2182cc5da6bc", 2, "Obscure the Sun", MasteryPower.Obviousness.HIGH, MasteryPower.Range.LONG, MasteryPower.Duration.SCENE),
                new MasteryPower("a3cda2f4-415f-4f91-a64a-ff32fa2aa87f", 3, "Storm", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.MEDIUM, MasteryPower.Duration.SCENE),
                new MasteryPower("1902b8f0-88a3-4c81-9624-91872bffc47c", 3, "Strong Wind", MasteryPower.Obviousness.LOW, MasteryPower.Range.LONG, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("e4efbbd3-5742-4f0e-8d6e-9717e2cfa77f", 4, "Electric Storm", MasteryPower.Obviousness.HIGH, MasteryPower.Range.MEDIUM, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("a491c3aa-56cd-4e2b-815e-e55394cafa35", 5, "Tornado", MasteryPower.Obviousness.HIGH, MasteryPower.Range.MEDIUM, MasteryPower.Duration.ENCOUNTER)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("83661661-49d1-49df-98c0-d307c3c70d19", "Telekinesis", Mastery.Type.MINOR, Stream.of(
                new MasteryPower("59c4861e-5cb8-4ead-83af-9481272ba548", 1, "Quick Move", MasteryPower.Obviousness.LOW, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("d0fc0ddb-3374-4749-98f6-af3881fd63fc", 2, "Defy Gravity", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("a7a52e1c-05a9-4155-a03e-2272f50e27de", 2, "Move Object", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("7a82b3ed-a8a4-4550-8c67-32930232b73f", 3, "Deadly Projectile", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.LINE_OF_SIGHT),
                new MasteryPower("4765c165-96fe-4c20-9e52-d41c459d094a", 3, "Deflect Projectiles", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.SHORT, MasteryPower.Duration.ROUND),
                new MasteryPower("fcd3ae6d-123a-4877-954c-5130564d4076", 3, "Scream", MasteryPower.Obviousness.HIGH, MasteryPower.Range.SHORT),
                new MasteryPower("21e4be1e-4805-4ac3-9fb6-0e0c75364418", 4, "Levitate", MasteryPower.Obviousness.MEDIUM, MasteryPower.Range.LINE_OF_SIGHT, MasteryPower.Duration.SUSTAIN_COMPLEX_ACTION),
                new MasteryPower("92c8e56c-517d-40a3-bc1a-f0b003cb18da", 5, "Remove Action", MasteryPower.Obviousness.HIGH, MasteryPower.Range.LINE_OF_SIGHT)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("fc84509e-4d2f-4ff3-bb18-4058776e1ce9", "Toxin-Breather", Mastery.Type.MINOR, Stream.of(
                new MasteryPower("8e2ee8c5-e6ad-4143-8da5-a97dc79a821e", 1, "Toxin-Breather 1", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF, 5),
                new MasteryPower("5dbf9d20-f2e5-4e88-92d0-2673b1dd416a", 2, "Toxin-Breather 2", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF, 10),
                new MasteryPower("5f033790-798c-4061-a4c2-938915658040", 3, "Toxin-Breather 3", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF, 15),
                new MasteryPower("c74bb99c-33e4-4583-ad89-00cf8f48160a", 4, "Toxin-Breather 4", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF, 20),
                new MasteryPower("7c314e36-04ac-4386-9581-03bb0c04d0c3", 5, "Toxin-Breather 5", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF, 25)
        ).collect(Collectors.toSet())));


        masteriesRepository.save(new Mastery("afcbcfc4-a92a-44c7-bb06-0e89b02f70cb", "Belligerent", Mastery.Type.SPECIALIZE, Stream.of(
                new MasteryPower("410897c7-d3da-4207-bfb2-37ac31112ecf", 1, "Charge", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("b520b21c-74f4-4023-bf2f-5950705e71c7", 1, "Death from Above", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("efe0db5c-9ce1-4717-bacf-71ef60cc1aa8", 1, "Grab Weapon", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("467b31b7-99a8-4203-abd3-744184683dd0", 1, "Lock and Choke", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("969f263f-cf9c-4953-ab3b-25efe44cdef7", 1, "No Pain no Gain", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("40337628-ec7f-4718-aa0f-13163906e6e2", 1, "Pin Down", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("ae455df4-88e4-4d45-8b70-5deae556410a", 1, "Sweep Attack", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("cb566260-bf7e-46fc-90bf-2b152adaac84", 1, "Throw Opponent", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("27e062ff-a2da-43c1-adc2-352ac42e6db4", 1, "Will to Survive", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("b467c4fe-9e19-4b6a-8813-28f658a7b183", "Combat Tactician", Mastery.Type.SPECIALIZE, Stream.of(
                new MasteryPower("a6fd16fd-5c88-4a40-bd65-05b5d3bdd31a", 1, "Artillery Officer", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF, MasteryPower.Duration.ENCOUNTER),
                new MasteryPower("628c6b19-e1c7-4cb2-a15c-763d2bfa4bf0", 1, "Flanking", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("4d963c28-1048-49a5-9482-f936a0e77516", 1, "Quick Reload", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("f7f2a9f4-c246-4598-840f-2e39f057b00a", 2, "Firearm Expert", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("f529c9ce-30f8-4403-95b1-20b2fe6489ed", 2, "Pack Tactic", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("dfddc450-cd9d-4d1e-99cd-341008b22765", 2, "Projectile Expert", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("9b3f780c-dc79-4ab1-873c-0eec1817554b", 2, "Weapon Expert", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("b68fd9b4-ab02-41da-9974-ad43ee42b527", 3, "Sniper", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("82b8469a-8e02-469f-a839-173ca0db50f6", "Erudite", Mastery.Type.SPECIALIZE, Stream.of(
                new MasteryPower("a7952ae0-6d62-4b75-8814-91ea9a99a7fd", 1, "Brewmaster", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("a15d14d6-e7ee-4787-91ed-101b2099efcd", 1, "Botanist", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("7b4b8a43-8f38-48c5-9aeb-4283761882b9", 1, "Demolition Worker", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("f765b2c0-0beb-4013-bf1c-bde4b3b36083", 1, "Nurse", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("b7eccf2d-3d5a-44ef-900c-75b38f1a916d", 1, "Nuclear Technician", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("8b4efb97-d504-43d4-b69e-98b627dfc8ec", 1, "Veterinary", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("e34d005a-c7bf-40fb-b439-315b11a611ef", 2, "Chemist", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("fbe002f4-21b6-43b4-8da9-f97eb0400ea9", 2, "Master Electrician", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("f486c81a-5932-4a29-bc85-b46577f9eac8", 2, "Mechanics", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("5e2e18fa-39fd-4a9f-87cf-6affb765e5cc", 2, "Pilot", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("11d56e25-7548-4e74-bf90-118cf2006f4e", 2, "Trapper", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("44351042-16ab-493d-a548-106f3abd84b2", 3, "Surgeon", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("1269f116-23a0-4425-978d-8cf9afd6a6ba", "Magnate", Mastery.Type.SPECIALIZE, Stream.of(
                new MasteryPower("7aba27f0-5667-4a42-840c-e86a461934f2", 1, "Animal Trainer", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("9dd60176-3000-4d45-bed5-5ae49599ac31", 1, "Intimidatior", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("7f1080db-ddf0-4bd5-9a4d-e3fbd28d587d", 1, "Leader", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("6a7f2519-15a3-4ba4-ad2b-b9b7dff49385", 1, "Provoker", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("92e2ad8e-374f-485a-bc3b-152bcb2da3a2", 1, "Sex Machine", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("38646ccf-cbb3-40ce-8024-5aecb1cbac77", 2, "Negociator", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("2565c0a5-2b49-4ad9-8f81-3df0f7e4a4ca", "Scoundrel", Mastery.Type.SPECIALIZE, Stream.of(
                new MasteryPower("1a1180c4-b5ce-411a-9a13-9471902f6552", 1, "Cheater", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("4bf4b571-d1fa-40ef-a304-1ba2c4a83192", 1, "Damage Weapon", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("c2fb0e55-370f-4be5-8983-93b1f9824885", 1, "Dirty Trick", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("185dd15a-f90c-4116-84b2-a51b4eb53c0c", 1, "Hacker", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("3c309c6d-e02c-4a7c-97e4-536f035ea3af", 1, "Master of Disguise", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("040331e0-2895-4bb2-9e0a-acca0a85eeb3", 1, "Safe Cracker", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("d8c32231-1c88-4f63-976f-72145cc621c4", 1, "Sucker Punch", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE),
                new MasteryPower("1c026cb2-4eaf-4553-a239-3e85130a7dda", 1, "Vicious Backstab", MasteryPower.Obviousness.NONE, MasteryPower.Range.CLOSE)
        ).collect(Collectors.toSet())));
        masteriesRepository.save(new Mastery("f92b8299-35dc-49aa-86c7-3a99713b9b43", "Traceur", Mastery.Type.SPECIALIZE, Stream.of(
                new MasteryPower("ceb95031-9e54-4872-9f8a-14796e366e0d", 1, "Acrobatic Move", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("713caf44-6208-4138-85d3-a61d7e56865b", 1, "Arise", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("5b98f0e5-1d75-464e-9bdf-aef70bb72ff8", 1, "Catch and Throw", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("9c17ec3d-6a05-466b-a9d1-d17716291bc3", 1, "Light Step", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("f8f5c913-f1bf-4ae6-9513-3ab3c6233700", 1, "Pack Rat", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("06ec67af-597e-462a-bcfe-6c494355dd1c", 1, "Parkour", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("980d6977-eaf0-4b5c-bc5a-672bdcd3a8ae", 1, "Rope Tricks", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("c7e8812a-1421-4a25-931b-2491f6ebaf76", 1, "Tightrope Walking", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("290b9ffe-dc95-412a-b8d6-596cc8e2478c", 2, "Endurance", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("521f8a6e-2033-4921-aae0-a1fa73987d95", 2, "Gecko Crawl", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("eea71ba6-4684-4b44-9199-b05184e1d40c", 2, "Traveller", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF),
                new MasteryPower("033639d0-39e7-4761-819e-59c3c6db00d4", 2, "Wall Running", MasteryPower.Obviousness.NONE, MasteryPower.Range.SELF)
        ).collect(Collectors.toSet())));

        Set<MasteryPower> allSpecializations = masteryPowersRepository.findAllByParentTypeIs(Mastery.Type.SPECIALIZE);
        Set<MasteryPower> allMinorsMasteries = masteryPowersRepository.findAllByParentTypeIs(Mastery.Type.MINOR);

        SourceOfPower childOfGaia = new SourceOfPower("94e30b70-9e65-436e-8671-bf92a716dba6", "Child of Gaia", Stream.of(
                new SourceOfPowerMasteryGroup(allSpecializations),
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Storm Chaser")),
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Elementalism"))
        ).collect(Collectors.toSet()));
        sourceOfPowersRepository.save(childOfGaia);

        sourceOfPowersRepository.save(new SourceOfPower("c1ade2ac-8b07-4bbd-b5d4-e03547301461", "Clairtangent", Stream.of(
                new SourceOfPowerMasteryGroup(allSpecializations),
                new SourceOfPowerMasteryGroup(combine(
                        masteryPowersRepository.findAllByParentName("Telekinesis"),
                        masteryPowersRepository.findAllByParentName("Toxin-Breather")
                )),
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Psychometry"))
        ).collect(Collectors.toSet())));

        sourceOfPowersRepository.save(new SourceOfPower("a4d113fb-423e-4bd1-a91f-cad49754fe01", "Creeper", Stream.of(
                new SourceOfPowerMasteryGroup(allSpecializations),
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Belligerent")),
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Thorn"))
        ).collect(Collectors.toSet())));

        sourceOfPowersRepository.save(new SourceOfPower("4d7e8973-a2af-4442-ad7a-ec5a6c5b6c5d", "Mortician", Stream.of(
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Erudite")),
                new SourceOfPowerMasteryGroup(combine(
                        allSpecializations,
                        masteryPowersRepository.findAllByParentName("Telekinesis"),
                        masteryPowersRepository.findAllByParentName("Toxin-Breather")
                )),
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Thanatology"))
        ).collect(Collectors.toSet())));

        sourceOfPowersRepository.save(new SourceOfPower("42685a21-60f5-4bef-8b02-7855c5bad009", "Primalist", Stream.of(
                new SourceOfPowerMasteryGroup(allSpecializations),
                new SourceOfPowerMasteryGroup(combine(
                        masteryPowersRepository.findAllByParentName("Storm Chaser"),
                        masteryPowersRepository.findAllByParentName("Seer"),
                        allSpecializations
                )),
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Animalism"))
        ).collect(Collectors.toSet())));

        sourceOfPowersRepository.save(new SourceOfPower("b4f937ad-5676-4074-9dbc-77053580f3bb", "Puppeteer", Stream.of(
                new SourceOfPowerMasteryGroup(allSpecializations),
                new SourceOfPowerMasteryGroup(allMinorsMasteries),
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Mind Control"))
        ).collect(Collectors.toSet())));

        sourceOfPowersRepository.save(new SourceOfPower("9669f7fd-0d59-4fb0-b809-4f2867102329", "Succubus", Stream.of(
                new SourceOfPowerMasteryGroup(allSpecializations),
                new SourceOfPowerMasteryGroup(combine(
                        allSpecializations,
                        masteryPowersRepository.findAllByParentName("Seer"),
                        masteryPowersRepository.findAllByParentName("Dream Weaver")
                )),
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Lure"))
        ).collect(Collectors.toSet())));

        sourceOfPowersRepository.save(new SourceOfPower("20e75653-0558-43e5-9b1d-772817393d6b", "Flesh Craft", Stream.of(
                new SourceOfPowerMasteryGroup(allSpecializations),
                new SourceOfPowerMasteryGroup(combine(
                        masteryPowersRepository.findAllByParentName("Toxin-Breather"),
                        allSpecializations
                )),
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Flesh Craft"))
        ).collect(Collectors.toSet())));

        sourceOfPowersRepository.save(new SourceOfPower("33b83acb-9f13-436a-8973-731689ebaf1e", "Trickster", Stream.of(
                new SourceOfPowerMasteryGroup(allSpecializations),
                new SourceOfPowerMasteryGroup(combine(
                        masteryPowersRepository.findAllByParentName("Toxin-Breather"),
                        masteryPowersRepository.findAllByParentName("Dream Weaver"),
                        masteryPowersRepository.findAllByParentName("Telekinesis")
                )),
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Smoke and Mirrors"))
        ).collect(Collectors.toSet())));

        sourceOfPowersRepository.save(new SourceOfPower("57facdce-629b-499c-8cfb-6421d177d47f", "Uncorrupted", Stream.of(
                new SourceOfPowerMasteryGroup(combine(
                        masteryPowersRepository.findAllByParentName("Toxin-Breather"),
                        allSpecializations
                ))
        ).collect(Collectors.toSet())));

        sourceOfPowersRepository.save(new SourceOfPower("8da245bb-9380-4daf-91b9-2bee3dfaf3ca", "Werebeast", Stream.of(
                new SourceOfPowerMasteryGroup(allSpecializations),
                new SourceOfPowerMasteryGroup(allSpecializations),
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Metamorphosis"))
        ).collect(Collectors.toSet())));

        sourceOfPowersRepository.save(new SourceOfPower("5e92931f-e2ac-462f-a777-494696550fc2", "World Walkers", Stream.of(
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Traceur")),
                new SourceOfPowerMasteryGroup(combine(
                        masteryPowersRepository.findAllByParentName("Telekinesis"),
                        masteryPowersRepository.findAllByParentName("Toxin-Breather"),
                        allSpecializations
                )),
                new SourceOfPowerMasteryGroup(masteryPowersRepository.findAllByParentName("Unfold"))
        ).collect(Collectors.toSet())));

        Category topCategoryAge = categoriesRepository.save(new Category(null, "Age"));
        Category topCategoryGeneral = categoriesRepository.save(new Category(null, "General Descriptors"));
        Category topCategorySize = categoriesRepository.save(new Category(null, "Size"));

        Category categoryGeneralMental = categoriesRepository.save(new Category(topCategoryGeneral, "Mental"));
        Category categoryGeneralPhysical = categoriesRepository.save(new Category(topCategoryGeneral, "Physical"));
        Category categoryGeneralSocial = categoriesRepository.save(new Category(topCategoryGeneral, "Social"));

        descriptorsRepository.saveAll(Stream.of(
                new Descriptor(topCategoryAge, "Child", -2, -1, -1, 0, 0, 0, 0, 0, -4, -4),
                new Descriptor(topCategoryAge, "Young", -1, 0, -1, 0, 0, 0, 0, 0, -2, -2),
                new Descriptor(topCategoryAge, "Adult", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(topCategoryAge, "Mature", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                new Descriptor(topCategoryAge, "Old", 0, 0, -1, 0, 0, 0, 1, 0, -1, 0),
                new Descriptor(topCategoryAge, "Senior", 1, 0, -1, 0, 0, 0, 2, 0, -1, -2),
                new Descriptor(topCategoryAge, "Venerable", -1, -1, -1, 0, 0, 0, 1, 0, -1, -2),
                new Descriptor(topCategorySize, "Small", 0, 0, -1, 0, 0, 0, 0, 0, -2, -2),
                new Descriptor(topCategorySize, "Short", -1, 0, -1, 0, 0, 0, 0, 0, 0, -1),
                new Descriptor(topCategorySize, "Medium", 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(topCategorySize, "High", 1, 0, 1, 0, 0, 0, 0, 0, 1, 1),
                new Descriptor(topCategorySize, "Large", 2, 2, 0, 0, 0, 0, 0, 0, 1, 2),
                new Descriptor(topCategorySize, "Tall", 1, 0, 1, 0, 0, 0, 0, 0, 2, 2),
                new Descriptor(topCategorySize, "Well-Built", 3, 1, 2, 0, 0, 0, 0, 0, 2, 2),
                new Descriptor(topCategorySize, "Very Tall", 2, 1, 1, 0, 0, 0, 0, 0, 3, 3),
                new Descriptor(topCategorySize, "Giant", 1, 2, 1, -2, 0, 0, 0, 0, 4, 4),
                new Descriptor(topCategorySize, "Gigantic", 2, 3, 1, -2, 0, 0, 0, 0, 5, 5),
                new Descriptor(categoryGeneralPhysical, "Acute Hearing", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Acute Taste and Smell", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Acute Vision", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Agile", 2, 0, 0, 2, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Athletic", 2, 0, 1, 0, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Attractive Appearance", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Awkward", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Back Pain", -3, 0, -1, -1, 0, -1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Bad Sight", -2, 0, 0, 0, -2, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Balanced Step", 2, 0, 0, 1, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Bald", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Beautiful", 2, 0, 0, 0, 0, 0, 0, 2, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Catlike", 2, 0, 0, 2, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Chubby", -1, 0, 0, -1, 0, 0, 0, 0, 0, 1),
                new Descriptor(categoryGeneralPhysical, "Clumsy", -1, 0, 0, -1, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Crude", -2, 0, 0, -1, 0, -1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Curvy", 0, 0, 0, 0, 0, -1, 0, 1, 0, 1),
                new Descriptor(categoryGeneralPhysical, "Deaf", -2, 0, 0, 0, -2, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Dexterous", 1, 0, 0, 1, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Double-Jointed", 1, 0, 0, 2, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Endurant", 1, 0, 1, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Energetic", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Eye-Hand Coordination", 2, 0, 0, 1, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Fast", 2, 0, 0, 1, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Fast Hands", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Fat", 0, 1, 0, 0, 0, -1, 0, 0, 0, 5),
                new Descriptor(categoryGeneralPhysical, "Fit", 2, 1, 1, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Flabby", -3, -1, -1, -1, 0, 0, 0, 0, 0, 2),
                new Descriptor(categoryGeneralPhysical, "Flexible", 3, 0, 0, 2, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Frail", -2, -1, -1, 0, 0, 0, 0, 0, 0, -2),
                new Descriptor(categoryGeneralPhysical, "Good Balance", 2, 0, 0, 1, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Hardy", 1, 0, 1, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Healthy", 1, 0, 1, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Heavy", 2, 2, 0, 0, 0, 0, 0, 0, 0, 5),
                new Descriptor(categoryGeneralPhysical, "Heavy Lifter", 1, 1, 0, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Hideous", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Inexperienced", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Injured", -1, 0, -1, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Injured Eardrum", -1, 0, 0, 0, -1, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Jogger", 1, 0, 1, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Keen-Eyed", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Lightning Fast", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Malnourished", -1, 0, -1, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Morbid Obese", -2, 2, 0, -2, 0, -2, 0, 0, 0, 20),
                new Descriptor(categoryGeneralPhysical, "Muscular", 1, 1, 0, 0, 0, 0, 0, 1, 0, 1),
                new Descriptor(categoryGeneralPhysical, "Myopic", -1, 0, 0, 0, -1, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Obese", -1, 1, 0, -1, 0, -1, 0, 0, 0, 10),
                new Descriptor(categoryGeneralPhysical, "One Eyes", -2, 0, 0, 0, -1, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Overweight", 0, 1, 0, -1, 0, 0, 0, 0, 0, 5),
                new Descriptor(categoryGeneralPhysical, "Plump", -2, 0, 0, -1, 0, -1, 0, 0, 0, 5),
                new Descriptor(categoryGeneralPhysical, "Puny", -4, -2, -2, 0, 0, 0, 0, 0, 0, -3),
                new Descriptor(categoryGeneralPhysical, "Quick", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Quick Reflexes", 2, 0, 0, 0, 0, 2, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Rickety", -4, -2, -2, 0, 0, 0, 0, 0, 0, -5),
                new Descriptor(categoryGeneralPhysical, "Scarred", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Shapely", 2, 0, 0, 2, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Sharp Shooter", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Skinny", -2, -1, -1, 0, 0, 0, 0, 0, 0, -2),
                new Descriptor(categoryGeneralPhysical, "Slender", 2, 0, 1, 1, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Slow", -1, 0, 0, 0, 0, -1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Sluggish", -3, -1, -1, 0, 0, -1, 0, 0, 0, 1),
                new Descriptor(categoryGeneralPhysical, "Smelly", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Sporty", 2, 0, 1, 1, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Sprinter", 2, 0, 1, 0, 0, 1, 0, 0, 0, 1),
                new Descriptor(categoryGeneralPhysical, "Strong", 1, 1, 0, 0, 0, 0, 0, 0, 0, 1),
                new Descriptor(categoryGeneralPhysical, "Sturdy", 2, 1, 1, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Swift", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Thick", 2, 1, 1, 0, 0, 0, 0, 0, 0, -1),
                new Descriptor(categoryGeneralPhysical, "Thin", -1, 0, -1, 0, 0, 0, 0, 0, 0, -1),
                new Descriptor(categoryGeneralPhysical, "Tone Deaf", -1, 0, 0, 0, -1, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Tough", 2, 0, 2, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Trained", 2, 1, 1, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Ugly", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Unathletic", -2, -1, -1, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Unattractive Appearance", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Uncouth", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Underfed", -3, -2, -1, 0, 0, 0, 0, 0, 0, -3),
                new Descriptor(categoryGeneralPhysical, "Underweight", -2, 0, -2, 0, 0, 0, 0, 0, 0, -1),
                new Descriptor(categoryGeneralPhysical, "Unsporty", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Unsteady Hands", -1, 0, 0, -1, 0, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Very Hairy", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralPhysical, "Weak", -1, -1, 0, 0, 0, 0, 0, 0, 0, -1),
                new Descriptor(categoryGeneralPhysical, "Wiry", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Alert", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Bright", 2, 0, 0, 0, 0, 1, 1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Brilliant", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Broadminded", 2, 0, 0, 0, 0, 0, 1, 1, 0, 0),
                new Descriptor(categoryGeneralMental, "Clever", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Confuse", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Dimwitted", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Disorganized", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Dreamy", -2, 0, 0, 0, 0, -1, -1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Dropout", 0, 1, 0, 0, 0, 0, -1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Dumb", -3, 0, 0, 0, 0, -1, -2, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Dyscalculia", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Educated", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Fast Learner", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Fast Thinker", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Focused", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Genius", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Ignorant", -2, 0, 0, 0, 0, 0, -2, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Inattentive", -1, 0, 0, 0, -1, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Instinctive", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Intellectual", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Intuitive", 2, 0, 0, 0, 0, 2, 0, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Inventive", 2, 0, 0, 0, 0, 1, 1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Logic", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Lazy", -1, 0, 0, 0, 0, -1, 0, 0, 0, 1),
                new Descriptor(categoryGeneralMental, "Methodical", 2, 0, 0, 0, 1, 0, 1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Moronic", -2, 0, 0, 0, 0, 0, -2, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Observant", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Obtuse", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Open-Minded", 2, 0, 0, 0, 0, 0, 1, 1, 0, 0),
                new Descriptor(categoryGeneralMental, "Orderly", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Perceptive", 2, 0, 0, 0, 2, 0, 0, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Sage", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Sharp", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Simple", -2, 0, 0, 0, 0, 0, -1, -1, 0, 0),
                new Descriptor(categoryGeneralMental, "Slow Learner", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Smart", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Spontaneous", 2, 0, 0, 0, 0, 1, 1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Studious", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Stupid", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Thoughtless", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Uneducated", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Unintellectual", -2, 0, 0, 0, 0, 0, -2, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Wise", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                new Descriptor(categoryGeneralMental, "Witty", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0),
                new Descriptor(categoryGeneralSocial, "Attractive", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Bon vivant", 2, 0, 0, 0, 0, 1, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Boring", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Breathtaking", 3, 0, 0, 0, 0, 0, 0, 3, 0, 0),
                new Descriptor(categoryGeneralSocial, "Caring", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Charming", 2, 0, 0, 0, 0, 0, 0, 2, 0, 0),
                new Descriptor(categoryGeneralSocial, "Charming Voice", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Cheerful", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Communicator", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Cute", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Discreet", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Disfigured", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0),
                new Descriptor(categoryGeneralSocial, "Empathic", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Entertaining", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Extrovert", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Friendly", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Fun", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Funny", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Gorgeous", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Handsome", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Introvert", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Neglectful", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Odious", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0),
                new Descriptor(categoryGeneralSocial, "Outgoing", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Personable", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Pleasant", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Pretty", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Quiet", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Repulsive", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Romantic", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Scruffy", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Sensual", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Sexy", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Shy", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Stuttering", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Sympathetic", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Trusted Face", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                new Descriptor(categoryGeneralSocial, "Ugly", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0),
                new Descriptor(categoryGeneralSocial, "Unattractive", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0),
                new Descriptor(categoryGeneralSocial, "Unkempt", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0),
                new Descriptor(categoryGeneralSocial, "Vitiligo", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0)
        ).toList());

        Actor alexTerrieur = new Actor();
        alexTerrieur.id = UUID.randomUUID();
        alexTerrieur.name = "Alex Terrieur";
        alexTerrieur.age = 33;
        alexTerrieur.ethnicity = "QC";

        alexTerrieur.addDescriptor(descriptorsRepository.findByName("Mature"));
        alexTerrieur.addDescriptor(descriptorsRepository.findByName("Quiet"));
        alexTerrieur.addDescriptor(descriptorsRepository.findByName("Fast Learner"));
        alexTerrieur.addDescriptor(descriptorsRepository.findByName("Jogger"));

        alexTerrieur.power = sourceOfPowersRepository.findByName("World Walkers");
        alexTerrieur.addPower(masteryPowersRepository.findByName("Hide in the Gloom"));
        alexTerrieur.addPower(masteryPowersRepository.findByName("Walk the Gloom"));

        actorsRepository.save(alexTerrieur);
    }
}
