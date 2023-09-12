package cronicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CronicasDoEstudanteTest {
    @Test
    public void criandoLivretoAbaixoLimite(){
        CronicasDoEstudanteSistema sistema = new CronicasDoEstudanteSistema();

        sistema.cadastrarCronica("Minha semana do fera 2022.2", "Cheguei bem fera na UFCG, não sabia onde achar nada… A semana do fera foi essencial para eu tomar um rumo…", "13/03/2023");
        sistema.cadastrarCronica("JUnit lá vou eu!", "JUnit é o framework de Java para testes de unidade, disponível na versão 5…", "19/04/2023", "Nathanzinho");
        sistema.cadastrarCronica("Mulheres na computacao!", "Ada Lovelace eh uma importante figura na historia da computacao...", "24/08/2023");

        try {
            int[] indices = {0, 1};
            sistema.criarLivreto(indices);
            fail("Era esperado exceção IllegalArgumentException");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    public void criandoLivretoAcimaLimite(){
        CronicasDoEstudanteSistema sistema = new CronicasDoEstudanteSistema();

        sistema.cadastrarCronica("Minha semana do fera 2022.2", "Cheguei bem fera na UFCG, não sabia onde achar nada… A semana do fera foi essencial para eu tomar um rumo…", "13/03/2023");
        sistema.cadastrarCronica("JUnit lá vou eu!", "JUnit é o framework de Java para testes de unidade, disponível na versão 5…", "19/04/2023", "Nathanzinho");
        sistema.cadastrarCronica("Mulheres na computacao!", "Ada Lovelace eh uma importante figura na historia da computacao...", "24/08/2023");

        try {
            int[] indices = {0, 1, 2, 0, 1, 2};
            sistema.criarLivreto(indices);
            fail("Era esperado exceção IllegalArgumentException");
        } catch (IllegalArgumentException iae) {

        }
    }
    @Test
    public void criandoLivreto(){
        CronicasDoEstudanteSistema sistema = new CronicasDoEstudanteSistema();

        sistema.cadastrarCronica("Minha semana do fera 2022.2", "Cheguei bem fera na UFCG, não sabia onde achar nada… A semana do fera foi essencial para eu tomar um rumo…", "13/03/2023");
        sistema.cadastrarCronica("JUnit lá vou eu!", "JUnit é o framework de Java para testes de unidade, disponível na versão 5…", "19/04/2023", "Nathanzinho");
        sistema.cadastrarCronica("Mulheres na computacao!", "Ada Lovelace eh uma importante figura na historia da computacao...", "24/08/2023");

        int[] indices = {0, 1, 2};

        assertEquals(true, sistema.criarLivreto(indices));
    }

    @Test
    public void cronicaMaisLida() {
        CronicasDoEstudanteSistema sistema = new CronicasDoEstudanteSistema();

        sistema.cadastrarCronica("Minha semana do fera 2022.2", "Cheguei bem fera na UFCG, não sabia onde achar nada… A semana do fera foi essencial para eu tomar um rumo…", "13/03/2023");
        sistema.cadastrarCronica("JUnit lá vou eu!", "JUnit é o framework de Java para testes de unidade, disponível na versão 5…", "19/04/2023", "Nathanzinho");
        sistema.cadastrarCronica("Mulheres na computacao!", "Ada Lovelace eh uma importante figura na historia da computacao...", "24/08/2023");

        sistema.lerCronica(0);
        sistema.lerCronica(1);
        sistema.lerCronica(1);

        String resultadoEsperado = "JUnit lá vou eu! - lida 2 vezes";
        assertEquals(resultadoEsperado, sistema.exibirCronicaMaisLida());
    }
}
