package musicapplication;
import java.util.*;
public class MusicApplication {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner obj = new Scanner(System.in);
        int choice = 0;
        
        while(choice != -1){
            System.out.println("Enter your choice: \n "
                + "1:Creater User Account \n 2:Creater Admin User Account \n 3:Admin:-> Add music\n"
                    + "4:->Add songe to playlist\n"
                    + "5:- View play list\n"
                    + "6:- Subscribe the application\n"
                    + "7:- purchase album\n"
                    + "8:- Filter the music");
            choice = obj.nextInt();
            switch(choice){
                case 1:
                    obj.nextLine();
                    System.out.println("Enter your Name");
                    String name = obj.nextLine();
                    System.out.println("Enter your Mobile Number");
                    String mobilenumber = obj.nextLine();
                    System.out.println("Enter your Password");
                    String password = obj.nextLine();
                    users user = new users(name,mobilenumber,"user",password);
                    break;
                 case 2:
                    obj.nextLine();
                    System.out.println("Enter your Name");
                    String name1 = obj.nextLine();
                    System.out.println("Enter your Mobile Number");
                    String mobilenumber1 = obj.nextLine();
                    System.out.println("Enter your Password");
                    String password1 = obj.nextLine();
                    users user1 = new users(name1,mobilenumber1,"admin",password1);
                    break;
                case 3:
                    obj.nextLine();
                    System.out.println("Enter your userid");
                    int userid = obj.nextInt();
                    if(!users.checkUser(userid)){
                       System.out.println("User id not found");
                       break;
                    }
                    obj.nextLine();
                    System.out.println("Enter artist name");
                    String artist = obj.nextLine();
                    System.out.println("Enter Song name");
                    String song = obj.nextLine();
                    System.out.println("Enter your Album name");
                    String albumName = obj.nextLine();
                    System.out.println("Enter your year");
                    String year = obj.nextLine();
                    System.out.println("Enter your gener");
                    String gener = obj.nextLine();
                    Music music = new Music(userid,artist,song,albumName,year,gener);
                    int position = PlayList.playListposition(userid, albumName);
                   if(position == -1){
                       PlayList album = new PlayList(albumName,userid,"album");
                    album.addMusic(music);
                    break;
                   }
                    PlayList.playList.get(position).addMusic(music);
                    break;
                case 4:
                    obj.nextLine();
                    System.out.println("Enter your userid");
                    int user_id = obj.nextInt();
                    obj.nextLine();
                    System.out.println("Enter your mobilenumber which your used while signup");
                    String mobile_number = obj.nextLine();
                    if(!users.checkUserMobile(user_id, mobile_number)){
                        System.out.println("You Dont Have an account yet");
                        break;
                    }
                    else{
                        Music.showSongs();
                    }
                    System.out.println("Enter your playlist name");
                    String name_ = obj.nextLine();
                    int position_ = PlayList.playListposition(user_id, name_);
                    if(position_ == -1){
                       PlayList play = new PlayList(name_,user_id,"playlist");
                       System.out.println("Enter a songid which would like to add playlist");
                       int songId = obj.nextInt();
                       play.addSong(songId);
                     break;
                    }
                    System.out.println("Enter a songid which would like to add playlist");
                    int songId = obj.nextInt();
                    PlayList.playList.get(position_).addSong(songId);
                    break;
                    
                case 5:
                    obj.nextLine();
                    System.out.println("Enter your userid");
                    int userId = obj.nextInt();
                    obj.nextLine();
                    System.out.println("Enter your mobilenumber which your used while signup");
                    String mobileNumber = obj.nextLine();
                    System.out.println("Enter your playlist name");
                    String playlistname = obj.nextLine();
                    if(!users.checkUserMobile(userId, mobileNumber)){
                        System.out.println("You Dont Have an account yet");
                        break;
                    }
                    PlayList list =  PlayList.getPlaylist(userId, playlistname);
                    if(list == null){
                        System.out.println("You Dont Have an any playlist yet");
                        break;
                    }
                    for(int i=0;i<list.musiclist.size();i++){
                        System.out.println("Song Name : "+list.musiclist.get(i).song+" Artist Name  "+list.musiclist.get(i).artist
                        +"album name :"+list.musiclist.get(i).album);
                    }
                    break;
                case 6:
                    obj.nextLine();
                    System.out.println("Enter your userid");
                    int subUser = obj.nextInt();
                    int subscription = Subscripition.getSubscribe(subUser);
                     if(subscription == -1){
                        System.out.println("You Dont Have an account to subscribe");
                        break;
                    }
                    if(Subscripition.subscription.get(subscription).endDate!=null){
                        System.out.println("You already subscribed");
                        break;
                    }
//                    obj.nextLine();
                    System.out.println("Enter your duration in day \n"
                            + "OPTIONS ARE: weekely 7days \n monthly 30days \n"
                            + "Quatraly 186days \n yearly 365days");
                    int days = obj.nextInt();
                    Subscripition.subscription.get(subscription).subscribeAcc(subscription,days);
                    break;
                    
                case 7:
                    obj.nextLine();
                    System.out.println("Enter userId");
                    int purchaseUser = obj.nextInt();
                    obj.nextLine();
                    System.out.println("Enter Mobilenumber");
                    String mobileno = obj.nextLine();
                    int pos = users.userPosition(purchaseUser);
                    if(!users.checkUserMobile(purchaseUser, mobileno)){
                        System.out.println("You Dont Have an account yet");
                        break;
                    }
                    System.out.println("Choose an album which is your choice");
                    PlayList.getAlbumDetails();
                    System.out.println("Enter album_Name");
                    String album_Name = obj.nextLine();
                    System.out.println("Enter albumId");
                    int albumId = obj.nextInt();
                    users.usersList.get(pos).addAlbum(albumId, album_Name);
                    break;
                    
                case 8:
                    obj.nextLine();
                    System.out.println("List of Music are");
                    Music.showSongs();
                    
                    break;
                    
            }
            }
        }
    }
    

