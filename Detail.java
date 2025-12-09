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
    
    public void printDetails()//shows the added steps in terminal
    {
        int index = 1;
        for(String detail : detailsList)
        {
            System.out.println(index + ". " + detail.replace(".", ""));
            index++;
        }
    }
    
    public String getDetails()
    {
        int index = 1;
        String info = "";
        for (String detail : detailsList)
        {
            info = info + "- - " + index + ". " + detail + "\n";
            index++;
        }
        return info;
        
        // for(Detail detail : detailsList)
        // {
            // if(desert.isFrozen)
            // {
                
            // }
        // }
    }

    public void addDetail(String step, int index)//add a step in a particular position (ie manually)
    {
        detailsList.add(index, step);
    }

    public void addDetail(String detail)
    {
        detailsList.add(detail);
    }

    public void removeDetail(int index)
    {
        detailsList.remove(index);        
    }
}
