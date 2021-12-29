// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;

public class BlockTFTowerWood extends amj
{
    private static final int TEX_PLAIN = 128;
    private static final int TEX_BANDED = 129;
    
    public BlockTFTowerWood(final int id) {
        super(id, 128, agb.d);
        this.c(100.0f);
        this.b(35.0f);
        this.a(amj.e);
        this.a(th.b);
    }
    
    public int a(final int side, final int meta) {
        switch (meta) {
            default: {
                return 128;
            }
            case 1: {
                return 129;
            }
        }
    }
    
    public void a(final int par1, final th par2CreativeTabs, final List par3List) {
        par3List.add(new um(par1, 1, 0));
        par3List.add(new um(par1, 1, 1));
    }
    
    public int b(final int meta) {
        return meta;
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
}
