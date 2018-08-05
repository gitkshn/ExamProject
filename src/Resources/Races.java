/* Kasper Suamchiang Hvitfeldt Nielsen
kshn16@student.aau.dk */
package Resources;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
//enum for all the races with a getRandomRace method to return a single race as a string.
public enum Races {
    EMIRATES_OF_HACAN,
    UNIVERSITIES_OF_JOLNAR,
    NEKRO_VIRUS,
    FEDERATION_OF_SOL,
    BROTHERHOOD_OF_YIN,
    SARDAK_NORR,
    L1Z1X_MINDNET,
    CLAN_OF_SAAR,
    GHOSTS_OF_CREUSS,
    BARONY_OF_LETNEV,
    YSSRAIL_TRIBES,
    NALU_COLLECTIVE,
    MENTAK_COALITION,
    XXCHA_KINGDOMS,
    ARBOREC,
    WINNU;

    ArrayList<Races> racesArrayList;
    //makes an arrayList of the enum constants and returns a random race as a string.
    public String getRandomRace() {
        racesArrayList = new ArrayList<>(Arrays.asList(Races.values()));
        Random rand = new Random();
        int racesCount = racesArrayList.size();
        int seed = rand.nextInt(racesCount);
        String randomRace = racesArrayList.get(seed).name();
        racesArrayList.remove(seed);

        return randomRace;
    }
    //TODO: useable?
    //returns an arrayList of all the enum constants.
    public ArrayList<Races> getRacesArrayList() {
        ArrayList arrayList = new ArrayList<>(Arrays.asList(Races.values()));
        return arrayList;
    }
}
