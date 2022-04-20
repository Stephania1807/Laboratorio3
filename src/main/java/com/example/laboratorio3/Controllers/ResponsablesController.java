package com.example.laboratorio3.Controllers;

import com.example.laboratorio3.Entity.Responsable;
import com.example.laboratorio3.Repository.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nuevo")
public class ResponsablesController {
    @Autowired
    ResponsableRepository responsableRepository;

    @GetMapping(value = {"/",""})
    public String listaResponsables(Model model) {
        model.addAttribute("listaResponsables", responsableRepository.findAll());
        return "Responsable/lista";
    }

    @GetMapping("/new")
    public String nuevoResponsable(Model model, @ModelAttribute("responsable")Responsable responsable){
        return "Responsable/new";
        }
    @PostMapping("/save")
    public String saveResponsable(Responsable responsable){
        responsableRepository.save(responsable);
        return "redirect:/nuevo";
    }
}
