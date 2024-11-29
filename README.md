# Angry Birds Project

An immersive **Angry Birds** inspired game developed with **LibGDX** and **Box2D**, blending realistic physics simulation with engaging gameplay mechanics. Players launch birds from a slingshot to topple structures and eliminate pigs in a strategic and visually engaging environment.

---

## 🎯 Objectives

- Launch birds using a slingshot.
- Strategically destroy structures and eliminate all pigs to progress through levels.
- Experience realistic physics-based interactions between game objects.

---

## 🏗️ Features

### 🌌 Game Mechanics
- **Realistic Physics Simulation:**  
  Powered by Box2D, the game provides lifelike bird trajectories, structure destruction, and dynamic interactions.
  
- **Drag-and-Release Slingshot:**  
  Intuitive controls allow players to drag and release birds to control trajectory and velocity.

- **Unique Bird Types:**  
  Each bird type comes with distinct characteristics:
  - **Red Bird:** Standard bird with no special ability.
  - **Yellow Bird:** Accelerates mid-air for added impact force.
  - **Black Bird:** Explodes on impact, causing widespread destruction.

### 🏢 Structures and Pigs
- **Dynamic Structures:**  
  Made up of destructible materials:
  - **Wood, Glass, and Stone:** Each material has unique health and resistance to impacts.
  
- **Interactive Pigs:**  
  Pigs have health bars and are removed when their health depletes. Positioned strategically to challenge the player.

### 🕹️ Gameplay Experience
- **Level Progression:**  
  - Multiple levels with increasing complexity.
  - Diverse layouts for structures and pig placements.
  
- **Win/Lose Conditions:**  
  - **Win:** All pigs are destroyed before running out of birds.
  - **Lose:** Birds are exhausted while pigs remain.

### 🎵 Audio and Visuals
- **Background Music:**  
  Immersive level-specific tracks enhance the experience.
  
- **Dynamic Visuals:**  
  Smooth animations for bird movements, structure collapses, and explosions.

### 🔄 Replayability
- **Reset and Retry:**  
  Players can restart levels to optimize their strategy.

### 🛠️ Debugging Tools
- **Box2DDebugRenderer:**  
  Visualize the physics world for debugging purposes.
  
- **Detailed Logging:**  
  Comprehensive logs for collisions, damage calculations, and game state updates.

---

## 📂 Project Structure

- **`BirdTypes/`:** Classes for different bird types (`RedBird`, `YellowBird`, `BlackBird`), each with unique properties and behaviors.
- **`PigTypes/`:** Classes for managing pigs, including health management and collision detection.
- **`StructureTypes/`:** Classes for structures, supporting various materials like wood, glass, and rock.
- **`Screens/`:** Game screens, including:
  - `LevelScreen`: Core gameplay.
  - `WinScreen`: Displays when the level is completed successfully.
  - `LoseScreen`: Displays when the player loses the level.
- **`Slingshot/`:** Handles bird launching mechanics.

---

## 🕹️ Gameplay Instructions

### Launch Birds
1. **Drag:** Hold and drag the bird backward on the slingshot to aim.
2. **Release:** Let go to launch the bird with calculated velocity and direction.

### Strategy
- Target weak points in structures to maximize destruction.
- Each structure destruction is equal to 100 points.
- Each pig destruction is equal to 1000 points.
---

## 📦 Installation and Setup

### Prerequisites
- **Java Development Kit (JDK):** Version 8 or higher.
- **Gradle:** For building and running the project.
- **LibGDX Framework:** For game development.

### Steps
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/aryaman-2307/AngryBirdsProject.git
   cd AngryBirdsProject
   ```

2. **Open the Project:**
   Open the project in an IDE like IntelliJ IDEA or Eclipse.

3. **Build the Project:**
   ```bash
   ./gradlew build
   ```

4. **Run the Game:**
   ```bash
   ./gradlew desktop:run
   ```

---

## 🔧 Configuration

### Assets
- Located in the `core/assets/` directory:
  - Images (`images/`)
  - Sounds (`sounds/`)
  - Background music (`music/`)

### Level Customization
- Modify the `initializeLevel` method in `LevelScreen` to:
  - Add new bird types.
  - Rearrange pigs and structures.
  - Introduce unique level designs.

---

## 🐛 Troubleshooting

### Common Issues
1. **Birds Falling Off-Screen:**
   - Ensure ground bodies are properly initialized in `createGround()`.

2. **Collision Detection Errors:**
   - Verify that all game entities (`Birds`, `Pigs`, `Structures`) have their `userData` set correctly.

3. **Debugging Tools:**
   - Use the `Box2DDebugRenderer`:
     ```java
     debugRenderer.render(world, camera.combined.scl(PPM));
     ```
   - Enable detailed logs for collisions:
     ```java
     Gdx.app.log("Collision Info", "Body A: " + dataA + ", Body B: " + dataB);
     ```

---

## 👨‍💻 Author

- **Aryaman Gupta**
  - [GitHub Profile](https://github.com/aryaman-2307)

---
