
/**
 * Write a description of class Dish here.
 *
 * @author John
 * @version (a version number or a date)
 */
public class Dish extends Recipe
{
    boolean isVegeterian;

    /**
     * This constructor gets the ID, name, and recipe type of the recipe (a DISH). 
     * It also sets the alcoholic and hot characteristic of the dish.
     * @param id The ID of a recipe. For developer use.
     * @param recipeName The name of the recipe.
     * @param isVegetarian Whether the recipe is vegetarian or not.
     */
    public Dish(int id, String recipeName, boolean isVegeterian)
    {
        super(id, recipeName, RecipeType.DISH);
        this.isVegeterian = isVegeterian;
    }
}