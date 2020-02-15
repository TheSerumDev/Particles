package me.serumdev.particles.particles;

import me.serumdev.particles.Particles;
import me.serumdev.particles.objects.Coordinate;
import me.serumdev.particles.utils.Particle;
import me.serumdev.particles.utils.ParticleAPI;
import me.serumdev.particles.utils.RGB;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class HeartParticle implements Particle {

    @Override
    public void init() {

    }

    @Override
    public void initPlayer(Player player) {
        Location location = player.getLocation();
        ArrayList<Coordinate> coords = new ArrayList<>();

        for (double x = -1.0D; x < 1.1D; x += 0.1D) {
            double sqrt = Math.sqrt(1 - Math.pow(x, 2));
            double v = sqrt + Math.cbrt(Math.pow(x, 2));
            double v1 = Math.cbrt(Math.pow(x, 2)) - sqrt;

            System.out.println(String.format("[%f/%f]", x, v));
            System.out.println(String.format("[%f/%f]", x, v1));

            coords.add(new Coordinate(x, v));
            coords.add(new Coordinate(x, v1));
        }

        coords.add(new Coordinate(1.0D, 1.0D));

        new BukkitRunnable() {
            @Override
            public void run() {
                coords.forEach((coords) -> ParticleAPI.sendToAllRgb(new Location(player.getWorld(), location.getX() + coords.getX(), location.getY() + coords.getY(), location.getZ()), true, new RGB(255, 0, 0), 3));
            }
        }.runTaskTimer(Particles.getInstance(), 0, 1);
    }

    @Override
    public void stop() {

    }

    @Override
    public String getName() {
        return "Heart";
    }

    @Override
    public Material getMaterial() {
        return Material.CAKE;
    }
}
