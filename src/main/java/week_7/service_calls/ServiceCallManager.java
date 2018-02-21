package week_7.service_calls;

import java.util.*;

import static input.InputUtils.*;

/**
 * Created by clara on 2/3/17.
 * Prototype of user interface for managing service calls.
 *
 */

public class ServiceCallManager {

    private LinkedList<ServiceCall> todayServiceCalls;
    private LinkedList<ServiceCall> resolvedServiceCalls;
    
    private final int ADD_CALL = 1;
    private final int RESOLVE_CALL = 2;
    private final int PRINT_NEXT_CALL = 3;
    private final int PRINT_ALL_CALLS = 4;
    private final int PRINT_ALL_RESOLVED = 5;
    private final int QUIT = 6;
    
    private final int ADD_FURNACE = 1;
    private final int ADD_AC = 2;
    private final int RETURN_TO_MAIN = 3;
    
    
    // Menu options, as an array
    private String[] mainMenuOptions = {
            ADD_CALL + ". Add service call to queue",
            RESOLVE_CALL + ". Resolve current call",
            PRINT_NEXT_CALL + ". Print current call",
            PRINT_ALL_CALLS + ". Print all outstanding calls",
            PRINT_ALL_RESOLVED + ". Print all resolved calls ",
            QUIT + ". Quit" };
    

    private String[] addCallOptions = {
            ADD_FURNACE + ". Add service call for furnace",
            ADD_AC + ". Add service call for AC unit",
            RETURN_TO_MAIN + ". Return to main menu" };

    

    /* Constructor sets up the two lists to store data in the program. */
    
    ServiceCallManager() {

        todayServiceCalls = new LinkedList<>();

        // This will be used to store a list of resolved service calls.
        resolvedServiceCalls = new LinkedList<>();

    }


    /* The main menu */
   public void manageCalls() {
        
        boolean quit = false;
        
        while (!quit) {
        
            displayMenu("Main Menu", mainMenuOptions);
        
            int choice = intInput("Enter selection: ");
        
            switch (choice) {
                case ADD_CALL:
                    addServiceCall();
                    break;
                case RESOLVE_CALL:
                    resolveServiceCall();
                    break;
                case PRINT_NEXT_CALL:
                    showNextCall();
                    break;
                case PRINT_ALL_CALLS:
                    showAllCalls("All open service calls", todayServiceCalls);
                    break;
                case PRINT_ALL_RESOLVED:
                    showAllCalls("All resolved service calls", resolvedServiceCalls);
                    break;
                case QUIT:
                    quit = true;  // Will stop the loop
                default:
                    System.out.println("Enter a number from the menu choices");
                    break;
            }
        }
        
        System.out.println("Thanks, bye!");
    }


    /* Displays the contents of an array; the array should hold each menu option. */
    private void displayMenu(String menuName, String[] options) {
    
        System.out.println("\n" + menuName + "\n");
        
        for (String option : options) {
            System.out.println(option);
        }
        
    }


    /* Display sub-menu to add a new service call. Ask user what type of item needs servicing, and
    call appropriate method to create a service call for that type of thing. */
    private void addServiceCall() {

        while (true) {
            displayMenu("Add Service Call Menu", addCallOptions);
    
            int choice = intInput("Enter selection: ");
    
            switch (choice) {
                case ADD_FURNACE:
                    addFurnaceServiceCall();
                    break;
                case ADD_AC:
                    addACServiceCall();
                    break;
                case RETURN_TO_MAIN:
                    return;
                default:
                    System.out.println("Please enter a number from the menu choices");
                    break;
            }
        }
    }


    /* Get data about furnace, create Furnace object, add to end of queue of ServiceCalls */
    private void addFurnaceServiceCall() {

        String address = stringInput("Enter address of furnace");
        String problem = stringInput("Enter description of problem");
        Furnace.FurnaceType type = HVAC_Input.getFurnaceType();
        Furnace f = new Furnace(address, problem, new Date(), type);
        todayServiceCalls.add(f);

        System.out.println("Added the following furnace to list of calls:\n" + f);
    }


    /* Get data about AC unit, create CentralAC object, add to end of queue of ServiceCalls */
    private void addACServiceCall() {

        String address = stringInput("Enter address of AC unit");
        String problem = stringInput("Enter description of problem");
        String model = stringInput("Enter model of AC unit");

        CentralAC ac = new CentralAC(address, problem, new Date(), model);
        todayServiceCalls.add(ac);
        System.out.println("Added the following AC unit to list of calls:\n" + ac);
    }


    /* Resolve the call at the top of the queue
     Call is resolved by removing it from the queue, asking user
     for resolution and fee, and adding the call to the resolved calls list */
    private void resolveServiceCall() {

        if (todayServiceCalls.isEmpty()) {
            System.out.println("No service calls today");
            return;
        }

        ServiceCall resolvedCall = todayServiceCalls.remove();    //Remove call from head of queue

        String resolution = stringInput("Enter resolution for " + resolvedCall);
        double fee = positiveDoubleInput("Enter fee charged to customer");

        resolvedCall.setResolution(resolution);
        resolvedCall.setFee(fee);
        resolvedCall.setResolvedDate(new Date());  //default resolved date is now

        resolvedServiceCalls.add(resolvedCall);  //Add this call to the list of resolved calls

    }


    /* Print details of the next call, the one at the head of the queue */
    private void showNextCall() {
        if (todayServiceCalls.isEmpty()) {
            System.out.println("No service calls today");
        } else {
            System.out.println(todayServiceCalls.peek());
        }
    }

    
    
    /* Display all open calls */
    private void showAllCalls(String headerMessage, LinkedList<ServiceCall> calls) {

        System.out.println(headerMessage);
        
        if (calls.isEmpty()) {
            System.out.println("No service calls today");
        }

        // Display a numbered list of all the serviceCalls
        int callCount = 1;
        
        for (ServiceCall call : calls) {
            System.out.println("Service Call " + callCount++ + ", " + call +  "\n");
        }

    }



}









