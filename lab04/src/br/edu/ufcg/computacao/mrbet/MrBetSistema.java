package br.edu.ufcg.computacao.mrbet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Classe representando o Sistema MrBet que faz a relação com o main, ela é responsável por fazer todas as operações do sistema e toda a interação com o main.
 *
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */
public class MrBetSistema {
    /**
     * HashMap que armazena os times que recebe como chave o ID de cada time e valor o objeto Time.
     */
    private HashMap<String, Time> times;

    /**
     * HashMap que armazena os campeonatos que recebe como chave o nome do campeonato e como valor o objeto Campeonato.
     */
    private HashMap<String, Campeonato> campeonatos;

    /**
     * ArrayList que armazena todas as apostas do sistema.
     */
    private ArrayList<Aposta> apostas;

    /**
     * Construtor default (sem parâmetros) que cria uma nova instância do sistema.
     */
    public MrBetSistema() {
        this.times = new HashMap<>();
        this.campeonatos = new HashMap<>();
        this.apostas = new ArrayList<>();
    }

    /**
     * Método para incluir um time, recebendo o código do time, o nome e seu mascote.
     * Este método vai criar uma nova instância de Time, caso o time não exista.
     *
     * @param codigo O código do time.
     * @param nome O nome do time.
     * @param mascote O mascote do time.
     * @return String retornando se o time já existe ou se a inscrição foi realizada.
     */
    public String incluirTime(String codigo, String nome, String mascote) {
        if (this.times.containsKey(codigo)) {
            return "TIME JÁ EXISTE!";
        }
        times.put(codigo, new Time(codigo, nome, mascote));
        return "INCLUSÃO REALIZADA!";
    }

    /**
     * Método para recuperar um time do sistema, caso o time exista.
     *
     * @param codigo O código do time que deseja recuperar.
     * @return Uma String retornando o toString do Time ou uma mensagem dizendo que o time não existe.
     */
    public String recuperarTime(String codigo) {
        if (this.times.containsKey(codigo)) {
            return times.get(codigo).toString();
        } else {
            throw new IllegalArgumentException("O TIME NÃO EXISTE!");
        }
    }

    /**
     * Método para adicionar um campeonato no sistema, recebendo o nome e a quantidade máxima de participantes.
     * Este método vai criar uma nova instância de campeonato e vai adicionar ao sistema, caso o campeonato não exista ainda no sistema.
     *
     * @param nome O nome do campeonato.
     * @param participantes O número de participantes.
     * @return Uma String dizendo se o campeonato foi adicionado ou se o campeonato já existe.
     */
    public String adicionarCampeonato(String nome, int participantes) {
        for (String chave : this.campeonatos.keySet()) {
            if (chave.equalsIgnoreCase(nome)) {
                return "CAMPEONATO JÁ EXISTE!";
            }
        }
        campeonatos.put(nome, new Campeonato(participantes, nome));
        return "CAMPEONATO ADICIONADO!";
    }

    /**
     * Método para incluir um time em um determinado campeonato através do nome do campeonato e do código do time.
     *
     * @param codigo O código do time a ser inserido.
     * @param campeonato O campeonato que deseja incluir o time.
     * @return Uma String representando se o time foi incluído no campeonato, se o time já está incluso, se já excedeu o limite de times, se o campeonato não existe ou se o time não existe.
     */
    public String incluirTimeEmCampeonato(String codigo, String campeonato) {
        if (this.times.containsKey(codigo)) {
            boolean temCampeonato = false;
            for (String chave : this.campeonatos.keySet()) {
                if (chave.equalsIgnoreCase(campeonato)) {
                    campeonato = chave;
                    temCampeonato = true;
                }
            }
            if (!temCampeonato) {
                throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
            }

            Campeonato c = this.campeonatos.get(campeonato);
            Time time = this.times.get(codigo);

            boolean foiIncluido = c.incluirTime(time);
            if (foiIncluido) {
                time.adicionaCampeonato(c);
                return "TIME INCLUÍDO NO CAMPEONATO!";
            } else {
                return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
            }

        }
        else {
            throw new IllegalArgumentException("O TIME NÃO EXISTE!");
        }
    }

    /**
     * Método para verificar se o time está no campeonato através do código do time e do nome do campeonato.
     *
     * @param codigo O código do time que deseja verificar.
     * @param campeonato O nome do campeonato que deseja verificar.
     * @return Uma String dizendo se o time está no campeonato, se não está no campeonato, se o campeonato não existe, ou se o time não existe.
     */
    public String verificaTimeEmCampeonato(String codigo, String campeonato){
        if (this.times.containsKey(codigo)) {
            boolean temCampeonato = false;
            for (String chave : this.campeonatos.keySet()) {
                if (chave.equalsIgnoreCase(campeonato)) {
                    campeonato = chave;
                    temCampeonato = true;
                }
            }
            if (!temCampeonato) {
                throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
            }

            Campeonato c = this.campeonatos.get(campeonato);
            Time time = this.times.get(codigo);
            boolean temTime = c.verificaTime(time);
            if (temTime) {
                return "O TIME ESTÁ NO CAMPEONATO";
            } else {
                return "O TIME NÃO ESTÁ NO CAMPEONATO";
            }
        } else {
            throw new IllegalArgumentException("O TIME NÃO EXISTE!");
        }
    }

    /**
     * Método para exibir a lista de todos os campeonatos que o time participa através do código do time.
     *
     * @param codigo O código do time.
     * @return Retorna a lista de campeonatos que o time participa, a quantidade de máxima de participantes e os de inscritos de cada campeonato.
     */
    public String exibirCampeonatosQueOTimeParticipa(String codigo) {
        if (this.times.containsKey(codigo)) {
            Time time = this.times.get(codigo);
            String retorno = "Campeonatos do " + time.getNome() + ":";

            for (Campeonato campeonato : this.campeonatos.values()) {
                if (campeonato.verificaTime(time)) {
                    retorno += "\n* " + campeonato.toString();
                }
            }

            return retorno;
        } else {
            throw new IllegalArgumentException("O TIME NÃO EXISTE!");
        }
    }

    /**
     * Método de adicionar uma aposta no sistema se o campeonato existir, o time também e a colocação não for maior que o limite máximo de participantes.
     *
     * @param codigo O código do time em que deseja apostar.
     * @param campeonato O nome do campeonato em que deseja apostar.
     * @param colocacao A colocação do time que você deseja apostar (lembrando que tem que ser menor ou igual ao número máximo de participantes do campeonato).
     * @param valor O valor da aposta
     * @return Uma String relatando se a aposta foi registrada, se não foi registrada, se o campeonato não existe ou se o time não existe.
     */
    public String adicionarAposta(String codigo, String campeonato, int colocacao, double valor) {
        if (this.times.containsKey(codigo)) {
            Time time = this.times.get(codigo);
            boolean temCampeonato = false;
            for (String chave : this.campeonatos.keySet()) {
                if (chave.equalsIgnoreCase(campeonato)) {
                    campeonato = chave;
                    temCampeonato = true;
                }
            }
            if (!temCampeonato) {
                throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
            }
            Campeonato c = this.campeonatos.get(campeonato);
            if (colocacao > c.getParticipantes()) {
                return "APOSTA NÃO REGISTRADA!";
            }
            this.apostas.add(new Aposta(time, c, colocacao, valor));
            return "APOSTA REGISTRADA";
        } else {
            throw new IllegalArgumentException("O TIME NÃO EXISTE!");
        }
    }

    /**
     * Método que mostra o status de todas as apostas do sistema.
     *
     * @return Uma String contendo os dados de todas as apostas cadastradas do sistema.
     */
    public String statusApostas() {
        StringBuilder retorno = new StringBuilder();
        int indice = 1;
        for (Aposta aposta : this.apostas) {
            retorno.append("\n").append(indice).append(". ").append(aposta.toString());
            indice++;
        }
        return retorno.toString();
    }

    /**
     * Método que retorna os times com mais participações em campeonatos.
     * Em caso de empate, mostra os times e a quantidade de aparições.
     *
     * @return O time que mais apareceu, ou os times em caso de empate.
     */
    public String timeMaisIncluido() {
        int maxCamp = 0;
        for (Time time : this.times.values()) {
            if (time.quantidadeCampeonatos() >= maxCamp) {
                maxCamp = time.quantidadeCampeonatos();
            }
        }

        ArrayList<Time> timesMaisFrequentes = new ArrayList<>();
        for (Time time : this.times.values()) {
            if (time.quantidadeCampeonatos() == maxCamp) {
                timesMaisFrequentes.add(time);
            }
        }

        if (timesMaisFrequentes.size() > 1) {
            StringBuilder retorno = new StringBuilder("Participação mais frequente em campeonatos\n");
            for (Time time : timesMaisFrequentes) {
                retorno.append(time.toString()).append(" - ").append(maxCamp).append("\n");
            }
            return retorno.toString();
        } else {
            return "Participação mais frequente em campeonatos\n" + timesMaisFrequentes.get(0).toString();
        }
    }

    /**
     * Retorna todos os times que não participaram ainda de nenhum campeonato.
     *
     * @return Todos os times que não participaram
     */
    public String timesQueNaoParticiparam() {
        ArrayList<Time> naoParticiparam = new ArrayList<>();
        for (Time time : this.times.values()) {
            if (time.quantidadeCampeonatos() == 0) {
                naoParticiparam.add(time);
            }
        }

        StringBuilder retorno = new StringBuilder("Ainda não participou de campeonato\n");
        for (Time time : naoParticiparam) {
            retorno.append(time.toString()).append("\n");
        }
        return retorno.toString();
    }

    /**
     * Mostra todos os times que apareceram em 1º lugar na colocação das apostas, e a quantidade de vezes que o mesmo apareceu.
     *
     * @return O nome do time e a quantidade de aparições.
     */
    public String primeiroNasApostas() {
        ArrayList<Time> primeirosRepetidos = new ArrayList<>();
        HashSet<Time> primeiros = new HashSet<>();

        for (Aposta aposta : this.apostas) {
            if (aposta.getColocacao() == 1) {
                primeirosRepetidos.add(aposta.getTime());
                primeiros.add(aposta.getTime());
            }
        }

        StringBuilder retorno = new StringBuilder("Popularidade em apostas\n");
        for (Time time : primeiros) {
            String aparicoes = String.valueOf(quantidadeAparicoesTime(time, primeirosRepetidos));
            retorno.append(time.getNome()).append(" / ").append(aparicoes).append("\n");
        }

        return retorno.toString();
    }

    /**
     * Método auxiliar para verificar a quantidade de aparições do time no ArrayList de times do método primeiroNasApostas
     *
     * @param time O time que deseja verificar
     * @param times O ArrayList dos times
     * @return retorna um inteiro representando a quantidade de aparições.
     */
    private int quantidadeAparicoesTime(Time time, ArrayList<Time> times) {
        int contador = 0;
        for (Time t : times) {
            if (t.equals(time)) {
                contador++;
            }
        }
        return contador;
    }
}
