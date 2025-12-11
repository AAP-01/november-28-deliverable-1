import java.util.ArrayList;

/**
 * Write a description of class Details here.
 *
 * @author (John)
 * @version (a version number or a date)
 */
public class Detail
{
    String detail;
    ArrayList<String> detailsList;
    

    public Detail()
    {
        detailsList = new ArrayList<>();
    }
    
    public void printSteps()//shows the added steps in terminal
    {
        int index = 1;
        
    }
    
    public String getSteps()
    {
        int index = 1;
        String info = "";
        for (String detail : detailsList)
        {
            info = info + "- - " + index + ". " + detail + "\n";
            index++;
        }
        return info;
    }



    public void addDetail(String step)
    {
        detailsList.add(step);
    }

    public void removeDetail(int index)
    {
        detailsList.remove(index);        
    }
}
