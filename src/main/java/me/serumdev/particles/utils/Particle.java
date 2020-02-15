package me.serumdev.particles.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public interface Particle {

    void init();

    void initPlayer(Player player);

    void stop();

    String getName();

    Material getMaterial();
}
