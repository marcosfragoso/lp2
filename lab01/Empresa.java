import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */



 public class Empresa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	String gasto = sc.nextLine();

        String[] gastos = gasto.split(" ");
        int[] gastosInteiro = new int[gastos.length];

        for(int i = 0; i < gastos.length; i++) {
            gastosInteiro[i] = Integer.parseInt(gastos[i]);
        }

        for(int i = 0; i < gastosInteiro.length - 1; i++) {
            boolean trocou = false;
            for(int j = 0; j < gastosInteiro.length - i - 1; j++) {
                if(gastosInteiro[j] > gastosInteiro[j + 1]) {
                    int varAux = gastosInteiro[j];
                    gastosInteiro[j] = gastosInteiro[j + 1];
                    gastosInteiro[j + 1] = varAux;
                    trocou = true;
                }
            }
            if(!trocou) {
                break;
            }
        }

        System.out.println(gastosInteiro[gastosInteiro.length - 1] + gastosInteiro[gastosInteiro.length - 2]);
    }
 }
