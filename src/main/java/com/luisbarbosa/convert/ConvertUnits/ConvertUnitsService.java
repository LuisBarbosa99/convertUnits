package com.luisbarbosa.convert.ConvertUnits;

import com.luisbarbosa.convert.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ConvertUnitsService {
    private final ConvertUnitsRepository convertUnitsRepository;

    @Autowired
    public ConvertUnitsService(ConvertUnitsRepository convertUnitsRepository) {
        this.convertUnitsRepository = convertUnitsRepository;
    }

    public float operacao(float valor1,float valor2,char op){
        float result;

        if (op=='*')
            result = valor1 * valor2;
        else
            result = valor1 / valor2;

        return result;
    }

    public float calculo(String equacao){
        float valor1, valor2;
        char op = 0;
        String[] valores = new String[0];

        if (equacao.contains("*")){
            op = '*';
            valores = equacao.split("[*]");
        }else if (equacao.contains("/")){
            op = '/';
            valores = equacao.split("/");
        }

        valor1 = Float.parseFloat(valores[0]);
        valor2 = Float.parseFloat(valores[1]);

        return operacao(valor1,valor2,op);
    }

    public String openClose(String equacao){

        int cont = 0;   //Contador de parênteses abertos
        int posInicio = 0;
        int posFinal = 0;
        boolean first = true;

        for (int i=0; i<equacao.length(); i++) {
            char c = equacao.charAt(i);

            if (c == '(') {
                cont++;
                if (first){
                    posInicio = i;
                    first = false;
                }
            }else if (c == ')'){
                cont--;
                if (cont == 0){
                    posFinal = i;
                    break;
                }
            }
            if(i==equacao.length()-1 && cont==0)
                return equacao;
        }

        if (posInicio != posFinal){
            String subEquacao1 = equacao.substring(posInicio+1,posFinal-1);
            return openClose(subEquacao1);
        }
        return null;
    }
    @GetMapping
    public Response getConversion(String units){
        String subEquacao = null;
        float resposta = 0;
        String nomesSI = units;
        String nome;
        List<ConvertUnits> conversions = convertUnitsRepository.findAll();

        for (int i = 0; i <conversions.size();i++){
            units = units.replace(conversions.get(i).getName(), Float.toString(conversions.get(i).getValue()));

            nomesSI= nomesSI.replace(conversions.get(i).getName(), conversions.get(i).getUnitName());
        }

        if (units.contains("*") || units.contains("/")){

            if (!units.contains("(")){
                resposta = calculo(subEquacao);
            }else {
                while(true){
                    subEquacao = openClose(units);

                    if (subEquacao == units)
                        break;

                    resposta = calculo(subEquacao);
                    subEquacao = "(" + subEquacao + ")";

                    units.replace(subEquacao, Float.toString(resposta));
                }
            }
        }else{
            resposta = Float.parseFloat(units);
        }
        return new Response(nomesSI,resposta); //unit_type: nomesSI, multiplication_factor: resposta
    }
}
