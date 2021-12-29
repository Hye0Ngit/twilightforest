// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.block.Block;
import net.minecraft.util.Icon;
import java.util.List;
import java.util.Random;
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
    protected BlockTFBossSpawner(final int i) {
        super(i, Material.field_76243_f);
        this.func_71848_c(20.0f);
        this.func_71894_b(10.0f);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean hasTileEntity(final int metadata) {
        return true;
    }
    
    public TileEntity func_72274_a(final World var1) {
        return null;
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
        return null;
    }
    
    public int func_71885_a(final int par1, final Random par2Random, final int par3) {
        return 0;
    }
    
    public int func_71925_a(final Random random) {
        return 0;
    }
    
    public boolean func_71926_d() {
        return false;
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
    }
    
    public Icon func_71858_a(final int side, final int metadata) {
        return Block.field_72065_as.func_71858_a(side, metadata);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
    }
}
