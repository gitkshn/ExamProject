package Resources;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class RacesTest {
    //TODO: SLET?
    @Test
    void getRandomRace() {
        try {
            assertNotNull(Races.EMIRATES_OF_HACAN.getRandomRace());

        } catch (Exception e) {
            System.out.println(e.toString() + " caught in getRandomRace test");
            assert false;
        }
    }
    //TODO: SLET?
    @Test
    void getRacesArrayList() {
        try {
            ArrayList<Races> arrayList = Races.EMIRATES_OF_HACAN.getRacesArrayList();
            assertNotNull(arrayList);

        } catch (Exception e) {
            System.out.println(e.toString() + " caught in getRacesArrayList test");
            assert false;
        }
    }
}