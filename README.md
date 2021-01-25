# Temperature Reader
## Beschreibung Projekt
Service welcher Temperatur-Messwerte empfängt und diese in eine Datenbank
zwischenspeichert. 
Daten können dann von einer öffentlichen Schnittstelle abgerufen werden.

## Beschreibung Repository
Das Repository umfasst nur das Backend. 
* Empfangen der Daten über HTTP Schnittstelle
* Abrufen der Daten über HTTP Schnittstelle
* Speicherung der Daten in SQL Datenbank

## Lauffähig machen
Keine `*.jar` exportiert.  
**Keine Lauffähige Version derzeit**

## Verwendete Technologien
* Java als Entwicklungssprache
* SpringFramework für den WebService
* H2 Datenbank - Memory basiert

## Endpoints
Alle Endpoints werden mit `/sensors` aufgerufen
- **GET** `/all` Gibt alle in der Datenbank gespeicherten Werte zurück
- **GET** `/findByDate` Sucht nach einem speziellen Datum und gibt diese Werte als Liste zurück
- **POST** `/add` Fügt einen Wert der Datenbank hinzu

### Response/Request Struktur
[Beispiel Responses](RESPONSE.md)

## Fortschritt
- [x] Aufsetzen der Datenbank
- [x] Erstellen der Datenstrukturen in der Datenbank
- [x] Endpoint fürs Abrufen der Daten
- [x] Endpoint zum Empfangen von Daten
- [ ] Test Enpoint
- [ ] Endpoint für Frontend Kommunikation
- [ ] Error handling durchgeführt
- [ ] Testcases geschrieben und ausgeführt