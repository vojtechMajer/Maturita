akce, které vykonává preprocesor ještě před začátkem kompilace

mezi tyto akce patří:
## 1. Vložení hlavičkových souborů (File inclusion)

```c
// main.c

#include "nazevsouboru"
```

hledá se soubor **s názvem "nazevsouboru"** v **domovském adresáři** (tam kde je soubor main.c) , jestliže  takový soubor **neexistuje**, **nebo** jsou místo uvozovek **<  >**, hledá se soubor podle pravidla závislého na operačním systému (nejčastěji v systémové proměnné **path**)
## 2. Nahrazení maker (Macro substitution)
nahradí makra v programu textem

definice makra
```c
#define MAX_SIZE 10 
#undef MAX_SIZE // zruší definici pro MAX_SIZE

#define MAX_SIZE 10 

#define max(A, B) ((A) > (B) ? (A) : (B))



```

makra s proměnnou i když vypadají jako funkce, jsou to pouze makra

**před činností preprocesoru**:
```c
int pole[MAX_SIZE];


printf("%d", max(10,11) );
```
**po proběhnutí preprocesoru:**
```c
int pole[10];

printf("%d", ((10) > (11) ? (10) : (11)) );

```

## 3. Podmíněné zpracování (Conditional inclusion)
Nejčastěji používaný příklad je ošetření pro includnutí stejných souborů vícekrát

```c
#ifndef __MUJ_HLAVICKOVY_SOUBOR_H__ // jestli ještě nebyl nikde inkludnut, tedy nebyl ještě definován tak pokračujeme
#define __MUJ_HLAVICKOVY_SOUBOR_H__ // makro se zde definuje aby mohla proběhnout kontrola v dalších souborech

...

#endif // tady by skočil preprocessor, kdyby už bylo makro definováno
```

**překlad řízený hodnotou makra**
```c
#define DEBUG false
	#IF DEBUG == true
	...
	print("debugovaci informace ....");
	#ELSE
	...
	#endif
```

Jde taky podmíněně zpracovávat platformně specifický kod

```c
#ifdef _WIN32
    // Windows (x64 and x86)
    ...
#elif __unix__ // all unices, not all compilers
    // Unix
    ...
#elif __linux__
    // linux
    ...
#elif __APPLE__
	...

```
