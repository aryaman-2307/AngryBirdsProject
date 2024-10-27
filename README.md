
# Angry Birds Game - README

## Project Overview

This Angry Birds game project is implemented using the LibGDX framework, designed to provide an interactive and immersive gaming experience similar to the classic Angry Birds gameplay. With its multi-screen structure, the game offers a user-friendly interface and includes essential features like saving progress, resuming gameplay, and easy navigation between different screens. Players can navigate using buttons styled with custom fonts and themes, creating a polished and engaging game environment.

## Project Setup

### Prerequisites

Ensure that the following dependencies are installed:
- **Java Development Kit (JDK)**: Version 11 or higher.
- **Gradle**: A build automation tool.

To verify installations, open a terminal and check the versions:
   ```bash
   java -version
   gradle -v
   ```

### Steps:

**1. Clone the Repository**
   Open a terminal and clone the repository to the local machine using:
   ```bash
   git clone https://github.com/aryaman-2307/AngryBirdsProject
   cd AngryBirdsProject
   ```

**2. Set Up a Java Development Environment**
   Any Java IDE like **IntelliJ IDEA** or **Eclipse**, or just a simple text editor can be used.

   - **Using an IDE**:
     - Open the project in IDE by selecting **File > Open** and navigating to the cloned project folder.
     - The IDE should recognize the project structure. It might ask to set up a JDK version; select the appropriate one.
     - Wait for any dependencies to load.

   - **Using the Terminal**:
     - Navigate to the project folder:
       ```bash
       cd AngryBirdsProject
       ```
     - Compile the `.java` files:
       ```bash
       javac -d bin src/*.java
       ```
       Ensure the paths in the project align with this command; if files are organized in subdirectories, adjust paths accordingly.

**3. Run the Project**
   - For an an IDE, look for a `Main` or `App` class with a `main` method and click **Run**.
   - For the terminal, navigate to the `bin` directory and execute the `main` class, such as:
     ```bash
     java -cp bin Main
     ```
     Replace `Main` with the actual main class name if it’s different.

## Project Structure

The game code is organized across multiple classes and screens, each serving a specific purpose in the gameplay experience:

- **MenuScreen**: Serves as the main menu where players can resume a saved game or return to the home screen. It uses custom button styles to enhance the UI experience.
  
- **PauseScreen**: This screen pauses the game, providing options to resume gameplay, save progress, or return to the home screen. It features a semi-transparent overlay that signifies the paused state, enhancing visual clarity.

Each screen includes UI components like `TextButton` and `Table`, using LibGDX's scene2d library to manage layouts and button styles. Custom fonts and button themes, defined in `uiskin.json`, create an intuitive and polished interface that enhances gameplay immersion.

## Testing the Project

You can test the game functionality by following these steps:
1. **Run the Project** as detailed in the setup instructions above.
2. **Interact with the Game** using the following screen buttons:
   - **Resume Game**: Resumes the current game session.
   - **Save Game**: Saves your current progress for later access.
   - **Home**: Returns to the home screen, where you can start a new session or return to the menu.

## Brief Explanation of the Code

The code for this Angry Birds game is implemented in Java, using the LibGDX framework to create an interactive, multi-screen game. The MenuScreen class provides an intuitive navigation experience, allowing players to resume or restart the game. The PauseScreen adds functionality to pause gameplay, save progress, or return to the main screen. Currently, selecting "Load Game" defaults to Level 1, and "Save Game" only prints a placeholder message. Custom-styled buttons and fonts enhance the UI, making gameplay more immersive and accessible. Designed with scalability in mind, the project structure supports future expansion with minimal modifications.

---
