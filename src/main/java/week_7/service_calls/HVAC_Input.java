package week_7.service_calls;

import java.util.TreeMap;

import static input.InputUtils.positiveIntInput;

/** Methods for validating input in this program. The InputUtils methods are not specific enough
 */


public class HVAC_Input {
    
    private static TreeMap<Integer, Furnace.FurnaceType> furnaceTypes;
    private static int totalTypes;
    
    // Static initialization blocks. Runs one time, the first time this class is used
    // Kinda like a constructor, but for static variables
    
    static {
        
        //Build a TreeMap - a HashMap with sorted keys - of the valid types
        furnaceTypes = new TreeMap<>();
    
        int code = 1;
        for (Furnace.FurnaceType type : Furnace.FurnaceType.values()) {
            furnaceTypes.put(code++, type);
        }
    
        totalTypes = code - 1;   //If there are 3 types, then code will be 4 at the end of the loop.
    
    }
    
    
    /* Request a valid type from the furnace types allowed, based on the FurnaceTypes enum */
    static Furnace.FurnaceType getFurnaceType() {
        
        
        // Display codes and types, ask user to enter code number corresponding to the desired type
        // Validate that the type code entered is a valid one.
        while (true) {
            
            System.out.println("Enter type of furnace");
            
            for (int typeCode : furnaceTypes.keySet()) {
                System.out.println(typeCode + " " + furnaceTypes.get(typeCode));
            }

            int typeCodeInt = positiveIntInput();
            
            if ( typeCodeInt > totalTypes || typeCodeInt < 1 ) {
                System.out.println("Please enter a valid type code number");
            }
            
            else {
                return furnaceTypes.get(typeCodeInt);
            }
        }
    }
    
}
