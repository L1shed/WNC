package me.lished

import me.lished.command.TestCommand
import me.lished.module.ModuleManager
import me.lished.util.addChatMessage
import me.lished.util.mc
import net.weavemc.loader.api.ModInitializer
import net.weavemc.loader.api.command.CommandBus
import net.weavemc.loader.api.event.EventBus
import net.weavemc.loader.api.event.KeyboardEvent
import net.weavemc.loader.api.event.StartGameEvent
import org.lwjgl.input.Keyboard

class Client: ModInitializer {
    override fun preInit() {
        /** Anything that needs to be initialized before Minecraft has been loaded
         *
         * IMPORTANT! Do not instantiate any classes that reference Minecraft in preInit
         * This will result with issues, as it is forcing premature class loading on Minecraft classes
         */

        EventBus.subscribe(StartGameEvent.Post::class.java) {
            init()
        }
    }

    private fun init() {
        /**
         * Anything that needs to be initialized after Minecraft has been loaded
         *
         * It is safe to instantiate classes that reference Minecraft here
         */


//        EventBus.subscribe(ModuleManager)
//        CommandBus.register(TestCommand())
//
//        EventBus.subscribe(
//            KeyboardEvent::class.java
//        ) { e: KeyboardEvent ->
//            if (mc.currentScreen == null && e.keyState) {
//                addChatMessage("Key Pressed: " + Keyboard.getKeyName(e.keyCode)
//                )
//            }
//        }
//
//        repeat(1000) {
//            Thread.sleep(10000)
//            addChatMessage("INITIALIZED")
//            println("INITIALIZED")
//        }
    }
}