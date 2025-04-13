package br.gov.sp.cps.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class mainController {
    public double peso=0;
    public double altura=0;
    public double imc=0;
    @GetMapping("/")
    public String index(){

        return "index";
    }
    @GetMapping("/abaixodopeso")
    public String abaixoDoPeso(ModelMap model){
        model.addAttribute("imc",imc);
        model.addAttribute("altura",altura);
        model.addAttribute("peso", peso);
        return "AbaixoDoPeso";
    }
    @GetMapping("/pesonormal")
    public String pesoNormal(ModelMap model){
        model.addAttribute("imc",imc);
        model.addAttribute("altura",altura);
        model.addAttribute("peso", peso);
        return "PesoNormal";
    }
    @GetMapping("/sobrepeso")
    public String sobrePeso(ModelMap model){
        model.addAttribute("imc",imc);
        model.addAttribute("altura",altura);
        model.addAttribute("peso", peso);
        return "Sobrepeso";
    }

    @GetMapping("/obesidade1")
    public String obesidade1(ModelMap model){
        model.addAttribute("imc",imc);
        model.addAttribute("altura",altura);
        model.addAttribute("peso", peso);
        return "Obesidade1";
    }

    @GetMapping("/obesidade2")
    public String obesidade2(ModelMap model){
        model.addAttribute("imc",imc);
        model.addAttribute("altura",altura);
        model.addAttribute("peso", peso);
        return "Obesidade2";
    }
    @GetMapping("/obesidade3")
    public String obesidade3(ModelMap model){
        model.addAttribute("imc",imc);
        model.addAttribute("altura",altura);
        model.addAttribute("peso", peso);
        return "Obesidade3";
    }


}
