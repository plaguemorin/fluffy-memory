package ca.screenshot.antagonistsp;


import ca.screenshot.antagonistsp.entities.Category;
import ca.screenshot.antagonistsp.entities.Item;
import ca.screenshot.antagonistsp.repository.Actors;
import ca.screenshot.antagonistsp.repository.Categories;
import ca.screenshot.antagonistsp.repository.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean {
    private static final Logger log = LoggerFactory.getLogger(TestBean.class);
    private Items itemsRepository;
    private Categories categoriesRepository;
    private Actors actorsRepository;

    public void setItemsRepository(Items itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public void setCategoriesRepository(Categories categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public void setActorsRepository(Actors actorsRepository) {
        this.actorsRepository = actorsRepository;
    }

    public void execute() {
        categoriesRepository.deleteAll();
        itemsRepository.deleteAll();
        actorsRepository.deleteAll();

        Category topCategoryAge = categoriesRepository.save(new Category(null, "Age"));
        Category topCategoryGeneral = categoriesRepository.save(new Category(null, "General Descriptors"));
        Category topCategorySize = categoriesRepository.save(new Category(null, "Size"));

        Category categoryGeneralMental = categoriesRepository.save(new Category(topCategoryGeneral, "Mental"));
        Category categoryGeneralPhysical = categoriesRepository.save(new Category(topCategoryGeneral, "Physical"));
        Category categoryGeneralSocial = categoriesRepository.save(new Category(topCategoryGeneral, "Social"));

        itemsRepository.save(new Item(topCategoryAge, "Child", -2, -1, -1, 0, 0, 0, 0, 0, -4, -4));
        itemsRepository.save(new Item(topCategoryAge, "Young", -1, 0, -1, 0, 0, 0, 0, 0, -2, -2));
        itemsRepository.save(new Item(topCategoryAge, "Adult", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(topCategoryAge, "Mature", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        itemsRepository.save(new Item(topCategoryAge, "Old", 0, 0, -1, 0, 0, 0, 1, 0, -1, 0));
        itemsRepository.save(new Item(topCategoryAge, "Senior", 1, 0, -1, 0, 0, 0, 2, 0, -1, -2));
        itemsRepository.save(new Item(topCategoryAge, "Venerable", -1, -1, -1, 0, 0, 0, 1, 0, -1, -2));
        itemsRepository.save(new Item(topCategorySize, "Small", 0, 0, -1, 0, 0, 0, 0, 0, -2, -2));
        itemsRepository.save(new Item(topCategorySize, "Short", -1, 0, -1, 0, 0, 0, 0, 0, 0, -1));
        itemsRepository.save(new Item(topCategorySize, "Medium", 1, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(topCategorySize, "High", 1, 0, 1, 0, 0, 0, 0, 0, 1, 1));
        itemsRepository.save(new Item(topCategorySize, "Large", 2, 2, 0, 0, 0, 0, 0, 0, 1, 2));
        itemsRepository.save(new Item(topCategorySize, "Tall", 1, 0, 1, 0, 0, 0, 0, 0, 2, 2));
        itemsRepository.save(new Item(topCategorySize, "Well-Built", 3, 1, 2, 0, 0, 0, 0, 0, 2, 2));
        itemsRepository.save(new Item(topCategorySize, "Very Tall", 2, 1, 1, 0, 0, 0, 0, 0, 3, 3));
        itemsRepository.save(new Item(topCategorySize, "Giant", 1, 2, 1, -2, 0, 0, 0, 0, 4, 4));
        itemsRepository.save(new Item(topCategorySize, "Gigantic", 2, 3, 1, -2, 0, 0, 0, 0, 5, 5));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Acute Hearing", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Acute Taste and Smell", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Acute Vision", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Agile", 2, 0, 0, 2, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Athletic", 2, 0, 1, 0, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Attrative Appearance", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Awkward", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Back Pain", -3, 0, -1, -1, 0, -1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Bad Sight", -2, 0, 0, 0, -2, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Balanced Step", 2, 0, 0, 1, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Bald", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Beautiful", 2, 0, 0, 0, 0, 0, 0, 2, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Catlike", 2, 0, 0, 2, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Chubby", -1, 0, 0, -1, 0, 0, 0, 0, 0, 1));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Clumsy", -1, 0, 0, -1, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Crude", -2, 0, 0, -1, 0, -1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Curvy", 0, 0, 0, 0, 0, -1, 0, 1, 0, 1));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Deaf", -2, 0, 0, 0, -2, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Dexterous", 1, 0, 0, 1, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Double-Jointed", 1, 0, 0, 2, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Endurant", 1, 0, 1, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Energetic", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Eye-Hand Coordination", 2, 0, 0, 1, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Fast", 2, 0, 0, 1, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Fast Hands", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Fat", 0, 1, 0, 0, 0, -1, 0, 0, 0, 5));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Fit", 2, 1, 1, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Flabby", -3, -1, -1, -1, 0, 0, 0, 0, 0, 2));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Flexible", 3, 0, 0, 2, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Frail", -2, -1, -1, 0, 0, 0, 0, 0, 0, -2));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Good Balance", 2, 0, 0, 1, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Hardy", 1, 0, 1, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Healty", 1, 0, 1, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Heavy", 2, 2, 0, 0, 0, 0, 0, 0, 0, 5));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Heavy Lifter", 1, 1, 0, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Hideous", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Inexperienced", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Injured", -1, 0, -1, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Injured Eardrum", -1, 0, 0, 0, -1, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Jogger", 1, 0, 1, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Keen-Eyed", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Lightning Fast", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Malnourished", -1, 0, -1, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Morbid Obese", -2, 2, 0, -2, 0, -2, 0, 0, 0, 20));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Muscular", 1, 1, 0, 0, 0, 0, 0, 1, 0, 1));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Myopic", -1, 0, 0, 0, -1, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Obese", -1, 1, 0, -1, 0, -1, 0, 0, 0, 10));
        itemsRepository.save(new Item(categoryGeneralPhysical, "One Eyes", -2, 0, 0, 0, -1, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Overweight", 0, 1, 0, -1, 0, 0, 0, 0, 0, 5));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Plump", -2, 0, 0, -1, 0, -1, 0, 0, 0, 5));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Puni", -4, -2, -2, 0, 0, 0, 0, 0, 0, -3));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Quick", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Quick Reflexes", 2, 0, 0, 0, 0, 2, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Rickety", -4, -2, -2, 0, 0, 0, 0, 0, 0, -5));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Scarred", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Shapely", 2, 0, 0, 2, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Sharp Shooter", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Skinny", -2, -1, -1, 0, 0, 0, 0, 0, 0, -2));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Slender", 2, 0, 1, 1, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Slow", -1, 0, 0, 0, 0, -1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Sluggish", -3, -1, -1, 0, 0, -1, 0, 0, 0, 1));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Smelly", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Sporty", 2, 0, 1, 1, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Sprinter", 2, 0, 1, 0, 0, 1, 0, 0, 0, 1));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Strong", 1, 1, 0, 0, 0, 0, 0, 0, 0, 1));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Sturdy", 2, 1, 1, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Swift", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Thick", 2, 1, 1, 0, 0, 0, 0, 0, 0, -1));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Thin", -1, 0, -1, 0, 0, 0, 0, 0, 0, -1));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Tone Deaf", -1, 0, 0, 0, -1, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Tough", 2, 0, 2, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Trained", 2, 1, 1, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Ugly", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Unathletic", -2, -1, -1, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Unattractive Appearance", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Uncouth", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Underfed", -3, -2, -1, 0, 0, 0, 0, 0, 0, -3));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Underwight", -2, 0, -2, 0, 0, 0, 0, 0, 0, -1));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Unsporty", -1, -1, 0, 0, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Unsteady Hands", -1, 0, 0, -1, 0, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Very Hairy", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Weak", -1, -1, 0, 0, 0, 0, 0, 0, 0, -1));
        itemsRepository.save(new Item(categoryGeneralPhysical, "Wiry", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Alert", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Bright", 2, 0, 0, 0, 0, 1, 1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Brillant", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Broadminded", 2, 0, 0, 0, 0, 0, 1, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Clever", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Confuse", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Dimitted", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Disorganized", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Dreamy", -2, 0, 0, 0, 0, -1, -1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Dropout", 0, 1, 0, 0, 0, 0, -1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Dumb", -3, 0, 0, 0, 0, -1, -2, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Dyscalculia", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Educated", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Fast Learner", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Fast Thinker", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Focused", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Genius", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Ignorant", -2, 0, 0, 0, 0, 0, -2, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Inattentive", -1, 0, 0, 0, -1, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Instivtive", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Intellectual", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Intuitive", 2, 0, 0, 0, 0, 2, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Inventive", 2, 0, 0, 0, 0, 1, 1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Lazy", -1, 0, 0, 0, 0, -1, 0, 0, 0, 1));
        itemsRepository.save(new Item(categoryGeneralMental, "Methodical", 2, 0, 0, 0, 0, 1, 1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Lazy", -1, 0, 0, 0, 0, -1, 0, 0, 0, 1));
        itemsRepository.save(new Item(categoryGeneralMental, "Methodical", 2, 0, 0, 0, 1, 0, 1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Moronic", -2, 0, 0, 0, 0, 0, -2, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Observant", 1, 0, 0, 0, 1, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Obtuse", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Open-Minded", 2, 0, 0, 0, 0, 0, 1, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Orderly", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Perceptive", 2, 0, 0, 0, 2, 0, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Sage", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Sharp", 2, 0, 0, 0, 0, 0, 2, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Simple", -2, 0, 0, 0, 0, 0, -1, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Slow Learner", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Smart", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Spontaneous", 2, 0, 0, 0, 0, 1, 1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Studious", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Stupid", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Thoughtless", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Uneducated", -1, 0, 0, 0, 0, 0, -1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Unintellectual", -2, 0, 0, 0, 0, 0, -2, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Wise", 1, 0, 0, 0, 0, 0, 1, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralMental, "Witty", 1, 0, 0, 0, 0, 1, 0, 0, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Attractive", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Bon vivant", 2, 0, 0, 0, 0, 1, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Boring", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Breathtaking", 3, 0, 0, 0, 0, 0, 0, 3, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Caring", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Charming", 2, 0, 0, 0, 0, 0, 0, 2, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Charming Voice", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Cheerful", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Communicator", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Cute", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Discreet", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Disfigured", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Empathic", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Entertaining", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Extrovert", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Friendly", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Fun", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Funny", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Gorgeous", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Handsome", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Introvert", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Neglectful", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Odious", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Outgoing", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Personable", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Pleasant", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Pretty", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Quiet", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Repulsive", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Romantic", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Scruffy", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Sensual", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Sexy", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Shy", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Stuttering", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Sympathetic", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Trusted Face", 1, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Ugly", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Unattractive", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Unkempt", -2, 0, 0, 0, 0, 0, 0, -2, 0, 0));
        itemsRepository.save(new Item(categoryGeneralSocial, "Vitiligo", -1, 0, 0, 0, 0, 0, 0, -1, 0, 0));

        for (Item item : itemsRepository.findAll()) {
            log.info("Item = " + item.name);
        }
    }
}
