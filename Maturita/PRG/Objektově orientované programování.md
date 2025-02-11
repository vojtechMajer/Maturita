# Draft fáze píšu sračky


oop - strukturuje data a procedury (metody/operace) do tříd

třída je teda seskupení dat a operací, které spolu dávají smysl, například třída člověk bude mít operaci běh mluv ... další nesmysly a data jako jméno výška ...

třída určuje co bude každá instance mít za data(atributy), a metody 


instance třídy (objekt) - je pak už objekt vytvořen ze třídy se specifickými daty pro ten objekt (kdyby byla třída auto,, tak instance je Škoda Fábia, pistáciová, 50l, ...)


Instance se vytváří pomocí klíčového slova new, které alokuje pamět pro objekt, protože objekty jsou referenční datové typy
více v referenčních datových typech [[Datové Typy]]


Zapouzdření
"schování" dat, ke kterým by uživatel neměl mít přístup
get() set() 
private 

dáváme přístup k věcem, jen u těch u kterých je to nutné


Dědičnost
potomek - třída, která dědí  z nadřazené třídy
dědí se atributy a metody 

polymorfismus 

classa zvíře, každé zvíře dělá nějaký zvuk, ale jiný polymorfismus nám umožnuje zavolat metodu specifickou pro dané zvíře (chro pro prase)

nadřazená třída určí metodu (případně určí defaultní chování), a je na každém objektu jakým způsobem bude implementován v případě prasete to bude sout("chro") u kocky třeba sout(kňá) ....


abstraktní třída

je třída, pro kterou nedává smysl vytvářet z ní objekt

například vozdilo, mohlo by to být letadlo auto, kamion(tyhle třídy by dědily z třídy vozidlo), všechno s jinými parametry, ale stejným základem (kapacita lidí, metoda pohyb bla bla)


interfacy v podstatě umožnuje inheritova více tříd