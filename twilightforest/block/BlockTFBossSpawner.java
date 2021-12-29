// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import java.util.List;
import net.minecraft.item.Item;
import java.util.Random;
import twilightforest.tileentity.TileEntityTFSnowQueenSpawner;
import twilightforest.tileentity.TileEntityTFKnightPhantomsSpawner;
import twilightforest.tileentity.TileEntityTFTowerBossSpawner;
import twilightforest.tileentity.TileEntityTFHydraSpawner;
import twilightforest.tileentity.TileEntityTFLichSpawner;
import twilightforest.tileentity.TileEntityTFNagaSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockContainer;

public class BlockTFBossSpawner extends BlockContainer
{
    protected BlockTFBossSpawner() {
        super(Material.field_151576_e);
        this.func_149711_c(20.0f);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean hasTileEntity(final int metadata) {
        return true;
    }
    
    public TileEntity createTileEntity(final World world, final int metadata) {
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
        if (metadata == 5) {
            return new TileEntityTFSnowQueenSpawner();
        }
        return null;
    }
    
    public TileEntity func_149915_a(final World var1, final int var2) {
        return this.createTileEntity(var1, var2);
    }
    
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return null;
    }
    
    public int func_149745_a(final Random random) {
        return 0;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
    }
    
    public IIcon func_149691_a(final int side, final int metadata) {
        return Blocks.field_150474_ac.func_149691_a(side, metadata);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
    }
}
