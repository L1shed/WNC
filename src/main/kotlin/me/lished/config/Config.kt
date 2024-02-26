package me.lished.config

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import me.lished.module.Module
import me.lished.module.ModuleManager
import me.lished.setting.CheckboxSetting
import me.lished.setting.DoubleSliderSetting
import me.lished.setting.Setting
import me.lished.setting.SliderSetting
import me.lished.util.addChatMessage
import java.io.File

class Config(
    val name: String
) {
    private val serializer = Json {
        serializersModule = SerializersModule {
            polymorphic(Setting::class) {
                subclass(SliderSetting::class)
                subclass(DoubleSliderSetting::class)
                subclass(CheckboxSetting::class)
            }
        }
        ignoreUnknownKeys = true
    }

    /**
     * Saves the configuration file
     */
    fun save() {
        val file = File("$name.config")
        file.createNewFile()

        ModuleManager.moduleMap.forEach { (name, module) ->
            try {
                val serialized = serializer.encodeToString(module)
                file.writeText(serialized)
            } catch (ex: Exception) {
                addChatMessage("Failed to save module $name in configuration ${this.name}")
            }
        }
    }

    /**
     * Loads the configuration file
     */
    fun load() {
        val file = File("$name.config")

        if (file.exists()) {
            try {
                val deserialized: SerializableConfig = serializer.decodeFromStream(file.inputStream())
                ModuleManager.moduleMap = deserialized.modules.associateBy { it.getConfigName() } as HashMap<String, Module>
            } catch (ex: Exception) {
                addChatMessage("Failed to load $name configuration")
            }
        }
    }

    @Serializable
    private data class SerializableConfig(
        val modules: Array<Module>
    )
}