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

import entities.PrizePot;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import model.UsersModel;
import org.springframework.stereotype.Controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PrizePotModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class ProfileController {
    
    private UsersModel users;
    private PrizePotModel prizePot;

    public ProfileController() {
        this.users = new UsersModel();
        this.prizePot = new PrizePotModel();
    }
    
    @RequestMapping(value = {"perfil.htm"}, method = RequestMethod.GET)
    public ModelAndView profile(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        Locale locale = new Locale("cl", "CL");
        PrizePot pp = this.prizePot.getPrizePot(BigDecimal.ONE);
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        mav.addObject("pp", pp);
        mav.addObject("fmt", fmt);
        mav.setViewName("perfil");
        return mav;
    }
    
}
