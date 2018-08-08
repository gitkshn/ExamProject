import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class RandomGalaxyTest {

    @Test
    void getGalaxy() {
        RandomGalaxy randomGalaxy = new RandomGalaxy();
        Galaxy testGalaxy = randomGalaxy.getGalaxy();
        try {
            assertTrue(testGalaxy.isLegal());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}