package LabOOP;

interface Playable{
    void play();
}

public class DJ {
    public void play(){
        System.out.println("Playing ");
    }
    void playSong(Song song){
        System.out.println(song);
    }
}
