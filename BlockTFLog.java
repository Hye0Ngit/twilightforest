import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFLog extends uz
{
    public static int sprTop;
    public static int sprOakSide;
    public static int sprCanopySide;
    public static int sprMangroveSide;
    
    protected BlockTFLog(final int i) {
        super(i);
    }
    
    public int a(final int side, final int meta) {
        if (side <= 1) {
            return BlockTFLog.sprTop;
        }
        if (meta <= 0) {
            return BlockTFLog.sprOakSide;
        }
        if (meta == 1) {
            return BlockTFLog.sprCanopySide;
        }
        return BlockTFLog.sprMangroveSide;
    }
    
    public int a(final int i, final Random random, final int j) {
        return TFBlocks.wood.bO;
    }
    
    static {
        BlockTFLog.sprTop = ModLoader.addOverride("/terrain.png", "/twilightforest/blocks/SkyrootLogTop.png");
        BlockTFLog.sprOakSide = ModLoader.addOverride("/terrain.png", "/twilightforest/blocks/TwilightOakSide.png");
        BlockTFLog.sprCanopySide = ModLoader.addOverride("/terrain.png", "/twilightforest/blocks/TwilightCanopySide.png");
        BlockTFLog.sprMangroveSide = ModLoader.addOverride("/terrain.png", "/twilightforest/blocks/TwilightMangroveSide.png");
    }
}
