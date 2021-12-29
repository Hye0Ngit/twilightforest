// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;

public class BlockTFMazestone extends amj
{
    private static final int TEX_PLAIN = 80;
    private static final int TEX_BRICK = 81;
    private static final int TEX_PILLAR = 82;
    private static final int TEX_DECO = 83;
    private static final int TEX_CRACKED = 84;
    private static final int TEX_MOSSY = 85;
    private static final int TEX_MOSAIC = 86;
    private static final int TEX_BORDER = 87;
    
    public BlockTFMazestone(final int id, final int texture) {
        super(id, texture, agb.e);
        this.c(100.0f);
        this.b(5.0f);
        this.a(amj.h);
        this.a(th.b);
    }
    
    public int a(final int side, final int meta) {
        switch (meta) {
            default: {
                return 80;
            }
            case 1: {
                return 81;
            }
            case 2: {
                return (side > 1) ? 82 : 80;
            }
            case 3: {
                return (side > 1) ? 83 : 81;
            }
            case 4: {
                return 84;
            }
            case 5: {
                return 85;
            }
            case 6: {
                return (side > 1) ? 81 : 86;
            }
            case 7: {
                return (side > 1) ? 81 : 87;
            }
        }
    }
    
    public void a(final xv world, final qx entityplayer, final int x, final int y, final int z, final int meta) {
        final um cei = entityplayer.bT();
        if (cei != null && cei.b() instanceof tu && !(cei.b() instanceof ItemTFMazebreakerPick)) {
            cei.a(16, (md)entityplayer);
        }
        super.a(world, entityplayer, x, y, z, meta);
    }
    
    public void a(final int par1, final th par2CreativeTabs, final List par3List) {
        par3List.add(new um(par1, 1, 0));
        par3List.add(new um(par1, 1, 1));
        par3List.add(new um(par1, 1, 2));
        par3List.add(new um(par1, 1, 3));
        par3List.add(new um(par1, 1, 4));
        par3List.add(new um(par1, 1, 5));
        par3List.add(new um(par1, 1, 6));
        par3List.add(new um(par1, 1, 7));
    }
    
    public int b(final int meta) {
        return meta;
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
}
