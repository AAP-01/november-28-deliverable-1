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
    ArrayList<String> stepsList;

    public Instruction()
    {
        stepsList = new ArrayList<>();
    }
    
    public void printSteps()//shows the added steps in terminal
    {
        int index = 1;
        for(String step : stepsList)
        {
            System.out.println(index + ". " + step.replace(".", ""));
            index++;
        }
    }
    
    public String getSteps()
    {
        int index = 1;
        String info = "";
        for (String step : stepsList)
        {
            info = info + "- - " + index + ". " + step + "\n";
            index++;
        }
        return info;
    }

    public void addStep(String step, int index)//add a step in a particular position (ie manually)
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