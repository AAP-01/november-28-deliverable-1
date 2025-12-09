/**
 * Write a description of class Main here.
 *
 * @author Daniel
 * @version (a version number or a date)
 */
public class Main {

    public static void main(String[] arg) {
        RecipeBook start = new RecipeBook("Recipe Book-inator 3000", "By Dan and John", 2008);
        start.openBookPanel();
        // Desert start = new Desert(1, "Cake");
        // start.addIngredient(new Ingredient("Sugar", QuantityTypes.tableSpoon, 3));
        // start.addIngredient(new Ingredient("Flour", QuantityTypes.cup, 2));
        // start.printIngredients();
        //start.saveRecipe();
    }
}