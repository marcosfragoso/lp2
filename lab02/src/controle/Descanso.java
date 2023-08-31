package controle;

/**
 * A classe Descanso representa uma rotina de descanso de um aluno para identificar se o mesmo está ou não cansada.
 * Cada instância desta classe mantém informações sobre a quantidade de horas de descanso e a quantidade de semanas.
 *
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */
public class Descanso {

    /**
     * Quantidade de horas que o aluno descansou.
     */
    private int horas;

    /**
     * Quantidade de semanas que foi feito o descanso.
     */
    private int qntdSemanas;


    /**
     * Construtor default para criar um objeto Descanso.
     * O aluno começa cansado, ou seja, 0 horas de descanso em 0 semanas.
     */
    public Descanso(){
        this.qntdSemanas = 0;
        this.horas = 0;
    }

    /**
     * Um setter que define a quantidade de horas de descanso do aluno.
     *
     * @param horas Quantidade de horas de descanso do aluno em inteiro.
     */
    public void defineHorasDescanso(int horas) {
        this.horas = horas;
    }

    /**
     * Um setter que define a quantidade de semanas que foi feito o descanso do aluno.
     *
     * @param qntdSemanas Quantidde de semanas de descanso do aluno em inteiro.
     */
    public void defineNumeroSemanas(int qntdSemanas) {
        this.qntdSemanas = qntdSemanas;
    }

    /**
     * Retorna o status geral do aluno, ou seja, se ele está ou não cansado.
     * Se o aluno descansou 26 horas por semana ou mais, ele está descansado. Caso contrário, está cansado.
     * O aluno começa cansado.
     *
     * @return Retorna uma String mostrando o status do aluno: "cansado" ou "descansado".
     */
    public String getStatusGeral(){
        if (this.qntdSemanas > 0) {
            if (this.horas / this.qntdSemanas >= 26) {
                return "descansado";
            }
            return "cansado";
        }
        return "cansado";
    }
}
