import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlaylistTest {
    Playlist list1;
    Playlist list2;
    Playlist list3;
    String artist1, artist2, artist3, artist4, artist5, artist6, artist7, artist8, artist10;
    Song s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    Boolean T=true, F=false;

    @BeforeEach
    void setUp(){

        s1 = new Song("Song 1",40, "Album 1", artist1, T ,"jazz");
        s2 = new Song("Song 2", 339, "Album 2", artist2, F , "jazz");
        s3 = new Song("Song 3",40, "Album 3", artist3, T , "pop");
        s4 = new Song("Song 4", 339,"Album 4", artist4, T , "rock");
        s5 = new Song("Song 5",40,"Album 5", artist5, T ,"jazz");
        s6 = new Song("Song 6", 339, "Album 6", artist6, T ,"jazz");
        s7 = new Song("Song 7",40, "Album 7", artist7, F, "r&b");
        s8 = new Song("Song 8", 339, "Album 8", artist8, F ,"jazz");

        // Songs to test duplicates and addition
        s9 = new Song("Song 1", 40, "Album 1", "Artist 1", T);
        s10 = new Song("Song 10", 40, "Album 1", artist10 , T);

        list1 = new Playlist("list1");
        list2 = new Playlist("list2");
        list3 = new Playlist("list3");

        list1.addSong(s1);
        list1.addSong(s2);
        list1.addSong(s3);
        list1.addSong(s4);
        list2.addSong(s5);
        list2.addSong(s6);
        list2.addSong(s7);
        list2.addSong(s8);
        list3.addSong(s1);
        list3.addSong(s2);
        list3.addSong(s3);
        list3.addSong(s4);
        list3.addSong(s5);
        list3.addSong(s6);
        list3.addSong(s7);
        list3.addSong(s8);

    }


    @Test
    void testAddSong(){
        list1.addSong(s10);
        System.out.println(list1.getSongs());
//        assertTrue(list1.findSong(s1));
    }

    @Test
    void testDeleteSong(){
        list1.deleteSong(s1);
        list1.getSongs();
        assertFalse(list1.findSong(s1));
    }

    @Test
    void sortList() {
        list1.getSongs();
        list1.sortList();
        System.out.println(list1);

    }

    @Test
    void mergeLists() throws Exception {
        list2.addSong(s9);
        list1.mergeLists(list2.getSongs());
        //System.out.println(list1.getSongs());
    }

    @Test
    void shuffleList() {
        System.out.println(list1.getSongs());
        list1.shuffleList();
        System.out.println(list1.getSongs());
    }

    @Test
    void findSong() {
        assertTrue(list1.findSong(s1));
    }

    @Test
    void randomList() {
        //System.out.println(list3.getSongs());
        System.out.println(list3.randomList("jazz"));
    }
}