

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RecipeBookTest.
 *
 * @author  John
 * @version (a version number or a date)
 */
public class RecipeBookTest
{
    /**
     * Default constructor for test class RecipeBookTest
     */
    public RecipeBookTest()
    {
    }

    private RecipeBook recipeBook;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        recipeBook = new RecipeBook("Test Recipe Book", "Test Author", 2024);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */


    @Test
    public void testRecipeBookConstructor()
    {
        RecipeBook book = new RecipeBook("My Recipes", "John Doe", 2024);
        assertNotNull(book);
        assertNotNull(book.recipeList);
    }



}
