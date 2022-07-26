package musicapplication;
import java.util.*;
public class users {
    static List<users> usersList = new ArrayList<users>();
    static int no_userId = 1;
    int userId;
    String name,mobilenumber,type;
    String password;
    Subscripition subscripition;
    List<PlayList> purchasedList = new ArrayList<PlayList>();
    users(String name,String mobilenumber,String type,String password){
        this.userId = no_userId++;
        this.name = name;
        this.mobilenumber = mobilenumber;
        this.type = type; 
        this.password = password;
        //add subscripition
        usersList.add(this);
        Subscripition sub = new Subscripition(this.userId,"NotPaid",null,null,null);
        System.out.println("Account successfully Created");
        System.out.println("Your subscripition id is : "+Subscripition.subscription.get(userId-1).subId+" and "
                + "Your User id is :"+this.userId);
    }
    
    
    //add purchsed album to the list
    
    void addAlbum(int albumId , String AlbumName){
        int i=0;
        for(PlayList play  : PlayList.playList ){
            if(play.name.equals(AlbumName)&&play.playListId==albumId&&play.playlistType.equals("album")){
                this.purchasedList.add(play);
                System.out.println("Your purchase is successfully completed your albumis added");
                i=1;
                break;
            }
        }
        if(i==0){
            System.out.println("Album is not found");
        }
    }
    
//checking admin user
    static boolean checkUser(int userId){
        for(int i=0;i<usersList.size();i++){
            if(usersList.get(i).userId == userId &&usersList.get(i).type.equals("admin") ){
                return true;
            }
        }
        return false;
    }
//    checking normal user is valid or not
    static boolean checkUserMobile(int userId,String mobilenumber){
        for(int i=0;i<usersList.size();i++){
            if(usersList.get(i).userId == userId &&usersList.get(i).mobilenumber.equals(mobilenumber) ){
                return true;
            }
        }
        return false;
    }
    //get user position
    static int userPosition(int userId){
        for(int i=0;i<usersList.size();i++){
            if(usersList.get(i).userId == userId){
                return i;
            }
        }
        return 0;
    }
    
}
