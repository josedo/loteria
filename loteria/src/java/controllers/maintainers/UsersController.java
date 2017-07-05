/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.maintainers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsersModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jose.becerra
 */

@Controller
@SessionAttributes
public class UsersController {
    
    private UsersModel users;

    public UsersController() {
        this.users = new UsersModel();
    }
    
    @RequestMapping(value = {"mantenedores/usuarios.htm"}, method = RequestMethod.GET)
    public ModelAndView profile(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        List<Object> list = this.users.getAllUsers();
        mav.addObject("list", list);
        mav.setViewName("maintainers/users/all");
        return mav;
    }
    
    
}
