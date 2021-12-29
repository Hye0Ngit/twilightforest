// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.trollcave;

import twilightforest.entity.monster.ArmoredGiant;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.monster.GiantMiner;
import twilightforest.entity.TFEntities;
import net.minecraft.core.Vec3i;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class CloudCastleComponent extends TFStructureComponentOld
{
    private boolean minerPlaced;
    private boolean warriorPlaced;
    
    public CloudCastleComponent(final ServerLevel level, final CompoundTag nbt) {
        super(TrollCavePieces.TFClCa, nbt);
        this.minerPlaced = false;
        this.warriorPlaced = false;
        this.minerPlaced = nbt.m_128471_("minerPlaced");
        this.warriorPlaced = nbt.m_128471_("warriorPlaced");
    }
    
    public CloudCastleComponent(final TFFeature feature, final int index, int x, int y, int z) {
        super(TrollCavePieces.TFClCa, feature, index, x, y, z);
        this.minerPlaced = false;
        this.warriorPlaced = false;
        this.m_73519_(Direction.SOUTH);
        x &= 0xFFFFFFFC;
        y &= 0xFFFFFFFC;
        z &= 0xFFFFFFFC;
        this.spawnListIndex = 1;
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, -8, -4, -8, 64, 16, 64, Direction.SOUTH);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128379_("minerPlaced", this.minerPlaced);
        tagCompound.m_128379_("warriorPlaced", this.warriorPlaced);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        boolean plus = rand.nextBoolean();
        int offset = rand.nextInt(5) - rand.nextInt(5);
        final CloudTreeComponent treeX = new CloudTreeComponent(this.getFeatureType(), this.m_73548_() + 1, this.f_73383_.m_162395_() + 8 + (plus ? 32 : -16), 168, this.f_73383_.m_162398_() + offset * 4);
        list.m_142679_((StructurePiece)treeX);
        treeX.m_142537_((StructurePiece)this, list, rand);
        plus = rand.nextBoolean();
        offset = rand.nextInt(5) - rand.nextInt(5);
        final CloudTreeComponent treeZ = new CloudTreeComponent(this.getFeatureType(), this.m_73548_() + 1, this.f_73383_.m_162395_() + offset * 4, 168, this.f_73383_.m_162398_() + 8 + (plus ? 32 : -16));
        list.m_142679_((StructurePiece)treeZ);
        treeZ.m_142537_((StructurePiece)this, list, rand);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73441_(world, sbb, 8, 0, 8, 23, 3, 23, ((Block)TFBlocks.FLUFFY_CLOUD.get()).m_49966_(), ((Block)TFBlocks.FLUFFY_CLOUD.get()).m_49966_(), false);
        this.m_73441_(world, sbb, 8, 4, 8, 23, 15, 23, ((Block)TFBlocks.GIANT_COBBLESTONE.get()).m_49966_(), ((Block)TFBlocks.GIANT_COBBLESTONE.get()).m_49966_(), false);
        this.m_73441_(world, sbb, 8, 16, 8, 23, 19, 23, ((Block)TFBlocks.GIANT_LOG.get()).m_49966_(), ((Block)TFBlocks.GIANT_LOG.get()).m_49966_(), false);
        this.m_73535_(world, sbb, 12, 4, 12, 19, 15, 19);
        this.m_73535_(world, sbb, 8, 4, 12, 12, 11, 15);
        if (!this.minerPlaced) {
            final int bx = this.m_73392_(14, 14);
            final int by = this.m_73544_(4);
            final int bz = this.m_73525_(14, 14);
            final BlockPos pos = new BlockPos(bx, by, bz);
            if (sbb.m_71051_((Vec3i)pos)) {
                this.minerPlaced = true;
                final GiantMiner miner = new GiantMiner(TFEntities.GIANT_MINER, (Level)world.m_6018_());
                miner.m_6034_((double)bx, (double)by, (double)bz);
                miner.m_21530_();
                miner.m_6518_((ServerLevelAccessor)world, world.m_6436_(pos), MobSpawnType.STRUCTURE, null, null);
                world.m_7967_((Entity)miner);
            }
        }
        if (!this.warriorPlaced) {
            final int bx = this.m_73392_(17, 17);
            final int by = this.m_73544_(4);
            final int bz = this.m_73525_(17, 17);
            final BlockPos pos = new BlockPos(bx, by, bz);
            if (sbb.m_71051_((Vec3i)pos)) {
                this.warriorPlaced = true;
                final ArmoredGiant warrior = new ArmoredGiant(TFEntities.ARMORED_GIANT, (Level)world.m_6018_());
                warrior.m_6034_((double)bx, (double)by, (double)bz);
                warrior.m_21530_();
                warrior.m_6518_((ServerLevelAccessor)world, world.m_6436_(pos), MobSpawnType.STRUCTURE, null, null);
                world.m_7967_((Entity)warrior);
            }
        }
        return true;
    }
}
