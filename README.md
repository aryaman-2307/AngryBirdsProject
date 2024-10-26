
# Angry Birds Game - README

## Project Overview

This Angry Birds game project is implemented using the LibGDX framework, designed to provide an interactive and immersive gaming experience similar to the classic Angry Birds gameplay. With its multi-screen structure, the game offers a user-friendly interface and includes essential features like saving progress, resuming gameplay, and easy navigation between different screens. Players can navigate using buttons styled with custom fonts and themes, creating a polished and engaging game environment.

## Project Setup

### Prerequisites

Ensure that the following dependencies are installed:
- **Java Development Kit (JDK)**: Version 11 or higher (download [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)).
- **Gradle**: A build automation tool (download and setup instructions [here](https://gradle.org/install/)).

To verify installations, open a terminal and check the versions:
   ```bash
   java -version
   gradle -v
   ```

### Steps

1. **Clone the Repository**
   Clone the repository from version control system and navigate into the project directory.
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Install Dependencies**
   The project’s dependencies will be managed by Gradle. Run the following command to download and set up dependencies:
   ```bash
   gradle build
   ```

3. **Run the Project**
   To start the game, use the Gradle run command. This will initiate the game with all configurations.
   ```bash
   gradle run
   ```

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

The code for this Angry Birds game is implemented in Java, using the LibGDX framework to create an interactive, multi-screen game. The `MenuScreen` class provides an intuitive navigation experience, allowing players to resume or restart the game. The `PauseScreen` adds functionality to pause gameplay, save progress, or return to the main screen. Custom-styled buttons and fonts enhance the UI, making gameplay more immersive and accessible. Designed with scalability in mind, the project structure supports future expansion with minimal modifications.

---
