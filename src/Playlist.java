import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Playlist extends Entity{

    private ArrayList<Song> listOfSongs;

    public Playlist(String name) {
        super(name);
        listOfSongs = new ArrayList<Song>();
    }

    public boolean addSong(Song s) {
        return listOfSongs.add(s);
    }

    public boolean deleteSong(Song s) {
        return listOfSongs.remove(s);
    }

    public boolean findSong(Song s){
        return listOfSongs.contains(s);
    }

    public List<Song> sortList() {
        List<Song> sl = listOfSongs.stream().sorted(Comparator.comparing(Song::getLiked)).collect(Collectors.toList());
        return sl;
    }

    public ArrayList<Song> getSongs(){
        ArrayList<Song> list = new ArrayList<Song>();
        list.addAll(listOfSongs);
        return list;
    }

    public List<Song> mergeLists(List<Song> otherList){

        List<Song> list2 = new ArrayList<Song>(listOfSongs);
        list2.removeAll(otherList);
        listOfSongs.addAll(list2);
        System.out.println(listOfSongs);
        return listOfSongs;

    }

    public List<Song> shuffleList() {
        Collections.shuffle(listOfSongs);
        return listOfSongs;
    }

    public List<Song> randomList(String g){
        List<Song> list = listOfSongs.stream().filter(s -> s.genre.equals(g)).collect(Collectors.toList());
        return list;
    }
}