// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.entity.TFEntities;
import net.minecraft.block.Block;
import twilightforest.world.feature.config.CaveStalactiteConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import twilightforest.world.feature.TFBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import twilightforest.world.feature.TFGenCaveStalactite;
import net.minecraft.util.math.vector.Vector3i;
import twilightforest.loot.TFTreasure;
import net.minecraft.entity.EntityType;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class HollowHillComponent extends TFStructureComponentOld
{
    int hillSize;
    int radius;
    
    public HollowHillComponent(final TemplateManager manager, final CompoundNBT nbt) {
        this(TFFeature.TFHill, nbt);
    }
    
    public HollowHillComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
        this.hillSize = nbt.func_74762_e("hillSize");
        this.radius = (this.hillSize * 2 + 1) * 8 - 6;
    }
    
    public HollowHillComponent(final IStructurePieceType piece, final TFFeature feature, final int i, final int size, final int x, final int y, final int z) {
        super(piece, feature, i);
        this.func_186164_a(Direction.SOUTH);
        this.hillSize = size;
        this.radius = (this.hillSize * 2 + 1) * 8 - 6;
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, -this.radius, -(3 + this.hillSize), -this.radius, this.radius * 2, this.radius / 2, this.radius * 2, Direction.SOUTH);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74768_a("hillSize", this.hillSize);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final int[] sna = { 0, 128, 256, 512 };
        final int sn = sna[this.hillSize];
        final int[] mga = { 0, 1, 4, 9 };
        final int mg = mga[this.hillSize];
        final int[] tca = { 0, 2, 6, 12 };
        final int tc = tca[this.hillSize];
        for (int i = 0; i < mg; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            final EntityType<?> mobID = this.getMobID(rand);
            this.setSpawner(world, dest[0], rand.nextInt(4), dest[1], sbb, mobID);
        }
        for (int i = 0; i < tc; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateTreasureChest(world, dest[0], 0, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateOreStalactite(world, generator, manager, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateBlockStalactite(world, generator, manager, Blocks.field_150348_b, 1.0f, true, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateBlockStalactite(world, generator, manager, Blocks.field_150348_b, 0.9f, false, dest[0], 1, dest[1], sbb);
        }
        if (this.hillSize == 3) {}
        return true;
    }
    
    protected void generateTreasureChest(final ISeedReader world, final int x, final int y, final int z, final MutableBoundingBox sbb) {
        final Random chestRNG = new Random(world.func_72905_C() + x * z);
        this.placeTreasureAtCurrentPosition(world, x, y, z, (this.hillSize == 3) ? TFTreasure.hill3 : ((this.hillSize == 2) ? TFTreasure.hill2 : TFTreasure.hill1), sbb);
        this.func_175811_a(world, Blocks.field_150347_e.func_176223_P(), x, y - 1, z, sbb);
    }
    
    protected void generateOreStalactite(final ISeedReader world, final ChunkGenerator generator, final StructureManager manager, final int x, final int y, final int z, final MutableBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vector3i)pos) && world.func_180495_p(pos).func_177230_c() != Blocks.field_150474_ac) {
            final Random stalRNG = new Random(world.func_72905_C() + dx * dz);
            final CaveStalactiteConfig stalag = TFGenCaveStalactite.makeRandomOreStalactite(stalRNG, this.hillSize);
            ((Feature)TFBiomeFeatures.CAVE_STALACTITE.get()).func_225566_b_((IFeatureConfig)stalag).func_242765_a(world, generator, stalRNG, pos);
        }
    }
    
    protected void generateBlockStalactite(final ISeedReader world, final ChunkGenerator generator, final StructureManager manager, final Block blockToGenerate, float length, final boolean up, final int x, final int y, final int z, final MutableBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vector3i)pos) && world.func_180495_p(pos).func_177230_c() != Blocks.field_150474_ac) {
            final Random stalRNG = new Random(world.func_72905_C() + dx * dz);
            if (this.hillSize == 1) {
                length *= 1.9f;
            }
            ((Feature)TFBiomeFeatures.CAVE_STALACTITE.get()).func_225566_b_((IFeatureConfig)new CaveStalactiteConfig(blockToGenerate.func_176223_P(), length, -1, -1, up)).func_242765_a(world, generator, stalRNG, pos);
        }
    }
    
    boolean isInHill(final int cx, final int cz) {
        final int dx = this.radius - cx;
        final int dz = this.radius - cz;
        final int dist = (int)Math.sqrt(dx * dx + dz * dz);
        return dist < this.radius;
    }
    
    boolean isInHill(final int mapX, final int mapY, final int mapZ) {
        final int dx = this.field_74887_e.field_78897_a + this.radius - mapX;
        final int dy = (this.field_74887_e.field_78895_b - mapY) * 2;
        final int dz = this.field_74887_e.field_78896_c + this.radius - mapZ;
        final int dist = dx * dx + dy * dy + dz * dz;
        return dist < this.radius * this.radius;
    }
    
    int[] getCoordsInHill2D(final Random rand) {
        return this.getCoordsInHill2D(rand, this.radius);
    }
    
    int[] getCoordsInHill2D(final Random rand, final int rad) {
        int rx;
        int rz;
        do {
            rx = rand.nextInt(2 * rad);
            rz = rand.nextInt(2 * rad);
        } while (!this.isInHill(rx, rz));
        final int[] coords = { rx, rz };
        return coords;
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
        return (EntityType<?>)EntityType.field_200748_an;
    }
    
    public EntityType<?> getLevel1Mob(final Random rand) {
        switch (rand.nextInt(10)) {
            default: {
                return TFEntities.swarm_spider;
            }
            case 3:
            case 4:
            case 5: {
                return (EntityType<?>)EntityType.field_200748_an;
            }
            case 6:
            case 7: {
                return (EntityType<?>)EntityType.field_200725_aD;
            }
            case 8: {
                return (EntityType<?>)EntityType.field_200740_af;
            }
            case 9: {
                return TFEntities.redcap;
            }
        }
    }
    
    public EntityType<?> getLevel2Mob(final Random rand) {
        switch (rand.nextInt(10)) {
            default: {
                return TFEntities.redcap;
            }
            case 3:
            case 4:
            case 5: {
                return (EntityType<?>)EntityType.field_200725_aD;
            }
            case 6:
            case 7: {
                return (EntityType<?>)EntityType.field_200741_ag;
            }
            case 8: {
                return TFEntities.swarm_spider;
            }
            case 9: {
                return (EntityType<?>)EntityType.field_200794_h;
            }
        }
    }
    
    public EntityType<?> getLevel3Mob(final Random rand) {
        switch (rand.nextInt(11)) {
            case 0: {
                return TFEntities.slime_beetle;
            }
            case 1: {
                return TFEntities.fire_beetle;
            }
            case 2: {
                return TFEntities.pinch_beetle;
            }
            case 3:
            case 4:
            case 5: {
                return (EntityType<?>)EntityType.field_200741_ag;
            }
            case 6:
            case 7:
            case 8: {
                return (EntityType<?>)EntityType.field_200794_h;
            }
            case 9: {
                return (EntityType<?>)EntityType.field_200797_k;
            }
            default: {
                return TFEntities.wraith;
            }
        }
    }
}
