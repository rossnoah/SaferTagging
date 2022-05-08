package net.vanillaplus.safertagging;

import com.SirBlobman.combatlogx.api.event.PlayerPreTagEvent;
import com.SirBlobman.combatlogx.api.event.PlayerReTagEvent;
import com.booksaw.betterTeams.Team;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void beforeTag(PlayerPreTagEvent e) {
        Player tagged = e.getPlayer();
        if (e.getEnemy() instanceof Player) {
            Player enemy = (Player)e.getEnemy();
            if (Team.getTeam(tagged.getUniqueId()) != null && Team.getTeam(enemy.getUniqueId()) != null &&
                    Team.getTeam(tagged.getUniqueId()).equals(Team.getTeam(enemy.getUniqueId())))
                e.setCancelled(true);
        }
    }
    @Override
    public void onDisable() {}
}
