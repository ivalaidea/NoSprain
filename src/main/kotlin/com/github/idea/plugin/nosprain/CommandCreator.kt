package com.github.idea.plugin.nosprain

import com.github.idea.plugin.nosprain.Main.Companion.plugin
import com.github.syari.spigot.api.command.command
import com.github.syari.spigot.api.command.tab.CommandTabArgument.Companion.argument

object CommandCreator {
    fun register() {
        plugin.command("nosprain") {
            tab {
                argument {
                    tab { addAll("enable", "disable", "reload") }
                }
                execute {
                    when (args.lowerOrNull(0)) {
                        "enable" -> {
                            ConfigLoader.isEnable = true
                            ConfigLoader.save()
                            sender.send("&f落下ダメージを &c無効化 &fしました")
                        }
                        "disable" -> {
                            ConfigLoader.isEnable = false
                            ConfigLoader.save()
                            sender.send("&f落下ダメージを &a有効化 &fしました")
                        }
                        "reload" -> {
                            ConfigLoader.load(sender)
                            sender.send("&fコンフィグを再読み込みしました")
                        }
                        else -> {
                            sender.send("&c/$label [enable, disable, reload]")
                        }
                    }
                }
            }
        }
    }
}