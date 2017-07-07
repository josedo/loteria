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
            Tickets ticket = this.tickets.getByUser(this.userSession);
            if (ticket != null) {
                Drafts lastDraft = ticket.getDrafts();
                mav.addObject("lastDraft", lastDraft);
            }
            Drafts actualDrafts = this.drafts.getActualDrafts();
            float succesRate = DraftManager.successRate(ticket);
            mav.addObject("succesRate", succesRate);
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
            Tickets ticket = new Tickets(BigDecimal.ZERO, draft, userSession, number1, number2, number3, number4, number5, number6);
            try {
                if (TransactionManager.buyTicket(userSession, ticket)) {
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
    
    private boolean validateSession(HttpSession session) throws IOException {
        this.userSession = (Users) session.getAttribute("user");
        return null != this.userSession;
    }
    
}
