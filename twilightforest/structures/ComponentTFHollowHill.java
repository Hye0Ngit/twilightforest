// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.entity.EntityTFWraith;
import net.minecraft.entity.monster.EntityCreeper;
import twilightforest.entity.EntityTFPinchBeetle;
import twilightforest.entity.EntityTFFireBeetle;
import twilightforest.entity.EntityTFSlimeBeetle;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySkeleton;
import twilightforest.entity.EntityTFRedcap;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntityZombie;
import twilightforest.entity.EntityTFSwarmSpider;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.block.Block;
import twilightforest.world.feature.TFGenCaveStalactite;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import twilightforest.loot.TFTreasure;
import net.minecraft.util.ResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public class ComponentTFHollowHill extends StructureTFComponentOld
{
    int hillSize;
    int radius;
    
    public ComponentTFHollowHill() {
    }
    
    public ComponentTFHollowHill(final TFFeature feature, final World world, final Random rand, final int i, final int size, final int x, final int y, final int z) {
        super(feature, i);
        this.func_186164_a(EnumFacing.SOUTH);
        this.hillSize = size;
        this.radius = (this.hillSize * 2 + 1) * 8 - 6;
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -this.radius, -(3 + this.hillSize), -this.radius, this.radius * 2, this.radius / 2, this.radius * 2, EnumFacing.SOUTH);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74768_a("hillSize", this.hillSize);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.hillSize = tagCompound.func_74762_e("hillSize");
        this.radius = (this.hillSize * 2 + 1) * 8 - 6;
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int[] sna = { 0, 128, 256, 512 };
        final int sn = sna[this.hillSize];
        final int[] mga = { 0, 1, 4, 9 };
        final int mg = mga[this.hillSize];
        final int[] tca = { 0, 2, 6, 12 };
        final int tc = tca[this.hillSize];
        for (int i = 0; i < mg; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            final ResourceLocation mobID = this.getMobID(rand);
            this.setSpawner(world, dest[0], rand.nextInt(4), dest[1], sbb, mobID);
        }
        for (int i = 0; i < tc; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateTreasureChest(world, dest[0], 0, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateOreStalactite(world, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateBlockStalactite(world, Blocks.field_150348_b, 1.0f, true, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateBlockStalactite(world, Blocks.field_150348_b, 0.9f, false, dest[0], 1, dest[1], sbb);
        }
        if (this.hillSize == 3) {}
        return true;
    }
    
    protected void generateTreasureChest(final World world, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final Random chestRNG = new Random(world.func_72905_C() + x * z);
        this.placeTreasureAtCurrentPosition(world, chestRNG, x, y, z, (this.hillSize == 3) ? TFTreasure.hill3 : ((this.hillSize == 2) ? TFTreasure.hill2 : TFTreasure.hill1), sbb);
        this.func_175811_a(world, Blocks.field_150347_e.func_176223_P(), x, y - 1, z, sbb);
    }
    
    protected void generateOreStalactite(final World world, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vec3i)pos) && world.func_180495_p(pos).func_177230_c() != Blocks.field_150474_ac) {
            final Random stalRNG = new Random(world.func_72905_C() + dx * dz);
            final TFGenCaveStalactite stalag = TFGenCaveStalactite.makeRandomOreStalactite(stalRNG, this.hillSize);
            stalag.func_180709_b(world, stalRNG, pos);
        }
    }
    
    protected void generateBlockStalactite(final World world, final Block blockToGenerate, float length, final boolean up, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        final BlockPos pos = new BlockPos(dx, dy, dz);
        if (sbb.func_175898_b((Vec3i)pos) && world.func_180495_p(pos).func_177230_c() != Blocks.field_150474_ac) {
            final Random stalRNG = new Random(world.func_72905_C() + dx * dz);
            if (this.hillSize == 1) {
                length *= 1.9f;
            }
            new TFGenCaveStalactite(blockToGenerate, length, up).func_180709_b(world, stalRNG, pos);
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
    
    protected ResourceLocation getMobID(final Random rand) {
        return this.getMobID(rand, this.hillSize);
    }
    
    protected ResourceLocation getMobID(final Random rand, final int level) {
        if (level == 1) {
            return this.getLevel1Mob(rand);
        }
        if (level == 2) {
            return this.getLevel2Mob(rand);
        }
        if (level == 3) {
            return this.getLevel3Mob(rand);
        }
        return EntityList.func_191306_a((Class)EntitySpider.class);
    }
    
    public ResourceLocation getLevel1Mob(final Random rand) {
        switch (rand.nextInt(10)) {
            case 0:
            case 1:
            case 2: {
                return EntityList.func_191306_a((Class)EntityTFSwarmSpider.class);
            }
            case 3:
            case 4:
            case 5: {
                return EntityList.func_191306_a((Class)EntitySpider.class);
            }
            case 6:
            case 7: {
                return EntityList.func_191306_a((Class)EntityZombie.class);
            }
            case 8: {
                return EntityList.func_191306_a((Class)EntitySilverfish.class);
            }
            case 9: {
                return EntityList.func_191306_a((Class)EntityTFRedcap.class);
            }
            default: {
                return EntityList.func_191306_a((Class)EntityTFSwarmSpider.class);
            }
        }
    }
    
    public ResourceLocation getLevel2Mob(final Random rand) {
        switch (rand.nextInt(10)) {
            case 0:
            case 1:
            case 2: {
                return EntityList.func_191306_a((Class)EntityTFRedcap.class);
            }
            case 3:
            case 4:
            case 5: {
                return EntityList.func_191306_a((Class)EntityZombie.class);
            }
            case 6:
            case 7: {
                return EntityList.func_191306_a((Class)EntitySkeleton.class);
            }
            case 8: {
                return EntityList.func_191306_a((Class)EntityTFSwarmSpider.class);
            }
            case 9: {
                return EntityList.func_191306_a((Class)EntityCaveSpider.class);
            }
            default: {
                return EntityList.func_191306_a((Class)EntityTFRedcap.class);
            }
        }
    }
    
    public ResourceLocation getLevel3Mob(final Random rand) {
        switch (rand.nextInt(11)) {
            case 0: {
                return EntityList.func_191306_a((Class)EntityTFSlimeBeetle.class);
            }
            case 1: {
                return EntityList.func_191306_a((Class)EntityTFFireBeetle.class);
            }
            case 2: {
                return EntityList.func_191306_a((Class)EntityTFPinchBeetle.class);
            }
            case 3:
            case 4:
            case 5: {
                return EntityList.func_191306_a((Class)EntitySkeleton.class);
            }
            case 6:
            case 7:
            case 8: {
                return EntityList.func_191306_a((Class)EntityCaveSpider.class);
            }
            case 9: {
                return EntityList.func_191306_a((Class)EntityCreeper.class);
            }
            default: {
                return EntityList.func_191306_a((Class)EntityTFWraith.class);
            }
        }
    }
}
