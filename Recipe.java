import java.util.ArrayList;
import java.io.File;       // Import the File class
import java.io.IOException; // Import IOException to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class

public class Recipe
{
    ArrayList<Ingredient> ingredientList;
    ArrayList<Instruction> instructionList;
    public String recipeName;
    int id;

    public Recipe(int id, String recipeName)
    {
        this.id = id;
        this.recipeName = recipeName;
        ingredientList = new ArrayList<>();
        instructionList = new ArrayList<>();
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

    public void printInstructions()
    {
        if (instructionList != null)
        {
            for (Instruction instruction: instructionList)
            {
                instruction.printSteps();
            }
        }
    }
    
    private String saveIngredients()
    {
        if (ingredientList != null)
        {
            String saveInfo = "";
            for (Ingredient ingredient: ingredientList)
            {
                saveInfo = saveInfo + "- " + ingredient.getIngredientText() + "\n";
            }

            return saveInfo;
        }

        return null;
        
    }

    public void addIngredient(Ingredient ingredient) 
    {
        ingredientList.add(ingredient);
    }
    
    public void addInstruction(Instruction instruction) 
    {
        instructionList.add(instruction);
    }

    public void saveRecipe() 
    {
        try {
        File myObj = new File("RecipeData//" + recipeName + ".txt"); // Create File object
        if (myObj.createNewFile()) {           // Try to create the file
            System.out.println("File created: " + myObj.getName());
            FileWriter myWriter = new FileWriter("RecipeData//" + recipeName + ".txt");
            myWriter.write(saveIngredients());
            myWriter.close();
        } else {
            System.out.println("File already exists.");
        }
        } catch (IOException e) {
            System.out.println("Stuff Broke, Error Happened");
            e.printStackTrace(); // Print error details
        }
    }
}