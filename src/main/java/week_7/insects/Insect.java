package week_7.insects;

/**
 * Represents a general insect species
 */

public abstract class Insect {
    
    
    // TODO add a String called name
    
    // TODO add an int called wingCount
    
    // TODO add a static constant int called LEG_COUNT, set it to 6
    
    // TODO add an abstract method called speciesDataReport that subclasses will be forced to override
    // speciesDataReport should take no arguments, and return a String.
    // You don't need to write the method body. Insect's subclasses will do that.



    protected String name;

    protected int wingCount;

    public static int LEG_COUNT = 6;

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public int getWingCount() {

        return wingCount;

    }

    public void setWingCount(int wingCount) {

        this.wingCount = wingCount;

    }

    public abstract String speciesDataReport();



}
