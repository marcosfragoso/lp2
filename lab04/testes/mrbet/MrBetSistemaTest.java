package mrbet;

import br.edu.ufcg.computacao.mrbet.MrBetSistema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class MrBetSistemaTest {
    private MrBetSistema sistema;

    @BeforeEach
    void setup() {
        sistema = new MrBetSistema();
        sistema.incluirTime("001_SP", "Corinthians", "Mosqueteiro");
        sistema.incluirTime("002_SP", "Palmeiras", "Porco");
        sistema.incluirTime("003_SP", "Santos", "Peixe");
        sistema.incluirTime("004_RJ", "Flamengo", "Urubu");
        sistema.adicionarCampeonato("Campeonato Brasileiro", 20);
        sistema.adicionarCampeonato("Copa Libertadores", 1);
        sistema.incluirTimeEmCampeonato("001_SP", "copa libertadores");
        sistema.adicionarAposta("001_SP", "Copa Libertadores", 1, 500);

    }

    @Test
    public void incluirTimeNoSistemaComSucesso() {
        Assertions.assertEquals("INCLUSÃO REALIZADA!", sistema.incluirTime("250_PB", "Nacional de Patos", "Canário"));
    }
    @Test
    public void incluirTimeQueJáExiste(){
        sistema.incluirTime("250_PB", "Treze", "Galo");
        Assertions.assertEquals("TIME JÁ EXISTE!", sistema.incluirTime("250_PB", "Nacional de Patos", "Canário"));
    }
    @Test
    public void cadastrarUmCampeonatoComSucesso() {
        Assertions.assertEquals("CAMPEONATO ADICIONADO!", sistema.adicionarCampeonato("Copa do Brasil", 32));
    }
    @Test
    public void cadastrarCampeonatoExistente() {
        Assertions.assertEquals("CAMPEONATO JÁ EXISTE!", sistema.adicionarCampeonato("campEonaTo brasileiro", 5));
    }

    @Test
    public void incluirTimeEmCampeonatoExistente() {
        Assertions.assertEquals("TIME INCLUÍDO NO CAMPEONATO!", sistema.incluirTimeEmCampeonato("002_SP", "campeonato brasileiro"));
    }
    @Test
    public void incluirTimeJaInscritoEmCampeonatoExistente() {
        Assertions.assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!", sistema.incluirTimeEmCampeonato("001_SP", "copa libertadores"));
    }

    @Test
    public void incluirTimeEmCampeonatoInexistente() {
        try {
            sistema.incluirTimeEmCampeonato("001_SP", "copa do brasil");
            fail("O CAMPEONATO NÃO EXISTE!");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    public void incluirTimeEmCampeonatoSemVagas() {
        Assertions.assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!", sistema.incluirTimeEmCampeonato("002_SP", "copa libertadores"));
    }
    @Test
    public void incluirTimeQueNaoExisteEmCampeonato() {
        try {
            sistema.incluirTimeEmCampeonato("007_SC", "campeonato brasileiro");
            fail("O TIME NÃO EXISTE!");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    public void verificaTimeParticipanteExistenteEmCampeonatoExistente() {
        Assertions.assertEquals("O TIME ESTÁ NO CAMPEONATO", sistema.verificaTimeEmCampeonato("001_SP", "Copa Libertadores"));
    }

    @Test
    public void verificaTimeNaoParticipanteExistenteEmCampeonatoExistente() {
        Assertions.assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO", sistema.verificaTimeEmCampeonato("002_SP", "Copa Libertadores"));
    }

    @Test
    public void verificaTimeInexistenteEmCampeonatoExistente() {
        try {
            sistema.verificaTimeEmCampeonato("007_SP", "Copa Libertadores");
            fail("O TIME NÃO EXISTE!");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    public void verificaTimeExistenteEmCampeonatoInexistente() {
        try {
            sistema.verificaTimeEmCampeonato("001_SP", "Premier League");
            fail("O CAMPEONATO NÃO EXISTE!");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    public void exibeCampeonatosQueOTimeParticipa() {
        String result = "Campeonatos do Corinthians:\n* Copa Libertadores - 1/1";
        Assertions.assertEquals(result, sistema.exibirCampeonatosQueOTimeParticipa("001_SP"));
    }
    @Test
    public void exibeCampeonatosQueOTimeInexistenteParticipa() {
        try {
            sistema.exibirCampeonatosQueOTimeParticipa("007_SP");
            fail("O TIME NÃO EXISTE!");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    public void adicionaApostaComSucesso() {
        String result = "APOSTA REGISTRADA";
        Assertions.assertEquals(result, sistema.adicionarAposta("001_SP", "Copa Libertadores", 1, 200));
    }

    @Test
    public void adicionaApostaComColocacaoAcimaDeParticipantes() {
        String result = "APOSTA NÃO REGISTRADA!";
        Assertions.assertEquals(result, sistema.adicionarAposta("001_SP", "Copa Libertadores", 2, 200));
    }

    @Test
    public void adicionaApostaEmTimeInexistente() {
        try {
            sistema.adicionarAposta("007_SP", "Copa Libertadores", 1, 200);
            fail("O TIME NÃO EXISTE!");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    public void adicionaApostaEmCampeonatoInexistente() {
        try {
            sistema.adicionarAposta("001_SP", "Premier League", 1, 200);
            fail("O CAMPEONATO NÃO EXISTE!");
        } catch (IllegalArgumentException iae) {

        }
    }

    @Test
    public void imprimeStatusDaAposta() {
        String result = "\n1. [001_SP] Corinthians / Mosqueteiro\nCopa Libertadores\n1/1\nR$ 500.0";
        Assertions.assertEquals(result, sistema.statusApostas());
    }
    @Test
    public void imprimeUnicoTimeMaisIncluido(){
        sistema.incluirTimeEmCampeonato("001_SP", "Campeonato Brasileiro");
        sistema.incluirTimeEmCampeonato("002_SP", "Campeonato Brasileiro");

        String result = "Participação mais frequente em campeonatos\n[001_SP] Corinthians / Mosqueteiro";
        Assertions.assertEquals(result, sistema.timeMaisIncluido());
    }

    @Test
    public void imprimeTimesMaisIncluidos(){
        sistema.incluirTimeEmCampeonato("002_SP", "Campeonato Brasileiro");

        String result = "Participação mais frequente em campeonatos\n[001_SP] Corinthians / Mosqueteiro - 1\n[002_SP] Palmeiras / Porco - 1\n";
        Assertions.assertEquals(result, sistema.timeMaisIncluido());
    }

    @Test
    public void imprimteTimesQueNaoParticipamDeCampeonatos(){
        String result = "Ainda não participou de campeonato\n[004_RJ] Flamengo / Urubu\n" +
                        "[003_SP] Santos / Peixe\n" +
                        "[002_SP] Palmeiras / Porco\n";

        Assertions.assertEquals(result, sistema.timesQueNaoParticiparam());
    }

    @Test
    public void imprimeTimesMaisPopularesEmApostas(){
        sistema.incluirTimeEmCampeonato("002_SP", "campeonato Brasileiro");
        sistema.adicionarAposta("002_SP", "Campeonato Brasileiro", 1, 1000);
        sistema.adicionarAposta("002_SP", "Campeonato Brasileiro", 1, 500);
        sistema.adicionarAposta("002_SP", "Campeonato Brasileiro", 1, 500);

        String result = "Popularidade em apostas\nPalmeiras / 3\nCorinthians / 1\n";
        Assertions.assertEquals(result, sistema.primeiroNasApostas());
    }
}
