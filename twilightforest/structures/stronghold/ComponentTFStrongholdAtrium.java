// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.util.math.BlockPos;
import twilightforest.world.feature.TFGenSmallRainboak;
import twilightforest.world.feature.TFGenSmallTwilightOak;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLog;
import net.minecraft.util.math.Vec3i;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFStrongholdAtrium extends StructureTFStrongholdComponent
{
    private boolean enterBottom;
    
    public ComponentTFStrongholdAtrium() {
    }
    
    public ComponentTFStrongholdAtrium(final TFFeature feature, final int i, final EnumFacing facing, final int x, final int y, final int z) {
        super(feature, i, facing, x, y, z);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74757_a("enterBottom", this.enterBottom);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.enterBottom = tagCompound.func_74767_n("enterBottom");
    }
    
    @Override
    public StructureBoundingBox generateBoundingBox(final EnumFacing facing, final int x, final int y, final int z) {
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
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random random) {
        super.func_74861_a(parent, list, random);
        if (this.enterBottom) {
            this.addDoor(4, 1, 0);
            this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_180, 13, 8, -1);
        }
        else {
            this.addDoor(13, 8, 0);
            this.addNewComponent(parent, list, random, Rotation.CLOCKWISE_180, 4, 1, -1);
        }
        this.addNewComponent(parent, list, random, Rotation.NONE, 13, 1, 18);
        this.addNewComponent(parent, list, random, Rotation.NONE, 4, 8, 18);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeStrongholdWalls(world, sbb, 0, 0, 0, 17, 13, 17, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 1, 6, 1, 16, 7, 16, false, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 5, 8, 5, 12, 8, 12, this.deco.fenceState, ComponentTFStrongholdAtrium.AIR, false);
        this.func_74878_a(world, sbb, 6, 6, 6, 11, 8, 11);
        this.placeBalconyPillar(world, sbb, Rotation.NONE);
        this.placeBalconyPillar(world, sbb, Rotation.CLOCKWISE_90);
        this.placeBalconyPillar(world, sbb, Rotation.CLOCKWISE_180);
        this.placeBalconyPillar(world, sbb, Rotation.COUNTERCLOCKWISE_90);
        this.func_74882_a(world, sbb, 1, 1, 1, 1, 12, 2, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 2, 1, 1, 2, 12, 1, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 16, 1, 1, 16, 12, 2, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 15, 1, 1, 15, 12, 1, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 1, 1, 15, 1, 12, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 2, 1, 16, 2, 12, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 16, 1, 15, 16, 12, 16, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 15, 1, 16, 15, 12, 16, false, rand, this.deco.randomBlocks);
        final IBlockState grass = Blocks.field_150349_c.func_176223_P();
        this.func_189914_a(world, sbb, rand, 0.5f, 6, 0, 6, 11, 0, 11, grass, grass, false, 0);
        this.func_175804_a(world, sbb, 7, 0, 7, 10, 0, 10, grass, ComponentTFStrongholdAtrium.AIR, false);
        this.spawnATree(world, rand.nextInt(5), 8, 1, 8, sbb);
        this.placeCornerStatue(world, 2, 8, 2, 0, sbb);
        this.placeCornerStatue(world, 2, 1, 15, 1, sbb);
        this.placeCornerStatue(world, 15, 1, 2, 2, sbb);
        this.placeCornerStatue(world, 15, 8, 15, 3, sbb);
        this.placeDoors(world, rand, sbb);
        return true;
    }
    
    private void spawnATree(final World world, final int treeNum, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final BlockPos pos = this.getBlockPosWithOffset(x, y, z);
        if (sbb.func_175898_b((Vec3i)pos)) {
            final int minHeight = 8;
            WorldGenerator treeGen = null;
            switch (treeNum) {
                default: {
                    final IBlockState oakWood = Blocks.field_150364_r.func_176223_P().func_177226_a((IProperty)BlockOldLog.field_176301_b, (Comparable)BlockPlanks.EnumType.OAK);
                    final IBlockState oakLeaves = Blocks.field_150362_t.func_176223_P().func_177226_a((IProperty)BlockOldLeaf.field_176239_P, (Comparable)BlockPlanks.EnumType.OAK).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
                    treeGen = (WorldGenerator)new WorldGenTrees(true, minHeight, oakWood, oakLeaves, false);
                    break;
                }
                case 1: {
                    final IBlockState jungleWood = Blocks.field_150364_r.func_176223_P().func_177226_a((IProperty)BlockOldLog.field_176301_b, (Comparable)BlockPlanks.EnumType.JUNGLE);
                    final IBlockState jungleLeaves = Blocks.field_150362_t.func_176223_P().func_177226_a((IProperty)BlockOldLeaf.field_176239_P, (Comparable)BlockPlanks.EnumType.JUNGLE).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
                    treeGen = (WorldGenerator)new WorldGenTrees(true, minHeight, jungleWood, jungleLeaves, false);
                    break;
                }
                case 2: {
                    final IBlockState birchWood = Blocks.field_150364_r.func_176223_P().func_177226_a((IProperty)BlockOldLog.field_176301_b, (Comparable)BlockPlanks.EnumType.BIRCH);
                    final IBlockState birchLeaves = Blocks.field_150362_t.func_176223_P().func_177226_a((IProperty)BlockOldLeaf.field_176239_P, (Comparable)BlockPlanks.EnumType.BIRCH).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
                    treeGen = (WorldGenerator)new WorldGenTrees(true, minHeight, birchWood, birchLeaves, false);
                    break;
                }
                case 3: {
                    treeGen = (WorldGenerator)new TFGenSmallTwilightOak(false, minHeight);
                    break;
                }
                case 4: {
                    treeGen = (WorldGenerator)new TFGenSmallRainboak(false);
                    break;
                }
            }
            for (int i = 0; i < 100; ++i) {
                if (treeGen.func_180709_b(world, world.field_73012_v, pos)) {
                    break;
                }
            }
        }
    }
    
    private void placeBalconyPillar(final World world, final StructureBoundingBox sbb, final Rotation rotation) {
        this.fillBlocksRotated(world, sbb, 5, 1, 5, 5, 12, 5, this.deco.pillarState, rotation);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(EnumFacing.WEST), rotation, false), 5, 1, 6, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(EnumFacing.WEST), rotation, false), 6, 1, 5, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(EnumFacing.WEST), rotation, true), 5, 5, 6, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(EnumFacing.WEST), rotation, true), 6, 5, 5, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.COUNTERCLOCKWISE_90.func_185831_a(EnumFacing.WEST), rotation, true), 5, 12, 6, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, Rotation.CLOCKWISE_180.func_185831_a(EnumFacing.WEST), rotation, true), 6, 12, 5, rotation, sbb);
    }
}
