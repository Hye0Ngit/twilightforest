// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import twilightforest.item.TFItems;

public class BlockTFTowerWood extends amq
{
    private static final int TEX_PLAIN = 128;
    private static final int TEX_BANDED = 129;
    
    public BlockTFTowerWood(final int id) {
        super(id, 128, agi.d);
        this.c(100.0f);
        this.b(35.0f);
        this.a(amq.e);
        this.a((tj)TFItems.creativeTab);
    }
    
    public int b(final ym par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.h(x, y, z);
        if (meta == 0) {
            int value = x * 31 + y * 15 + z * 33;
            if ((value & 0x100) != 0x0) {
                value = 255 - (value & 0xFF);
            }
            value &= 0xFF;
            value >>= 1;
            value |= 0x80;
            return value << 16 | value << 8 | value;
        }
        return 16777215;
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
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        par3List.add(new ur(par1, 1, 0));
        par3List.add(new ur(par1, 1, 1));
    }
    
    public int b(final int meta) {
        return meta;
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
}
