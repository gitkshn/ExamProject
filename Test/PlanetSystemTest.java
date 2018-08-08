import Exceptions.ContainsMoreThan3PlanetsException;
import Exceptions.InvalidSpaceBattleException;
import Resources.PlanetNames;
import Resources.Races;
import Units.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class PlanetSystemTest {
    private LightCruiser lightCruiser = new LightCruiser(new Player("Ragnar", Races.ARBOREC.name(), "Red"));
    private Destroyer destroyer = new Destroyer(new Player("Magnus", Races.CLAN_OF_SAAR.name(), "Orange"));


    @Test
    void flySpaceshipToSystem() {
        try {
            ArrayList<Planet> planetArrayList = new ArrayList<>();
            planetArrayList.add(new Planet(PlanetNames.ARNOR.name(), 5));
            PlanetSystem planetSystem = new PlanetSystem("North", planetArrayList);

            //should contain a light cruiser.
            planetSystem.flySpaceshipToSystem(lightCruiser);
            assertTrue(planetSystem.getSpaceshipsInsideSystem().contains(lightCruiser));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            assert false;
        }
    }

    @Test
    void flySpaceshipAwayFromSystem() {
        try {
            ArrayList<Planet> planetArrayList = new ArrayList<>();
            planetArrayList.add(new Planet(PlanetNames.CENTAURI.name(), 5));
            PlanetSystem planetSystem = new PlanetSystem("Center", planetArrayList);
            planetSystem.flySpaceshipToSystem(lightCruiser);
            assertTrue(planetSystem.getSpaceshipsInsideSystem().contains(lightCruiser));

            //removes the recently added light cruiser and the planet system should now be empty of spaceships.
            planetSystem.flySpaceshipAwayFromSystem(lightCruiser);
            assertTrue(planetSystem.getSpaceshipsInsideSystem().isEmpty());
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    void retrieveAllSpaceships() {
        try {
            ArrayList<Planet> planetArrayList = new ArrayList<>();
            planetArrayList.add(new Planet(PlanetNames.ARCTURUS.name(), 6));
            PlanetSystem planetSystem = new PlanetSystem("East", planetArrayList);
            planetSystem.flySpaceshipToSystem(lightCruiser);
            planetSystem.flySpaceshipToSystem(destroyer);

            //should print the 2 ships that resides in the planet system.
            planetSystem.retrieveAllSpaceships();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
        //should throw a InvalidSpaceBattleException.
    void InvalidSpaceBattle() {
        PredefinedGalaxy predefinedGalaxy = new PredefinedGalaxy();
        Galaxy testGalaxy = predefinedGalaxy.getGalaxy();
        Player playerRed = testGalaxy.SystemsList.get(0).getSpaceshipsInsideSystem().get(0).getOwner();
        Player playerBlue = testGalaxy.SystemsList.get(1).getSpaceshipsInsideSystem().get(0).getOwner();

        try {
            testGalaxy.SystemsList.get(0).spaceBattle(playerRed, playerBlue);
        } catch (InvalidSpaceBattleException e) {
            assert true;
        }
    }

    @Test
        //resolves a space battle between two brothers.
    void spaceBattle() {
        try {
            PlanetSystem planetSystem = new PlanetSystem("Center", new ArrayList<>());
            Player playerRed = new Player("Clegane", Races.XXCHA_KINGDOMS.name(), "Black");
            Player playerBlue = new Player("Sandor", Races.BROTHERHOOD_OF_YIN.name(), "Gray");

            Carrier carrier = new Carrier(playerRed);
            LightCruiser lightCruiser = new LightCruiser(playerRed);
            Destroyer destroyer = new Destroyer(playerRed);

            Dreadnought dreadnought = new Dreadnought(playerBlue);
            Cruiser cruiser = new Cruiser(playerBlue);
            Dreadnought dreadnought1 = new Dreadnought(playerBlue);

            planetSystem.flySpaceshipToSystem(carrier, lightCruiser, destroyer, dreadnought, cruiser, dreadnought1);

            Player winner = planetSystem.spaceBattle(playerRed, playerBlue);
            if (winner == null) {
                System.out.println("All ships were destroyed.");
            } else {
                System.out.println("The winner is: " + winner);
            }
            assert true;

        } catch (ContainsMoreThan3PlanetsException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            assert false;
        } catch (InvalidSpaceBattleException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            assert false;
        }
    }
}