// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import net.minecraftforge.client.IRenderHandler;
import twilightforest.client.renderer.TFSkyRenderer;
import twilightforest.world.WorldProviderTwilightForest;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import java.util.ArrayList;
import cpw.mods.fml.common.IScheduledTickHandler;

public class TFClientTicker implements IScheduledTickHandler
{
    protected ats mc;
    protected float zLevel;
    private ArrayList<bed> particleBuffer;
    private EnumSet<TickType> ticks;
    
    public TFClientTicker() {
        this.mc = null;
        this.zLevel = -90.0f;
        this.ticks = EnumSet.of(TickType.CLIENT, TickType.RENDER);
        this.particleBuffer = new ArrayList<bed>();
    }
    
    @SideOnly(Side.CLIENT)
    public void tickStart(final EnumSet<TickType> type, final Object... tickData) {
        if (this.mc == null) {
            this.mc = FMLClientHandler.instance().getClient();
        }
        if (type.contains(TickType.CLIENT)) {
            final abv world = (abv)this.mc.f;
            final ue player = (ue)this.mc.h;
            if (world != null && world.t instanceof WorldProviderTwilightForest) {
                if (world.t.getSkyRenderer() == null) {
                    world.t.setSkyRenderer((IRenderHandler)new TFSkyRenderer());
                }
                if (this.mc.r != null) {
                    this.mc.r.a = 0.0f;
                }
            }
            synchronized (this) {
                for (final bed particle : this.particleBuffer) {
                    this.mc.k.a(particle);
                }
                this.particleBuffer.clear();
            }
        }
    }
    
    public void tickEnd(final EnumSet<TickType> type, final Object... tickData) {
        if (type.contains(TickType.RENDER)) {
            this.renderBossHealth();
        }
    }
    
    public EnumSet<TickType> ticks() {
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
        final bfn var9 = bfn.a;
        var9.b();
        var9.a((double)(par1 + 0), (double)(par2 + par6), (double)this.zLevel, (double)((par3 + 0) * var7), (double)((par4 + par6) * var8));
        var9.a((double)(par1 + par5), (double)(par2 + par6), (double)this.zLevel, (double)((par3 + par5) * var7), (double)((par4 + par6) * var8));
        var9.a((double)(par1 + par5), (double)(par2 + 0), (double)this.zLevel, (double)((par3 + par5) * var7), (double)((par4 + 0) * var8));
        var9.a((double)(par1 + 0), (double)(par2 + 0), (double)this.zLevel, (double)((par3 + 0) * var7), (double)((par4 + 0) * var8));
        var9.a();
    }
    
    public void addParticle(final bed particle) {
        synchronized (this) {
            this.particleBuffer.add(particle);
        }
    }
}
