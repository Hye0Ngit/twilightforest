// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
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
            final zv world = (zv)this.mc.e;
            final sk player = (sk)this.mc.g;
            if (world != null && world.t instanceof WorldProviderTwilightForest) {
                if (world.t.getSkyRenderer() == null) {
                    world.t.setSkyRenderer((IRenderHandler)new TFSkyRenderer());
                }
                this.mc.w.a = 0.0f;
            }
            synchronized (this) {
                for (final ben particle : this.particleBuffer) {
                    this.mc.j.a(particle);
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
        final bfx var9 = bfx.a;
        var9.b();
        var9.a((double)(par1 + 0), (double)(par2 + par6), (double)this.zLevel, (double)((par3 + 0) * var7), (double)((par4 + par6) * var8));
        var9.a((double)(par1 + par5), (double)(par2 + par6), (double)this.zLevel, (double)((par3 + par5) * var7), (double)((par4 + par6) * var8));
        var9.a((double)(par1 + par5), (double)(par2 + 0), (double)this.zLevel, (double)((par3 + par5) * var7), (double)((par4 + 0) * var8));
        var9.a((double)(par1 + 0), (double)(par2 + 0), (double)this.zLevel, (double)((par3 + 0) * var7), (double)((par4 + 0) * var8));
        var9.a();
    }
    
    public void addParticle(final ben particle) {
        synchronized (this) {
            this.particleBuffer.add(particle);
        }
    }
}
