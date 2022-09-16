/**
 * @author Wiktoria Pieczykolan
 * @version 1.0
 */

public class Artist {
    private String artistName;
    private String artistEmail;
    private String artistPhone;

    /**
     * Constructor for objects in class Artist
     * artistName Name of the Artist
     * artistEmail Email of the Artist
     * artistPhone Phone of the Artist
     */

    /** public Artist formats the String in order
     * if the artist name length entered by the user is greater than 30, the name will be trimmed.
     * if the artist is name entered is less than 30, the artistName entered will be returned
     *
     */

    public Artist(String artistName, String artistEmail, String artistPhone) {
        if (artistName.length() > 30) {
            this.artistName = artistName.substring(0, 30);
        } else {
            this.artistName = artistName;
        }

        /** if the email entered by the user contains the "@" and "." the artistEmail will be returned
         * if it doesn't contain the "@" and ".", an "invalid format email" message will appear.
         */

        if (artistEmail.contains("@") && artistEmail.contains(".")) {
            this.artistEmail = artistEmail;
        } else {
            this.artistEmail = "invalid format email";
        }

        /** if the artistPhone mathec the specification of using only numbers the artistPhone will be returned,
         * otherwise unknown.
          */

        if (artistPhone.matches("[0-9]+")) {
            this.artistPhone = artistPhone;
        } else {
            this.artistPhone = "unknown";
        }

        //Getters//
    }

    public String getArtistEmail() {
        return artistEmail;                     //Returns Artist Email//
    }

    public String getArtistPhone() {
        return artistPhone;                     //Returns Artist Phone//
    }

    public String getArtistName() {
        return artistName;                      //Returns Artist Name//
    }

    //Setters//

    /**
     * Updates the Artist Name to the value passed as a parameter
     *
     * @param artistName is the new Artist Name
     */

    public void setArtistName(String artistName) {

        if (artistName.length() > 30) {
            this.artistName = artistName.substring(0, 30);
        } else {
            this.artistName = artistName;
        }

    }

    /**
     * Updates the Artist Email to the value passed as a parameter
     *
     * @param artistEmail is the new Artist Email
     */

    public void setArtistEmail(String artistEmail) {
        if (artistEmail.contains("@") && artistEmail.contains(".")) {
            this.artistEmail = artistEmail;
        }
    }

    /**
     * Updates the Artist Phone to the value passed as a parameter
     *
     * @param artistPhone is the new Artist Phone
     */

    public void setArtistPhone(String artistPhone) {
        if (artistPhone.matches("[0-9]+")) {
            this.artistPhone = artistPhone;
        }
    }

    /**
     * Builds String representing a user friendly representation of the object state
     *
     * @return Details of the specific artist
     */

    @Override
    public String toString() {
        return "Artist{" + "artistName='" + artistName + '\'' + ", artistEmail='" + artistEmail + '\'' + ", artistPhone='" + artistPhone + '\'' + '}';
    }
}

