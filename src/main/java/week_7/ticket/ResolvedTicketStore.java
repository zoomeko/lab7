package week_7.ticket;

import java.util.LinkedList;

public class ResolvedTicketStore {
    
    private static LinkedList<Ticket> resolvedTickets;
    
    private static ResolvedTicketStore instance;
    
    private ResolvedTicketStore() {
        resolvedTickets = new LinkedList<Ticket>();
    }
    
    public static ResolvedTicketStore getInstance(){
        if (instance == null) {
            instance = new ResolvedTicketStore();
        }
        return instance;
    }
    
    public void addTicket(Ticket t) {
        resolvedTickets.add(t);
    }
    
    public LinkedList<Ticket> getAll() {
        return resolvedTickets;
    }
    
}
