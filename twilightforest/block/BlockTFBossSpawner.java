// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import twilightforest.tileentity.TileEntityTFKnightPhantomsSpawner;
import twilightforest.tileentity.TileEntityTFTowerBossSpawner;
import twilightforest.tileentity.TileEntityTFHydraSpawner;
import twilightforest.tileentity.TileEntityTFLichSpawner;
import twilightforest.tileentity.TileEntityTFNagaSpawner;
import twilightforest.item.TFItems;

public class BlockTFBossSpawner extends amt
{
    protected BlockTFBossSpawner(final int i) {
        super(i, ajz.f);
        this.c(20.0f);
        this.b(10.0f);
        this.a((wv)TFItems.creativeTab);
    }
    
    public boolean hasTileEntity(final int metadata) {
        return true;
    }
    
    public asm b(final abv var1) {
        return null;
    }
    
    public asm createTileEntity(final abv world, final int metadata) {
        if (metadata == 0) {
            return new TileEntityTFNagaSpawner();
        }
        if (metadata == 1) {
            return new TileEntityTFLichSpawner();
        }
        if (metadata == 2) {
            return new TileEntityTFHydraSpawner();
        }
        if (metadata == 3) {
            return new TileEntityTFTowerBossSpawner();
        }
        if (metadata == 4) {
            return new TileEntityTFKnightPhantomsSpawner();
        }
        return null;
    }
    
    public int a(final int par1, final Random par2Random, final int par3) {
        return 0;
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public boolean c() {
        return false;
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
    }
    
    public mr a(final int side, final int metadata) {
        return aqw.ax.a(side, metadata);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
    }
}
