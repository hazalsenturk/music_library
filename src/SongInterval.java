public class SongInterval {
    private int length;

    public SongInterval(int l){
        this.length = l;
    }

    public  String toString(){
        int min = length / 60;
        int sec = length % 60;

        String time = (min + ":" + sec);

        return time;

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

