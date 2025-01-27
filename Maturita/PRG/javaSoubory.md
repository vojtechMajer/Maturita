# Java Soubory

Tridy se kterými se pracuje:

 - FileReader (textový) - zapis pomocí proudu znaků (čte po jednom znaku)
 - FileWriter (textový) - čte znaky
 - **BufferedReader** souvisí se Třídou FileReader(new BufferReader(FileReader) ), umožňuje práci s více znaky (readLine, atd...)
 - **BufferedWriter** obdobně jako BufferedReader
 - FileOutputStream (binární) - zápis pomocí proudu btw (zápis 1 bytu)
 - FileInputStream (binární) - čtení po jednom bytu
 - **DataInputStream** (nadstavba nad FileInputStream) - umožnuje zápis více než jednoho bytu (větší bloky než jeden block) např.: celý int, double atd...
 - **DataOutputStream** (nadstavba nad FileOutputStream) - čtení intu, doublue atd... z binárního souboru
 - **ObjectDataStream** zápis objektu binarně (je třeba implementovat rozhraní)

**čtení řádků pomocí bufferedReaderu do konce souboru**
``` while( (text = bufferedReader.readLine()) != null) ```

**Čtení všech bytu do konce souboru**
``` while( (Byte/Float/Int data = (byte) inputStream.read()) != -1 )```

Při řešení souborů je třeba ošetřit vyjímky (exceptions)
vyjímky můžou nastat například, když soubor neexistuje, na disku není místo a pod.
**jsou 2 možnosti:**
1. Vyřešit vyjímku na místě (když není třeba výhoda posílání dál, nějaká interní chyba)
2. Poslat ji dál (když děláme metody pro ostatní lidi nebylo by vhodné řešit exception na místě a přerušit tím program, proto ji pošlem dál a necháme uživatele se s ní poprat)

**Zápis souborů**
k zápisu souborů dochází buď při naplnění mezipaměti, nebo při `soubor.close()` 
write tedy neproběhne hned při volání, ale až při close nebo naplnění mezi paměti (všechny data se pak **ne**musí zapsat **bez** použití `close()` )

