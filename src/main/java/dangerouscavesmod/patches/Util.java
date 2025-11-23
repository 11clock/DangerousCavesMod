package dangerouscavesmod.patches;

import necesse.entity.mobs.Mob;
import necesse.entity.mobs.hostile.*;

public class Util {
    public static boolean isHostile(Mob mob) {
        return (mob.isHostile || mob instanceof HostileMob);
    }
}
