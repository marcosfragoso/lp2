package agenda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AgendaTest {
    @Test
    public void cadastraContatoNumaPosicaoVazia() {
        Agenda agenda = new Agenda();

        String resultadoEsperado = "CADASTRO REALIZADO";
        assertEquals(resultadoEsperado, agenda.cadastraContato(100, "Vinicius", "Marcos", "123456789"));
    }

    @Test
    public void cadastraContatoNumaPosicaoNaoVazia(){
        Agenda agenda = new Agenda();
        agenda.cadastraContato(1, "Vinicius", "Marcos", "123456789");

        String resultadoEsperado = "CADASTRO REALIZADO";
        assertEquals(resultadoEsperado, agenda.cadastraContato(1, "Marcos", "Vinícius", "9999-9999"));
    }

    @Test
    public void naoCadastraContatoJaCadastrado(){
        Agenda agenda = new Agenda();
        agenda.cadastraContato(1, "Vinicius", "Marcos", "123456789");

        String resultadoEsperado = "CONTATO JA CADASTRADO";
        assertEquals(resultadoEsperado, agenda.cadastraContato(2, "Vinicius", "Marcos", "9993-3232"));
    }

    @Test
    public void naoCadastraNaPosicaoMenorQueUm() {
        Agenda agenda = new Agenda();

        String resultadoEsperado = "POSIÇÃO INVÁLIDA";
        assertEquals(resultadoEsperado, agenda.cadastraContato(0, "Vinicius", "Marcos", "9993-3232"));
    }

    @Test
    public void naoCadastraNaPosicaoMaiorQue100() {
        Agenda agenda = new Agenda();

        String resultadoEsperado = "POSIÇÃO INVÁLIDA";
        assertEquals(resultadoEsperado, agenda.cadastraContato(101, "Vinicius", "Marcos", "9993-3232"));
    }

    @Test
    public void naoCadastraComNomeNull() {
        Agenda agenda = new Agenda();

        String resultadoEsperado = "CONTATO INVALIDO";
        assertEquals(resultadoEsperado, agenda.cadastraContato(2, null, "Marcos", "9993-3232"));
    }

    @Test
    public void naoCadastraComTelefoneNull() {
        Agenda agenda = new Agenda();

        String resultadoEsperado = "CONTATO INVALIDO";
        assertEquals(resultadoEsperado, agenda.cadastraContato(2, "Marcos", "Marcos", null));
    }

    @Test
    public void naoCadastraComNomeVazio() {
        Agenda agenda = new Agenda();

        String resultadoEsperado = "CONTATO INVALIDO";
        assertEquals(resultadoEsperado, agenda.cadastraContato(2, "", "Marcos", "9993-3232"));
    }

    @Test
    public void naoCadastraComTelefoneVazio() {
        Agenda agenda = new Agenda();

        String resultadoEsperado = "CONTATO INVALIDO";
        assertEquals(resultadoEsperado, agenda.cadastraContato(2, "Marcos", "Marcos", ""));
    }

    @Test
    public void listarTodosOsContatos() {
        Agenda agenda = new Agenda();

        String resultadoEsperado = "\n1 - Marcos Vinícius\n7 - Fragoso Oliveira\n9 - Iranildo Oliveira";

        agenda.cadastraContato(1, "Marcos", "Vinícius", "123");
        agenda.cadastraContato(7, "Fragoso", "Oliveira", "456");
        agenda.cadastraContato(9, "Iranildo", "Oliveira", "789");

        assertEquals(resultadoEsperado, agenda.listarContatos());
    }

    @Test
    public void listaUmDeterminadoContatoNaoFavorito() {
        Agenda agenda = new Agenda();

        String resultadoEsperado = "Marcos Vinícius\n123";

        agenda.cadastraContato(1, "Marcos", "Vinícius", "123");

        assertEquals(resultadoEsperado, agenda.getContato(1).toString());
    }

    @Test
    public void listaUmDeterminadoContatoFavorito() {
        Agenda agenda = new Agenda();

        String resultadoEsperado = "❤️ Marcos Vinícius\n123";

        agenda.cadastraContato(1, "Marcos", "Vinícius", "123");
        agenda.adicionarFavorito(1,1);

        assertEquals(resultadoEsperado, agenda.getContato(1).toString());
    }

    @Test
    public void exibeContatoNumaPosicaoMenorQueUm() {
        Agenda agenda = new Agenda();

        agenda.cadastraContato(1, "Marcos", "Vinícius", "123");
        assertThrows(IndexOutOfBoundsException.class, () -> agenda.getContato(0));
    }

    @Test
    public void exibeContatoNumaPosicaoMaiorQueCem() {
        Agenda agenda = new Agenda();

        agenda.cadastraContato(1, "Marcos", "Vinícius", "123");
        assertThrows(IndexOutOfBoundsException.class, () -> agenda.getContato(101));
    }

    @Test
    public void exibeContatoNumaPosicaoVazia(){
        Agenda agenda = new Agenda();

        assertEquals(null, agenda.getContato(1));
    }

    @Test
    public void adicionaContatoAosFavoritosNumaPosicaoVazia(){
        Agenda agenda = new Agenda();

        agenda.cadastraContato(100, "Vinicius", "Marcos", "123456789");


        String resultadoEsperado = "CONTATO FAVORITADO NA POSIÇÃO 1!";

        assertEquals(resultadoEsperado, agenda.adicionarFavorito(100, 1));
    }

    @Test
    public void adicionaContatoAosFavoritosNumaPosicaoMenorQueUm(){
        Agenda agenda = new Agenda();

        agenda.cadastraContato(100, "Vinicius", "Marcos", "123456789");


        String resultadoEsperado = "POSIÇÃO INVÁLIDA";

        assertEquals(resultadoEsperado, agenda.adicionarFavorito(100, 0));
    }

    @Test
    public void adicionaContatoAosFavoritosNumaPosicaoOcupada(){
        Agenda agenda = new Agenda();

        agenda.cadastraContato(100, "Vinicius", "Marcos", "123456789");
        agenda.cadastraContato(99, "Fragoso", "Oliveira", "444");
        agenda.adicionarFavorito(99, 1);

        String resultadoEsperado = "CONTATO FAVORITADO NA POSIÇÃO 1!";

        assertEquals(resultadoEsperado, agenda.adicionarFavorito(100, 1));
    }

    @Test
    public void adicionaContatoAosFavoritosNumaPosicaoMaiorQueDez(){
        Agenda agenda = new Agenda();

        agenda.cadastraContato(100, "Vinicius", "Marcos", "123456789");
        agenda.cadastraContato(99, "Fragoso", "Oliveira", "444");
        agenda.adicionarFavorito(99, 1);

        String resultadoEsperado = "POSIÇÃO INVÁLIDA";

        assertEquals(resultadoEsperado, agenda.adicionarFavorito(100, 11));
    }

    @Test
    public void adicionaContatoJaExistenteAosFavoritos(){
        Agenda agenda = new Agenda();

        agenda.cadastraContato(100, "Vinicius", "Marcos", "123456789");
        agenda.adicionarFavorito(100, 3);

        String resultadoEsperado = "CONTATO JÁ EXISTE NA LISTA DE FAVORITOS";

        assertEquals(resultadoEsperado, agenda.adicionarFavorito(100, 1));
    }

    @Test
    public void removerContatoQueNaoExisteNosFavoritos(){
        Agenda agenda = new Agenda();

        String resultadoEsperado = "NÃO EXISTE FAVORITO NESSA POSIÇÃO";

        assertEquals(resultadoEsperado, agenda.removerFavorito(1));
    }

    @Test
    public void removerContatoExisteNosFavoritos(){
        Agenda agenda = new Agenda();
        agenda.cadastraContato(100, "Vinicius", "Marcos", "123456789");
        agenda.adicionarFavorito(100, 3);

        String resultadoEsperado = "CONTATO REMOVIDO COM SUCESSO";

        assertEquals(resultadoEsperado, agenda.removerFavorito(3));
    }

    @Test
    public void listarTodosOsFavoritos() {
        Agenda agenda = new Agenda();
        agenda.cadastraContato(100, "Vinicius", "Marcos", "123456789");
        agenda.cadastraContato(99, "Fragoso", "Oliveira", "999");
        agenda.adicionarFavorito(100, 3);

        String resultadoEsperado = "\n3 - ❤️ Vinicius Marcos\n123456789";

        assertEquals(resultadoEsperado, agenda.listarFavoritos());
    }

    @Test
    public void removeContatoExistenteNaAgenda() {
        Agenda agenda = new Agenda();
        agenda.cadastraContato(100, "Vinicius", "Marcos", "123456789");

        String resultadoEsperado = "CONTATO REMOVIDO COM SUCESSO!";

        assertEquals(resultadoEsperado, agenda.removerContato(100));
    }

    @Test
    public void removeContatoNaoExistenteNaAgenda() {
        Agenda agenda = new Agenda();
        agenda.cadastraContato(100, "Vinicius", "Marcos", "123456789");

        String resultadoEsperado = "CONTATO NÃO EXISTE NA AGENDA!";

        assertEquals(resultadoEsperado, agenda.removerContato(99));
    }

    @Test
    public void naoRemoveContatoPosicaoAbaixoDoLimite() {
        try {
            Agenda agenda = new Agenda();
            agenda.removerContato(0);
            fail("Era esperado exceção ao passar código vazio");
        } catch (IndexOutOfBoundsException idx) {

        }
    }

    @Test
    public void naoRemoveContatoPosicaoAcimaDoLimite() {
        try {
            Agenda agenda = new Agenda();
            agenda.removerContato(101);
            fail("Era esperado exceção ao passar código vazio");
        } catch (IndexOutOfBoundsException idx) {

        }
    }

    @Test
    public void buscaContatosPorNomeOuSobrenome() {
        Agenda agenda = new Agenda();
        agenda.cadastraContato(1, "Marcos", "Fragoso", "123");
        agenda.cadastraContato(6, "Vinicius", "Oliveira", "456");
        agenda.cadastraContato(11, "Jaqueline", "Fragoso", "789");

        String resultadoEsperado = "\n1 - Marcos Fragoso\n123\n11 - Jaqueline Fragoso\n789";

        assertEquals(resultadoEsperado, agenda.getContatos("Fragoso"));
    }

}
