import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CornO{
    private ArrayList<Anotacao> anotacoes;

    public CornO() {
        this.anotacoes = new ArrayList<>();
    }

    public int cadastrarAnotacao(String nomeDisciplina, String data, String texto) {
        if (nomeDisciplina.isEmpty()) {
            throw new IllegalArgumentException("Nome de disciplina vazio!");
        }
        Anotacao anotacao = new Anotacao(nomeDisciplina, data, texto);
        anotacoes.add(anotacao);
        int id = this.anotacoes.indexOf(anotacao) + 1;
        anotacao.setId(id);
        return id;
    }

    public void definirSumario(int idAnotacao, String texto) {
        int indice = idAnotacao - 1;
        if (indice >= 0 && indice < this.anotacoes.size()) {
            this.anotacoes.get(indice).addSumario(texto);
        } else {
            throw new IllegalArgumentException("Anotação inexistente!");
        }
    }

    public String exibirAnotacao(int idAnotacao) {
        int indice = idAnotacao - 1;
        if (indice >= 0 && indice < this.anotacoes.size()) {
            return this.anotacoes.get(indice).toString();
        } else {
            throw new IllegalArgumentException("Anotação inexistente!");
        }
    }

    public void cadastrarQuestaoMultipla(int idAnotacao, String enunciado, String[] alternativas, int prioridade, String gabarito) {
        int indice = idAnotacao - 1;
        if (alternativas.length < 2 || alternativas.length > 5) {
            throw new IllegalArgumentException("Número de alternativas inválido.");
        }
        if (indice >= 0 && indice < this.anotacoes.size()) {
            QuestaoMultiplaEscolha questao = new QuestaoMultiplaEscolha(enunciado, prioridade,gabarito, alternativas);
            this.anotacoes.get(indice).addQuestao(questao);
        } else {
            throw new IllegalArgumentException("Anotação inexistente!");
        }
    }

    public void cadastrarQuestaoAberta(int idAnotacao, String enunciado, int prioridade, String gabarito) {
        int indice = idAnotacao - 1;
        if (indice >= 0 && indice < this.anotacoes.size()) {
            QuestaoAberta questao = new QuestaoAberta(enunciado, prioridade,gabarito);
            this.anotacoes.get(indice).addQuestao(questao);
        } else {
            throw new IllegalArgumentException("Anotação inexistente!");
        }
    }

    public String exibirQuestao(int idAnotacao, int ordemQuestao) {
        int indice = idAnotacao - 1;
        if (indice >= 0 && indice < this.anotacoes.size()) {
            return this.anotacoes.get(indice).exibirQuestao(ordemQuestao);
        } else {
            throw new IllegalArgumentException("Anotação inexistente!");
        }
    }

    public boolean responderQuestao(int idAnotacao, int ordemQuestao, String resposta) {
        int indice = idAnotacao - 1;
        if (indice >= 0 && indice < this.anotacoes.size()) {
            return this.anotacoes.get(indice).estaCorreta(ordemQuestao, resposta);
        } else {
            throw new IllegalArgumentException("Anotação inexistente!");
        }
    }

    public String listarAnotacoes() {
        this.anotacoes.sort(Comparator.comparing(Anotacao::getNomeDisciplina).thenComparing(Anotacao::getId));
        String retorno = "";
        for (Anotacao anotacao : this.anotacoes) {
            retorno += "\n" + anotacao.getId() + " - " +
                    anotacao.getNomeDisciplina() + " - " + anotacao.getData() + " - Sumário: " + anotacao.getSumario();
        }
        return retorno;

    }
}
