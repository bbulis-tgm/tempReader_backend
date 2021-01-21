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
*TODO*

## Verwendete Technologien
* Java als Entwicklungssprache
* SpringFramework für den WebService
* H2 Datenbank - Memory basiert

## Fortschritt
- [x] Aufsetzen der Datenbank
- [ ] Erstellen der Datenstrukturen in der Datenbank
- [ ] Endpoint fürs Abrufen der Daten
- [ ] Endpoint zum Empfangen von Daten
- [x] Test Enpoint
- [ ] Endpoint für Frontend Kommunikation