package dangerouscavesmod.patches;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.MobSpawnLocation;
import net.bytebuddy.asm.Advice;

@ModMethodPatch(target = MobSpawnLocation.class, name = "checkMaxLightThreshold", arguments = {int.class})
public class MaxLightThresholdPatch {

    @Advice.OnMethodEnter
    static void onEnter(@Advice.This MobSpawnLocation mobSpawnLocation, @Advice.Argument(value = 0, readOnly = false) int maxLight) {
        if (mobSpawnLocation.mob.isHostile && (mobSpawnLocation.mob.getLevel().isCave)) {
            maxLight = Integer.MAX_VALUE;
        }
    }

}
