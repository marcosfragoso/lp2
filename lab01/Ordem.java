/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */



import java.util.Scanner;

public class Ordem {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int num4 = sc.nextInt();

		if(num4 > num3 && num3 > num2 && num2 > num1){
			System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
		} else if (num1 > num2 && num2 > num3 && num3 > num4) {
			System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
		} else {
			System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
		}
	}
}
