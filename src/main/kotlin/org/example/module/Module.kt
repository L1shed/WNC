package org.example.module

import kotlinx.serialization.Serializable
import net.weavemc.loader.api.event.EventBus
import org.example.setting.Setting

@Serializable
open class Module(
    val name: String,
    val description: String,
    var keybind: Int,
    val settings: Array<Setting>
) {
    var enabled: Boolean = false

    fun toggle() {
        enabled = !enabled
        if (enabled)
            onEnable()
        else
            onDisable()
    }

    open fun onEnable() {
        EventBus.subscribe(this)
    }

    open fun onDisable() {
        EventBus.unsubscribe(this)
    }

    fun getConfigName() = name.lowercase().replace(" ", "_")
}