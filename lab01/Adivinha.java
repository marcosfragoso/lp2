/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */

 import java.util.Scanner;


 public class Adivinha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();

        while(true) {
            int tentativa = sc.nextInt();
            if(tentativa > numero) {
                System.out.println("MAIOR");
            } else if (tentativa < numero) {
                System.out.println("MENOR");
            } else {
                System.out.println("ACERTOU");
                break;
            }
        }
    }
 }
