package org.example.util

import net.minecraft.client.Minecraft
import net.minecraft.util.ChatComponentText

val mc = Minecraft.getMinecraft()

/**
 * Adds a chat message to the client's chat box
 */
fun addChatMessage(message: String) = mc.thePlayer.addChatMessage(ChatComponentText(message))

/**
 * Sends a chat message to the Server
 */
fun sendChatMessage(message: String) = mc.thePlayer.sendChatMessage(message)