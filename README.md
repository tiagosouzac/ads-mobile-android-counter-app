# 📱 Android Counter App

A clean and functional Android application developed as a technical challenge. The app features a counter with increment, decrement, and reset logic, along with custom input capabilities.

## 🚀 Features

* **Core Counter:** Increment and decrement the value starting from 0.
* **Safety Logic:** The "Decrease" button is automatically disabled when the counter reaches 0 to prevent negative values.
* **Reset (Challenge 1):** A "Reset" button that restores the counter to zero after user confirmation via an **AlertDialog**.
* **Custom Start Value (Challenge 2):** A unique feature allowing users to input a specific number via an `EditText` to set or start the counter from a custom value.

## 🛠️ Tech Stack

* **Language:** [Kotlin](https://kotlinlang.org/)
* **UI Layout:** `ConstraintLayout`
* **Architecture:** View-based with event listeners.
* **Components:** `TextView`, `Button`, `EditText`, `AlertDialog`.

## 📥 How to Run

1. **Clone the repository:**
```bash
git clone https://github.com/your-username/repository-name.git

```

2. **Open in Android Studio:**
* Go to `File > Open` and select the project folder.

3. **Sync Gradle:**
* Wait for the project to sync and download necessary dependencies.

4. **Run the app:**
* Select an Emulator or a physical device and click the **Run** button (green play icon).

## 📝 Implementation Details

For **Challenge 2**, I implemented a "Set Value" functionality. This allows the user to manually input a number into an `EditText` field. When a valid number is entered, the counter updates instantly to that value, providing more flexibility than a standard 0-start counter.
