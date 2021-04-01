package com.github.idea.plugin.nosprain

import com.github.syari.spigot.api.string.toColor
import org.bukkit.command.CommandSender

fun CommandSender.send(message: String) {
    sendMessage("&b[NoSprain] &r$message".toColor())
}