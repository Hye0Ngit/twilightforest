// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import twilightforest.TwilightForestMod;
import twilightforest.item.TFItems;

public class BlockTFMagicLeaves extends akt
{
    int oakColor;
    int canopyColor;
    int mangroveColor;
    private int[] b;
    
    protected BlockTFMagicLeaves(final int i) {
        super(i, 52);
        this.oakColor = 4764952;
        this.canopyColor = 6330464;
        this.mangroveColor = 8431445;
        this.c(0.2f);
        this.h(2);
        this.a(amq.g);
        this.r();
        this.a((tj)TFItems.creativeTab);
    }
    
    public int o() {
        return 16777215;
    }
    
    public int g_(final int par1) {
        return 16777215;
    }
    
    public int b(final ym par1IBlockAccess, final int x, final int y, final int z) {
        int fade = x * 16 + y * 16 + z * 16;
        if ((fade & 0x100) != 0x0) {
            fade = 255 - (fade & 0xFF);
        }
        fade &= 0xFF;
        final float spring = (255 - fade) / 255.0f;
        final float fall = fade / 255.0f;
        final int red = (int)(spring * 106.0f + fall * 251.0f);
        final int green = (int)(spring * 156.0f + fall * 108.0f);
        final int blue = (int)(spring * 23.0f + fall * 27.0f);
        return red << 16 | green << 8 | blue;
    }
    
    public int d() {
        return TwilightForestMod.proxy.getMagicLeavesBlockRenderID();
    }
    
    public int n() {
        return 0;
    }
    
    public boolean c() {
        return false;
    }
    
    public int a(final int i, final int j) {
        return 115;
    }
    
    public boolean a(final ym iblockaccess, final int i, final int j, final int k, final int l) {
        return amq.N.a(iblockaccess, i, j, k, l);
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        par3List.add(new ur(par1, 1, 0));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
}
