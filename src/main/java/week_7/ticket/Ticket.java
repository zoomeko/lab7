package week_7.ticket;

import java.util.Date;

public class Ticket {

    private int priority;
    private String reporter; //Stores person or department who reported problem
    private String description;
    private Date dateReported;

    //TODO 1: Make sure you understand how ticketIdCounter and ticketID interact. Why is ticketIdCounter static and ticketID is not?

    //STATIC Counter - one variable, shared by all Ticket objects.
    //If any Ticket object modifies this counter, all Ticket objects will have the modified value
    //Make it private - only Ticket objects should have access
    private static int ticketIdCounter = 1;

    //The ID for each ticket - an instance variable. Each Ticket will have it's own ticketID variable
    private int ticketID;

    // TODO 6: tickets need to store the resolution Date and a String describing the resolution
    
     
    public Ticket(String desc, int p, String rep, Date date) {
  
        this.description = desc;
        this.priority = p;
        this.reporter = rep;
        this.dateReported = date;
        this.ticketID = ticketIdCounter;
    
        ticketIdCounter++;    // Increment ticketIDCounter so the next ticket's number is one higher
    
    }
    
    // TODO 7: add your constructor to create a Ticket from existing Ticket data read from a file
    
    // TODO 7: Ensure that every new Ticket created has a unique ID, even if the program is closed and restarted

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    public String getReporter() {
        return reporter;
    }
    
    public void setReporter(String reporter) {
        this.reporter = reporter;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Date getDateReported() {
        return dateReported;
    }
    
    public void setDateReported(Date dateReported) {
        this.dateReported = dateReported;
    }
    
    protected int getPriority() {
        return priority;
    }

    public int getTicketID() {
        return ticketID;
    }

    public String getDescription() { return description; }

    public String toString(){
        return("ID: " + this.ticketID + " Description: " + this.description + " Priority: " +
                this.priority + " Reported by: " + this.reporter + " Reported on: " + this.dateReported);
    }
    
    // TODO you may want to add a method to generate a String representing this Ticket, suitable
    //  for writing to a file. Whatever you write out, should be able to be read and turned back into a Ticket object.
    
    
}

