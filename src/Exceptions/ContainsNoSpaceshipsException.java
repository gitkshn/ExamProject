package Exceptions;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class ContainsNoSpaceshipsException extends Exception{
    @Override
    public String getMessage() {
        return "Planet system contains no space ships currently.";
    }
}
