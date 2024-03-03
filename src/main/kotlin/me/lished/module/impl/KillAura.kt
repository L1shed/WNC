package me.lished.module.impl

import net.weavemc.loader.api.event.SubscribeEvent
import net.weavemc.loader.api.event.TickEvent
import me.lished.module.Module
import me.lished.setting.*
import me.lished.util.addChatMessage
import org.lwjgl.input.Keyboard

class KillAura(
    private val blatantMode: ModeEntry = ModeEntry("Blatant", "Blatantly attacks entities around you"),
    private val silentMode: ModeEntry = ModeEntry("Silent", "Silently attacks entities around you"),
    private val mode: ModeSelectSetting = ModeSelectSetting("Mode", "Selection of Kill Aura modes",
        emptyArray(), blatantMode, arrayOf(
            blatantMode.name to blatantMode,
            silentMode.name to silentMode
        )
    ),
    aps: DoubleSliderSetting = DoubleSliderSetting("APS", "Attacks per second", emptyArray(),
        4.0, 20.0, 4.0, 20.0, 0.1
    ),
    range: SliderSetting = SliderSetting("Range", "Range in blocks for attacking", emptyArray(),
        1.0, 1.0, 6.0, 0.1
    ),
    smoothing: SliderSetting = SliderSetting("Smoothing", "Amount of smoothing for rotations", emptyArray(),
        0.0, 0.0, 10.0, 0.1
    ),
    switchInterval: SliderSetting = SliderSetting("Interval", "Interval at which targets will be switched in milliseconds",
        emptyArray(), 0.0, 0.0, 1000.0, 100.0
    ),
    switch: CheckboxSetting = CheckboxSetting("Switch", "Switch targets at a set rate",
        arrayOf(
            switchInterval
        )
    )
): Module(
    "KillAura",
    "Automatically attacks nearby entities",
    Keyboard.KEY_R,
    arrayOf(
        mode,
        aps,
        range,
        smoothing,
        switch,
    )
) {
    @SubscribeEvent
    fun onTick(event: TickEvent.Post) {
        addChatMessage("obb")
        when (mode.selected) {
            blatantMode -> {
                // blatant logic
            }
            silentMode -> {
                // silent logic
            }
        }
    }
}