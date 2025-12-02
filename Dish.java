

public class Dish extends Recipe
{
    boolean isVegeterian;

    public Dish(int id, String recipeName, boolean isVegeterian)
    {
        super(id, recipeName);
        this.isVegeterian = isVegeterian;
    }


}