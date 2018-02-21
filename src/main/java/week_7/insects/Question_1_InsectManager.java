package week_7.insects;

/** The instructions are in grades/Lab 7 Questions.md  */
import java.util.ArrayList;

import java.util.List;


public class Question_1_InsectManager {
    
    public static void main(String[] args) {
        Question_1_InsectManager insectManager = new Question_1_InsectManager();
        insectManager.testInsects();
                
    }
    
    public void testInsects() {
        
        // TODO Create an ArrayList of Insect objects
        
        // TODO Create two example Butterfly objects and add them to the ArrayList
    
        // TODO Create two example Bee objects and add them to the ArrayList
    
        // TODO loop over the ArrayList and call speciesDataReport() for each Insect (Butterfly, Bee) object in the ArrayList




                List<Insect> insectList = new ArrayList<Insect>();

                Butterfly butterfly1 = new Butterfly("Monarch butterfly", 4, "orange and black", "milkweed");

                Butterfly butterfly2 = new Butterfly("Swallowtail", 4, "yellow and black", "milk parsley");

                Bee bee1 = new Bee("Honey bee", 4, true, "yellow and black");

                Bee bee2 = new Bee("Bumble bee", 4, false, "black and white");

                insectList.add(butterfly1);

                insectList.add(butterfly2);

                insectList.add(bee1);

                insectList.add(bee2);

                for (Insect insect : insectList) {

                    System.out.println(insect.speciesDataReport());

                }

            }

        }



