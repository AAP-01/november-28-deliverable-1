
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
    public Drink(int id, String recipeName, boolean isAlcoholic, boolean isHot)
    {
        super(id, recipeName, RecipeType.DRINK);
        this.isAlcoholic = isAlcoholic;
        this.isHot = isHot;
    }
}
