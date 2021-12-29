// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraftforge.fml.common.registry.GameRegistry;
import twilightforest.tileentity.critters.TileEntityTFMoonworm;
import twilightforest.tileentity.critters.TileEntityTFFirefly;
import twilightforest.tileentity.critters.TileEntityTFCicada;
import net.minecraft.advancements.Advancement;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.gui.inventory.GuiFurnace;
import twilightforest.client.GuiTFGoblinCrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.util.math.BlockPos;
import twilightforest.tileentity.TileEntityTFCinderFurnace;
import twilightforest.inventory.ContainerTFUncrafting;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import twilightforest.client.particle.TFParticleType;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class TFCommonProxy implements IGuiHandler
{
    public void preInit() {
    }
    
    public void init() {
    }
    
    public void spawnParticle(final TFParticleType particleType, final double x, final double y, final double z, final double vx, final double vy, final double vz) {
    }
    
    public Object getServerGuiElement(final int id, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        if (id == 1) {
            return new ContainerTFUncrafting(player.field_71071_by, world, x, y, z);
        }
        if (id == 2) {
            return new ContainerFurnace(player.field_71071_by, (IInventory)world.func_175625_s(new BlockPos(x, y, z)));
        }
        return null;
    }
    
    public Object getClientGuiElement(final int id, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        if (id == 1) {
            return new GuiTFGoblinCrafting(player.field_71071_by, world, x, y, z);
        }
        if (id == 2) {
            return new GuiFurnace(player.field_71071_by, (IInventory)world.func_175625_s(new BlockPos(x, y, z)));
        }
        return null;
    }
    
    public ModelBiped getKnightlyArmorModel(final EntityEquipmentSlot armorSlot) {
        return null;
    }
    
    public ModelBiped getPhantomArmorModel(final EntityEquipmentSlot armorSlot) {
        return null;
    }
    
    public ModelBiped getYetiArmorModel(final EntityEquipmentSlot armorSlot) {
        return null;
    }
    
    public ModelBiped getArcticArmorModel(final EntityEquipmentSlot armorSlot) {
        return null;
    }
    
    public ModelBiped getFieryArmorModel(final EntityEquipmentSlot armorSlot) {
        return null;
    }
    
    public boolean doesPlayerHaveAdvancement(final EntityPlayer player, final ResourceLocation advId) {
        if (player instanceof EntityPlayerMP) {
            final Advancement adv = ((EntityPlayerMP)player).func_71121_q().func_191952_z().func_192778_a(advId);
            return adv != null && ((EntityPlayerMP)player).func_192039_O().func_192747_a(adv).func_192105_a();
        }
        return false;
    }
    
    public TileEntityTFCicada getNewCicadaTE() {
        return new TileEntityTFCicada();
    }
    
    public TileEntityTFFirefly getNewFireflyTE() {
        return new TileEntityTFFirefly();
    }
    
    public TileEntityTFMoonworm getNewMoonwormTE() {
        return new TileEntityTFMoonworm();
    }
    
    public void registerCritterTileEntities() {
        GameRegistry.registerTileEntity((Class)TileEntityTFFirefly.class, prefix("firefly"));
        GameRegistry.registerTileEntity((Class)TileEntityTFCicada.class, prefix("cicada"));
        GameRegistry.registerTileEntity((Class)TileEntityTFMoonworm.class, prefix("moonworm"));
    }
    
    protected static ResourceLocation prefix(final String name) {
        return new ResourceLocation("twilightforest", name);
    }
}
