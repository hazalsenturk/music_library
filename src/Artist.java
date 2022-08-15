import java.util.ArrayList;

public class Artist extends Entity {

    protected ArrayList<Song> songs;
    protected ArrayList<Album> albums;

    public Artist(String name) {
        super(name);
    }

    protected ArrayList<Song> getSongs() {
        return songs;
    }

    protected void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    protected ArrayList<Album> getAlbums() {
        return albums;
    }

    protected void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    public void addSong(Song s) {
        songs.add(s);
    }

    public String toXML() {
        return "\t<artist id= \"" + this.entityID + "\">\n" +
                "\t\t<name>" + this.name + "</name>\n" +
                "\t</artist>";
    }

    public String toJSON() {
        return "{" +
                "\"id\": \"" + this.entityID + "\","+
                "\"name\": \""  + this.name + "\""+
                "}";
    }
}
