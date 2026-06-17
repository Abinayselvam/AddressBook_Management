# Address Book Management System (Maven)

This is a Maven-ized version of the original `AddressBook_Management` IntelliJ project.
The code itself is unchanged — only the project layout and dependency management
were converted to the standard Maven format.

## What changed

- Source files moved from `Address_Book/src/...` into the standard Maven path
  `src/main/java/...`, keeping the same package layout (`Entity`, `Services`,
  `DBConnection`, `API`, and the default package for `AddressBookMain`).
- The hand-added jars in `src/lib/` (`gson`, `opencsv`, `commons-lang3`) and the
  MySQL driver referenced from the IDE module file are now declared as normal
  Maven `<dependency>` entries in `pom.xml`, so they're downloaded automatically
  instead of being committed as binary jars.
- `AddressBookTable.sql` moved to `src/main/resources/sql/` for reference.
- `AddressBook.csv`, `AddressBook.json`, and `db.json` were kept at the project
  root (next to `pom.xml`), since the code reads/writes them using plain
  relative filenames (e.g. `"AddressBook.csv"`), and the working directory is
  the project root when you run via `mvn exec:java` or `java -jar`.
- IDE-specific files (`.idea/`, `.iml`, `out/`) were dropped; they aren't needed
  for a Maven project and IntelliJ regenerates them automatically when you open
  the `pom.xml` as a Maven project.

## Build

```
mvn clean package
```

This produces a runnable, dependency-bundled jar at:

```
target/AddressBookSystem.jar
```

## Run

Either:

```
mvn exec:java
```

or, after `mvn package`:

```
java -jar target/AddressBookSystem.jar
```

Run these from the project root so the relative data files
(`AddressBook.csv`, `AddressBook.json`) are found correctly.

## Notes

- `Services/PayrollDBService.java` connects to a local MySQL database
  (`jdbc:mysql://localhost:3306/addressbook_service`, user `root` / `root`).
  Use `src/main/resources/sql/AddressBookTable.sql` to set up that schema if
  you want to exercise the DB-backed code (`DBConnection/DBTest.java`).
- `Services/AddressBookRestService.java` and `API/Api_Test.java` expect a REST
  server on `http://localhost:3000/contacts` — `db.json` looks like a
  `json-server` fixture for that purpose.
