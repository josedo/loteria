
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
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DraftsModel;
import model.PrizePotModel;
import model.TicketsModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class IndexController {
    
    private PrizePotModel prizePot;
    private TicketsModel tickets;
    private DraftsModel drafts;

    public IndexController() {
        this.prizePot = new PrizePotModel();
        this.tickets = new TicketsModel();
        this.drafts = new DraftsModel();
    }
    
    @RequestMapping(value = {"index.htm"}, method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        ModelAndView mav = new ModelAndView();
        Locale locale = new Locale("cl", "CL");
        PrizePot pp = this.prizePot.getPrizePot(BigDecimal.ONE);
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        Drafts actualDrafts = this.drafts.getActualDrafts();
        mav.addObject("actualDrafts", actualDrafts);
        mav.addObject("pp", pp);
        mav.addObject("fmt", fmt);
        mav.setViewName("index");
        return mav;
        
    }
    
}

