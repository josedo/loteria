/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entities.Drafts;
import entities.Tickets;
import entities.Users;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
import model.DraftsModel;
import model.TicketsModel;
import services.Payment;

/**
 *
 * @author jose.becerra
 */
public class DraftManager {
    
    public static float successRate(Tickets ticket) {
        
        if (ticket == null || ticket.getDrafts() == null)
            return 0;
        
        int total = 6;
        int count = 0;
        Drafts draft = ticket.getDrafts();
        
        if (ticket.getNumber1().compareTo(draft.getNumber1()) == 0)
            ++count;
        if (ticket.getNumber2().compareTo(draft.getNumber2()) == 0)
            ++count;
        if (ticket.getNumber3().compareTo(draft.getNumber3()) == 0)
            ++count;
        if (ticket.getNumber4().compareTo(draft.getNumber4()) == 0)
            ++count;
        if (ticket.getNumber5().compareTo(draft.getNumber5()) == 0)
            ++count;
        if (ticket.getNumber6().compareTo(draft.getNumber6()) == 0)
            ++count;
        return (count/total) * 100;
    }
    
    public static void makeDraft() {
        DraftsModel draftsModel = new DraftsModel();
        int[] draftNumbers = new int[6];
        ArrayList numbers = new ArrayList();
        for (int i = 1; i < 100; i++) {
            numbers.add(i);
        }
        for (int i = 0; i < draftNumbers.length; i++) {
            int random = (int)(Math.random() * (numbers.size() - 1) + 1) + 1;
            draftNumbers[i] = (int)numbers.get(random);
            numbers.remove(random);
        }
        java.util.Date date = Calendar.getInstance().getTime();
        
        Drafts draft = draftsModel.getPendingDrafts();
        draft.setNumber1(BigDecimal.valueOf(draftNumbers[0]));
        draft.setNumber2(BigDecimal.valueOf(draftNumbers[1]));
        draft.setNumber3(BigDecimal.valueOf(draftNumbers[2]));
        draft.setNumber4(BigDecimal.valueOf(draftNumbers[3]));
        draft.setNumber5(BigDecimal.valueOf(draftNumbers[4]));
        draft.setNumber6(BigDecimal.valueOf(draftNumbers[5]));
        draft.setDate(date);
        draftsModel.updateDrafts(draft);
        
        Drafts newDraft = new Drafts(BigDecimal.ZERO, date, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        draftsModel.createDrafts(newDraft);
        checkWinners(draft);
    }
    
    public static void checkWinners(Drafts draft){
        Set<Tickets> tickets = draft.getTicketses();
        
        for (int i = 0; i < tickets.size(); i++) {
            
        }
    }
    
    public static void setPrize(){
        
    }
    
    public static void buyRandomTicket(Users user){
        DraftsModel draftsModel = new DraftsModel();
        TicketsModel ticketsModel = new TicketsModel();
        int[] draftNumbers = new int[6];
        ArrayList numbers = new ArrayList();
        for (int i = 1; i < 100; i++) {
            numbers.add(i);
        }
        for (int i = 0; i < draftNumbers.length; i++) {
            int random = (int)(Math.random() * (numbers.size() - 1) + 1) + 1;
            draftNumbers[i] = (int)numbers.get(random);
            numbers.remove(random);
        }
        Drafts draft = draftsModel.getPendingDrafts();
        Tickets ticket = new Tickets(BigDecimal.ZERO, draft, user, BigDecimal.valueOf(draftNumbers[0]), BigDecimal.valueOf(draftNumbers[1]), BigDecimal.valueOf(draftNumbers[2]), BigDecimal.valueOf(draftNumbers[3]), BigDecimal.valueOf(draftNumbers[4]), BigDecimal.valueOf(draftNumbers[5]));
        ticketsModel.createTickets(ticket);
    }
}
