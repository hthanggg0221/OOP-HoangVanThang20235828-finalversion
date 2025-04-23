package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompareDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompareDisc() {
        super();
    }

    public CompareDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompareDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompareDisc(String title, String category, String director, int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        for (Track i : tracks) {
            if (Objects.equals(i, track)) {
                System.out.println("Track \"" + track.getTitle() + "\" already exists in the list.");
                return;
            }
        }
        tracks.add(track);
        System.out.println("Track \"" + track.getTitle() + "\" has been added.");
    }

    public void removeTrack(Track track) {
        for (int i = 0; i < tracks.size(); i++) {
            if (Objects.equals(tracks.get(i), track)) {
                System.out.println("Track \"" + track.getTitle() + "\" has been deleted.");
                tracks.remove(track);
                return;
            }
        }
        System.out.println("Track \"" + track.getTitle() + "\" does not exist in the list.");
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());

        System.out.println("Information of Compact Disc : \n");
        for (Track track : tracks) {
            track.play();
        }
    }
}
