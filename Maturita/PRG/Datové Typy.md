
**Určuje:**
## Množinu přístupných **hodnot**
Například:
- do celočíselného datového typu **ne**půjde uložit reálné číslo
- **Nelze** uložit záporné číslo do proměnné s **modifikátorem** unsigned 
```c
// Je možné, ALE bude uložená špatná hodnota 1
int x = 1.5; // výsledek x = 1

// LZE ale bude špatný výsledek
// výsledek je Maximální hodnota unsigned intu, kvůli přetečení
unsigned int y = -1; // y = 4294967295
```

## Množinu přípustných **operací**
(float - dělení, nelze použít % zbytek, sčítaní, ... int - dělení beze zbytku, zbytek %, sčítání ...)
### Reálné čísla (float, double)
klasické operace sčítání odečítání ....
**!!! Výsledek dělení je reálné číslo! (/)**
**!!! Nelze získat zbytek po dělení, operace modulo (%)**
### Celá čísla (int, char, ...)
klasické operace
jsou ordinální, lze je použít ve switchi case, enum
**Celočíselné dělení (/)**
**!!! Lze použít modulo (%)** 

```c

int a = 5;
int b = 2;
float d = 5;

// dělení a zbytek celého čísla
int c = 5/2; // vysledek je 2
int zbytek = 5%2;

// POZOR POZOR POZOR POZOR
// I když by se mohlo zdát že používáme reálné dělení, protože máme v levo float
// není tomu tak. Důvod je že operátor / voláme na dvou Intech a tak se použije celočíselné dělení
float c = a/b; // 2
float c = 5/2; // c =2
// Správné užití by tedy muselo přetopovat alespoň jeden operand na float e.g.
float d = a/(float)b  // 2.5

// příklad reálného dělení
float d = d/b // 2.5
float d /= 2.0; // 2.5


```

### / jako operator overloading
trošku odbočka k operátorům
operator overload = přetížení operátoru = má jiné funkce pro různé datové typy

## Rozsah hodnoty 
Kolik místa v paměti zabírají, jakou mají přesnost
B = Byte
b = bit (0,1)
1B = 8b = $2^8$  =  256 možností

**Odbočka z matiky**
Matika Variace s **opakováním** (0 i 1 se můžou opakovat)
$V'(k,n)$
0 a 1 jsou dvě možnosti **n = 2** 
tvoří se 8 (8bitů) místné k-tice  **k = 8**
příklad.:
1. 00000000
2. 00000001
3. 00000010
4.        ...

Tedy **char** (1B) má 256 různých znaků = ascii tabulka má 256 různých znaků
**int** = 4B ($2^{36}$) = HODNĚ


## Dělení 
1. **Jednoduché** 
	1. celočíselné (int, enum (enum je unsigned int), char)
	2. reálné (float, double)
2. **Strukturované**
	1. Homogenní - Pole, řetězce, soubory (soubor jako znaky v paměti, **ne**jedná se o strukturu `FILE* soubor = fopen(...);` 
	2. Strukturované - struct, union
3. **Speciální**
	1. void bez rozsahu


### Enumy structy a uniony

**enum** je takzvaný výčtový datový typ vyčte možnosti např.:
enum je zajištěn **unsigned intem** jeho rozsah jsou tedy kladná celá čísla (maximálně 4294967295) a nula
```c
enum barva {
CERVENA, // 0 (tuším že se startuje od jedničky)
CERNA, // 1
ZLUTA, // 2
MODRA = 5 // hodnotu lze i ručně přiřadit
}
```

**Struct a union**
člen (member) - 
struct zabírá tolik místa v paměti jako součet svých členů v paměti
```c
// cleny structu osoba jsou jmeno, prijmeni, vek, vaha

// Velikost dohromady 38 B
struct Osoba {
char jmeno[10]; // 10B 
char prijmeni[20] // 20B
int vek; // 4B
float vaha; // 4B
}
```

union zabírá **paměť podle největšího ze svých členů**, v **jeden moment** proto **ukládá** **právě jeden** ze svých členů
```c
// velikost bude 20B paměti se jakoby překrývají
union KdyzChcemePouzitJenJedenZClenu{
	char slovo[20]; // 20B
	int cislo; // 4B
}
```


## V Jave
### Referenční (Objektové)
Data se nacházejí v **haldě** a **reference** (proto referenční/odkazující) odkazující na tyto data v **zásobníku**  viz obr..

Navíc můžeme mít reference odkazující na stejná data a zmenšit tím místo zabrané v paměti, ale pozor že úpravou dat např. člověk, který má na sobě 2 nebo více referencí, **změníme všechny**

```java
Clovek karel = new Clovek("Karel", "Novák", ....);
Clovek karelAleZnova = karel; // ukazuje na stejná data v haldě

// Jestliže chceme kopie kterou půjde odděleně modifikovat(měnit musíme vytvořit tzn. hlubokou kopii)
KarelAleZnova = new Clovek(karel.jmeno, karel.prijmeni, ...);
// nebo
KarelAleZnova = new Clovek(karel); // vyžaduje takzvaný copy constructor

class Clovek{
...

	public Clovek(Clovek copy)
	{
		this.jmeno = copy.jmeno;
		this.prijmeni = copy.prijmeni;
		...
	}
}

```
### Primitivní
int, char, atd.. čili stejné jako Jednoduché datové typy v jazyce C, nachází se rovnou v zásobníku

![[zasobnik_a_halda_struktura.png]]
Pozor na obrázku je třída ne struktura, struktura by měla všechny své data v zásobníku
Z obrázku můžeme vyčíst že **primitivní datové typy** jako je právě int (`int a=10`), se nachází **v zásobníku**
a **referenční** mají "**zástupce**" v **zásobníku**, který ukazuje na jejich **data**, které jsou v **haldě**

Proč je **zásobník zeleně**? a proč **halda červeně**?
zjednodušeně **zásobník** je **rychlý**, ale má **omezenou paměť**, proto se **dlouhé data** jako člověk(jmeno, příjmení, věk, váha adresa, ....) ukládají do haldy a by měl procesor rychlejší přístup k podstatnějším věcem a navíc zvětšili místo v paměti, které můžeme použít (halda má **mnohem víc místa**, ale je **pomalejší** )

**více v poznámce o Pojmech**

## O čem mluvit
1. **Množina přístupných hodnot, operací a rozsah (první 3 nadpisy)**
2. **/ jako overload operátor** (nadpis množina přístupných operací)
		napsat příklad na papír, jak funguje dělení
3. **Dělení (jednoduché, strukturované, speciální)**
4. Referenční a primitivní typy v Jave (co je na haldě co v zásobníku)
5.  enum, struct a union
