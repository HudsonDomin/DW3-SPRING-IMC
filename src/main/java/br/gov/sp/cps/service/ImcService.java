package br.gov.sp.cps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ImcService {
    @Autowired
    @Qualifier("limiteAbaixoDoPeso")
    private double limiteAbaixoDoPeso;
    @Autowired
    @Qualifier("limitePesoNormal")
    private double limitePesoNormal;
    @Autowired
    @Qualifier("limiteSobrepeso")
    private double limiteSobrepeso;
    @Autowired
    @Qualifier("limiteObesidade1")
    private double limiteObesidade1;
    @Autowired
    @Qualifier("limiteObesidade2")
    private double limiteObesidade2;
    @Autowired
    @Qualifier("limiteObesidade3")
    private double limiteObesidade3;

    public static double calculeImc(double altura, double peso){
        return peso / (altura * altura);
    }

    public String classifiqueImc(double imc){
        if(imc < limiteAbaixoDoPeso){
            return "Abaixo do Peso";
        }
        if(imc < limitePesoNormal){
            return "Peso Normal";
        }
        if(imc < limiteSobrepeso){
            return "Sobrepeso";
        }
        if(imc < limiteObesidade1){
            return "Obesidade 1";
        }
        if(imc < limiteObesidade2){
            return "Obesidade 2";
        }
        return "Obesidade 3";
    }
}
