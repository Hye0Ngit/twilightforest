import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFTreasureItem
{
    kp itemStack;
    int rarity;
    
    public TFTreasureItem(final id item) {
        this(item, 1, 10);
    }
    
    public TFTreasureItem(final id item, final int quantity) {
        this(item, quantity, 10);
    }
    
    public TFTreasureItem(final id item, final int quantity, final int rarity) {
        this.itemStack = new kp(item, quantity);
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final vz block, final int quantity, final int rarity) {
        this.itemStack = new kp(block, quantity);
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final kp itemStack, final int rarity) {
        this.itemStack = itemStack.j();
        this.rarity = rarity;
    }
    
    public kp getItemStack(final Random rand) {
        final kp result = this.itemStack.j();
        result.a = rand.nextInt(result.a) + 1;
        return result;
    }
    
    public int getRarity() {
        return this.rarity;
    }
}
