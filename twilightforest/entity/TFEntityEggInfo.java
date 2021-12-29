// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.util.IChatComponent;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.stats.StatBase;

public class TFEntityEggInfo
{
    public final int spawnedID;
    public final int primaryColor;
    public final int secondaryColor;
    public final StatBase killedStat;
    public final StatBase killedByStat;
    
    public TFEntityEggInfo(final int par1, final int par2, final int par3) {
        this.spawnedID = par1;
        this.primaryColor = par2;
        this.secondaryColor = par3;
        this.killedStat = makeEntityKillStat(this);
        this.killedByStat = makeEntityKilledByStat(this);
    }
    
    public static StatBase makeEntityKillStat(final TFEntityEggInfo eggInfo) {
        final String s = TFCreatures.getStringFromID(eggInfo.spawnedID);
        return (s == null) ? null : new StatBase("stat.killEntity." + s, (IChatComponent)new ChatComponentTranslation("stat.entityKill", new Object[] { new ChatComponentTranslation("entity." + s + ".name", new Object[0]) })).func_75971_g();
    }
    
    public static StatBase makeEntityKilledByStat(final TFEntityEggInfo p_151176_0_) {
        final String s = TFCreatures.getStringFromID(p_151176_0_.spawnedID);
        return (s == null) ? null : new StatBase("stat.entityKilledBy." + s, (IChatComponent)new ChatComponentTranslation("stat.entityKilledBy", new Object[] { new ChatComponentTranslation("entity." + s + ".name", new Object[0]) })).func_75971_g();
    }
}
