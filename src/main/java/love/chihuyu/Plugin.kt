package love.chihuyu

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin
import java.time.Instant
import java.util.*

class Plugin : JavaPlugin(), Listener {

    companion object {
        lateinit var plugin: JavaPlugin
    }

    init {
        plugin = this
    }

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onHorn(e: PlayerInteractEvent) {
        val item = e.item ?: return
        val player = e.player

        if (item.type != Material.GOAT_HORN) return
        player.banPlayer("Used goat horn (1hour)", Date.from(Instant.ofEpochSecond(Instant.now().epochSecond + (60 * 60))))
    }
}