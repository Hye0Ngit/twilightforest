// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.BlockTorch;
import net.minecraft.entity.Entity;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockSlab;
import twilightforest.enums.BossVariant;
import twilightforest.block.BlockTFBossSpawner;
import twilightforest.block.TFBlocks;
import net.minecraft.util.ResourceLocation;
import twilightforest.util.TFEntityNames;
import twilightforest.util.VanillaEntityNames;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.Rotation;
import twilightforest.util.RotationUtil;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public class ComponentTFTowerMain extends ComponentTFTowerWing
{
    public ComponentTFTowerMain() {
    }
    
    public ComponentTFTowerMain(final TFFeature feature, final World world, final Random rand, final int index, final int x, final int y, final int z) {
        super(feature, index, x, y, z, 15, 55 + rand.nextInt(32), EnumFacing.SOUTH);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        this.makeARoof(parent, list, rand);
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            final int[] dest = this.getValidOpening(rand, rotation);
            if (dest[1] < this.height / 2) {
                final int[] array = dest;
                final int n = 1;
                array[n] += 20;
            }
            final int childHeight = Math.min(21 + rand.nextInt(10), this.height - dest[1] - 3);
            if (!this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 9, childHeight, rotation)) {
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 7, childHeight, rotation);
            }
        }
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            final int[] dest = this.getValidOpening(rand, rotation);
            if (dest[1] < this.height / 2) {
                final int[] array2 = dest;
                final int n2 = 1;
                array2[n2] += 10;
            }
            final int childHeight = Math.min(21 + rand.nextInt(10), this.height - dest[1] - 3);
            if (!this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 9, childHeight, rotation)) {
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 7, childHeight, rotation);
            }
        }
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            final int[] dest = this.getValidOpening(rand, rotation);
            final int childHeight = Math.min(7 + rand.nextInt(6), this.height - dest[1] - 3);
            if (!this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 5, childHeight, rotation)) {
                this.makeTowerWing(list, rand, 1, dest[0], dest[1], dest[2], 3, childHeight, rotation);
            }
        }
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            final int[] dest = this.getOutbuildingOpening(rand, rotation);
            final int childHeight = 11 + rand.nextInt(10);
            final int childSize = 7 + rand.nextInt(2) * 2;
            this.makeTowerOutbuilding(list, rand, 1, dest[0], dest[1], dest[2], childSize, childHeight, rotation);
        }
        for (int i = 0; i < 4; ++i) {
            for (final Rotation towerRotation : RotationUtil.ROTATIONS) {
                final int[] dest2 = this.getValidOpening(rand, towerRotation);
                final int childHeight2 = 6 + rand.nextInt(5);
                if (rand.nextInt(3) == 0 || !this.makeTowerWing(list, rand, 1, dest2[0], dest2[1], dest2[2], 5, childHeight2, towerRotation)) {
                    this.makeTowerWing(list, rand, 1, dest2[0], dest2[1], dest2[2], 3, childHeight2, towerRotation);
                }
            }
        }
    }
    
    public int[] getOutbuildingOpening(final Random rand, final Rotation rotation) {
        int rx = 0;
        final int ry = 1;
        int rz = 0;
        switch (rotation) {
            case NONE: {
                rx = this.size - 1;
                rz = 6 + rand.nextInt(8);
                break;
            }
            case CLOCKWISE_90: {
                rx = 1 + rand.nextInt(11);
                rz = this.size - 1;
                break;
            }
            case CLOCKWISE_180: {
                rx = 0;
                rz = 1 + rand.nextInt(8);
                break;
            }
            case COUNTERCLOCKWISE_90: {
                rx = 3 + rand.nextInt(11);
                rz = 0;
                break;
            }
        }
        return new int[] { rx, ry, rz };
    }
    
    public boolean makeTowerOutbuilding(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        final ComponentTFTowerOutbuilding outbuilding = new ComponentTFTowerOutbuilding(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, outbuilding.func_74874_b());
        if (intersect == null) {
            list.add(outbuilding);
            outbuilding.func_74861_a(this, list, rand);
            this.addOpening(x, y, z, rotation);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_74882_a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, false, rand, StructureTFComponentOld.getStrongholdStones());
        this.func_74878_a(world, sbb, 1, 1, 1, this.size - 2, this.height - 2, this.size - 2);
        final IBlockState defaultState = Blocks.field_150347_e.func_176223_P();
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                this.func_175808_b(world, defaultState, x, -1, z, sbb);
            }
        }
        this.nullifySkyLightForBoundingBox(world);
        if (this.height - this.highestOpening > 15) {
            this.highestOpening = this.height - 15;
        }
        this.makeStairs(world, rand, sbb);
        this.makeOpenings(world, sbb);
        this.decorateStairFloor(world, rand, sbb);
        this.makeStairwayCrossings(world, rand, sbb);
        this.makeLichRoom(world, rand, sbb);
        this.makeTowerPaintings(world, rand, sbb);
        return true;
    }
    
    protected void makeStairwayCrossings(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int flights = this.highestOpening / 5 - 2, i = 2 + rand.nextInt(2); i < flights; i += 1 + rand.nextInt(5)) {
            this.makeStairCrossing(world, rand, i, sbb);
        }
    }
    
    protected void makeStairCrossing(final World world, final Random rand, final int flight, final StructureBoundingBox sbb) {
        final EnumFacing temp = this.func_186165_e();
        if (flight % 2 == 0) {
            this.func_186164_a(this.getStructureRelativeRotation(Rotation.CLOCKWISE_90));
        }
        int floorLevel = 0 + flight * 5;
        final IBlockState crossingfloor = rand.nextBoolean() ? Blocks.field_150334_T.func_176223_P() : Blocks.field_150344_f.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
        for (int dx = 6; dx <= 8; ++dx) {
            for (int dz = 4; dz <= 10; ++dz) {
                this.func_175811_a(world, crossingfloor, dx, floorLevel, dz, sbb);
            }
        }
        ++floorLevel;
        int dx = 6;
        for (int dz = 3; dz <= 11; ++dz) {
            this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), dx, floorLevel, dz, sbb);
        }
        ++dx;
        for (int dz = 3; dz <= 11; ++dz) {
            this.func_175811_a(world, ComponentTFTowerMain.AIR, dx, floorLevel, dz, sbb);
        }
        ++dx;
        for (int dz = 3; dz <= 11; ++dz) {
            this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), dx, floorLevel, dz, sbb);
        }
        this.func_175811_a(world, crossingfloor, 6, floorLevel - 1, 11, sbb);
        this.func_175811_a(world, crossingfloor, 8, floorLevel - 1, 3, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), 5, floorLevel, 11, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), 9, floorLevel, 3, sbb);
        ResourceLocation mobID = VanillaEntityNames.SKELETON;
        switch (rand.nextInt(4)) {
            case 0:
            case 1: {
                mobID = VanillaEntityNames.SKELETON;
                break;
            }
            case 2: {
                mobID = VanillaEntityNames.ZOMBIE;
                break;
            }
            case 3: {
                mobID = TFEntityNames.SWARM_SPIDER;
                break;
            }
        }
        this.setSpawner(world, 7, floorLevel + 2, 7, sbb, mobID);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), 6, floorLevel + 1, 7, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), 8, floorLevel + 1, 7, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), 6, floorLevel + 2, 7, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), 8, floorLevel + 2, 7, sbb);
        this.func_186164_a(temp);
    }
    
    protected void makeLichRoom(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int floorLevel = 2 + this.highestOpening / 5 * 5;
        final Rotation i = (this.highestOpening / 5 % 2 == 0) ? Rotation.NONE : Rotation.CLOCKWISE_90;
        this.makeLichFloor(world, floorLevel, i, sbb);
        this.decorateLichChandelier(world, floorLevel, sbb);
        this.decorateTorches(world, rand, floorLevel, sbb);
        this.decoratePaintings(world, rand, floorLevel, sbb);
        this.func_175811_a(world, TFBlocks.boss_spawner.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.LICH), this.size / 2, floorLevel + 2, this.size / 2, sbb);
    }
    
    protected void makeTowerPaintings(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int howMany = 10;
        this.generatePaintingsOnWall(world, rand, howMany, 0, EnumFacing.WEST, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, EnumFacing.WEST, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, EnumFacing.WEST, 0, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, EnumFacing.EAST, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, EnumFacing.EAST, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, EnumFacing.EAST, 0, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, EnumFacing.NORTH, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, EnumFacing.NORTH, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, EnumFacing.NORTH, 0, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, EnumFacing.SOUTH, 48, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, EnumFacing.SOUTH, 32, sbb);
        this.generatePaintingsOnWall(world, rand, howMany, 0, EnumFacing.SOUTH, 0, sbb);
    }
    
    protected void makeLichFloor(final World world, final int floorLevel, final Rotation rotation, final StructureBoundingBox sbb) {
        final EnumFacing temp = this.func_186165_e();
        this.func_186164_a(this.getStructureRelativeRotation(rotation));
        final BlockPlanks.EnumType birch = BlockPlanks.EnumType.BIRCH;
        final IBlockState birchSlab = Blocks.field_150376_bx.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)birch).func_177226_a((IProperty)BlockSlab.field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.TOP);
        final IBlockState birchPlank = Blocks.field_150344_f.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)birch);
        for (int fx = 1; fx < 14; ++fx) {
            for (int fz = 1; fz < 14; ++fz) {
                if ((fx == 1 || fx == 2) && fz >= 6 && fz <= 12) {
                    if (fz == 6) {
                        this.func_175811_a(world, birchSlab, fx, floorLevel, fz, sbb);
                    }
                }
                else if ((fx == 12 || fx == 13) && fz >= 3 && fz <= 8) {
                    if (fz == 8) {
                        this.func_175811_a(world, birchSlab, fx, floorLevel, fz, sbb);
                    }
                }
                else if (fx >= 4 && fx <= 10 && fz >= 4 && fz <= 10) {
                    if ((fx == 4 && fz == 4) || (fx == 10 && fz == 10)) {
                        this.func_175811_a(world, birchPlank, fx, floorLevel, fz, sbb);
                    }
                    else {
                        this.func_175811_a(world, Blocks.field_150359_w.func_176223_P(), fx, floorLevel, fz, sbb);
                    }
                }
                else if ((fx == 2 || fx == 3) && (fz == 2 || fz == 3)) {
                    this.func_175811_a(world, Blocks.field_150359_w.func_176223_P(), fx, floorLevel, fz, sbb);
                }
                else if ((fx == 11 || fx == 12) && (fz == 11 || fz == 12)) {
                    this.func_175811_a(world, Blocks.field_150359_w.func_176223_P(), fx, floorLevel, fz, sbb);
                }
                else {
                    this.func_175811_a(world, birchPlank, fx, floorLevel, fz, sbb);
                }
            }
        }
        this.func_175811_a(world, ComponentTFTowerMain.AIR, 3, floorLevel + 1, 11, sbb);
        this.func_175811_a(world, ComponentTFTowerMain.AIR, 3, floorLevel + 1, 10, sbb);
        this.func_175811_a(world, ComponentTFTowerMain.AIR, 3, floorLevel + 2, 11, sbb);
        this.func_175811_a(world, ComponentTFTowerMain.AIR, 11, floorLevel + 1, 3, sbb);
        this.func_175811_a(world, ComponentTFTowerMain.AIR, 11, floorLevel + 1, 4, sbb);
        this.func_175811_a(world, ComponentTFTowerMain.AIR, 11, floorLevel + 2, 3, sbb);
        this.func_186164_a(temp);
    }
    
    protected void decorateLichChandelier(final World world, final int floorLevel, final StructureBoundingBox sbb) {
        final int cx = this.size / 2;
        int cy = floorLevel + 4;
        final int cz = this.size / 2;
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx + 1, cy, cz + 0, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx + 2, cy, cz + 0, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx + 1, cy, cz + 1, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx + 0, cy, cz + 1, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx + 0, cy, cz + 2, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx - 1, cy, cz + 1, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx - 1, cy, cz + 0, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx - 2, cy, cz + 0, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx - 1, cy, cz - 1, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx + 0, cy, cz - 1, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx + 0, cy, cz - 2, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx + 1, cy, cz - 1, sbb);
        ++cy;
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx + 1, cy, cz + 0, sbb);
        this.func_175811_a(world, Blocks.field_150478_aa.func_176223_P(), cx + 2, cy, cz + 0, sbb);
        this.func_175811_a(world, Blocks.field_150478_aa.func_176223_P(), cx + 1, cy, cz + 1, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx + 0, cy, cz + 1, sbb);
        this.func_175811_a(world, Blocks.field_150478_aa.func_176223_P(), cx + 0, cy, cz + 2, sbb);
        this.func_175811_a(world, Blocks.field_150478_aa.func_176223_P(), cx - 1, cy, cz + 1, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx - 1, cy, cz + 0, sbb);
        this.func_175811_a(world, Blocks.field_150478_aa.func_176223_P(), cx - 2, cy, cz + 0, sbb);
        this.func_175811_a(world, Blocks.field_150478_aa.func_176223_P(), cx - 1, cy, cz - 1, sbb);
        this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx + 0, cy, cz - 1, sbb);
        this.func_175811_a(world, Blocks.field_150478_aa.func_176223_P(), cx + 0, cy, cz - 2, sbb);
        this.func_175811_a(world, Blocks.field_150478_aa.func_176223_P(), cx + 1, cy, cz - 1, sbb);
        ++cy;
        this.func_175811_a(world, Blocks.field_150478_aa.func_176223_P(), cx + 1, cy, cz + 0, sbb);
        this.func_175811_a(world, Blocks.field_150478_aa.func_176223_P(), cx + 0, cy, cz + 1, sbb);
        this.func_175811_a(world, Blocks.field_150478_aa.func_176223_P(), cx - 1, cy, cz + 0, sbb);
        this.func_175811_a(world, Blocks.field_150478_aa.func_176223_P(), cx + 0, cy, cz - 1, sbb);
        for (int y = floorLevel + 5; y < this.height - 1; ++y) {
            this.func_175811_a(world, Blocks.field_180407_aO.func_176223_P(), cx + 0, y, cz + 0, sbb);
        }
    }
    
    protected void decoratePaintings(final World world, final Random rand, final int floorLevel, final StructureBoundingBox sbb) {
        final int howMany = 100;
        for (final EnumFacing horizontal : EnumFacing.field_176754_o) {
            this.generatePaintingsOnWall(world, rand, howMany, floorLevel, horizontal, 48, sbb);
            this.generatePaintingsOnWall(world, rand, howMany, floorLevel, horizontal, 32, sbb);
            this.generatePaintingsOnWall(world, rand, howMany, floorLevel, horizontal, 0, sbb);
        }
    }
    
    protected void decorateTorches(final World world, final Random rand, final int floorLevel, final StructureBoundingBox sbb) {
        this.generateTorchesOnWall(world, rand, floorLevel, EnumFacing.SOUTH, sbb);
        this.generateTorchesOnWall(world, rand, floorLevel, EnumFacing.EAST, sbb);
        this.generateTorchesOnWall(world, rand, floorLevel, EnumFacing.NORTH, sbb);
        this.generateTorchesOnWall(world, rand, floorLevel, EnumFacing.WEST, sbb);
    }
    
    protected void generateTorchesOnWall(final World world, final Random rand, final int floorLevel, final EnumFacing direction, final StructureBoundingBox sbb) {
        for (int i = 0; i < 5; ++i) {
            final BlockPos wCoords = this.getRandomWallSpot(rand, floorLevel, direction, sbb);
            final BlockPos.MutableBlockPos tCoords = new BlockPos.MutableBlockPos(wCoords);
            final AxisAlignedBB torchBox = new AxisAlignedBB((double)tCoords.func_177958_n(), (double)tCoords.func_177956_o(), (double)tCoords.func_177952_p(), tCoords.func_177958_n() + 1.0, tCoords.func_177956_o() + 2.0, tCoords.func_177952_p() + 1.0);
            final IBlockState blockState = world.func_180495_p((BlockPos)tCoords);
            final IBlockState aboveBlockState = world.func_180495_p(tCoords.func_177984_a());
            if (blockState.func_185904_a() == Material.field_151579_a && aboveBlockState.func_185904_a() == Material.field_151579_a && world.func_72839_b((Entity)null, torchBox).size() == 0) {
                world.func_180501_a((BlockPos)tCoords, Blocks.field_180407_aO.func_176223_P(), 2);
                world.func_180501_a(tCoords.func_177984_a(), Blocks.field_150478_aa.func_176223_P().func_177226_a((IProperty)BlockTorch.field_176596_a, (Comparable)EnumFacing.UP), 2);
            }
        }
    }
}
