# Tvorba grafického rozhraní aplikací – Rozmístění (JavaFX)
JavaFX je knihovna pro tvorbu GUI (grafického uživatelského rozhraní) v jazyce Java

V Main funkci načteme .fxml soubory a ukážeme je uživateli
V .fxml souboru je nastavený vzhled aplikace
Každému fxml souboru přiřadíme kontroler který řídí funkčnost (V SceneBuilderu)


v kontroleru můžeme implementovat rozhraní Initializable, když chceme provést kód (třeba inicializovat komponenty) ještě předtím, než se scéna zobrazí uživateli.
```java
public class MainController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generate();
    }
}
```
FXML
FXML je "markup language" založený na XML, který se používá v JavaFX pro deklarativní popis uživatelského rozhraní
skládá se z komponentů a ovládacích prvků (Button, TextField, Label, ...) a rozvržení které určují rozmístění komponentů


## Rozvržení (Layout)
Rozvržení (layouts) určují, jak budou jednotlivé komponenty (např. tlačítka, textová pole) rozmístěny v okně aplikace.
JavaFX nabízí několik předdefinovaných **layout managerů**, které usnadňují tvorbu přehledného a responzivního rozhraní.




## Hlavní třídy layout manager
- **HBox -	Umístí prvky vodorovně horizontálně
- **VBox -	Umístí prvky svisle vertikálně
- **GridPane -	Mřížka – prvky do řádků a sloupců
- **BorderPane -	Rozdělení do oblastí: Top, Bottom, Left, Right, Center.
- **AnchorPane** -	Umožňuje „připnout“ prvky k okrajům kontejneru (ConstraintLayout v Androidu)

```java
Pane pane = new Pane();
Button btn = new Button("Klikni");
btn.setLayoutX(50);
btn.setLayoutY(100);
pane.getChildren().add(btn);
