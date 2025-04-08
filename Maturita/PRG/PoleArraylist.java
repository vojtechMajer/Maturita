
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Pole v jave má pevnou velikost. Jakmile ho vytvoříš, už ho nemůžeš zvětšit nebo zmenšit
        // V zásobníku je reference na pole vytvořené v haldě
        // Pole je objekt
        // můžeme do něj ukládat primitivní i refernčí datový typy

        // int[] pole = new int[] {4, 8, 2}; je to stejné jako int[] pole = {4, 8, 2};

        int[] pole = new int[3];
        pole[0] = 5;
        pole[1] = 2;
        System.out.println("Délka pole:" + pole.length); // 3
        System.out.println(pole[4]); // způsobí ArrayIndexOutOfBoundsException

        //ArrayList je nadstavba na obyčejným polem v Jave
        // Velikost arrayListu se může měnit v průběhu programu
        // je pomalejší a zabere více paměti oproti poli
        // do pole můžeme uložit pouze referenční typy (obecný datový typ <>)

        ArrayList<Integer> list = new ArrayList<>(); //
        list.add(4);  // přidáme na konec (když není prázdný)
        list.addFirst(2);  // přidat na začátek
        list.remove(2);  // odstraní podle indexu
        list.contains(4);  // vrátí true pokud v listu je číslo 4
        list.size();  // vrací délku pole
        System.out.println(list.get(1)); // vypíše druhou hodnotu

    }
}
