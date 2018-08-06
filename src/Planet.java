import Exceptions.InvalidResourceProductionException;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class Planet {
    private String name;
    private int resourceProduction;

    //constructor.
    public Planet(String name, int resourceProduction) throws InvalidResourceProductionException {
        this.name = name;
        //resource production should be between [0-6] otherwise an exception is thrown.
        if (0 <= resourceProduction && resourceProduction <= 6) {
            this.resourceProduction = resourceProduction;
        }
        else {
            throw new InvalidResourceProductionException();
        }
    }
    //returns the name of the planet.
    public String getName() {
        return name;
    }
    //TODO: Usable?
    public int getResourceProduction() {
        return resourceProduction;
    }
}
