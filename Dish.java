
/**
 * Write a description of class Dish here.
 *
 * @author John
 * @version (a version number or a date)
 */
public class Dish extends Recipe
{
    boolean isVegeterian;

    public Dish(int id, String recipeName, boolean isVegeterian)
    {
        super(id, recipeName, RecipeType.DISH);
        this.isVegeterian = isVegeterian;
    }
}