// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.entity.TFCreatures;
import twilightforest.world.TFGenCaveStalactite;
import net.minecraft.block.Block;
import twilightforest.TFTreasure;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFHollowHill extends StructureTFComponent
{
    int hillSize;
    int radius;
    
    public ComponentTFHollowHill() {
    }
    
    public ComponentTFHollowHill(final World world, final Random rand, final int i, final int size, final int x, final int y, final int z) {
        super(i);
        this.setCoordBaseMode(0);
        this.hillSize = size;
        this.radius = (this.hillSize * 2 + 1) * 8 - 6;
        this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -this.radius, -3, -this.radius, this.radius * 2, 10, this.radius * 2, 0);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("hillSize", this.hillSize);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.hillSize = par1NBTTagCompound.func_74762_e("hillSize");
        this.radius = (this.hillSize * 2 + 1) * 8 - 6;
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List list, final Random random) {
        super.func_74861_a(structurecomponent, list, random);
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
            final String mobID = this.getMobID(rand);
            this.placeSpawnerAtCurrentPosition(world, rand, dest[0], rand.nextInt(4), dest[1], mobID, sbb);
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
            this.generateStoneStalactite(world, 1.0f, true, dest[0], 1, dest[1], sbb);
        }
        for (int i = 0; i < sn; ++i) {
            final int[] dest = this.getCoordsInHill2D(rand);
            this.generateStoneStalactite(world, 0.9f, false, dest[0], 1, dest[1], sbb);
        }
        if (this.hillSize == 3) {}
        return true;
    }
    
    protected void generateTreasureChest(final World world, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final Random chestRNG = new Random(world.func_72905_C() + x * z);
        this.placeTreasureAtCurrentPosition(world, chestRNG, x, y, z, (this.hillSize == 3) ? TFTreasure.hill3 : ((this.hillSize == 2) ? TFTreasure.hill2 : TFTreasure.hill1), sbb);
        this.func_74870_b(world, Block.field_71978_w.field_71990_ca, 0, x, y - 1, z, sbb);
    }
    
    protected void generateOreStalactite(final World world, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        if (sbb.func_78890_b(dx, dy, dz) && world.func_72798_a(dx, dy, dz) != Block.field_72065_as.field_71990_ca) {
            final Random stalRNG = new Random(world.func_72905_C() + dx * dz);
            final TFGenCaveStalactite stalag = TFGenCaveStalactite.makeRandomOreStalactite(stalRNG, this.hillSize);
            stalag.func_76484_a(world, stalRNG, dx, dy, dz);
        }
    }
    
    protected void generateStoneStalactite(final World world, float length, final boolean up, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        if (sbb.func_78890_b(dx, dy, dz) && world.func_72798_a(dx, dy, dz) != Block.field_72065_as.field_71990_ca) {
            final Random stalRNG = new Random(world.func_72905_C() + dx * dz);
            if (this.hillSize == 1) {
                length *= 1.9f;
            }
            new TFGenCaveStalactite(Block.field_71981_t.field_71990_ca, length, up).func_76484_a(world, stalRNG, dx, dy, dz);
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
    
    protected String getMobID(final Random rand) {
        return this.getMobID(rand, this.hillSize);
    }
    
    protected String getMobID(final Random rand, final int level) {
        if (level == 1) {
            return this.getLevel1Mob(rand);
        }
        if (level == 2) {
            return this.getLevel2Mob(rand);
        }
        if (level == 3) {
            return this.getLevel3Mob(rand);
        }
        return "Spider";
    }
    
    public String getLevel1Mob(final Random rand) {
        switch (rand.nextInt(10)) {
            case 0:
            case 1:
            case 2: {
                return TFCreatures.getSpawnerNameFor("Swarm Spider");
            }
            case 3:
            case 4:
            case 5: {
                return "Spider";
            }
            case 6:
            case 7: {
                return "Zombie";
            }
            case 8: {
                return "Silverfish";
            }
            case 9: {
                return TFCreatures.getSpawnerNameFor("Redcap");
            }
            default: {
                return TFCreatures.getSpawnerNameFor("Swarm Spider");
            }
        }
    }
    
    public String getLevel2Mob(final Random rand) {
        switch (rand.nextInt(10)) {
            case 0:
            case 1:
            case 2: {
                return TFCreatures.getSpawnerNameFor("Redcap");
            }
            case 3:
            case 4:
            case 5: {
                return "Zombie";
            }
            case 6:
            case 7: {
                return "Skeleton";
            }
            case 8: {
                return TFCreatures.getSpawnerNameFor("Swarm Spider");
            }
            case 9: {
                return "CaveSpider";
            }
            default: {
                return TFCreatures.getSpawnerNameFor("Redcap");
            }
        }
    }
    
    public String getLevel3Mob(final Random rand) {
        switch (rand.nextInt(11)) {
            case 0: {
                return TFCreatures.getSpawnerNameFor("Slime Beetle");
            }
            case 1: {
                return TFCreatures.getSpawnerNameFor("Fire Beetle");
            }
            case 2: {
                return TFCreatures.getSpawnerNameFor("Pinch Beetle");
            }
            case 3:
            case 4:
            case 5: {
                return "Skeleton";
            }
            case 6:
            case 7:
            case 8: {
                return "CaveSpider";
            }
            case 9: {
                return "Creeper";
            }
            default: {
                return TFCreatures.getSpawnerNameFor("Twilight Wraith");
            }
        }
    }
}
