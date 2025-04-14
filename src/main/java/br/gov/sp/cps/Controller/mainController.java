package br.gov.sp.cps.Controller;

import br.gov.sp.cps.services.ImcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class mainController {

    private Double peso = (Double) 0.0;
    private Double altura = (Double) 0.0;
    private Double imc = (Double) 0.0;

    @Autowired
    private ImcService imcService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/imc")
    public String calculaImc(@RequestParam("numPeso") Double peso,
                             @RequestParam("numAltura") Double altura,
                             ModelMap model) {
        this.peso = peso;
        this.altura = altura;
        this.imc = (Double) ImcService.calculeImc(altura, peso);

        String classificacao = imcService.classifiqueImc(imc);

        return switch (classificacao) {
            case "Abaixo do Peso" -> "redirect:/abaixodopeso";
            case "Peso Normal" -> "redirect:/pesonormal";
            case "Sobrepeso" -> "redirect:/sobrepeso";
            case "Obesidade 1" -> "redirect:/obesidade1";
            case "Obesidade 2" -> "redirect:/obesidade2";
            default -> "redirect:/obesidade3";
        };
    }

    @GetMapping("/abaixodopeso")
    public String abaixoDoPeso(ModelMap model) {
        model.addAttribute("imc", imc);
        model.addAttribute("altura", altura);
        model.addAttribute("peso", peso);
        return "AbaixoDoPeso";
    }

    @GetMapping("/pesonormal")
    public String pesoNormal(ModelMap model) {
        model.addAttribute("imc", imc);
        model.addAttribute("altura", altura);
        model.addAttribute("peso", peso);
        return "PesoNormal";
    }

    @GetMapping("/sobrepeso")
    public String sobrePeso(ModelMap model) {
        model.addAttribute("imc", imc);
        model.addAttribute("altura", altura);
        model.addAttribute("peso", peso);
        return "Sobrepeso";
    }

    @GetMapping("/obesidade1")
    public String obesidade1(ModelMap model) {
        model.addAttribute("imc", imc);
        model.addAttribute("altura", altura);
        model.addAttribute("peso", peso);
        return "Obesidade1";
    }

    @GetMapping("/obesidade2")
    public String obesidade2(ModelMap model) {
        model.addAttribute("imc", imc);
        model.addAttribute("altura", altura);
        model.addAttribute("peso", peso);
        return "Obesidade2";
    }

    @GetMapping("/obesidade3")
    public String obesidade3(ModelMap model) {
        model.addAttribute("imc", imc);
        model.addAttribute("altura", altura);
        model.addAttribute("peso", peso);
        return "Obesidade3";
    }
}
