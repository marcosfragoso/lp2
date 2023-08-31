/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */

 import java.util.Scanner;

 public class Acima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sequencia = sc.nextLine();

        float soma = 0;
        for(String numero : sequencia.split(" ")) {
            float numeroFloat = Float.parseFloat(numero);
            soma += numeroFloat;
        }
        
        float media = soma / sequencia.split(" ").length;
        for(String numero : sequencia.split(" ")) {
            int numeroFloat = Integer.parseInt(numero);
            if(numeroFloat > media) {
                System.out.print(numeroFloat + " ");
            }
        }
    }
    
 }
