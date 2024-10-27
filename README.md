# Angry Birds Game - README

## Project Overview

This Angry Birds game project, implemented using the LibGDX framework, provides an interactive and immersive gaming experience inspired by the classic Angry Birds gameplay. The game includes multiple screens with easy navigation, enabling players to save progress, resume gameplay, and interact with a polished, custom-themed interface. Buttons are styled with unique fonts and themes for an engaging user experience.

## Project Setup

### Prerequisites

Ensure the following dependencies are installed:
- **Java Development Kit (JDK)**: Version 11 or higher.
- **Gradle**: A build automation tool.

To verify installations, open a terminal and check the versions:
   ```bash
   java -version
   gradle -v
   ```

### Steps:

**1. Clone the Repository**
   Open a terminal and clone the repository to the local machine:
   ```bash
   git clone https://github.com/aryaman-2307/AngryBirdsProject
   cd AngryBirdsProject
   ```

**2. Set Up a Java Development Environment**
   Use any Java IDE like **IntelliJ IDEA** or **Eclipse**, or a simple text editor.

   - **Using an IDE**:
     - Open the project by selecting **File > Open** and navigating to the cloned project folder.
     - Set up the JDK version if prompted.
     - Wait for dependencies to load.

   - **Using the Terminal**:
     - Navigate to the project folder:
       ```bash
       cd AngryBirdsProject
       ```
     - Compile the `.java` files:
       ```bash
       javac -d bin src/*.java
       ```
       Adjust paths if files are organized in subdirectories.

**3. Run the Project**
   - For an IDE, locate the `LWJGL3Launcher` class under `core/src/main/java/com/angrybirds` and click **Run**.
   - For the terminal, navigate to the `bin` directory and execute:
     ```bash
     java -cp bin com.angrybirds.LWJGL3Launcher
     ```

## Project Structure

The game code is organized across multiple classes and screens, each contributing to gameplay functionality. The primary code structure is found under `core/src/main/java/com/angrybirds` and consists of the following:

- **LWJGL3Launcher**: Initializes the game. Acts as the entry point for launching the project using the LWJGL3 framework, setting up the window and managing essential configurations.
  
- **MenuScreen**: The main menu where players can resume a saved game, start a new one, or return to the home screen. Styled buttons enhance the user interface and align with the game’s visual theme.
  
- **PauseScreen**: Pauses the game, offering options to resume, save, or return to the main menu. A semi-transparent overlay and UI elements convey the paused state effectively.
  
- **GameplayScreen**: Contains the core gameplay mechanics, including the slingshot and the physics-based trajectory calculations. Handles player interactions with the slingshot to launch birds at targets, aiming to simulate the classic Angry Birds experience.

Each screen includes UI components such as `TextButton` and `Table`, utilizing LibGDX’s scene2d library for layout management. Custom fonts and button themes are defined in `uiskin.json`, creating a visually cohesive and engaging experience.

### Assets and Resources

The following resources were used to create sprites and images for the game:

- **Sprites and Character Images**:
   - [King Pig](https://angrybirds.fandom.com/wiki/King_Pig?file=KingPigToons-SmileGrin.png)
   - [Minion Pigs](https://angrybirds.fandom.com/wiki/Minion_Pigs/Small_Pig)
   - [Chef Pig](https://angrybirds.fandom.com/wiki/Chef_Pig)
   - [Angry Birds Style Font](https://www.dafont.com/angrybirds.font?psize=s)
- **Game Environment Elements**:
   - [Slingshot](https://angrybirds.fandom.com/wiki/Slingshot)
   - [Wood Blocks](https://angrybirds.fandom.com/wiki/Wood)
   - [Stone Blocks](https://angrybirds.fandom.com/wiki/Stone?file=Toons_Stone_Block.png)
   - [Glass](https://angrybirds.fandom.com/wiki/Glass)
- **Miscellaneous**:
   - [Additional Angry Birds PNGs](https://www.freeiconspng.com/images/angry-birds-png)
   - [Loading Screens](https://angrybirds.fandom.com/wiki/Angry_Birds_(series)/Loading_Screens)

## Testing the Project

To test the game’s functionality:

1. **Run the Project** as per the setup instructions.
2. **Interact with the Game** using screen buttons:
   - **Resume Game**: Resumes the current game session.
   - **Save Game**: Saves progress for later access.
   - **Home**: Returns to the home screen, allowing a new session or navigation to the main menu.

## Brief Explanation of the Code

The code for this Angry Birds game, implemented in Java with the LibGDX framework, provides an interactive, multi-screen experience with essential functionalities such as game pause, save, and resume. The `MenuScreen` allows navigation, the `PauseScreen` provides pause options, and `GameplayScreen` handles core game mechanics. Selecting "Load Game" defaults to Level 1, and "Save Game" currently outputs a placeholder message. Styled buttons and custom fonts enhance the user experience, supporting scalability for future expansion with minimal modifications.

