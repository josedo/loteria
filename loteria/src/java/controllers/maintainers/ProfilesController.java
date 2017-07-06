/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.maintainers;

import entities.Profiles;
import entities.Users;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProfilesModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Joe
 */

@Controller
@SessionAttributes
public class ProfilesController {
    
    private ProfilesModel profiles;
    private Users userSession;

    public ProfilesController() {
        this.profiles = new ProfilesModel();
    }
    
    @RequestMapping(value = {"mantenedores/perfiles.htm"}, method = RequestMethod.GET)
    public ModelAndView listado(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if (this.validateSession(session)) {
            ModelAndView mav = new ModelAndView();
            List<Object> list = this.profiles.getAllProfiles();
            mav.addObject("list", list);
            mav.setViewName("maintainers/profiles/all");
            return mav;
        } else {
            response.sendRedirect("/loteria/login.htm");
            return null;
        }
    }
    
    @RequestMapping(value = {"mantenedores/getPerfil.htm"}, method = RequestMethod.POST)
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();
        
        if (this.validateSession(session)) {
            BigDecimal id = BigDecimal.valueOf(Double.parseDouble(request.getParameter("id")));
            Profiles profile = this.profiles.getProfiles(id);
            mav.addObject("json", profile);
        } else {
            String json = "{\"response\":0, \"msg\":\"Sesión caducada, favor de reiniciar la página actual.\"}";
            mav.addObject("json", json);
        }
        
        mav.setViewName("include/json");
        return mav;
    }
    
    @RequestMapping(value = {"mantenedores/deletePerfil.htm"}, method = RequestMethod.POST)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        String json = "{\"response\":0, \"msg\":\"Sesión caducada, favor de reiniciar la página actual.\"}";
        ModelAndView mav = new ModelAndView();
        
        if (this.validateSession(session)) {
            json = "{\"response\":0}";
            BigDecimal id = BigDecimal.valueOf(Double.parseDouble(request.getParameter("id")));
            Profiles profile = this.profiles.getProfiles(id);

            if (this.profiles.removeProfiles(profile))
                json = "{\"response\":1}";

        }
        
        mav.addObject("json", json);
        mav.setViewName("include/json");
        return mav;
    }
    
    @RequestMapping(value = {"mantenedores/updatePerfil.htm"}, method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        String json = "{\"response\":0, \"msg\":\"Sesión caducada, favor de reiniciar la página actual.\"}";
        ModelAndView mav = new ModelAndView();
        
        if (this.validateSession(session)) {
            json = "{\"response\":0}";
            try {
                BigDecimal id = BigDecimal.valueOf(Double.parseDouble(request.getParameter("id")));
                String name = request.getParameter("name");
                Profiles profile = new Profiles(id, name);

                if (id.intValueExact() == 0){
                    if (this.profiles.createProfiles(profile))
                        json = "{\"response\":1}";
                } else {
                    profile = this.profiles.getProfiles(id);
                    profile.setName(name);
                    if (this.profiles.updateProfiles(profile))
                        json = "{\"response\":1}";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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
