package Units;

import Resources.Races;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class PlayerTest {
    private Player tim = new Player("Tim", Races.BARONY_OF_LETNEV.name(), "Red");
    private Player jim = new Player("Jim", Races.BARONY_OF_LETNEV.name(), "Red");

    @Test
    void EqualsTest() {
        assertEquals(tim, tim);
        assertNotEquals(jim, tim);
    }
    @Test
    void GettersTest() {
        assertEquals(jim.getColor(), "Red");
        assertEquals(jim.getName(), "Jim");
        assertEquals(jim.getRace(), Races.BARONY_OF_LETNEV.name());
    }
}