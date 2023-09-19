package agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representação de um Contato da Agenda que mantém nome, sobrenome e telefone.
 *
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */
public class Contato {
    /**
     * Armazena o nome do contato.
     */
    private String nome;

    /**
     * Armazena o sobrenome do contato.
     */
    private String sobrenome;

    /**
     * Armazena o número do telefone do contato.
     */
    private String telefone;

    /**
     * Armazena as tags do contato.
     */
    private List<String> tags;

    /**
     * Armazena um boolean para saber se o usuário é favorito.
     */
    private boolean isFavorito;

    /**
     * Construtor que cria uma nova instância de Contato.
     * O contato já vem pré determinado como não sendo um favorito.
     * O contato não pode receber nenhum atributo nulo ou vazio.
     *
     * @param nome O nome do contato.
     * @param sobrenome O sobrenome do contato.
     * @param telefone O telefone do contato.
     */
    public Contato(String nome, String sobrenome, String telefone) {
        if (nome == null) { throw new NullPointerException("Erro: Nome nulo!"); }
        if (sobrenome == null) { throw new NullPointerException("Erro: Sobrenome nulo!"); }
        if (telefone == null) { throw new NullPointerException("Erro: Telefone nulo!"); }
        if (nome.trim().isEmpty()) { throw new IllegalArgumentException("Erro: Nome vazio!"); }
        if (sobrenome.trim().isEmpty()) { throw new IllegalArgumentException("Erro: Sobrenome vazio!"); }
        if (telefone.trim().isEmpty()) { throw new IllegalArgumentException("Erro: Telefone vazio!"); }

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.isFavorito = false;
        this.tags = new ArrayList<>();
    }

    /**
     * Um getter para identificar se um contato é favorito.
     *
     * @return Boolean representando se o contato é favorito.
     */
    public boolean isFavorito() {
        return isFavorito;
    }

    /**
     * Um setter para alterar o status de favorito do contato
     *
     * @param favorito O valor representando se é favorito. true = favorito. false = não favorito.
     */
    public void setFavorito(boolean favorito) {
        isFavorito = favorito;
    }

    /**
     * Um getter do nome do contato.
     *
     * @return O nome do contato.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Um getter do sobrenome do contato.
     *
     * @return O sobrenome do contato.
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Um getter do telefone do contato.
     *
     * @return O telefone do contato.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Um getter de todas as tags do contato.
     *
     * @return Um array list de todas as tags do contato.
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * Método setter para alterar o número do telefone.
     *
     * @param telefone O novo número do telefone do contato.
     */
    public void setTelefone(String telefone) {
        if (telefone == null) { throw new NullPointerException("ERRO: Telefone nulo!");}
        if (telefone.trim().isEmpty()) { throw new IllegalArgumentException("ERRO: Telefone vazio!");}
        this.telefone = telefone;
    }

    /**
     * Método básico equals que compara se este contato é igual ao objeto passado.
     *
     * @param o Objeto a ser comparado com o contato.
     * @return true se o objeto for igual ao contato, false se não for.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) && Objects.equals(sobrenome, contato.sobrenome);
    }

    /**
     * Getter que retorna o nome completo do contato.
     * @return O nome completo, incluindo nome e sobrenome. E um coração em caso de favorito.
     */
    public String getNomeCompleto() {
        if (!isFavorito()) {
            return this.nome + " " + this.sobrenome;
        } else {
            return "❤️ " + this.nome + " " + this.sobrenome;
        }
    }

    /**
     * Método básico hashCode que é uma representação em hash code para o contato.
     * @return O valor hash code para o contato.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome);
    }

    /**
     * Método toString que é uma representação em String do contato, contendo todas as informações.
     *
     * @return Nome completo, incluindo nome e sobrenome. Telefone e em caso de favorito um coração.
     */
    @Override
    public String toString() {
        return getNomeCompleto() + "\n" + getTelefone();
    }

    /**
     * Adiciona a tag em um determinado contato de acordo com a posição passada.
     * Só é permitido 5 tags por contato.
     *
     * @param tag A tag que deseja adicionar no contato.
     * @return String representando se a tag foi adicionada ou se o usuário estourou o limite de tags.
     */
    public String adicionarTag(String tag) {

        if (this.getTags().size() < 5) {
            this.getTags().add(tag);
            return "Tag adicionada com sucesso!";
        }
        return "Contato já possui 5 tags!";
    }
}
