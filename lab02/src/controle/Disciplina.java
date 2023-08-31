package controle;


import java.util.Arrays;

/**
 * A classe representa uma disciplina.
 * Cada instância contém: nome, notas, media, e as horas de estudo dedicada a ela. E verifica se o aluno foi ou não aprovado nela.
 *
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */
public class Disciplina {

    /**
     * Nome da disciplina.
     */
    private String nome;

    /**
     * Quantidade de horas dedicada a disciplina.
     */
    private int horasEstudo;

    /**
     * Array de notas. Contém 4 notas.
     */
    private double[] notas;

    /**
     * Média aritmética calculada a partir das notas.
     */
    private double media;

    /**
     * Quantidade de notas da disciplina.
     */
    private int qntdNotas;

    /**
     * Array de pesos das notas.
     */
    private double[] pesos;

    /**
     * Construtor para criar um objeto Disciplina com o nome dela.
     * Para cada nota não cadastrada, ela é inicializada como 0.
     * A disciplina começa sem horas cadastradas.
     *
     * @param nome O nome da disciplina.
     */
    public Disciplina(String nome) {
        this.nome = nome;
        this.qntdNotas = 4;
        this.notas = new double[4];
        for(int i = 0; i < notas.length; i++){
            this.notas[i] = 0;
        }
    }

    /**
     * Construtor para criar um objeto Disciplina com o nome e a quantidade de notas.
     *
     * @param nome O nome da disciplina.
     * @param qntdNotas A quantidade de notas da disciplina.
     */
    public Disciplina(String nome, int qntdNotas) {
        this.nome = nome;
        this.qntdNotas = qntdNotas;
        this.notas = new double[qntdNotas];
        for(int i = 0; i < notas.length; i++){
            this.notas[i] = 0;
        }
    }

    /**
     * Construtor para criar um objeto Disciplina com nome, quantidade de notas e peso.
     *
     * @param nome O nome da disciplina.
     * @param qntdNotas A quantidade de notas da disciplina.
     * @param pesos O array que contém os pesos das notas da disciplina.
     */
    public Disciplina(String nome, int qntdNotas, double[] pesos) {
        this.nome = nome;
        this.qntdNotas = qntdNotas;
        this.notas = new double[qntdNotas];
        for(int i = 0; i < notas.length; i++){
            this.notas[i] = 0;
        }
        this.pesos = pesos;

    }

    /**
     * É um setter que define a média da disciplina.
     *
     * @param media
     */
    public void setMedia(double media) {
        this.media = media;
    }

    /**
     * Adiciona um determinado tempo em horas para a disciplina.
     * O método aumenta as horas de estudo cadastradas.
     *
     * @param horas Quantidade de horas a ser adicionada.
     */
    public void cadastraHoras(int horas) {
        this.horasEstudo = this.horasEstudo + horas;
    }

    /**
     * Método que cadastra o valor da nota de um aluno.
     *
     * @param nota Número de qual das 4 notas a ser atribuída o valor.
     * @param valorNota O valor da nota.
     */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }

    /**
     * Método que retorna se o aluno está aprovado de acordo com o cálculo da média das 4 notas.
     * Média maior ou igual a 7 é aprovado. Caso contrário, não.
     * O cálculo é uma média aritmética caso o array de pesos não seja passado. E caso seja passado, uma média ponderada.
     *
     * @return Boolean. Retorna "true" se tá aprovado e "false" caso contrário.
     */
    public boolean aprovado() {

        double soma = 0;
        for (int i = 0; i < this.notas.length; i ++) {
            if(this.pesos == null) {
                soma += this.notas[i];
            } else {
                soma += this.notas[i] * this.pesos[i];
            }
        }

        double media;
        if(this.pesos == null) {
            media = soma / this.qntdNotas;
        } else {
            media = soma / 10;
        }
        setMedia(media);
        if (media >= 7) {
            return true;
        }
        return false;
    }

    /**
     * Uma representação do objeto Disciplina em formato de String.
     * Contém o nome da disciplina, a quantidade de horas de estudo, a média e as notas.
     *
     * @return String que representa o objeto no formato: {nome} {horasEstudo} {media} {notas}
     */
    public String toString() {
        return nome + " " + horasEstudo + " " + media + " " + Arrays.toString(notas);
    }
}
