import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SongList {
    private ArrayList<Song> songs = new ArrayList<>();

    /**
     * Adds a song to the SongList
     */

    public void addSong(Song song) {
        songs.add(song);
    }

    public Song getSong(int ind) {
        if ((ind >= 0) && (ind < numberOfSongs())) {
            return songs.get(ind);
        } else {
            return null;
        }
    }

    public boolean removeSong(int ind) {
        if ((ind >= 0) && (ind < numberOfSongs())) {
            songs.remove(ind);
            return true;
        } else {
            return false;
        }
    }

    public int numberOfSongs() {
        return songs.size();
    }

    public String listOfSongs() {
        if (songs.size() == 0) {
            return "There are no songs in the list";
        }
        String S = "";
        for (int i = 0; i < songs.size(); i++) {
            S = S + i + ':' + songs.get(i).toString();
        }
        return S;
    }

    public String listSongsBySpecificGenre(String specificGenre) {
    String result="";
        boolean specifiedGenre = false;
        if (songs.isEmpty()) {
            return "no songs stored";
        } else {
            String listSongsBySpecificGenre = "";
            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getSongGenre().equalsIgnoreCase(specificGenre)) {
                   result += songs.get(i).toString()+"\n";
                    specifiedGenre = true;
                }
            }

            if (specifiedGenre) {
                return result;
            } else {
                return "no songs with the genre" + specificGenre;
            }
        }
    }

    public String listSongsBySpecificArtist(String artistName) {

        boolean specifiedArtist = false;
        if (songs.isEmpty()) {
            return "There are no songs stored in the list";
        } else {
            String listSongsBySpecificArtist = "";
            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getArtist().getArtistName().toLowerCase().contains(artistName.toLowerCase())) {
                    specifiedArtist = true;
                }
            }

            if (specifiedArtist) {
                return listSongsBySpecificArtist;
            } else {
                return "no songs with the artist" + artistName;
            }
        }
    }

    public Song longestSong() {
        if (!songs.isEmpty()) {
            Song longestSong = songs.get(0);
            for (Song song : songs) {
                if (song.getSongLength() > longestSong.getSongLength())
                    longestSong = song;
            }
            return longestSong;
        } else return null;
    }

    public double averageSongLength() {
        if (songs.size() != 0) {
            double allLength = 0;
            for (int i = 0; i < songs.size(); i++) {
                allLength = allLength + songs.get(i).getSongLength();
            }
            return toTwoDecimalPlaces(allLength / songs.size());
        } else {
            return 0.0;
        }
    }

    public int lengthOfAllSongs() {
        if (songs.size() != 0) {
            int allLength = 0;
            for (int i = 0; i < songs.size(); i++) {
                allLength = allLength + songs.get(i).getSongLength();
            }
            return allLength;
        }
        return 0;
    }

        public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("songs.xml"));
        songs = (ArrayList<Song>) is.readObject();
        is.close();
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("songs.xml"));
        out.writeObject(songs);
        out.close();
    }

    private double toTwoDecimalPlaces(double decimal){
        return (int)(decimal*100)/100.0;
    }
}