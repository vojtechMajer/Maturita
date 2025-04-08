
Funkce je logický blok kódu, který můžeme volat vícekrát, takže není třeba kopírovat kód pořád dokola, a navíc můžeme pro ostatní programátory vytvořit nějaký modul (např. matika) obsahující funkce z daného okruhu, a uživatel pak nemusí psát vše sám.

Funkce má 2 části: **Hlavičku** a **tělo**
funkce taky zabírají paměťové místo
## Hlavička
- **hlavička funkce** obsahuje výstupní a vstupní parametry a jejich datové typy
- **tělo funkce** - vykonává cokoliv co je třeba a v 
## Deklarace funkce 
deklarací funkce je hlavička a v jazyce C se musí nacházet nad místem, kde funkci voláme

## Rekurzivní funkce
Je taková funkce, která volá sama sebe.
Lze nahradit jiným cyklem
```c
// deklarace
int secti(int a, int b);
int faktorial(int a);
int main(void)
{
	int x;
	x = secti(6,9);
}

// definice
int secti(int a, int b) // hlavicka
// tělo
{
	return a+b; // return musí vracet int
}

// rekursivni funkce
int faktorial(int a)
{
	if(a>=1)
		return a*faktorial(a-1);
	else
		return 1;
}

// přes iteraci
int faktorial2(int a)
{
	int faktorial = 1;
	for(int i = a; i>=1; i--)
	{
		faktorial = faktorial*i; // faktorial *= i;
	}
	return fac;
}

void funkceBezNavratoveHodnotyAParametru(void)
{
	printf(":( jsem zbytečná funkce");
	return;
}
```

## Co když chceme vrátit více než jednu hodnotu
1. **Uděláme struct s hodnoty, co potřebujeme vrátit zpět**
```c
struct Bod {
int x,y;
}
struct Bod vratBod()
{
	return (struct Bod){1,2};
}
```
2. **vrátíme pole**
```c
int* vratSezarenePole(int velikost, int* pole)
{
	int* nove_pole;
	...
	return nove_pole;
};
```
3. **Přidáme pointery na hodnoty jako atributy**
```c
void naDruhou(int* a)
{
	*a = (*a)*(*a);
	return;
}

int main()
{
	int a = 10;
	naDruhou(&a);
}
```



