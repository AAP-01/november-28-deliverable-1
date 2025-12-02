import java.util.ArrayList;

public class Recipe
{
    ArrayList<Ingredient> ingredientList;
    public String recipeName;
    int id;

    public Recipe(int id, String recipeName)
    {
        this.id = id;
        this.recipeName = recipeName;
        ingredientList = new ArrayList<>();
        System.out.println("Created: " + recipeName + ", ID: " + id);
    }
    
    public void printIngredients()
    {
        if (ingredientList != null)
        {
            for (Ingredient ingredient: ingredientList)
            {
                System.out.println(ingredient.getIngredientText());
            }
        }
        
    }

    public void addIngredient(Ingredient ingredient) 
    {
        ingredientList.add(ingredient);
    }
}