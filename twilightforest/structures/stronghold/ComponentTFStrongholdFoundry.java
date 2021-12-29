// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.nbt.NBTTagCompound;

public class ComponentTFStrongholdFoundry extends StructureTFStrongholdComponent
{
    int entranceLevel;
    
    public ComponentTFStrongholdFoundry() {
    }
    
    public ComponentTFStrongholdFoundry(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("entranceLevel", this.entranceLevel);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.entranceLevel = par1NBTTagCompound.func_74762_e("entranceLevel");
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final int facing, final int x, final int y, final int z) {
        if (y > 17) {
            this.entranceLevel = 3;
            return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -20, 0, 18, 25, 18, facing);
        }
        if (y < 11) {
            this.entranceLevel = 1;
            return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -6, 0, 18, 25, 18, facing);
        }
        this.entranceLevel = 2;
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -13, 0, 18, 25, 18, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random random) {
        super.func_74861_a(parent, list, random);
        switch (this.entranceLevel) {
            case 1: {
                this.addDoor(4, 6, 0);
                this.addNewComponent(parent, list, random, 1, -1, 13, 13);
                this.addNewComponent(parent, list, random, 3, 18, 13, 4);
                this.addNewComponent(parent, list, random, 0, 13, 20, 18);
                break;
            }
            case 2: {
                this.addDoor(4, 13, 0);
                this.addNewComponent(parent, list, random, 1, -1, 6, 13);
                this.addNewComponent(parent, list, random, 3, 18, 20, 4);
                this.addNewComponent(parent, list, random, 0, 13, 13, 18);
                break;
            }
            case 3: {
                this.addDoor(4, 20, 0);
                this.addNewComponent(parent, list, random, 0, 13, 6, 18);
                this.addNewComponent(parent, list, random, 1, -1, 13, 13);
                this.addNewComponent(parent, list, random, 3, 18, 13, 4);
                break;
            }
        }
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 25, 17, rand, this.deco.randomBlocks);
        this.func_74884_a(world, sbb, 1, 0, 1, 16, 4, 16, Block.field_71938_D.field_71990_ca, 0, false);
        this.func_74882_a(world, sbb, 1, 19, 1, 16, 19, 16, false, rand, this.deco.randomBlocks);
        this.func_74878_a(world, sbb, 2, 19, 2, 15, 19, 15);
        this.func_74882_a(world, sbb, 1, 12, 1, 16, 12, 16, false, rand, this.deco.randomBlocks);
        this.func_74878_a(world, sbb, 2, 12, 2, 15, 12, 15);
        this.func_74882_a(world, sbb, 1, 5, 1, 16, 5, 16, false, rand, this.deco.randomBlocks);
        this.func_74878_a(world, sbb, 2, 5, 2, 15, 5, 15);
        this.func_74882_a(world, sbb, 1, 1, 1, 1, 24, 2, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 2, 1, 1, 2, 24, 1, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 16, 1, 1, 16, 24, 2, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 15, 1, 1, 15, 24, 1, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 1, 1, 15, 1, 24, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 2, 1, 16, 2, 24, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 16, 1, 15, 16, 24, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 15, 1, 16, 15, 24, 16, false, rand, this.deco.randomBlocks);
        final Random massRandom = new Random(rand.nextLong());
        for (int x = 4; x < 14; ++x) {
            for (int z = 4; z < 14; ++z) {
                for (int y = 8; y < 23; ++y) {
                    final float c = Math.abs(x - 8.5f) + Math.abs(z - 8.5f) + Math.abs(y - 18.0f);
                    final float r = 5.5f + (massRandom.nextFloat() - massRandom.nextFloat()) * 3.5f;
                    if (c < r) {
                        this.func_74864_a(world, Block.field_71981_t.field_71990_ca, 0, x, y, z, sbb);
                    }
                }
            }
        }
        for (int i = 0; i < 400; ++i) {
            final int dx = massRandom.nextInt(9) + 5;
            final int dz = massRandom.nextInt(9) + 5;
            final int dy = massRandom.nextInt(13) + 10;
            if (this.func_74866_a(world, dx, dy, dz, sbb) > 0) {
                for (int y2 = 0; y2 < 3; ++y2) {
                    this.func_74864_a(world, Block.field_71981_t.field_71990_ca, 0, dx, dy - y2, dz, sbb);
                }
            }
        }
        for (int i = 0; i < 8; ++i) {
            final int blockID = Block.field_72047_aN.field_71990_ca;
            final int blockMeta = 0;
            this.addOreToMass(world, sbb, massRandom, blockID, blockMeta);
        }
        for (int i = 0; i < 8; ++i) {
            final int blockID = Block.field_71949_H.field_71990_ca;
            final int blockMeta = 0;
            this.addOreToMass(world, sbb, massRandom, blockID, blockMeta);
        }
        for (int i = 0; i < 6; ++i) {
            final int blockID = Block.field_71941_G.field_71990_ca;
            final int blockMeta = 0;
            this.addOreToMass(world, sbb, massRandom, blockID, blockMeta);
        }
        for (int i = 0; i < 2; ++i) {
            final int blockID = Block.field_72014_bd.field_71990_ca;
            final int blockMeta = 0;
            this.addOreToMass(world, sbb, massRandom, blockID, blockMeta);
        }
        for (int i = 0; i < 2; ++i) {
            final int blockID = Block.field_72068_bR.field_71990_ca;
            final int blockMeta = 0;
            this.addOreToMass(world, sbb, massRandom, blockID, blockMeta);
        }
        for (int i = 0; i < 4; ++i) {
            final int blockID = Block.field_72073_aw.field_71990_ca;
            final int blockMeta = 0;
            this.addOreToMass(world, sbb, massRandom, blockID, blockMeta);
        }
        this.placeDoors(world, rand, sbb);
        return true;
    }
    
    private void addOreToMass(final World world, final StructureBoundingBox sbb, final Random massRandom, final int blockID, final int blockMeta) {
        for (int i = 0; i < 10; ++i) {
            final int dx = massRandom.nextInt(9) + 5;
            final int dz = massRandom.nextInt(9) + 5;
            final int dy = massRandom.nextInt(13) + 10;
            if (this.func_74866_a(world, dx, dy, dz, sbb) > 0) {
                this.func_74864_a(world, blockID, blockMeta, dx, dy, dz, sbb);
                break;
            }
        }
    }
}
