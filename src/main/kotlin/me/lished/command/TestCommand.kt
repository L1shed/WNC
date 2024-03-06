package me.lished.command

import me.lished.util.addChatMessage
import net.weavemc.loader.api.command.Command

class TestCommand: Command("test") {
    override fun handle(p0: Array<out String>) {
        addChatMessage("dd")
    }
}