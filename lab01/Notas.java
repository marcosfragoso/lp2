/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */

 import java.util.Scanner;

 public class Notas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soma = 0;
        int abaixo = 0;
        int acima = 0;
        int qntd = 0;
        int maior = 0;
        int menor = 0;
        int media = 0;

        String aluno = sc.nextLine();
        if(!"-".equals(aluno)) {
            int nota = Integer.parseInt(aluno.split(" ")[1]);
            maior = nota;
            menor = nota;
            qntd ++;
            soma += maior;

            if(nota >= 700) {
                acima++;
            } else {
                abaixo++;
            }
        }

        aluno = sc.nextLine();
        while(!"-".equals(aluno)) {
            int nota = Integer.parseInt(aluno.split(" ")[1]);
            soma += nota;
            qntd++;

            if (nota > maior) {
                maior = nota;
            }
            if (nota < menor) {
                menor = nota;
            }
            if(nota >= 700) {
                acima++;
            } else {
                abaixo++;
            }

            aluno = sc.nextLine();
        }

        media = soma / qntd;

        System.out.println("maior: " + maior);
        System.out.println("menor: " + menor);
        System.out.println("media: " + media);
        System.out.println("acima: " + acima);
        System.out.println("abaixo: " + abaixo);
    }
 }
