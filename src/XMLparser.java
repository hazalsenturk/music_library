import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLparser {

    public static void main(String[] args) {
        parseXML("src/music-library.xml");
    }

    public static String getContent(Node n) {
        StringBuilder sb = new StringBuilder();
        Node child = n.getFirstChild();
        sb.append(child.getNodeValue());
        return sb.toString();
    }

    public static void parseXML(String fName) {
        String fileName = fName;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(fileName));

            Element root = doc.getDocumentElement();
            System.out.println("theRoot is: " + root);
            NodeList songs = root.getElementsByTagName("song");
            Node currentNode, subNode;

            Song currentSong;
            Artist currentArtist;
            Album currentAlbum;
            Library lib = new Library();

            for (int i = 0; i < songs.getLength(); i++) {
                currentNode = songs.item(i);
                Element num = (Element) currentNode;
                String id = num.getAttribute("id");

                NodeList children = currentNode.getChildNodes();
                currentSong = new Song();
                currentSong.entityID = Integer.parseInt(id);
                for (int j = 0; j < children.getLength(); j++) {
                    subNode = children.item(j);
                    if (subNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element name = (Element) subNode;
                        if (name.getNodeName().equals("title")) {
                            currentSong.setName(getContent(name).trim());
                        } else if (name.getNodeName().equals("artist")) {
                            id = name.getAttribute("id");
                            currentArtist = new Artist(getContent(subNode).trim());
                            currentArtist.entityID = Integer.parseInt(id);
                            currentSong.setArtist(currentArtist);
                        } else if (name.getNodeName().equals("album")) {
                            id = name.getAttribute("id");
                            currentAlbum = new Album(getContent(subNode).trim());
                            currentAlbum.entityID = Integer.parseInt(id);
                            currentSong.setAlbum(currentAlbum);
                        }
                    }
                }
                lib.addSongsXML(currentSong);

            }
            System.out.println(lib.getSongs());
           // lib.duplicates();

        } catch (Exception e) {
            System.out.println("Parsing error:" + e);
        }
    }

}

