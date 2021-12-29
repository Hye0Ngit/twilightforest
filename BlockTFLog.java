import java.util.ArrayList;
import java.util.Random;
import forge.ITextureProvider;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFLog extends pl implements ITextureProvider
{
    public static int sprTop;
    public static int sprOakSide;
    public static int sprCanopySide;
    public static int sprMangroveSide;
    
    protected BlockTFLog(final int i) {
        super(i);
    }
    
    public int a(final int side, final int meta) {
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
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new aai((ox)this, 1, 0));
        itemList.add(new aai((ox)this, 1, 1));
        itemList.add(new aai((ox)this, 1, 2));
    }
    
    public String getTextureFile() {
        return "/twilightforest/terrain.png";
    }
    
    static {
        BlockTFLog.sprTop = 0;
        BlockTFLog.sprOakSide = 1;
        BlockTFLog.sprCanopySide = 2;
        BlockTFLog.sprMangroveSide = 3;
    }
}
