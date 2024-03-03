package me.lished.ui

abstract class Component(
    var x: Int,
    var y: Int,
    var width: Int,
    var height: Int
) {
    abstract fun drawScreen(mouseX: Int, mouseY: Int)
    abstract fun mouseClicked(mouseX: Int, mouseY: Int, mouse: Int)
    abstract fun keyTyped(typedChar: Char, key: Int)

    fun updateComponent(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    // pasted from sassan's client
    fun isMouseOver(x: Int, y: Int): Boolean {
        return ((x > this.x)
                && (x < (this.x + width))
                && (y > this.y)
                && (y < (this.y + height)))
    }
}