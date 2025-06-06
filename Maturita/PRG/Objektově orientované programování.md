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
je teda seskupení dat a operací, které spolu dávají smysl, například třída člověk bude mít operaci běhej, mluv ... další nesmysly a data jako jméno, výška ...
třída určuje co bude každá instance mít za data(atributy) a metody  
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
  - Jeho funkcí je inicializovat objekt výchozími hodnotami (jednoduché datové typy - 0, referenční - null).
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
- **final**
	- final class
		- Třídu nelze dále dědit (nemůže mít potomky)
		Příklad:
		```Java
		final class Auto { ... }
		class SportovniAuto extends Auto {} // ❌ Chyba – Auto je final
		```
	- final - pro metodu
		- Metodu nelze přepsat (@Override) v podtřídách
		Příklad:
		```Java
		class Zvire {
		    final void mluv() { ... }
		}
		class Pes extends Zvire {
  		    @Override
   		 void mluv() {} // ❌ Chyba – metoda je final
		}
		```
	- final - pro proměnnou
		- Proměnná, která musí být inicializována a už ji nelze změnit (chová se jako konstanta)
		Příklad:
		```Java
		final int cislo = 10;
		cislo = 20; // ❌ Chyba – final proměnná nelze přepsat
		```
  
- **extends** - zajišťuje dědičnost z rodičovských tříd
- **implements** - používáno v kontextu s rozhraními - říkáme tím jaké rozhraní bude třída implementovat
  
## Zapouzdření
způsob jak zabezpečit data 
"znepřístupnění" dat mimo třídu, u kterých dává smysl že k nim uživatel třídy (jiný programátor, který používá vaši třídu, jako modul/knihovnu) nemá přístup

- **gettery** - metody pro vracení hodnoty atributu
- **settery** - nastavení hodnoty atributu

### Modifikátory přístupu (access modifiers)
- private - přístupné jen v rámci třídy, kde byl atribut vytvořen
- protected - přístupné jen pro potomky
- public - přístupná pro všechny
dáváme přístup k věcem, jen u těch u kterých je to nutné

## Dědičnost
Vztah mezi rodičem (nadřazená třída) a potomkem (podřazená třída).
Potomek ze svého rodiče dědí metody a atributy
Třída může mít **maximálně jednoho** rodiče, ale potomků může mít podle potřeby
dědičnost je zajištěna klíčovým slovem extends

Například máme třídu Brainrot ze které můžeme dědit ve třídách ItalianBrainrot nebo AIKocicky... každá z těchto tříd bude mít možnost upravit si chováí rodiče podle sebe -> každý brainrot má jiný negativní dopad.

## Polymorfismus
je schopnost objektu chovat se různě podle toho, v jakém kontextu je použitý.
Máme třídu zvíře, každé zvíře dělá nějaký zvuk. Polymorfismus nám umožnuje zavolat metodu specifickou pro dané zvíře ("Haf haf" pro pejska)
Nadřazená třída nám určí metodu (případně určí její defaultní chování), a je na každém objektu jakým způsobem bude implementovat danou metodu.
**Příklad.:**
```Java
abstract class Zvire {
    protected String jmeno; // jméno musí existovat a být přístupné v potomcích

    public Zvire(String jmeno) {
        this.jmeno = jmeno;
    }


    void zvuk() {
        System.out.println("Můj mazlíčk "+ this.jmeno + " říka: " );
    }
}

class Pes extends Zvire {
    public Pes(String jmeno) {
        super(jmeno); // voláme konstruktor rodiče
    }

    @Override
    void zvuk() {
        super.zvuk(); // zavolá metodu rodiče
        System.out.println("Haf haf");
    }
}

// Někde jinde v kodu..
Zvire z = new Pes();
z.zvuk(); // ➝ Haf haf
```


### Abstraktní třída
je třída ze které nemůžeme explicitně vytvořit objekt můžeme z ní pouze dědit.
Vytváříme pomocí klíčového slova 'abstract'
Důležité je porozumět rozdílu oproti rozhraní:
- rozhraní nemůže mít vlastnosti ani implementaci metod -> toto si řeší každý potomek sám, kdežto abstraktní třída se chová jako všechny ostatní třídy
- nevýhodou abstraktní třídy je jako u všech rodičovských tříd -> můžu dědit jen z jedné (abstraktní) třídy 


například **vozidlo** by mohlo být letadlo, auto nebo kamion, proto si vytvoříme třídu vozidlo a třídy jako letadlo nebo auto z ní můžou dědit.
všechno s jinými parametry, ale stejným základem (vlastnost kapacita lidí, metoda pohyb a tak dále)

## Exceptions (Vyjímky)
Je potomek třídy `Exception` ,který je vyhozen v případě chyby buď samotným programem nebo programátorem( viz vytvoření vlastní vyjímky)
Například vyjímky, které řeží chyby vstupů a výstupů se nazývají `IOException`.
V jazyce C nemáme možnost odchytit vyjímky musíme si všechno ručně ošetřit pomocí alternativy(větvení)
### Vysvětlení pojmů (klíčových slov) pro odchycení a vyhodnocení vyjímky
- **try** => blok kodu ve kterém odchytáváme vyjímku
- **catch** => blok kodu kde je vyjímka zpracována
  - můžeme mít libovolný počet catchů ale pozor záleží na pořadí
  	- catch bez parametrů  - vyjímka bude odchycena ale nemůžeme například vyhodnotit typ vyjímky nebo message vyjímky
  	- catch s parametry - můžeme zde specifikovat odchycení jen konkrétních vyjímek a máme přístup ke všem datům o zachycené vyjímce
  - poté co je vyjímka vržena metoda pokračuje už **jen** do bloku finally
- **finally** => blok kodu co bude spuštěn v každém připadě
  	- vhodné třeba v případě obeznámení uživatele o tom že operace proběhla
### Zachycení vyjímky
```Java
try {
    del(0, 5); // pokus o dělení nulou
}
// vyhodnocujeme vlastní vyjímku výjimku
catch (VlastniVyjimka e) { // musí odpovídat názvu vlastní výjimky -> POZOR pokud jako parametr catch specifikujeme konkrétní vyjímku ostatní nebudou zachyceny 
    System.out.println("Vlastní vyjímka byla vyhozena: "+e.getMessage());
}
//pro všechny ostatní vyjímky 
catch(Exception e) //můžeme mít libovolný počet catchů ale pozor záleží na pořadí
{
	System.out.println("Byla vyhozena vyjímka" + e.getMessage());
}
//v tomto případě tento catch nikdy vyjímku nezachytí vyjímka bude zachycena nejpozději v druhém catchi
catch
{
	System.out.println("Byla vyhozena nějaká vyjímka");
}
// kód, který se provede vždy
finally {
    System.out.println("Operace proběhla");
}
```
### Předání - necháme vyjímku vyřešit toho, co metodu volá
```Java
void funkce() throws DelisNulouException
{
	del(0,5);
	return;
}

```
### Vytvoření vlastní vyjímky
- vyjímka jako každá jiná musí dědit ze třídy Exception
```Java
// Vlastní výjimka
public class VlastniVyjimka extends Exception {
    public VlastniVyjimka() {
        super("záporácká exceptiona"); // volá konstruktor nadřazené třídy Exception s textem zprávy
    }
}

```
### Vyvolání - při tvorbě vlastních vyjímek musíme určit kdy nastane
```Java
public int del(int jmenovatel, int citatel) throws VlastniVyjimka {
    if (jmenovatel == 0) {
        throw new VlastniVyjimka();
    }
    return citatel / jmenovatel;
}
```
