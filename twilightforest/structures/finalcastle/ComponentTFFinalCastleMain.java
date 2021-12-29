// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.block.state.IBlockState;
import twilightforest.block.BlockTFCastleDoor;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFForceField;
import twilightforest.block.TFBlocks;
import twilightforest.util.RotationUtil;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Iterator;
import java.util.Collection;
import java.util.LinkedList;
import net.minecraft.util.Rotation;
import twilightforest.block.BlockTFCastleMagic;
import net.minecraft.item.EnumDyeColor;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.math.BlockPos;
import twilightforest.TwilightForestMod;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFFinalCastleMain extends StructureTFComponentOld
{
    public ComponentTFFinalCastleMain() {
    }
    
    public ComponentTFFinalCastleMain(final TFFeature feature, final World world, final Random rand, final int i, int x, final int y, int z) {
        super(feature, i);
        this.func_186164_a(EnumFacing.SOUTH);
        this.spawnListIndex = 1;
        x = x + 127 >> 8 << 8;
        z = z + 127 >> 8 << 8;
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -24, 120, -24, 48, 40, 48, EnumFacing.SOUTH);
        final BlockPos cc = TFFeature.getNearestCenterXYZ(x >> 4, z >> 4, world);
        final int cx = x >> 8 << 8;
        final int cz = z >> 8 << 8;
        TwilightForestMod.LOGGER.debug("Making castle at {}, {}. center is {}, {}", (Object)x, (Object)z, (Object)cc.func_177958_n(), (Object)cc.func_177952_p());
        TwilightForestMod.LOGGER.debug("Natural center at {}, {}", (Object)cx, (Object)cz);
        if (this.deco == null) {
            this.deco = new StructureTFDecoratorCastle();
        }
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        final ComponentTFFinalCastleFoundation48 foundation = new ComponentTFFinalCastleFoundation48(this.getFeatureType(), rand, 4, this);
        list.add(foundation);
        foundation.func_74861_a(this, list, rand);
        final StructureTFComponentOld roof = new ComponentTFFinalCastleRoof48Crenellated(this.getFeatureType(), rand, 4, this);
        list.add(roof);
        roof.func_74861_a((StructureComponent)this, (List)list, rand);
        final StructureTFComponentOld gazebo = new ComponentTFFinalCastleBossGazebo(this.getFeatureType(), rand, 5, this);
        list.add(gazebo);
        gazebo.func_74861_a((StructureComponent)this, (List)list, rand);
        final ComponentTFFinalCastleStairTower tower0 = new ComponentTFFinalCastleStairTower(this.getFeatureType(), rand, 3, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78896_c, EnumFacing.NORTH);
        list.add(tower0);
        tower0.func_74861_a(this, list, rand);
        final ComponentTFFinalCastleLargeTower tower2 = new ComponentTFFinalCastleLargeTower(this.getFeatureType(), rand, 3, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78896_c, EnumFacing.EAST);
        list.add(tower2);
        tower2.func_74861_a(this, list, rand);
        final ComponentTFFinalCastleStairTower tower3 = new ComponentTFFinalCastleStairTower(this.getFeatureType(), rand, 3, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78892_f, EnumFacing.WEST);
        list.add(tower3);
        tower3.func_74861_a(this, list, rand);
        final ComponentTFFinalCastleStairTower tower4 = new ComponentTFFinalCastleStairTower(this.getFeatureType(), rand, 3, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78892_f, EnumFacing.SOUTH);
        list.add(tower4);
        tower4.func_74861_a(this, list, rand);
        BlockPos dest = new BlockPos(this.field_74887_e.field_78897_a - 4, this.field_74887_e.field_78894_e, this.field_74887_e.field_78896_c - 24);
        this.buildTowerMaze(list, rand, 48, 0, 24, 60, EnumFacing.SOUTH, BlockTFCastleMagic.VALID_COLORS.get(0), dest);
        dest = new BlockPos(this.field_74887_e.field_78893_d + 4, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 24);
        this.buildTowerMaze(list, rand, 0, 30, 24, 60, EnumFacing.NORTH, BlockTFCastleMagic.VALID_COLORS.get(1), dest);
        final ComponentTFFinalCastleDungeonSteps steps0 = new ComponentTFFinalCastleDungeonSteps(rand, 5, this.field_74887_e.field_78897_a + 18, this.field_74887_e.field_78895_b + 1, this.field_74887_e.field_78896_c + 18, EnumFacing.SOUTH);
        list.add(steps0);
        steps0.func_74861_a(this, list, rand);
        final ComponentTFFinalCastleDungeonSteps steps2 = steps0.buildMoreStepsTowards(parent, list, rand, Rotation.COUNTERCLOCKWISE_90);
        final ComponentTFFinalCastleDungeonSteps steps3 = steps2.buildMoreStepsTowards(parent, list, rand, Rotation.COUNTERCLOCKWISE_90);
        final ComponentTFFinalCastleDungeonSteps steps4 = steps3.buildMoreStepsTowards(parent, list, rand, Rotation.COUNTERCLOCKWISE_90);
        steps4.buildLevelUnder(parent, list, rand, 1);
        final BlockPos mc = this.offsetTowerCCoords(48, 23, 25, 1, EnumFacing.SOUTH);
        final ComponentTFFinalCastleMural mural0 = new ComponentTFFinalCastleMural(this.getFeatureType(), rand, 7, mc.func_177958_n(), mc.func_177956_o(), mc.func_177952_p(), 35, 30, EnumFacing.SOUTH);
        list.add(mural0);
        mural0.func_74861_a((StructureComponent)this, (List)list, rand);
        final BlockPos mc2 = this.offsetTowerCCoords(48, 33, 24, -1, EnumFacing.SOUTH);
        final ComponentTFFinalCastleMural mural2 = new ComponentTFFinalCastleMural(this.getFeatureType(), rand, 7, mc2.func_177958_n(), mc2.func_177956_o(), mc.func_177952_p(), 19, 12, EnumFacing.NORTH);
        list.add(mural2);
        mural2.func_74861_a((StructureComponent)this, (List)list, rand);
    }
    
    private void buildTowerMaze(final List<StructureComponent> list, final Random rand, final int x, final int y, final int z, final int howFar, final EnumFacing direction, final EnumDyeColor type, final BlockPos dest) {
        boolean complete = false;
        int iterations = 0;
        while (!complete && iterations < 15) {
            ++iterations;
            final List<StructureComponent> before = new LinkedList<StructureComponent>(list);
            final BlockPos tc = this.offsetTowerCCoords(x, y, z, howFar, direction);
            final ComponentTFFinalCastleMazeTower13 sTower = new ComponentTFFinalCastleMazeTower13(this.getFeatureType(), rand, 3, tc.func_177958_n(), tc.func_177956_o(), tc.func_177952_p(), type, direction);
            final BlockPos bc = this.offsetTowerCCoords(x, y, z, 1, direction);
            final ComponentTFFinalCastleBridge bridge = new ComponentTFFinalCastleBridge(this.getFeatureType(), this.func_74877_c() + 1, bc.func_177958_n(), bc.func_177956_o(), bc.func_177952_p(), howFar - 7, direction);
            list.add(bridge);
            bridge.func_74861_a(this, list, rand);
            list.add(sTower);
            sTower.buildTowards(this, list, rand, dest);
            TwilightForestMod.LOGGER.debug("Working towards {},{},{}", (Object)dest.func_177958_n(), (Object)dest.func_177956_o(), (Object)dest.func_177952_p());
            if (this.isMazeComplete(list, type)) {
                TwilightForestMod.LOGGER.debug("Tower maze color {} complete!", (Object)type);
                complete = true;
            }
            else {
                TwilightForestMod.LOGGER.info("Tower maze color {} INCOMPLETE, retrying!", (Object)type);
                list.clear();
                list.addAll(before);
            }
        }
    }
    
    private boolean isMazeComplete(final List<StructureComponent> list, final EnumDyeColor type) {
        if (list.size() > 60) {
            TwilightForestMod.LOGGER.warn("Maze of color {} is getting a bit excessive.", (Object)type);
        }
        for (final StructureComponent structurecomponent : list) {
            final StructureBoundingBox boundingBox = structurecomponent.func_74874_b();
            final int x = boundingBox.field_78893_d - boundingBox.field_78897_a / 2 + boundingBox.field_78897_a;
            final int y = boundingBox.field_78894_e - boundingBox.field_78895_b / 2 + boundingBox.field_78895_b;
            final int z = boundingBox.field_78892_f - boundingBox.field_78896_c / 2 + boundingBox.field_78896_c;
            TwilightForestMod.LOGGER.debug("Component {} at {},{},{}", (Object)structurecomponent.getClass().getSimpleName(), (Object)x, (Object)y, (Object)z);
            if (type == BlockTFCastleMagic.VALID_COLORS.get(0) && structurecomponent instanceof ComponentTFFinalCastleEntranceTower) {
                return true;
            }
            if (type == BlockTFCastleMagic.VALID_COLORS.get(1) && structurecomponent instanceof ComponentTFFinalCastleBellTower21) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected BlockPos offsetTowerCCoords(final int x, final int y, final int z, final int howFar, final EnumFacing direction) {
        int dx = this.func_74865_a(x, z);
        final int dy = this.func_74862_a(y);
        int dz = this.func_74873_b(x, z);
        switch (direction) {
            case SOUTH: {
                dx += howFar;
                break;
            }
            case WEST: {
                dz += howFar;
                break;
            }
            case NORTH: {
                dx -= howFar;
                break;
            }
            case EAST: {
                dz -= howFar;
                break;
            }
        }
        return new BlockPos(dx, dy, dz);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_74882_a(world, sbb, 0, 0, 0, 48, 40, 48, false, rand, this.deco.randomBlocks);
        this.func_74882_a(world, sbb, 13, 30, 1, 47, 30, 12, false, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 13, 31, 12, 36, 31, 12, this.deco.fenceState, this.deco.fenceState, false);
        this.func_74882_a(world, sbb, 13, 30, 36, 47, 30, 47, false, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 13, 31, 36, 36, 31, 36, this.deco.fenceState, this.deco.fenceState, false);
        this.func_74882_a(world, sbb, 1, 30, 1, 12, 30, 47, false, rand, this.deco.randomBlocks);
        this.func_175804_a(world, sbb, 12, 31, 12, 12, 31, 36, this.deco.fenceState, this.deco.fenceState, false);
        this.func_74882_a(world, sbb, 38, 25, 13, 47, 25, 35, false, rand, this.deco.randomBlocks);
        for (int i = 0; i < 5; ++i) {
            int y = 30 - i;
            this.makeMezzTopStairs(world, sbb, y, 10 + i, EnumFacing.SOUTH);
            this.makeMezzTopStairs(world, sbb, y, 38 - i, EnumFacing.NORTH);
            y = 25 - i;
            final int x = 37 - i;
            final IBlockState stairState = StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, this.field_186169_c, false);
            this.func_175804_a(world, sbb, x, y, 14, x, y, 22, stairState, stairState, false);
            this.func_175804_a(world, sbb, x, y - 1, 14, x, y - 1, 22, this.deco.blockState, this.deco.blockState, false);
            this.func_175804_a(world, sbb, x, y, 26, x, y, 34, stairState, stairState, false);
            this.func_175804_a(world, sbb, x, y - 1, 26, x, y - 1, 34, this.deco.blockState, this.deco.blockState, false);
        }
        for (int x2 = 11; x2 < 47; x2 += 12) {
            for (int z = 11; z < 47; z += 12) {
                this.func_175804_a(world, sbb, x2, 1, z, x2 + 2, 40, z + 2, this.deco.pillarState, this.deco.blockState, false);
                this.makePillarBase(world, sbb, x2, z, 1, false);
                this.makePillarBase(world, sbb, x2, z, 19, true);
                this.makePillarBase(world, sbb, x2, z, 21, false);
                this.makePillarBase(world, sbb, x2, z, 39, true);
            }
        }
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            for (int z2 = 11; z2 < 47; z2 += 12) {
                if (z2 == 23) {
                    if (rotation == Rotation.NONE) {
                        continue;
                    }
                    if (rotation == Rotation.CLOCKWISE_180) {
                        continue;
                    }
                }
                this.fillBlocksRotated(world, sbb, 1, 1, z2, 1, 40, z2 + 2, this.deco.pillarState, rotation);
                this.makeHalfPillarBase(world, sbb, rotation, 1, z2, false);
                this.makeHalfPillarBase(world, sbb, rotation, 19, z2, true);
                this.makeHalfPillarBase(world, sbb, rotation, 21, z2, false);
                this.makeHalfPillarBase(world, sbb, rotation, 39, z2, true);
            }
        }
        this.func_74882_a(world, sbb, 1, 20, 1, 47, 20, 47, false, rand, this.deco.randomBlocks);
        final IBlockState fieldBlock = TFBlocks.force_field.func_176223_P().func_177226_a((IProperty)BlockTFForceField.COLOR, (Comparable)EnumDyeColor.PINK);
        this.func_175804_a(world, sbb, 12, 1, 12, 24, 10, 12, fieldBlock, fieldBlock, false);
        this.func_175804_a(world, sbb, 12, 1, 12, 12, 10, 24, fieldBlock, fieldBlock, false);
        this.func_175804_a(world, sbb, 24, 1, 12, 24, 10, 24, fieldBlock, fieldBlock, false);
        this.func_175804_a(world, sbb, 12, 1, 24, 24, 10, 24, fieldBlock, fieldBlock, false);
        this.func_175804_a(world, sbb, 12, 10, 12, 24, 10, 24, fieldBlock, fieldBlock, false);
        final IBlockState castleDoor = TFBlocks.castle_door.func_176223_P();
        this.func_175804_a(world, sbb, 17, 1, 12, 19, 4, 12, castleDoor.func_177226_a((IProperty)BlockTFCastleDoor.LOCK_INDEX, (Comparable)2), ComponentTFFinalCastleMain.AIR, false);
        this.func_175804_a(world, sbb, 17, 1, 24, 19, 4, 24, castleDoor.func_177226_a((IProperty)BlockTFCastleDoor.LOCK_INDEX, (Comparable)2), ComponentTFFinalCastleMain.AIR, false);
        this.makeSmallTowerStairs(world, sbb, Rotation.NONE);
        this.makeSmallTowerStairs(world, sbb, Rotation.CLOCKWISE_90);
        this.makeSmallTowerStairs(world, sbb, Rotation.COUNTERCLOCKWISE_90);
        this.makeLargeTowerStairs(world, sbb, Rotation.CLOCKWISE_180);
        this.func_175804_a(world, sbb, 48, 1, 23, 48, 4, 25, castleDoor.func_177226_a((IProperty)BlockTFCastleDoor.LOCK_INDEX, (Comparable)0), ComponentTFFinalCastleMain.AIR, false);
        this.func_175804_a(world, sbb, 0, 31, 23, 0, 34, 25, castleDoor.func_177226_a((IProperty)BlockTFCastleDoor.LOCK_INDEX, (Comparable)1), ComponentTFFinalCastleMain.AIR, false);
        return true;
    }
    
    private void makeSmallTowerStairs(final World world, final StructureBoundingBox sbb, final Rotation rotation) {
        for (int y = 1; y < 4; ++y) {
            final int z = 40 + y;
            this.fillBlocksRotated(world, sbb, 1, 1, z, 4, y, z, this.deco.blockState, rotation);
            this.fillBlocksRotated(world, sbb, 2, y, z, 3, y, z, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, false), rotation);
        }
    }
    
    private void makeLargeTowerStairs(final World world, final StructureBoundingBox sbb, final Rotation rotation) {
        final IBlockState stairState = StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, false);
        for (int y = 1; y < 4; ++y) {
            final int z = 38 + y;
            this.fillBlocksRotated(world, sbb, 2, 1, z, 6, y, z, this.deco.blockState, rotation);
            this.fillBlocksRotated(world, sbb, 3, y, z, 5, y, z, stairState, rotation);
        }
    }
    
    private void makeMezzTopStairs(final World world, final StructureBoundingBox sbb, final int y, final int z, final EnumFacing stairMeta) {
        final IBlockState stairState = StructureTFComponentOld.getStairState(this.deco.stairState, stairMeta, this.field_186169_c, false);
        this.func_175804_a(world, sbb, 38, y, z, 46, y, z, stairState, stairState, false);
        this.func_175804_a(world, sbb, 38, y - 1, z, 46, y - 1, z, this.deco.blockState, this.deco.blockState, false);
        this.func_74878_a(world, sbb, 38, y + 1, z, 46, y + 3, z);
    }
    
    private void makeHalfPillarBase(final World world, final StructureBoundingBox sbb, final Rotation rotation, final int y, final int z, final boolean isFlipped) {
        this.fillBlocksRotated(world, sbb, 2, y, z - 1, 2, y, z + 3, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.EAST, rotation, isFlipped), rotation);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, rotation, isFlipped), 1, y, z - 1, rotation, sbb);
        this.setBlockStateRotated(world, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, rotation, isFlipped), 1, y, z + 3, rotation, sbb);
    }
    
    private void makePillarBase(final World world, final StructureBoundingBox sbb, final int x, final int z, final int y, final boolean isFlipped) {
        this.func_175804_a(world, sbb, x + 0, y, z + 3, x + 3, y, z + 3, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.SOUTH, this.field_186169_c, isFlipped), ComponentTFFinalCastleMain.AIR, false);
        this.func_175804_a(world, sbb, x - 1, y, z - 1, x + 2, y, z - 1, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.NORTH, this.field_186169_c, isFlipped), ComponentTFFinalCastleMain.AIR, false);
        this.func_175804_a(world, sbb, x + 3, y, z - 1, x + 3, y, z + 2, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.EAST, this.field_186169_c, isFlipped), ComponentTFFinalCastleMain.AIR, false);
        this.func_175804_a(world, sbb, x - 1, y, z + 0, x - 1, y, z + 3, StructureTFComponentOld.getStairState(this.deco.stairState, EnumFacing.WEST, this.field_186169_c, isFlipped), ComponentTFFinalCastleMain.AIR, false);
    }
}
