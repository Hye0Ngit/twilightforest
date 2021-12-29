// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import twilightforest.item.ItemTFMazebreakerPick;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFMazestone extends aqw
{
    private static mr TEX_PLAIN;
    private static mr TEX_BRICK;
    private static mr TEX_PILLAR;
    private static mr TEX_DECO;
    private static mr TEX_CRACKED;
    private static mr TEX_MOSSY;
    private static mr TEX_MOSAIC;
    private static mr TEX_BORDER;
    
    public BlockTFMazestone(final int id) {
        super(id, ajz.e);
        this.c(100.0f);
        this.b(5.0f);
        this.a(aqw.k);
        this.a((wv)TFItems.creativeTab);
    }
    
    public mr a(final int side, final int meta) {
        switch (meta) {
            default: {
                return BlockTFMazestone.TEX_PLAIN;
            }
            case 1: {
                return BlockTFMazestone.TEX_BRICK;
            }
            case 2: {
                return (side > 1) ? BlockTFMazestone.TEX_PILLAR : BlockTFMazestone.TEX_PLAIN;
            }
            case 3: {
                return (side > 1) ? BlockTFMazestone.TEX_DECO : BlockTFMazestone.TEX_BRICK;
            }
            case 4: {
                return BlockTFMazestone.TEX_CRACKED;
            }
            case 5: {
                return BlockTFMazestone.TEX_MOSSY;
            }
            case 6: {
                return (side > 1) ? BlockTFMazestone.TEX_BRICK : BlockTFMazestone.TEX_MOSAIC;
            }
            case 7: {
                return (side > 1) ? BlockTFMazestone.TEX_BRICK : BlockTFMazestone.TEX_BORDER;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        BlockTFMazestone.TEX_PLAIN = par1IconRegister.a("TwilightForest:mazestone_plain");
        BlockTFMazestone.TEX_BRICK = par1IconRegister.a("TwilightForest:mazestone_brick");
        BlockTFMazestone.TEX_PILLAR = par1IconRegister.a("TwilightForest:mazestone_pillar");
        BlockTFMazestone.TEX_DECO = par1IconRegister.a("TwilightForest:mazestone_decorative");
        BlockTFMazestone.TEX_CRACKED = par1IconRegister.a("TwilightForest:mazestone_cracked");
        BlockTFMazestone.TEX_MOSSY = par1IconRegister.a("TwilightForest:mazestone_mossy");
        BlockTFMazestone.TEX_MOSAIC = par1IconRegister.a("TwilightForest:mazestone_mosaic");
        BlockTFMazestone.TEX_BORDER = par1IconRegister.a("TwilightForest:mazestone_border");
    }
    
    public void a(final abv world, final ue entityplayer, final int x, final int y, final int z, final int meta) {
        final yd cei = entityplayer.bx();
        if (cei != null && cei.b() instanceof xi && !(cei.b() instanceof ItemTFMazebreakerPick)) {
            cei.a(16, (oe)entityplayer);
        }
        super.a(world, entityplayer, x, y, z, meta);
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        par3List.add(new yd(par1, 1, 0));
        par3List.add(new yd(par1, 1, 1));
        par3List.add(new yd(par1, 1, 2));
        par3List.add(new yd(par1, 1, 3));
        par3List.add(new yd(par1, 1, 4));
        par3List.add(new yd(par1, 1, 5));
        par3List.add(new yd(par1, 1, 6));
        par3List.add(new yd(par1, 1, 7));
    }
    
    public int a(final int meta) {
        return meta;
    }
}
