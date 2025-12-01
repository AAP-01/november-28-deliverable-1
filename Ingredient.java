
/**
 * Write a description of class Ingredient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ingredient
{
    String name;
    QuantityTypes types;
    int quantity;
    String txtQuantity;

    public Ingredient(String name, QuantityTypes types, int quantity)
    {
        this.name = name;
        this.types = types;
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public QuantityTypes getType()
    {
        return types;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public String getTXTQuantity()
    {
        return txtQuantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public void setQuantityType(QuantityTypes types)
    {
        this.types = types;
    }

    public String createTextQuantity()
    {
        return (quantity + " " + types);
    }
}