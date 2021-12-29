// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api.internal;

import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;

public class WeightedRandomLoot extends WeightedRandom.Item
{
    public ItemStack item;
    public static ArrayList<WeightedRandomLoot> lootBagCommon;
    public static ArrayList<WeightedRandomLoot> lootBagUncommon;
    public static ArrayList<WeightedRandomLoot> lootBagRare;
    
    public WeightedRandomLoot(final ItemStack stack, final int weight) {
        super(weight);
        this.item = stack;
    }
    
    static {
        WeightedRandomLoot.lootBagCommon = new ArrayList<WeightedRandomLoot>();
        WeightedRandomLoot.lootBagUncommon = new ArrayList<WeightedRandomLoot>();
        WeightedRandomLoot.lootBagRare = new ArrayList<WeightedRandomLoot>();
    }
}
