package com.example.laboratorio3.Controllers;

import com.example.laboratorio3.Repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mascota")
public class MascotaController {




    public String nuevaMascota(Model model){
        return "Mascota/new";
    }

}
