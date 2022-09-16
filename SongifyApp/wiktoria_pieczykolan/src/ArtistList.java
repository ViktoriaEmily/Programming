import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArtistList {
    private ArrayList<Artist> artists = new ArrayList<>();

    /**
     * Add an artist to the ArtistList
     *
     * @param artist Artists to add to the list
     */

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public Artist getArtist(int artistNumber) {
        if (artists.size() == 0) {
            return null;
        } else if (artistNumber >= 0 && artistNumber < artists.size())
            return artists.get(artistNumber);

        else {
            return null;
        }
    }

    public int numberOfArtists() {
        return artists.size();
    }

    public boolean removeArtist(int ind) {
        if ((ind >= 0) && (ind < numberOfArtists())) {
            artists.remove(ind);
            return true;
        } else {
            return false;
        }
    }

    public String listOfArtists() {
        if (artists.size() == 0) {
            return "There are no artists in the list";
        }
        String A = "";
        for (int i = 0; i < artists.size(); i++) {
            A = A + i + ':' + artists.get(i).toString();
        }
        return A;
    }

    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("artists.xml"));
        artists = (ArrayList<Artist>) is.readObject();
        is.close();
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("artists.xml"));
        out.writeObject(artists);
        out.close();
    }}
