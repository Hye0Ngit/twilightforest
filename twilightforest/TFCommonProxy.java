// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import twilightforest.client.GuiTFGoblinCrafting;
import cpw.mods.fml.common.network.IGuiHandler;

public class TFCommonProxy implements IGuiHandler
{
    public void doPreLoadRegistration() {
    }
    
    public void doOnLoadRegistration() {
    }
    
    public int getCritterBlockRenderID() {
        return 0;
    }
    
    public int getPlantBlockRenderID() {
        return 0;
    }
    
    public int getComplexBlockRenderID() {
        return 0;
    }
    
    public int getNagastoneBlockRenderID() {
        return 0;
    }
    
    public int getMagicLeavesBlockRenderID() {
        return 0;
    }
    
    public int registerArmorRenderID(final String prefix) {
        return 0;
    }
    
    public yc getClientWorld() {
        return null;
    }
    
    public void spawnParticle(final String particleType, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
    }
    
    public Object getServerGuiElement(final int ID, final qx player, final yc world, final int x, final int y, final int z) {
        return new ContainerTFUncrafting(player.bJ, world, x, y, z);
    }
    
    public Object getClientGuiElement(final int ID, final qx player, final yc world, final int x, final int y, final int z) {
        return new GuiTFGoblinCrafting(player.bJ, world, x, y, z);
    }
}
