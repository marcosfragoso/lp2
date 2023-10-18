import java.util.ArrayList;
import java.util.Objects;

public class Anotacao {
    private int id;
    private String nomeDisciplina;
    private String data;
    private String texto;
    private String sumario;
    private ArrayList<Questao> questoes;

    public Anotacao(String nomeDisciplina, String data, String texto) {
        this.nomeDisciplina = nomeDisciplina;
        this.data = data;
        this.texto = texto;
        this.questoes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public String getData() {
        return data;
    }

    public String getSumario() {
        return sumario;
    }

    public void addSumario(String texto) {
        this.sumario = texto;
    }

    public void addQuestao(Questao questao) {
        this.questoes.add(questao);
    }

    public String exibirQuestao(int idQuestao) {
        int indice = idQuestao - 1;
        return this.questoes.get(indice).toString();
    }

    public boolean estaCorreta(int idQuestao, String resposta) {
        int indice = idQuestao - 1;
        if (this.questoes.get(indice).getGabarito().equalsIgnoreCase(resposta)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anotacao anotacao)) return false;
        return nomeDisciplina.equals(anotacao.nomeDisciplina) && data.equals(anotacao.data) && texto.equals(anotacao.texto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeDisciplina, data, texto);
    }

    @Override
    public String toString() {
        if (sumario == null) {
            return "Disciplina: " + nomeDisciplina +
                    "\nData: " + data +
                    "\nTexto: " + texto;
        }
        return "Disciplina: " + nomeDisciplina +
                "\nData: " + data +
                "\nTexto: " + texto +
                "\nSumário: " + sumario;
    }



}
