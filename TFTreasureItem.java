import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFTreasureItem
{
    int itemID;
    int itemDamage;
    int quantity;
    int rarity;
    
    public TFTreasureItem(final acy item) {
        this(item, 1, 10);
    }
    
    public TFTreasureItem(final acy item, final int quantity) {
        this(item, quantity, 10);
    }
    
    public TFTreasureItem(final acy item, final int quantity, final int rarity) {
        this.itemID = item.bM;
        this.itemDamage = 0;
        this.quantity = quantity;
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final yy block, final int quantity, final int rarity) {
        this.itemID = block.bM;
        this.itemDamage = 0;
        this.quantity = quantity;
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final dk itemStack, final int rarity) {
        this.itemID = itemStack.c;
        this.itemDamage = itemStack.i();
        this.quantity = itemStack.a;
        this.rarity = rarity;
    }
    
    public dk getItemStack(final Random rand) {
        return new dk(this.itemID, rand.nextInt(this.quantity) + 1, this.itemDamage);
    }
    
    public int getRarity() {
        return this.rarity;
    }
}
