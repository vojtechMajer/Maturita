#  Základy objektově orientovaného programování, třídy a objekty (Java)

## Vysvětlení pojmu
OOP - způsob programování (životní styl), který strukturuje data a procedury (metody/operace) do tříd
- Třída
  - Konstruktor
    - Implicitní(Defaultní), Kopírovací, Inicializační, Vlastní(udělat cokoliv navíc) 
  - Objekt
  - Metoda
    - Přetížení metody
  - Vlastnosti(Properties)
- Pilíře OOP
  - Zapouzdření (gettery, settery, private...)
  - Polymorfismus(rozhraní, abstraktní třídy)
  - Dědičnost(rodič a potomek třídy)
  - 
## Třída 
je teda seskupení dat a operací, které spolu dávají smysl, například třída člověk bude mít operaci běh mluv ... další nesmysly a data jako jméno výška ...
třída určuje co bude každá instance mít za data(atributy), a metody 
```JAVA
public class Automobil
{
  //STATICKÉ ATRIBUTY
  private static int _pocetAutomobilu;
  //ATRIBUTY
  private String _nazev;
  private Barva _barva;
  
  //KONSTRUKTOR
  public Automobil(String nazev, Barva barva)
  {
    _nazev = nazev;
    _barva = barva;
  }
  //GETTERY A SETTERY

  //METODY
}

```

## Objekt
je **instance třídy** - 
je vytvořen ze třídy se specifickými daty pro danou instanci (kdyby byla třída auto,, tak instance je Škoda Fábia, pistáciová, 50l, ...)
tvoříme klíčovým slovem **new()**, která volá **konstruktor** třídy a alokuje místo pro atributy a metody objektu
```JAVA
Automobil auto = new Automobil("Škoda Fabia", Barva.Pistáciová, 50);
``` 


Instance se vytváří pomocí klíčového slova new, které alokuje pamět pro objekt, protože objekty jsou referenční datové typy
více v referenčních datových typech [[Datové Typy]]


## Zapouzdření
způsob jak zabezpečit data 
"znepřístupnění" dat mimo třídu, ke kterým by uživatel neměl mít přístup
- **gettery** - metody pro vracení hodnoty atributu
- **settery** - nastavení hodnoty atributu

### Modifikátory přístupu(access modifiers)
- private - přístupné jen v rámci třídy, kde byl atribut vytvořen
- protected - přístupné jen pro potomky
- public - přístupná pro všechny
dáváme přístup k věcem, jen u těch u kterých je to nutné


Dědičnost
potomek - třída, která dědí  z nadřazené třídy
dědí se atributy a metody 

polymorfismus 

classa zvíře, každé zvíře dělá nějaký zvuk, ale jiný polymorfismus nám umožnuje zavolat metodu specifickou pro dané zvíře (chro pro prase)

nadřazená třída určí metodu (případně určí defaultní chování), a je na každém objektu jakým způsobem bude implementován v případě prasete to bude sout("chro") u kocky třeba sout(kňá) ....


abstraktní třída

je třída, pro kterou nedává smysl vytvářet z ní objekt

například vozdilo, mohlo by to být letadlo auto, kamion(tyhle třídy by dědily z třídy vozidlo), všechno s jinými parametry, ale stejným základem (kapacita lidí, metoda pohyb bla bla)


interfacy v podstatě umožnuje inheritova více tříd
