package com.bolsadeideas.springboot.web.app.controllers;

import com.bolsadeideas.springboot.web.app.models.Usuario;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//RUTA DE PRIMER NIVEL DEL CONTROLADOR
@RequestMapping("/app")
public class IndexController {
    
    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;
    
    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;
    
    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    //RUTA DE SEGUNDO NIVEL DEL CONTROLADOR
    @RequestMapping(value = {"/index", "/", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Roberto");
        usuario.setApellido("Ledesma");
        usuario.setEmail("rob017led@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil + usuario.getNombre());
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", textoListar);
        return "listar";
    }

    //Anotacion para utilizar en varias paginas
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = Arrays.asList(new Usuario("Miguel", "Gonzalez", "mgonza@mail.com"),
                new Usuario("Omar", "Torres", "otorres@mail.com"),
                new Usuario("Raul", "Blanco", "rblanco@mail.com"),
                new Usuario("Paola", "Pliego", "ppliego@mail.com"));
        return usuarios;
    }

}
