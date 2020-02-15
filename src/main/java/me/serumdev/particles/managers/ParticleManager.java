package me.serumdev.particles.managers;

import me.serumdev.particles.particles.HeartParticle;
import me.serumdev.particles.utils.Particle;

import java.util.ArrayList;

public class ParticleManager {

    private static final HashSet<Particle> particles = new HashSet<>();

    public static void addToCache() {
        addParticle(new HeartParticle());
    }

    public static void addParticle(Particle particle) {
        particles.add(particle);
    }

    public static HashSet<Particle> getParticles() {
        return particles;
    }

    public static Particle getParticleByName(String name) {
        return particles.stream().filter((particles) -> particles.getName().equals(name)).findFirst().orElse(null);
    }
}
