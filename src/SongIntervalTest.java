import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SongIntervalTest {

    SongInterval si1;
    @BeforeEach
    void setUp(){
        si1 = new SongInterval(40);

    }

    @Test
    void intervalTest(){
        System.out.println(si1.toString());
    }

}