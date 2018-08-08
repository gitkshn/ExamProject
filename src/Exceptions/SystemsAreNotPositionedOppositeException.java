package Exceptions;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class SystemsAreNotPositionedOppositeException extends Exception {
    @Override
    public String getMessage() {
        return "The systems are not aligned opposite of each other correctly.";
    }
}
