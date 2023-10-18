public class Main {
    public static void main(String[] args) {
        CornO c = new CornO();
        c.cadastrarAnotacao("P2", "28/08/2019", "Texto qualquer");
        c.cadastrarAnotacao("LP2", "29/08/2019", "Texto qualquer");
        c.cadastrarAnotacao("P2", "30/08/2019", "Texto qualquer");
        c.definirSumario(1, "Classes e Objetos. Primeiros objetos.");
        c.definirSumario(2, "Programando a primeira classe. Lab 2.");
        c.definirSumario(3, "Métodos. Objetos com ações");
        System.out.println(c.listarAnotacoes());
    }
}