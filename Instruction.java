import java.util.ArrayList;

/**
 * Write a description of class Instruction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Instruction
{
    String instruction;
    ArrayList<String> stepsList = new ArrayList<>();

    public Instruction()
    {
        
    }
    
    public void printSteps()
    {
        int index = 1;
        for(String step : stepsList)
        {
            System.out.println(index + ". " + step);
            index++;
        }
    }

    public void addStep(String step, int index)
    {
        stepsList.add(index, step);
    }

    public void addStep(String step)
    {
        stepsList.add(step);
    }

    public void removeStep(int index)
    {
        stepsList.remove(index);        
    }
}