// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.lichtowerrevamp;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import java.util.Map;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.block.Mirror;
import twilightforest.world.components.processors.BoxCuttingProcessor;
import java.util.HashMap;
import net.minecraft.core.Direction;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.block.Rotation;
import twilightforest.TwilightForestMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TwilightTemplateStructurePiece;

public final class TowerFoyer extends TwilightTemplateStructurePiece
{
    public TowerFoyer(final ServerLevel serverLevel, final CompoundTag compoundTag) {
        super(LichTowerRevampPieces.TOWER_FOYER, compoundTag, serverLevel, TwilightTemplateStructurePiece.readSettings(compoundTag));
    }
    
    public TowerFoyer(final StructureManager structureManager, final BlockPos startPosition) {
        super(LichTowerRevampPieces.TOWER_FOYER, 0, structureManager, TwilightForestMod.prefix("lich_tower/foyer"), TwilightTemplateStructurePiece.makeSettings(Rotation.NONE), startPosition.m_6630_(3));
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor structureStart, final Random random) {
        super.m_142537_(parent, structureStart, random);
        final int randomCountTowerSegments = random.nextInt(5) + 15;
        final Direction front = this.f_73379_.m_55954_(Direction.NORTH);
        final BlockPos center = this.f_73383_.m_162394_();
        final BlockPos centralTowerOrigin = new BlockPos(center.m_123341_() - 15, this.f_73383_.m_162400_() - 30, center.m_123343_() - 15);
        final Map<BlockPos, Direction> sideTowerStarts = new HashMap<BlockPos, Direction>();
        final int totalSegments = (randomCountTowerSegments >> 1) - 2;
        this.beginSideTowers(structureStart, random, totalSegments, 0, front, Rotation.CLOCKWISE_90, centralTowerOrigin, sideTowerStarts);
        this.beginSideTowers(structureStart, random, totalSegments, 0, front, Rotation.COUNTERCLOCKWISE_90, centralTowerOrigin, sideTowerStarts);
        this.beginSideTowers(structureStart, random, totalSegments, 7, front, Rotation.NONE, centralTowerOrigin, sideTowerStarts);
        this.beginSideTowers(structureStart, random, totalSegments, 7, front, Rotation.CLOCKWISE_180, centralTowerOrigin, sideTowerStarts);
        final BoxCuttingProcessor cuttingProcessor = BoxCuttingProcessor.forLichTower(sideTowerStarts);
        Rotation climbingRotation = this.f_73379_;
        for (int i = 0; i < randomCountTowerSegments; ++i) {
            final CentralTowerSegment towerSegment = new CentralTowerSegment(this.structureManager, climbingRotation, cuttingProcessor, StructureTemplate.m_74587_(centralTowerOrigin, Mirror.NONE, climbingRotation, 30, 30).m_6630_(i * 4));
            towerSegment.m_142537_((StructurePiece)this, structureStart, random);
            structureStart.m_142679_((StructurePiece)towerSegment);
            climbingRotation = climbingRotation.m_55952_((this.f_73378_ == Mirror.NONE) ? Rotation.COUNTERCLOCKWISE_90 : Rotation.CLOCKWISE_90);
        }
    }
    
    private void beginSideTowers(final StructurePieceAccessor structureStart, final Random random, final int totalSegments, final int segmentStart, final Direction front, final Rotation fromFront, final BlockPos centralTowerOrigin, final Map<BlockPos, Direction> sideTowerStarts) {
        for (int i = segmentStart; i < totalSegments; ++i) {
            final float weight = i / (float)totalSegments * 2.0f;
            if (random.nextFloat() < weight) {
                final Rotation relativeRotation = fromFront.m_55952_(this.f_73379_);
                final Direction sideTowerDirection = relativeRotation.m_55954_(front);
                final BlockPos sideTowerPos = LichTowerUtil.getRandomOpeningPlacementPos(centralTowerOrigin, sideTowerDirection, Mirror.NONE, random, i << 1, this.f_73379_ == Rotation.NONE || this.f_73379_ == Rotation.CLOCKWISE_180);
                sideTowerStarts.put(sideTowerPos.m_142300_(sideTowerDirection), sideTowerDirection);
                final CentralTowerAttachment sideTower = CentralTowerAttachment.startRandomAttachment(this.structureManager, relativeRotation, sideTowerPos.m_5484_(sideTowerDirection, 2), random);
                sideTower.m_142537_((StructurePiece)this, structureStart, random);
                structureStart.m_142679_((StructurePiece)sideTower);
            }
        }
    }
    
    public boolean m_7832_(final WorldGenLevel level, final StructureFeatureManager structureFeatureManager, final ChunkGenerator chunkGenerator, final Random random, final BoundingBox boundingBox, final ChunkPos chunkPos, final BlockPos pos) {
        final boolean result = this.placePieceAdjusted(level, structureFeatureManager, chunkGenerator, random, boundingBox, chunkPos, pos, -3);
        final BlockPos placement = new BlockPos(this.f_73383_.m_162394_().m_123341_() + 1, this.f_73383_.m_162396_() + 7, this.f_73383_.m_162398_() + 16);
        if (boundingBox.m_71051_((Vec3i)placement)) {
            final ArmorStand armorStand = new ArmorStand(EntityType.f_20529_, (Level)level.m_6018_());
            armorStand.m_6593_((Component)new TextComponent("Welcome to the new Lich Tower! The design is heavily WIP and will be fleshed out significantly in later development builds"));
            armorStand.m_7678_((double)placement.m_123341_(), placement.m_123342_() + 0.5, placement.m_123343_() + 0.5, 0.0f, 0.0f);
            armorStand.m_20331_(true);
            armorStand.m_6842_(true);
            armorStand.m_20340_(true);
            armorStand.m_20225_(true);
            armorStand.m_20242_(true);
            armorStand.m_20088_().m_135381_(ArmorStand.f_31524_, (Object)(byte)((byte)armorStand.m_20088_().m_135370_(ArmorStand.f_31524_) | 0x10));
            level.m_7967_((Entity)armorStand);
        }
        return result;
    }
    
    protected void m_7756_(final String label, final BlockPos pos, final ServerLevelAccessor levelAccessor, final Random random, final BoundingBox boundingBox) {
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BEARD;
    }
}
