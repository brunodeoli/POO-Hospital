import java.util.ArrayList;
import java.util.List;

public class ListaSintomas {
    private static List<String> sintomas;

    public ListaSintomas() {
        this.sintomas = new ArrayList<>();
        //Geral
        this.sintomas.add("Gripe");
        this.sintomas.add("Febre");
        this.sintomas.add("Vomito");
        //Cirurgiao
        this.sintomas.add("Fratura");
        this.sintomas.add("Fratura exposta");
        this.sintomas.add("Corte profundo");
        //Neuro
        this.sintomas.add("Exaqueca");
        this.sintomas.add("Epilepsia");
        this.sintomas.add("Insonia");
    }

    public static List<String> getSintomas() {
        return sintomas;
    }
}
