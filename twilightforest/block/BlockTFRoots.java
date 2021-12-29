// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFRoots extends aou
{
    public static lx spRootSide;
    public static lx spOreRootSide;
    public static final int ROOT_META = 0;
    public static final int OREROOT_META = 1;
    
    public BlockTFRoots(final int par1) {
        super(par1, ahz.d);
        this.a((uy)TFItems.creativeTab);
        this.c(2.0f);
        this.a(aou.g);
    }
    
    public lx a(final int side, final int meta) {
        if (meta == 1) {
            return BlockTFRoots.spOreRootSide;
        }
        return BlockTFRoots.spRootSide;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        BlockTFRoots.spRootSide = par1IconRegister.a("twilightforest:rootblock");
        BlockTFRoots.spOreRootSide = par1IconRegister.a("twilightforest:oreroots");
    }
    
    public int a(final int meta, final Random random, final int j) {
        switch (meta) {
            case 0: {
                return we.E.cp;
            }
            case 1: {
                return TFItems.liveRoot.cp;
            }
            default: {
                return this.cz;
            }
        }
    }
    
    public int a(final int meta) {
        switch (meta) {
            case 0: {
                return 0;
            }
            case 1: {
                return 0;
            }
            default: {
                return meta | 0x8;
            }
        }
    }
    
    public int quantityDropped(final int meta, final int fortune, final Random random) {
        switch (meta) {
            case 0: {
                return 3 + random.nextInt(2);
            }
            default: {
                return super.quantityDropped(meta, fortune, random);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        par3List.add(new wg(par1, 1, 0));
        par3List.add(new wg(par1, 1, 1));
    }
}
