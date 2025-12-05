

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class IngredientTest.
 *
 * @author  John
 * @version (a version number or a date)
 */
public class IngredientTest
{
    /**
     * Default constructor for test class IngredientTest
     */
    public IngredientTest()
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
    public void testIngredientConstructor()
    {
        Ingredient ingredient = new Ingredient("Flour", QuantityTypes.CUP, 2);
        assertEquals("Flour", ingredient.getName());
        assertEquals(QuantityTypes.CUP, ingredient.getType());
        assertEquals(2, ingredient.getQuantity());
    }

    @Test
    public void testGetIngredientText()
    {
        Ingredient ingredient = new Ingredient("Sugar", QuantityTypes.TABLESPOON, 3);
        String expected = "3 TABLESPOON of Sugar";
        assertEquals(expected, ingredient.getIngredientText());
    }

    @Test
    public void testSetQuantity()
    {
        Ingredient ingredient = new Ingredient("Salt", QuantityTypes.PINCH, 1);
        ingredient.setQuantity(2);
        assertEquals(2, ingredient.getQuantity());
    }

    @Test
    public void testSetQuantityType()
    {
        Ingredient ingredient = new Ingredient("Milk", QuantityTypes.CUP, 1);
        ingredient.setQuantityType(QuantityTypes.TEASPOON);
        assertEquals(QuantityTypes.TEASPOON, ingredient.getType());
    }

    @Test
    public void testGetTXTQuantity()
    {
        Ingredient ingredient = new Ingredient("Eggs", QuantityTypes.UNIT, 4);
        String expected = "4 UNIT";
        assertEquals(expected, ingredient.getTXTQuantity());
    }

    @Test
    public void testDifferentQuantityTypes()
    {
        Ingredient cupIngredient = new Ingredient("Water", QuantityTypes.CUP, 1);
        Ingredient tspIngredient = new Ingredient("Vanilla", QuantityTypes.TEASPOON, 1);
        Ingredient tbspIngredient = new Ingredient("Oil", QuantityTypes.TABLESPOON, 2);
        Ingredient unitIngredient = new Ingredient("Apple", QuantityTypes.UNIT, 3);
        Ingredient pinchIngredient = new Ingredient("Salt", QuantityTypes.PINCH, 1);

        assertEquals(QuantityTypes.CUP, cupIngredient.getType());
        assertEquals(QuantityTypes.TEASPOON, tspIngredient.getType());
        assertEquals(QuantityTypes.TABLESPOON, tbspIngredient.getType());
        assertEquals(QuantityTypes.UNIT, unitIngredient.getType());
        assertEquals(QuantityTypes.PINCH, pinchIngredient.getType());
    }
}
