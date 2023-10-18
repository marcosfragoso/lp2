import java.util.Arrays;

public class QuestaoMultiplaEscolha extends Questao{
    private String[] alternativas;
    public QuestaoMultiplaEscolha(String enunciado, int prioridade, String gabarito, String[] alternativas) {
        super(enunciado, prioridade, gabarito);
        this.alternativas = alternativas;
    }

    public double getPeso() {
        return this.getPrioridade() * (this.alternativas.length / 5.0);
    }

    @Override
    public String toString() {
        String[] letras = {"a) ","b) ","c) ","d) ","e) "};
        String retorno = this.getEnunciado() + " (" + this.getPeso() + "):";
        int indice = 0;
        for (String alternativa : this.alternativas) {
            retorno += "\n" + letras[indice] + alternativa;
            indice++;
        }
        return retorno;
    }
}
