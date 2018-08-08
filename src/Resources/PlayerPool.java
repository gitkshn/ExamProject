package Resources;

import Units.Player;

import java.util.ArrayList;


/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class PlayerPool {
    //arrayList with all players made in the constructor.
    private ArrayList<Player> playerArrayList;

    public PlayerPool() {
        Player player1 = new Player("Sansa", Races.MENTAK_COALITION.name(), "Red");
        Player player2 = new Player("Jon", Races.GHOSTS_OF_CREUSS.name(), "White");
        Player player3 = new Player("Peter", Races.XXCHA_KINGDOMS.name(), "Blue");
        Player player4 = new Player("Clegane", Races.BARONY_OF_LETNEV.name(), "Black");
        Player player5 = new Player("Tom", Races.BROTHERHOOD_OF_YIN.name(), "Cyan");
        Player player6 = new Player("Chap", Races.NALU_COLLECTIVE.name(), "Yellow");

        playerArrayList = new ArrayList<>();

        playerArrayList.add(player1);
        playerArrayList.add(player2);
        playerArrayList.add(player3);
        playerArrayList.add(player4);
        playerArrayList.add(player5);
        playerArrayList.add(player6);

    }

    //makes an arrayList object with players according to the input parameter on how many is needed.
    public ArrayList<Player> getRandomPlayers(int howMany) {
        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {
            players.add(this.playerArrayList.get(i));
        }
        return players;
    }

}
