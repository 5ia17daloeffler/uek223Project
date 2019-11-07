# M223: Punchclock
Dies ist eine Beispielapplikation für das Modul M223.

## Loslegen
Folgende Schritte befolgen um loszulegen:
1. Sicherstellen, dass JDK 12 installiert und in der Umgebungsvariable `path` definiert ist.
1. Ins Verzeichnis der Applikation wechseln und über die Kommandozeile mit `./gradlew bootRun` oder `./gradlew.bat bootRun` starten
1. Unittest mit `./gradlew test` oder `./gradlew.bat test` ausführen.
1. Ein ausführbares JAR kann mit `./gradlew bootJar` oder `./gradlew.bat bootJar` erstellt werden.

Folgende Dienste stehen während der Ausführung im Profil `dev` zur Verfügung:
- REST-Schnittstelle der Applikation: http://localhost:8081
- Dashboard der H2 Datenbank: http://localhost:8081/h2-console



GIT Verlauf Bild in resources abgespeichert

In theorie:
- Registrieren und Anmelden von Mitgliedern
- Erstellen und beitreten von Events
- Bearbeiten und löschen von Users

Registration & login seite auf `http://localhost:8081/index.html`
Registrieren und dan Anmelden

Admin als Beispielperson im script.js erstellt.
- als admin anmelden mit:
    username: admin
    password: password


Im Postman User tested:
Sign in:
    http://localhost:8081/users/sign-up
    body: {
          	"username": "user",
          	"password": "1234"
          }

Login:
    http://localhost:8081/login
    body:{
            "username": "user",
            "password": "1234"
         }
         
get Users:
    http://localhost:8081/users
    header: Key             Value (Authorization fon login)
            Authorization   Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9
                            .eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTczOTg2NDY5fQ.
                            ldlNkh2Jdp39RmoUg-1byAbLhdBd3BSGw-mRSws804WR_yZ9H1Ia5opEuSkQe-
                            vSetx6zkY93fZj5tF--RGeLA