# Java OOP Projects

Small Java programs from my object-oriented programming coursework. Each folder is a standalone project.

| Project | What it is | Concepts |
|---|---|---|
| [`programmer-calculator`](programmer-calculator) | Swing GUI calculator with decimal, binary and hexadecimal modes and bitwise operations | Swing (`JFrame`, layout managers), event handling (`ActionListener`), inheritance (`extends JFrame`) |
| [`tic-tac-toe`](tic-tac-toe) | Console Tic-Tac-Toe, human vs. computer (the computer plays random moves) | 2D arrays, `enum`, game loop, input handling |
| [`reading-materials-inheritance`](reading-materials-inheritance) | Class hierarchy for reading materials (book, novel, textbook, magazine, journal) | Inheritance, `super`, method overriding, polymorphism |

## How to run

You need a JDK installed. In a project folder:

```bash
javac *.java
java ProgrammerCalculator      # programmer-calculator
java Main                      # tic-tac-toe
java ReadingMaterialDriver     # reading-materials-inheritance
```

## Project notes

### Programmer Calculator
- Choose Decimal, Binary or Hexadecimal; digit and letter buttons are enabled or disabled to match the mode.
- Operations: `+ - * /`, `And`, `Or`, `XOR`, `<<`, `>>`.
- Values are 32-bit `int`s.

**Known limitations**
- The `NOT` button is not implemented yet.
- Division by zero and empty or invalid input are not handled.

### Tic-Tac-Toe
- You choose who starts; the computer picks a random free cell.
- **Possible improvement:** replace the random move with a minimax player.

### Reading Materials
- `ReadingMaterial` is the base class. `Book` and `Magazine` extend it; `Novel` and `Textbook` extend `Book`; `TechnicalJournal` extends `ReadingMaterial`.
- Each subclass overrides `printDetails()` and calls `super.printDetails()` first.
- `ReadingMaterialDriver` stores every type in a `ReadingMaterial` variable to show polymorphism.

<!-- TODO (your words): one or two sentences on what you learned from these projects -->

## Planned

- Card game
