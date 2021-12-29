// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures;

import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import twilightforest.entity.TFEntities;
import net.minecraft.util.Mth;
import twilightforest.world.components.feature.BlockSpikeFeature;
import net.minecraft.world.level.block.Blocks;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.Vec3i;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.feature.config.SpikeConfig;

public class HollowHillComponent extends TFStructureComponentOld
{
    private static final int[] stalactitesForSizes;
    private static final int[] spawnersForSizes;
    private static final int[] chestsForSizes;
    protected static final SpikeConfig STONE_STALACTITE;
    protected static final SpikeConfig STONE_STALAGMITE;
    private final int hillSize;
    final int radius;
    final int hdiam;
    
    public HollowHillComponent(final ServerLevel level, final CompoundTag nbt) {
        this(TFFeature.TFHill, nbt);
    }
    
    public HollowHillComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
        this.hillSize = nbt.m_128451_("hillSize");
        this.radius = (this.hillSize * 2 + 1) * 8 - 6;
        this.hdiam = (this.hillSize * 2 + 1) * 16;
    }
    
    public HollowHillComponent(final StructurePieceType piece, final TFFeature feature, final int i, final int size, final int x, final int y, final int z) {
        super(piece, feature, i, x, y, z);
        this.m_73519_(Direction.SOUTH);
        this.hillSize = size;
        this.radius = (this.hillSize * 2 + 1) * 8 - 6;
        this.hdiam = (this.hillSize * 2 + 1) * 16;
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, -this.radius, -(3 + this.hillSize), -this.radius, this.radius * 2, this.radius / 2, this.radius * 2, Direction.SOUTH);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128405_("hillSize", this.hillSize);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final int stalactiteCount = HollowHillComponent.stalactitesForSizes[this.hillSize];
        for (int i = 0; i < stalactiteCount; ++i) {
            final BlockPos.MutableBlockPos dest = this.randomCeilingCoordinates(rand, (float)this.radius);
            this.generateOreStalactite(world, (Vec3i)dest.m_122184_(0, 1, 0), sbb);
        }
        for (int i = 0; i < stalactiteCount; ++i) {
            final BlockPos.MutableBlockPos dest = this.randomCeilingCoordinates(rand, (float)this.radius);
            this.generateBlockSpike(world, HollowHillComponent.STONE_STALACTITE, dest.m_123341_(), dest.m_123342_(), dest.m_123343_(), sbb);
        }
        for (int i = 0; i < stalactiteCount; ++i) {
            final BlockPos.MutableBlockPos dest = this.randomFloorCoordinates(rand, (float)this.radius);
            this.generateBlockSpike(world, HollowHillComponent.STONE_STALAGMITE, dest.m_123341_(), dest.m_123342_(), dest.m_123343_(), sbb);
        }
        for (int i = 0; i < HollowHillComponent.spawnersForSizes[this.hillSize]; ++i) {
            final BlockPos.MutableBlockPos dest = this.randomFloorCoordinates(rand, (float)this.radius);
            final EntityType<?> mobID = this.getMobID(rand);
            this.setSpawner(world, (Vec3i)dest.m_122184_(0, 1, 0), sbb, mobID);
        }
        for (int i = 0; i < HollowHillComponent.chestsForSizes[this.hillSize]; ++i) {
            final BlockPos.MutableBlockPos dest = this.randomFloorCoordinates(rand, (float)this.radius);
            this.generateTreasureChest(world, (Vec3i)dest.m_122184_(0, 1, 0), sbb);
        }
        return true;
    }
    
    protected void generateTreasureChest(final WorldGenLevel world, final Vec3i pos, final BoundingBox sbb) {
        this.generateTreasureChest(world, pos.m_123341_(), pos.m_123342_(), pos.m_123343_(), sbb);
    }
    
    protected void generateTreasureChest(final WorldGenLevel world, final int x, final int y, final int z, final BoundingBox sbb) {
        final Random chestRNG = new Random(world.m_7328_() + x * (long)z);
        this.placeTreasureAtCurrentPosition(world, x, y, z, (this.hillSize == 3) ? TFTreasure.LARGE_HOLLOW_HILL : ((this.hillSize == 2) ? TFTreasure.MEDIUM_HOLLOW_HILL : TFTreasure.SMALL_HOLLOW_HILL), sbb);
        this.m_73434_(world, Blocks.f_50652_.m_49966_(), x, y - 1, z, sbb);
    }
    
    protected void generateOreStalactite(final WorldGenLevel world, final Vec3i pos, final BoundingBox sbb) {
        this.generateOreStalactite(world, pos.m_123341_(), pos.m_123342_(), pos.m_123343_(), sbb);
    }
    
    protected void generateOreStalactite(final WorldGenLevel world, final int x, final int y, final int z, final BoundingBox sbb) {
        final int dx = this.m_73392_(x, z);
        final int dy = this.m_73544_(y);
        final int dz = this.m_73525_(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.m_71051_((Vec3i)pos) && world.m_8055_(pos).m_60734_() != Blocks.f_50085_) {
            final Random stalRNG = new Random(world.m_7328_() + dx * (long)dz);
            final SpikeConfig stalag = BlockSpikeFeature.makeRandomOreStalactite(stalRNG, this.hillSize);
            BlockSpikeFeature.startSpike(world, pos, stalag, stalRNG);
        }
    }
    
    protected void generateBlockSpike(final WorldGenLevel world, final SpikeConfig config, final int x, final int y, final int z, final BoundingBox sbb) {
        final int dx = this.m_73392_(x, z);
        final int dy = this.m_73544_(y);
        final int dz = this.m_73525_(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.m_71051_((Vec3i)pos) && world.m_8055_(pos).m_60734_() != Blocks.f_50085_) {
            final Random stalRNG = new Random(world.m_7328_() + dx * (long)dz);
            BlockSpikeFeature.startSpike(world, pos, config, stalRNG);
        }
    }
    
    boolean isInHill(final int cx, final int cz) {
        final int dx = this.radius - cx;
        final int dz = this.radius - cz;
        return Mth.m_14116_((float)(dx * dx + dz * dz)) < this.radius;
    }
    
    @Deprecated
    int[] randomCoordinatesInHill2D(final Random rand) {
        return this.randomCoordinatesInHill2D(rand, this.radius);
    }
    
    @Deprecated
    int[] randomCoordinatesInHill2D(final Random rand, final int maximumRadius) {
        final Vec3i pos = (Vec3i)this.randomFloorCoordinates(rand, (float)maximumRadius);
        return new int[] { pos.m_123341_(), pos.m_123343_() };
    }
    
    BlockPos.MutableBlockPos randomFloorCoordinates(final Random rand, final float maximumRadius) {
        final float degree = rand.nextFloat() * 6.2831855f;
        final float radius = rand.nextFloat() * 0.9f * maximumRadius;
        final float dist = Mth.m_14116_(radius * radius);
        final float height = this.hillSize * 2 - Mth.m_14089_(dist / this.hdiam * 3.1415927f) * (this.hdiam / 20.0f);
        return new BlockPos.MutableBlockPos((double)(maximumRadius - Mth.m_14089_(degree) * radius), (double)height, (double)(maximumRadius - Mth.m_14031_(degree) * radius));
    }
    
    BlockPos.MutableBlockPos randomCeilingCoordinates(final Random rand, final float maximumRadius) {
        final float degree = rand.nextFloat() * 6.2831855f;
        final float radius = rand.nextFloat() * 0.9f * maximumRadius;
        final float dist = Mth.m_14116_(radius * radius);
        final float height = Mth.m_14089_(dist / this.hdiam * 3.1415927f) * (this.hdiam / 4.0f);
        return new BlockPos.MutableBlockPos((double)(maximumRadius - Mth.m_14089_(degree) * radius), (double)height, (double)(maximumRadius - Mth.m_14031_(degree) * radius));
    }
    
    protected EntityType<?> getMobID(final Random rand) {
        return this.getMobID(rand, this.hillSize);
    }
    
    protected EntityType<?> getMobID(final Random rand, final int level) {
        if (level == 1) {
            return this.getLevel1Mob(rand);
        }
        if (level == 2) {
            return this.getLevel2Mob(rand);
        }
        if (level == 3) {
            return this.getLevel3Mob(rand);
        }
        return (EntityType<?>)EntityType.f_20479_;
    }
    
    public EntityType<?> getLevel1Mob(final Random rand) {
        EntityType entityType = switch (rand.nextInt(10)) {
            case 3,  4,  5 -> EntityType.f_20479_;
            case 6,  7 -> EntityType.f_20501_;
            case 8 -> EntityType.f_20523_;
            case 9 -> TFEntities.REDCAP;
            default -> TFEntities.SWARM_SPIDER;
        };
        return (EntityType<?>)entityType;
    }
    
    public EntityType<?> getLevel2Mob(final Random rand) {
        EntityType entityType = switch (rand.nextInt(10)) {
            case 3,  4,  5 -> EntityType.f_20501_;
            case 6,  7 -> EntityType.f_20524_;
            case 8 -> TFEntities.SWARM_SPIDER;
            case 9 -> EntityType.f_20554_;
            default -> TFEntities.REDCAP;
        };
        return (EntityType<?>)entityType;
    }
    
    public EntityType<?> getLevel3Mob(final Random rand) {
        Object o = switch (rand.nextInt(11)) {
            case 0 -> TFEntities.SLIME_BEETLE;
            case 1 -> TFEntities.FIRE_BEETLE;
            case 2 -> TFEntities.PINCH_BEETLE;
            case 3,  4,  5 -> EntityType.f_20524_;
            case 6,  7,  8 -> EntityType.f_20554_;
            case 9 -> EntityType.f_20558_;
            default -> TFEntities.WRAITH;
        };
        return (EntityType<?>)o;
    }
    
    static {
        stalactitesForSizes = new int[] { 0, 128, 256, 512 };
        spawnersForSizes = new int[] { 0, 1, 4, 9 };
        chestsForSizes = new int[] { 0, 2, 6, 12 };
        STONE_STALACTITE = new SpikeConfig((BlockStateProvider)new SimpleStateProvider(Blocks.f_50069_.m_49966_()), (IntProvider)UniformInt.m_146622_(5, 11), (IntProvider)UniformInt.m_146622_(4, 5), true);
        STONE_STALAGMITE = new SpikeConfig((BlockStateProvider)new SimpleStateProvider(Blocks.f_50069_.m_49966_()), (IntProvider)UniformInt.m_146622_(5, 10), (IntProvider)UniformInt.m_146622_(4, 5), false);
    }
}
