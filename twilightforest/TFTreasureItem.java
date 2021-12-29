// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFTreasureItem
{
    um itemStack;
    int rarity;
    int randomEnchantmentLevel;
    
    public TFTreasureItem(final uk item) {
        this(item, 1, 10);
    }
    
    public TFTreasureItem(final uk item, final int quantity) {
        this(item, quantity, 10);
    }
    
    public TFTreasureItem(final uk item, final int quantity, final int rarity) {
        this.randomEnchantmentLevel = 0;
        this.itemStack = new um(item, quantity);
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final amj block, final int quantity, final int rarity) {
        this.randomEnchantmentLevel = 0;
        this.itemStack = new um(block, quantity);
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final um itemStack, final int rarity) {
        this.randomEnchantmentLevel = 0;
        this.itemStack = itemStack.l();
        this.rarity = rarity;
    }
    
    public um getItemStack(final Random rand) {
        final um result = this.itemStack.l();
        result.a = rand.nextInt(result.a) + 1;
        if (result.v() && this.randomEnchantmentLevel > 0) {
            wy.a(rand, result, this.randomEnchantmentLevel);
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
