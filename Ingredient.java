/**
 * Write a description of class Ingredient here.
 *
 * @author Daniel
 * @version (a version number or a date)
 */
public class Ingredient
{
    String name;
    QuantityTypes types;
    int quantity;
    String txtQuantity;

    /**
     * This constructor sets the relevant information for an ingredient. 
     * It also forms the full line of an ingredient in the terminal and 
     * txt file.
     * @param name The name of the ingredient.
     * @param types The Quantity type of the ingredient (CUP, TEASPOON, TABLESPOON, UNIT, or PINCH).
     * @param quantity The amount of an ingredient.
     */
    public Ingredient(String name, QuantityTypes types, int quantity)
    {
        this.name = name;
        this.types = types;
        this.quantity = quantity;
        createTextQuantity();
    }

    /**
     * Getter for the name of the ingredient.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Getter for the quantity type of the ingredient.
     */
    public QuantityTypes getType()
    {
        return types;
    }

    /**
     * Getter for the quantity of the ingredient.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Getter for the txtQuantity field.
     */
    public String getTXTQuantity()
    {
        return txtQuantity;
    }

    /**
     * Setter for the quantity of the ingredient.
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    /**
     * Setter for the quantity type of the ingredient.
     */
    public void setQuantityType(QuantityTypes types)
    {
        this.types = types;
    }

    /**
     * createTextQuantity() combines the quantity and the quantity type 
     * into String form.
     */
    public void createTextQuantity()
    {
        txtQuantity = (quantity + " " + types);
    }

    /**
     * getIngredientText() combines the String from createTextQuantity() 
     * with the name of the ingredient.
     */
    public String getIngredientText()
    {
        return (txtQuantity + " of " + name);
    }
}