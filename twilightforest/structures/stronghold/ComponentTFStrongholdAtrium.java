// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.world.gen.feature.WorldGenerator;
import twilightforest.world.TFGenSmallRainboak;
import twilightforest.world.TFGenSmallTwilightOak;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.nbt.NBTTagCompound;

public class ComponentTFStrongholdAtrium extends StructureTFStrongholdComponent
{
    private boolean enterBottom;
    
    public ComponentTFStrongholdAtrium() {
    }
    
    public ComponentTFStrongholdAtrium(final int i, final int facing, final int x, final int y, final int z) {
        super(i, facing, x, y, z);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74757_a("enterBottom", this.enterBottom);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.enterBottom = par1NBTTagCompound.func_74767_n("enterBottom");
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final int facing, final int x, final int y, final int z) {
        if (y > 17) {
            this.enterBottom = false;
        }
        else if (y < 11) {
            this.enterBottom = true;
        }
        else {
            this.enterBottom = ((z & 0x1) == 0x0);
        }
        if (this.enterBottom) {
            return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -4, -1, 0, 18, 14, 18, facing);
        }
        return StructureTFStrongholdComponent.getComponentToAddBoundingBox(x, y, z, -13, -8, 0, 18, 14, 18, facing);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random random) {
        super.func_74861_a(parent, list, random);
        if (this.enterBottom) {
            this.addDoor(4, 1, 0);
            this.addNewComponent(parent, list, random, 2, 13, 8, -1);
        }
        else {
            this.addDoor(13, 8, 0);
            this.addNewComponent(parent, list, random, 2, 4, 1, -1);
        }
        this.addNewComponent(parent, list, random, 0, 13, 1, 18);
        this.addNewComponent(parent, list, random, 0, 4, 8, 18);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 13, 17, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 1, 6, 1, 16, 7, 16, false, rand, this.deco.randomBlocks);
        this.func_74884_a(world, sbb, 5, 8, 5, 12, 8, 12, this.deco.fenceID, this.deco.fenceMeta, false);
        this.func_74878_a(world, sbb, 6, 6, 6, 11, 8, 11);
        this.placeBalconyPillar(world, sbb, 0);
        this.placeBalconyPillar(world, sbb, 1);
        this.placeBalconyPillar(world, sbb, 2);
        this.placeBalconyPillar(world, sbb, 3);
        this.func_74882_a(world, sbb, 1, 1, 1, 1, 12, 2, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 2, 1, 1, 2, 12, 1, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 16, 1, 1, 16, 12, 2, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 15, 1, 1, 15, 12, 1, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 1, 1, 15, 1, 12, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 2, 1, 16, 2, 12, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 16, 1, 15, 16, 12, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 15, 1, 16, 15, 12, 16, false, rand, this.deco.randomBlocks);
        this.func_74880_a(world, sbb, rand, 0.5f, 6, 0, 6, 11, 0, 11, Block.field_71980_u.field_71990_ca, Block.field_71980_u.field_71990_ca, false);
        this.func_74884_a(world, sbb, 7, 0, 7, 10, 0, 10, Block.field_71980_u.field_71990_ca, 0, false);
        this.spawnATree(world, rand.nextInt(5), 8, 1, 8, sbb);
        this.placeCornerStatue(world, 2, 8, 2, 0, sbb);
        this.placeCornerStatue(world, 2, 1, 15, 1, sbb);
        this.placeCornerStatue(world, 15, 1, 2, 2, sbb);
        this.placeCornerStatue(world, 15, 8, 15, 3, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
    
    private void spawnATree(final World world, final int treeNum, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        final int dz = this.func_74873_b(x, z);
        if (sbb.func_78890_b(dx, dy, dz)) {
            final int minHeight = 8;
            WorldGenerator treeGen = null;
            switch (treeNum) {
                default: {
                    treeGen = (WorldGenerator)new WorldGenTrees(true, minHeight, 0, 0, false);
                    break;
                }
                case 1: {
                    treeGen = (WorldGenerator)new WorldGenTrees(true, minHeight, 3, 3, false);
                    break;
                }
                case 2: {
                    treeGen = (WorldGenerator)new WorldGenTrees(true, minHeight, 2, 2, false);
                    break;
                }
                case 3: {
                    treeGen = new TFGenSmallTwilightOak(false, minHeight);
                    break;
                }
                case 4: {
                    treeGen = new TFGenSmallRainboak(false);
                    break;
                }
            }
            for (int i = 0; i < 100; ++i) {
                if (treeGen.func_76484_a(world, world.field_73012_v, dx, dy, dz)) {
                    break;
                }
                if (i == 99) {}
            }
        }
    }
    
    private void placeBalconyPillar(final World world, final StructureBoundingBox sbb, final int rotation) {
        this.fillBlocksRotated(world, sbb, 5, 1, 5, 5, 12, 5, this.deco.pillarID, this.deco.pillarMeta, rotation);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation), 5, 1, 6, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation), 6, 1, 5, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation) + 4, 5, 5, 6, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation) + 4, 6, 5, 5, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation) + 4, 5, 12, 6, rotation, sbb);
        this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(2 + rotation) + 4, 6, 12, 5, rotation, sbb);
    }
}
