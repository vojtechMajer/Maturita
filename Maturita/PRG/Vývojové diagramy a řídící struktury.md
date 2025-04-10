![[vyvojove_diagramy.png]]


Chybí:
**switch** - více násobné dělení
vnořené větvení - větvení uvnitř nějaké větve 
typo - cyklus v pravo dole není s podmínkou na začátku, ale na konci

**Řídící struktury programu:**
způsob jak určovat tok "flow" programu, umožňuje programátorovi psát kod v závislosti na ostatní části kodu (např. mezi nějaké dvě části)

1. **Posloupnost** (sekvence) - viz první vývojový diagram, krok za krokem -> vlastnost algoritmu **determinovanost**
2. **cykly** (iterace) - 3 a 4 vývojový diagram + for (když potřebujeme pracovat s číslem již provedených iterací (provedení těla cyklu) a **známe počet opakování**)
3. **Větvení** (Alternativa) - 2 diagram + switch a úplná a neúplné alternativa

## Vlastnosti algoritmu
**Elementárnost** -> element (základní, nezmenšitelný). Algoritmus se skládá z nejmenších možných kroků např. algoritmus neřekne "uvař polévku", ale specifikuje elementární kroky potřebné k uvaření polívky: orestuj zeleninu, udělej závařku, zamíchej, ....
**Pozor!** postup nahoře **ne**splňuje elementárnost, konkrétně přidej zavářku by **ne**byl elementární krok, protože se skládá z více kroků (pánev -> mouka -> voda -> ....)

**Determinovanost** -> v každé fázi zpracování programu je jasný nadcházející krok, počítač se sám neumí rozhodnout, proto se nesmí dostat do situace, kde by k tomu došlo. (Psaním programu tuto vlastnost nelze porušit, ale například můžeme udělat chybu ve vývojovém diagramu, i když se nám zdá že další krok je jasný)

**Konečnost** -> algoritmus musí skončit v reálném čase. Nemůžeme dělit 9/3 **přesně**, protože bychom nikdy neskončili a navíc by nám došla paměť

**Rezultativnost** -> Každý program musí mít výsledek, i chyba je výsledkem

**Hromadnost** -> algoritmus by měl být použitelný pro všechny úlohy stejného charakteru například.: 
```c
// splňuje Hromadnost -> funguje pro každou kombinací 2 intů 
int soucet(int a, int b)
{
	return a+b;
}

// Nesplňuje -> platí pouze pro 1+1
int soucet1()
{
	return 1+1;
}

int soucet_1_2()
{
	return 1+2;
}

...
```

**Efektivnost** -> algoritmus by neměl končit v co nejrychlejším čase a využít co nejméně výpočtů (počtu činností) 


## O čem mluvit
1. Řídící struktury (kreslit vývojáky) celkem nadlouho
2. Výhody a nevýhody cyklů s podmínkou na začátku nebo na konci
3. Větvění vnořené popsat na příkladu **větší než** 0 **menší než** 0 nebo 0
4. Switch (musíme znát větve před kompilací case: "pes" // nemůže tu být proměnná)
5. Vlastnosti algoritmů (vyjmenovat a na příkladech popsat)
