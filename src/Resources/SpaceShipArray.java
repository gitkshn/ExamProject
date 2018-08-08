package Resources;

import Units.*;

import java.util.ArrayList;
import java.util.Random;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class SpaceShipArray {
    //instantiates the 4 different types of ships with the player as owner and returns 1 random ship.
    public Units getRandomSpaceShip(Player player) {
        ArrayList<Units> allSpaceShipsList = new ArrayList<>();
        //instantiate and add all the 4 spaceship types into the Array list.
        Carrier carrier = new Carrier(player);
        Cruiser cruiser = new Cruiser(player);
        Destroyer destroyer = new Destroyer(player);
        Dreadnought dreadnought = new Dreadnought(player);
        LightCruiser lightCruiser = new LightCruiser(player);

        allSpaceShipsList.add(carrier);
        allSpaceShipsList.add(cruiser);
        allSpaceShipsList.add(destroyer);
        allSpaceShipsList.add(dreadnought);
        allSpaceShipsList.add(lightCruiser);

        //random value between 0-4.
        Random rand = new Random();
        int randomValue = rand.nextInt(5);
        //returns the spaceship at the index randomValue.
        return allSpaceShipsList.get(randomValue);
    }
}
