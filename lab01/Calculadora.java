/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */

 import java.util.Scanner;

 public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operacao = sc.nextLine();

        if("+".equals(operacao) || "-".equals(operacao) || "*".equals(operacao) || "/".equals(operacao)) {
            float num1 = sc.nextFloat();
            float num2 = sc.nextFloat();
            if("/".equals(operacao)) {
                if(num2 == 0) {
                    System.out.println("ERRO");
                } else {
                    float divisao = num1 / num2;
                    System.out.println("RESULTADO: " + divisao);
                }
            } else if ("+".equals(operacao)) {
                float soma = num1 + num2;
                System.out.println("RESULTADO: " + soma);
            } else if ("-".equals(operacao)) {
                float subtracao = num1 - num2;
                System.out.println("RESULTADO: " + subtracao);
            } else if ("*".equals(operacao)) {
                float multiplicacao = num1 * num2;
                System.out.println("RESULTADO: " + multiplicacao);
            }
        } else {
            System.out.println("ENTRADA INVALIDA");
        }
    }
 }

 