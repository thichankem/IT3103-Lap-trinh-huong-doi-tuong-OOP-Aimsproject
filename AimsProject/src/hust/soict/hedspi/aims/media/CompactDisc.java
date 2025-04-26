package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();


    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void addTrack(Track track){
        if(!tracks.contains(track)){
            tracks.add(track);
            System.out.println("Track added to the list");
        }else{
            System.out.println("Track already exists");
        }
    }

    public void removeTrack(Track track){
        if (tracks.contains(track)){
            tracks.remove(track);
        }else{
            System.out.println("Track does not exist");
        }
    }

    public int getLength(){
        int totalLength = 0;
        for(Track track : tracks){
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public String toString(){
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " - " + this.getCost() + " - "+ this.getArtist();
    }


    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD artist: " + this.getArtist());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }
}