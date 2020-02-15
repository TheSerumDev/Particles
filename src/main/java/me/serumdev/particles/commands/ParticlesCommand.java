package me.serumdev.particles.commands;

import me.serumdev.particles.Particles;
import me.serumdev.particles.particles.MenuInventory;
import me.serumdev.particles.utils.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ParticlesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        if (!(cs instanceof Player))
            return true;

        Player player = (Player) cs;

        if (!(player.hasPermission("youtube.command.particle")))
            return true;

        if (args.length == 0) {
            new MenuInventory().open(player);
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
        } else {
            player.sendMessage(Particles.PREFIX + "§e/particles");
        }
        return true;
    }
}
