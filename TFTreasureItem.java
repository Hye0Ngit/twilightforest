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
    
    public TFTreasureItem(final ym item) {
        this(item, 1, 10);
    }
    
    public TFTreasureItem(final ym item, final int quantity) {
        this(item, quantity, 10);
    }
    
    public TFTreasureItem(final ym item, final int quantity, final int rarity) {
        this.itemID = item.bQ;
        this.itemDamage = 0;
        this.quantity = quantity;
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final ox block, final int quantity, final int rarity) {
        this.itemID = block.bO;
        this.itemDamage = 0;
        this.quantity = quantity;
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final aai itemStack, final int rarity) {
        this.itemID = itemStack.c;
        this.itemDamage = itemStack.i();
        this.quantity = itemStack.a;
        this.rarity = rarity;
    }
    
    public aai getItemStack(final Random rand) {
        return new aai(this.itemID, rand.nextInt(this.quantity) + 1, this.itemDamage);
    }
    
    public int getRarity() {
        return this.rarity;
    }
}
