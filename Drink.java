
/**
 * Write a description of class Drink here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Drink extends Recipe
{
    boolean isAlcoholic;
    boolean isHot;
    public Drink(int id, String recipeName, RecipeType recipeTypes, boolean isAlcoholic, boolean isHot)
    {
        super(id, recipeName, recipeTypes);
        this.isAlcoholic = isAlcoholic;
        this.isHot = isHot;
    }
}
