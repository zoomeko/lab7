package week_7.insects;

/**
 * Represents a Bee species.
 */

//public class Bee {
    
    // TODO make this a subclass of Insect
    
    // TODO add a boolean called makesHoney
    
    // TODO add a String called bodyColor
    
    // TODO add a constructor to set all necessary values
    
    // TODO override the speciesDataReport to return a String with Bee information


    public class Bee extends Insect {

        private boolean makesHoney;

        private String bodyColor;

        public Bee(String name,int wingCount,boolean makesHoney, String bodyColor) {

            super();

            this.name=name;

            this.wingCount=wingCount;

            this.makesHoney = makesHoney;

            this.bodyColor = bodyColor;

        }

        @Override

        public String speciesDataReport() {

            return "Bee [name="+getName()+"wingCount="+getWingCount()+" makesHoney=" + makesHoney + ", bodyColor=" + bodyColor + "]";

        }

    }



