// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.common.ForgeDirection;
import twilightforest.entity.EntityTFTowerTermite;
import java.util.Random;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFTowerWood extends aqw
{
    private static mr TEX_PLAIN;
    private static mr TEX_ENCASED;
    private static mr TEX_CRACKED;
    private static mr TEX_MOSSY;
    private static mr TEX_INFESTED;
    public static final int META_INFESTED = 4;
    
    public BlockTFTowerWood(final int id) {
        super(id, ajz.d);
        this.c(40.0f);
        this.b(10.0f);
        this.a(aqw.h);
        this.a((wv)TFItems.creativeTab);
    }
    
    public int c(final ace par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.h(x, y, z);
        if (meta == 0 || meta == 2 || meta == 3 || meta == 4) {
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
    
    public mr a(final int side, final int meta) {
        switch (meta) {
            default: {
                return BlockTFTowerWood.TEX_PLAIN;
            }
            case 1: {
                return BlockTFTowerWood.TEX_ENCASED;
            }
            case 2: {
                return BlockTFTowerWood.TEX_CRACKED;
            }
            case 3: {
                return BlockTFTowerWood.TEX_MOSSY;
            }
            case 4: {
                return BlockTFTowerWood.TEX_INFESTED;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        BlockTFTowerWood.TEX_PLAIN = par1IconRegister.a("TwilightForest:towerwood_planks");
        BlockTFTowerWood.TEX_ENCASED = par1IconRegister.a("TwilightForest:towerwood_encased");
        BlockTFTowerWood.TEX_CRACKED = par1IconRegister.a("TwilightForest:towerwood_cracked");
        BlockTFTowerWood.TEX_MOSSY = par1IconRegister.a("TwilightForest:towerwood_mossy");
        BlockTFTowerWood.TEX_INFESTED = par1IconRegister.a("TwilightForest:towerwood_infested");
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        par3List.add(new yd(par1, 1, 0));
        par3List.add(new yd(par1, 1, 1));
        par3List.add(new yd(par1, 1, 2));
        par3List.add(new yd(par1, 1, 3));
        par3List.add(new yd(par1, 1, 4));
    }
    
    public int a(final int meta) {
        return meta;
    }
    
    public int quantityDropped(final int meta, final int fortune, final Random random) {
        if (meta == 4) {
            return 0;
        }
        return super.quantityDropped(meta, fortune, random);
    }
    
    public float l(final abv world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        if (meta == 4) {
            return 0.75f;
        }
        return super.l(world, x, y, z);
    }
    
    public void g(final abv par1World, final int x, final int y, final int z, final int meta) {
        if (!par1World.I && meta == 4) {
            final EntityTFTowerTermite termite = new EntityTFTowerTermite(par1World);
            termite.b(x + 0.5, (double)y, z + 0.5, 0.0f, 0.0f);
            par1World.d((nm)termite);
            termite.q();
        }
        super.g(par1World, x, y, z, meta);
    }
    
    public int getFlammability(final ace world, final int x, final int y, final int z, final int metadata, final ForgeDirection face) {
        return 1;
    }
    
    public int getFireSpreadSpeed(final abv world, final int x, final int y, final int z, final int metadata, final ForgeDirection face) {
        return 0;
    }
}
