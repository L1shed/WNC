package module

import kotlinx.serialization.Serializable
import net.weavemc.loader.api.event.EventBus
import setting.Setting

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

    fun onEnable() {
        EventBus.subscribe(this)
    }

    fun onDisable() {
        EventBus.unsubscribe(this)
    }

    fun getConfigName() = name.lowercase().replace(" ", "_")
}