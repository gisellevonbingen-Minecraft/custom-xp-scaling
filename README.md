# Custom XP Scaling

[![](https://img.shields.io/modrinth/dt/ijDiJ5t6?style=flat-square&logo=modrinth&color=F6F6F6)](https://modrinth.com/mod/custom-xp-scaling)
[![](https://img.shields.io/curseforge/dt/1018968?style=flat-square&logo=curseforge&color=F6F6F6)](https://www.curseforge.com/minecraft/mc-mods/custom-xp-scaling)

Allow you to customize the XP scaling in the game. You can set the XP scaling to be linear, exponential, or any custom curve you want.

In mod configuration, you can use a math formula to describe the relationship between the level and the XP required to reach the next level.
Available operations and functions can be found [here](https://ezylang.github.io/EvalEx/references/references.html).

Here is an example of what the vanilla XP scaling looks like:
```IF(level >= 31, level * 9 - 158, IF(level >= 16, 5 * level - 38, 2 * level + 7))```

Requires owo-lib to run.

This mod is licensed under the MIT license.
