import java.util.ArrayList;
import java.util.*;

public class RecipeBook
{
    ArrayList<Recipe> recipeList;
    boolean activeMenu;
    Scanner scanner;

    public RecipeBook(String title, String author, int year)
    {
        System.out.println(title);
        System.out.println(author);
        System.out.println(year);
        System.out.println("Welcome to the best recipe book in the world!");
        
        recipeList = new ArrayList<>();
    }

    public void openBookPanel()
    {
        scanner = new Scanner(System.in);
        boolean scannerOpen = true; // Create a Scanner object
        activeMenu = true;
        
        String userInput = "";
        while (activeMenu)
        {
            System.out.println("Write ''Quit'' to quit");
            System.out.println("create recipe? (Yes or No)");
            userInput = scanner.nextLine();
            if (userInput.toLowerCase().equals("yes"))
            {
                
                scannerOpen = false;
                createRecipe();
                
                
            } else 
            {   
                if (userInput.toLowerCase().equals("quit")) {activeMenu = false;}
                else {
                    System.out.println("Alright!");
                }
            }
            
        }

        
        
    }



    public void addRecipe(Recipe recipe)
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
                    recipe.printInstructions();
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

    public void createRecipe()
    {

        System.out.println("Recipe Name?");
        String recipeName = scanner.nextLine();
        System.out.println("Is it a DISH, DRINK or DESERT");
        RecipeType type = RecipeType.valueOf(scanner.nextLine().toUpperCase());

    }


}