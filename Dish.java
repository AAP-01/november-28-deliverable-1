
/**
 * Write a description of class Dish here.
 *
 * @author John
 * @version (a version number or a date)
 */
public class Dish extends Recipe
{
    boolean isVegeterian;

    public Dish(int id, String recipeName, RecipeType recipeTypes, boolean isVegeterian)
    {
        super(id, recipeName, recipeTypes);
        this.isVegeterian = isVegeterian;
    }
}