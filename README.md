# Game of Life

A Java-based implementation of Conway's Game of Life, showcasing various object-oriented design patterns. This project demonstrates the evolution of a simple implementation through the application of design patterns including State, Singleton, Command, and Observer.

## Features

- **Classic Game of Life Rules**: 
  - Any live cell with two or three live neighbors survives.
  - Any dead cell with exactly three live neighbors becomes a live cell.
  - All other live cells die in the next generation. Similarly, all other dead cells stay dead.

- **Design Patterns Implemented**:
  - **State Pattern**: Abstracted cell states (Alive, Dead) for better flexibility and extensibility.
  - **Singleton Pattern**: Ensured centralized management of certain game components.
  - **Command Pattern**: Delayed execution of cell state changes using commands like `LiveCommand` and `DieCommand`.
  - **Observer Pattern**: Decoupled game logic and UI, enabling multiple views of the game state.

## Getting Started

### Prerequisites
- Java 8 or higher
- Eclipse IDE or any other Java-compatible IDE
- DuDraw library (add as an external library in your build path)

### Installation
1. Import the project into your IDE.
2. Add the `DuDraw.jar` library to your build path.

### Running the Game
1. Go to the `src` folder.
2. Run the `Main.java` file.
3. Use the mouse to toggle cell states and the spacebar to advance the game by one step.

## Design Pattern Breakdown

- **State Pattern**: Encapsulated cell states (`AliveState`, `DeadState`) to handle behavior transitions more effectively.
- **Singleton Pattern**: Managed the game's configuration and state centrally to avoid redundancy.
- **Command Pattern**: Eliminated the need to create a new grid at every step by queuing state changes as commands.
- **Observer Pattern**: Enabled multiple UI components to react to game state changes, separating GUI logic from the core game logic.

