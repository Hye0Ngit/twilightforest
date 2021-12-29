// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import twilightforest.item.TFItems;

public class BlockTFMagicLogSpecial extends BlockTFMagicLog
{
    protected BlockTFMagicLogSpecial(final int i) {
        super(i);
        this.a((tj)TFItems.creativeTab);
    }
    
    public int r_() {
        return 20;
    }
    
    public void g(final yc par1World, final int par2, final int par3, final int par4) {
        par1World.a(par2, par3, par4, this.cm, this.r_());
    }
    
    @Override
    public int a(final int side, final int meta) {
        final int orient = meta & 0xC;
        final int woodType = meta & 0x3;
        return (orient == 0 && (side == 1 || side == 0)) ? BlockTFMagicLogSpecial.sprTimeTop : ((orient == 4 && (side == 5 || side == 4)) ? BlockTFMagicLogSpecial.sprTimeTop : ((orient == 8 && (side == 2 || side == 3)) ? BlockTFMagicLogSpecial.sprTimeTop : BlockTFMagicLogSpecial.sprTimeClock));
    }
    
    public void b(final yc world, final int x, final int y, final int z, final Random rand) {
        world.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.1f, 0.5f);
        world.a(x, y, z, this.cm, this.r_());
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final yc world, final int x, final int y, final int z, final Random rand) {
    }
    
    public int getLightValue(final ym world, final int x, final int y, final int z) {
        return 15;
    }
    
    @Override
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        par3List.add(new ur(par1, 1, 0));
    }
}
