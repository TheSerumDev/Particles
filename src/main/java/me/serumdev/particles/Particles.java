package me.serumdev.particles;

import me.serumdev.particles.commands.ParticlesCommand;
import me.serumdev.particles.listeners.InventoryClickListener;
import me.serumdev.particles.managers.ParticleManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Particles extends JavaPlugin {

    private static Particles instance;

    public static final String PREFIX = "§8[§eParticles§8] §r";

    @Override
    public void onEnable() {
        instance = this;

        init();
    }

    @Override
    public void onDisable() {

    }

    private void init() {
        getCommand("particles").setExecutor(new ParticlesCommand());

        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    public static Particles getInstance() {
        return instance;
    }
}
