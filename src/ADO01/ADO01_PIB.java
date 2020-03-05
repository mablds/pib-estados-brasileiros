package ADO01;

import java.io.*;
import java.util.ArrayList;

/**
 * Class Description . . .
 *
 * @author: Marcelo Arthur
 * @version: 1.0
 * Main Class File: ADO01_PIB.java
 * File: Structure.java
 * Date: 05/03/2020
 */

public class ADO01_PIB {
    public static void main(String[] args) {
        ArrayList<String> estadoPib = leArquivo("pib.txt");
        int limitIterator = estadoPib.size();
        double somaPib = somaPib(estadoPib);
        
        for(int i = 0; i < limitIterator; i++) {
            if(i % 2 == 0){
                System.out.println(estadoPib.get(i));
            } else {
                double valor = Double.parseDouble(estadoPib.get(i));
                System.out.println(porcentagemEstado(valor, somaPib));
            } 
        }
    }
        
    public static ArrayList<String> leArquivo(String nome){
        String nomeDoArquivo = nome;
        String linha = null;
        ArrayList estadosPIB = new ArrayList<String>();
        
        try {
            FileReader fileReader = new FileReader(nomeDoArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // loop por cada linha do arquivo
            while((linha = bufferedReader.readLine()) != null) {
                String[] array = new String[2];
                array = linha.split(";");
                
                for(int i = 0; i < array.length; i++) {
                    estadosPIB.add(array[i]);
                    //System.out.println(estadosPIB.get(i));
                }
                //System.out.println(linha);
            }   

            // feche o arquivo
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + nomeDoArquivo + "'");                
        }
        catch(IOException ex) {
            System.out.println("Erro lendo o arquivo '" + nomeDoArquivo + "'");                  
        }
        return estadosPIB;
    }
    
    public static double somaPib(ArrayList<String> estadoPIB){
        int limitIterator = estadoPIB.size();
        double soma = 0.0;
        for(int i = 0; i < estadoPIB.size(); i++){
            if(i % 2 != 0){
                soma += Double.parseDouble(estadoPIB.get(i));
            }
        }
        return soma;
    }
    
    public static double porcentagemEstado(double estadoPIB, double somaTotal){
        double porcentagem = (estadoPIB * 100) / somaTotal;
        return porcentagem;
    }
}
