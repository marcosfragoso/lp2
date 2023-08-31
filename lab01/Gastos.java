/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */

 import java.util.Scanner;


 public class Gastos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] meses = sc.nextLine().split(" ");
        String[] gastos = sc.nextLine().split(" ");
        String mes = sc.nextLine();

        for(int i = 0; i < meses.length; i++) {
            if(meses[i].equals(mes)) {
                System.out.println(gastos[i]);
            }
        }

    }
    
 }
