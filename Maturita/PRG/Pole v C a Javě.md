## Co je vlastně to pole
Pole jsou způsob jak uložit několik hodnot do jedné proměnné.
Dále u pole platí že jsou data uloženy hned za sebou, takže jsou **konsekutivní** (Po sobě jdoucí).
proměnná **pole** je pointer, který ukazuje na první hodnotu prvku

Z řazení datových typů také víme že jsou data homogenní, čili stejného datového typu.
![Pole](./../pole.jpg)

## Jak teda vypadá Přístup k prvkům pole? (Pointerová akrobacie)
jestli víme že adresa prvního prvku je začátek pole tak k prvnímu poli se dostaneme takto
```c
int pole[9] = {1,2,3,4,5,6,7,8,9};
// představme si že prvke 1 má adres 0x0000 (hexadecimalne)
int hodnotaPrvnihoPrvku = *(pole + 0); // 1
```

**Dále díky homogenitě a konsekutivnosti(jsou za sebou, žádná hodnota není mezi nimi) dat víme že další prvek bude**
```c
int pole[9] = {1,2,3,4,5,6,7,8,9};
// představme si že prvke 1 má adres 0x0000 (hexadecimalne)
int hodnotaPrvnihoPrvku = *( (int*) ((char*)pole + 1 * sizeof(int)) ); // 2
```
nelekejte se, tohle všechno za nás udělá compiler a stačí to napsat takto:
```c
int pole[9] = {1,2,3,4,5,6,7,8,9};
// představme si že prvke 1 má adres 0x0000 (hexadecimalne)
int hodnotaPrvnihoPrvku = *(pole+1); // 2
```
Důležité je si odnést že kdyby byly různé datové typy nebo kdyby bylo pole rozděleno do několika segmentů nešlo by pole používat.

ještě více zkrácený výraz, který se používá nejčastěji je tento:
u tohoto zápisu si musíme uvědomit že pole se **indexuje od 0**
```c
int pole[9] = {1,2,3,4,5,6,7,8,9};
// představme si že prvke 1 má adres 0x0000 (hexadecimalne)
int hodnotaPrvnihoPrvku = pole[2] // 3
```

## Další možnosti polí
začnu s analogii, zásobník si můžeme představit jako na sobě položené talíře, v tomto případě jsou talíře data, která přidáváme do zásobníku. Když se podíváme na talíře poskládané na sobě a ty co používáme jsou přímo nahoře, takže k nim máme rychlý přístup.
Naopak halda se dá představit ... no jako halda smetí všechno náhodně bez ladu a skladu, a věci co hledáme přímo nevidíme a trvá nám dlouho je najít.

**Tak Proč by někdo používal haldu??**
v reálném světe máme jen určitou výšku do které můžeme skládat talíře na sebe než se nedostaneme dále. Tento stejný problém má i zásobník, je omezen tím kolik nám operační systém přidělil paměti (konkrétně RAM).

A halda je výrazně větší a dokáže tedy uložit více věcí, dat, a navíc se dá zvětšit návozem více hlíny/odpadků/dat

**Proč není zásobník větší než halda?**
Aby zásobník mohl být tak rychlý jak je, tak vyžaduje optimalizaci compilerem, která není možná v moment, kdy potřebujeme haldu dynamicky měnit.
### Pole v zásobníku
- je třeba vědět jeho velikost předem.
- rychlejší přístup/ přidání na stack (data se pushnou na stack)
- **může** zabírat velikou část stacku (hodně hodnot, může dojít k stack overflow)
- nelze dynamicky měnit
```c
int main(void)
{
	int pole[9]; // pole je v zásobníku
}
```

### Pole na haldě
- není třeba vědět velikost
- pomalejší alokace (allocator musí projet hladu najít dostatečně velké místo, a uložit data viz obr)
- pomalejší přístup (přes pointer,který je na stacku)
- lze změnit velikost (ale často se pole musí přesunout na jiné místo v haldě)
```c
int main(void)
{
	int* pole = malloc(sizeof(int) * 9);
	// použití
	// uvolnění paměti a zakotvení
	free(pole); // můžeme si představit jako smazání čísel 1-9 z obrázku
	pole = null; // už nebude ukaovat na místo v haldě abychom jej omylem nepoužili
}
```

![Halda a stack](./../Halda_a_stack.jpg)


## Pole v jave

