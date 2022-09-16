import java.util.Scanner;

/**
 * This class manages the User Interface (U.I)
 * i.e. the menu and the user input/output
 * The Driver class is a menu driven application where the user can choose to
 * enter Song Names and/or Artist Name
 */

public class Driver {

    private Scanner input = new Scanner(System.in);
    /**
     * input is an object of the Scanner class
     */
    private ArtistList artistList;
    /**
     * artistList is an object of the ArtistList class
     */
    private SongList songList;

    /**
     * songList is an object of the Songlist class
     */

    public Driver() {
        artistList = new ArtistList();
        songList = new SongList();
        runMenu();
    }

    public static void main(String[] args) {
        new Driver();
    }

    /**
     * mainMenu() - displays the menu, reads the menu option that user entered and returns it.
     *
     * @return - is the menu option entered by the user.
     */


    private int mainMenu() {
        System.out.println("Songify Menu");
        System.out.println("----------");
        System.out.println("    1) Add an Artist");
        System.out.println("    2) List all Artists");
        System.out.println("    3) Remove an Artist (by index)");
        System.out.println("----------");
        System.out.println("    4) Add a Song");
        System.out.println("    5) List all Songs");
        System.out.println("    6) List all Songs in a Genre");
        System.out.println("    7) List all Songs by Artist");
        System.out.println("    8) List Song Statistics");
        System.out.println("    9) Remove a Song (by index)");
        System.out.println("----------");
        System.out.println("    10) Save to XML");
        System.out.println("    11) Load from XML");
        System.out.println("----------");
        System.out.println("    0) Exit");
        System.out.println("==>>");
        int option = input.nextInt();
        return option;
    }

    private void runMenu() {
        int option = mainMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    addArtist();
                    break;
                case 2:
                    System.out.print(artistList.listOfArtists());
                    break;
                case 3:
                    deleteArtist();
                    break;
                case 4:
                    addSong();
                    break;
                case 5:
                    System.out.print(songList.listOfSongs());
                    break;
                case 6:
                    listSongByGenre();
                    break;
                case 7:
                    listSongByArtist();
                    break;
                case 8:
                    listSongStats();
                    break;
                case 9:
                    deleteSong();
                    break;
                case 10:
                    save();
                    break;
                case 11:
                    load();
                    break;
                default:
                    System.out.println("Invalid option selected");
                    break;
            }

            /**
             * pause the program so that the user can read what we just printed to the terminal window
             */
            System.out.println("\nPress any key to continue...");
            input.nextLine();

            /**
             * display the main menu again - important otherwise stuck on loop asking same questions
             */
            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }


    /**
     * prints out the average song length and the length of all the songs
     */
    private void listSongStats() {
        System.out.println("Average Song Length:");
    }

    private void listSongByArtist() {
    }

    private void listSongByGenre() {
        System.out.println("Enter a Genre");
    }

    private Artist addArtist() {
        System.out.print("Please enter the following artist details...");
        String enter = input.nextLine();
        System.out.print("      Name (max 30 chars):");
        String name = input.nextLine();
        System.out.print("      Email (must contain @ and .):");
        String email = input.nextLine();
        System.out.print("      Phone (numbers only:)");
        String phone = input.nextLine();
        Artist art = new Artist(name, email, phone);
        artistList.addArtist(art);
        return (art);
    }


    private void deleteArtist() {
        System.out.print(artistList.listOfArtists());

        System.out.print("Index of artists to delete ==>");
        int delete = input.nextInt();

        artistList.removeArtist(delete);

    }

    /**
     * Askd the user to enter the song name,genre, length of the song in minutes and length of the song in seconds
     * displays list of artists, the user then selects a number from the index
     * if there are no artists with that song in the system, the user will be asked to enter the artist details
     * the song will then be stored in the SongList class
     */

    private void addSong() {
        Artist artist = null;
        System.out.print("Please enter the following song details...");
        System.out.print("      Name (max 30 chars):");
        String sName = input.nextLine();
        System.out.print("      Genre (ROCK,POP,BLUES,RAP.DANCE,CLASSICAL):");
        String sGenre = input.nextLine();
        int sMinutes = ScannerInput.readNextInt(" Length of Song(minutes)");
        int sSeconds = ScannerInput.readNextInt("Length of Song (seconds)");
        int sLength = (sMinutes * 60) + sSeconds;

        if (artistList.numberOfArtists()==0) {
            artist = addArtist();
        }
        else {
            System.out.println(artistList.listOfArtists());
            int ind = ScannerInput.readNextInt("Choose the artist by index number");
            artist = artistList.getArtist(ind);
        }
        songList.addSong(new Song(sName,sGenre,sLength,artist));

    }

    /**
     * asks user to enter the song to delete by entering the index it coresponds to,
     * if the song is valid the song is deleted from the list.
     * otherwise "there is no song for this index number"
     */
    private void deleteSong() {
        System.out.print(songList.listOfSongs());

        System.out.print("Index of songs to delete ==>");
        int delete = input.nextInt();

        songList.removeSong(delete);

    }


    private void save() {
        try {
            artistList.save();
            songList.save();
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e);
        }
    }

    private void load() {
        try {
            artistList.load();
            songList.load();
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e);
        }

    }


}

