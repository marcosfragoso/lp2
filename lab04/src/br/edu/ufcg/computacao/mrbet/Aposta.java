package br.edu.ufcg.computacao.mrbet;

/**
 * Representação de uma aposta onde recebe o time que vai ser apostado, o campeonato, a colocação e o valor da aposta.
 *
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */
public class Aposta {
    /**
     * O objeto Time em que deseja apostar.
     */
    private Time time;

    /**
     * O objeto Campeonato em que deseja apostar.
     */
    private Campeonato campeonato;

    /**
     * A colocação do time que deseja apostar.
     */
    private int colocacao;

    /**
     * O valor da aposta.
     */
    private double valor;

    /**
     * Construtor que cria uma nova instância de aposta que recebe o time, o campeonato, a colocação do time e o valor da aposta.
     *
     * @param time O time que deseja apostar.
     * @param campeonato O campeonato que deseja apostar.
     * @param colocacao A colocação do time.
     * @param valor O valor da aposta.
     */
    public Aposta(Time time, Campeonato campeonato, int colocacao, double valor) {
        this.time = time;
        this.campeonato = campeonato;
        this.colocacao = colocacao;
        this.valor = valor;
    }

    /**
     * Método get que retorna a colocação apostada no time.
     *
     * @return A colocação.
     */
    public int getColocacao() {
        return colocacao;
    }

    /**
     * Método get que retorna o time em que foi feito a aposta.
     *
     * @return O time.
     */
    public Time getTime() {
        return time;
    }

    /**
     * Método básico toString que é uma representação em formato de String do objeto aposta.
     * Contém as informações do time, campeonato, colocação e os participantes
     *
     * @return Uma Strind contendo o nome do time, o nome do campeonato, a colocação em que foi apostado e o valor da aposta.
     */
    @Override
    public String toString() {
        String linha1 = this.time.toString();
        String linha2 = this.campeonato.getNome();
        String linha3 = this.colocacao + "/" + this.campeonato.getParticipantes();
        String linha4 = "R$ " + this.valor;
        return linha1 + "\n" + linha2 + "\n" + linha3 + "\n" + linha4;
    }
}
