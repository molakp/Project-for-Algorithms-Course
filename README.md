# Laboratorio di Algoritmi e Strutture Dati #


## ENG ##

The "Project-for-Algorithms-Course" repository is a collection of projects and examples developed as a part of an algorithms course. The repository includes implementations of various data structures and algorithms using Python, and covers topics such as sorting, searching, graph algorithms, and dynamic programming. The projects are designed to provide hands-on experience with solving real-world problems using algorithms, and include examples such as shortest path algorithms, network flow algorithms, and dynamic programming solutions to optimization problems.

The repository is intended for computer science students and anyone interested in learning about algorithms and data structures. Each project includes a README file with instructions on how to run the code and a brief explanation of the problem and the solution. The code is well-documented and follows best practices for Python coding.

The projects in this repository are designed to be used as a resource for learning and practicing algorithms, and can be used as a supplement to other learning materials such as textbooks and lecture notes. The code is open source and contributions are welcome, making this a collaborative effort to improve understanding and implementation of algorithms.


## ITA ##
**ESERCIZIO 1**
* Implementare una libreria che offre i seguenti
algoritmi di ordinamento:
* insertion sort
* merge sort

* Ogni algoritmo va implementato in modo tale da
poter essere utilizzato su un generico tipo T
* L'implementazione degli algoritmi deve permettere di
specificare il criterio secondo cui ordinare i dati
* Suggerimento: Usare l'interfaccia java.util.Comparator
(o, nel caso di una implementazione C, un puntatore a
funzione)

**ESERCIZIO 1: PRIMO USO**
* File integers.txt con 20 milioni di interi da ordinare
* Gli interi sono scritti di seguito, ciascuno su una riga
* Implementare un'applicazione che, usando ciascuno
degli algoritmi di ordinamento offerti dalla libreria,
ordina in modo crescente gli interi contenuti nel file
* Si misurino i tempi di risposta e si crei una breve
relazione (circa una pagina) in cui si riportano i
risultati ottenuti insieme a un loro commento
* Tempo > 10 minuti interrompere
l'esecuzione e riportare un fallimento dell’operazione
* Commentare nella relazione i risultati

**ESERCIZIO 1: SECONDO USO**
* Implementare una funzione che:
* accetta in input un intero N e un qualunque array A di
interi
* verifica se A contiene due interi la cui somma è
esattamente N
* Funzione DEVE avere complessità �(KlogK) (K= numero di
elementi di A)

* File sums.txt con 100 numeri interi
* Gli interi sono scritti di seguito, ciascuno su una riga
* Implementare un'applicazione che carica in un array A gli interi contenuti nel file integers.txt e, per ciascun intero N contenuto nel file sums.txt, verifica se esso è la somma di due elementi contenuti
in A
* Si aggiunga un commento sulle prestazioni di questo algoritmo alla
relazione scritta per la prima parte dell’esercizio

**ESERCIZIO 2**
* Si consideri il problema di determinare la distanza di edit tra due
stringhe (Edit distance)
* date due stringhe s1 e s2, non necessariamente della stessa
lunghezza, determinare il minimo numero di operazioni necessarie
per trasformare la stringa s2 in s1
* Operazioni disponibili:
  * cancellazione di un carattere
  * inserimento di un carattere

 Esempi:
 "casa" e "cassa" edit distance =1 (1 cancellazione)
 "casa" e "cara" edit distance =2 (1 cancellazione + 1
inserimento)
 "tassa" e "passato" edit distance =4 (3 cancellazioni + 1
inserimento)
 "pioppo" e "pioppo" edit distance =0

* Si implementi una versione ricorsiva della funzione
edit_distance
 Sia la lunghezza di una stringa
 Sia la sottostringa di ottenuta ignorando il primo carattere di

```java
|s|
rest(s) s
|s1| = 0 edit distance(s1, s2) = |s2|
|s2| = 0 edit distance(s1, s2) = |s1|
```

 Altrimenti siano:
```java
dcanc = 1 + edit distance(s1,rest(s2))
dins = 1 + edit distance(rest(s1), s2)
dnoop = (edit distance(rest(s1),rest(s2)) se s1[0] = s2[0]
//Allora
edit distance(s1, s2) = min{dnoop, dcanc, dins}
```


* Si implementi una versione edit_distance_dyn della
funzione, adottando una strategia di programmazione
dinamica
 **Nota**: Le definizioni alle slides precedenti non corrispondono
al modo usuale di definire la distanza di edit, né si prestano ad
una implementazione iterativa particolarmente efficiente.
Sono del tutto sufficienti però per risolvere l'esercizio e sono
quelle su cui dovrete basare la vostra risposta.

**ESERCIZIO 2 - USO DELLE
FUNZIONI**
• File dictionary.txt
• elenco delle parole italiane (molte)
• Parole scritte di seguito, ciascuna su una riga
• File correctme.txt
• citazione di John Lennon
• presenti alcuni errori di battitura

ESERCIZIO 2 - USO DELLE
FUNZIONI
• Si implementi un'applicazione che usa la funzione
edit_distance_dyn per determinare, per ogni
parola w in correctme.txt, la lista di parole in
dictionary.txt con edit distance minima da w
• Si sperimenti il funzionamento dell'applicazione e
si riporti in una breve relazione (circa una pagina) i
risultati degli esperimenti

ESERCIZIO 3
• Si implementi la struttura dati Coda con priorità
• La struttura dati
• deve gestire tipi generici
• consentire un numero qualunque e non noto
a priori di elementi

ESERCIZIO 4
• Si implementi una libreria che realizza la struttura dati Grafo in modo che sia
ottimale per dati sparsi
• La struttura deve consentire di rappresentare sia grafi diretti che grafi non
diretti
• suggerimento: un grafo non diretto può essere rappresentato usando
un'implementazione per grafi diretti in modo che:
• per ogni arco (a,b), etichettato w, presente nel grafo, è presente
nel grafo anche l'arco (b,a), etichettato w
• il grafo dovrà mantenere l'informazione che specifica se è diretto o no

ESERCIZIO 4
• Implementare:
• le funzioni essenziali per la struttura dati
Grafo
• una funzione che restituisce il peso del grafo
• se il grafo non è pesato, la funzione
può terminare con un errore

ESERCIZIO 4 - USO DELLA
LIBRERIA
• Si implementi l'algoritmo di Prim per la determinazione
della minima foresta ricoprente del grafo
• utilizzare la struttura dati Coda con priorità dell’esercizio 3
• Se il grafo è costituito da una sola componente connessa,
l'algoritmo restituirà un albero, altrimenti restituirà una
foresta costituita dai minimi alberi ricoprenti di ciascuna
componente connessa

ESERCIZIO 4 - USO DELLA
LIBRERIA E DI PRIM
• Utilizzare l’algoritmo di Prim sul file italian_dist_graph.csv
• distanze in metri tra varie località italiane
• Formato CSV standard: campi separati da virgole, record separati da fine riga (\n)
• Ogni record contiene i seguenti dati:
• località 1: (tipo stringa) nome della località "sorgente". La stringa può contenere
spazi, non può contenere virgole;
• località 2: (tipo stringa) nome della località "destinazione". La stringa può
contenere spazi, non può contenere virgole;
• distanza: (tipo float) distanza in metri tra le due località.

ESERCIZIO 4 - USO DELLA
LIBRERIA E DI PRIM
• Interpretare le informazioni del file come archi non diretti
• il file è stato creato a partire da un dataset poco accurato
• Dati riportati contengono inesattezze e
imprecisioni
• Risultato atteso: minima foresta ricoprente con 18.640
nodi, 18.637 archi (non orientati) e di peso complessivo
di circa 89.939,913 Km
