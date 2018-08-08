package Exceptions;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class InvalidSpaceBattleException extends Exception {
    //local getmessage string.
    String getMessage;

    //constructor with different if-statements depending on the input parameter.
    public InvalidSpaceBattleException(String message) {
        if (message.contains("supernova")) {
            getMessage = "All ships was destroyed in the supernova. No space battle shall commence.";
        }
        if (message.contains("asteroidField")) {
            getMessage = "There seems to be no visibility here. A space battle would be impossible.";
        }
        if (message.contains("emptyList")) {
            getMessage = "One of the players has no spaceships in this planet system";
        }
    }

    @Override
    public String getMessage() {
        return this.getMessage;
    }
}
