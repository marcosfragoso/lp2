package br.edu.ufcg.computacao.mrbet;

import java.util.ArrayList;
import java.util.Objects;


/**
 * Representação de um Time onde nele está armazenado o id do time, o nome do time e seu mascote.
 *
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */
public class Time {
    /**
     * O id do time, onde vai ser o identificador único do objeto.
     */
    private String id;

    /**
     * O nome do time.
     */
    private String nome;

    /**
     * O mascote do time.
     */
    private String mascote;

    /**
     * Lista dos campeonatos em que o time participa.
     */
    private ArrayList<Campeonato> campeonatos;

    /**
     * Construtor que cria uma nova instância de Time recebendo o id, nome e o seu mascote. Além de inicializar o ArrayList de campeonatos.
     *
     * @param id O id do time.
     * @param nome O nome do time.
     * @param mascote O mascote do time.
     */
    public Time(String id, String nome, String mascote) {
        this.id = id;
        this.nome = nome;
        this.mascote = mascote;
        this.campeonatos = new ArrayList<>();
    }

    /**
     * Método get que acessa o id do time.
     *
     * @return O id do time.
     */
    public String getId() {
        return id;
    }

    /**
     * Método get que retorna o nome do time.
     *
     * @return O nome do time.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método get que retorna o mascote do time.
     *
     * @return O mascote do time.
     */
    public String getMascote() {
        return mascote;
    }

    /**
     * Método básico equals que compara se dois objetos são iguais, neste caso são iguais se os dois objetos tiverem o mesmo id.
     *
     * @param o O objeto a ser comparado.
     * @return Um booleano representando se são iguais ou não.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time time)) return false;
        return id.equals(time.id);
    }

    /**
     * Método báscio hashCode que é uma representação do objeto em formato de inteiro.
     *
     * @return O inteiro que representa o objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Método para adicionar um campeonato na lista de campeonatos em que o time participa.
     *
     * @param campeonato O objeto Campeonato.
     */
    public void adicionaCampeonato(Campeonato campeonato) {
        this.campeonatos.add(campeonato);
    }

    /**
     * Método para verificar a quantidade de campeonatos que o time participa.
     *
     * @return A quantidade de campeonatos.
     */
    public int quantidadeCampeonatos(){
        return this.campeonatos.size();
    }

    /**
     * Método básico toString que é uma representação do objeto em forma de String.
     *
     * @return O id do time, o nome do time e o seu mascote.
     */
    @Override
    public String toString() {
        return "[" + this.id + "] " + this.nome + " / " + this.mascote;
    }
}
