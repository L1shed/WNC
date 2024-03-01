package me.lished.ui.impl

import me.lished.module.Module
import me.lished.ui.Component
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.Gui

class ModuleComponent(private val module: Module, x: Int, y: Int, width: Int, height: Int) :
    Component(x, y, width, height) {
    override fun drawScreen(mouseX: Int, mouseY: Int) {
//        RenderUtils.drawRect(x, y, width, height, -0xe0e0e1)
//        RenderUtils.drawString(
//            Minecraft.getMinecraft().fontRendererObj,
//            module.name,
//            x + 6,
//            (y + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT.toFloat() / 2 + 4) as Int,
//            if (module.isEnabled()) -0xb0b1 else -1
//        )
        Gui.drawRect(x, y, x + width, y + height, -0xe0e0e1)
        Minecraft.getMinecraft().fontRendererObj.drawString(
            module.name,
            x + 6,
            (y + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT.toFloat() / 2 + 4) as Int,
            if (module.enabled) -0xb0b1 else -1
        )
    }

    override fun mouseClicked(mouseX: Int, mouseY: Int, mouse: Int) {
        if (isMouseOver(mouseX, mouseY)) {
            when (mouse) {
                0 -> module.toggle()
                1 -> {}
                2 -> {}
            }
        }
    }

    override fun keyTyped(typedChar: Char, key: Int) {
    }
}