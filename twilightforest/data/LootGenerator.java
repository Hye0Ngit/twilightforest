// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import net.minecraft.loot.ValidationTracker;
import java.util.Map;
import com.google.common.collect.ImmutableList;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.data.DataGenerator;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootTable;
import net.minecraft.util.ResourceLocation;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import com.mojang.datafixers.util.Pair;
import java.util.List;
import net.minecraft.data.LootTableProvider;

public class LootGenerator extends LootTableProvider
{
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> tables;
    
    public LootGenerator(final DataGenerator generator) {
        super(generator);
        this.tables = (List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>>)ImmutableList.of((Object)Pair.of((Object)BlockLootTables::new, (Object)LootParameterSets.field_216267_h), (Object)Pair.of((Object)ChestLootTables::new, (Object)LootParameterSets.field_216261_b), (Object)Pair.of((Object)EntityLootTables::new, (Object)LootParameterSets.field_216263_d));
    }
    
    protected void validate(final Map<ResourceLocation, LootTable> map, final ValidationTracker validationtracker) {
    }
    
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return this.tables;
    }
    
    public String func_200397_b() {
        return "TwilightForest loot tables";
    }
}
