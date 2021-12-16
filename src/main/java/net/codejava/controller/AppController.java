package net.codejava.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.codejava.services.IMCService;
import net.codejava.Usuario;
import net.codejava.entity.Formulario;
import net.codejava.entity.IMC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private IMCService service;

    @RequestMapping("/")
    public String viewHomePage(HttpSession session, Model model) {

        if (session.getAttribute("mySessionAttribute") != null) {
            List<IMC> listIMC = service.listAll();
            model.addAttribute("listIMC", listIMC);
            return "index";
        } else {
            model.addAttribute("formulario", new Formulario());
            return "login";
        }
    }

    @RequestMapping("/login")
    public String login(HttpSession session) {
        session.setAttribute("mySessionAttribute", "Bienvenido");

        return "redirect:/";
    }

    @RequestMapping("/new")
    public String showNewIMCPage(Model model) {
        IMC IMC = new IMC();
        model.addAttribute("IMC", IMC);

        return "new_IMC";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveIMC(@ModelAttribute("IMC") IMC IMC) {
        service.save(IMC);

        return "redirect:/";
    }



    @RequestMapping("/delete/{id}")
    public String deleteIMC (@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}