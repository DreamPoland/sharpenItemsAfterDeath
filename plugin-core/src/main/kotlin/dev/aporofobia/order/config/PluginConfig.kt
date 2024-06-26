package dev.aporofobia.order.config

import cc.dreamcode.platform.bukkit.component.configuration.Configuration
import eu.okaeri.configs.OkaeriConfig
import eu.okaeri.configs.annotation.Comment
import eu.okaeri.configs.annotation.CustomKey
import eu.okaeri.configs.annotation.Header
import org.bukkit.Material

@Configuration(child = "config.yml")
@Header("## SharpenItemsAfterDeath (Main-Config) ##")
data class PluginConfig(
    @Comment
    @Comment("Debug pokazuje dodatkowe informacje do konsoli. Lepiej wylaczyc. :P")
    @CustomKey("debug")
    var debug: Boolean = true,
    @Comment
    @Comment("Ile % itemkow ma leciec z gracza?")
    var dropPercentage: Double = 50.0,
    @Comment
    @Comment("Jakie itemki maja nie byc brane pod uwage?")
    var ignoredItems: MutableList<Material> = mutableListOf()
) : OkaeriConfig()