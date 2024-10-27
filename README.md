# Angry Birds Game - README

## Project Overview

This Angry Birds project, implemented using the LibGDX framework, provides a static GUI experience inspired by classic Angry Birds gameplay. Currently, only buttons are interactive, allowing basic navigation between screens. Static images represent slingshots, birds, and obstacles without any physics or player-driven interactions. The design focuses on creating a polished user interface with a cohesive visual theme.

## Project Setup

### Prerequisites

Ensure these are installed:
- **Java Development Kit (JDK)**: Version 11 or higher.
- **Gradle**: Build automation tool.

To verify installations:
   ```bash
   java -version
   gradle -v
   ```

### Setup Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/aryaman-2307/AngryBirdsProject
   cd AngryBirdsProject
   ```

2. **Open the Project in a Java IDE**
   - Use **IntelliJ IDEA** or **Eclipse**.
   - Open the project and set up the JDK if prompted.

3. **Run the Project**
   - Locate `LWJGL3Launcher` in `lwjgl3/src/main/java/com/angrybirds/lwjgl3/Lwjgl3Launcher.java` and click **Run**.

## Project Structure

### Directories and Key Files

- **lwjgl3**: Contains `LWJGL3Launcher`, which launches the game with the LWJGL3 backend, managing window setup, display settings, and other core configurations for GUI rendering.
  
- **core/src/main/java/com/angrybirds**: Contains primary classes and screens:
  - **MenuScreen**: Displays the main menu with options to start, save, or load games.
  - **PauseScreen**: Displays a pause overlay with options to resume or save.
  - **LevelScreen**: Displays static game elements (slingshot, obstacles).

- **Assets**: Includes sprites, fonts, and backgrounds for UI styling.

## Current Features and Limitations

- **Static Interface**: Displays static images without physics or interactivity.
- **Button-Only Navigation**: Buttons provide limited functionality, such as navigating to different screens or pausing the game.

## Assets and Resources

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

The code for this Angry Birds game, implemented in Java with the LibGDX framework, provides an interactive, multi-screen experience with essential functionalities such as game pause, save, and resume. The `MenuScreen` allows navigation, the `PauseScreen` provides pause options, and `LevelScreen` handles core game mechanics. Selecting "Load Game" defaults to Level 1, and "Save Game" currently outputs a "Game Saved!" message. Styled buttons and custom fonts enhance the user experience, supporting scalability for future expansion with minimal modifications.

