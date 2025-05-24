package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String artist, int length, String director) {
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
    public void play() throws PlayerException {
        if(this.getLength() > 0) {
            for (Track track : tracks) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
            java.util.Iterator iter = tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                }catch(PlayerException e) {
                    throw e;
                }
            }
        }else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
}
