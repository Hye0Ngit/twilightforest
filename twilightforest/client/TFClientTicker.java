// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.client.renderer.Tessellator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.client.particle.EntityFX;
import net.minecraftforge.client.IRenderHandler;
import twilightforest.world.WorldProviderTwilightForest;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.IScheduledTickHandler;

public class TFClientTicker implements IScheduledTickHandler
{
    protected Minecraft mc;
    protected float zLevel;
    private ArrayList particleBuffer;
    private EnumSet ticks;
    
    public TFClientTicker() {
        this.mc = null;
        this.zLevel = -90.0f;
        this.ticks = EnumSet.of(TickType.CLIENT, TickType.RENDER);
        this.particleBuffer = new ArrayList();
    }
    
    @SideOnly(Side.CLIENT)
    public void tickStart(final EnumSet type, final Object... tickData) {
        if (this.mc == null) {
            this.mc = FMLClientHandler.instance().getClient();
        }
        if (type.contains(TickType.CLIENT)) {
            final World world = (World)this.mc.field_71441_e;
            final EntityPlayer player = (EntityPlayer)this.mc.field_71439_g;
            if (world != null && world.field_73011_w instanceof WorldProviderTwilightForest) {
                if (world.field_73011_w.getSkyRenderer() == null) {
                    world.field_73011_w.setSkyRenderer((IRenderHandler)new TFSkyRenderer());
                }
                if (this.mc.field_71456_v != null) {
                    this.mc.field_71456_v.field_73843_a = 0.0f;
                }
            }
            synchronized (this) {
                for (final EntityFX particle : this.particleBuffer) {
                    this.mc.field_71452_i.func_78873_a(particle);
                }
                this.particleBuffer.clear();
            }
        }
    }
    
    public void tickEnd(final EnumSet type, final Object... tickData) {
        if (type.contains(TickType.RENDER)) {
            this.renderBossHealth();
        }
    }
    
    public EnumSet ticks() {
        return this.ticks;
    }
    
    public String getLabel() {
        return "Twilight Forest Client Tick Loop";
    }
    
    public int nextTickSpacing() {
        return 1;
    }
    
    private void renderBossHealth() {
    }
    
    public void drawTexturedModalRect(final int par1, final int par2, final int par3, final int par4, final int par5, final int par6) {
        final float var7 = 0.00390625f;
        final float var8 = 0.00390625f;
        final Tessellator var9 = Tessellator.field_78398_a;
        var9.func_78382_b();
        var9.func_78374_a((double)(par1 + 0), (double)(par2 + par6), (double)this.zLevel, (double)((par3 + 0) * var7), (double)((par4 + par6) * var8));
        var9.func_78374_a((double)(par1 + par5), (double)(par2 + par6), (double)this.zLevel, (double)((par3 + par5) * var7), (double)((par4 + par6) * var8));
        var9.func_78374_a((double)(par1 + par5), (double)(par2 + 0), (double)this.zLevel, (double)((par3 + par5) * var7), (double)((par4 + 0) * var8));
        var9.func_78374_a((double)(par1 + 0), (double)(par2 + 0), (double)this.zLevel, (double)((par3 + 0) * var7), (double)((par4 + 0) * var8));
        var9.func_78381_a();
    }
    
    public void addParticle(final EntityFX particle) {
        synchronized (this) {
            this.particleBuffer.add(particle);
        }
    }
}
