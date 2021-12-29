// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import java.util.Iterator;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockHugeMushroom;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import twilightforest.util.RotationUtil;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFTrollCaveConnect extends ComponentTFTrollCaveMain
{
    protected boolean[] openingTowards;
    
    public ComponentTFTrollCaveConnect() {
        this.openingTowards = new boolean[] { false, false, true, false };
    }
    
    public ComponentTFTrollCaveConnect(final TFFeature feature, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final EnumFacing direction) {
        super(feature, index);
        this.openingTowards = new boolean[] { false, false, true, false };
        this.size = caveSize;
        this.height = caveHeight;
        this.func_186164_a(direction);
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, direction);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74757_a("openingTowards0", this.openingTowards[0]);
        tagCompound.func_74757_a("openingTowards1", this.openingTowards[1]);
        tagCompound.func_74757_a("openingTowards2", this.openingTowards[2]);
        tagCompound.func_74757_a("openingTowards3", this.openingTowards[3]);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.openingTowards[0] = tagCompound.func_74767_n("openingTowards0");
        this.openingTowards[1] = tagCompound.func_74767_n("openingTowards1");
        this.openingTowards[2] = tagCompound.func_74767_n("openingTowards2");
        this.openingTowards[3] = tagCompound.func_74767_n("openingTowards3");
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (this.func_74877_c() < 3) {
            for (final Rotation rotation : RotationUtil.ROTATIONS) {
                final BlockPos dest = this.getValidOpening(rand, 2, rotation);
                if (rand.nextBoolean() || !this.makeGardenCave(list, rand, this.func_74877_c() + 1, dest.func_177958_n(), dest.func_177956_o(), dest.func_177952_p(), 30, 15, rotation)) {
                    this.makeSmallerCave(list, rand, this.func_74877_c() + 1, dest.func_177958_n(), dest.func_177956_o(), dest.func_177952_p(), 20, 15, rotation);
                }
            }
        }
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.isBoundingBoxOutsideBiomes(world, sbb, ComponentTFTrollCaveConnect.highlands)) {
            return false;
        }
        this.hollowCaveMiddle(world, sbb, rand, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            if (!this.openingTowards[rotation.ordinal()]) {
                this.decorateWall(world, sbb, decoRNG, rotation);
            }
        }
        decoRNG.setSeed(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        for (int i = 0; i < 32; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, decoRNG, Blocks.field_150348_b, 0.5f, true, dest.func_177958_n(), 3, dest.func_177952_p(), sbb);
        }
        for (int i = 0; i < 8; ++i) {
            final BlockPos dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, decoRNG, Blocks.field_150348_b, 0.5f, false, dest.func_177958_n(), 3, dest.func_177952_p(), sbb);
        }
        decoRNG.setSeed(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        if (this.countExits() == 1 && decoRNG.nextInt(3) == 0) {
            this.makeTreasureCrate(world, decoRNG, sbb);
        }
        else if (decoRNG.nextInt(3) == 0) {
            this.makeMonolith(world, decoRNG, sbb);
        }
        return true;
    }
    
    protected void makeMonolith(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int mid = this.size / 2;
        final int height = 7 + rand.nextInt(8);
        final Rotation rotation = RotationUtil.ROTATIONS[rand.nextInt(4)];
        this.fillBlocksRotated(world, sbb, mid - 1, 0, mid - 1, mid - 1, height, mid - 1, Blocks.field_150343_Z.func_176223_P(), rotation);
        this.fillBlocksRotated(world, sbb, mid + 0, 0, mid - 1, mid + 0, height - 2, mid - 1, Blocks.field_150343_Z.func_176223_P(), rotation);
        this.fillBlocksRotated(world, sbb, mid - 1, 0, mid + 0, mid - 1, height - 2, mid + 0, Blocks.field_150343_Z.func_176223_P(), rotation);
        this.fillBlocksRotated(world, sbb, mid + 0, 0, mid + 0, mid + 0, height - 4, mid + 0, Blocks.field_150343_Z.func_176223_P(), rotation);
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
    
    private void decorateWall(final World world, final StructureBoundingBox sbb, final Random decoRNG, final Rotation rotation) {
        if (decoRNG.nextBoolean()) {
            this.decorateBracketMushrooms(world, sbb, decoRNG, rotation);
        }
        else if (decoRNG.nextBoolean()) {
            this.decorateStoneFormation(world, sbb, decoRNG, rotation);
            this.decorateStoneFormation(world, sbb, decoRNG, rotation);
        }
        else {
            this.decorateStoneProjection(world, sbb, decoRNG, rotation);
        }
    }
    
    private void decorateStoneFormation(final World world, final StructureBoundingBox sbb, final Random decoRNG, final Rotation rotation) {
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
    
    private void makeSingleStoneFormation(final World world, final StructureBoundingBox sbb, final Random decoRNG, final Rotation rotation, final int z, final int y, final int width, final int depth) {
        if (decoRNG.nextInt(8) == 0) {
            this.fillBlocksRotated(world, sbb, this.size - (depth + 1), y - width, z - width, this.size - 1, y + width, z + width, Blocks.field_150343_Z.func_176223_P(), rotation);
        }
        else if (decoRNG.nextInt(4) == 0) {
            this.fillBlocksRotated(world, sbb, this.size - (depth + 1), y - width, z - width, this.size - 1, y + width, z + width, TFBlocks.trollsteinn.func_176223_P(), rotation);
        }
        else {
            this.fillBlocksRotated(world, sbb, this.size - (depth + 1), y - width, z - width, this.size - 1, y + width, z + width, Blocks.field_150348_b.func_176223_P(), rotation);
        }
    }
    
    private void decorateStoneProjection(final World world, final StructureBoundingBox sbb, final Random decoRNG, final Rotation rotation) {
        final int z = 7 + decoRNG.nextInt(3) - decoRNG.nextInt(3);
        final int y = 7 + decoRNG.nextInt(3) - decoRNG.nextInt(3);
        this.randomlyFillBlocksRotated(world, sbb, decoRNG, 0.25f, this.size - 9, y, z, this.size - 2, y + 3, z + 3, TFBlocks.trollsteinn.func_176223_P(), Blocks.field_150348_b.func_176223_P(), rotation);
        if (decoRNG.nextBoolean()) {
            this.randomlyFillBlocksRotated(world, sbb, decoRNG, 0.25f, this.size - 9, 1, z, this.size - 6, y - 1, z + 3, TFBlocks.trollsteinn.func_176223_P(), Blocks.field_150348_b.func_176223_P(), rotation);
        }
        else {
            this.randomlyFillBlocksRotated(world, sbb, decoRNG, 0.25f, this.size - 9, y + 4, z, this.size - 6, this.height - 2, z + 3, TFBlocks.trollsteinn.func_176223_P(), Blocks.field_150348_b.func_176223_P(), rotation);
        }
    }
    
    private void decorateBracketMushrooms(final World world, final StructureBoundingBox sbb, final Random decoRNG, final Rotation rotation) {
        int z = 5 + decoRNG.nextInt(7);
        int y;
        for (int startY = y = 1 + decoRNG.nextInt(4); y < this.height; y += 2) {
            final int width = 1 + decoRNG.nextInt(2) + decoRNG.nextInt(2);
            final int depth = 1 + decoRNG.nextInt(2) + decoRNG.nextInt(2);
            final Block mushBlock = (decoRNG.nextInt(3) == 0) ? TFBlocks.huge_mushgloom : (decoRNG.nextBoolean() ? Blocks.field_150420_aW : Blocks.field_150419_aX);
            this.makeSingleBracketMushroom(world, sbb, rotation, z, y, width, depth, mushBlock.func_176223_P());
            z += decoRNG.nextInt(4) - decoRNG.nextInt(4);
            if (z < 5 || z > this.size - 5) {
                z = 5 + decoRNG.nextInt(7);
            }
        }
    }
    
    private void makeSingleBracketMushroom(final World world, final StructureBoundingBox sbb, final Rotation rotation, final int z, final int y, final int width, final int depth, final IBlockState mushBlock) {
        this.fillBlocksRotated(world, sbb, this.size - depth, y, z - (width - 1), this.size - 2, y, z + (width - 1), mushBlock.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.CENTER), rotation);
        this.fillBlocksRotated(world, sbb, this.size - (depth + 1), y, z - (width - 1), this.size - (depth + 1), y, z + (width - 1), this.getMushroomState(mushBlock, BlockHugeMushroom.EnumType.EAST), rotation);
        final IBlockState northMushroom = this.getMushroomState(mushBlock, BlockHugeMushroom.EnumType.SOUTH);
        for (int d = 0; d < depth - 1; ++d) {
            this.setBlockStateRotated(world, northMushroom, this.size - (2 + d), y, z - width, rotation, sbb);
        }
        final IBlockState northWestMushroom = this.getMushroomState(mushBlock, BlockHugeMushroom.EnumType.SOUTH_EAST);
        this.setBlockStateRotated(world, northWestMushroom, this.size - (depth + 1), y, z - width, rotation, sbb);
        final IBlockState southMushroom = this.getMushroomState(mushBlock, BlockHugeMushroom.EnumType.NORTH);
        for (int d2 = 0; d2 < depth - 1; ++d2) {
            this.setBlockStateRotated(world, southMushroom, this.size - (2 + d2), y, z + width, rotation, sbb);
        }
        final IBlockState southWestMushroom = this.getMushroomState(mushBlock, BlockHugeMushroom.EnumType.NORTH_EAST);
        this.setBlockStateRotated(world, southWestMushroom, this.size - (depth + 1), y, z + width, rotation, sbb);
    }
    
    private IBlockState getMushroomState(final IBlockState mushroomBlockState, final BlockHugeMushroom.EnumType defaultRotation) {
        if (mushroomBlockState.func_177227_a().contains(BlockHugeMushroom.field_176380_a)) {
            return mushroomBlockState.func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)defaultRotation);
        }
        return mushroomBlockState;
    }
    
    protected boolean makeGardenCave(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final Rotation rotation) {
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
        final BlockPos dest = this.offsetTowerCCoords(x, y, z, caveSize, direction);
        final ComponentTFTrollCaveMain cave = new ComponentTFTrollCaveGarden(this.getFeatureType(), index, dest.func_177958_n(), dest.func_177956_o(), dest.func_177952_p(), caveSize, caveHeight, direction);
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, cave.func_74874_b());
        final StructureComponent otherGarden = this.findNearbyGarden(list, cave.func_74874_b());
        if ((intersect == null || intersect == this) && otherGarden == null) {
            list.add(cave);
            cave.func_74861_a(list.get(0), list, rand);
            return this.openingTowards[rotation.ordinal()] = true;
        }
        return false;
    }
    
    private StructureComponent findNearbyGarden(final List<StructureComponent> list, final StructureBoundingBox boundingBox) {
        final StructureBoundingBox structureBoundingBox;
        final StructureBoundingBox largeBox = structureBoundingBox = new StructureBoundingBox(boundingBox);
        structureBoundingBox.field_78897_a -= 30;
        final StructureBoundingBox structureBoundingBox2 = largeBox;
        structureBoundingBox2.field_78895_b -= 30;
        final StructureBoundingBox structureBoundingBox3 = largeBox;
        structureBoundingBox3.field_78896_c -= 30;
        final StructureBoundingBox structureBoundingBox4 = largeBox;
        structureBoundingBox4.field_78893_d += 30;
        final StructureBoundingBox structureBoundingBox5 = largeBox;
        structureBoundingBox5.field_78894_e += 30;
        final StructureBoundingBox structureBoundingBox6 = largeBox;
        structureBoundingBox6.field_78892_f += 30;
        for (final StructureComponent component : list) {
            if (component instanceof ComponentTFTrollCaveGarden && component.func_74874_b().func_78884_a(largeBox)) {
                return component;
            }
        }
        return null;
    }
    
    @Override
    protected boolean makeSmallerCave(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final Rotation rotation) {
        return super.makeSmallerCave(list, rand, index, x, y, z, caveSize, caveHeight, rotation) && (this.openingTowards[rotation.ordinal()] = true);
    }
}
