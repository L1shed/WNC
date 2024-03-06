package me.lished.module

import me.lished.module.impl.ClickGui
import me.lished.module.impl.KillAura
import me.lished.module.impl.LeftClicker
import me.lished.util.addChatMessage
import net.weavemc.loader.api.event.KeyboardEvent
import net.weavemc.loader.api.event.SubscribeEvent

object ModuleManager {
    var moduleMap: HashMap<String, Module> = hashMapOf(
        Pair("ClickGui", ClickGui(null)),
        Pair("KillAura", KillAura()),
        Pair("LeftClick", LeftClicker()),
    )

    fun getModule(name: String): Module = moduleMap[name] ?: error("Failed to retrieve module $name")

    @SubscribeEvent
    fun onKeyPress(event: KeyboardEvent) {
        if (event.keyState)
            addChatMessage(event.keyCode.toString())
            moduleMap.values.find { it.keybind == event.keyCode }?.toggle() ?: return
    }
}