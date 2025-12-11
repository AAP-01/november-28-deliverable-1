
/**
 * Write a description of class Drink here.
 *
 * @author John
 * @version (a version number or a date)
 */
public class Drink extends Recipe
{
    boolean isAlcoholic;
    boolean isHot;
    
    /**
     * This constructor gets the ID, name, and recipe type of the recipe (a DRINK). 
     * It also sets the alcoholic and hot characteristic of the drink.
     * @param id The ID of a recipe. For developer use.
     * @param recipeName The name of the recipe.
     * @param isAlcoholic Whether the recipe is alcoholic or not.
     * @param isHot Whether the recipe is hot or not.
     */
    public Drink(int id, String recipeName, boolean isAlcoholic, boolean isHot)
    {
        super(id, recipeName, RecipeType.DRINK);
        this.isAlcoholic = isAlcoholic;
        this.isHot = isHot;
    }
}
