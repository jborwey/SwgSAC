package HAM;

/**
 * Created by jb039k on 4/10/2017.
 */
public class RegenerationTime {

    /**
     * Regeneration formula for stats is:
     * 4/7*(regenstat*13)/1200
     *
     * modifier = 1.f;
     *
     * if(creature == player) modifier /= 3.0f
     *
     * uint32 healthTick = (uint32) ceil((float) MAX(0, getHAM(
     * CreatureAttribute::CONSTITUTION)) * 13.0f / 1200.0f * 3.0f
     * modifier);
     *
     * http://review.swgemu.com:8080/#/c/2598/1/MMOCoreORB/src/server/zone/objects/creature/CreatureObjectImplementation.cpp
     *
     *
     * ANH
     * regenStat * 13 / 1200 * (4/7)
     */

    public double timeToRegen(double regenStat){
        double postureModifier = 4.0 / 7.0;
        return regenStat * 13.0 / 1200.0  * postureModifier;
    }
}
