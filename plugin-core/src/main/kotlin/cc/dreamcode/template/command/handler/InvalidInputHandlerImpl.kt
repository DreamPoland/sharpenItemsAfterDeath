package cc.dreamcode.template.command.handler

import cc.dreamcode.command.DreamSender
import cc.dreamcode.command.bukkit.BukkitSender
import cc.dreamcode.command.handler.InvalidInputHandler
import cc.dreamcode.template.config.MessageConfig
import cc.dreamcode.utilities.builder.MapBuilder
import eu.okaeri.injector.annotation.Inject
import org.bukkit.World
import org.bukkit.entity.Player

class InvalidInputHandlerImpl @Inject constructor(
    private val messageConfig: MessageConfig
): InvalidInputHandler {

    override fun handle(dreamSender: DreamSender<*>, requiringClass: Class<*>, input: String) {
        val bukkitSender = dreamSender as BukkitSender

        if (requiringClass.isAssignableFrom(Player::class.java)) {
            this.messageConfig.playerNotFound.send(bukkitSender.handler)
            return
        }

        if (requiringClass.isAssignableFrom(World::class.java)) {
            this.messageConfig.worldNotFound.send(bukkitSender.handler)
            return
        }

        this.messageConfig.invalidFormat.send(bukkitSender.handler, MapBuilder<String, Any>()
            .put("input", input)
            .build())
    }
}
