package week_7.ticket;

import java.util.Date;
import java.util.LinkedList;
import java.util.TreeMap;

import static input.InputUtils.intInput;
import static input.InputUtils.stringInput;
import static input.InputUtils.yesNoInput;

public class TicketUI {
    
    
    /** User interaction - user input and printing - for the ticket manager  */
    
    
    protected int showMenuGetChoice(TreeMap<Integer, String> allOptions) {
        
        while (true) {
            
            for (int option : allOptions.keySet()) {
                System.out.println(String.format("%d: %s", option, allOptions.get(option)));
            }
            
            int task = intInput("Enter your selection");
            
            // If the user's option is in the map's key set, it's a valid choice. Return it.
            if (allOptions.keySet().contains(task)) {
                return task;
            }
            
            // Else, loop until user enters valid choice from the menu
            
        }
    }
    
    
    protected Ticket getNewTicketInfo() {
        
        Date dateReported = new Date(); //Default constructor creates Date with current date/time
        
        String description = stringInput("Enter description of the problem: ");
        String reporter = stringInput("Who reported this problem? ");
        
        // TODO Problem 2 ensure the priority is between 1 and 5
        int priority = intInput("Enter priority of " + description);
        
        Ticket t = new Ticket(description, priority, reporter, dateReported);
        
        return t;
        
        
        
    }
    
    
    protected int getTicketID() {
        return intInput("Enter Ticket ID: ");
    }
    
    
    protected String getSearchTerm() {
        return stringInput("Enter text to search for: ");
    }
    
    
    protected boolean areYouSure(String question) {
        return yesNoInput(question);
    }
    
    
    protected void displayTickets(LinkedList<Ticket> tickets) {
        System.out.println(" ------- All tickets ----------");
        
        for ( Ticket t : tickets ) {
            System.out.println(t); // This calls the toString method for the Ticket object.
        }
        
        System.out.println(" ------- End of ticket list ----------");
        
    }
    
    
    public void userMessage(String s) {
        System.out.println(s);
    }
    
    public void displayTicket(Ticket next) {
        System.out.println(next);
    }
    
    
    
}
