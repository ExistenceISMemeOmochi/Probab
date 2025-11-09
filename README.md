# Probab Plugin (for Paper/Spigot)

Probab is a lightweight Minecraft server plugin designed to allow server administrators to modify the drop probability of certain blocks, starting with the ability to adjust the chance of **Gravel dropping Flint**.

## 🚀 Features

* **Adjustable Drop Rates:** Easily modify the chance of specific block drops via an in-game command.
* **Gravel to Flint Control:** Set the exact percentage chance for Gravel to drop Flint when broken.
* **Persistent Configuration:** Drop rates are saved and loaded automatically.

## ⚙️ Setup and Installation

1.  Download the latest release of `Probab-X.X.jar` from the [Releases page](YOUR_GITHUB_RELEASES_LINK).
2.  Place the downloaded `.jar` file into the `plugins/` folder of your Paper or Spigot server.
3.  Restart or reload your server.

## 💻 Commands

The primary command for configuring probabilities is `/probab`.

| Command | Usage | Permission | Description |
| :--- | :--- | :--- | :--- |
| `/probab` | `/probab <feature> <percentage>` | `probab.admin` | Base command for setting probabilities. |

### Example: Setting Gravel to Flint Probability

Use the following command to set the chance of Gravel dropping Flint to **30%**:

