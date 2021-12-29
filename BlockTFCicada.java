// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFCicada extends BlockTFCritter
{
    public static int sprCicada;
    private Class cicadaEntityClass;
    
    protected BlockTFCicada(final int i) {
        super(i, p.p);
        this.cicadaEntityClass = TileEntityTFCicada.class;
        this.bL = BlockTFCicada.sprCicada;
    }
    
    public int c() {
        return mod_TwilightForest.cicadaRenderID;
    }
    
    @Override
    protected boolean canPlaceAt(final ry world, final int x, final int y, final int z) {
        return world.g(x, y, z) || world.e(x, y, z) == p.i;
    }
    
    public bq j_() {
        try {
            return this.cicadaEntityClass.newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
    
    public static boolean renderCicada(final acr renderblocks, final kq blockAccess, final int x, final int y, final int z, final yy block) {
        final cv tessellator = cv.a;
        final int spr = BlockTFCicada.sprCicada;
        final float brightness = block.d(blockAccess, x, y, z);
        tessellator.a(brightness, brightness, brightness);
        final int spr2 = (spr & 0xF) << 4;
        final int spr3 = spr & 0xF0;
        final double d = spr2 / 256.0f;
        final double d2 = (spr2 + 15.99f) / 256.0f;
        final double d3 = spr3 / 256.0f;
        final double d4 = (spr3 + 15.99f) / 256.0f;
        final int meta = blockAccess.d(x, y, z);
        final float f1 = 0.0f;
        final float f2 = 0.01f;
        if (meta == 1) {
            tessellator.a((double)(x + f2), (double)(y + 1 + f1), (double)(z + 1 + f1), d, d3);
            tessellator.a((double)(x + f2), (double)(y + 0 - f1), (double)(z + 1 + f1), d, d4);
            tessellator.a((double)(x + f2), (double)(y + 0 - f1), (double)(z + 0 - f1), d2, d4);
            tessellator.a((double)(x + f2), (double)(y + 1 + f1), (double)(z + 0 - f1), d2, d3);
        }
        if (meta == 2) {
            tessellator.a((double)(x + 1 - f2), (double)(y + 0 - f1), (double)(z + 1 + f1), d2, d4);
            tessellator.a((double)(x + 1 - f2), (double)(y + 1 + f1), (double)(z + 1 + f1), d2, d3);
            tessellator.a((double)(x + 1 - f2), (double)(y + 1 + f1), (double)(z + 0 - f1), d, d3);
            tessellator.a((double)(x + 1 - f2), (double)(y + 0 - f1), (double)(z + 0 - f1), d, d4);
        }
        if (meta == 3) {
            tessellator.a((double)(x + 1 + f1), (double)(y + 0 - f1), (double)(z + f2), d2, d4);
            tessellator.a((double)(x + 1 + f1), (double)(y + 1 + f1), (double)(z + f2), d2, d3);
            tessellator.a((double)(x + 0 - f1), (double)(y + 1 + f1), (double)(z + f2), d, d3);
            tessellator.a((double)(x + 0 - f1), (double)(y + 0 - f1), (double)(z + f2), d, d4);
        }
        if (meta == 4) {
            tessellator.a((double)(x + 1 + f1), (double)(y + 1 + f1), (double)(z + 1 - f2), d, d3);
            tessellator.a((double)(x + 1 + f1), (double)(y + 0 - f1), (double)(z + 1 - f2), d, d4);
            tessellator.a((double)(x + 0 - f1), (double)(y + 0 - f1), (double)(z + 1 - f2), d2, d4);
            tessellator.a((double)(x + 0 - f1), (double)(y + 1 + f1), (double)(z + 1 - f2), d2, d3);
        }
        return true;
    }
    
    static {
        BlockTFCicada.sprCicada = ModLoader.addOverride("/terrain.png", "/twilightforest/blocks/cicada-tiny.png");
    }
}
