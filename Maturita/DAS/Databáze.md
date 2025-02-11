
## Pojmy
**Relační model** - databázový model, který sdružuje data do **relací** (**tabulek**), které obsahují **řádky**, každý řádek obsahuje **atributy**(sloupce) 

**Integrita dat** - správné nenarušené vztahy mezi záznamy, integritu dat zajišťuje ji **referenční integrita**, **cizí klíč**, **primární klíč** a **normálové formy**

**referenční integrita** - je definována cizím klíčem pro dvojici tabulek
příklady referenční integrity:
- Při vkládání záznamu do tabulky, která obsahuje adresy podniků, se kontroluje, zda vložené poštovní směrovací čísel Poštovní směrovací číslo") existuje v tabulce poštovních směrovacích čísel (směrovací číslo je v tabulce směrovacích čísel [primárním klíčem](https://cs.wikipedia.org/wiki/Prim%C3%A1rn%C3%AD_kl%C3%AD%C4%8D "Primární klíč")).
- Při vkládání záznamu do tabulky, která obsahuje adresy podniků, se kontroluje, zda vložené [poštovní směrovací číslo](https://cs.wikipedia.org/wiki/Po%C5%A1tovn%C3%AD_sm%C4%9Brovac%C3%AD_%C4%8D%C3%ADslo "Poštovní směrovací číslo") existuje v tabulce poštovních směrovacích čísel (směrovací číslo je v tabulce směrovacích čísel [primárním klíčem](https://cs.wikipedia.org/wiki/Prim%C3%A1rn%C3%AD_kl%C3%AD%C4%8D "Primární klíč")).

**cizí klíč** - definuje vztah mezi dvěma tabulky a to tak že hodnota cizího klíče musí existovat v jiném primárním klíči. Cizí klíč umožňuje definovat akce, které mají nastat při pokusu o změnu nebo mazání záznamů v cizí tabulce. ON DELETE CASCADE atd...

**Primary key** - jednoznačně identifikuje instanci tabulky, vlastnosti ne NULLOVÁ hodnota a jedinečnost v tabulce

**Normalizace** - je o spojování dat správným způsobem
**Entita** - 

**báze dat** - Organizovaná kolekce dat, která je spravována DBMS systémem
**DBSM** (database management system|systém řízení báze dat) - zajišťuje správu dat
**Databázový systém** - kombinace DBSM a báze dat
**Databázový model** - relační model (klíče normálové formy)
**Integritní omezení** 
- unikátnost - každá hodnota ve sloupci je jedinečná
- Referenční integrita - cizí klíč odkazuje na existující primární klíč
- Primární klíč nemůže být NULL
**Doména** - množina povolených hodnot pro atribut
**Redundantnost** - duplicitní ukládání stejných dat

úrovně pohledu na data: ???


**Kardinalita** - 

## 1. Databázový systém
a. Popište databázový systém – jeho části, úkoly a vlastnosti.
b. Vysvětlete pojmy: báze dat, systém řízení báze dat, databázový systém, databázový model,
integritní omezení, doména, redundantnost, primární klíč, cizí klíč, úrovně pohledu na data.

Databázový systém je program, který se specializuje na efektivní ukládání a práci s daty(čtení, mazání, úpravy)

jeho části:

**Data** - uložená data  (s relacemi v tabulkách)

úkoly:
manipulace s daty
**zajištění integrity dat** (primární klíče, atd...)
optimalizace výkonu
zabezpečení dat

Vlastnosti:
**3NF** - 3 normální formy

1NF - unikátní a atomické hodnoty, adresu uložíme jako.: město, psč, číslo popisné, místo jenom adresy

2NF - Všechny data musí záležet na nějakém primárním klíči  
stačí vytvořit mezi tabulky u spojených klíčů, aby se neopakovaly záznamy
**Ne**splňuje
![[Pasted image 20250211092045.png]]Splňuje
![[Pasted image 20250211092121.png]]
3NF -
![[Pasted image 20250211100539.png]]
Job name by se mohla opakovat u více zaměstnanců proto je třeba udělat další tabulku

