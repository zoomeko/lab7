package week_7.insects;

/**
 * Represents a butterfly species
 */

//public class Butterfly {
    
    // TODO make this a subclass of Insect
    
    // TODO add a String called wingColor. Add get and set methods
    
    // TODO add a String called favoriteFlower. Add get and set methods
    
    // TODO add a constructor to set all necessary values
    
    // TODO override the speciesDataReport method to return a String with Butterfly information

    public class Butterfly extends Insect {

        private String wingColor;

        private String favoriteFlower;

        public Butterfly(String name, int wingCount, String wingColor, String favoriteFlower) {

            this.name = name;

            this.wingCount = wingCount;

            this.wingColor = wingColor;

            this.favoriteFlower = favoriteFlower;

        }

        public String getWingColor() {

            return wingColor;

        }

        public void setWingColor(String wingColor) {

            this.wingColor = wingColor;

        }

        public void setFavoriteFlower(String favoriteFlower) {

            this.favoriteFlower = favoriteFlower;

        }

        @Override

        public String speciesDataReport() {

            return "Butterfly [name=" + getName() + "wingCount=" + getWingCount() + " wingColor=" + wingColor

                    + ", favoriteFlower=" + favoriteFlower + "]";

        }

    }



