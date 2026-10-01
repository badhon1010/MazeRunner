# Maze Runner 🏃‍♂️

A 2D tile-based adventure game built with Java Swing and AWT. Explore mazes, collect keys, open doors, and find hidden chests in this classic retro-style RPG game!

## 🎮 Features
- **Classic 2D Graphics:** 16x16 tiles scaled up (48x48) for a perfect retro feel.
- **Smooth Gameplay:** Custom game loop running at a smooth 60 FPS.
- **Game States:** Includes Title Screen, Play, Pause, and Map Selection states.
- **Interactive Objects:** Find and interact with objects like Keys, Doors, and Chests.
- **Collision Detection:** Solid tile and object collision system.
- **Multi-Map Support:** Transition between different maps and worlds seamlessly.
- **Audio:** Background music and sound effects (SE) for actions like picking up items.
- **Network Ready:** Foundational structure for multiplayer (Client/Server sockets).

## 🛠️ Built With
- **Language:** Java (JDK 8 or higher recommended)
- **GUI Framework:** Java Swing (`JFrame`, `JPanel`) & AWT (`Graphics2D`)

## 🚀 Getting Started

### Prerequisites
- Make sure you have the Java Development Kit (JDK) installed on your system.
- An IDE like IntelliJ IDEA, Eclipse, or VS Code (optional but recommended).

### How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/badhon1010/MazeRunner.git
   ```
2. Open the project in your favorite IDE.
3. Locate the main entry point at `src/Main.java`.
4. Compile and Run `Main.java`.
5. Enjoy the game!

## 🕹️ Controls
- **W / Up Arrow:** Move Up
- **A / Left Arrow:** Move Left
- **S / Down Arrow:** Move Down
- **D / Right Arrow:** Move Right
- *(Add more controls here as you implement them, e.g., 'P' to Pause or 'Enter' to select menu items)*

## 📂 Project Structure
- `src/`: Contains all the Java source code.
  - `Main.java` & `GamePanel.java`: Core engine and window setup.
  - `Player.java` & `Entity.java`: Player character and entity logic.
  - `TileManager.java`: Renders the map from text files.
  - `CollisionChecker.java`: Handles solid boundary and object collisions.
  - `Sound.java`: Audio management.
- `src/maps/`: Text files defining the layout of the game maps.
- `src/materials/`, `src/objects/`, `src/tiles/`: Image sprites for rendering characters and environment.
- `src/sound/`: `.wav` files for music and sound effects.

---
*Developed by Badhon Saha*

*Created as a personal project to explore 2D game development in Java.*
