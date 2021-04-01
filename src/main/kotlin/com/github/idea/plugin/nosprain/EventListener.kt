package com.github.idea.plugin.nosprain

import com.github.syari.spigot.api.event.EventRegister
import com.github.syari.spigot.api.event.Events
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageEvent

object EventListener : EventRegister {
    override fun Events.register() {
        event<EntityDamageEvent>(ignoreCancelled = true) {
            val entity =it.entity
            if (entity is Player && it.cause == EntityDamageEvent.DamageCause.FALL && ConfigLoader.isEnable) {
                it.isCancelled = true
            }
            }
        }
    }
