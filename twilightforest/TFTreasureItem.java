// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFTreasureItem
{
    aan itemStack;
    int rarity;
    
    public TFTreasureItem(final yr item) {
        this(item, 1, 10);
    }
    
    public TFTreasureItem(final yr item, final int quantity) {
        this(item, quantity, 10);
    }
    
    public TFTreasureItem(final yr item, final int quantity, final int rarity) {
        this.itemStack = new aan(item, quantity);
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final pb block, final int quantity, final int rarity) {
        this.itemStack = new aan(block, quantity);
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final aan itemStack, final int rarity) {
        this.itemStack = itemStack.k();
        this.rarity = rarity;
    }
    
    public aan getItemStack(final Random rand) {
        final aan result = this.itemStack.k();
        result.a = rand.nextInt(result.a) + 1;
        return result;
    }
    
    public int getRarity() {
        return this.rarity;
    }
}
