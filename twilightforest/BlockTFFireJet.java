// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;
import java.util.Random;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class BlockTFFireJet extends amj
{
    public static final int META_SMOKER = 0;
    public static final int META_JET_IDLE = 8;
    public static final int META_JET_POPPING = 9;
    public static final int META_JET_FLAME = 10;
    public static int spriteJet;
    public static int spriteSide;
    
    protected BlockTFFireJet(final int par1) {
        super(par1, BlockTFFireJet.spriteJet, agb.e);
        this.c(1.5f);
        this.b(10.0f);
        this.a(amj.e);
        this.a(th.c);
        this.b(true);
    }
    
    public int b(final int meta) {
        return meta;
    }
    
    public int a(final int side, final int meta) {
        if (side == 1) {
            return BlockTFFireJet.spriteJet;
        }
        return BlockTFFireJet.spriteSide;
    }
    
    @SideOnly(Side.CLIENT)
    public int o() {
        final double var1 = 0.5;
        final double var2 = 1.0;
        return xu.a(var1, var2);
    }
    
    @SideOnly(Side.CLIENT)
    public int b(final yf par1IBlockAccess, final int par2, final int par3, final int par4) {
        int var5 = 0;
        int var6 = 0;
        int var7 = 0;
        for (int var8 = -1; var8 <= 1; ++var8) {
            for (int var9 = -1; var9 <= 1; ++var9) {
                final int var10 = par1IBlockAccess.a(par2 + var9, par4 + var8).k();
                var5 += (var10 & 0xFF0000) >> 16;
                var6 += (var10 & 0xFF00) >> 8;
                var7 += (var10 & 0xFF);
            }
        }
        return (var5 / 9 & 0xFF) << 16 | (var6 / 9 & 0xFF) << 8 | (var7 / 9 & 0xFF);
    }
    
    public int getLightValue(final yf world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        switch (meta) {
            default: {
                return 0;
            }
            case 10: {
                return 15;
            }
        }
    }
    
    public void b(final xv world, final int x, final int y, final int z, final Random random) {
        if (!world.J && world.h(x, y, z) == 8) {
            final s lavaPos = this.findLavaAround(world, x, y - 1, z);
            if (this.isLava(world, lavaPos.a, lavaPos.b, lavaPos.c)) {
                world.e(lavaPos.a, lavaPos.b, lavaPos.c, 0);
                world.d(x, y, z, this.cm, 9);
            }
        }
    }
    
    private s findLavaAround(final xv world, final int x, final int y, final int z) {
        if (this.isLava(world, x, y, z)) {
            return new s(x, y, z);
        }
        int rx = x + world.u.nextInt(3) - 1;
        int rz = z + world.u.nextInt(3) - 1;
        if (this.isLava(world, rx, y, rz)) {
            return new s(rx, y, rz);
        }
        rx = x + world.u.nextInt(3) - 1;
        rz = z + world.u.nextInt(3) - 1;
        if (this.isLava(world, rx, y, rz)) {
            return new s(rx, y, rz);
        }
        rx = x + world.u.nextInt(3) - 1;
        rz = z + world.u.nextInt(3) - 1;
        if (this.isLava(world, rx, y, rz)) {
            return new s(rx, y, rz);
        }
        return new s(x, y, z);
    }
    
    private boolean isLava(final xv world, final int x, final int y, final int z) {
        return world.g(x, y, z) == agb.i && world.h(x, y, z) == 0;
    }
    
    public boolean hasTileEntity(final int metadata) {
        return metadata == 0 || metadata == 9 || metadata == 10;
    }
    
    public anq createTileEntity(final xv world, final int metadata) {
        if (metadata == 0) {
            return new TileEntityTFSmoker();
        }
        if (metadata == 9) {
            return new TileEntityTFPoppingJet();
        }
        if (metadata == 10) {
            return new TileEntityTFFlameJet();
        }
        return null;
    }
    
    public void a(final int par1, final th par2CreativeTabs, final List par3List) {
        par3List.add(new um(par1, 1, 0));
        par3List.add(new um(par1, 1, 8));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    static {
        BlockTFFireJet.spriteJet = 48;
        BlockTFFireJet.spriteSide = 49;
    }
}
