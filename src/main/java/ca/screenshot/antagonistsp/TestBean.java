package ca.screenshot.antagonistsp;


import ca.screenshot.antagonistsp.entities.Category;
import ca.screenshot.antagonistsp.entities.Descriptor;
import ca.screenshot.antagonistsp.repository.Actors;
import ca.screenshot.antagonistsp.repository.Categories;
import ca.screenshot.antagonistsp.repository.Descriptors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean {
    private static final Logger log = LoggerFactory.getLogger(TestBean.class);
    private Descriptors descriptorsRepository;
    private Categories categoriesRepository;
    private Actors actorsRepository;

    public void setItemsRepository(Descriptors descriptorsRepository) {
        this.descriptorsRepository = descriptorsRepository;
    }

    public void setCategoriesRepository(Categories categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public void setActorsRepository(Actors actorsRepository) {
        this.actorsRepository = actorsRepository;
    }

    public void execute() {
        categoriesRepository.deleteAll();
        descriptorsRepository.deleteAll();
        actorsRepository.deleteAll();

        Category topCategoryAge = categoriesRepository.save(new Category(null, "Age"));
        Category topCategoryGeneral = categoriesRepository.save(new Category(null, "General Descriptors"));
        Category topCategorySize = categoriesRepository.save(new Category(null, "Size"));

        Category categoryGeneralMental = categoriesRepository.save(new Category(topCategoryGeneral, "Mental"));
        Category categoryGeneralPhysical = categoriesRepository.save(new Category(topCategoryGeneral, "Physical"));
        Category categoryGeneralSocial = categoriesRepository.save(new Category(topCategoryGeneral, "Social"));

        descriptorsRepository.save(new Descriptor(topCategoryAge, "Child", -2, -1, -1, 0, 0, 0, 0, 0, -4, -4));
        descriptorsRepository.save(new Descriptor(topCategoryAge, "Young", -1, 0, -1, 0, 0, 0, 0, 0, -2, -2));
        descriptorsRepository.save(new Descriptor(topCategoryAge, "Adult", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(topCategoryAge, "Mature", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(topCategoryAge, "Old", 0, 0, -1, 0, 0, 0, 1, 0, -1, 0));
        descriptorsRepository.save(new Descriptor(topCategoryAge, "Senior", 1, 0, -1, 0, 0, 0, 2, 0, -1, -2));
        descriptorsRepository.save(new Descriptor(topCategoryAge, "Venerable", -1, -1, -1, 0, 0, 0, 1, 0, -1, -2));
        descriptorsRepository.save(new Descriptor(topCategorySize, "Small", 0, 0, -1, 0, 0, 0, 0, 0, -2, -2));
        descriptorsRepository.save(new Descriptor(topCategorySize, "Short", -1, 0, -1, 0, 0, 0, 0, 0, 0, -1));
        descriptorsRepository.save(new Descriptor(topCategorySize, "Medium", 1, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(topCategorySize, "High", 1, 0, 1, 0, 0, 0, 0, 0, 1, 1));
        descriptorsRepository.save(new Descriptor(topCategorySize, "Large", 2, 2, 0, 0, 0, 0, 0, 0, 1, 2));
        descriptorsRepository.save(new Descriptor(topCategorySize, "Tall", 1, 0, 1, 0, 0, 0, 0, 0, 2, 2));
        descriptorsRepository.save(new Descriptor(topCategorySize, "Well-Built", 3, 1, 2, 0, 0, 0, 0, 0, 2, 2));
        descriptorsRepository.save(new Descriptor(topCategorySize, "Very Tall", 2, 1, 1, 0, 0, 0, 0, 0, 3, 3));
        descriptorsRepository.save(new Descriptor(topCategorySize, "Giant", 1, 2, 1, -2, 0, 0, 0, 0, 4, 4));
        descriptorsRepository.save(new Descriptor(topCategorySize, "Gigantic", 2, 3, 1, -2, 0, 0, 0, 0, 5, 5));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Acute Hearing", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Acute Taste and Smell", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Acute Vision", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Agile", 2, 0, 0, 2, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Athletic", 2, 0, 1, 0, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Attrative Appearance", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Awkward", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Back Pain", -3, 0, -1, -1, 0, -1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Bad Sight", -2, 0, 0, 0, -2, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Balanced Step", 2, 0, 0, 1, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Bald", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Beautiful", 2, 0, 0, 0, 0, 0, 0, 2, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Catlike", 2, 0, 0, 2, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Chubby", -1, 0, 0, -1, 0, 0, 0, 0, 0, 1));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Clumsy", -1, 0, 0, -1, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Crude", -2, 0, 0, -1, 0, -1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Curvy", 0, 0, 0, 0, 0, -1, 0, 1, 0, 1));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Deaf", -2, 0, 0, 0, -2, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Dexterous", 1, 0, 0, 1, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Double-Jointed", 1, 0, 0, 2, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Endurant", 1, 0, 1, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Energetic", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Eye-Hand Coordination", 2, 0, 0, 1, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Fast", 2, 0, 0, 1, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Fast Hands", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Fat", 0, 1, 0, 0, 0, -1, 0, 0, 0, 5));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Fit", 2, 1, 1, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Flabby", -3, -1, -1, -1, 0, 0, 0, 0, 0, 2));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Flexible", 3, 0, 0, 2, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Frail", -2, -1, -1, 0, 0, 0, 0, 0, 0, -2));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Good Balance", 2, 0, 0, 1, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Hardy", 1, 0, 1, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Healty", 1, 0, 1, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Heavy", 2, 2, 0, 0, 0, 0, 0, 0, 0, 5));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Heavy Lifter", 1, 1, 0, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Hideous", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Inexperienced", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Injured", -1, 0, -1, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Injured Eardrum", -1, 0, 0, 0, -1, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Jogger", 1, 0, 1, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Keen-Eyed", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Lightning Fast", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Malnourished", -1, 0, -1, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Morbid Obese", -2, 2, 0, -2, 0, -2, 0, 0, 0, 20));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Muscular", 1, 1, 0, 0, 0, 0, 0, 1, 0, 1));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Myopic", -1, 0, 0, 0, -1, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Obese", -1, 1, 0, -1, 0, -1, 0, 0, 0, 10));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "One Eyes", -2, 0, 0, 0, -1, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Overweight", 0, 1, 0, -1, 0, 0, 0, 0, 0, 5));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Plump", -2, 0, 0, -1, 0, -1, 0, 0, 0, 5));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Puni", -4, -2, -2, 0, 0, 0, 0, 0, 0, -3));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Quick", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Quick Reflexes", 2, 0, 0, 0, 0, 2, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Rickety", -4, -2, -2, 0, 0, 0, 0, 0, 0, -5));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Scarred", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Shapely", 2, 0, 0, 2, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Sharp Shooter", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Skinny", -2, -1, -1, 0, 0, 0, 0, 0, 0, -2));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Slender", 2, 0, 1, 1, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Slow", -1, 0, 0, 0, 0, -1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Sluggish", -3, -1, -1, 0, 0, -1, 0, 0, 0, 1));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Smelly", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Sporty", 2, 0, 1, 1, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Sprinter", 2, 0, 1, 0, 0, 1, 0, 0, 0, 1));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Strong", 1, 1, 0, 0, 0, 0, 0, 0, 0, 1));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Sturdy", 2, 1, 1, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Swift", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Thick", 2, 1, 1, 0, 0, 0, 0, 0, 0, -1));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Thin", -1, 0, -1, 0, 0, 0, 0, 0, 0, -1));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Tone Deaf", -1, 0, 0, 0, -1, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Tough", 2, 0, 2, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Trained", 2, 1, 1, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Ugly", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Unathletic", -2, -1, -1, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Unattractive Appearance", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Uncouth", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Underfed", -3, -2, -1, 0, 0, 0, 0, 0, 0, -3));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Underwight", -2, 0, -2, 0, 0, 0, 0, 0, 0, -1));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Unsporty", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Unsteady Hands", -1, 0, 0, -1, 0, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Very Hairy", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Weak", -1, -1, 0, 0, 0, 0, 0, 0, 0, -1));
        descriptorsRepository.save(new Descriptor(categoryGeneralPhysical, "Wiry", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Alert", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Bright", 2, 0, 0, 0, 0, 1, 1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Brillant", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Broadminded", 2, 0, 0, 0, 0, 0, 1, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Clever", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Confuse", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Dimitted", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Disorganized", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Dreamy", -2, 0, 0, 0, 0, -1, -1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Dropout", 0, 1, 0, 0, 0, 0, -1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Dumb", -3, 0, 0, 0, 0, -1, -2, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Dyscalculia", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Educated", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Fast Learner", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Fast Thinker", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Focused", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Genius", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Ignorant", -2, 0, 0, 0, 0, 0, -2, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Inattentive", -1, 0, 0, 0, -1, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Instivtive", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Intellectual", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Intuitive", 2, 0, 0, 0, 0, 2, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Inventive", 2, 0, 0, 0, 0, 1, 1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Lazy", -1, 0, 0, 0, 0, -1, 0, 0, 0, 1));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Methodical", 2, 0, 0, 0, 0, 1, 1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Lazy", -1, 0, 0, 0, 0, -1, 0, 0, 0, 1));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Methodical", 2, 0, 0, 0, 1, 0, 1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Moronic", -2, 0, 0, 0, 0, 0, -2, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Observant", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Obtuse", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Open-Minded", 2, 0, 0, 0, 0, 0, 1, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Orderly", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Perceptive", 2, 0, 0, 0, 2, 0, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Sage", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Sharp", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Simple", -2, 0, 0, 0, 0, 0, -1, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Slow Learner", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Smart", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Spontaneous", 2, 0, 0, 0, 0, 1, 1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Studious", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Stupid", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Thoughtless", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Uneducated", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Unintellectual", -2, 0, 0, 0, 0, 0, -2, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Wise", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralMental, "Witty", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Attractive", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Bon vivant", 2, 0, 0, 0, 0, 1, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Boring", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Breathtaking", 3, 0, 0, 0, 0, 0, 0, 3, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Caring", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Charming", 2, 0, 0, 0, 0, 0, 0, 2, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Charming Voice", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Cheerful", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Communicator", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Cute", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Discreet", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Disfigured", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Empathic", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Entertaining", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Extrovert", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Friendly", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Fun", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Funny", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Gorgeous", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Handsome", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Introvert", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Neglectful", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Odious", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Outgoing", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Personable", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Pleasant", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Pretty", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Quiet", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Repulsive", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Romantic", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Scruffy", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Sensual", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Sexy", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Shy", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Stuttering", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Sympathetic", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Trusted Face", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Ugly", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Unattractive", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Unkempt", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0));
        descriptorsRepository.save(new Descriptor(categoryGeneralSocial, "Vitiligo", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));

        for (Descriptor descriptor : descriptorsRepository.findAll()) {
            log.info("Item = " + descriptor.name);
        }
    }
}
