/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.maintainers;

import entities.Pages;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PagesModel;
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
public class PagesController {
    
    private PagesModel pages;

    public PagesController() {
        this.pages = new PagesModel();
    }
    
    @RequestMapping(value = {"mantenedores/paginas.htm"}, method = RequestMethod.GET)
    public ModelAndView listado(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        List<Object> list = this.pages.getAllPages();
        mav.addObject("list", list);
        mav.setViewName("maintainers/pages/all");
        return mav;
    }
    
    @RequestMapping(value = {"mantenedores/getPagina.htm"}, method = RequestMethod.POST)
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        BigDecimal id = BigDecimal.valueOf(Double.parseDouble(request.getParameter("id")));
        Pages page = this.pages.getPages(id);
        mav.addObject("json", page);
        mav.setViewName("include/json");
        return mav;
    }
    
    @RequestMapping(value = {"mantenedores/deletePagina.htm"}, method = RequestMethod.POST)
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        String json = "{\"response\":0}";
        BigDecimal id = BigDecimal.valueOf(Double.parseDouble(request.getParameter("id")));
        Pages page = this.pages.getPages(id);
        
        if (this.pages.removePages(page))
            json = "{\"response\":1}";
            
        mav.addObject("json", json);
        mav.setViewName("include/json");
        return mav;
    }
    
    @RequestMapping(value = {"mantenedores/updatePagina.htm"}, method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        String json = "{\"response\":0}";
        try {
            BigDecimal id = BigDecimal.valueOf(Double.parseDouble(request.getParameter("id")));
            String name = request.getParameter("name");
            String url = request.getParameter("url");
            String icon = request.getParameter("icon");
            BigDecimal parent;
            if (request.getParameter("parent").equals(""))
                parent = BigDecimal.valueOf(Double.parseDouble(request.getParameter("parent")));
            else parent = null;
            Pages page = new Pages(id, name, url, icon, parent);

            if (id.intValueExact() == 0){
                if (this.pages.createPages(page))
                    json = "{\"response\":1}";
            } else {
                page = this.pages.getPages(id);
                page.setName(name);
                page.setUrl(url);
                page.setIcon(icon);
                page.setParent(parent);
                if (this.pages.updatePages(page))
                    json = "{\"response\":1}";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("json", json);
        mav.setViewName("include/json");
        return mav;
    }
    
}
