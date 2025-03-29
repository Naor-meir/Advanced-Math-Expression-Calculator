# Advanced Math Expression Calculator

This project implements an advanced math expression calculator using a fully object‐oriented approach. The system represents mathematical expressions as a tree structure, allowing for evaluation, simplification, differentiation, and assignment. It makes use of maps to assign variable values during evaluation and is built entirely using OOP principles like interfaces, abstract classes, and polymorphism.

## What I Did

- **Object-Oriented Design:**  
  - **Interfaces:** The `Expression` interface defines the core methods (such as `evaluate()`, `assign()`, `differentiate()`, and `simplify()`).
  - **Abstract Classes:** Classes like `BaseExpression`, `BinaryExpression`, and `UnaryExpression` provide shared functionality and enforce a consistent design for all expression types.
  
- **Expression Tree Structure:**  
  The project represents expressions as a tree:
  - **Leaf Nodes:** Represent variables and numeric constants.
  - **Internal Nodes:** Represent operations (binary or unary), enabling the construction of complex, nested expressions.
  - **Evaluation:** A map (e.g., `Map<String, Double>`) is used to assign values to variables as the tree is recursively evaluated.

- **Modularity & Extensibility:**  
  The design is highly modular, making it easy to add new operations or adjust existing ones with minimal changes to the overall codebase.

## Project Structure

```plaintext
└───src
    ├───Base
    ├───Binary
    ├───elements
    ├───interfaces
    └───Unary
\'\'\'

    
## How to Download

1. **Clone the Repository:**  
   Open your terminal and run:
   ```bash
   git clone https://github.com/yourusername/AdvancedMathExpressionCalculator.git
2. **Navigate to the Project Directory**  
   ```bash
   cd AdvancedMathExpressionCalculator
3. **Open in Your IDE**  
   Use your favorite Java IDE (**IntelliJ IDEA**, **Eclipse**, **VS Code**, etc.) to open the project.

4. **Compile and Run**  
   Ensure you have **JDK 11 or later** installed, compile the project, and run the `Main` class to see a demonstration of the calculator in action.



