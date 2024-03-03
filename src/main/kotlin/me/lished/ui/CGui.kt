package me.lished.ui

import me.lished.module.ModuleManager.moduleMap
import me.lished.ui.impl.ModuleComponent
import net.minecraft.client.gui.GuiScreen

class CGui : GuiScreen() {
    private val x: Int
    private val y: Int
    private val width: Int = 0
    private val height: Int = 0
    private val moduleComponents: MutableList<ModuleComponent> = ArrayList<ModuleComponent>()

    init {
        width = 450
        height = 300
        x = 50
        y = 50

        shit()
    }

    override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
        super.drawScreen(mouseX, mouseY, partialTicks)

        GuiScreen.drawRect(x, y, x+width, y+height, -0xf0f0f1)

        var i = 0
        for (md in moduleComponents) {
            md.updateComponent(x, y)
            md.drawScreen(mouseX, mouseY)
            i += 30
        }
    }

    private fun shit() {
        for ((_, module) in moduleMap) {
            moduleComponents.add(ModuleComponent(module, 0, 0, width - 112, 24))
        }
    }

    public override fun keyTyped(typedChar: Char, keyCode: Int) {
        super.keyTyped(typedChar, keyCode)
    }
}