package com.github.idea.plugin.nosprain

import com.github.idea.plugin.nosprain.Main.Companion.plugin
import com.github.syari.spigot.api.config.CustomConfig
import com.github.syari.spigot.api.config.config
import com.github.syari.spigot.api.config.type.ConfigDataType
import org.bukkit.command.CommandSender

object ConfigLoader {
    var isEnable = false
    fun load(sender: CommandSender) {
        config(sender) {
            isEnable = get("enable", ConfigDataType.Boolean, default = false)
        }
    }

    fun save() {
        config(null) {
            set("enable", ConfigDataType.Boolean, isEnable,save = true)
        }
    }

    private fun config(sender: CommandSender?, action: CustomConfig.() -> Unit) {
        plugin.config(sender, "config.yml",action = action )
    }
}