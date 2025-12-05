

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RecipeTest.
 *
 * @author  John
 * @version (a version number or a date)
 */
public class RecipeTest
{
    /**
     * Default constructor for test class RecipeTest
     */
    public RecipeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }



    @Test
    public void testAddIngredient()
    {
        Recipe recipe = new Recipe(1, "Cake", RecipeType.DESERT);
        Ingredient ingredient = new Ingredient("Flour", QuantityTypes.CUP, 2);
        recipe.addIngredient(ingredient);
        
        assertNotNull(recipe.ingredientList);
        assertEquals(1, recipe.ingredientList.size());
    }

    @Test
    public void testAddMultipleIngredients()
    {
        Recipe recipe = new Recipe(1, "Cake", RecipeType.DESERT);
        recipe.addIngredient(new Ingredient("Flour", QuantityTypes.CUP, 2));
        recipe.addIngredient(new Ingredient("Sugar", QuantityTypes.CUP, 1));
        recipe.addIngredient(new Ingredient("Eggs", QuantityTypes.UNIT, 3));
        
        assertEquals(3, recipe.ingredientList.size());
    }

    @Test
    public void testAddInstruction()
    {
        Recipe recipe = new Recipe(1, "Cake", RecipeType.DESERT);
        Instruction instruction = new Instruction();
        instruction.addStep("Mix ingredients");
        recipe.addInstruction(instruction);
        
        assertNotNull(recipe.instructionList);
        assertEquals(1, recipe.instructionList.size());
    }

    @Test
    public void testAddMultipleInstructions()
    {
        Recipe recipe = new Recipe(1, "Cake", RecipeType.DESERT);
        Instruction instruction1 = new Instruction();
        instruction1.addStep("Mix dry ingredients");
        Instruction instruction2 = new Instruction();
        instruction2.addStep("Mix wet ingredients");
        
        recipe.addInstruction(instruction1);
        recipe.addInstruction(instruction2);
        
        assertEquals(2, recipe.instructionList.size());
    }



 
}
