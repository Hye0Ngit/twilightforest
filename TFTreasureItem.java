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
    
    public TFTreasureItem(final hg item) {
        this(item, 1, 10);
    }
    
    public TFTreasureItem(final hg item, final int quantity) {
        this(item, quantity, 10);
    }
    
    public TFTreasureItem(final hg item, final int quantity, final int rarity) {
        this.itemID = item.bN;
        this.itemDamage = 0;
        this.quantity = quantity;
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final ud block, final int quantity, final int rarity) {
        this.itemID = block.bO;
        this.itemDamage = 0;
        this.quantity = quantity;
        this.rarity = rarity;
    }
    
    public TFTreasureItem(final jm itemStack, final int rarity) {
        this.itemID = itemStack.c;
        this.itemDamage = itemStack.h();
        this.quantity = itemStack.a;
        this.rarity = rarity;
    }
    
    public jm getItemStack(final Random rand) {
        return new jm(this.itemID, rand.nextInt(this.quantity) + 1, this.itemDamage);
    }
    
    public int getRarity() {
        return this.rarity;
    }
}
