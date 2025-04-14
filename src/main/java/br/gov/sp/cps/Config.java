package br.gov.sp.cps;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean(name = "limiteAbaixoDoPeso")
    public double limiteAbaixoDoPeso() {
        return 18.5;
    }

    @Bean(name = "limitePesoNormal")
    public double limitePesoNormal() {
        return 24.9;
    }

    @Bean(name = "limiteSobrepeso")
    public double limiteSobrepeso() {
        return 29.9;
    }

    @Bean(name = "limiteObesidade1")
    public double limiteObesidade1() {
        return 34.9;
    }

    @Bean(name = "limiteObesidade2")
    public double limiteObesidade2() {
        return 39.9;
    }

    @Bean(name = "limiteObesidade3")
    public double limiteObesidade3() {
        return Double.MAX_VALUE;
    }
}
