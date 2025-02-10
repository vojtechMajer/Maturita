
## Dialogová okna na import a export

### Nastavené filtrů
```java
FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
fileChooser.getExtensionFilters().add(extFilter);
```
  

  
### import
```java
FileChooser fileChooser = new FileChooser();
// Nastavení filtrů pro typy souborů
FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
fileChooser.getExtensionFilters().add(extFilter);
        
File file = fileChooser.showOpenDialog(new Stage());
  if (file != null) {
    try
      {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null)
        {
          historiePrikladu.getItems().add(line+"\n");
        }

      } catch (FileNotFoundException e)
        {
          errorHlaska.setText("soubor neexistuje");
        } catch (IOException e)
          {
            throw new RuntimeException(e);
          }
  }
```

### export
```java
FileChooser fileChooser = new FileChooser();
// Nastavení filtrů pro typy souborů
FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
fileChooser.getExtensionFilters().add(extFilter);
        
File file = fileChooser.showOpenDialog(new Stage());
  if (file != null) {
    try
      {
        BufferedWriter writer = new BufferedWriter(new FileWriter(writer));
        writer.write(...);

      } catch (IOException e)
      {
        errorHlaska.setText("soubor neexistuje");
      }
  }
```
