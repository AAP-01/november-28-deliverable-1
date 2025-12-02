

public class MainDishRecipe extends Recipe
{
    boolean isVegeterian;

    public MainDishRecipe(int id, String recipeName, boolean isVegeterian)
    {
        super(int id, String recipeName)
        this.isVegeterian = isVegeterian;
    }


}