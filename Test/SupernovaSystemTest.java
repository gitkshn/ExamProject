import Resources.Races;
import Units.Dreadnought;
import Units.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class SupernovaSystemTest {
    private Dreadnought dreadnought = new Dreadnought(new Player("Danny", Races.BROTHERHOOD_OF_YIN.name(), "White"));

    private SupernovaSystem supernovaSystem = new SupernovaSystem("North");

    @Test
    void flySpaceshipToSystem() {
        try {
            supernovaSystem.flySpaceshipToSystem(dreadnought);
            assertTrue(supernovaSystem.getSpaceshipsInsideSystem().isEmpty());

        } catch (Exception e) {
            e.printStackTrace();
            assert false;
        }

    }
}