import java.util.ArrayList;

public class Album extends Entity {
    protected ArrayList<Song> songs;
    protected Artist artist;

    public Album(String name) {
        super(name);
        songs = new ArrayList<Song>();
    }

    public Album(String name, String artist) {
        super(name);
        songs = new ArrayList<Song>();
        this.artist = new Artist(artist);
    }

    public String getName() {
        return name;
    }

    public boolean equals(Album otherAlbum) {
        if ((this.artist.equals(otherAlbum.getArtist())) &&
                (this.name.equals(otherAlbum.getName()))) {
            return true;
        } else {
            return false;
        }
    }

    protected ArrayList<Song> getSongs() {
        return songs;
    }

    protected void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

//    public String toString() {
//        return super.toString() + " " + this.artist;
//    }

    public String toHTML() {
        return super.toHTML() + " <br> " + this.artist + " </br>";
    }

    public String toXML() {
        return "\t<album id= \"" + this.entityID + "\">\n" +
                "\t\t<title>" + this.name + "</title>\n" +
                "\t</album>";
    }

    public String toJSON() {
        return "{" + "\"id\": \"" + this.entityID + "\","+
                "\"name\": \""  + this.name + "\""+
                "}";
    }

}
