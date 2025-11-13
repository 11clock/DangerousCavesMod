package dangerouscavesmod.patches;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.MobSpawnLocation;
import necesse.entity.mobs.hostile.HostileMob;
import net.bytebuddy.asm.Advice;

@ModMethodPatch(target = MobSpawnLocation.class, name = "checkMaxStaticLightThreshold", arguments = {int.class})
public class MaxStaticLightThresholdPatch {

    @Advice.OnMethodEnter
    static void onEnter(@Advice.This MobSpawnLocation mobSpawnLocation, @Advice.Argument(value = 0, readOnly = false) int maxLight) {
        if (mobSpawnLocation.mob instanceof HostileMob && (mobSpawnLocation.mob.getLevel().isCave)) {
            maxLight = Integer.MAX_VALUE;
        }
    }

}
