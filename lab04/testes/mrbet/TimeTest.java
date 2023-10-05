package mrbet;

import br.edu.ufcg.computacao.mrbet.Campeonato;
import br.edu.ufcg.computacao.mrbet.Time;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TimeTest {
    private Time timeA;
    private Time timeB;
    private Time timeC;
    private Campeonato campeonato;

    @BeforeEach
    void setup(){
        timeA = new Time("PB_001", "Botafogo", "Manequinho");
        timeB = new Time("PB_002", "Flamengo", "Urubu");
        timeC = new Time("PB_001", "Corinthians", "Mosqueteiro");
        campeonato = new Campeonato(10,"Brasileiro");
    }

    @Test
    public void testaNumCampeonatos() {
        timeA.adicionaCampeonato(campeonato);
        Assertions.assertEquals(1, timeA.quantidadeCampeonatos());
    }

    @Test
    public void testaToString(){
        String result = "[PB_001] Botafogo / Manequinho";
        Assertions.assertEquals(result, timeA.toString());
    }

    @Test
    public void testaEqualsObjetosIguais(){
        Assertions.assertTrue(timeA.equals(timeC));
    }

    @Test
    public void testaEqualsObjetosDiferentes(){
        Assertions.assertFalse(timeA.equals(timeB));
    }

}
