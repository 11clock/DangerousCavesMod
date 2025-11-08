package dangerouscavesmod.patches;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.engine.network.PacketReader;
import necesse.entity.mobs.Mob;
import necesse.entity.particle.Particle;
import necesse.entity.particle.SmokePuffParticle;
import necesse.level.maps.Level;
import net.bytebuddy.asm.Advice;

import java.awt.*;

@ModMethodPatch(target = Mob.class, name = "applySpawnPacket", arguments = {PacketReader.class})
public class SpawnParticlesPatch {

    @Advice.OnMethodExit
    static void onExit(@Advice.This Mob mob) {
        if (mob.isHostile) {
            Level level = mob.getLevel();
            if (level.isClient()) {
                mob.getLevel().entityManager.addParticle(new SmokePuffParticle(level, mob.x, mob.y), Particle.GType.IMPORTANT_COSMETIC);
            }
        }

    }

}
