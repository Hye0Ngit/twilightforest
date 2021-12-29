import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFTreasureTable
{
    protected ArrayList list;
    
    public TFTreasureTable() {
        this.list = new ArrayList();
    }
    
    public void add(final hg item, final int quantity) {
        this.add(item, quantity, 10);
    }
    
    public void add(final hg item, final int quantity, final int rarity) {
        this.list.add(new TFTreasureItem(item, quantity, rarity));
    }
    
    public void add(final ud block, final int quantity) {
        this.add(block, quantity, 10);
    }
    
    public void add(final ud block, final int quantity, final int rarity) {
        this.list.add(new TFTreasureItem(block, quantity, rarity));
    }
    
    protected int total() {
        int value = 0;
        for (final TFTreasureItem item : this.list) {
            value += item.getRarity();
        }
        return value;
    }
    
    public jm getRandomItem(final Random rand) {
        int value = rand.nextInt(this.total());
        for (final TFTreasureItem item : this.list) {
            if (item.getRarity() > value) {
                return item.getItemStack(rand);
            }
            value -= item.getRarity();
        }
        return null;
    }
}
