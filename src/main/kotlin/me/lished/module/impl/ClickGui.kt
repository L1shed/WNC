package me.lished.module.impl

import me.lished.module.Module
import me.lished.ui.CGui
import me.lished.util.mc
import org.lwjgl.input.Keyboard


class ClickGui(
    private var cGui: CGui?
): Module(
    "ClickGui",
    "Displays the ClickGUI",
    Keyboard.KEY_RCONTROL,
    arrayOf(

    )
) {
    override fun onEnable() {
        if (cGui == null) {
            cGui = CGui();
        }
        mc.displayGuiScreen(cGui);
        enabled = false
        super.onEnable()
    }
}