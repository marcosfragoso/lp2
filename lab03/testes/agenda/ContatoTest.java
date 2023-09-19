package agenda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ContatoTest {
    @Test
    public void verificaSeDoisContatosSaoIguais() {
        Contato c1 = new Contato("Marcos", "Vinícius", "123456789");
        Contato c2 = new Contato("Marcos", "Vinícius", "1");

        boolean resultadoEsperado = true;
        assertEquals(resultadoEsperado, c1.equals(c2));
    }
    @Test
    public void verificaSeDoisContatosSaoDiferentes(){
        Contato c1 = new Contato("Marcos", "Vinícius", "123456789");
        Contato c2 = new Contato("Marcos", "Vinicius", "123456789");

        boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado, c1.equals(c2));
    }
    @Test
    public void verificaToStringDeContatoFavorito() {
        Contato c1 = new Contato("Marcos", "Vinícius", "123456789");
        c1.setFavorito(true);

        String resultadoEsperado = "❤️ Marcos Vinícius\n123456789";
        assertEquals(resultadoEsperado, c1.toString());
    }
    @Test
    public void verificaToStringDeContatoNaoFavorito() {
        Contato c1 = new Contato("Marcos", "Vinícius", "123456789");

        String resultadoEsperado = "Marcos Vinícius\n123456789";
        assertEquals(resultadoEsperado, c1.toString());
    }

    @Test
    public void verificaContatoComNomeNulo() {
        try {
            Contato contatoInvalido = new Contato(null, "Vinicius", "123");
            fail("Era esperado exceção ao passar código nulo");
        } catch (NullPointerException npe) {

        }
    }
    @Test
    public void verificaContatoComSobrenomeNulo() {
        try {
            Contato contatoInvalido = new Contato("Marcos", null, "123");
            fail("Era esperado exceção ao passar código nulo");
        } catch (NullPointerException npe) {

        }
    }
    @Test
    public void verificaContatoComTelefoneNulo() {
        try {
            Contato contatoInvalido = new Contato("Marcos", "Vinícius", null);
            fail("Era esperado exceção ao passar código nulo");
        } catch (NullPointerException npe) {

        }
    }
    @Test
    public void verificaContatoComNomeVazio() {
        try {
            Contato contatoInvalido = new Contato("  ", "Vinícius", "123");
            fail("Era esperado exceção ao passar código vazio");
        } catch (IllegalArgumentException npe) {

        }
    }
    @Test
    public void verificaContatoComSobrenomeVazio() {
        try {
            Contato contatoInvalido = new Contato("Marcos", " ", "123");
            fail("Era esperado exceção ao passar código vazio");
        } catch (IllegalArgumentException npe) {

        }
    }
    @Test
    public void verificaContatoComTelefoneVazio() {
        try {
            Contato contatoInvalido = new Contato("Marcos", "Sobrenome", "");
            fail("Era esperado exceção ao passar código vazio");
        } catch (IllegalArgumentException npe) {

        }
    }

    @Test
    public void verificaSeAlterouTelefone() {
        Contato c1 = new Contato("Marcos", "Vinícius", "123456789");
        c1.setTelefone("123");

        String resultadoEsperado = "Marcos Vinícius\n123";

        assertEquals(resultadoEsperado, c1.toString());
    }

    @Test
    public void verificaSeAlterouTelefoneParaVazio() {
        try {
            Contato contatoInvalido = new Contato("Marcos", "Vinicius", "123");
            contatoInvalido.setTelefone("");
            fail("Era esperado exceção ao passar código vazio");
        } catch (IllegalArgumentException npe) {

        }
    }

    @Test
    public void verificaSeAlterouTelefoneParaNulo() {
        try {
            Contato contatoInvalido = new Contato("Marcos", "Vinicius", "123");
            contatoInvalido.setTelefone(null);
            fail("Era esperado exceção ao passar código vazio");
        } catch (NullPointerException npe) {

        }
    }

    @Test
    public void adiconarTagNumContato(){
        Contato c1 = new Contato("Marcos", "Vinícius", "123");

        String resultadoEsperado = "Tag adicionada com sucesso!";

        assertEquals(resultadoEsperado, c1.adicionarTag("TAG"));
    }

    @Test
    public void adiconarTagNumContatoComCincoTags(){
        Contato c1 = new Contato("Marcos", "Vinícius", "123");
        c1.adicionarTag("TAG1");
        c1.adicionarTag("TAG2");
        c1.adicionarTag("TAG3");
        c1.adicionarTag("TAG4");
        c1.adicionarTag("TAG5");

        String resultadoEsperado = "Contato já possui 5 tags!";

        assertEquals(resultadoEsperado, c1.adicionarTag("TAG"));
    }
}
