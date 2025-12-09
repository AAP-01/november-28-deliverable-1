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
    ArrayList<Detail> detailsList;
    public String recipeName;
    int id;//not relevant to user, for reference to us
    RecipeType recipeTypes;

    public Recipe(int id, String recipeName, RecipeType recipeTypes)
    {
        this.id = id;
        this.recipeName = recipeName;
        ingredientList = new ArrayList<>();
        instructionList = new ArrayList<>();
        System.out.println("Created: " + recipeName + ", ID: " + id);
    }
    
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
    
    public void printDetails()//recipe book uses this
    {
        if (detailsList != null)
        {
            for (Detail detail: detailsList)
            {
                detail.printSteps();
            }
        }
    }
    
    private String saveIngredients()//for vscode functionality(?)
    {
        if (ingredientList != null)
        {
            String saveInfo = "";
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
        return null;
    }

    public void addIngredient(Ingredient ingredient)//adds an ingredient object (contains one ingredient)
    {
        ingredientList.add(ingredient);
    }
    
    public void addInstruction(Instruction instruction)//adds an instruction object(contains the steps)
    {
        instructionList.add(instruction);
    }

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