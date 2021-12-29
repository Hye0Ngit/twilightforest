// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import net.minecraft.world.level.storage.loot.ValidationContext;
import java.util.Map;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.resources.ResourceLocation;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import com.mojang.datafixers.util.Pair;
import java.util.List;
import net.minecraft.data.loot.LootTableProvider;

public class LootGenerator extends LootTableProvider
{
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> tables;
    
    public LootGenerator(final DataGenerator generator) {
        super(generator);
        this.tables = (List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>>)ImmutableList.of((Object)Pair.of((Object)BlockLootTables::new, (Object)LootContextParamSets.f_81421_), (Object)Pair.of((Object)ChestLootTables::new, (Object)LootContextParamSets.f_81411_), (Object)Pair.of((Object)EntityLootTables::new, (Object)LootContextParamSets.f_81415_));
    }
    
    protected void validate(final Map<ResourceLocation, LootTable> map, final ValidationContext validationtracker) {
    }
    
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return this.tables;
    }
    
    public String m_6055_() {
        return "TwilightForest loot tables";
    }
}
