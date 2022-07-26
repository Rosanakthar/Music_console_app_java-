
package musicapplication;
import java.util.*;
public class Music {
    static List<Music> music = new ArrayList<Music>();
    static int musId = 1;
    int musicId = 0,userid;
    String artist,album,year,gener,song;
    Music(int userid,String artist,String song,String album,String year,String gener){
        this.musicId = musId++;
        this.artist = artist;
        this.song = song;
        this.userid = userid;
        this.album = album;
        this.year = year;
        this.gener = gener;
        music.add(this);
        System.out.println("Music added Successfully");
        
    }
    public static void showSongs(){
        for(Music mu:music){
            System.out.println("Music id is : "+mu.musicId+"    Album Name : "+mu.album+"   Artist : "+mu.artist+""
                    + " Songe Name : "+mu.song);
        }
    }
    
}
