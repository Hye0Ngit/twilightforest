// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.Explosion;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public abstract class BlockTFGiantBlock extends Block
{
    private IIcon[][][] giantIcon;
    private Block baseBlock;
    private boolean isSelfDestructing;
    
    public BlockTFGiantBlock(final Block baseBlock) {
        super(baseBlock.func_149688_o());
        this.func_149672_a(baseBlock.field_149762_H);
        this.baseBlock = baseBlock;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        this.giantIcon = (IIcon[][][])new GiantBlockIcon[4][4][6];
        for (int x = 0; x < 4; ++x) {
            for (int y = 0; y < 4; ++y) {
                for (int side = 0; side < 6; ++side) {
                    this.giantIcon[x][y][side] = (IIcon)new GiantBlockIcon(this.baseBlock.func_149733_h(side), x, y);
                }
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149673_e(final IBlockAccess world, final int x, final int y, final int z, final int side) {
        switch (side) {
            default: {
                return this.giantIcon[x & 0x3][z & 0x3][side];
            }
            case 1: {
                return this.giantIcon[x & 0x3][z & 0x3][side];
            }
            case 2: {
                return this.giantIcon[3 - (x & 0x3)][3 - (y & 0x3)][side];
            }
            case 3: {
                return this.giantIcon[x & 0x3][3 - (y & 0x3)][side];
            }
            case 4: {
                return this.giantIcon[z & 0x3][3 - (y & 0x3)][side];
            }
            case 5: {
                return this.giantIcon[3 - (z & 0x3)][3 - (y & 0x3)][side];
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int side, final int meta) {
        return this.giantIcon[0][0][side];
    }
    
    public boolean func_149742_c(final World world, final int x, final int y, final int z) {
        final int bx = x >> 2 << 2;
        final int by = y >> 2 << 2;
        final int bz = z >> 2 << 2;
        boolean allReplaceable = true;
        for (int dx = 0; dx < 4; ++dx) {
            for (int dy = 0; dy < 4; ++dy) {
                for (int dz = 0; dz < 4; ++dz) {
                    allReplaceable &= world.func_147439_a(bx + dx, by + dy, bz + dz).isReplaceable((IBlockAccess)world, bx + dx, by + dy, bz + dz);
                }
            }
        }
        return super.func_149742_c(world, x, y, z) && allReplaceable;
    }
    
    public AxisAlignedBB func_149668_a(final World world, final int x, final int y, final int z) {
        final int bx = x >> 2 << 2;
        final int by = y >> 2 << 2;
        final int bz = z >> 2 << 2;
        return AxisAlignedBB.func_72330_a(bx + this.field_149759_B, by + this.field_149760_C, bz + this.field_149754_D, bx + this.field_149755_E * 4.0, by + this.field_149756_F * 4.0, bz + this.field_149757_G * 4.0);
    }
    
    public void func_149689_a(final World world, final int x, final int y, final int z, final EntityLivingBase player, final ItemStack itemStack) {
        if (!world.field_72995_K) {
            final int bx = x >> 2 << 2;
            final int by = y >> 2 << 2;
            final int bz = z >> 2 << 2;
            for (int dx = 0; dx < 4; ++dx) {
                for (int dy = 0; dy < 4; ++dy) {
                    for (int dz = 0; dz < 4; ++dz) {
                        world.func_147465_d(bx + dx, by + dy, bz + dz, (Block)this, 0, 2);
                    }
                }
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public boolean addDestroyEffects(final World world, final int x, final int y, final int z, final int meta, final EffectRenderer effectRenderer) {
        final int bx = x >> 2 << 2;
        final int by = y >> 2 << 2;
        final int bz = z >> 2 << 2;
        final Block blockThere = world.func_147439_a(x, y, z);
        final int metaThere = world.func_72805_g(x, y, z);
        final byte b0 = 16;
        for (int i1 = 0; i1 < b0; ++i1) {
            for (int j1 = 0; j1 < b0; ++j1) {
                for (int k1 = 0; k1 < b0; ++k1) {
                    final double d0 = bx + (i1 + 0.5) / 4.0;
                    final double d2 = by + (j1 + 0.5) / 4.0;
                    final double d3 = bz + (k1 + 0.5) / 4.0;
                    effectRenderer.func_78873_a((EntityFX)new EntityDiggingFX(world, d0, d2, d3, d0 - x - 0.5, d2 - y - 0.5, d3 - z - 0.5, blockThere, metaThere).func_70596_a(x, y, z));
                }
            }
        }
        return true;
    }
    
    public void func_149681_a(final World world, final int x, final int y, final int z, final int meta, final EntityPlayer player) {
        this.setGiantBlockToAir(world, x, y, z);
    }
    
    public void onBlockExploded(final World world, final int x, final int y, final int z, final Explosion explosion) {
        world.func_147468_f(x, y, z);
        this.setGiantBlockToAir(world, x, y, z);
    }
    
    public void func_149725_f(final World world, final int x, final int y, final int z, final int meta) {
        if (!this.isSelfDestructing && !this.func_149718_j(world, x, y, z)) {
            this.setGiantBlockToAir(world, x, y, z);
        }
    }
    
    private void setGiantBlockToAir(final World world, final int x, final int y, final int z) {
        this.isSelfDestructing = true;
        final int bx = x >> 2 << 2;
        final int by = y >> 2 << 2;
        final int bz = z >> 2 << 2;
        for (int dx = 0; dx < 4; ++dx) {
            for (int dy = 0; dy < 4; ++dy) {
                for (int dz = 0; dz < 4; ++dz) {
                    if ((x != bx + dx || y != by + dy || z != bz + dz) && world.func_147439_a(bx + dx, by + dy, bz + dz) == this) {
                        world.func_147468_f(bx + dx, by + dy, bz + dz);
                    }
                }
            }
        }
        this.isSelfDestructing = false;
    }
    
    public boolean func_149718_j(final World world, final int x, final int y, final int z) {
        boolean allThisBlock = true;
        final int bx = x >> 2 << 2;
        final int by = y >> 2 << 2;
        final int bz = z >> 2 << 2;
        for (int dx = 0; dx < 4; ++dx) {
            for (int dy = 0; dy < 4; ++dy) {
                for (int dz = 0; dz < 4; ++dz) {
                    allThisBlock &= (world.func_147439_a(bx + dx, by + dy, bz + dz) == this);
                }
            }
        }
        return allThisBlock;
    }
    
    public int func_149656_h() {
        return 2;
    }
}
