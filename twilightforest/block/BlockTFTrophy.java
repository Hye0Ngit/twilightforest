// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import java.util.ArrayList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;
import twilightforest.tileentity.TileEntityTFTrophy;

public class BlockTFTrophy extends amt
{
    public BlockTFTrophy(final int par1) {
        super(par1, ajz.q);
        this.a(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
    }
    
    public int d() {
        return -1;
    }
    
    public boolean c() {
        return false;
    }
    
    public boolean b() {
        return false;
    }
    
    public asu b(final abv par1World, final int par2, final int par3, final int par4) {
        this.a((ace)par1World, par2, par3, par4);
        return super.b(par1World, par2, par3, par4);
    }
    
    public void a(final ace par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.h(x, y, z) & 0x7;
        final TileEntityTFTrophy trophy = (TileEntityTFTrophy)par1IBlockAccess.r(x, y, z);
        if (trophy != null && trophy.a() == 0) {
            switch (meta) {
                default: {
                    this.a(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
                    break;
                }
                case 2:
                case 3: {
                    this.a(0.25f, 0.25f, 0.0f, 0.75f, 0.75f, 1.0f);
                    break;
                }
                case 4:
                case 5: {
                    this.a(0.0f, 0.25f, 0.25f, 1.0f, 0.75f, 0.75f);
                    break;
                }
            }
        }
        else if (trophy != null && trophy.a() == 3) {
            this.a(0.25f, 0.5f, 0.25f, 0.75f, 1.0f, 0.75f);
        }
        else {
            switch (meta) {
                default: {
                    this.a(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
                    break;
                }
                case 2: {
                    this.a(0.25f, 0.25f, 0.5f, 0.75f, 0.75f, 1.0f);
                    break;
                }
                case 3: {
                    this.a(0.25f, 0.25f, 0.0f, 0.75f, 0.75f, 0.5f);
                    break;
                }
                case 4: {
                    this.a(0.5f, 0.25f, 0.25f, 1.0f, 0.75f, 0.75f);
                    break;
                }
                case 5: {
                    this.a(0.0f, 0.25f, 0.25f, 0.5f, 0.75f, 0.75f);
                    break;
                }
            }
        }
    }
    
    public void onBlockPlacedBy(final abv par1World, final int par2, final int par3, final int par4, final oe par5EntityLiving) {
        final int var6 = lr.c(par5EntityLiving.A * 4.0f / 360.0f + 2.5) & 0x3;
        par1World.b(par2, par3, par4, var6, 2);
    }
    
    public asm b(final abv par1World) {
        return (asm)new TileEntityTFTrophy();
    }
    
    @SideOnly(Side.CLIENT)
    public int d(final abv par1World, final int par2, final int par3, final int par4) {
        return TFItems.trophy.cv;
    }
    
    public int h(final abv par1World, final int par2, final int par3, final int par4) {
        final asm var5 = par1World.r(par2, par3, par4);
        return (var5 != null && var5 instanceof ask) ? ((ask)var5).a() : super.h(par1World, par2, par3, par4);
    }
    
    public int a(final int par1) {
        return par1;
    }
    
    public void a(final abv par1World, final int par2, final int par3, final int par4, int par5, final ue par6EntityPlayer) {
        if (par6EntityPlayer.bG.d) {
            par5 |= 0x8;
            par1World.b(par2, par3, par4, par5, 2);
        }
        this.c(par1World, par2, par3, par4, par5, 0);
        super.a(par1World, par2, par3, par4, par5, par6EntityPlayer);
    }
    
    public void a(final abv par1World, final int par2, final int par3, final int par4, final int par5, final int par6) {
        super.a(par1World, par2, par3, par4, par5, par6);
    }
    
    public ArrayList<yd> getBlockDropped(final abv world, final int x, final int y, final int z, final int metadata, final int fortune) {
        final ArrayList<yd> drops = new ArrayList<yd>();
        if ((metadata & 0x8) == 0x0) {
            final yd var7 = new yd(TFItems.trophy.cv, 1, this.h(world, x, y, z));
            final TileEntityTFTrophy var8 = (TileEntityTFTrophy)world.r(x, y, z);
            if (var8 == null) {
                return drops;
            }
            if (var8.a() == 3 && var8.c() != null && var8.c().length() > 0) {
                var7.d(new bx());
                var7.q().a("SkullOwner", var8.c());
            }
            drops.add(var7);
        }
        return drops;
    }
    
    public int a(final int par1, final Random par2Random, final int par3) {
        return TFItems.trophy.cv;
    }
    
    @SideOnly(Side.CLIENT)
    public mr a(final int side, final int meta) {
        return aqw.bh.a(side, meta);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
    }
}
