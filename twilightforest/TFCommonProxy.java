// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.client.model.ModelBiped;
import twilightforest.client.GuiTFCinderFurnace;
import twilightforest.client.GuiTFGoblinCrafting;
import twilightforest.inventory.ContainerTFCinderFurnace;
import twilightforest.inventory.ContainerTFUncrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
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
    
    public int getPedestalBlockRenderID() {
        return 0;
    }
    
    public int getThornsBlockRenderID() {
        return 0;
    }
    
    public int getKnightmetalBlockRenderID() {
        return 0;
    }
    
    public int getHugeLilyPadBlockRenderID() {
        return 0;
    }
    
    public int getCastleMagicBlockRenderID() {
        return 0;
    }
    
    public int registerArmorRenderID(final String prefix) {
        return 0;
    }
    
    public World getClientWorld() {
        return null;
    }
    
    public void spawnParticle(final World world, final String particleType, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
    }
    
    public Object getServerGuiElement(final int id, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        if (id == 1) {
            return new ContainerTFUncrafting(player.field_71071_by, world, x, y, z);
        }
        if (id == 2) {
            return new ContainerTFCinderFurnace(player.field_71071_by, world, x, y, z);
        }
        return null;
    }
    
    public Object getClientGuiElement(final int id, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        if (id == 1) {
            return new GuiTFGoblinCrafting(player.field_71071_by, world, x, y, z);
        }
        if (id == 2) {
            return new GuiTFCinderFurnace(player.field_71071_by, world, x, y, z);
        }
        return null;
    }
    
    public ModelBiped getKnightlyArmorModel(final int armorSlot) {
        return null;
    }
    
    public ModelBiped getPhantomArmorModel(final int armorSlot) {
        return null;
    }
    
    public ModelBiped getYetiArmorModel(final int armorSlot) {
        return null;
    }
    
    public ModelBiped getArcticArmorModel(final int armorSlot) {
        return null;
    }
    
    public ModelBiped getFieryArmorModel(final int armorSlot) {
        return null;
    }
    
    public void doBlockAnnihilateEffect(final World worldObj, final int blockX, final int blockY, final int blockZ) {
    }
}
