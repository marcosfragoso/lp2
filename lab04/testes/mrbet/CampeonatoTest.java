package mrbet;

import br.edu.ufcg.computacao.mrbet.Campeonato;
import br.edu.ufcg.computacao.mrbet.Time;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampeonatoTest {
    private Campeonato campeonato;
    private Campeonato brasileiro;
    private Campeonato copaDoBrasil;
    private Time time;
    @BeforeEach
    void setup(){
        campeonato = new Campeonato(20, "Copa do Brasil");
        brasileiro = new Campeonato(0, "Campeonato Brasileiro");
        copaDoBrasil = new Campeonato(10, "copa do brasil");
        time = new Time("PB_001", "Botafogo", "Manequinho");
    }

    @Test
    public void incluirTimeComSucesso() {
        Assertions.assertTrue(campeonato.incluirTime(time));
    }
    @Test
    public void incluirTimeNegado() {
        Assertions.assertFalse(brasileiro.incluirTime(time));
    }
    @Test
    public void equalsObjetosIguais() {
        Assertions.assertTrue(campeonato.equals(copaDoBrasil));
    }
    @Test
    public void equalsObjetosDiferentes() {
        Assertions.assertFalse(campeonato.equals(brasileiro));
    }
    @Test
    public void verificaTimeExistente() {
        campeonato.incluirTime(time);
        Assertions.assertTrue(campeonato.verificaTime(time));
    }
    @Test
    public void verificaTimeInexistente() {
        Assertions.assertFalse(campeonato.verificaTime(time));
    }
    @Test
    public void verificaToString(){
        campeonato.incluirTime(time);
        String result = "Copa do Brasil - 1/20";
        Assertions.assertEquals(result, campeonato.toString());
    }





}
