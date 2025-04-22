# 🎮 Tic Tac Toe - Java Swing Edition
A simple, clean, and intuitive implementation of the classic Tic Tac Toe game using Java's Swing library. This GUI-based app lets two players face off in a 3x3 battle of Xs and Os — no internet, no AI, just pure click-for-click human warfare.

## 📸 Preview
- player turn indicator
- responsive game board 
- color-coded win states 
- tie detection

## 📂 Project Structure
```
TicTacToe/
├── .classpath                # Eclipse project classpath settings
├── .project                  # Eclipse project metadata
├── README.md                 # Project documentation
├── bin/                      # Compiled .class files go here
├── settings/                 # Eclipse settings (optional, IDE-managed)
└── src/                      # Java source files
    ├── App.java              # Launcher with main method
    └── TicTacToe.java        # GUI game logic

```

## 🚀 How to Run
### 🧰 Requirements:
- Java Development Kit (JDK) 8 or later
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans, or even good ol' Notepad++)
- Or, run via terminal

### 🏗️ Compile & Run:
```
javac TicTacToe.java
java TicTacToe
```
## 🎯 Features
- ✅ 3x3 interactive game grid
- ✅ Turn-based switching between players X and O
- ✅ Winner detection for: Rows, Columns, Diagonals
- ✅ Tie detection (when all 9 cells are filled)
- ✅ Dynamic UI updates (label changes + color feedback)
- ✅ Basic input validation (no overwriting tiles)

## 🎨 UI Details
- JFrame: The game window
- JPanel: One for the game title/status bar, One for the main 3x3 grid
- JLabel: Displays player turn and win messages
- JButton[][]: Represents each tile of the board, with styles applied
### Visual Feedback
- ❌ Player X = Red
- ⭕ Player O = Red
- ✅ Winning tiles = Green on white
- 🤝 Tie tiles = Yellow on light gray

## ⚠️ Known Limitations
- No AI (Player vs Player only)
- No animations or sounds
- No error message when clicking an already-filled tile — just silently ignores it

## 🧠 Improvements to Come
- 🤖 Implement a simple AI for single-player mode
- 📈 Track scores across games
- 📱 Make it mobile-ready using JavaFX or Android

## 👨‍💻 Author
- 👤 [Karim Hassan](https://github.com/karimhassan-808)
- 📧 [email](mailto:karimhassanbinich@gmail.com)

