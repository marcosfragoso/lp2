package cronicas;

public class CronicasDoEstudanteSistema {

    private Cronica[] cronicas = new Cronica[1000];
    private Livreto[] livretos = new Livreto[100];
    private int indice = 0;
    private int posLivreto = 0;

    public CronicasDoEstudanteSistema(){
    }

    public void cadastrarCronica(String titulo, String texto, String data, String autor) {
        if (indice < 1000) {
            Cronica cronica = new Cronica(titulo, texto, autor, data);
            this.cronicas[indice] = cronica;
            this.indice++;
        }
    }

    public void cadastrarCronica(String titulo, String texto, String data) {
        if (indice < 1000) {
            Cronica cronica = new Cronica(titulo, texto, data);
            this.cronicas[indice] = cronica;
            this.indice++;
        }
    }

    public String listarCronicas(){
        String retorno = "";
        int contador = 1;
        for (Cronica cronica : cronicas) {
            if (cronica != null) {
                retorno += "\n\ncronicas.Cronica #" + contador;
                retorno += cronica.toString();
                contador ++;
            }
        }
        return retorno;
    }

    public String lerCronica(int i) {
        this.cronicas[i].adicionaLeitura();
        return this.cronicas[i].getTexto();
    }

    public String exibirCronicaMaisLida(){
        Cronica cronicaMaior = this.cronicas[0];
        for (Cronica cronica : cronicas) {
            if (cronica != null) {
                if (cronica.getQntdLeituras() > cronicaMaior.getQntdLeituras()) {
                    cronicaMaior = cronica;
                }
            }
        }
        return cronicaMaior.getTitulo() + " - lida " + cronicaMaior.getQntdLeituras() + " vezes";
    }

    public boolean criarLivreto(int[] cronicas) {
        if (cronicas.length > 5 || cronicas.length < 3) {
            throw new IllegalArgumentException("Livretos só entre 3 a 5 crônicas.");
        }
        Livreto livreto = new Livreto(cronicas.length);
        for (int i = 0; i < cronicas.length; i++){
            livreto.getCronicas()[i] = this.cronicas[cronicas[i]];
        }
        if (this.posLivreto > 99) {
            this.posLivreto = 0;
        }
        this.livretos[posLivreto] = livreto;
        this.posLivreto++;
        return true;
    }

    public String lerLivreto(int i) {
        String retorno = "";
        for (int j = 0; j < this.livretos[i].cronicas.length; j++) {
            retorno += "\n" + this.lerCronica(j);
        }
        return retorno;
    }

    public boolean contemCronicaNoLivreto(String titulo, int i){
        for (Cronica cronica : livretos[i].cronicas) {
            if(cronica.getTitulo().equals(titulo)) {
                return true;
            }
        }
        return false;
    }

}
