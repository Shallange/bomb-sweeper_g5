# BombSweeper (Minesweeper)

A terminal version of the classic Minesweeper game built in Java.  
The player interacts through the terminal by choosing cells to reveal while avoiding hidden bombs.
In game bombs are revealed not necessarily mines, hence the name change 

---

## Structure

- `Main.java` – Entry point
- `Game.java` – Main game loop and player interaction
- `Difficulty.java` – Handles difficulty levels and bomb ratios
- `BombPlacer.java` – Randomly places bombs
- `Table.java` – Displays and updates the game grid
- `InputHandler.java` – Reads and validates user input
- `RatioCalculator.java` – Calculates bomb density
- `Color.java` & `Emoji.java` – Visual enhancements in the terminal

---

## Design Choices

The structure is built around small, focused classes.
This made it easier to test and change individual parts without breaking the rest of the code.
We left out features like recursive reveal for now, but the base logic supports adding them in a later version.

---

## How to Run

Clone the project or download the zip file
go in src fil via terminal and run these commands

```bash
  cd src
```

```bash
  javac Main.java
```

```bash
  java Main
```
