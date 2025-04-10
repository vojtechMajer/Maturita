
**proměnná** -> pojmenované místo v paměti, přístupné pomocí **identifikátoru** (název)
## Deklarace Inicializace a definice

**deklarace** - prohlášení - určení identifikátoru (jména proměnné) a datového typu,  **! ne** hodnoty
```c
int a;
```

**Inicializace** - zahájení - první přidání hodnoty
```c
a = 10;
```

**Definice** - spojení deklarace a inicializace
```c
int a = 10;
```

## Statické typování
datový typ je třeba určit předem, a tak i zůstává celý zbytek života
```C
	int promena = 49;
```


## Specifikátory
používají se ve scanf() printf() a ostatních podobných funkcí

```
%d - decimalní
%f - reálné float 
%d - reálné double
%x - hexadecimální
...
```
## životnost proměnné (scope)
```c
void main
{
	int a = 10; // 'a' vzniká tady
	{
		int b = 5;// vzniká zde 
		int* x = malloc(sizepf(int)*1);
		*x = 2;
	} // tady už b neexistuje // pointer x už neexistuje, ale data pořád zůstavají v haldě protože nebyly "vyčistěny" free()
	
	printf("%d", a);
	
} // 'a' zaníká zde
```

## více definic na řádku, pomocí čárky
```c
int x = 5, y = 6, z = 50;
```

## Identifikátory
jméno proměnné
musí být **unikátní**, **ne**smí mít **stejný název** jako klíčová slova
jsou **case sensitive**
**ne**smí začínat **číslem**
a obsahovat bílé znaky (mezery ) a speciální znaky (#, !, ...) 

```c
int tohleJeIdentifikator = 3;
```


## Paměťové třídy
určují kde bude proměnná uložena, životnost (scope) a výchozí hodnoty
extern static a register

```c
// kde je uložena; výchozí hodnota; životnost;

auto int moje_promenna1; // mimo stack i haldu (datový segment); random;
// AUTO je to samé jako nespecifikovat paměťovou třídu
auto int a; // === int a;


extern int promenna_definovana_jinde; // mimo stack u haldu; 0
# Proměnná je definována někde mimo

static int asd; // tahle proměnná si uchová hodnotu i po skončení bloku např.:
void pes()
{
	static int cislo = 2; // inicializace se provede pouze jednou
	cislo += 2;
	print("%d"m cislo);
}
pes(); // 2
pes(); // 4
pes(); // 6

// u statická globální(definovaná mimo main nebo jiné funkce) proměnné/funkce má static efekt že na ni nelze odkázat přes extern v jiném programu 

register int ahh; // jsou uložéné rovnou v registru cpu (jsou rychlejší) nelze na něodkazovat &
// nejčastěji se používají, když je knim třeba přistupovat často, takže třeba iterace(cykly)


```

## O čem mluvit:
1. Co je proměnná
2. deklarace definice inicializace
3. typ typování (statické)
4. Specifikátory
5. životnost
6. Identifikátory
7. * více definic najednou
8.  jak se zapisuje char (`'a'`)
9. paměťové třídy
