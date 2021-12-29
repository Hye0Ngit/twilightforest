// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFTreasureItem
{
    wg itemStack;
    int rarity;
    int randomEnchantmentLevel;
    
    public TFTreasureItem(final we item) {
        this(item, 1, 10);
    }
    
    public TFTreasureItem(final we item, final int quantity) {
        this(item, quantity, 10);
    }
    
    public TFTreasureItem(final we item, final int quantity, final int rarity) {
        this.randomEnchantmentLevel = 0;
        this.itemStack = new wg(item, quantity);
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final aou block, final int quantity, final int rarity) {
        this.randomEnchantmentLevel = 0;
        this.itemStack = new wg(block, quantity);
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final wg itemStack, final int rarity) {
        this.randomEnchantmentLevel = 0;
        this.itemStack = itemStack.m();
        this.rarity = rarity;
    }
    
    public wg getItemStack(final Random rand) {
        final wg result = this.itemStack.m();
        result.a = rand.nextInt(result.a) + 1;
        if (result.w() && this.randomEnchantmentLevel > 0) {
            yv.a(rand, result, this.randomEnchantmentLevel);
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
