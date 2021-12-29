// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import twilightforest.item.ItemTFMazebreakerPick;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFMazestone extends aou
{
    private static lx TEX_PLAIN;
    private static lx TEX_BRICK;
    private static lx TEX_PILLAR;
    private static lx TEX_DECO;
    private static lx TEX_CRACKED;
    private static lx TEX_MOSSY;
    private static lx TEX_MOSAIC;
    private static lx TEX_BORDER;
    
    public BlockTFMazestone(final int id) {
        super(id, ahz.e);
        this.c(100.0f);
        this.b(5.0f);
        this.a(aou.j);
        this.a((uy)TFItems.creativeTab);
    }
    
    public lx a(final int side, final int meta) {
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
    public void a(final ly par1IconRegister) {
        BlockTFMazestone.TEX_PLAIN = par1IconRegister.a("twilightforest:mazestone_plain");
        BlockTFMazestone.TEX_BRICK = par1IconRegister.a("twilightforest:mazestone_brick");
        BlockTFMazestone.TEX_PILLAR = par1IconRegister.a("twilightforest:mazestone_pillar");
        BlockTFMazestone.TEX_DECO = par1IconRegister.a("twilightforest:mazestone_decorative");
        BlockTFMazestone.TEX_CRACKED = par1IconRegister.a("twilightforest:mazestone_cracked");
        BlockTFMazestone.TEX_MOSSY = par1IconRegister.a("twilightforest:mazestone_mossy");
        BlockTFMazestone.TEX_MOSAIC = par1IconRegister.a("twilightforest:mazestone_mosaic");
        BlockTFMazestone.TEX_BORDER = par1IconRegister.a("twilightforest:mazestone_border");
    }
    
    public void a(final zv world, final sk entityplayer, final int x, final int y, final int z, final int meta) {
        final wg cei = entityplayer.cb();
        if (cei != null && cei.b() instanceof vl && !(cei.b() instanceof ItemTFMazebreakerPick)) {
            cei.a(16, (ng)entityplayer);
        }
        super.a(world, entityplayer, x, y, z, meta);
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        par3List.add(new wg(par1, 1, 0));
        par3List.add(new wg(par1, 1, 1));
        par3List.add(new wg(par1, 1, 2));
        par3List.add(new wg(par1, 1, 3));
        par3List.add(new wg(par1, 1, 4));
        par3List.add(new wg(par1, 1, 5));
        par3List.add(new wg(par1, 1, 6));
        par3List.add(new wg(par1, 1, 7));
    }
    
    public int a(final int meta) {
        return meta;
    }
}
