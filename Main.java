public class Main {

    public static void main(String[] arg) {
        Recipe start = new Recipe(1, "Cake");
        start.addIngredient(new Ingredient("Sugar", QuantityTypes.tableSpoon, 3));
        start.addIngredient(new Ingredient("Flour", QuantityTypes.cup, 2));
        start.printIngredients();
    }
}