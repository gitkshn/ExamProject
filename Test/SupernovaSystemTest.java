import Resources.Races;
import Units.Dreadnought;
import Units.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class SupernovaSystemTest {
    Dreadnought dreadnought = new Dreadnought(new Player("Danny", Races.BROTHERHOOD_OF_YIN.name(), "White"));

    SupernovaSystem supernovaSystem = new SupernovaSystem();

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