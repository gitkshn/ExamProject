package Resources;

import Units.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class PlayerPool {
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Player player5;
    private Player player6;

    private ArrayList<Player> playerArrayList;

    public PlayerPool() {
        player1 = new Player("Sansa", Races.MENTAK_COALITION.name(),"Red");
        player2 = new Player("Jon", Races.GHOSTS_OF_CREUSS.name(), "White");
        player3 = new Player("Peter", Races.XXCHA_KINGDOMS.name(),"Blue");
        player4 = new Player("Clegane", Races.BARONY_OF_LETNEV.name(), "Black");
        player5 = new Player("Tom", Races.BROTHERHOOD_OF_YIN.name(), "Cyan");
        player6 = new Player("Chap", Races.NALU_COLLECTIVE.name(),"Yellow");

        playerArrayList = new ArrayList<>();
        playerArrayList.add(player1);
        playerArrayList.add(player2);
        playerArrayList.add(player3);
        playerArrayList.add(player4);
        playerArrayList.add(player5);
        playerArrayList.add(player6);

    }
    //todo: delete?
    public ArrayList<Player> getPlayerArrayList() {
        return playerArrayList;
    }
    //todo: check iterations on the for loop.
    public ArrayList<Player> getRandomPlayers(int howMany) {
        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < howMany ; i++) {
            players.add(this.playerArrayList.get(i));
        }
        return players;
    }

}
