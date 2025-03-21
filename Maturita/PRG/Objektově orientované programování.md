#  Základy objektově orientovaného programování, třídy a objekty (Java)

## Vysvětlení pojmu
OOP - způsob programování (životní styl), který strukturuje data a procedury (metody/operace) do tříd
- Třída
  - Konstruktor
    - Implicitní(Defaultní), Explicitní, Kopírovací, Inicializační, Vlastní(udělat cokoliv navíc) 
  - Objekt
  - Metoda
    - Přetížení metody
  - Vlastnosti(Properties)
- Pilíře OOP
  - Zapouzdření(gettery, settery, private...)
  - Polymorfismus(rozhraní, abstraktní třídy)
  - Dědičnost(rodič a potomek třídy)
## Třída 
je teda seskupení dat a operací, které spolu dávají smysl, například třída člověk bude mít operaci běh mluv ... další nesmysly a data jako jméno výška ...
třída určuje co bude každá instance mít za data(atributy), a metody 
```JAVA
public class Automobil
{
  //STATICKÉ ATRIBUTY
  private static int _pocetAutomobilu;
  //ATRIBUTY
  private String nazev;
  private Barva barva;
  
  //KONSTRUKTOR
  public Automobil(String nazev, Barva barva)
  {
    this.nazev = nazev;
    this.barva = barva;
  }
  //GETTERY A SETTERY

  //METODY
}

```
## Konstuktor
je **metodou** třídy která je používána k inicializaci objektu při jeho vytváření.
máme 5 základních druhů:
### Implicitní (nebo také "Defaultní")
  - Nemusí být definován ručně, po vytvoření třídy již existuje.
  - Nemá žádné parametry.
  - Jeho funkcí je inicializovat objekt výchozími hodnotami(jednoduché datové typy - 0, referenční - null).
  - Volá konstruktor nadřazené třídy (pokud žádný konstruktor nadřazené třídy není definován, použije se konstruktor bez parametrů z třídy Object). //**toto je gpťácký bod pozor**
  - Pokud je již vytvořen jiný konstruktor (bez parametrů) implicitní konstuktor není k dispozici.
### Explicitní
  - Konstruktor bez parametrů, který je definován přímo programátorem.
  ```JAVA
   public Automobil() {
        this.nazev = "Lada Niva";
        this.barva = Barva.Zelená;
    }
  ```
### Kopírovací
  - Slouží k vytvoření kopie již existujícího objektu stejné třídy.
  - Obvykle má jede argument a to objekt stejné třídy.
  ```JAVA
  public Automobil(Automobil jineAuto) {
        this.nazev = jineAuto.nazev;
        this.barva = jineAuto.barva;
    }
  ```
- ### Inicializační
   - umožňuje inicializovat objekt s konkrétními hodnotami, které jsou předány jako argumenty při vytváření objektu. Tento konstruktor je definován programátorem a přijímá parametry, které se používají pro nastavení hodnot instančních proměnných.
   ```JAVA
   public Automobil(String nazev, Barva barva) {
        this.nazev = nazev;
        this.barva = barva;
    }
  ```
## Objekt
je **instance třídy** - 
je vytvořen ze třídy se specifickými daty pro danou instanci (kdyby byla třída auto,, tak instance je Škoda Fábia, pistáciová, 50l, ...)
tvoříme klíčovým slovem **new()**, které alokuje pamět pro objekt a také volá **konstruktor** třídy a alokuje místo pro atributy a metody objektu
```JAVA
Automobil auto = new Automobil("Škoda Fabia", Barva.Pistáciová, 50);
```

## Pilíře OOP

### Klíčová slova
**final**
- final class - nelze dále dědit
-  final method - metody nelze dále přepisovat/předefinovat(override)
-  final variable - konstantní proměnná
**extends** - 
**implements** -
## Zapouzdření
způsob jak zabezpečit data 
"znepřístupnění" dat mimo třídu, ukterých dává smysl že k nim uživatel nemá přístup
- **gettery** - metody pro vracení hodnoty atributu
- **settery** - nastavení hodnoty atributu

### Modifikátory přístupu(access modifiers)
- private - přístupné jen v rámci třídy, kde byl atribut vytvořen
- protected - přístupné jen pro potomky
- public - přístupná pro všechny
dáváme přístup k věcem, jen u těch u kterých je to nutné

## Dědičnost
Vztah mezi rodičem(nadřazená třída) a potomkem(podřazená třída).
Potomek ze svého rodiče dědí metody a atributy
Třída může mít **maximálně jednoho** rodiče, ale potomků může mít podle potřeby
dědičnost je zajištěna klíčovým slovem extends
polymorfismus

classa zvíře, každé zvíře dělá nějaký zvuk, ale jiný polymorfismus nám umožnuje zavolat metodu specifickou pro dané zvíře (chro pro prase)

nadřazená třída určí metodu (případně určí defaultní chování), a je na každém objektu jakým způsobem bude implementován v případě prasete to bude sout("chro") u kocky třeba sout(kňá) ....


abstraktní třída

je třída, pro kterou nedává smysl vytvářet z ní objekt

například vozdilo, mohlo by to být letadlo auto, kamion(tyhle třídy by dědily z třídy vozidlo), všechno s jinými parametry, ale stejným základem (kapacita lidí, metoda pohyb bla bla)


interfacy v podstatě umožnuje inheritova více tříd
