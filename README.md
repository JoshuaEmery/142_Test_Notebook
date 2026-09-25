# CS 142 · Assignment 01: Hello, World! and Variables

[![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://codespaces.new/JoshuaEmery/142_Test_Notebook?quickstart=1)

In this assignment you'll run your first Java code, practice with variables, and write two small Java programs.
**You don't need to install anything.** Everything runs in your browser in GitHub Codespaces.

---

## Getting started

1. On your assignment repository's GitHub page, click **Code → Codespaces → Create codespace on main**.
2. Wait a minute or two the first time. Java, Jupyter, and VS Code extensions are being set up for you.
3. When VS Code opens in your browser, you're ready. This README and the Part 1 notebook open automatically.

> **Tip:** When you're done working, close the tab. Your codespace stops on its own after a while, and your work is saved.
> To come back later, go to **Code → Codespaces** and open the same codespace instead of creating a new one.

---

## Part 1: Notebook practice (not graded by the autograder)

Open **`notebooks/01-hello-variables.ipynb`**.

- Run cells with **Shift + Enter**, top to bottom.
- If asked to choose a kernel, pick **Jupyter Kernel… → Java**.
- Complete every cell marked **✏️ Your turn**, and fix the three mistakes in section 4.

## Part 2: Java programs (autograded)

### 2a. `src/main/java/HelloWorld.java`
Make the program print exactly:

```
Hello, World!
```

### 2b. `src/main/java/Variables.java`
Follow the TODO steps in the file. When finished, the program prints exactly:

```
Course: CS 142
Credits: 5
Meal cost: 40.0
Tip: 8.0
Total: 48.0
```

You must use variables and **calculate** the tip and total. Typing `8.0` or `48.0` directly into your code won't pass.

### Running your programs
- Click **Run** above `main` in the editor, **or**
- in the terminal: `java src/main/java/HelloWorld.java`

---

## Checking your work

Run the same tests your instructor uses. In the terminal:

```bash
mvn test
```

Or click the **Testing** (🧪 flask) icon on the left sidebar and press ▶.

Every test that fails tells you what it expected. Read the message, fix your code, and run again.

## Submitting

Save your work to GitHub with **commit and push**:

1. Click the **Source Control** icon on the left (it looks like a branch).
2. Type a short message, like `Finished assignment 01`.
3. Click **Commit**, then **Sync Changes** (or **Push**).

After you push, the **Actions** tab on GitHub runs the autograder. A ✅ green check means all tests pass. A ❌ means open the run to see which tests failed.

You can commit and push as many times as you want. Your latest push is what gets graded.

---

## Rubric

| Part | Points |
|---|---|
| Part 1 notebook: all "Your turn" cells completed, mistakes fixed | 4 |
| `HelloWorld` prints exactly `Hello, World!` | 2 |
| `Variables`: correct five lines of output | 5 |
| `Variables`: correct variable names and types, tip and total calculated | 4 |
| **Total** | **15** |

---

<details>
<summary><strong>Instructor notes</strong></summary>

- **Environment:** `.devcontainer/devcontainer.json` builds Java 21 + Maven + Python/Jupyter + the [JJava](https://github.com/dflib/jjava) Java notebook kernel (pinned to `1.0a8`) plus the VS Code Java and Jupyter extensions. Setup commands live in `.devcontainer/setup.sh`.
- **Autograding:** `.github/workflows/autograde.yml` runs `mvn test` on every push and publishes a test report. Tests are in `src/test/java/`.
- **Reuse:** In repo **Settings → General**, check **Template repository**. Students can then click **Use this template** (or you can hand out copies with an assignment tool) and every copy gets the same environment.
- **Faster startup:** Consider enabling **Codespaces prebuilds** (Settings → Codespaces) for the template so students don't wait on the setup script.
- **Notebook caveat:** Notebooks run on JShell, so classes and `main` are optional there. It also forgives a missing semicolon on the last line of a cell. Section 5 of the notebook bridges the gap: students define a full `class` with `main` in a cell and call `main` themselves, before Part 2 moves them to real `.java` files.
- The Open-in-Codespaces badge above points at this repo. Update it if you copy this template.

</details>
