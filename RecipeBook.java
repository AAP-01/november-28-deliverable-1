import java.util.ArrayList;
import java.util.*;
import java.io.File;       // Import the File class
import java.io.IOException; // Import IOException to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class

/**
 * Write a description of class RecipeBook here.
 *
 * @author Daniel
 * @version (a version number or a date)
 */
public class RecipeBook
{
    ArrayList<Recipe> recipeList;
    boolean activeMenu;
    Scanner scanner;
    String sep = "-";
    String line = "";
    

    public RecipeBook(String title, String author, int year)
    {
        for (int i = 0; i <= title.length(); i ++) 
        {
            line = line + sep;
        }
        System.out.println(line);
        System.out.println(title);
        System.out.println(line);
        System.out.println(author);
        System.out.println(line);
        System.out.println(year);
        System.out.println(line);
        System.out.println("Welcome to the best recipe book in the world!");
        recipeList = new ArrayList<>();
        loadAllRecipesFromFolder("RecipeData");
        
   
    }

    public void openBookPanel() {
        scanner = new Scanner(System.in);
        activeMenu = true;

        while (activeMenu) {

            System.out.println("\n===== RECIPE BOOK MENU =====");
            System.out.println("1. Create new recipe");
            System.out.println("2. List all recipes");
            System.out.println("3. Open a recipe");
            System.out.println("4. Quit");
            System.out.println("Choose an option (1-4):");

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":
                    createRecipe();
                    break;

                case "2":
                    printRecipes();
                    break;

                case "3":
                    openRecipeByName();
                    break;

                case "4":
                case "quit":
                case "QUIT":
                    activeMenu = false;
                    System.out.println("Closing Recipe Book...");
                    break;

                default:
                    System.out.println("Invalid option. Please enter 1–4.");
                    break;
            }
        }
    }

    private void openRecipeByName() {
        System.out.println("Enter recipe name:");
        String name = scanner.nextLine().trim();

        boolean found = false;

        for (Recipe recipe : recipeList) {
            if (recipe.recipeName.equalsIgnoreCase(name)) {
                System.out.println("=== " + recipe.recipeName + " ===");
                System.out.println("\n== " + "Details" + " ==");
                recipe.printDetails();
                System.out.println("\n== " + "Ingredients" + " ==");
                recipe.printIngredients();
                System.out.println("\n== " + "Instructions" + " ==");
                recipe.printInstructions();
                found = true;
                System.out.println("\nPress 'Enter' to Continue..");
                scanner.nextLine();
                break;
            }
        }

        if (!found) {
            System.out.println("Recipe '" + name + "' not found.");
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
                    recipe.printDetails();
                    recipe.printIngredients();
                    recipe.printInstructions();
                }
            }
        }
    }
    
    public void printRecipes()//shows all added recipes in the terminal
    {   
        int index = 1;
        System.out.println("""
                ------Recipe List------
            """);

        for(Recipe recipe : recipeList)
        {
            System.out.println(index + ") " + recipe.recipeName);
            index++;
        }
    }

    public void loadAllRecipesFromFolder(String folderName) {
        File folder = new File(folderName);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Folder not found: " + folderName);
            return;
        }

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null || files.length == 0) {
            System.out.println("No recipe files found.");
            return;
        }

        for (File file : files) {
            loadSingleRecipe(file);
        }

        System.out.println("Loaded " + recipeList.size() + " recipes.");
    }

    private void loadSingleRecipe(File file) {
        try (Scanner sc1 = new Scanner(file); Scanner sc2 = new Scanner(file); Scanner sc3 = new Scanner(file) ) {

            String recipeName = file.getName().replace(".txt", "");
            RecipeType type = null;
            int id = recipeList.size() + 1;  // auto ID
             // default since your file doesn't store it
            String details = null;
            Recipe recipe = null;
            Instruction instructions = new Instruction();
            boolean frozen = false;
            boolean vegeterian = false;
            boolean hot = false;
            boolean alcoholic = false;


            while (sc1.hasNextLine()) {
                String line = sc1.nextLine().trim();
                if (line.isEmpty()) continue;
                if (line.startsWith("#"))
                {
                    String lineDet = line.substring(2);
                    String[] pDtls = lineDet.split(" ");
                    String formatterInfo = "";
                    int index = 0;
                    for (String fDtls : pDtls)
                    {
                        switch (fDtls)
                        {
                            case "frozen" :
                                if (pDtls[index + 1].equals("true"))
                                {
                                    frozen = true;
                                } else {frozen = false;}
                                break;
                            case "alcoholic" :
                                if (pDtls[index + 1].equals("true"))
                                {
                                    alcoholic = true;
                                } else {alcoholic = false;}
                                break;
                            case "hot" :
                                if (pDtls[index + 1].equals("true"))
                                {
                                    hot = true;
                                } else {hot = false;}
                                break;
                            case "vegeterian" :
                                if (pDtls[index + 1].equals("true"))
                                {
                                    vegeterian = true;
                                } else {vegeterian = false;}
                                break;

                            default: index ++;
                        }
                    }

                }
            }

            
            
            
            while (sc2.hasNextLine()) {
                String line = sc2.nextLine().trim();
                if (line.isEmpty()) continue;
                if (line.startsWith("^"))
                    {
                        String lineFType = line.substring(2);
                        String[] parts = lineFType.split(" ");
                        String formatterInfo = parts[0];
                        type = RecipeType.valueOf(formatterInfo);
                        switch (type)
                        {
                            case DISH:
                                recipe = new Dish(id, recipeName, vegeterian);
                                recipe.addDetail("");

                                break;
                            case DRINK: 
                                recipe = new Drink(id, recipeName, alcoholic, hot);
                                break;
                            case DESERT: 
                                recipe = new Desert(id, recipeName, frozen);
                                break;
                            default: 
                                recipe = new Recipe(id, recipeName, type);
                        }


                    }

                if (line.startsWith("#"))
                {
                    String lineDet = line.substring(2);
                    String[] pDtls = lineDet.split(" ");
                    String formatterInfo = "";
                    int index = 0;
                    for (String fDtls : pDtls)
                    {
                        switch (fDtls)
                        {
                            case "frozen" :
                                if (pDtls[index + 1].equals("true"))
                                {
                                    recipe.addDetail("frozen true");
                                } else {recipe.addDetail("frozen false");}
                                break;
                            case "alcoholic" :
                                if (pDtls[index + 1].equals("true"))
                                {
                                    recipe.addDetail("alcoholic true");
                                } else {recipe.addDetail("alcoholic false");}
                                break;
                            case "hot" :
                                if (pDtls[index + 1].equals("true"))
                                {
                                    recipe.addDetail("hot true");
                                } else {recipe.addDetail("hot false");}
                                break;
                            case "vegeterian" :
                                if (pDtls[index + 1].equals("true"))
                                {
                                    recipe.addDetail("vegeterian true");
                                } else {recipe.addDetail("vegeterian false");}
                                break;

                            default: index ++;
                        }
                    }

                }
            }


            while (sc3.hasNextLine()) {
                String line = sc3.nextLine().trim();
                if (line.isEmpty()) continue;


                // Ingredient format:
                // - 1 unit of steak
                if (line.startsWith("- ") && !line.startsWith("- -")) {

                    // Remove "- "
                    line = line.substring(2);

                    // "1 unit of steak"
                    String[] parts = line.split(" ");

                    int quantity = Integer.parseInt(parts[0]);
                    QuantityTypes qtyType = QuantityTypes.valueOf(parts[1].toUpperCase());

                    // Ingredient name is everything after "of "
                    String ingName = line.substring(line.indexOf("of ") + 3);

                    recipe.addIngredient(new Ingredient(ingName, qtyType, quantity));
                }

                // Instruction format:
                // - - 1. Cook the steak
                else if (line.startsWith("- -")) {

                    // Remove "- - "
                    String step = line.substring(4);

                    // Remove "1. " numbering
                    if (step.matches("\\d+\\.\\s+.*")) {
                        step = step.substring(step.indexOf(". ") + 2);
                    }

                    instructions.addStep(step);
                }
            }


            recipe.addInstruction(instructions);
            recipeList.add(recipe);

            // System.out.println("Loaded recipe: " + recipeName);

        } catch (Exception e) {
            System.out.println("Error loading file: " + file.getName());
            e.printStackTrace();
        }
    }

    public void createRecipe()
    {
        RecipeType recipeType = null;
        System.out.println("Recipe Name?");
        String recipeName = scanner.nextLine();
        Recipe recipe = null;
        boolean isCorrect = false;
        // Create recipe with auto-generated ID
        int recipeId = recipeList.size() + 1;
        while (!isCorrect)
        {
            System.out.println("Is it a DISH, DRINK or DESERT");

            try
            {
                recipeType = RecipeType.valueOf(scanner.nextLine().toUpperCase());
                
            } catch (Exception e) {
                recipeType = RecipeType.NULL;
            }
            
            
            switch (recipeType)
            {
                case DISH : {
                    isCorrect = true;
                    System.out.println("Is it vegeterian? (true, false)");
                    boolean isVegeterian = scanner.nextBoolean();
                    try {
                        recipe = new Dish(recipeId, recipeName, isVegeterian); 
                        recipe.addDetail("vegeterian " + isVegeterian);
                    } catch (Exception e) {
                        recipe = new Dish(recipeId, recipeName, false);
                        recipe.addDetail("vegeterian " + "false");
                        System.out.println("error, vegeterian set to false");
                    }
                    
                    break;
                    }
                
                case DESERT : 

                    isCorrect = true;
                    System.out.println("Is it frozen? (true, false)");
                    boolean isFrozen = scanner.nextBoolean();
                    try {
                        recipe = new Desert(recipeId,recipeName, isFrozen); 
                        recipe.addDetail("frozen " + isFrozen);
                    } catch (Exception e) {
                        recipe = new Desert(recipeId,recipeName, false);
                        recipe.addDetail("frozen " + "false");
                        System.out.println("error, frozen set to false");
                    }
                    break;

                case DRINK :

                    isCorrect = true;
                    System.out.println("Is it hot? (true, false)");
                    boolean isHot = scanner.nextBoolean();
                    System.out.println("Is it alcoholic? (true, false)");
                    boolean isAlcoholic = scanner.nextBoolean();
                    try {
                        recipe = new Drink(recipeId, recipeName, isAlcoholic, isHot); 
                        recipe.addDetail("alcoholic " + isAlcoholic);
                        recipe.addDetail("hot " + isHot);
                    } catch (Exception e) {
                        recipe = new Drink(recipeId, recipeName, false, false);
                        recipe.addDetail("alcoholic " + "false");
                        recipe.addDetail("hot " + "false");
                        System.out.println("error, hot and alcoholic set to false");
                    }
             
                    break;

                default : isCorrect = false; System.out.println("ERROR: RETRY"); break;
            }
        }

        
        
        // Collect ingredients
        String addIngredients = scanner.nextLine();
        String ingredientName = null;
        String step = null;
        QuantityTypes quantityType = null;
        int quantity = 0;
        Ingredient ingredient = null;
        while (!addIngredients.toLowerCase().equals("done"))
        {
            System.out.println("Ingredient name?");
            if (!addIngredients.toLowerCase().equals("done")) addIngredients = scanner.nextLine();
            if (!addIngredients.toLowerCase().equals("done")) ingredientName = addIngredients;
            if (!addIngredients.toLowerCase().equals("done")) System.out.println("Quantity type? (cup, teaSpoon, tableSpoon, unit, pinch)");
            if (!addIngredients.toLowerCase().equals("done")) addIngredients = scanner.nextLine();
            
            if (!addIngredients.toLowerCase().equals("done")) quantityType = QuantityTypes.valueOf(addIngredients.toUpperCase());
            if (!addIngredients.toLowerCase().equals("done")) System.out.println("Quantity? (number)");
            if (!addIngredients.toLowerCase().equals("done")) addIngredients = scanner.nextLine();
            if (!addIngredients.toLowerCase().equals("done")) quantity = Integer.parseInt(addIngredients);
            
            if ((ingredientName != null) && (!quantityType.equals(null) ) && (quantity != 0)) ingredient = new Ingredient(ingredientName, quantityType, quantity);
            if (ingredient != null && !addIngredients.toLowerCase().equals("done")) recipe.addIngredient(ingredient); System.out.println("Ingredient added");
            
        }
        
        // Collect instructions
        Instruction instruction = new Instruction();
        //System.out.println("Add instructions? (Yes or No)");
        
        String addInstructions = "lol";
        System.out.println("Add Instructions. 'Done' to complete");
        while (!addInstructions.toLowerCase().equals("done"))
        {
            if (!addInstructions.toLowerCase().equals("done")) System.out.println("Enter step:");
            if (!addInstructions.toLowerCase().equals("done")) addInstructions = scanner.nextLine();
            if (!addInstructions.toLowerCase().equals("done")) step = addInstructions;
            if (!addInstructions.toLowerCase().equals("done") && (step != null)) instruction.addStep(step);
            
            
            
        }
        recipe.addInstruction(instruction);
        
        
        // Add recipe to the recipe list
        addRecipe(recipe);
        recipe.saveRecipe();
        System.out.println("Recipe created and added to recipe book!");
    }

    
}