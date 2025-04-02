![[Pasted image 20250211112747.png]]

## Textový editor
slouží k napsání zdrojového kódu (\*.c)
## Preprocesor
[[Činnost preprocessoru]]

## Compiler (překladač)
přeloží zdrojový kód do relativního kódu (adresy ještě nejsou známy, takže se použijí adresy pomocné tzv. relativní )

## Linker
změní adresy na absolutní, přidělí adresy i například volaným funkcím z ostatních knihoven, vytváří spustitelný soubor (na windows \*.exe)

## Debugger 
ladící program k hledání chyb, prochází program řádek po řádku

## Typy chyb
**logické chyby** - chyby například v algoritmu, takže postupu řešení debugger vám o nich neřekne, ale může s nimi pomoct
**syntaktické chyby** - chybějící středník, špatné jméno proměnné atd... (rozpozná je už compiler)
**sémantické chyby** - chyby, které vznikají během programu, například access paměti mimo program
## kompilované vs interpretované jazyky
kompilované jazyky jsou obvykle rychlejší, ale je třeba je kompilovat specificky pro platformu. 
Interpretované potřebují interpreter, který musí být nainstalovaný na cílovém zařízení

## Oddělený překlad
výhoda je že není třeba kompilovat každý soubor znova a znova, ale jenom změněné, tato výhoda se začíná ukazovat více až při větších projektech