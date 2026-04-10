# Android Stopwatch App

A clean and functional Stopwatch application for Android, developed using Kotlin. This project demonstrates core Android concepts like activity lifecycle management, UI handling, and background task scheduling.

## 🚀 Features
*   **Start/Stop/Reset:** Standard stopwatch controls.
*   **State Persistence:** The timer continues correctly even if you rotate the screen or switch between apps.
*   **Real-time Updates:** Uses a `Handler` and `Looper` for accurate per-second UI updates.
*   **Material Design:** Simple and intuitive user interface.

## 🛠️ Built With
*   **Language:** [Kotlin](https://kotlinlang.org/)
*   **Toolkit:** Android SDK
*   **Architecture:** Activity-based with Lifecycle awareness.

## 📱 How to Run
1. Clone this repository:
2. Open the project in **Android Studio**.
3. Build and run the app on an emulator or a physical device.

## 📝 Concepts Covered
*   Managing `onSaveInstanceState` to prevent data loss.
*   Handling `onPause` and `onResume` for a better user experience.
*   Running background tasks using `Handler.postDelayed`.   
   
