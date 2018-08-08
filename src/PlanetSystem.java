import Exceptions.ContainsMoreThan3PlanetsException;
import Exceptions.ContainsNoSpaceshipsException;
import Exceptions.InvalidSpaceBattleException;
import Units.*;
import Units.Units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class PlanetSystem implements Systems{
    private String position;
    private ArrayList<Planet> planetList;
    private ArrayList<Units> spaceshipsInsidePlanetSystem = new ArrayList<>();

    //constructor with position and arrayList for initializing without planets.
    PlanetSystem(String position, ArrayList<Planet> planetList) throws ContainsMoreThan3PlanetsException {
        this.position = position;
        if (planetList.size() <= 3) {
            this.planetList = planetList;
        }
        else {
            throw new ContainsMoreThan3PlanetsException();
        }
    }
    //constructor with position and arrayList for initializing with planets via varargs.
    PlanetSystem(String position, ArrayList<Planet> planetList, Planet ... planets) throws ContainsMoreThan3PlanetsException {
        this.position = position;
        if (planetList.size() <= 3 && planets.length <= 3) {
            //var args parses an array and Array.asList converts it to a list.
            planetList.addAll(Arrays.asList(planets));
            this.planetList = planetList;
        }
        else {
            throw new ContainsMoreThan3PlanetsException();
        }
    }

    @Override
    //adds a spaceship to the spaceships arrayList.
    public void flySpaceshipToSystem(Units spaceship) {
        spaceshipsInsidePlanetSystem.add(spaceship);
    }

    //adds multiple ships via varargs. the method is overloaded.
    void flySpaceshipToSystem(Units ... spaceship) {
        spaceshipsInsidePlanetSystem.addAll(Arrays.asList(spaceship));
    }

    @Override
    //returns an arrayList of the spaceships ín the system.
    public ArrayList<Units> getSpaceshipsInsideSystem() {
        return spaceshipsInsidePlanetSystem;
    }

    @Override
    //returns an arrayList of the planets present in the system.
    public ArrayList<Planet> getPlanetList() {
        return planetList;
    }

    @Override
    public String getPosition() {
        return position;
    }

    //remove a spaceship in the spaceships arrayList if it is present.
    void flySpaceshipAwayFromSystem(Units spaceship) {
        spaceshipsInsidePlanetSystem.remove(spaceship);
    }

    //prints all the ships that resides in the current planet system.
    void retrieveAllSpaceships() throws ContainsNoSpaceshipsException {
        if (spaceshipsInsidePlanetSystem.isEmpty()) {
            throw new ContainsNoSpaceshipsException();
        }
        else {
            System.out.println("The " + position + " planet system contains the following ships:");
            for (Units spaceship : spaceshipsInsidePlanetSystem) {
                System.out.println(spaceship.getOwner().getName() + " has a " + spaceship.getClass().getSimpleName());
            }
        }
    }

    @Override
    //resolves a space battle between two players who has spaceships in this system.
    public Player spaceBattle(Player redPlayer, Player bluePlayer) throws InvalidSpaceBattleException {
        ArrayList<Units> spaceshipsRed = new ArrayList<Units>();
        ArrayList<Units> spaceshipsBlue = new ArrayList<Units>();
        //gathers the spaceship in the system into an arrayList according to their owner/player.
        for (Units spaceship : spaceshipsInsidePlanetSystem) {
            if (spaceship.getOwner().equals(redPlayer)) {
                spaceshipsRed.add(spaceship);
            }
            else if (spaceship.getOwner().equals(bluePlayer)) {
                spaceshipsBlue.add(spaceship);
            }
        }
        //throws an InvalidSpaceBattleException if either of the players has no ships.
        if (spaceshipsRed.isEmpty() || spaceshipsBlue.isEmpty()) {
            throw new InvalidSpaceBattleException("emptyList");
        }
        //sorts the lists according to the spaceships with the lowest resource cost.
        spaceshipsRed.sort(Comparator.comparingInt(Units::getResourceCost));
        spaceshipsBlue.sort(Comparator.comparingInt(Units::getResourceCost));

        boolean onGoingSpaceBattle = true;

        while (onGoingSpaceBattle) {
            //hits counter for each player.
            int redHits = 0, blueHits = 0;

            //each spaceship gets their combat value compared to a random number between 1-10 that determines a hit or not.
            for (Units spaceship : spaceshipsRed) {
                if (spaceship.getCombatValue() < getNumberFrom1to10()) {
                    redHits++;
                }
                else if (spaceship.getCombatValue() < getNumberFrom1to10()) {
                    blueHits++;
                }
            }
            //removes the weakest ships according to hits.
            for (int i = 0; i < redHits; i++) {
                if (!spaceshipsRed.isEmpty()) {
                    spaceshipsRed.remove(0);
                }
            }

            for (int i = 0; i < blueHits; i++) {
                if (!spaceshipsBlue.isEmpty()) {
                    spaceshipsBlue.remove(0);
                }
            }
            //checks whether the space is over or not.
            if (spaceshipsRed.isEmpty() || spaceshipsBlue.isEmpty()) {
                onGoingSpaceBattle = false;
            }

        }
        //if both players have their ships destroyed, the method returns null.
        if (spaceshipsRed.isEmpty() && spaceshipsBlue.isEmpty()) {
            System.out.println("War. War never changes. Both players has lost all their spaceships.");
            return null;
        }
        //returns who won via the conditional operator.
        return spaceshipsRed.isEmpty() ? bluePlayer : redPlayer;
    }
    //returns a number from 1 to 10.
    private int getNumberFrom1to10() {
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }

}
