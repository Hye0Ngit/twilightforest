// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import java.util.ArrayList;

public class TFTreasureTable
{
    private static final int DEFAULT_RARITY = 10;
    protected ArrayList<TFTreasureItem> list;
    
    public TFTreasureTable() {
        this.list = new ArrayList<TFTreasureItem>();
    }
    
    public void add(final Item item, final int quantity) {
        this.add(item, quantity, 10);
    }
    
    public void add(final Item item, final int quantity, final int rarity) {
        this.list.add(new TFTreasureItem(item, quantity, rarity));
    }
    
    public void add(final ItemStack itemstack) {
        this.list.add(new TFTreasureItem(itemstack, 10));
    }
    
    public void addEnchanted(final ItemStack itemstack, final Enchantment ench1, final int enchLevel1) {
        itemstack.func_77966_a(ench1, enchLevel1);
        this.list.add(new TFTreasureItem(itemstack, 10));
    }
    
    public void addEnchantedBook(final Enchantment ench1, final int enchLevel1) {
        final ItemStack itemstack = Item.field_92105_bW.func_92111_a(new EnchantmentData(ench1, enchLevel1));
        this.list.add(new TFTreasureItem(itemstack, 10));
    }
    
    public void addEnchanted(final ItemStack itemstack, final Enchantment ench1, final int enchLevel1, final Enchantment ench2, final int enchLevel2) {
        itemstack.func_77966_a(ench1, enchLevel1);
        itemstack.func_77966_a(ench2, enchLevel2);
        this.list.add(new TFTreasureItem(itemstack, 10));
    }
    
    public void addEnchanted(final ItemStack itemstack, final Enchantment ench1, final int enchLevel1, final Enchantment ench2, final int enchLevel2, final Enchantment ench3, final int enchLevel3) {
        itemstack.func_77966_a(ench1, enchLevel1);
        itemstack.func_77966_a(ench2, enchLevel2);
        itemstack.func_77966_a(ench3, enchLevel3);
        this.list.add(new TFTreasureItem(itemstack, 10));
    }
    
    public void addRandomEnchanted(final ItemStack itemstack, final int randomLevel) {
        final TFTreasureItem treasure = new TFTreasureItem(itemstack, 10);
        treasure.setRandomEnchantmentLevel(randomLevel);
        this.list.add(treasure);
    }
    
    public void addRandomEnchanted(final Item item, final int randomLevel) {
        final TFTreasureItem treasure = new TFTreasureItem(item, 1, 10);
        treasure.setRandomEnchantmentLevel(randomLevel);
        this.list.add(treasure);
    }
    
    public void add(final Block block, final int quantity) {
        this.add(block, quantity, 10);
    }
    
    public void add(final Block block, final int quantity, final int rarity) {
        this.list.add(new TFTreasureItem(block, quantity, rarity));
    }
    
    protected int total() {
        int value = 0;
        for (final TFTreasureItem item : this.list) {
            value += item.getRarity();
        }
        return value;
    }
    
    public ItemStack getRandomItem(final Random rand) {
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
