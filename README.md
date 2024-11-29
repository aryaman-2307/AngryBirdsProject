# Angry Birds Project

A custom implementation of the popular game **Angry Birds**, developed using **LibGDX** and the **Box2D physics engine**. This project focuses on realistic physics-based gameplay, where players launch birds to destroy structures and eliminate pigs.

## 🚀 Features

- **Physics Simulation:** Utilizes Box2D for realistic bird trajectories, collisions, and object destruction.
- **Multiple Bird Types:** Includes unique bird abilities such as explosive black birds and fast yellow birds.
- **Dynamic Level Design:** Supports varied structures and pig placements across levels.
- **Collision Handling:** Interactive collision detection for damage calculations and object destruction.
- **Slingshot Mechanics:** Drag-and-release mechanics for launching birds.
- **Audio Effects:** Background music and sound effects for an engaging experience.
- **Win/Lose Conditions:** Monitors game progression and determines outcomes based on pigs destroyed and birds remaining.

---

## 🛠️ Built With

- [LibGDX](https://libgdx.com/): Game development framework.
- [Box2D](https://box2d.org/): Physics engine for realistic gameplay.
- Java: Primary programming language for the project.

---

## 📂 Project Structure

### Key Components

- **`BirdTypes/`**  
  Contains classes for different bird types (`RedBird`, `YellowBird`, `BlackBird`), each with unique attributes and behaviors.

- **`PigTypes/`**  
  Manages the pig entities, including health tracking and damage handling.

- **`StructureTypes/`**  
  Represents destructible structures, such as wood, glass, and stone.

- **`Screens/`**  
  Includes game screens like `LevelScreen`, `WinScreen`, and `LoseScreen`.

- **`Slingshot/`**  
  Handles slingshot mechanics for launching birds.

---

## 🕹️ Gameplay

1. **Objective:**  
   Launch birds to destroy structures and eliminate all pigs.

2. **Controls:**  
   - Drag the bird on the slingshot to aim.
   - Release to launch the bird with calculated velocity.
   - Observe the physics-based destruction of structures and pigs.

3. **Win/Lose Conditions:**  
   - **Win:** All pigs are destroyed.
   - **Lose:** No pigs are destroyed before running out of birds.

---

## 📦 Installation and Setup

### Prerequisites
- **Java Development Kit (JDK)** 8 or higher.
- **Gradle** for building the project.
- **LibGDX Framework.**

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/aryaman-2307/AngryBirdsProject.git
   cd AngryBirdsProject
   ```

2. Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse).

3. Build the project using Gradle:
   ```bash
   ./gradlew build
   ```

4. Run the project:
   ```bash
   ./gradlew desktop:run
   ```

---

## 🔧 Configuration

- **Assets:**  
  Game assets such as images and sounds are located in the `core/assets/` directory. Ensure these paths are correct in your code.

- **Level Design:**  
  Modify the `initializeLevel` method in `LevelScreen` to create new levels with custom structures, pigs, and bird arrangements.

- **Collision Handling:**  
  Update the `handleCollisions` method to add new collision responses.

---

## 🐛 Debugging

- Use the `Box2DDebugRenderer` for visualizing the physics world:
  ```java
  debugRenderer.render(world, camera.combined.scl(PPM));
  ```

- Check logs for collision-related errors:
  ```java
  Gdx.app.log("Collision Info", "Body A: " + dataA + ", Body B: " + dataB);
  ```
  
---

## 👨‍💻 Author

- **Aryaman Gupta**  
  - GitHub: [aryaman-2307](https://github.com/aryaman-2307)


