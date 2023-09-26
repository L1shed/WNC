package org.example.setting

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
    val maxValue: Double
): Setting()

@Serializable
@SerialName("double-slider")
class DoubleSliderSetting(
    override val name: String,
    override val description: String,
    override val subSettings: Array<Setting>,
    var lowValue: Double,
    var highValue: Double,
    val minValue: Double,
    val maxValue: Double
): Setting() {
    fun getRandom(): Double = Random.nextDouble(minValue, maxValue)
}

@Serializable
@SerialName("checkbox")
class CheckboxSetting(
    override val name: String,
    override val description: String,
    override val subSettings: Array<Setting>,
): Setting() {
    var enabled: Boolean = false

    fun toggle() {
        enabled = !enabled
    }
}