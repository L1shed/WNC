package me.lished.setting

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
abstract class Setting {
    abstract val name: String
    abstract val description: String
    abstract val subSettings: Array<Setting>
    fun getConfigName() = name.lowercase().replace(" ", "_")
}

@Serializable
@SerialName("slider")
data class SliderSetting(
    override val name: String,
    override val description: String,
    override val subSettings: Array<Setting>,
    var value: Double,
    val minValue: Double,
    val maxValue: Double,
    val increaseBy: Double
): Setting()

@Serializable
@SerialName("double-slider")
data class DoubleSliderSetting(
    override val name: String,
    override val description: String,
    override val subSettings: Array<Setting>,
    var lowValue: Double,
    var highValue: Double,
    val minValue: Double,
    val maxValue: Double,
    val increaseBy: Double
): Setting() {
    fun getRandom(): Double = Random.nextDouble(minValue, maxValue)
}

@Serializable
@SerialName("checkbox")
data class CheckboxSetting(
    override val name: String,
    override val description: String,
    override val subSettings: Array<Setting>,
): Setting() {
    var enabled: Boolean = false

    fun toggle() {
        enabled = !enabled
    }
}

/**
 * @param modes An array of String pairs, where the first element is the entry name, and the second is the entry element
 */
@Serializable
@SerialName("mode-select")
data class ModeSelectSetting(
    override val name: String,
    override val description: String,
    override val subSettings: Array<Setting>,
    var selected: ModeEntry,
    val modes: Array<Pair<String, ModeEntry>>
): Setting()

@Serializable
data class ModeEntry(
    val name: String,
    val description: String,
    val additionalSettings: Array<Setting> = emptyArray()
) {
    override fun equals(other: Any?): Boolean =
        (other is ModeEntry && other.name == this.name && other.description == this.description)
}