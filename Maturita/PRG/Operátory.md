
```c
int main()
{
	int a,b,c;
	
	// a, b, c jsou operandy 
	// = a + jsou operátory (operátor pracuje s operandy)
	a = b+c
}
```

operátor provádí operace s **operandy**, operátor je reprezentován jedním nebo více znaky
Operátory mají odlišné přednosti(myšleno pořadí průběhu), některé se provádějí dříve než ostatní

**Dělení operátorů (podle počtu operandů)**

**unární** (1 operand)
provádí operace na jednom operandu
**příklady:**
```c
// Referenční/Adresové/Pointerové
& - reference // získá adresu
* - dereference // získá hodnotu
-,+ před operandem znaménko kladná/záporná hodnota
., -> přístup k členům

// Speciální
sizeof(int) - taky je operátor
, - ano čárka je taky operátor (k ničemu ale to je detail)

// Logické
! negace 
~ bitová negace
```
**binární** (2 operandy)
Provádí operace se dvěma operandy

**příklady:**
```c
aritmetické
+, -,*, /, % pozor procento nelze používat u floatu
++, --
přiřazovací
=, +=, -=, *= ...

relační (porovnávací)
<, <=, >, >=, ==, !=

Logické 
&&, ||

bitové
>>, <<, |, &, ^

```
**ternární** (3 operandy)
```c
int a = (1>0)?10 : 20
```
**Vyhodnocování**
Vyhodnocuje od konce
```c
int a = 2, b=3;
int c = a + b; // vvhyodnotí se a+b a pak až se přiřadí výsledek na místo v paměti vyhrazené pro c  
```

**Zrychlené vyhodnocování**

```c
bool a = false;
bool b = true;

(b && a) stačí se podívat na a jelikož je false není třeba kontrolovat b ani (a || b), protože && potřebuje true na obou stranách aby bylo pravdivé 

if( (a || b) && (b && a) )
{
	....
}
```

**Operátor děleno**
speciální výskyt overload operátoru -> chová se jinak v případě reálného nebo celočíselného datového typu.

Dělení u reálných čísel a celočíselných čísel
```c
float result1 = 7.0f / 3.0f; výsledkem je desetinné číslo
int result2 = 7 / 3; výsledkem je zaokrouhlené číslo
```

modulo % zbytek po dělení !pouze pro celočíselné datové typy!

**Post a pre-inkrement a dekrement**
může přijít i otázka na tohle

pre - před (provádí **operací**) 
post -po (provádí se **po** operaci)

```c
int a = 5;
int b = 2;

// POST - PO operaci
// k b se přičte 1 až po operaci += takže výsledek a bude 5+2
a += b++; // 5+2
// po proběhnutí se inkrementace provede a b tak v následujících operacích bude o 1 více (b++)

// a=7, b=3
print("%d, %d",a,b);

// PRE - Před operací
// b se odečte a jeho hodnota se následně přiřadí do a
a = --b; // 1

// a=1, b=1
print("%d, %d",a,b);
```


## O čem mluvit
1. Co je operátor,  a co je operand (napsat jednoduchý příklad a popsat)
2. Dělení podle **Počtu** operací a podle **typu** operací
3. * Overload operátoru /
4. * dělení a modulo u celočíselných a reálných datových typů
5.  Postup vyhodnocování operátorů + Zrychlené vyhodnocování logických operátorů
6. Pre a post inkrement 