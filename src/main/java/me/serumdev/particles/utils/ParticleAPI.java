package me.serumdev.particles.utils;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.stream.IntStream;

public class ParticleAPI {

    public static void sendToAll(EnumParticle particle, Location location, boolean longDistance, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        Bukkit.getOnlinePlayers().forEach((players) -> sendToPlayer(players, particle, location, longDistance, offsetX, offsetY, offsetZ, speed, amount));
    }

    public static void sendToAllRgb(Location location, boolean longDistance, RGB rgb, int amount) {
        Bukkit.getOnlinePlayers().forEach((players) -> sendToPlayerRgb(players, location, longDistance, rgb, amount));
    }

    public static void sendToPlayer(Player player, EnumParticle particle, Location location, boolean longDistance, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particle, longDistance, (float) location.getX(), (float) location.getY(), (float) location.getZ(), offsetX, offsetY, offsetZ, speed, amount);
        sendPacket(player, packet);
    }

    public static void sendToPlayerRgb(Player player, Location location, boolean longDistance, RGB rgb, int amount) {
        IntStream.range(0, amount).forEach((count) -> sendToPlayer(player, EnumParticle.REDSTONE, location, longDistance,
                rgb.getRed(), rgb.getGreen(), rgb.getBlue(), 1, 0));
    }

    private static void sendPacket(Player player, Packet<?> packet) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}
