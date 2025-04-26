package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    //constructor
    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }

    public String getTitle() {

        return title;
    }

    public int getLength() {

        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj) {
        Track track = (Track) obj;
        if (this.getTitle().equals(track.getTitle())){
            return true;
        }else{
            return false;
        }


    }
}