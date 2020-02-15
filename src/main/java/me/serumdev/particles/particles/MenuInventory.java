package me.serumdev.particles.particles;

import me.serumdev.particles.managers.ParticleManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.concurrent.atomic.AtomicReference;

public class MenuInventory {

    private static final Inventory inventory = Bukkit.createInventory(null, 54, "§eParticles");

    public MenuInventory() {
        AtomicReference<ItemStack> particleStack = new AtomicReference<>();
		
        ParticleManager.getParticles().forEach((particle -> {
            particleStack.set(new ItemStack(particle.getMaterial(), 1));
            ItemMeta particleMeta = particleStack.get().getItemMeta();
        
			particleMeta.setDisplayName("§e" + particle.getName());
            
			particleStack.get().setItemMeta(particleMeta);

        }));
        
		inventory.addItem(particleStack.get());
    }

    public void open(Player player) {
        player.openInventory(inventory);
    }
}
