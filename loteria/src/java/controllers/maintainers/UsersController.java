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
import model.ProfilesModel;
import model.UsersModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import utilities.Utilitaria;

/**
 *
 * @author jose.becerra
 */

@Controller
@SessionAttributes
public class UsersController {
    
    private UsersModel users;
    private ProfilesModel profiles;

    public UsersController() {
        this.users = new UsersModel();
        this.profiles = new ProfilesModel();
    }
    
    @RequestMapping(value = {"mantenedores/usuarios.htm"}, method = RequestMethod.GET)
    public ModelAndView listado(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        List<Object> list = this.users.getAllUsers();
        List<Object> profilesList = this.profiles.getAllProfiles();
        mav.addObject("list", list);
        mav.addObject("profiles", profilesList);
        mav.setViewName("maintainers/users/all");
        return mav;
    }
    
    @RequestMapping(value = {"mantenedores/getUsuario.htm"}, method = RequestMethod.POST)
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        BigDecimal id = BigDecimal.valueOf(Double.parseDouble(request.getParameter("id")));
        Users user = this.users.getUsers(id);
        mav.addObject("json", user);
        mav.setViewName("include/json");
        return mav;
    }
    
    @RequestMapping(value = {"mantenedores/deleteUsuario.htm"}, method = RequestMethod.POST)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        String json = "{\"response\":0}";
        BigDecimal id = BigDecimal.valueOf(Double.parseDouble(request.getParameter("id")));
        Users user = this.users.getUsers(id);
        user.setStatus(false);
        
        if (this.users.removeUsers(user))
            json = "{\"response\":1}";
            
        mav.addObject("json", json);
        mav.setViewName("include/json");
        return mav;
    }
    
    @RequestMapping(value = {"mantenedores/updateUsuario.htm"}, method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        String json = "{\"response\":0}";
        try {
            BigDecimal id = BigDecimal.valueOf(Double.parseDouble(request.getParameter("id")));
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String rut = request.getParameter("rut");
            String dv = request.getParameter("dv");
            BigDecimal wallet = BigDecimal.valueOf(Double.parseDouble(request.getParameter("wallet")));
            BigDecimal id_profile = BigDecimal.valueOf(Double.parseDouble(request.getParameter("profile")));
            boolean status = request.getParameter("status").equalsIgnoreCase("1");
            
            if (Utilitaria.validarRut(rut + dv)) {
                
                Profiles profile = this.profiles.getProfiles(id_profile);
                Users user = new Users(id, profile, username, password, firstName, lastName, wallet, Long.parseLong(rut), dv, email, status);
                
                if (id.intValueExact() == 0){
                    if (this.users.createUsers(user))
                        json = "{\"response\":1}";
                } else {
                    user = this.users.getUsers(id);
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setProfiles(profile);
                    user.setRut(Long.parseLong(rut));
                    user.setDv(dv);
                    user.setEmail(email);
                    user.setWallet(wallet);
                    user.setStatus(status);
                    if (this.users.updateUsers(user))
                        json = "{\"response\":1}";
                }

            } else 
                json = "{\"response\":0, \"msg\":\"Rut ingresado no es correcto.\"}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("json", json);
        mav.setViewName("include/json");
        return mav;
    }

}
