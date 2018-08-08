import Exceptions.InvalidSpaceBattleException;
import Units.Player;
import Units.Units;

import java.util.ArrayList;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public interface Systems {
    void flySpaceshipToSystem(Units spaceship);
    ArrayList<Units> getSpaceshipsInsideSystem();
    ArrayList<Planet> getPlanetList();
    String getPosition();
    Player spaceBattle(Player redPlayer, Player bluePlayer) throws InvalidSpaceBattleException;

}
