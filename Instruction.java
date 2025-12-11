import java.util.ArrayList;

/**
 * Write a description of class Instruction here.
 *
 * @author John
 * @version (a version number or a date)
 */
public class Instruction
{
    String instruction;
    ArrayList<String> stepsList;

    /**
     * This constructor creates a new Arraylist for the steps.
     */
    public Instruction()
    {
        stepsList = new ArrayList<>();
    }
    
    /**
     * printSteps() prints all the steps in the ArrayList in the terminal.
     */
    public void printSteps()//shows the added steps in terminal
    {
        int index = 1;
        for(String step : stepsList)
        {
            System.out.println(index + ". " + step.replace(".", ""));
            index++;
        }
    }
    
    /**
     * getSteps() gets all the steps in the info variable.
     */
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

    /**
     * addStep(String step, int index) manually adds a step in the list in 
     * a given position.
     * @param step The step.
     * @param index The position of the step in the list.
     */
    public void addStep(String step, int index)//add a step in a particular position (ie manually)
    {
        stepsList.add(index, step);
    }

    /**
     * addStep(String step) adds a step in the list in the most recent 
     * position.
     * @param step The step.
     */
    public void addStep(String step)
    {
        stepsList.add(step);
    }

    /**
     * removeStep(int index) removes the step linked to the inputted index 
     * (the step's position in the list).
     * @param index The position of the step in the list.
     */
    public void removeStep(int index)
    {
        stepsList.remove(index);        
    }
}