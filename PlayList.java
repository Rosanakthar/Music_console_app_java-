
package musicapplication;

import java.util.*;

public class PlayList {
    static List<PlayList> playList = new ArrayList<PlayList>();
    static int pl_id = 1;
    int playListId;
    String playlistType;
    int userid;
    String name;
    List<Music> musiclist = new ArrayList<>();
    public PlayList(String name,int userid,String playListType){
        this.playListId = pl_id++;
        this.name = name;
        this.userid = userid;
        this.playlistType = playListType;
        playList.add(this);
    }
    
    //is already playlist
    static int playListposition(int userid,String name){
        for(int i=0;i<playList.size();i++){
            PlayList temp = playList.get(i);
            if(temp.userid == userid && temp.name.equals(name)){
                return i;
            }
        }
        return -1;
    }
    
    //setter for adding song in album
    void addMusic(Music music){
        if(music != null){
            this.musiclist.add(music);
        }
    }
    //setter for adding song in playList
    
    void addSong(int songId){
        for(Music mu:Music.music){
            if(mu.musicId==songId)
                this.musiclist.add(mu);
        }
    }
    //getter function for getting playlist
    static PlayList getPlaylist(int userId,String playListName){
        for(PlayList play:PlayList.playList){
            if(play.userid == userId && play.name.equals(playListName)){
                return play;
            }
        }
        return null;
    }

    //get all album 
    static void getAlbumDetails(){
        for(int i=0;i<playList.size();i++){
            
            if(playList.get(i).playlistType.equals("album")){
                System.out.println("Album Name : "+playList.get(i).name+"   AlbumID : "+playList.get(i).playListId);
                for(int j=0;j<playList.get(i).musiclist.size();j++){
                    System.out.println("Song name : "+playList.get(i).musiclist.get(j).song+" "
                            + " Artist name : "+playList.get(i).musiclist.get(j).artist);
                }
            }        
        }
    }    
}
