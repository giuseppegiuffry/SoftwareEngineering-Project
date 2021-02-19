# Progetto finale di Ingegneria del Software - a.a. 2020-2021

Scopo del progetto è progettare una applicazione (per la simulazione) del famoso Gioco dell'Oca (semplificato). Questo applicativo è stato realizzato seguendo un approccio iterativo, in particolare nelle prime iterazioni ci si è concentrati a implementare le funzionalità più importanti individuate nei requisiti. 
A conclusione di tale lavoro e dopo aver applicato i test unitari con JUnit (con relative correzioni), è stata prodotta la versione del programma "GiocoDellOca.jar" presente nella cartella [GiocoDellOca](https://github.com/giuseppegiuffry/SoftwareEngineering-Project/tree/main/GiocoDellOca).  
Il risultato finale copre completamente le regole definite dal gioco e permette di avviare una simulazione della partita tramite console.

### Documentazione
All'interno della cartella **documentazione** è possibile trovare tutta la documentazione, che comprende i documenti e i diagrammi UML realizzati per la progettazione del software. Le varie cartelle ("01-Ideazione", "02-Elaborazione", ecc) contengono i documenti prodotti via via che si procedeva con la progettazione e con l'implementazione dell'applicazione.

### Librerie e Plugins
|Libreria/Plugin|Descrizione|
|---------------|-----------|
|__jUnit__|framework dedicato a Java per unit testing|

## Funzionalità
### Funzionalità Sviluppate
- Regole della versione semplificata del Gioco dell'Oca
- Un gestore definisce il tabellone di gioco (e quant'altro necessario per l'avvio delle partite)
- Un utente può avviare una (simulazione) di partita definendo quanti giocatori partecipano
- Una volta che la partita è cominciata, ad ogni turno l'applicazione fa vedere lo stato di tutti i giocatori (cioè dove sono sul tabellone e le mosse che man mano vengono fatte). L’utente deve poter controllare l’avanzamento dei vari passi della (simulazione della) partita

## Avvio

### In Eclipse
- E' sufficiente aprire il progetto dall'ambiente e avviare il file Main.java come applicazione Java

### Esecuzione JAR
Per eseguire il file JAR dell'applicazione, posizionarsi nella directory in cui si trova e digitare da linea di comando:

```[shell]
java -jar GiocoDellOca.jar
```