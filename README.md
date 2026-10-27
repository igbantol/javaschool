# Java School Projects

A collection of Java assignments organized by quarter and topic. All source lives
under `src/` using standard Java package naming (lowercase, dotted packages).

## Structure

```
src/
  quarter1/
    hello/            Hello.java                       (quarter1.hello)
    caroop/           Car.java, Main.java              (quarter1.caroop)
    croop/            CR.java, Main.java               (quarter1.croop)
    guesser/          Guesser.java                     (quarter1.guesser)
    scannerpkg/       CR.java, Main.java               (quarter1.scannerpkg)
    stringwithscanner/ Main.java                       (quarter1.stringwithscanner)
  quarter2/
    employee/         Main.java                        (quarter2.employee)
    product/          Product.java, Main.java          (quarter2.product)
    studentgrades/    StudentGrades.java               (quarter2.studentgrades)
```

## Conventions

- **Packages**: all lowercase (`quarter1.caroop`, `quarter1.guesser`).
- **Classes**: PascalCase (`Car`, `Guesser`, `CR`).
- **Build artifacts** (`.class`, `out/`, `build/`) are git-ignored.

## Build & Run

Compile everything:

```powershell
javac -d build (Get-ChildItem -Recurse -Path src -Filter *.java).FullName
```

Run a specific program:

```powershell
java -cp build quarter1.hello.Hello
java -cp build quarter1.caroop.Main
java -cp build quarter1.croop.Main
java -cp build quarter1.guesser.Guesser
java -cp build quarter1.scannerpkg.Main
java -cp build quarter1.stringwithscanner.Main
java -cp build quarter2.employee.Main
java -cp build quarter2.product.Main
java -cp build quarter2.studentgrades.StudentGrades
```

## Notes

- `quarter1.guesser.Guesser` requires a login (`igbantol` / `hashedpassword123`).
- `quarter2.studentgrades.StudentGrades` asks for the number of students and subjects, then prompts for each grade via Scanner.
- Each project is an independent `main` program; they do not depend on one another.
