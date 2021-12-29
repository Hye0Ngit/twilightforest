// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import twilightforest.biomes.TFBiomes;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.state.IBlockState;
import twilightforest.block.BlockTFCastleMagic;
import twilightforest.block.BlockTFForceField;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.CastleBrickVariant;
import twilightforest.block.BlockTFCastleBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.Rotation;
import twilightforest.util.RotationUtil;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.world.biome.Biome;
import java.util.function.Predicate;
import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFFinalCastleDungeonRoom31 extends ComponentTFTowerWing
{
    public int level;
    protected static final Predicate<Biome> plateauBiomes;
    
    public ComponentTFFinalCastleDungeonRoom31() {
    }
    
    public ComponentTFFinalCastleDungeonRoom31(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final EnumFacing direction, final int level) {
        super(feature, i);
        this.func_186164_a(direction);
        this.spawnListIndex = 2;
        this.size = 31;
        this.height = 7;
        this.level = level;
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -15, 0, -15, this.size - 1, this.height - 1, this.size - 1, EnumFacing.SOUTH);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        final int mySpread = this.func_74877_c() - parent.func_74877_c();
        final int maxSpread = (this.level == 1) ? 2 : 3;
        if (mySpread == maxSpread && !this.isExitBuildForLevel(parent)) {
            Rotation direction = RotationUtil.getRandomRotation(rand);
            for (int i = 0; i < 8 && !this.isExitBuildForLevel(parent); ++i) {
                direction = direction.func_185830_a(RotationUtil.ROTATIONS[i & 0x3]);
                if (this.addDungeonExit(parent, list, rand, direction)) {
                    this.setExitBuiltForLevel(parent, true);
                }
            }
        }
        if (mySpread < maxSpread) {
            Rotation direction = RotationUtil.getRandomRotation(rand);
            for (int i = 0; i < 12; ++i) {
                direction = direction.func_185830_a(RotationUtil.ROTATIONS[i & 0x3]);
                this.addDungeonRoom(parent, list, rand, direction, this.level);
            }
        }
    }
    
    private boolean isExitBuildForLevel(final StructureComponent parent) {
        return parent instanceof ComponentTFFinalCastleDungeonEntrance && ((ComponentTFFinalCastleDungeonEntrance)parent).hasExit;
    }
    
    private void setExitBuiltForLevel(final StructureComponent parent, final boolean exit) {
        if (parent instanceof ComponentTFFinalCastleDungeonEntrance) {
            ((ComponentTFFinalCastleDungeonEntrance)parent).hasExit = exit;
        }
    }
    
    protected boolean addDungeonRoom(final StructureComponent parent, final List<StructureComponent> list, final Random rand, Rotation rotation, final int level) {
        rotation = rotation.func_185830_a(this.field_186169_c);
        final BlockPos rc = this.getNewRoomCoords(rand, rotation);
        final ComponentTFFinalCastleDungeonRoom31 dRoom = new ComponentTFFinalCastleDungeonRoom31(this.getFeatureType(), rand, this.field_74886_g + 1, rc.func_177958_n(), rc.func_177956_o(), rc.func_177952_p(), rotation.func_185831_a(EnumFacing.SOUTH), level);
        final StructureBoundingBox largerBB = new StructureBoundingBox(dRoom.func_74874_b());
        final int expand = 0;
        final StructureBoundingBox structureBoundingBox = largerBB;
        structureBoundingBox.field_78897_a -= expand;
        final StructureBoundingBox structureBoundingBox2 = largerBB;
        structureBoundingBox2.field_78896_c -= expand;
        final StructureBoundingBox structureBoundingBox3 = largerBB;
        structureBoundingBox3.field_78893_d += expand;
        final StructureBoundingBox structureBoundingBox4 = largerBB;
        structureBoundingBox4.field_78892_f += expand;
        final StructureComponent intersect = StructureTFComponentOld.findIntersectingExcluding(list, largerBB, this);
        if (intersect == null) {
            list.add(dRoom);
            dRoom.func_74861_a(parent, list, rand);
            return true;
        }
        return false;
    }
    
    protected boolean addDungeonExit(final StructureComponent parent, final List<StructureComponent> list, final Random rand, Rotation rotation) {
        rotation = rotation.func_185830_a(this.field_186169_c);
        final BlockPos rc = this.getNewRoomCoords(rand, rotation);
        final ComponentTFFinalCastleDungeonExit dRoom = new ComponentTFFinalCastleDungeonExit(this.getFeatureType(), rand, this.field_74886_g + 1, rc.func_177958_n(), rc.func_177956_o(), rc.func_177952_p(), rotation.func_185831_a(EnumFacing.SOUTH), this.level);
        final StructureComponent intersect = StructureTFComponentOld.findIntersectingExcluding(list, dRoom.func_74874_b(), this);
        if (intersect == null) {
            list.add(dRoom);
            dRoom.func_74861_a(this, list, rand);
            return true;
        }
        return false;
    }
    
    private BlockPos getNewRoomCoords(final Random rand, final Rotation rotation) {
        int offset = rand.nextInt(15) - 9;
        if (rand.nextBoolean()) {
            offset += this.size;
        }
        switch (rotation) {
            default: {
                return new BlockPos(this.field_74887_e.field_78893_d + 9, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + offset);
            }
            case CLOCKWISE_90: {
                return new BlockPos(this.field_74887_e.field_78897_a + offset, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 9);
            }
            case CLOCKWISE_180: {
                return new BlockPos(this.field_74887_e.field_78897_a - 9, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + offset);
            }
            case COUNTERCLOCKWISE_90: {
                return new BlockPos(this.field_74887_e.field_78897_a + offset, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 9);
            }
        }
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.isBoundingBoxOutsideBiomes(world, sbb, ComponentTFFinalCastleDungeonRoom31.plateauBiomes)) {
            return false;
        }
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.fillWithAir(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, state -> state.func_185904_a() == Material.field_151576_e);
        final IBlockState floor = TFBlocks.castle_brick.func_176223_P();
        final IBlockState border = floor.func_177226_a((IProperty)BlockTFCastleBlock.VARIANT, (Comparable)CastleBrickVariant.FRAME);
        final Predicate<IBlockState> replacing = state -> {
            final Material material = state.func_185904_a();
            return material == Material.field_151576_e || material == Material.field_151579_a;
        };
        final int cs = 7;
        this.fillWithBlocks(world, sbb, 7, -1, 7, this.size - 1 - 7, -1, this.size - 1 - 7, border, floor, replacing);
        this.fillWithBlocks(world, sbb, 7, this.height, 7, this.size - 1 - 7, this.height, this.size - 1 - 7, border, floor, replacing);
        final EnumDyeColor forceFieldColor = this.getForceFieldColor(decoRNG);
        final EnumDyeColor runeColor = this.getRuneColor(forceFieldColor);
        final IBlockState forceField = TFBlocks.force_field.func_176223_P().func_177226_a((IProperty)BlockTFForceField.COLOR, (Comparable)forceFieldColor);
        final IBlockState castleMagic = TFBlocks.castle_rune_brick.func_176223_P().func_177226_a((IProperty)BlockTFCastleMagic.COLOR, (Comparable)runeColor);
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 7, 0, 8, 7, this.height - 1, this.size - 2 - 7, forceField, rotation);
            for (int z = 7; z < this.size - 1 - 7; z += 4) {
                this.fillBlocksRotated(world, sbb, 7, 0, z, 7, this.height - 1, z, castleMagic, rotation);
                final int y = ((z - 7) % 8 == 0) ? (decoRNG.nextInt(3) + 0) : (decoRNG.nextInt(3) + 4);
                this.fillBlocksRotated(world, sbb, 7, y, z + 1, 7, y, z + 3, castleMagic, rotation);
            }
        }
        return true;
    }
    
    protected EnumDyeColor getRuneColor(final EnumDyeColor forceFieldColor) {
        return BlockTFCastleMagic.VALID_COLORS.get((forceFieldColor == BlockTFForceField.VALID_COLORS.get(4)) ? 1 : 2);
    }
    
    protected EnumDyeColor getForceFieldColor(final Random decoRNG) {
        return BlockTFForceField.VALID_COLORS.get(decoRNG.nextInt(2) + 3);
    }
    
    static {
        plateauBiomes = (biome -> biome == TFBiomes.highlandsCenter || biome == TFBiomes.thornlands);
    }
}
