import java.util.Comparator;

public class AnotacaoComparador implements Comparator<Anotacao> {
    @Override
    public int compare(Anotacao anotacao1, Anotacao anotacao2) {
        return anotacao1.getNomeDisciplina().compareTo(anotacao2.getNomeDisciplina());
    }

}
