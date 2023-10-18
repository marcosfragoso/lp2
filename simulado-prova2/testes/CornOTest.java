import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CornOTest {
    private CornO c;

    @BeforeEach
    void setup() {
        c = new CornO();
        c.cadastrarAnotacao("Nome","data","txt");
        c.cadastrarQuestaoMultipla(1, "Questão 1", new String[]{"Errada", "Certa", "Errada", "Errada", "Errada"}, 10, "b");
        c.cadastrarQuestaoAberta(1, "Questão 2", 20, "Vermelho");
    }

    @Test
    public void respondeQuestaoCorreta(){
        Assertions.assertTrue(c.responderQuestao(1,2, "vermelho"));
    }

    @Test
    public void respondeQuestaoErrada(){
        Assertions.assertFalse(c.responderQuestao(1,1, "a"));
    }

}
