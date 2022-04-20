package com.example.laboratorio3.Controllers;


import com.example.laboratorio3.Entity.Cuenta;
import com.example.laboratorio3.Entity.Mascota;
import com.example.laboratorio3.Repository.CuentaRepository;
import com.example.laboratorio3.Repository.MascotaRepository;
import com.example.laboratorio3.Repository.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    ResponsableRepository responsableRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    @GetMapping(value = {"","/"})
    public String listaContacto(Model model){
        model.addAttribute("listacontacto", cuentaRepository.obtenerContactoMascota());
        return "Contacto/listaContacto";
    }

    @GetMapping(value = "/new")
    public String nuevoContacto(Model model){
        List<Cuenta> contactos = cuentaRepository.findAll();
        model.addAttribute("contactos",contactos);
        return "Contacto/newContacto";
    }

    @PostMapping("/save")
    public String saveContacto(Cuenta cuenta){
        cuentaRepository.save(cuenta);
        return "redirect:/contacto";
    }

    @GetMapping("/editar")
    public String editarContacto(@RequestParam("id") int id, Model model) {
        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(id);
        if (optionalCuenta.isPresent()) {
            Cuenta cuenta = optionalCuenta.get();
            model.addAttribute("cuenta", cuenta);
            return "Contacto/editContacto";
        } else {
            return "redirect:/contacto";
        }

    }



}
