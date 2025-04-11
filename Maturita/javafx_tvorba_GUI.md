# Tvorba grafického rozhraní aplikací – Rozmístění (JavaFX)

JavaFX je knihovna pro tvorbu GUI (grafického uživatelského rozhraní) v jazyce Java

## Jak vytvoříme JavaFX aplikaci

Aplikace můžeme vytvořit tím že vytváříme komponenty v Jave jako instance tříd které potom přidáme do layoutu

```java
    @Override
    public void start(Stage primaryStage) {
        // Vytvoření komponent
        Label label = new Label("Ahoj, svět!");
        Button button = new Button("Klikni mě");
        
        // Akce pro tlačítko
        button.setOnAction(e -> label.setText("Tlačítko bylo stisknuto"));

        // Layout: VBox
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(label, button);
        
        // Nastavení scény a zobrazení okna
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setTitle("Moje aplikace");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
```

Ale mnohem lepší způsob je vytvoření samostatného FXML souboru ve kterém nastavíme všechny komponenty a vzhled aplikace
Práce je takhle jednodušší a projekt je lépe strukturovaný

## Části aplikace: Main funkce

V Main funkci načteme .fxml soubor přes FXMLLoader

```java
FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
```

Vytvoříme scénu z načteného fxml

```java
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
```


Stage objektu nastavíme scénu a ukážeme jí uživateli 

```java
        stage.setScene(scene);
        stage.show();
```
Celé: 

```java
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
```

## Části aplikace: FXML

FXML je jazyk používaný v JavaFX pro definování uživatelského rozhraní aplikace. Umožňuje oddělit logiku aplikace (Java) od grafického rozhraní (FXML). To znamená, že rozhraní aplikace lze navrhovat a upravovat bez nutnosti psát Java kód.

## Kontroler

Každému fxml souboru přiřadíme kontroler který řídí funkčnost (V SceneBuilderu)
v kontroleru můžeme implementovat rozhraní Initializable, když chceme provést kód (třeba inicializovat komponenty) ještě předtím, než se scéna zobrazí uživateli

```java
public class MainController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generate();
    }
}
```

## Controls
Komponenty které slouží k interakci s uživatelem - zobrazení informací nebo získaní vstupních dat

- **Button** -	Tlačítka pro provedení akce
- **Label** -	extová popisná pole
- **TextField** -	Pole pro zadání textu
- **PasswordField** -	Pro zadávání hesla
- **TextArea** -	Víceřádkové textové pole
- **CheckBox** -	Zaškrtávací políčko pro volbu mezi dvěma možnostmi
- **RadioButton** -	Pro výběr jedné možnosti ze seznamu
- **ComboBox** -	Rozevírací seznam pro výběr
- **ListView** -	Seznam pro zobrazení položek


## Containers 
Containers určují, jak budou jednotlivé komponenty (např. tlačítka, textová pole) rozmístěny v okně aplikace.
JavaFX nabízí několik předdefinovaných **rozložení**, které usnadňují tvorbu přehledného a responzivního rozhraní.

## Hlavní třídy Containers
- **HBox** -	Umístí prvky vodorovně horizontálně
- **VBox** -	Umístí prvky svisle vertikálně
- **GridPane** -	Mřížka – prvky do řádků a sloupců
- **BorderPane** -	Rozdělení do oblastí: Top, Bottom, Left, Right, Center.
- **AnchorPane** -	Umožňuje „připnout“ prvky k okrajům kontejneru (ConstraintLayout v Androidu)




