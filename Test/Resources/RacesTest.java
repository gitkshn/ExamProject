package Resources;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class RacesTest {
    Races races;

    @Test
    void getRandomRace() {
        try {
            assertNotNull(races.EMIRATES_OF_HACAN.getRandomRace());
        } catch (Exception e) {
            System.out.println(e.toString() + " caught in getRandomRace test");
        }
    }
}