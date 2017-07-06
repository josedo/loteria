/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entities.Drafts;
import entities.Tickets;

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
    
    public static boolean isWinner(Tickets ticket) {
        return DraftManager.successRate(ticket) == 100;
    }
}
