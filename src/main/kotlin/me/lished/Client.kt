package me.lished

import net.weavemc.loader.api.ModInitializer
import net.weavemc.loader.api.event.EventBus
import net.weavemc.loader.api.event.StartGameEvent

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
    }
}