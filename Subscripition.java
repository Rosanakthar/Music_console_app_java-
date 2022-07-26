
package musicapplication;
import java.text.*;  
import java.util.*;
public class Subscripition {
    static List<Subscripition> subscription = new ArrayList<Subscripition>();
    static int no_id=1;
    int subId;
    int userId;
    String status,duration,startDate,endDate;
    public Subscripition(int userId,String status,String duration,String startDate,String endDate){
        this.subId = no_id++;
        this.status = status;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate  = endDate;
        this.userId = userId;
        subscription.add(this);
    }
    
    // subscribe the account
    void subscribeAcc(int pos,int duration){
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         Date date = new Date();
         Calendar cal = Calendar.getInstance();
         subscription.get(pos).startDate = sdf.format(cal.getTime());
         cal.add(Calendar.DAY_OF_MONTH,duration);
         subscription.get(pos).endDate = sdf.format(cal.getTime());
         subscription.get(pos).status = "Subscribed";
         subscription.get(pos).duration = "";
         
         System.out.println("Sub id :"+subscription.get(pos).subId+"\nsub Status : "+subscription.get(pos).status+
                 "\nsub statDate : "+subscription.get(pos).startDate+"\nEnd date : "+subscription.get(pos).endDate);
    }
    
//    getting subscripitin details
    static int getSubscribe(int userId){
        for(int i=0;i<subscription.size();i++){
            if(subscription.get(i).userId == userId){
                return i;
            }
        }
        return -1;
    }

    
}
