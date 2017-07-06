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

import entities.Users;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import model.UsersModel;
import org.springframework.stereotype.Controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProfilesPagesModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class LoginController {
    
    private UsersModel users;
    private ProfilesPagesModel profilePages;

    public LoginController() {
        this.users = new UsersModel();
        this.profilePages = new ProfilesPagesModel();
    }
    
    @RequestMapping(value = {"login.htm"}, method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
    
    @RequestMapping(value = {"postLogin.htm"}, method = RequestMethod.POST)
    public ModelAndView postLogin(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();
        Users user = this.users.authenticate(request.getParameter("login"), request.getParameter("password"));
        List pageList = new LinkedList();
        if (user != null){
            pageList = this.profilePages.getAllProfilesPagesByProfile(user.getProfiles().getId());
            session.setAttribute("pageList", pageList);
            session.setAttribute("user", user);
        }else{
            mav.addObject("error", "Usuario o Contraseña no válidos.");
        }
        mav.setViewName("login");
        return mav;
    }
    
    @RequestMapping(value = {"salir.htm"}, method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("./login.htm");
    }
      
}
