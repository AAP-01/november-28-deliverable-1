
/**
 * Write a description of class Desert here.
 *
 * @author John
 * @version (a version number or a date)
 */
public class Desert extends Recipe
{
    boolean isFrozen;
    
    public Desert(int id, String recipeName, boolean isFrozen)
    {
        super(id, recipeName, RecipeType.DESERT);
        this.isFrozen = isFrozen;
    }
}
//drgdggfdgdfgdfgd