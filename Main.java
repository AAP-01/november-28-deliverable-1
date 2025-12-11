/**
 * Write a description of class Main here.
 *
 * @author Daniel
 * @version (a version number or a date)
 */
public class Main {
    /**
     * This starts the program in the terminal. The title, author, and date 
     * of publication can be set here (default).
     */
    public static void main(String[] arg) {
        RecipeBook start = new RecipeBook("Universal Recipe Book", "By Dan and John", 2008);
        start.openBookPanel();
        // Desert start = new Desert(1, "Cake");
        // start.addIngredient(new Ingredient("Sugar", QuantityTypes.tableSpoon, 3));
        // start.addIngredient(new Ingredient("Flour", QuantityTypes.cup, 2));
        // start.printIngredients();
        //start.saveRecipe();
    }
}