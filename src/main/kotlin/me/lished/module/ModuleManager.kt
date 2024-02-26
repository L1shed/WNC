package me.lished.module

import net.weavemc.loader.api.event.KeyboardEvent
import net.weavemc.loader.api.event.SubscribeEvent

object ModuleManager {
    var moduleMap: HashMap<String, Module> = hashMapOf(

    )

    fun getModule(name: String): Module = moduleMap[name] ?: error("Failed to retrieve module $name")

    @SubscribeEvent
    fun onKeyPress(event: KeyboardEvent) {
        if (event.keyState)
            moduleMap.values.find { it.keybind == event.keyCode }?.toggle() ?: return
    }
}