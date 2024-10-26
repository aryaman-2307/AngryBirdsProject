# Angry Birds Game README

## Project Setup

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Install Dependencies**
   Make sure you have [Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) and [Gradle](https://gradle.org/install/) installed. You can check if you have them by running:
   ```bash
   java -version
   gradle -v
   ```

3. **Build the Project**
   ```bash
   gradle build
   ```

4. **Run the Project**
   ```bash
   gradle run
   ```

## Testing the Project

To test the game, simply run the project as mentioned above. You can interact with the game using the following commands:
- **Resume Game:** Click on the "Resume" button to continue your last session.
- **Save Game:** Click on the "Save Game" button to save your progress.
- **Home:** Click on the "Home" button to return to the home screen.

## Brief Explanation of the Code

The code implements a basic Angry Birds game using the LibGDX framework. It consists of multiple screens, including a main menu and a pause screen, which provide navigation and interaction capabilities. The `MenuScreen` class allows users to resume their game or return to the home screen, while the `PauseScreen` class includes functionality to resume the game, save progress, and navigate back to the home screen. The game features a user-friendly interface with styled buttons and custom fonts, enhancing the overall gameplay experience.

--- 
