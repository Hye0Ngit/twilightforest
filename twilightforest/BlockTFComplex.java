// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import org.lwjgl.opengl.GL11;
import java.util.ArrayList;
import java.util.Random;
import forge.ITextureProvider;

public class BlockTFComplex extends pb implements ITextureProvider
{
    public static int jarTop;
    public static int jarSide;
    public static int jarLid;
    public static int tinkerTop;
    public static int tinkerSide;
    
    protected BlockTFComplex(final int par1) {
        super(par1, BlockTFComplex.jarSide, acn.p);
        this.a(pb.e);
    }
    
    public boolean b() {
        return false;
    }
    
    protected int c(final int meta) {
        return meta;
    }
    
    public boolean a() {
        return false;
    }
    
    public int d() {
        return mod_TwilightForest.blockComplexRenderID;
    }
    
    public int a(final int side, final int meta) {
        switch (meta) {
            case 1: {
                return (side == 1) ? BlockTFComplex.tinkerTop : BlockTFComplex.tinkerSide;
            }
            default: {
                return (side == 1 || side == 0) ? BlockTFComplex.jarTop : BlockTFComplex.jarSide;
            }
        }
    }
    
    public float getHardness(final int meta) {
        switch (meta) {
            case 1: {
                return 2.5f;
            }
            default: {
                return 0.3f;
            }
        }
    }
    
    public int getLightValue(final ali world, final int x, final int y, final int z) {
        final int meta = world.e(x, y, z);
        switch (meta) {
            case 1: {
                return 0;
            }
            default: {
                return 8;
            }
        }
    }
    
    public boolean isBlockNormalCube(final xd world, final int x, final int y, final int z) {
        final int meta = world.e(x, y, z);
        switch (meta) {
            case 1: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public void a(final ali world, final int x, final int y, final int z) {
        final int meta = world.e(x, y, z);
        switch (meta) {
            case 1: {
                this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            default: {
                this.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 1.0f, 0.8125f);
                break;
            }
        }
    }
    
    public void b(final xd world, final int x, final int y, final int z, final Random rand) {
        final int meta = world.e(x, y, z);
        if (meta == 0) {
            double dx = x + (rand.nextFloat() - rand.nextFloat()) * 0.3f;
            double dy = y - 0.1f + (rand.nextFloat() - rand.nextFloat()) * 0.4f;
            double dz = z + (rand.nextFloat() - rand.nextFloat()) * 0.3f;
            EntityTFTinyFirefly tinyfly = new EntityTFTinyFirefly(world, dx, dy, dz);
            world.e((nn)tinyfly);
            dx = x + (rand.nextFloat() - rand.nextFloat()) * 0.3f;
            dy = y - 0.1f + (rand.nextFloat() - rand.nextFloat()) * 0.4f;
            dz = z + (rand.nextFloat() - rand.nextFloat()) * 0.3f;
            tinyfly = new EntityTFTinyFirefly(world, dx, dy, dz);
            world.e((nn)tinyfly);
        }
    }
    
    public boolean b(final xd world, final int x, final int y, final int z, final yw player) {
        final int meta = world.e(x, y, z);
        switch (meta) {
            case 1: {
                if (!world.F) {
                    player.openGui((BaseMod)mod_TwilightForest.instance, 1, world, x, y, z);
                }
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new aan((pb)this, 1, 0));
        itemList.add(new aan((pb)this, 1, 1));
    }
    
    public static boolean renderComplex(final vl renderblocks, final ali world, final int x, final int y, final int z, final pb block) {
        final int meta = world.e(x, y, z);
        switch (meta) {
            case 1: {
                renderblocks.o(block, x, y, z);
                return true;
            }
            case 0: {
                return renderJar(renderblocks, world, x, y, z, block);
            }
            default: {
                return false;
            }
        }
    }
    
    public static boolean renderJar(final vl renderblocks, final ali world, final int x, final int y, final int z, final pb block) {
        block.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 0.875f, 0.8125f);
        renderblocks.o(block, x, y, z);
        renderblocks.d = BlockTFComplex.jarLid;
        block.a(0.25f, 0.75f, 0.25f, 0.75f, 1.0f, 0.75f);
        renderblocks.o(block, x, y, z);
        renderblocks.a();
        block.h();
        return true;
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    public static void renderInvBlock(final vl renderblocks, final pb block, final int meta) {
        switch (meta) {
            case 1: {
                renderInvNormalBlock(renderblocks, block, meta);
                break;
            }
            case 0: {
                renderInvJar(renderblocks, block, meta);
                break;
            }
            default: {}
        }
    }
    
    public static void renderInvNormalBlock(final vl renderblocks, final pb par1Block, final int meta) {
        final adz tessellator = adz.a;
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        par1Block.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        tessellator.b();
        tessellator.b(0.0f, -1.0f, 0.0f);
        renderblocks.a(par1Block, 0.0, 0.0, 0.0, par1Block.a(0, meta));
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 1.0f, 0.0f);
        renderblocks.b(par1Block, 0.0, 0.0, 0.0, par1Block.a(1, meta));
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, -1.0f);
        renderblocks.c(par1Block, 0.0, 0.0, 0.0, par1Block.a(2, meta));
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, 1.0f);
        renderblocks.d(par1Block, 0.0, 0.0, 0.0, par1Block.a(3, meta));
        tessellator.a();
        tessellator.b();
        tessellator.b(-1.0f, 0.0f, 0.0f);
        renderblocks.e(par1Block, 0.0, 0.0, 0.0, par1Block.a(4, meta));
        tessellator.a();
        tessellator.b();
        tessellator.b(1.0f, 0.0f, 0.0f);
        renderblocks.f(par1Block, 0.0, 0.0, 0.0, par1Block.a(5, meta));
        tessellator.a();
    }
    
    public static void renderInvJar(final vl renderblocks, final pb par1Block, final int meta) {
        final adz tessellator = adz.a;
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        par1Block.a(0.1875f, 0.0f, 0.1875f, 0.8125f, 0.875f, 0.8125f);
        tessellator.b();
        tessellator.b(0.0f, -1.0f, 0.0f);
        renderblocks.a(par1Block, 0.0, 0.0, 0.0, BlockTFComplex.jarTop);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 1.0f, 0.0f);
        renderblocks.b(par1Block, 0.0, 0.0, 0.0, BlockTFComplex.jarTop);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, -1.0f);
        renderblocks.c(par1Block, 0.0, 0.0, 0.0, BlockTFComplex.jarSide);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, 1.0f);
        renderblocks.d(par1Block, 0.0, 0.0, 0.0, BlockTFComplex.jarSide);
        tessellator.a();
        tessellator.b();
        tessellator.b(-1.0f, 0.0f, 0.0f);
        renderblocks.e(par1Block, 0.0, 0.0, 0.0, BlockTFComplex.jarSide);
        tessellator.a();
        tessellator.b();
        tessellator.b(1.0f, 0.0f, 0.0f);
        renderblocks.f(par1Block, 0.0, 0.0, 0.0, BlockTFComplex.jarSide);
        tessellator.a();
        par1Block.a(0.25f, 0.75f, 0.25f, 0.75f, 1.0f, 0.75f);
        tessellator.b();
        tessellator.b(0.0f, -1.0f, 0.0f);
        renderblocks.a(par1Block, 0.0, 0.0, 0.0, BlockTFComplex.jarLid);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 1.0f, 0.0f);
        renderblocks.b(par1Block, 0.0, 0.0, 0.0, BlockTFComplex.jarLid);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, -1.0f);
        renderblocks.c(par1Block, 0.0, 0.0, 0.0, BlockTFComplex.jarLid);
        tessellator.a();
        tessellator.b();
        tessellator.b(0.0f, 0.0f, 1.0f);
        renderblocks.d(par1Block, 0.0, 0.0, 0.0, BlockTFComplex.jarLid);
        tessellator.a();
        tessellator.b();
        tessellator.b(-1.0f, 0.0f, 0.0f);
        renderblocks.e(par1Block, 0.0, 0.0, 0.0, BlockTFComplex.jarLid);
        tessellator.a();
        tessellator.b();
        tessellator.b(1.0f, 0.0f, 0.0f);
        renderblocks.f(par1Block, 0.0, 0.0, 0.0, BlockTFComplex.jarLid);
        tessellator.a();
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        par1Block.h();
    }
    
    static {
        BlockTFComplex.jarTop = 7;
        BlockTFComplex.jarSide = 8;
        BlockTFComplex.jarLid = 9;
        BlockTFComplex.tinkerTop = 39;
        BlockTFComplex.tinkerSide = 55;
    }
}
