import java.util.ArrayList;

public class RecipeBook
{
    ArrayList<Recipe> recipeList;

    public RecipeBook(String title, String author, int year)
    {
        System.out.println(title);
        System.out.println(author);
        System.out.println(year);
        System.out.println("Welcome to the best recipe book in the world!");
        
        recipeList = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe)
    {
        recipeList.add(recipe);
    }

    public void createRecipe(Recipe recipe)
    {
        recipeList.add(recipe);
    }
    
    public void searchAndOpenRecipe(String name)
    {
        if(!recipeList.isEmpty())
        {
            for(Recipe recipe: recipeList)
            {
                if (recipe.recipeName == name)
                {
                    recipe.printIngredients();
                }
            }
        }
    }
    
    public void printRecipes()
    {
        for(Recipe recipe : recipeList)
        {
            System.out.println(recipe.recipeName);
        }
    }
}