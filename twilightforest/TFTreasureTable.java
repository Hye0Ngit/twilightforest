// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;

public class TFTreasureTable
{
    private static final int DEFAULT_RARITY = 10;
    protected ArrayList list;
    
    public TFTreasureTable() {
        this.list = new ArrayList();
    }
    
    public void add(final up item, final int quantity) {
        this.add(item, quantity, 10);
    }
    
    public void add(final up item, final int quantity, final int rarity) {
        this.list.add(new TFTreasureItem(item, quantity, rarity));
    }
    
    public void add(final ur itemstack) {
        this.list.add(new TFTreasureItem(itemstack, 10));
    }
    
    public void addEnchanted(final ur itemstack, final xc ench1, final int enchLevel1) {
        itemstack.a(ench1, enchLevel1);
        this.list.add(new TFTreasureItem(itemstack, 10));
    }
    
    public void addEnchanted(final ur itemstack, final xc ench1, final int enchLevel1, final xc ench2, final int enchLevel2) {
        itemstack.a(ench1, enchLevel1);
        itemstack.a(ench2, enchLevel2);
        this.list.add(new TFTreasureItem(itemstack, 10));
    }
    
    public void addEnchanted(final ur itemstack, final xc ench1, final int enchLevel1, final xc ench2, final int enchLevel2, final xc ench3, final int enchLevel3) {
        itemstack.a(ench1, enchLevel1);
        itemstack.a(ench2, enchLevel2);
        itemstack.a(ench3, enchLevel3);
        this.list.add(new TFTreasureItem(itemstack, 10));
    }
    
    public void addRandomEnchanted(final ur itemstack, final int randomLevel) {
        final TFTreasureItem treasure = new TFTreasureItem(itemstack, 10);
        treasure.setRandomEnchantmentLevel(randomLevel);
        this.list.add(treasure);
    }
    
    public void addRandomEnchanted(final up item, final int randomLevel) {
        final TFTreasureItem treasure = new TFTreasureItem(item, 1, 10);
        treasure.setRandomEnchantmentLevel(randomLevel);
        this.list.add(treasure);
    }
    
    public void add(final amq block, final int quantity) {
        this.add(block, quantity, 10);
    }
    
    public void add(final amq block, final int quantity, final int rarity) {
        this.list.add(new TFTreasureItem(block, quantity, rarity));
    }
    
    protected int total() {
        int value = 0;
        for (final TFTreasureItem item : this.list) {
            value += item.getRarity();
        }
        return value;
    }
    
    public ur getRandomItem(final Random rand) {
        int value = rand.nextInt(this.total());
        for (final TFTreasureItem item : this.list) {
            if (item.getRarity() > value) {
                return item.getItemStack(rand);
            }
            value -= item.getRarity();
        }
        return null;
    }
    
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
    
    public void clear() {
        this.list.clear();
    }
}
