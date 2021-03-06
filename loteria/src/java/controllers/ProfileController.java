/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author jose.becerra
 */

import entities.Drafts;
import entities.PrizePot;
import entities.Tickets;
import entities.Users;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DraftsModel;
import model.PrizePotModel;
import model.TicketsModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import utilities.DraftManager;
import utilities.TransactionManager;

@Controller
@SessionAttributes
public class ProfileController {
    
    private PrizePotModel prizePot;
    private TicketsModel tickets;
    private DraftsModel drafts;
    private Users userSession;

    public ProfileController() {
        this.prizePot = new PrizePotModel();
        this.tickets = new TicketsModel();
        this.drafts = new DraftsModel();
    }
    
    @RequestMapping(value = {"perfil.htm"}, method = RequestMethod.GET)
    public ModelAndView profile(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if (this.validateSession(session)) {
            ModelAndView mav = new ModelAndView();
            Locale locale = new Locale("cl", "CL");
            PrizePot pp = this.prizePot.getPrizePot(BigDecimal.ONE);
            NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
            Drafts actualDrafts = this.drafts.getActualDrafts();
            List<Object> listTickets = this.tickets.getByUser(this.userSession, actualDrafts);
            Tickets ticket = null;
            
            if (listTickets.size() > 0) 
                ticket = (Tickets) listTickets.get(listTickets.size() - 1);
            if (ticket != null) {
                Drafts lastDraft = ticket.getDrafts();
                mav.addObject("lastDraft", lastDraft);
            }
            
            mav.addObject("listTickets", listTickets);
            mav.addObject("actualDrafts", actualDrafts);
            mav.addObject("ticket", ticket);
            mav.addObject("pp", pp);
            mav.addObject("fmt", fmt);
            mav.setViewName("perfil");
            return mav;
        } else {
            response.sendRedirect("/loteria/login.htm");
            return null;
        }
        
    }
    
    @RequestMapping(value = {"buyTicket.htm"}, method = RequestMethod.POST)
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();
        String json = "{\"response\":0}";
        if (this.validateSession(session)) {
            BigDecimal number1 = BigDecimal.valueOf(Double.parseDouble(request.getParameter("num1")));
            BigDecimal number2 = BigDecimal.valueOf(Double.parseDouble(request.getParameter("num2")));
            BigDecimal number3 = BigDecimal.valueOf(Double.parseDouble(request.getParameter("num3")));
            BigDecimal number4 = BigDecimal.valueOf(Double.parseDouble(request.getParameter("num4")));
            BigDecimal number5 = BigDecimal.valueOf(Double.parseDouble(request.getParameter("num5")));
            BigDecimal number6 = BigDecimal.valueOf(Double.parseDouble(request.getParameter("num6")));
            Drafts draft = this.drafts.getActualDrafts();
            Tickets ticket = new Tickets(BigDecimal.ZERO, draft, this.userSession, number1, number2, number3, number4, number5, number6);
            try {
                if (TransactionManager.buyTicket(this.userSession, ticket)) {
                    json = "{\"response\":1}";
                }
            } catch (Exception ex) {
                json = "{\"response\":0, \"msg\":\"" + ex.getMessage() + ".\"}";
            }
        } else {
            json = "{\"response\":0, \"msg\":\"Debe logearse para realizar compra de ticket.\"}";
        }
            mav.addObject("json", json);
        
        mav.setViewName("include/json");
        return mav;
    }
    
    @RequestMapping(value = {"randomTicket.htm"}, method = RequestMethod.POST)
    public ModelAndView randomTicket(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();
        String json = "{\"response\":0}";
        if (this.validateSession(session)) {
            
            try {
                if (DraftManager.buyRandomTicket(this.userSession)) {
                    json = "{\"response\":1}";
                }
            } catch (Exception ex) {
                json = "{\"response\":0, \"msg\":\"" + ex.getMessage() + ".\"}";
            }
            
        } else {
            json = "{\"response\":0, \"msg\":\"Debe logearse para realizar compra de ticket.\"}";
        }
        
        mav.addObject("json", json);
        mav.setViewName("include/json");
        return mav;
    }
    
    @RequestMapping(value = {"recharge.htm"}, method = RequestMethod.POST)
    public ModelAndView recharge(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();
        String json = "{\"response\":0}";
        if (this.validateSession(session)) {
            String account = request.getParameter("account");
            String amount = request.getParameter("amount");
            String payMethod = request.getParameter("amount");
            try {
                BigDecimal transaction = BigDecimal.valueOf(Double.parseDouble(String.valueOf(TransactionManager.makeTransaction(account, amount))));
                if (TransactionManager.makeRecharge(userSession, BigDecimal.valueOf(Double.parseDouble(amount)), transaction, payMethod))
                    json = "{\"response\":1}";
            } catch (Exception e) {
            json = "{\"response\":0, \"msg\":\"" + e.getMessage() +"\"}";
            }
                
        } else {
            json = "{\"response\":0, \"msg\":\"Debe logearse para realizar recarga.\"}";
        }
        
        mav.addObject("json", json);
        mav.setViewName("include/json");
        return mav;
    }
    
    @RequestMapping(value = {"schedule.htm"}, method = RequestMethod.POST)
    public ModelAndView schedule(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();
        String json = "{\"response\":0}";
        
        if (this.validateSession(session)) {
            try {
                if (DraftManager.makeDraft())
                    json = "{\"response\":1}";
            } catch (Exception e) {
                json = "{\"response\":0, \"msg\":\"" + e.getMessage() +"\"}";
            }
                
        } else {
            json = "{\"response\":0, \"msg\":\"Debe logearse para realizar recarga.\"}";
        }
        
        mav.addObject("json", json);
        mav.setViewName("include/json");
        return mav;
    }
    
    private boolean validateSession(HttpSession session) throws IOException {
        this.userSession = (Users) session.getAttribute("user");
        return null != this.userSession;
    }
    
}
