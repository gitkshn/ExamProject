import Exceptions.ContainsMoreThan3PlanetsException;
import Resources.PlayerPool;
import Resources.SpaceShipArray;
import Units.Player;

import java.util.ArrayList;
import java.util.Random;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class RandomGalaxy {
    //the method which returns a random galaxy.
    Galaxy getGalaxy() {
        PlanetArray planetArray = new PlanetArray();
        ArrayList<Systems> systemsArrayList = get7Systems(planetArray);
        SpaceShipArray spaceShipArray = new SpaceShipArray();
        PlayerPool playerPool = new PlayerPool();

        //gets 3-6 players from the player pool. +3 insures that there is at least 3 players as stated in the rules.
        ArrayList<Player> players = playerPool.getRandomPlayers(getRandomInt(3) + 3);

        //flag for adding spaceships if there is not a spaceship present in at least 2 systems.
        int systemsWithSpaceships = 0;

        for (Systems systems : systemsArrayList) {
            for (Player player : players) {
                //assigns a random spaceship to a player in the current system and increments the systemWithSpaceship counter.
                for (int i = 0; i < getRandomInt(2); i++) {
                    systems.flySpaceshipToSystem(spaceShipArray.getRandomSpaceShip(player));
                    systemsWithSpaceships++;
                }
            }
            //assigns a random spaceship to 2 players in the current system.
            if (systemsWithSpaceships < 2) {
                systems.flySpaceshipToSystem(spaceShipArray.getRandomSpaceShip(players.get(0)));
                systems.flySpaceshipToSystem(spaceShipArray.getRandomSpaceShip(players.get(1)));
            }
        }

        return new Galaxy(systemsArrayList);
    }

    private ArrayList<Systems> get7Systems(PlanetArray planetArray) {
        try {
            //at index 0 there should always be a center system with Mecatol Rex.
            PlanetSystem centerSystem = new PlanetSystem("Center", new ArrayList<>(), planetArray.getMecatolRex());
            //gets a random system with the parameters system position and planetArray.
            Systems northSystem = getRandomSystem("North", planetArray);
            Systems northEastSystem = getRandomSystem("North-East", planetArray);
            Systems southEastSystem = getRandomSystem("South-East", planetArray);

            Systems southSystem = getRandomSystem("South", planetArray);
            Systems southWest = getRandomSystem("South-West", planetArray);
            Systems northWest = getRandomSystem("North-West", planetArray);

            ArrayList<Systems> systemsArrayList = new ArrayList<>();

            systemsArrayList.add(centerSystem);
            systemsArrayList.add(northSystem);
            systemsArrayList.add(northEastSystem);

            systemsArrayList.add(southEastSystem);
            systemsArrayList.add(southSystem);
            systemsArrayList.add(southWest);
            systemsArrayList.add(northWest);

            return systemsArrayList;

        } catch (ContainsMoreThan3PlanetsException e) {
            e.printStackTrace();
            return null;
        }

    }

    //get a pseudo random system. planet systems has a 50% chance while supernovas and asteroid field systems has 25% each.
    private Systems getRandomSystem(String systemName, PlanetArray planetArray) {
        try {
            //gets an arrayList with 0 to 3 planets.
            ArrayList<Planet> planetArrayList = get0To3Planets(planetArray);

            PlanetSystem planetSystem = new PlanetSystem(systemName, planetArrayList);
            AsteroidFieldSystem asteroidFieldSystem = new AsteroidFieldSystem(systemName);
            SupernovaSystem supernovaSystem = new SupernovaSystem(systemName);

            ArrayList<Systems> arrayList = new ArrayList<>();
            arrayList.add(planetSystem);
            arrayList.add(planetSystem);
            arrayList.add(asteroidFieldSystem);
            arrayList.add(supernovaSystem);

            //returns 1 of the 4 systems in the arrayList.
            return arrayList.get(getRandomInt(4));

        } catch (ContainsMoreThan3PlanetsException e) {
            e.printStackTrace();
            return null;
        }
    }

    //returns an arrayList with 0 to 3 planets.
    private ArrayList<Planet> get0To3Planets(PlanetArray planetArray) {
        ArrayList<Planet> planetArrayList = new ArrayList<>();

        int seed = getRandomInt(4);
        for (int i = 0; i < seed; i++) {
            planetArrayList.add(planetArray.getRandomPlanet());
        }
        return planetArrayList;
    }

    //method which returns an random int according to the seed.
    private int getRandomInt(int seedNumber) {
        Random rand = new Random();
        return rand.nextInt(seedNumber);
    }

}
