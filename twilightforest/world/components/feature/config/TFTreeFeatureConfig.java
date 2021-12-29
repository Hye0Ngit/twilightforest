// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.config;

import net.minecraft.world.level.block.SaplingBlock;
import com.google.common.collect.Lists;
import com.mojang.datafixers.kinds.Applicative;
import java.util.function.Supplier;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.block.Blocks;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraftforge.common.IPlantable;
import net.minecraft.core.BlockPos;
import java.util.Random;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import java.util.List;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class TFTreeFeatureConfig implements FeatureConfiguration
{
    public static final Codec<TFTreeFeatureConfig> codecTFTreeConfig;
    public final BlockStateProvider trunkProvider;
    public final BlockStateProvider leavesProvider;
    public final BlockStateProvider branchProvider;
    public final BlockStateProvider rootsProvider;
    public final int minHeight;
    public final int chanceAddFiveFirst;
    public final int chanceAddFiveSecond;
    public final boolean hasLeaves;
    public final boolean checkWater;
    public final BlockStateProvider sapling;
    public transient boolean forcePlacement;
    public final List<TreeDecorator> decorators;
    
    public TFTreeFeatureConfig(final BlockStateProvider trunk, final BlockStateProvider leaves, final BlockStateProvider branch, final BlockStateProvider roots, final int height, final int chanceFiveFirst, final int chanceFiveSecond, final boolean hasLeaves, final boolean checkWater, final BlockStateProvider sapling, final List<TreeDecorator> decorators) {
        this.trunkProvider = trunk;
        this.leavesProvider = leaves;
        this.branchProvider = branch;
        this.rootsProvider = roots;
        this.minHeight = height;
        this.chanceAddFiveFirst = Math.max(chanceFiveFirst, 1);
        this.chanceAddFiveSecond = Math.max(chanceFiveSecond, 1);
        this.hasLeaves = hasLeaves;
        this.checkWater = checkWater;
        this.sapling = sapling;
        this.decorators = decorators;
    }
    
    public void forcePlacement() {
        this.forcePlacement = true;
    }
    
    public IPlantable getSapling(final Random rand, final BlockPos pos) {
        return (IPlantable)this.sapling.m_7112_(rand, pos).m_60734_();
    }
    
    static {
        codecTFTreeConfig = RecordCodecBuilder.create(instance -> instance.group((App)BlockStateProvider.f_68747_.fieldOf("trunk_provider").forGetter(obj -> obj.trunkProvider), (App)BlockStateProvider.f_68747_.fieldOf("leaves_provider").forGetter(obj -> obj.leavesProvider), (App)BlockStateProvider.f_68747_.fieldOf("branch_provider").forGetter(obj -> obj.branchProvider), (App)BlockStateProvider.f_68747_.fieldOf("roots_provider").forGetter(obj -> obj.rootsProvider), (App)Codec.INT.fieldOf("minimum_size").orElse((Object)20).forGetter(obj -> obj.minHeight), (App)Codec.INT.fieldOf("add_first_five_chance").orElse((Object)1).forGetter(obj -> obj.chanceAddFiveFirst), (App)Codec.INT.fieldOf("add_second_five_chance").orElse((Object)1).forGetter(obj -> obj.chanceAddFiveSecond), (App)Codec.BOOL.fieldOf("has_leaves").orElse((Object)true).forGetter(obj -> obj.hasLeaves), (App)Codec.BOOL.fieldOf("check_water").orElse((Object)false).forGetter(obj -> obj.checkWater), (App)BlockStateProvider.f_68747_.fieldOf("sapling").orElse((Object)new SimpleStateProvider(Blocks.f_50746_.m_49966_())).forGetter(obj -> obj.sapling), (App)TreeDecorator.f_70021_.listOf().fieldOf("decorators").orElseGet((Supplier)ImmutableList::of).forGetter(obj -> obj.decorators)).apply((Applicative)instance, TFTreeFeatureConfig::new));
    }
    
    public static class Builder
    {
        private BlockStateProvider trunkProvider;
        private BlockStateProvider leavesProvider;
        private BlockStateProvider branchProvider;
        private BlockStateProvider rootsProvider;
        private int baseHeight;
        private int chanceFirstFive;
        private int chanceSecondFive;
        private boolean hasLeaves;
        private boolean checkWater;
        private BlockStateProvider sapling;
        private List<TreeDecorator> decorators;
        
        public Builder(final BlockStateProvider trunk, final BlockStateProvider leaves, final BlockStateProvider branch, final BlockStateProvider roots) {
            this.decorators = Lists.newArrayList();
            this.trunkProvider = trunk;
            this.leavesProvider = leaves;
            this.branchProvider = branch;
            this.rootsProvider = roots;
        }
        
        public Builder minHeight(final int height) {
            this.baseHeight = height;
            return this;
        }
        
        public Builder chanceFirstFive(final int chance) {
            this.chanceFirstFive = chance;
            return this;
        }
        
        public Builder chanceSecondFive(final int chance) {
            this.chanceSecondFive = chance;
            return this;
        }
        
        public Builder noLeaves() {
            this.hasLeaves = false;
            return this;
        }
        
        public Builder checksWater() {
            this.checkWater = true;
            return this;
        }
        
        public Builder setSapling(final SaplingBlock plant) {
            this.sapling = (BlockStateProvider)new SimpleStateProvider(plant.m_49966_());
            return this;
        }
        
        public Builder addDecorator(final TreeDecorator deco) {
            this.decorators.add(deco);
            return this;
        }
        
        public TFTreeFeatureConfig build() {
            return new TFTreeFeatureConfig(this.trunkProvider, this.leavesProvider, this.branchProvider, this.rootsProvider, this.baseHeight, this.chanceFirstFive, this.chanceSecondFive, this.hasLeaves, this.checkWater, this.sapling, this.decorators);
        }
    }
}
