
**Určuje:**
## Množinu přístupných **hodnot**
Například:
- do celočíselného datového typu **ne**půjde uložit reálné číslo
- **Nelze** uložit záporné číslo do proměnné s **modifikátorem** unsigned 
```c
// NELZE
int x = 0.5;

// LZE ale bude špatný výsledek
unsigned int y = -1; // výsledek je Maximální hodnota unsigned intu, kvůli přetečení
```

## Množinu přípustných **operací**
(float - dělení, nelze zbytek, sčítaní, ... int - dělení beze zbytku, zbytek %, sčítání ...)
### Reálné čísla (float, double)
klasické operace sčítání odečítání ....
**!!! Výsledek dělení je reálné číslo! (/)**
**!!! Nelze získat zbytek po dělení, operace modulo (%)**
### Celá čísla (int, char, ...)
klasické operace
**Celočíselné dělení (/)**
**!!! Lze použít modulo (%)** 

```c

int a = 5;
int b = 2;

int c = 5/2; // vysledek je 2
int zbytek = 5%2; // vysledek je 1

// POZOR POZOR POZOR POZOR
float c = 5/2; // výsledek je taky 2, protože 5 i 2 jsou brány jako INT takže se používá celočíselné dělení
float c = a/b; // 2

// příklad reálného dělení
float d /= 2.0; // 2.5
float d = a/(float)b  // 2.5

```

### / jako operator overloading
trošku odbočka k operátorům
operator overload = přetížení operátoru = má jiné funkce pro různé datové typy


## Rozsah 
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

**enum** je takzvaný výčtový datový typ vyčítá nějaké možnosti pro něco např.:
```c

enum barva {
CERVENA, // 0 začíná se od nuly
CERNA, // 1
ZLUTA, // 2
MODRA = 5 // hodnotu lze i manuálně přiřadit
}
```

**Struct a union**
člen (member) - 
struct zabírá součet svých členů (member) 
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


![[Pasted image 20250106162222.png]]
Z obrázku můžeme vyčíst že **primitivní datové typy** jako je právě int (`int a=10`), se nachází **v zásobníku**
a **referenční** mají "**zástupce**" v **zásobníku**, který ukazuje na jejich **data**, které jsou v **haldě**

Proč je **zásobník zeleně**? a proč **halda červeně**?
zjednodušeně **zásobník** je **rychlý**, ale má **omezenou paměť**, proto se **dlouhé data** jako člověk(jmono, příjmení, věk, váha adresa, ....) ukládají do haldy a by měl procesor rychlejší přístup k podstatnějším věcem a navíc zvětšili místo v paměti, které můžeme použít (halda má **mnohem víc místa**, ale je **pomalejší** )

**více v poznámce o Pojmech**

## O čem mluvit
1. **Množina přístupných hodnot, operací a rozsah (první 3 nadpisy)**
2. **/ jako overload operátor** (nadpis množina přístupných operací)
		napsat příklad na papír, jak funguje dělení
3. **Dělení (jednoduché, strukturované, speciální)**
4. Referenční a primitivní typy v Jave (co je na haldě co v zásobníku)
5.  enum, struct a union
