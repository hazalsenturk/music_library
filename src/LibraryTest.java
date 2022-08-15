import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

        Library lib1;
        Song s1,s2,s3,s4, s5, s6,s7, s8, s9, s10;

        @BeforeEach
        void setup() {
            lib1 = new Library();

            s1 = new Song("Song 1",40, "Album 1", "artist1", true,  "jazz");
            s2 = new Song("Song 2", 339, "Album 2", "artist2", false,"jazz");
            s3 = new Song("Song 3",40, "Album 3", "artist3", true , "pop");
            s4 = new Song("Song 4", 339,"Album 4", "artist4", true , "rock");
            s5 = new Song("Song 5",40,"Album 5", "artist5", true ,"jazz");
            s6 = new Song("Song 6", 339, "Album 6", "artist6", true ,"jazz");
            s7 = new Song("Song 7",40, "Album 7", "artist7", false, "r&b");
            s8 = new Song("Song 8", 339, "Album 8", "artist8", false ,"jazz");

            // Songs to test duplicates and addition
            s9 = new Song("Song 1", 40, "Album 1", "Artist 1", true);
            s10 = new Song("Song 10", 40, "Album 1", "artist10" , true);

        }


        @Test
    void writeXML() {
            lib1.addSongs(s1);
            lib1.addSongs(s2);
            lib1.addSongs(s3);
            lib1.addSongs(s4);
            lib1.addSongs(s5);
            lib1.addSongs(s6);
            lib1.addSongs(s7);
            lib1.addSongs(s8);
            lib1.addSongs(s9);
            lib1.addSongs(s10);
            lib1.writeXML();

    }

    @Test
    void JSON(){
        lib1.addSongs(s1);
        lib1.addSongs(s2);
        lib1.addSongs(s3);
        lib1.addSongs(s4);
        lib1.addSongs(s5);
        lib1.addSongs(s6);
        lib1.addSongs(s7);
        lib1.addSongs(s8);
        lib1.addSongs(s9);
        lib1.addSongs(s10);
        lib1.writeJSON();
    }

}