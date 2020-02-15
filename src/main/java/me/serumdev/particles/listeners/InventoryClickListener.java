package me.serumdev.particles.listeners;

import me.serumdev.particles.Particles;
import me.serumdev.particles.managers.ParticleManager;
import me.serumdev.particles.utils.Particle;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getCurrentItem() == null || event.getCurrentItem().getItemMeta() == null || event.getCurrentItem().getItemMeta().getDisplayName() == null || event.getCurrentItem().getType() == Material.AIR)
            return;

        Player player = (Player) event.getWhoClicked();

        if (!(event.getInventory().getName().equals("§eParticles")))
            return;

        event.setCancelled(true);

        String name = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());

        Particle particle = ParticleManager.getParticleByName(name);
        particle.initPlayer(player);

        player.sendMessage(Particles.PREFIX + "§7Du hast die Particle §e" + particle.getName() + " §7ausgewählt!");
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);

        player.closeInventory();
    }
}
