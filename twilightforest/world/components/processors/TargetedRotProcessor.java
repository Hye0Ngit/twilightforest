// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.processors;

import java.util.function.BiFunction;
import com.mojang.datafixers.kinds.Applicative;
import java.util.function.Function;
import java.util.ArrayList;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import twilightforest.world.registration.TFStructureProcessors;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import javax.annotation.Nullable;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockRotProcessor;

public final class TargetedRotProcessor extends BlockRotProcessor
{
    public static final Codec<TargetedRotProcessor> CODEC;
    private final ImmutableSet<BlockState> blocksToRot;
    
    public TargetedRotProcessor(final ImmutableSet<BlockState> blocksToRot, final float integrity) {
        super(integrity);
        this.blocksToRot = blocksToRot;
    }
    
    @Nullable
    public StructureTemplate.StructureBlockInfo process(final LevelReader level, final BlockPos origin, final BlockPos centerBottom, final StructureTemplate.StructureBlockInfo originalBlockInfo, final StructureTemplate.StructureBlockInfo modifiedBlockInfo, final StructurePlaceSettings settings, @Nullable final StructureTemplate template) {
        if (!this.blocksToRot.contains((Object)modifiedBlockInfo.f_74676_)) {
            return modifiedBlockInfo;
        }
        return super.m_7382_(level, origin, centerBottom, originalBlockInfo, modifiedBlockInfo, settings);
    }
    
    protected StructureProcessorType<?> m_6953_() {
        return TFStructureProcessors.TARGETED_ROT;
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)BlockState.f_61039_.listOf().xmap((Function)ImmutableSet::copyOf, (Function)ArrayList::new).fieldOf("blocks_to_rot").forGetter(p -> p.blocksToRot), (App)Codec.FLOAT.fieldOf("integrity").orElse((Object)1.0f).forGetter(p -> p.f_74075_)).apply((Applicative)instance, (BiFunction)TargetedRotProcessor::new));
    }
}
