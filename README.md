Plecând de la exemplul comunicării client-server pe bază de sockets prezentat în cadrul laboratorului, realizați o arhitectură ce permite conexiuni multiple (se va realiza cu ajutorul thread-urilor, un thread per conexiune, care va gestiona stream-urile de input și output ale acesteia).
Pentru comunicare, va fi nevoie de crearea unei interfețe Human, cu două metode abstracte:

greeting()
doWork()
Interfața va fi implementată de două clase, Student și Profesor.
Student va avea următoarele câmpuri:

nume
prenume
acronim facultate (ASE, UPB, ATM, UBB, etc.)
vârstă
an de studiu
Profesor va avea următoarele câmpuri:

nume
prenume
acronim facultate
vârstă
materie
De asemenea, fiecare clasă va suprascrie metoda toString() pentru o afișare de forma:

[Prof. <Nume> <Prenume>, Fac. <Acronim>, Vârstă <Varsta>, Materie predată - <Materie>]
[Sd. <Nume> <Prenume>,Anul <An de studiu>, Fac. <Acronim>, Vârsta <Varsta>]
După realizarea conexiunii, clientul va trimite mesaje de forma Tip Valoare_Camp
Ex. Student Dorobantu Gabriel ATM 22 4

Thread-ul va crea o entitate pentru fiecare mesaj cu tipul corespunzător prin apelarea unui constructor și le va stoca într-o listă pusă la dispoziție de Collections Framework. La final, le va sorta după vărsta persoanelor adăugate în colecția respectivă(asta impune ca și Profesor și Student să implementeze interfața Comperable și să suprascrie metoda de comparare).
După sortare, va afișa în consolă rezultatul.