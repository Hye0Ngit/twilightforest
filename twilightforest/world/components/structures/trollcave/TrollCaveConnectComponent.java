// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.trollcave;

import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import java.util.Iterator;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import twilightforest.util.HugeMushroomUtil;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import twilightforest.util.RotationUtil;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.feature.config.SpikeConfig;

public class TrollCaveConnectComponent extends TrollCaveMainComponent
{
    protected static final SpikeConfig STONE_STALACTITE_SMALL;
    protected static final SpikeConfig STONE_STALAGMITE_SMALL;
    protected boolean[] openingTowards;
    
    public TrollCaveConnectComponent(final ServerLevel level, final CompoundTag nbt) {
        super(TrollCavePieces.TFTCCon, nbt);
        (this.openingTowards = new boolean[] { false, false, true, false })[0] = nbt.m_128471_("openingTowards0");
        this.openingTowards[1] = nbt.m_128471_("openingTowards1");
        this.openingTowards[2] = nbt.m_128471_("openingTowards2");
        this.openingTowards[3] = nbt.m_128471_("openingTowards3");
    }
    
    public TrollCaveConnectComponent(final TFFeature feature, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final Direction direction) {
        super(TrollCavePieces.TFTCCon, feature, index, x, y, z);
        this.openingTowards = new boolean[] { false, false, true, false };
        this.size = caveSize;
        this.height = caveHeight;
        this.m_73519_(direction);
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, direction);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128379_("openingTowards0", this.openingTowards[0]);
        tagCompound.m_128379_("openingTowards1", this.openingTowards[1]);
        tagCompound.m_128379_("openingTowards2", this.openingTowards[2]);
        tagCompound.m_128379_("openingTowards3", this.openingTowards[3]);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (this.m_73548_() < 3) {
            for (final Rotation rotation : RotationUtil.ROTATIONS) {
                final BlockPos dest = this.getValidOpening(rand, rotation);
                if (rand.nextBoolean() || !this.makeGardenCave(list, rand, this.m_73548_() + 1, dest.m_123341_(), dest.m_123342_(), dest.m_123343_(), 30, 15, rotation)) {
                    this.makeSmallerCave(list, rand, this.m_73548_() + 1, dest.m_123341_(), dest.m_123342_(), dest.m_123343_(), 20, 15, rotation);
                }
            }
        }
    }
    
    @Override
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.hollowCaveMiddle(world, sbb, rand, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        final Random decoRNG = new Random(world.m_7328_() + this.f_73383_.m_162395_() * 321534781L ^ this.f_73383_.m_162398_() * 756839L);
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            if (!this.openingTowards[rotation.ordinal()]) {
                this.decorateWall(world, sbb, decoRNG, rotation);
            }
        }
        decoRNG.setSeed(world.m_7328_() + this.f_73383_.m_162395_() * 321534781L ^ this.f_73383_.m_162398_() * 756839L);
        for (int i = 0; i < 32; ++i) {
            final BlockPos dest = (BlockPos)this.getCoordsInCave(decoRNG);
            this.generateBlockSpike(world, TrollCaveConnectComponent.STONE_STALACTITE_SMALL, (Vec3i)dest.m_175288_(this.height), sbb);
        }
        for (int i = 0; i < 32; ++i) {
            final BlockPos dest = (BlockPos)this.getCoordsInCave(decoRNG);
            this.generateBlockSpike(world, TrollCaveConnectComponent.STONE_STALAGMITE_SMALL, (Vec3i)dest.m_175288_(0), sbb);
        }
        decoRNG.setSeed(world.m_7328_() + this.f_73383_.m_162395_() * 321534781L ^ this.f_73383_.m_162398_() * 756839L);
        if (this.countExits() == 1 && decoRNG.nextInt(3) == 0) {
            this.makeTreasureCrate(world, sbb);
        }
        else if (decoRNG.nextInt(3) == 0) {
            this.makeMonolith(world, decoRNG, sbb);
        }
        return true;
    }
    
    protected void makeMonolith(final WorldGenLevel world, final Random rand, final BoundingBox sbb) {
        final int mid = this.size / 2;
        final int height = 7 + rand.nextInt(8);
        final Rotation rotation = RotationUtil.ROTATIONS[rand.nextInt(4)];
        this.fillBlocksRotated(world, sbb, mid - 1, 0, mid - 1, mid - 1, height, mid - 1, Blocks.f_50080_.m_49966_(), rotation);
        this.fillBlocksRotated(world, sbb, mid, 0, mid - 1, mid, height - 2, mid - 1, Blocks.f_50080_.m_49966_(), rotation);
        this.fillBlocksRotated(world, sbb, mid - 1, 0, mid, mid - 1, height - 2, mid, Blocks.f_50080_.m_49966_(), rotation);
        this.fillBlocksRotated(world, sbb, mid, 0, mid, mid, height - 4, mid, Blocks.f_50080_.m_49966_(), rotation);
    }
    
    private int countExits() {
        int count = 0;
        for (int i = 0; i < this.openingTowards.length; ++i) {
            if (this.openingTowards[i]) {
                ++count;
            }
        }
        return count;
    }
    
    private void decorateWall(final WorldGenLevel world, final BoundingBox sbb, final Random decoRNG, final Rotation rotation) {
        if (decoRNG.nextBoolean()) {
            this.decorateBracketMushrooms(world, sbb, decoRNG, rotation);
        }
        else if (decoRNG.nextBoolean()) {
            this.decorateStoneFormation(world, sbb, decoRNG, rotation);
            this.decorateStoneFormation(world, sbb, decoRNG, rotation);
        }
    }
    
    private void decorateStoneFormation(final WorldGenLevel world, final BoundingBox sbb, final Random decoRNG, final Rotation rotation) {
        int z = 5 + decoRNG.nextInt(7);
        int y;
        for (int startY = y = 1 + decoRNG.nextInt(2); y < this.height; y += 2) {
            final int width = 1;
            final int depth = 1 + ((decoRNG.nextInt(3) == 0) ? 1 : 0);
            this.makeSingleStoneFormation(world, sbb, decoRNG, rotation, z, y, width, depth);
            z += decoRNG.nextInt(4) - decoRNG.nextInt(4);
            if (z < 5 || z > this.size - 5) {
                z = 5 + decoRNG.nextInt(7);
            }
        }
    }
    
    private void makeSingleStoneFormation(final WorldGenLevel world, final BoundingBox sbb, final Random decoRNG, final Rotation rotation, final int z, final int y, final int width, final int depth) {
        if (decoRNG.nextInt(8) == 0) {
            this.fillBlocksRotated(world, sbb, this.size - (depth + 1), y - width, z - width, this.size - 1, y + width, z + width, Blocks.f_50080_.m_49966_(), rotation);
        }
        else if (decoRNG.nextInt(4) == 0) {
            this.fillBlocksRotated(world, sbb, this.size - (depth + 1), y - width, z - width, this.size - 1, y + width, z + width, ((Block)TFBlocks.TROLLSTEINN.get()).m_49966_(), rotation);
        }
        else {
            this.fillBlocksRotated(world, sbb, this.size - (depth + 1), y - width, z - width, this.size - 1, y + width, z + width, Blocks.f_50069_.m_49966_(), rotation);
        }
    }
    
    private void decorateStoneProjection(final WorldGenLevel world, final BoundingBox sbb, final Random decoRNG, final Rotation rotation) {
        final int z = 7 + decoRNG.nextInt(3) - decoRNG.nextInt(3);
        final int y = 7 + decoRNG.nextInt(3) - decoRNG.nextInt(3);
        this.randomlyFillBlocksRotated(world, sbb, decoRNG, 0.25f, this.size - 9, y, z, this.size - 2, y + 3, z + 3, ((Block)TFBlocks.TROLLSTEINN.get()).m_49966_(), Blocks.f_50069_.m_49966_(), rotation);
        if (decoRNG.nextBoolean()) {
            this.randomlyFillBlocksRotated(world, sbb, decoRNG, 0.25f, this.size - 9, 1, z, this.size - 6, y - 1, z + 3, ((Block)TFBlocks.TROLLSTEINN.get()).m_49966_(), Blocks.f_50069_.m_49966_(), rotation);
        }
        else {
            this.randomlyFillBlocksRotated(world, sbb, decoRNG, 0.25f, this.size - 9, y + 4, z, this.size - 6, this.height - 2, z + 3, ((Block)TFBlocks.TROLLSTEINN.get()).m_49966_(), Blocks.f_50069_.m_49966_(), rotation);
        }
    }
    
    private void decorateBracketMushrooms(final WorldGenLevel world, final BoundingBox sbb, final Random decoRNG, final Rotation rotation) {
        int z = 5 + decoRNG.nextInt(7);
        int y;
        for (int startY = y = 1 + decoRNG.nextInt(4); y < this.height; y += 2) {
            final int width = 1 + decoRNG.nextInt(2) + decoRNG.nextInt(2);
            final int depth = 1 + decoRNG.nextInt(2) + decoRNG.nextInt(2);
            final Block mushBlock = (Block)((decoRNG.nextInt(3) == 0) ? TFBlocks.HUGE_MUSHGLOOM.get() : (decoRNG.nextBoolean() ? Blocks.f_50180_ : Blocks.f_50181_));
            this.makeSingleBracketMushroom(world, sbb, rotation, z, y, width, depth, mushBlock.m_49966_());
            z += decoRNG.nextInt(4) - decoRNG.nextInt(4);
            if (z < 5 || z > this.size - 5) {
                z = 5 + decoRNG.nextInt(7);
            }
        }
    }
    
    private void makeSingleBracketMushroom(final WorldGenLevel world, final BoundingBox sbb, final Rotation rotation, final int z, final int y, final int width, final int depth, final BlockState mushBlock) {
        this.fillBlocksRotated(world, sbb, this.size - depth, y, z - (width - 1), this.size - 2, y, z + (width - 1), HugeMushroomUtil.getState(HugeMushroomUtil.HugeMushroomType.CENTER, mushBlock), rotation);
        this.fillBlocksRotated(world, sbb, this.size - (depth + 1), y, z - (width - 1), this.size - (depth + 1), y, z + (width - 1), this.getMushroomState(mushBlock, HugeMushroomUtil.HugeMushroomType.EAST), rotation);
        final BlockState northMushroom = this.getMushroomState(mushBlock, HugeMushroomUtil.HugeMushroomType.SOUTH);
        for (int d = 0; d < depth - 1; ++d) {
            this.setBlockStateRotated(world, northMushroom, this.size - (2 + d), y, z - width, rotation, sbb);
        }
        final BlockState northWestMushroom = this.getMushroomState(mushBlock, HugeMushroomUtil.HugeMushroomType.SOUTH_EAST);
        this.setBlockStateRotated(world, northWestMushroom, this.size - (depth + 1), y, z - width, rotation, sbb);
        final BlockState southMushroom = this.getMushroomState(mushBlock, HugeMushroomUtil.HugeMushroomType.NORTH);
        for (int d2 = 0; d2 < depth - 1; ++d2) {
            this.setBlockStateRotated(world, southMushroom, this.size - (2 + d2), y, z + width, rotation, sbb);
        }
        final BlockState southWestMushroom = this.getMushroomState(mushBlock, HugeMushroomUtil.HugeMushroomType.NORTH_EAST);
        this.setBlockStateRotated(world, southWestMushroom, this.size - (depth + 1), y, z + width, rotation, sbb);
    }
    
    private BlockState getMushroomState(final BlockState mushroomBlockState, final HugeMushroomUtil.HugeMushroomType defaultRotation) {
        return HugeMushroomUtil.getState(defaultRotation, mushroomBlockState);
    }
    
    protected boolean makeGardenCave(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final BlockPos dest = this.offsetTowerCCoords(x, y, z, caveSize, direction);
        final TrollCaveMainComponent cave = new TrollCaveGardenComponent(this.getFeatureType(), index, dest.m_123341_(), dest.m_123342_(), dest.m_123343_(), caveSize, caveHeight, direction);
        final StructurePiece intersect = list.m_141921_(cave.m_73547_());
        final StructurePiece otherGarden = this.findNearbyGarden(list, cave.m_73547_());
        if ((intersect == null || intersect == this) && otherGarden == null) {
            list.m_142679_((StructurePiece)cave);
            cave.m_142537_(this, list, rand);
            return this.openingTowards[rotation.ordinal()] = true;
        }
        return false;
    }
    
    private StructurePiece findNearbyGarden(final StructurePieceAccessor list, final BoundingBox boundingBox) {
        final BoundingBox largeBox = new BoundingBox(boundingBox.m_162394_());
        if (list instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)list;
            for (final StructurePiece component : start.m_73602_()) {
                if (component instanceof TrollCaveGardenComponent && component.m_73547_().m_71049_(largeBox)) {
                    return component;
                }
            }
        }
        return null;
    }
    
    @Override
    protected boolean makeSmallerCave(final StructurePieceAccessor list, final Random rand, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final Rotation rotation) {
        return super.makeSmallerCave(list, rand, index, x, y, z, caveSize, caveHeight, rotation) && (this.openingTowards[rotation.ordinal()] = true);
    }
    
    static {
        STONE_STALACTITE_SMALL = new SpikeConfig((BlockStateProvider)new SimpleStateProvider(Blocks.f_50069_.m_49966_()), (IntProvider)UniformInt.m_146622_(5, 5), (IntProvider)UniformInt.m_146622_(2, 3), true);
        STONE_STALAGMITE_SMALL = new SpikeConfig((BlockStateProvider)new SimpleStateProvider(Blocks.f_50069_.m_49966_()), (IntProvider)UniformInt.m_146622_(2, 4), (IntProvider)UniformInt.m_146622_(2, 3), false);
    }
}
