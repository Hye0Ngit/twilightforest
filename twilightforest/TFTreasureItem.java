// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFTreasureItem
{
    yd itemStack;
    int rarity;
    int randomEnchantmentLevel;
    
    public TFTreasureItem(final yb item) {
        this(item, 1, 10);
    }
    
    public TFTreasureItem(final yb item, final int quantity) {
        this(item, quantity, 10);
    }
    
    public TFTreasureItem(final yb item, final int quantity, final int rarity) {
        this.randomEnchantmentLevel = 0;
        this.itemStack = new yd(item, quantity);
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final aqw block, final int quantity, final int rarity) {
        this.randomEnchantmentLevel = 0;
        this.itemStack = new yd(block, quantity);
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final yd itemStack, final int rarity) {
        this.randomEnchantmentLevel = 0;
        this.itemStack = itemStack.m();
        this.rarity = rarity;
    }
    
    public yd getItemStack(final Random rand) {
        final yd result = this.itemStack.m();
        result.b = rand.nextInt(result.b) + 1;
        if (result.x() && this.randomEnchantmentLevel > 0) {
            aav.a(rand, result, this.randomEnchantmentLevel);
        }
        return result;
    }
    
    public int getRarity() {
        return this.rarity;
    }
    
    public int getRandomEnchantmentLevel() {
        return this.randomEnchantmentLevel;
    }
    
    public void setRandomEnchantmentLevel(final int randomEnchantmentLevel) {
        this.randomEnchantmentLevel = randomEnchantmentLevel;
    }
}
