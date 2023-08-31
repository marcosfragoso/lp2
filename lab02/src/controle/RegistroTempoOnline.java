package controle;


/**
 * A classe representa o registro de tempo online que o aluno dedicou a disciplina remota para concluri se atingiou ou não a meta, em tempo dedicado, da disciplina.
 * Cada instância desta classe mantém informações do nome da disciplina, tempo investido online nela e o tempo online esperado para ela.
 *
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */
public class RegistroTempoOnline {

    /**
     * Nome da disciplina.
     */
    private String nomeDisciplina;

    /**
     * Tempo em horas investido na disciplina.
     */
    private int tempoInvestido;

    /**
     * Tempo em horas esperado para a disciplina.
     */
    private int tempoOnlineEsperado;

    /**
     * Construtor para criar um objeto RegistroTempoOnline com o nome da disciplina e o tempo esperado.
     *
     * @param nomeDisciplina
     * @param tempoOnlineEsperado
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Construtor para criar um objeto RegistroTempoOnline com o nome da disciplina.
     * Quando não é informado a quantidade do tempo esperado, o valor padrão é de 120 horas.
     *
     * @param nomeDisciplina
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = 120;
    }

    /**
     * É um getter que obtém o tempo investido do aluno para aquela disciplina.
     *
     * @return O tempo investido em horas no tipo inteiro.
     */
    public int getTempoInvestido() {
        return tempoInvestido;
    }

    /**
     * É um setter que define o tempo investido do aluno para aquela disciplina.
     *
     * @param tempoInvestido
     */
    public void setTempoInvestido(int tempoInvestido) {
        this.tempoInvestido = tempoInvestido;
    }

    /**
     * Adiciona um determinado tempo investido do aluno para a disciplina online.
     * O método aumenta o tempo investido do aluno.
     *
     * @param tempo O tempo a ser adicionado no tempo investido do aluno em horas.
     */
    public void adicionaTempoOnline(int tempo){
        setTempoInvestido(getTempoInvestido() + tempo);
    }

    /**
     * Método que determina se o aluno atingiu ou não o tempo necessário para disciplina.
     * Se o tempo investido atingir o tempo esperado, retorna true. Caso contrário, false.
     *
     * @return Boolean para saber ou não se atingiu a meta: "true" = atingiu, "false": não atingiu.
     */
    public boolean atingiuMetaTempoOnline() {
        if (this.tempoInvestido >= this.tempoOnlineEsperado) {
            return true;
        }
        return false;
    }

    /**
     * Retorna a representação do objeto RegistroTempoOnline em formato de String.
     * Contém o nome da disciplina, o tempo investido e o tempo esperado.
     *
     * @return String que representa o objeto no formato: {nomeDisciplina} {tempoInvestido}/{tempoOnlineEsperado}
     */
    public String toString() {
        return this.nomeDisciplina + " " + this.tempoInvestido + "/" + tempoOnlineEsperado;
    }
}
