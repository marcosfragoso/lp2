public abstract class Questao {
    private String enunciado;
    private int prioridade;
    private String gabarito;

    public Questao(String enunciado, int prioridade, String gabarito) {
        this.enunciado = enunciado;
        this.prioridade = prioridade;
        this.gabarito = gabarito;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getGabarito() {
        return gabarito;
    }

}
