package controle;


/**
 * Classe main para as funcionalidades bônus
 *
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */
public class CoisaBonus {
    public static void main(String[] args) {
        disciplinaSemPesos();
        System.out.println("-----");
        disciplinaComPesos();
        System.out.println("-----");
        contemNosRegistros();
    }

    public static void disciplinaSemPesos() {
        Disciplina d1 = new Disciplina("P2", 5);
        d1.cadastraNota(1, 10);
        d1.cadastraNota(2, 9);
        d1.cadastraNota(3, 8);
        d1.cadastraNota(4, 7);
        d1.cadastraNota(5, 6);
        System.out.println(d1.aprovado());
    }

    public static void disciplinaComPesos() {
        double [] pesos = {6, 4};
        Disciplina d2 = new Disciplina("LP2", 2, pesos);
        d2.cadastraNota(1,10);
        d2.cadastraNota(2, 8);
        System.out.println(d2.aprovado());
    }

    public static void contemNosRegistros(){
        RegistroResumos meusResumos = new RegistroResumos(100); // 100 resumos
        meusResumos.adiciona("Classes", "Classes definem um tipo e a base de código para criação de objetos.");
        meusResumos.adiciona("Tipo", "Identifica a semântica (operações e significados) de um conjunto de dados.");
        String[] busca = meusResumos.busca("UM");
        for (int i = 0; i < busca.length; i++) {
            System.out.println(busca[i]);
        }
    }
}
