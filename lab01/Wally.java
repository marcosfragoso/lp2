/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */

 import java.util.Scanner;

 public class Wally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nomes = sc.nextLine();
        int qntdLetras = 5;

        while (!nomes.equals("wally")) {
            String novoNome = "?";
            for(String nome : nomes.split(" ")) {
                if(nome.length()== qntdLetras) {
                    novoNome = nome;
                }
            }
            System.out.println(novoNome);
            nomes = sc.nextLine();
        }
    }
 }
