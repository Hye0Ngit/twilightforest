// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import twilightforest.item.TFItems;

public class BlockTFRoots extends amq
{
    public static int spRootSide;
    public static int spOreRootSide;
    public static final int ROOT_META = 0;
    public static final int OREROOT_META = 1;
    
    public BlockTFRoots(final int par1) {
        super(par1, agi.d);
        this.a((tj)TFItems.creativeTab);
        this.c(2.0f);
        this.a(amq.e);
    }
    
    public int a(final int side, final int meta) {
        if (meta == 1) {
            return BlockTFRoots.spOreRootSide;
        }
        return BlockTFRoots.spRootSide;
    }
    
    public int a(final int meta, final Random random, final int j) {
        switch (meta) {
            case 0: {
                return up.D.cj;
            }
            case 1: {
                return TFItems.liveRoot.cj;
            }
            default: {
                return this.cm;
            }
        }
    }
    
    public int b(final int meta) {
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
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        par3List.add(new ur(par1, 1, 0));
        par3List.add(new ur(par1, 1, 1));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    static {
        BlockTFRoots.spRootSide = 13;
        BlockTFRoots.spOreRootSide = 14;
    }
}
