package me.lished.module.impl

import me.lished.module.Module
import me.lished.ui.CGui
import org.lwjgl.input.Keyboard

class ClickGui(
    private val cGui: CGui
): Module(
    "ClickGui",
    "Displays the ClickGUI",
    Keyboard.KEY_RCONTROL,
    arrayOf(

    )
) {
}