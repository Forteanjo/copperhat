# CopperHat: A Mesmerizing 3D Point Cloud Visualization

**CopperHat** is an Android application that showcases a visually captivating 3D point cloud visualization, rendered dynamically using Jetpack Compose's `Canvas` API. This project demonstrates how to leverage mathematical functions and modern Android development practices to create unique and interactive graphics within your apps.

## Features

*   **Dynamic Point Cloud:**  The application generates a complex point cloud, creating a 3D-like effect on a 2D canvas.
*   **Mathematical Foundation:** Utilizes trigonometric functions (sine, cosine) and π (pi) to calculate point positions, forming an intricate pattern.
*   **Jetpack Compose:** Built with the declarative UI toolkit, Jetpack Compose, for a modern and efficient UI.
*   **Canvas API:** Leverages Compose's `Canvas` to draw directly on the screen, providing full control over rendering.
* **Code Clarity:** The code is written with clear variable names, constants, and comments.
* **Efficient rendering:** The code uses sequences, making the generation of points more efficient.

## Getting Started

### Prerequisites

*   Android Studio (latest version recommended)
*   Android SDK (API level 26 or higher)
*   Kotlin (latest version recommended)

### Installation

1.  **Clone the Repository:**
2.  **Open in Android Studio:**
    *   Launch Android Studio.
    *   Select "Open an Existing Project."
    *   Navigate to the cloned repository and select the root directory.
3.  **Build and Run:**
    *   Click the "Sync Project with Gradle Files" button.
    *   Select your target device/emulator.
    *   Click the "Run" button.

## How It Works

The `CopperHat` composable function is the core of the visualization. Here's a high-level overview of its logic:

1.  **Canvas Setup:** A `Canvas` composable is created to provide a drawing surface.
2.  **Constants:**
    *  `degreesToRadians`: A constant to convert degrees to radians
    *  `rotationAngleRadians`: The angle of rotation, in radians
    *  `centerX`: the center x of the canvas
    *  `centerY`: the center y of the canvas
    *  `maxRadius`: The maximum radius used to generate points
3.  **Point Generation (Sequence):**
    *   A `Sequence` is used to generate `Offset` objects lazily. This means points are computed only when needed, optimizing memory usage.
    *   Nested loops iterate through a range of radii (`radius`) and angles (`theta`)
    *   `x`, `y`, and `z` are calculated using trigonometric functions, defining the 3D-like coordinates.
    *   `projectedX` and `projectedY` transform the 3D coordinates into 2D screen positions.
    *   `yield()` is used to emit each `Offset` object into the sequence.
4.  **Drawing:**
    *   `drawPoints()` is called with the generated list of `Offset` to render the point cloud on the `Canvas`.
    * `drawPoints()` is an API from the Canvas, used to draw points.
    * **PointMode.Points:** Defines that each point will be drawn as an individual point.
    * **Color.White:** Defines the color of the points.
    * **strokeWidth = 1f:** Defines the width of each point.

## Potential Enhancements

*   **Interactivity:** Add touch/drag gestures to rotate or zoom the point cloud.
*   **Color Dynamics:** Experiment with changing point colors based on their distance from the center or other criteria.
*   **Parameterization:** Make the point density, rotation angle, and other visual aspects configurable.
*   **Performance:** Explore using `Path` instead of individual points to draw for improved rendering.
* **More Complex Patterns:** Implement different trigonometric equations to generate more complex patterns.
* **Use of the Canvas Size:** Adapt the generated points depending on the Canvas size.

## Project Structure
    Copper_Hat/ 
    ├── app/ │ 
             └── src/ │ 
                      └── main/ │ 
                                ├── kotlin/ │ │ 
                                            └── sco/ │ │ 
                                                     └── carlukesoftware/ │ │ 
                                                                          └── copperhat/ │ │    
                                                                                         ├── MainActivity.kt # Entry point of the app │ │ 

    └── ui/ │ │ 
            └── components/ │ │ 
                            └── CopperHat.kt # The CopperHat Composable │ │ 
                                                                        └── theme/ │ │ 
                                                                                   └── ... # Compose theming │ 
    └── res/ # Resources │ └── AndroidManifest.xml # App Manifest │ └── ... # other files ├── build.gradle.kts └── ...


**Enjoy exploring the fascinating world of 3D graphics with Jetpack Compose!**

## Contributing

Contributions are welcome! If you find a bug or have an idea for a new feature, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Credits

## Contact

Donald McCaskey - [forteanjo@sky.com](mailto:forteanjo@sky.com)

Project Link: [https://github.com/forteanjo/battery_information](https://github.com/forteanjo/battery_information)
