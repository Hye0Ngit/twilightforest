// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.loot.TFTreasure;
import twilightforest.util.FeaturePlacers;
import twilightforest.entity.TFEntities;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import twilightforest.TwilightForestMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import twilightforest.world.components.processors.StoneBricksVariants;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.processors.TargetedRotProcessor;

public class QuestGrove extends TwilightTemplateStructurePiece
{
    private static final TargetedRotProcessor MOSSY_BRICK_DECAY;
    
    public QuestGrove(final ServerLevel serverLevel, final CompoundTag compoundTag) {
        super(TFFeature.TFQuestGrove, compoundTag, serverLevel, TwilightTemplateStructurePiece.readSettings(compoundTag).m_74383_((StructureProcessor)StoneBricksVariants.INSTANCE));
    }
    
    public QuestGrove(final StructureManager structureManager, final BlockPos templatePosition) {
        super(TFFeature.TFQuestGrove, 0, structureManager, TwilightForestMod.prefix("quest_grove"), TwilightTemplateStructurePiece.makeSettings(Rotation.NONE).m_74383_((StructureProcessor)QuestGrove.MOSSY_BRICK_DECAY).m_74383_((StructureProcessor)StoneBricksVariants.INSTANCE), templatePosition);
    }
    
    public boolean m_7832_(final WorldGenLevel level, final StructureFeatureManager structureFeatureManager, final ChunkGenerator chunkGenerator, final Random random, final BoundingBox boundingBox, final ChunkPos chunkPos, final BlockPos pos) {
        return this.placePieceAdjusted(level, structureFeatureManager, chunkGenerator, random, boundingBox, chunkPos, pos, -2);
    }
    
    protected void m_7756_(final String name, final BlockPos pos, final ServerLevelAccessor levelAccessor, final Random random, final BoundingBox boundingBox) {
        if (!boundingBox.m_71051_((Vec3i)pos)) {
            return;
        }
        if ("quest_ram".equals(name)) {
            FeaturePlacers.placeEntity(TFEntities.QUEST_RAM, pos, levelAccessor);
        }
        else if ("dispenser".equals(name)) {
            TFTreasure.QUEST_GROVE.generateLootContainer((LevelAccessor)levelAccessor, pos, (BlockState)Blocks.f_50286_.m_49966_().m_61124_((Property)DispenserBlock.f_52659_, (Comparable)this.f_73657_.m_74404_().m_55954_(Direction.NORTH)), 22, random.nextLong());
        }
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BEARD;
    }
    
    static {
        MOSSY_BRICK_DECAY = new TargetedRotProcessor((ImmutableSet<BlockState>)ImmutableSet.of((Object)Blocks.f_50223_.m_49966_()), 0.5f);
    }
}
