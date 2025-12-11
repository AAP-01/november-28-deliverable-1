
/**
 * Write a description of class Desert here.
 *
 * @author John
 * @version (a version number or a date)
 */
public class Desert extends Recipe//Desert is a typo but fixing it now would break everything
{
    boolean isFrozen;
    
    /**
     * This constructor gets the ID, name, and recipe type of the recipe (a DESERT). 
     * It also sets the alcoholic and hot characteristic of the desert.
     * @param id The ID of a recipe. For developer use.
     * @param recipeName The name of the recipe.
     * @param isFrozen Whether the recipe is frozen or not.
     */
    public Desert(int id, String recipeName, boolean isFrozen)
    {
        super(id, recipeName, RecipeType.DESERT);
        this.isFrozen = isFrozen;
    }
}
//drgdggfdgdfgdfgd