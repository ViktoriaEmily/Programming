/**
 * @author Wiktoria Pieczykolan
 * @version 1.0
 */
public class Song {

    private String songName;
    private String songGenre;
    private int songLength;
    private Artist artist;

    /**
     * Constructor for objects in class Song
     * songName Name of the Song
     * songGenre Genre of the Song
     * songLength Length of the Song
     * artist Artist of the Song
     */

    /**
     * public Song holds the String to the layout in the menu
     * if the song length entered is less than 30, the name will be trimmed
     * otherwise the name of the song will be returned
     */

    public Song(String songName, String songGenre, int songLength, Artist artist) {

        if (songName.length() > 30) {
            this.songName = songName.substring(0, 30);
        } else {
            this.songName = songName;
        }

        /**
         * if any of the following song genres are entered , the song genre will be returned, the casing of the genres are ignored as
         * the user may choose to use both lower and upper case, just lower or just upper, yet still has to find the genre.
         * if the genre does not fall under the categories stored, return unknown.
         */

        if (songGenre.equalsIgnoreCase("Rock") || songGenre.equalsIgnoreCase("Pop")
                || songGenre.equalsIgnoreCase("Blues") || songGenre.equalsIgnoreCase("Rap")
                || songGenre.equalsIgnoreCase("Dance") || songGenre.equalsIgnoreCase("Classical")) {
            this.songGenre = songGenre;
        } else {
            this.songGenre = "unknown";
        }

        /**
         * if the songLength is greater or equal to 10 and less than or equal to 1200 return the songLength,
         * if it falls outside that range return 0.
         */
        if (songLength >= 10 && songLength <= 1200) {
            this.songLength = songLength;
        } else {
            this.songLength = 0;
        }

        /**
         * if the artist is not null store this value (artist),
         * otherwise if it us null ,create new artist object
         */
        if (artist != null) {
            this.artist = artist;
        } else {
            this.artist = new Artist("", "", "");
        }
    }
        //Getters

        public String getSongName () {
            return songName;
        }

        public String getSongGenre () {
            return songGenre;
        }

        public int getSongLength () {
            return songLength;
        }

        public Artist getArtist () {
        return artist;
         }

         //Setters

    /**
     * not over riding the contructors
     */

    /**
     * Updates the Song Name to the value passed as a parameter
     *
     * @param songName is the new Song Name
     */

        public void setSongName (String songName){
            if (songName.length() > 30) {
                this.songName = songName.substring(0, 30);
            } else {
                this.songName = songName;
            }
        }

    /**
     * Updates the Song Genre to the value passed as a parameter
     *
     * @param songGenre is the new songGenre
     */

        public void setSongGenre (String songGenre){
            if (songGenre.equalsIgnoreCase("Rock") || songGenre.equalsIgnoreCase("Pop")
                    || songGenre.equalsIgnoreCase("Blues") || songGenre.equalsIgnoreCase("Rap")
                    || songGenre.equalsIgnoreCase("Dance") || songGenre.equalsIgnoreCase("Classical")) {
                this.songGenre = songGenre;
            }
        }

    /**
     * Updates the songLength to the value passed as a parameter
     *
     * @param songLength is the new songLength
     */

        public void setSongLength ( int songLength){
            if (songLength >= 10 && songLength <= 1200) {
                this.songLength = songLength;
            }
        }



        public void setArtist (Artist artist){
            if (artist != null) {
                this.artist = artist;
            }
        }

    /**
     * Builds String representing a user friendly representation of the object state
     *
     * @return Details of the specific song
     */

        @Override
        public String toString () {
            return songName + ", Artist:" + artist +"("+ songLength/60 +";" + songLength%60 +"), Genre: " + songGenre;
        }
    }

