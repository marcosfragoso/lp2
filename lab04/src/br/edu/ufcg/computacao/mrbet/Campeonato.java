package br.edu.ufcg.computacao.mrbet;

import java.util.HashSet;
import java.util.Objects;

/**
 * Representação de um Campeonato onde nele contém os times inscritos, o nome do campeonato e quantidade de participantes.
 *
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */
public class Campeonato {
    /**
     * Set para armazenar os times, a opção do Set é porque não é possível o mesmo time ser inscrito duas vezes no mesmo campeonato.
     */
    private HashSet<Time> times;

    /**
     * A quantidade máxima de participantes do campeonato.
     */
    private int participantes;

    /**
     * O nome do campeonato, este atributo é o identificador único.
     */
    private String nome;

    /**
     * Construtor para instanciar um campeonato que recebe a quantidade máxima de participantes e o nome.
     *
     * @param participantes A quantidade máxima de participantes do campeonato.
     * @param nome O nome do campeonato.
     */
    public Campeonato(int participantes, String nome) {
        this.participantes = participantes;
        this.nome = nome;
        this.times = new HashSet<>();
    }

    /**
     * Método get para acessar a quantidade máxima de participantes.
     *
     * @return A quantidade máxima de participantes.
     */
    public int getParticipantes() {
        return participantes;
    }


    /**
     * Método get para acessar o nome do campeonato.
     *
     * @return O nome do campeonato.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método para incluir um time no campeonato, e verificar se o mesmo foi incluso ou não.
     *
     * @param time O time a ser inscrito.
     * @return Um boolean retornando se um time foi inscrito. (true = inscrito, false = não inscrito)
     */
    public boolean incluirTime(Time time) {
        if (this.times.size() == this.participantes) {
            return false;
        }
        return this.times.add(time);
    }

    /**
     * Método para verificar se um time está presente no campeonato.
     *
     * @param time O time que deseja verificar.
     * @return Um boolean. (true = o time está no campeonato, false = o time não está).
     */
    public boolean verificaTime(Time time) {
        return this.times.contains(time);
    }

    /**
     * Método básico equals que compara dois objetos e retorna se são iguais. Para serem iguais precisam ter o mesmo nome, independente de letras maiúsculas e minúsculas.
     *
     * @param o O objeto que deseja comparar
     * @return Valor booleando retornando se são iguais ou não.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campeonato that)) return false;
        return nome.equalsIgnoreCase(that.nome);
    }

    /**
     * Método básico hashCode que retorna uma representação em forma de inteiro do objeto.
     *
     * @return Um inteiro representando o objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    /**
     * Método básico toString, que é uma representação do objeto em forma de String que retorna o nome do campeonato, a quantidade de inscritos e a quantidade máxima de participantes.
     *
     * @return O nome do campeonato, a quantidade de inscritos e a quantidade máxima de participantes.
     */
    @Override
    public String toString() {
        return this.nome + " - " + this.times.size() + "/" + this.participantes;
    }
}
