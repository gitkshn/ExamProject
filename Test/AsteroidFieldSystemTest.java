import Resources.Races;
import Units.Carrier;
import Units.Dreadnought;
import Units.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class AsteroidFieldSystemTest {
    private AsteroidFieldSystem asteroidFieldSystem = new AsteroidFieldSystem("North");
    private Player cercei = new Player("Cersei", Races.FEDERATION_OF_SOL.name(), "Yellow");
    private Carrier carrier = new Carrier(cercei);
    private Dreadnought dreadnought = new Dreadnought(cercei);

    @Test
    void flySpaceshipToSystem() {
        //the carrier should be destroyed therefor the arrayList should be empty.
        asteroidFieldSystem.flySpaceshipToSystem(carrier);
        assertTrue(asteroidFieldSystem.getSpaceshipsInsideSystem().isEmpty());

        //The dreadnought should be alive in the system.
        asteroidFieldSystem.flySpaceshipToSystem(dreadnought);
        assertTrue(asteroidFieldSystem.getSpaceshipsInsideSystem().contains(dreadnought));
    }


    @Test
        //the planet list should return an empty list as specified in the method.
    void getPlanetList() {
        assertTrue(asteroidFieldSystem.getPlanetList().isEmpty());
    }

    @Test
    void flySpaceshipAwayFromSystem() {
        //the dreadnought enters the system.
        asteroidFieldSystem.flySpaceshipToSystem(dreadnought);
        assertTrue(asteroidFieldSystem.getSpaceshipsInsideSystem().contains(dreadnought));

        //the dreadnought leaves the system and the list should not contain the dreadnought anymore.
        asteroidFieldSystem.flySpaceshipAwayFromSystem(cercei);
        assertFalse(asteroidFieldSystem.getSpaceshipsInsideSystem().contains(dreadnought));

    }
}