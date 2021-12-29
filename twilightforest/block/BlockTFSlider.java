// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;
import twilightforest.entity.EntityTFSlideBlock;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockRotatedPillar;

public class BlockTFSlider extends BlockRotatedPillar
{
    private static final int TICK_TIME = 80;
    private static final int OFFSET_TIME = 20;
    private static final int PLAYER_RANGE = 32;
    private static final float BLOCK_DAMAGE = 5.0f;
    private IIcon horiIcon;
    private IIcon vertIcon;
    private IIcon topIcon;
    
    protected BlockTFSlider() {
        super(Material.field_151573_f);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149711_c(2.0f);
        this.func_149752_b(10.0f);
    }
    
    public AxisAlignedBB func_149668_a(final World world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        final int rotation = meta & 0xC;
        final float pixel = 0.0625f;
        final float inset = 5.0f;
        switch (rotation) {
            default: {
                return AxisAlignedBB.func_72330_a((double)(x + pixel * inset), (double)y, (double)(z + pixel * inset), (double)(x + 1.0f - pixel * inset), (double)(y + 1.0f), (double)(z + 1.0f - pixel * inset));
            }
            case 4: {
                return AxisAlignedBB.func_72330_a((double)x, (double)(y + pixel * inset), (double)(z + pixel * inset), (double)(x + 1.0f), (double)(y + 1.0f - pixel * inset), (double)(z + 1.0f - pixel * inset));
            }
            case 8: {
                return AxisAlignedBB.func_72330_a((double)(x + pixel * inset), (double)(y + pixel * inset), (double)z, (double)(x + 1.0f - pixel * inset), (double)(y + 1.0f - pixel * inset), (double)(z + 1.0f));
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB func_149633_g(final World world, final int x, final int y, final int z) {
        return this.func_149668_a(world, x, y, z);
    }
    
    public void func_149719_a(final IBlockAccess world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        this.setBlockBoundsBasedOnMeta(meta);
    }
    
    public void setBlockBoundsBasedOnMeta(final int meta) {
        final int rotation = meta & 0xC;
        final float pixel = 0.0625f;
        final float inset = 5.0f;
        switch (rotation) {
            default: {
                this.func_149676_a(pixel * inset, 0.0f, pixel * inset, 1.0f - pixel * inset, 1.0f, 1.0f - pixel * inset);
                break;
            }
            case 4: {
                this.func_149676_a(0.0f, pixel * inset, pixel * inset, 1.0f, 1.0f - pixel * inset, 1.0f - pixel * inset);
                break;
            }
            case 8: {
                this.func_149676_a(pixel * inset, pixel * inset, 0.0f, 1.0f - pixel * inset, 1.0f - pixel * inset, 1.0f);
                break;
            }
        }
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public int func_149645_b() {
        return 0;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int side, final int meta) {
        final int rotation = meta & 0xC;
        if (rotation == 0) {
            switch (side) {
                case 0:
                case 1: {
                    return this.topIcon;
                }
                default: {
                    return this.vertIcon;
                }
            }
        }
        else if (rotation == 4) {
            switch (side) {
                case 4:
                case 5: {
                    return this.topIcon;
                }
                default: {
                    return this.horiIcon;
                }
            }
        }
        else {
            switch (side) {
                case 2:
                case 3: {
                    return this.topIcon;
                }
                case 0:
                case 1: {
                    return this.vertIcon;
                }
                default: {
                    return this.horiIcon;
                }
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    protected IIcon func_150163_b(final int meta) {
        if ((meta & 0xC) == 0x0) {
            return this.horiIcon;
        }
        if ((meta & 0xC) == 0x8) {
            return this.horiIcon;
        }
        return this.vertIcon;
    }
    
    @SideOnly(Side.CLIENT)
    protected IIcon func_150161_d(final int p_150161_1_) {
        return this.topIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        this.horiIcon = par1IconRegister.func_94245_a("TwilightForest:slider_h");
        this.vertIcon = par1IconRegister.func_94245_a("TwilightForest:slider_v");
        this.topIcon = par1IconRegister.func_94245_a("TwilightForest:slider_top");
    }
    
    public void func_149674_a(final World world, final int x, final int y, final int z, final Random par5Random) {
        if (!world.field_72995_K && this.isConnectedInRange(world, x, y, z)) {
            final EntityTFSlideBlock slideBlock = new EntityTFSlideBlock(world, x + 0.5, y, z + 0.5, (Block)this, world.func_72805_g(x, y, z));
            world.func_72838_d((Entity)slideBlock);
        }
        this.scheduleBlockUpdate(world, x, y, z);
    }
    
    public boolean isConnectedInRange(final World world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        if ((meta & 0xC) == 0x0) {
            return this.anyPlayerInRange(world, x, y, z) || this.isConnectedInRangeRecursive(world, x, y, z, ForgeDirection.UP) || this.isConnectedInRangeRecursive(world, x, y, z, ForgeDirection.DOWN);
        }
        if ((meta & 0xC) == 0x4) {
            return this.anyPlayerInRange(world, x, y, z) || this.isConnectedInRangeRecursive(world, x, y, z, ForgeDirection.WEST) || this.isConnectedInRangeRecursive(world, x, y, z, ForgeDirection.EAST);
        }
        if ((meta & 0xC) == 0x8) {
            return this.anyPlayerInRange(world, x, y, z) || this.isConnectedInRangeRecursive(world, x, y, z, ForgeDirection.NORTH) || this.isConnectedInRangeRecursive(world, x, y, z, ForgeDirection.SOUTH);
        }
        return this.anyPlayerInRange(world, x, y, z);
    }
    
    private boolean isConnectedInRangeRecursive(final World world, final int x, final int y, final int z, final ForgeDirection dir) {
        final int dx = x + dir.offsetX;
        final int dy = y + dir.offsetY;
        final int dz = z + dir.offsetZ;
        return world.func_147439_a(x, y, z) == world.func_147439_a(dx, dy, dz) && world.func_72805_g(x, y, z) == world.func_72805_g(dx, dy, dz) && (this.anyPlayerInRange(world, dx, dy, dz) || this.isConnectedInRangeRecursive(world, dx, dy, dz, dir));
    }
    
    public boolean anyPlayerInRange(final World world, final int x, final int y, final int z) {
        return world.func_72977_a(x + 0.5, y + 0.5, z + 0.5, 32.0) != null;
    }
    
    public void scheduleBlockUpdate(final World world, final int x, final int y, final int z) {
        final int offset = world.func_72805_g(x, y, z) & 0x3;
        final int update = 80 - (int)(world.func_72820_D() - offset * 20) % 80;
        world.func_147464_a(x, y, z, (Block)this, update);
    }
    
    public void func_149726_b(final World world, final int x, final int y, final int z) {
        this.scheduleBlockUpdate(world, x, y, z);
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
    }
    
    public void func_149683_g() {
        this.setBlockBoundsBasedOnMeta(0);
    }
    
    public void func_149670_a(final World world, final int x, final int y, final int z, final Entity entity) {
        entity.func_70097_a(DamageSource.field_76377_j, 5.0f);
        if (entity instanceof EntityLivingBase) {
            final double kx = (x + 0.5 - entity.field_70165_t) * 2.0;
            final double kz = (z + 0.5 - entity.field_70161_v) * 2.0;
            ((EntityLivingBase)entity).func_70653_a((Entity)null, 5.0f, kx, kz);
        }
    }
}
