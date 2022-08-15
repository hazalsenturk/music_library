public class Song extends Entity {
    protected Album album;
    protected Artist artist;
    protected SongInterval duration;
    protected String genre;
    protected Boolean liked;


    public Song(String name, String album, String artist) {
        super(name);
        this.artist = new Artist(artist);
        this.album = new Album(album, artist);
    }
    public Song(String name, int length, String album, String artist, boolean liked) {
        super(name);
        this.duration = new SongInterval(length);
        this.artist = new Artist(artist);
        this.album = new Album(album, artist);
        this.liked = liked;
        genre = "";
    }

    public Song(String name, int length, String album, String artist, boolean liked, String genre) {
        super(name);
        this.duration = new SongInterval(length);
        this.artist = new Artist(artist);
        this.album = new Album(album, artist);
        this.liked = liked;
        this.genre = genre;
    }

    public Song(String name, int length) {
        super(name);
        duration = new SongInterval(length);
        genre = "";
    }

    public Song() {
    }

    public boolean equals(Song otherSong){
        if((this.album.equals(otherSong.getAlbum()) &&
                this.name.equals(getName()) &&
                this.artist.equals(otherSong.getArtist()))){
            return true;
        }else{
            return false;
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLength(int length) {
        duration = new SongInterval(length);
   }

   public String showLength() {
        return duration.toString();
   }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }


    protected Album getAlbum() {
        return album;
    }

    protected void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String toString() {
        return super.toString() + " "  + this.artist + " " + this.album  /*+ " " + this.duration*/;

    }

    public String toXML() {
        return "\t<song id= \"" + this.entityID + "\">\n" + "\t\t<title>" + this.name + "</title>\n" +
                "\t\t<artist id=\"" + this.artist.entityID + "\">" + this.artist.name + "</artist>\n"
                + "\t\t<album id=\"" + this.album.entityID + "\">" + this.album.name + "</album> </song>";
    }

    public String toJSON() {
        return "{" +
                "\"id\": \"" + this.entityID + "\","+  "\"title\": \""  +   this.name + "\","+ "\"artist\": {"+
                "\"id\": \"" + this.artist.entityID + "\","+ "\"name\": \"" + this.artist.name+ "\""+ "},"+
                "\"album\": {"+ "\"id\": \""+  this.album.entityID + "\","+ "\"name\": \"" +this.album.name + "\""+ "}"+
                "}";
    }

}
