package controle;


import java.util.ArrayList;
import java.util.Collections;

/**
 * A classe representa um registro de resumos dos estudos realizados ao longo do período.
 * Cada instância desta classe contém uma quantidade limitada de resumos e os resumos.
 *
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */
public class RegistroResumos {

    /**
     * Quantidade de resumos que o registro pode ter.
     */
    private int numeroDeResumos;

    /**
     * Array da classe Resumo que contém o tema e o conteúdo.
     */
    private Resumo[] resumos;

    /**
     * Variável para controlar a ordem do resumo a ser inserido.
     */
    private int indice;

    /**
     * Construtor para criar um objeto de RegistroResumos com a quantidade de resumos.
     * De acordo com a quantidade de resumos, um array de Resumo.
     * Indice começa em zero, visto que não foi inserido nenhum resumo ainda.
     *
     * @param numeroDeResumos Quantidade limitada de resumos que o registro pode ter.
     */
    public RegistroResumos(int numeroDeResumos) {
        this.numeroDeResumos = numeroDeResumos;
        this.resumos = new Resumo[numeroDeResumos];
        this.indice = 0;
        for (int i = 0; i < numeroDeResumos; i++) {
            this.resumos[i] = new Resumo();
        }
    }

    /**
     * Método que adiciona um resumo aos registros.
     * Primeiro verifica se atingiu o limite, pois se atingiu o primeiro resumo é substituido. Por isso o indíce retorna a 0.
     * Em seguida, adiciona o tema concatenado com o resumo no array de resumos.
     * Depois disso, adiciona apenas o tema na lista de temas.
     * E por fim, incrementa o índice para a próxima inserção de resumo.
     *
     * @param tema Tema do resumo.
     * @param resumo Tema e conteúdo do resumo.
     */
    public void adiciona(String tema, String resumo) {
        if (indice >= numeroDeResumos) {
            this.indice = 0;
        }
        this.resumos[this.indice].tema = tema;
        this.resumos[this.indice].conteudo = tema + ": " + resumo;
        this.indice ++;
    }

    /**
     * É um getter que obtém a lista de resumos.
     *
     * @return Array de strings contendo os resumos.
     */
    public String[] pegaResumos() {
        ArrayList<String> conteudos = new ArrayList<>();
        for (int i = 0; i < resumos.length; i++) {
            conteudos.add(resumos[i].conteudo);
        }
        return conteudos.toArray(new String[conteudos.size()]);
    }

    /**
     * Método que imprime a quantidade de resumos cadastrados.
     * Imprime também os temas dos resumos cadastrados.
     *
     * @return retorna uma string com a quantidade de resumos cadastrados e os temas deles.
     */
    public String imprimeResumos(){
        String primeiraLinha = "- " + this.conta() + " resumo(s) cadastrado(s)";
        String segundaLinha = "- ";

        for (int i = 0; i < this.conta(); i++){
            if(i == this.conta() - 1){
                segundaLinha += resumos[i].tema;
            } else {
                segundaLinha += resumos[i].tema + " | ";
            }
        }

        return primeiraLinha + "\n" + segundaLinha;
    }

    /**
     * Método que conta quantos resumos têm cadastrados no registro.
     *
     * @return retorna o número de resumos cadastrados no tipo inteiro.
     */
    public int conta(){
        int contador = 0;
        for (int i = 0; i < resumos.length; i++) {
            if (resumos[i].conteudo != null){
                contador++;
            }
        }
        return contador;
    }

    /**
     * Método que retorna se tem ou não um determinado resumo de acordo com o tema.
     *
     * @param tema Tema a ser verificado se existe na lista de resumos.
     * @return Boolean resultando se contém ou não o tema. Tem = "true". Não tem = "false".
     */
    public boolean temResumo(String tema) {
        for (Resumo resumo : resumos) {
            if (tema.equals(resumo.tema)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que retorna um array ordenado de temas que contém a chave de busca passada no resumo.
     *
     * @param chaveDeBusca A chave de busca que deseja procurar nos resumos.
     * @return O array contendo todos os temas que a chave de busca aparece no resumo.
     */
    public String[] busca(String chaveDeBusca){
        ArrayList<String> temasEncontrados = new ArrayList<>();

        for (int i = 0; i < resumos.length; i++) {
            if(resumos[i].conteudo != null && resumos[i].conteudo.toLowerCase().contains(chaveDeBusca.toLowerCase())){
                temasEncontrados.add(resumos[i].tema);
            }
        }
        Collections.sort(temasEncontrados);
        String[] temasEncotnradosArray = temasEncontrados.toArray(new String[temasEncontrados.size()]);
        return temasEncotnradosArray;
    }

    /**
     * Representação de um resumo onde contém tema e conteúdo.
     * Esta classe segue o esquema de composição.
     * Ela é a parte do RegistroResumos.
     *
     */
    public class Resumo {
        /**
         * Tema do resumo
         */
        private String tema;
        /**
         * Conteúdo do resumo
         */
        private String conteudo;

        /**
         * Construtor default do Resumo
         */
        public Resumo(){

        }
    }
}
