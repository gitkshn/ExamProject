import Exceptions.InvalidSpaceBattleException;
import Units.*;
import Units.Units;

import java.util.ArrayList;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class SupernovaSystem implements Systems {
    private String position;
    private ArrayList<Units> spaceshipsInsideSupernova = new ArrayList<Units>();

    SupernovaSystem(String position) {
        this.position = position;
    }

    @Override
    //adds the spaceship to the arrayList and immediately removes it via the clear method.
    public void flySpaceshipToSystem(Units spaceship) {
        spaceshipsInsideSupernova.add(spaceship);
        System.out.println(spaceship.getClass().getSimpleName() + " has been destroyed by the supernovas.");
        spaceshipsInsideSupernova.clear();
    }

    @Override
    public ArrayList<Units> getSpaceshipsInsideSystem() {
        return spaceshipsInsideSupernova;
    }

    @Override
    public ArrayList<Planet> getPlanetList() {
        System.out.println("All the stars have collapsed and turned into supernovas in the " + getPosition() + " system.");
        return new ArrayList<>();
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    //throws an exception with supernova string parameter.
    public Player spaceBattle(Player redPlayer, Player bluePlayer) throws InvalidSpaceBattleException {
        throw new InvalidSpaceBattleException("supernova");
    }


}
