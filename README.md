# Progetto finale di Ingegneria del Software - a.a. 2020-2021

Scopo del progetto è quello di implementare il gioco da tavola Solitario, seguendo il pattern architetturale Model View Controller, per la realizzazione del modello secondo il paradigma di programmazione orientato agli oggetti. Questo applicativo è stato realizzato seguendo un approccio iterativo, in particolare nelle prime iterazioni ci si è concentrati a implementare le funzionalità più importanti individuate nei requisiti. 
A conclusione di tale lavoro e dopo aver applicato i test unitari con JUnit (con relative correzioni), è stata prodotta la versione del programma "Solitario.jar" presente nella cartella [jar](https://github.com/giuseppegiuffry/SoftwareEngineering-Project/tree/main/Solitario/jar).  
Il risultato finale copre completamente le regole definite dal gioco e permette di interagire con esse tramite un'interfaccia grafica (GUI).

### Documentazione
All'interno della cartella **documentation** è possibile trovare tutta la documentazione, che comprende i documenti e i diagrammi UML realizzati per la progettazione del software. Le varie cartelle ("01-Ideazione", "02-Elaborazione", ecc) contengono i documenti prodotti via via che si procedeva con la progettazione e con l'implementazione dell'applicazione.

### Librerie e Plugins
|Libreria/Plugin|Descrizione|
|---------------|-----------|
|__jUnit__|framework dedicato a Java per unit testing|
|__JavaFx__|libreria grafica di Java|

## Funzionalità
### Funzionalità Sviluppate
- Regole Complete
- GUI
- Visualizzare le regole del gioco
- Annullare l'ultima mossa eseguita

## Avvio
Per eseguire l'applicazione è necessario seguire i seguenti step:

- Scaricare una versione [JDK11](https://www.oracle.com/it/java/technologies/javase-jdk11-downloads.html) o superiore;
- Settare la variabile d'ambiente JAVA_HOME alla directory di installazione di JDK;
- Scaricare una versione appropriata di [JavaFXSDK](https://gluonhq.com/products/javafx/) ed estrarre l'archivio in una directory;

### In Eclipse
- Includere il nuovo JDK come Installed JREs in Eclipse -> Preferences -> Java -> Installed JREs -> Add
- Creare una nuova User Library in Eclipse -> Window -> Preferences -> Java -> Build Path -> User Libraries -> New
- Chiamarla JavaFX11 e includere i jar dentro la cartella **lib** di JavaFX 11
- Aggiungere la libreria al progetto andando su Properties -> Java Build Path -> Libraries -> Add Library -> User Library e selezionare JavaFX11
- Andare su Run -> Run Configurations...  -> Java Application e aggiungere questi argomenti VM:

```[shell]
--module-path "\path\to\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml
```
- Cliccare su Run -> Run As -> Java Application per eseguire l'applicazione

### Esecuzione JAR
Per eseguire il file JAR dell'applicazione, posizionarsi nella directory in cui si trova e digitare da linea di comando:

```[shell]
java --module-path "\path\to\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml -jar Solitario.jar
```

Per maggiori dettagli su JavaFX e su come eseguire in maniera corretta un progetto che utilizza questa libreria, eventualmente usando anche altri ambienti di sviluppo, si consiglia di fare riferimento a questa [guida](https://openjfx.io/openjfx-docs/).