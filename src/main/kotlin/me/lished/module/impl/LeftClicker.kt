package me.lished.module.impl

import me.lished.module.Module
import me.lished.setting.DoubleSliderSetting
import me.lished.util.addChatMessage
import net.weavemc.loader.api.event.SubscribeEvent
import net.weavemc.loader.api.event.TickEvent
import org.lwjgl.input.Keyboard

class LeftClicker(
    private val cps: DoubleSliderSetting = DoubleSliderSetting("CPS", "Clicks per second", emptyArray(),
        0.0, 20.0, 1.0, 20.0, 0.1
    ),
): Module(
    "LeftClicker",
    "Automatically clicks for you",
    Keyboard.KEY_NONE,
    arrayOf(
        cps
    )
) {
    @SubscribeEvent
    fun onTick(event: TickEvent.Post) {
        enabled = true
        addChatMessage("d")
    }
}