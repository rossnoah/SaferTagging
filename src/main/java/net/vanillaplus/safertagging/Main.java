package net.vanillaplus.safertagging;

import com.SirBlobman.combatlogx.api.event.PlayerPreTagEvent;
import com.SirBlobman.combatlogx.api.event.PlayerReTagEvent;
import com.booksaw.betterTeams.Team;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this,this);
    }
    @EventHandler
    public void beforeTag(PlayerPreTagEvent e) {
        Player tagged = e.getPlayer();
        if (e.getEnemy() instanceof Player) {
            Player enemy = (Player) e.getEnemy();
            if (Team.getTeam(tagged) != null&&Team.getTeam(enemy)!=null) {
                if(Team.getTeam(tagged).equals(Team.getTeam(enemy))){

            e.setCancelled(true);
        }
    }
    }
    }

    @EventHandler
    public void reTag(PlayerReTagEvent e){

        e.setCancelled(true);



        Player tagged = e.getPlayer();
        if (e.getEnemy() instanceof Player) {
            Player enemy = (Player) e.getEnemy();
            if (Team.getTeam(tagged) != null&&Team.getTeam(enemy)!=null) {
                if(Team.getTeam(tagged).equals(Team.getTeam(enemy))){

                    e.set(true);
                }
            }
        }
    }
    public void onDisable() {
        // Plugin shutdown logic
    }
}
