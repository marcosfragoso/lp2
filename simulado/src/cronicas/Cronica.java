package cronicas;

import java.util.Objects;

public class Cronica {
    private String titulo;
    private String texto;
    private String autor;
    private String dataCriacao;
    private int qntdLeituras;

    public Cronica(String titulo, String texto, String dataCriacao) {
        this.titulo = titulo;
        this.texto = texto;
        this.dataCriacao = dataCriacao;
        this.autor = "Anônimo";
    }

    public Cronica(String titulo, String texto, String autor, String dataCriacao) {
        this.titulo = titulo;
        this.texto = texto;
        this.autor = autor;
        this.dataCriacao = dataCriacao;
    }

    public String getTexto() {
        return texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getQntdLeituras() {
        return qntdLeituras;
    }

    public void adicionaLeitura() {
        this.qntdLeituras++;
    }

    @Override
    public String toString() {
        String retorno = "\n" + this.titulo + "\nData: " + this.dataCriacao +
                "\nAutor: " + autor + "\n" + texto;
        return retorno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cronica cronica)) return false;
        return titulo.equals(cronica.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
