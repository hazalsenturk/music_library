import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;

public class JSONparser {

    public static void main(String[] args) {
        String s;
        try {
            Scanner sc = new Scanner(new File("src/music-library.json"));
            sc.useDelimiter("\\Z");
            s = sc.next();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(s);
            JSONObject jsonObject = (JSONObject)obj;

            JSONArray songArray = (JSONArray)jsonObject.get("songs");
            for (Object song : songArray) {
                JSONObject jSong = (JSONObject)song;
                JSONObject jArtist = (JSONObject) jSong.get("artist");
                JSONObject jAlbum = (JSONObject) jSong.get("album");
                System.out.println(jSong.get("id") + " " +  jSong.get("title") + ", "  + jArtist.get("name") +", " + jAlbum.get("name"));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        } catch (ParseException e1) {
            System.out.println("Parser error");
        }
    }
}
