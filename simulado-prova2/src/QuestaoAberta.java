public class QuestaoAberta extends Questao{

    public QuestaoAberta(String enunciado, int prioridade, String gabarito) {
        super(enunciado, prioridade, gabarito);
    }

    public double getPeso() {
        return this.getPrioridade() * (1.2);
    }

    public String toString() {
        return this.getEnunciado() + " (" + this.getPeso() + ")";
    }
}
