package me.lished.render

import me.lished.util.addChatMessage
import kotlin.math.sin

data class Color(
    var red: Int,
    var green: Int,
    var blue: Int,
    var alpha: Int
) {
    init {
        require(red in 0..255) { "Red value must be between 0 and 255 " }
        require(green in 0..255) { "Green value must be between 0 and 255 " }
        require(blue in 0..255) { "Blue value must be between 0 and 255 " }
        require(alpha in 0..255) { "Alpha value must be between 0 and 255 " }
    }

    fun toRGBA(): Int = (alpha shl 24) or (red shl 16) or (green shl 8) or blue
}

object Colors {
    val WHITE = Color(255, 255, 255, 255)
    val BLACK = Color(0, 0, 0, 255)
    val RED = Color(255, 0, 0, 255)
    val GREEN = Color(0, 255, 0, 255)
    val BLUE = Color(0, 0, 255, 255)

    /**
     * Retrieves a Color from the gradient created by color1 and color2
     *
     * @param color1 Color represented by 0.0
     * @param color2 Color represented by 1.0
     * @param step Number between 0.0 and 1.0 representing the interpolated color
     */
    fun getColorInGradient(color1: Color, color2: Color, step: Float): Color {
        require(step in 0.0..1.0) { "Step value must be between 0.0 and 1.0" }

        val r = (color1.red * (1 - step) + color2.red * step).toInt()
        val g = (color1.green * (1 - step) + color2.green * step).toInt()
        val b = (color1.blue * (1 - step) + color2.blue * step).toInt()
        val a = (color1.alpha * (1 - step) + color2.alpha * step).toInt()

        return Color(r, g, b, a)
    }

    /**
     * Retrieves a Color from the gradient created by color1 and color2 using System.currentTimeMillis
     *
     * @param color1 Color represented by 0.0
     * @param color2 Color represented by 1.0
     * @param period Total time period for the gradient to complete (in milliseconds)
     */
    fun getColorInGradient(color1: Color, color2: Color, period: Int, offset: Int = 0): Color {
        val elapsedTime = (System.currentTimeMillis() + offset) % period
        val step = elapsedTime.toFloat() / period.toFloat()
        val smoothStep = (1.0 * sin(step * Math.PI)).toFloat()
        return getColorInGradient(color1, color2, smoothStep)
    }
}