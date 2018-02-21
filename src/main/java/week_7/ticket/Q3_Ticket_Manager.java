package week_7.ticket;

import java.util.TreeMap;


/** The instruction are in grades/Lab 7 Questions.md  */


public class Q3_Ticket_Manager {
    
    public static void main(String[] args) {
        new Q3_Ticket_Manager().manage();
    }
    
    // Constants used to display menu options, and figure out what user entered.
    static final int ADD_TICKET = 1;
    static final int SEARCH_BY_ID = 2;
    static final int DELETE_BY_TICKET_ID = 3;
    static final int SHOW_NEXT_TICKET = 4;
    static final int SHOW_ALL_TICKETS = 5;
    static final int QUIT = 9;
    
    // Global objects - the data stores, and the user interface
    TicketStore ticketStore = TicketStore.getInstance();
    TicketUI ticketUI = new TicketUI();
    
    // TODO Q5 create a ResolvedTicketStore object
    
    // Write and read to files in this directory. The tests will use a different directory, but same filenames.
    static String ticketDataDirectory = "TicketData";
    
    void manage() {
        
        TreeMap<Integer, String> options = configureMenuOptions();
    
        loadTickets();
        
        boolean quit = false;
    
        while (!quit) {
        
            int userChoice = ticketUI.showMenuGetChoice(options);
        
            switch (userChoice) {
                case ADD_TICKET:
                    menuOptionAddTicket();
                    break;
                case SEARCH_BY_ID:
                    menuOptionSearchById();
                    break;
                case DELETE_BY_TICKET_ID:
                    menuOptionDeleteById();
                    break;
                case SHOW_NEXT_TICKET:
                    menuOptionShowNextTicket();
                    break;
                case SHOW_ALL_TICKETS:
                    menuOptionDisplayAllTickets();
                    break;
                case QUIT:
                    menuOptionQuitProgram();
                    quit = true;
            }
        }
    }
    
    
    
    protected void menuOptionAddTicket() {
        // Get ticket data from user interface
        Ticket newTicket = ticketUI.getNewTicketInfo();
        // Add to the ticket store
        ticketStore.add(newTicket);
        ticketUI.userMessage("Ticket added to the ticket queue");
    }
    
    protected void menuOptionSearchById() {
        
        int ticketID = ticketUI.getTicketID();
        Ticket ticket = ticketStore.getTicketById(ticketID);
        if (ticket == null) {
            ticketUI.userMessage("No ticket found with that ID");
        } else {
            ticketUI.displayTicket(ticket);
        }
    }
    
    protected void menuOptionDeleteById() {
        // Get a ticket ID
        int ticketID = ticketUI.getTicketID();
    
        Ticket toDelete = ticketStore.getTicketById(ticketID);
        ticketUI.displayTicket(toDelete);
        
        deleteTicketById(ticketID);
    
    }
    
    protected void menuOptionShowNextTicket() {
        Ticket next = ticketStore.peekNextTicket();
        ticketUI.displayTicket(next);
    }
    
    protected void menuOptionDisplayAllTickets() {
        ticketUI.displayTickets(ticketStore.getAllTickets());
    }
    
    protected void menuOptionSearchByDescription() {
        
        // TODO problem 3 implement this method.
        
        // Use TicketUI getSearchTerm method to ask user for search term e.g. "server" or "powerpoint"
        // Create a method in TicketStore to get list of matching Tickets for a search term;
        //      this method should return a list of all tickets which contain the user's
        //      search term in their description
        // Use TicketUI displayTickets method to print the list of matching tickets
        
    }
    
    protected void menuOptionDeleteTicketByDescription() {
        
        // TODO problem 4 implement this method.
        // Ask user for search term e.g. "server"
        
        // If there are matching tickets, use TicketUI to ask user which ticket ID to delete;
        // call deleteTicketById(ticketID) to delete the ticket.
        
        // else, use TicketUI to show user 'not found' message
        
    }
    
    protected void menuOptionQuitProgram() {
        
        //TODO Problem 6 use the TicketFileIO methods to save all open tickets to a file
        //TODO Save all resolved tickets to a separate file containing today's filename
        //TODO save the ticket ID counter so when the program re-opens, it does not reset to 1
        // Make sure you save all of your files in the directory given by String ticketDataDirectory = "TicketData";
    }
    
    
    protected void loadTickets() {
        //TODO problem 7 load open tickets from a file, using your new TicketFileIO class
        //TODO Configure ticketIDCounter
        // Read your files from the directory given by ticketDataDirectory = "TicketData";
    }
    
    
    protected void deleteTicketById(int ticketID) {
    
        // TODO problem 5 use TicketUI to get the resolution for this Ticket
        // This method will be called by menuOptionDeleteTicketByDescription and menuOptionDeleteById
        // Save the resolution and the current date in this Ticket
        // add it to the ResolvedTicketStore object.

        if (ticketUI.areYouSure("Delete the above ticket, are you sure?")) {
            boolean deleted = ticketStore.deleteTicketById(ticketID);
            if (deleted) {
                ticketUI.userMessage("Ticket deleted");
            } else {
                ticketUI.userMessage("Ticket with this ID not found in the ticket queue");
            }
        } else {
            ticketUI.userMessage("No ticket deleted.");
        }
    }
    
    
    
    private TreeMap<Integer,String> configureMenuOptions() {
        
        TreeMap<Integer, String> options = new TreeMap<>();
        
        options.put(ADD_TICKET, "Add new ticket");
        options.put(SEARCH_BY_ID, "Search by ticket ID");
        options.put(DELETE_BY_TICKET_ID, "Delete by ticket ID");
        options.put(SHOW_NEXT_TICKET, "Show next ticket in ticket queue");
        options.put(SHOW_ALL_TICKETS, "Show all open tickets");
        
        options.put(QUIT, "Save and quit");
        
        return options;
    }
    
}

