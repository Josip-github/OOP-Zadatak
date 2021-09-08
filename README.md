OPIS ZADATKA:

Temeljem prilozene CSV datoteke( u Source paketu) napraviti prigodni objektno orijentirani model u kojem ce se pohraniti vrijednosti ucitane iz navedene datoteke.
U prilozenom CSV cjeniku definirani su podaci o plovilu (ID, Naziv, Godiste), kao i pripadajuce TJEDNE cijene za pojedine periode u godini.
Nakon sto je cjenik ucitan, izracunati cijenu najma za definirani ID plovila, datum polaska te trajanje najma. 
ID plovila, datum polaska i trajanje najma se definiraju kao parametri prilikom poziva aplikacije.

Znaci krajnji cilj je pozivom naredbe "java -jar projekt.jar 2 20.06.2021 5" program vraca izracun cijene najma plovila ID 2 za polazni datum 20.06.2021 u trajanju od 5 dana.

Napomene:
- stupci u CSV datoteci su razdvojeni sa , delimiterom

- struktura cjenika se smatra fiksnom, tj. uvijek su samo 3 polja za opis plovila i imamo fiksno 4 stupca za periode cijena; 
Fiksan broj stupaca za periode cijena je samo da bi se olaksalo ucitavanje podataka iz datoteke, 
ali objektno orijentirani model mora biti postavljen na nacin da je varijabilan broj perioda cijena.

- u prvom retku CSV datoteke prva 3 stupca su prazna, nakon cega slijede periodi za koje su definirane cijene najma. Period je definiran u formatu datum od - do

- moze se ocekivati proizvoljan broj redaka/plovila u cjeniku
