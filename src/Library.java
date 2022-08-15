import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Library extends Entity {

    public static ArrayList<Song> songs;
    public static ArrayList<Album> albums;
    public static ArrayList<Artist> artist;
    public ArrayList<Integer> listID = new ArrayList<>();

    public Library() {
        songs = new ArrayList<Song>();
        albums = new ArrayList<Album>();
        artist = new ArrayList<Artist>();
    }

    public static void addAlbums(Album a) {
        if(!albums.stream().anyMatch( x -> a.equals(x))){
            albums.add(a);
        }
    }

    public static void addArtist(Artist a) {
        if(!artist.stream().anyMatch( x -> a.equals(x))){
            artist.add(a);
        }
    }

    public static void addSongs(Song s) {
        if (!songs.contains(s)) {
            songs.add(s);
            addAlbums(s.getAlbum());
            addArtist(s.getArtist());
        }
        addAlbums(s.getAlbum());
        addArtist(s.getArtist());
    }

    public static void addSongsXML(Song s) {
        if (!songs.contains(s)) {
            songs.add(s);
        }
    }

    public boolean checkDup(Song sng){
        if (listID.contains(sng.entityID)) {
            return false;
        } else {
            for (Song s : songs) {
                if (sng.entityID != s.entityID) {
                    if (
                            sng.getName().equals(s.getName()) &&
                                    (sng.getAlbum().getName().equals(s.getAlbum().getName()) ||
                                            sng.getArtist().getName().equals(s.getArtist().getName()))) {
                        listID.add(s.entityID);
                        return true;
                    } else if (
                            sng.getAlbum().getName().equals(s.getAlbum().getName()) &&
                                    sng.getArtist().getName().equals(s.getArtist().getName()) &&
                                    sng.getName().toLowerCase().replaceAll("\\p{Punct}", "")
                                            .equals(s.getName().toLowerCase().replaceAll("\\p{Punct}", "")))
                    {
                        listID.add(s.entityID);
                        return true;
                    }
                }
            }
            return false;
        }
    }


    public void duplicates() {
        if (songs.stream()
                .anyMatch(sng -> checkDup(sng) == true)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("There are duplicates in the library. Do you wish to remove them? (y/n)");
            String input = sc.nextLine().toLowerCase();
            if (input.equals("y")) {
                songs.removeIf(sng -> listID.contains(sng.entityID));
            } else {
                System.out.println(" Invalid input.");
            }
        } else {
            System.out.println("There are no duplicate songs in the library.");
        }
    }

    public boolean findSongs(Song s) {
        return songs.contains(s);
    }

    public boolean getLiked(boolean liked) {

        if (liked == true) {
            return true;
        }
        return false;

    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public void writeXML(){

        try {
            FileWriter fw = new FileWriter("sample.xml");
            fw.write("<Library>\n" );
            fw.write("<songs>\n" );
            for (Song s: songs) {
                fw.write(s.toXML()+ "\n");
            }
            fw.write("</songs>\n" );

            fw.write("<artists>\n" );
            for (Artist art: artist) {
                fw.write(art.toXML()+ "\n");
            }
            fw.write("</artists>\n" );

            fw.write("<albums>\n" );
            for (Album a: albums) {
                fw.write(a.toXML()+ "\n");
            }
            fw.write("</albums>\n" );

            fw.write("</Library>");

            fw.close();
            System.out.println("Successfully written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void writeJSON(){

        try {
            FileWriter fw = new FileWriter("sample.json");
            fw.write("{\n" );
            fw.write("\"songs\" : [ \n" );
            int size = 0;
            for (Song s: songs) {

                fw.write(s.toJSON()+ "\n");
                size++;

                if(size <= songs.size() - 1){
                    System.out.println(size);
                    fw.write("," );
                }
            }
            fw.write("],\n" );
            size = 0;
            fw.write("\"artists\" : [ \n" );

            for (Artist art: artist) {

                fw.write(art.toJSON()+ "\n");
                size++;

                if(size <= artist.size() - 1){
                    System.out.println(size);
                    fw.write("," );
                }
            }
            fw.write("],\n" );
            size = 0;
            fw.write("\"albums\" : [ \n");
            for (Album a: albums) {
                fw.write(a.toJSON()+ "\n");
                size++;

                if(size <= albums.size() - 1){
                    System.out.println(size);
                    fw.write("," );
                }
            }

            fw.write("]\n}" );
            fw.close();

            System.out.println("Successfully written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    public static void main(String[] args){

        Library lib;
        lib = new Library();
        Song s1, s2, s3, s4;


        s1 = new Song("Song 1","Album 1", "artist1");
        s2 = new Song("Song 2","Album 2", "artist2");
        s3 = new Song("Song 3","Album 3", "artist3");
        s4 = new Song("Song 4","Album 4", "artist4");
        lib.songs.add(s1);
        lib.songs.add(s2);
        lib.songs.add(s3);
        lib.songs.add(s4);
        System.out.println(songs.size());


        for (int i = 0; i < songs.size(); i++) {
            System.out.println(songs.get(i).getName());
        }

    }
}


