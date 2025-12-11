import java.util.ArrayList;
import java.io.File;       // Import the File class
import java.io.IOException; // Import IOException to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class

/**
 * Write a description of class Recipe here.
 *
 * @author Daniel
 * @version (a version number or a date)
 */
public class Recipe
{
    ArrayList<Ingredient> ingredientList;
    ArrayList<Instruction> instructionList;
    public String recipeName;
    public String detail = "";
    int id;//not relevant to user, for reference to us
    RecipeType recipeTypes;

    /**
     * This constructor sets the relevant information for a recipe. It creates the ArrayLists 
     * for the ingredients and instructions.
     * @param id The ID of a recipe. For developer use.
     * @param recipeName The name of the recipe.
     * @param recipeTypes The type of the recipe (DISH, DRINK, or DESERT).
     */
    public Recipe(int id, String recipeName, RecipeType recipeTypes)
    {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeTypes = recipeTypes;
        ingredientList = new ArrayList<>();
        instructionList = new ArrayList<>();
        //System.out.println("Created: " + recipeName + ", ID: " + id);
    }
    /**
     * Getter for the recipe's details (details based on the recipe type).
     */
    public String getDetail() 
    {
        return detail;
    }

    /**
     * Setter for details when generating a txt file.
     * @param detail A detail.
     */
    public void setDetail(String detail)
    {
        this.detail = "# " + detail;
    }

    public void addDetail(String detail)
    {
        this.detail = this.detail + "\n# " + detail;
    }


    /**
     * printIngredients() prints out all the added ingredients in the ingredientList. 
     * searchAndOpenRecipe(String name) from RecipeBook uses this to print the ingredients of 
     * the requested recipe.
     */
    public void printIngredients()//recipe book uses this
    {
        if (ingredientList != null)
        {
            for (Ingredient ingredient: ingredientList)
            {
                System.out.println(ingredient.getIngredientText());
            }
        }
    }

    /**
     * printInstructions() prints out all the added instructions in the instructionList. 
     * searchAndOpenRecipe(String name) from RecipeBook uses this to print the instructions of 
     * the requested recipe.
     */
    public void printInstructions()//recipe book uses this
    {
        if (instructionList != null)
        {
            for (Instruction instruction: instructionList)
            {
                instruction.printSteps();
            }
        }
    }
    
    /**
     * printDetails() prints out all the added details. searchAndOpenRecipe(String name) from 
     * RecipeBook uses this to print the details of the requested recipe.
     */
    public void printDetails()//recipe book uses this
    {
        System.out.println(recipeTypes);
        System.out.println("___________________");
        System.out.println(detail);
    }

    /**
     * saveIngredients() saves the ingredients onto the txt file of the recipe.
     */
    private String saveIngredients()//for vscode functionality(?)
    {
        if (ingredientList == null) return "";
        String saveInfo = "";
        saveInfo = saveInfo + "^ " + String.valueOf(recipeTypes);
        System.out.println(String.valueOf(recipeTypes));
        saveInfo = saveInfo + detail + "\n";
        for (Ingredient ingredient: ingredientList)
        {
            saveInfo = saveInfo + "- " + ingredient.getIngredientText() + "\n";
        }
        for (Instruction instruction: instructionList)
        {
            saveInfo = saveInfo + instruction.getSteps() + "\n";
        }
        return saveInfo;
    }

    public void addIngredient(Ingredient ingredient)//adds an ingredient object (contains one ingredient)
    {
        ingredientList.add(ingredient);
    }
    
    public void addInstruction(Instruction instruction)//adds an instruction object(contains the steps)
    {
        instructionList.add(instruction);
    }

    /**
     * saveRecipe() saves the recipe onto a txt file.
     */
    public void saveRecipe()//ignore, for vscode functionality
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