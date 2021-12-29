// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.block.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.Rotation;
import twilightforest.util.RotationUtil;
import twilightforest.structures.TFStructureComponentOld;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.biome.Biome;
import java.util.function.Predicate;
import twilightforest.structures.lichtower.TowerWingComponent;

public class FinalCastleDungeonRoom31Component extends TowerWingComponent
{
    public int level;
    protected static final Predicate<Biome> plateauBiomes;
    
    public FinalCastleDungeonRoom31Component(final TemplateManager manager, final CompoundNBT nbt) {
        this(FinalCastlePieces.TFFCDunR31, nbt);
    }
    
    public FinalCastleDungeonRoom31Component(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
    }
    
    public FinalCastleDungeonRoom31Component(final IStructurePieceType piece, final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction, final int level) {
        super(piece, feature, i);
        this.func_186164_a(direction);
        this.spawnListIndex = 2;
        this.size = 31;
        this.height = 7;
        this.level = level;
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, -15, 0, -15, this.size - 1, this.height - 1, this.size - 1, Direction.SOUTH);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
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
    
    private boolean isExitBuildForLevel(final StructurePiece parent) {
        return parent instanceof FinalCastleDungeonEntranceComponent && ((FinalCastleDungeonEntranceComponent)parent).hasExit;
    }
    
    private void setExitBuiltForLevel(final StructurePiece parent, final boolean exit) {
        if (parent instanceof FinalCastleDungeonEntranceComponent) {
            ((FinalCastleDungeonEntranceComponent)parent).hasExit = exit;
        }
    }
    
    protected boolean addDungeonRoom(final StructurePiece parent, final List<StructurePiece> list, final Random rand, Rotation rotation, final int level) {
        rotation = rotation.func_185830_a(this.field_186169_c);
        final BlockPos rc = this.getNewRoomCoords(rand, rotation);
        final FinalCastleDungeonRoom31Component dRoom = new FinalCastleDungeonRoom31Component(FinalCastlePieces.TFFCDunR31, this.getFeatureType(), rand, this.field_74886_g + 1, rc.func_177958_n(), rc.func_177956_o(), rc.func_177952_p(), rotation.func_185831_a(Direction.SOUTH), level);
        final MutableBoundingBox largerBB = new MutableBoundingBox(dRoom.func_74874_b());
        final int expand = 0;
        final MutableBoundingBox mutableBoundingBox = largerBB;
        mutableBoundingBox.field_78897_a -= expand;
        final MutableBoundingBox mutableBoundingBox2 = largerBB;
        mutableBoundingBox2.field_78896_c -= expand;
        final MutableBoundingBox mutableBoundingBox3 = largerBB;
        mutableBoundingBox3.field_78893_d += expand;
        final MutableBoundingBox mutableBoundingBox4 = largerBB;
        mutableBoundingBox4.field_78892_f += expand;
        final StructurePiece intersect = TFStructureComponentOld.findIntersectingExcluding(list, largerBB, this);
        if (intersect == null) {
            list.add(dRoom);
            dRoom.func_74861_a(parent, list, rand);
            return true;
        }
        return false;
    }
    
    protected boolean addDungeonExit(final StructurePiece parent, final List<StructurePiece> list, final Random rand, Rotation rotation) {
        rotation = rotation.func_185830_a(this.field_186169_c);
        final BlockPos rc = this.getNewRoomCoords(rand, rotation);
        final FinalCastleDungeonExitComponent dRoom = new FinalCastleDungeonExitComponent(this.getFeatureType(), rand, this.field_74886_g + 1, rc.func_177958_n(), rc.func_177956_o(), rc.func_177952_p(), rotation.func_185831_a(Direction.SOUTH), this.level);
        final StructurePiece intersect = TFStructureComponentOld.findIntersectingExcluding(list, dRoom.func_74874_b(), this);
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
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        if (this.isBoundingBoxOutsideBiomes(world, FinalCastleDungeonRoom31Component.plateauBiomes)) {
            return false;
        }
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.fillWithAir(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, state -> state.func_185904_a() == Material.field_151576_e);
        final BlockState floor = ((Block)TFBlocks.castle_brick.get()).func_176223_P();
        final BlockState border = ((Block)TFBlocks.castle_brick_frame.get()).func_176223_P();
        final Predicate<BlockState> replacing = state -> {
            final Material material = state.func_185904_a();
            return material == Material.field_151576_e || material == Material.field_151579_a;
        };
        final int cs = 7;
        this.fillWithBlocks(world, sbb, 7, -1, 7, this.size - 1 - 7, -1, this.size - 1 - 7, border, floor, replacing);
        this.fillWithBlocks(world, sbb, 7, this.height, 7, this.size - 1 - 7, this.height, this.size - 1 - 7, border, floor, replacing);
        final BlockState forceField = this.getForceFieldColor(decoRNG);
        final BlockState castleMagic = this.getRuneColor(forceField);
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 7, 0, 8, 7, this.height - 1, this.size - 2 - 7, forceField, rotation);
            for (int z = 7; z < this.size - 1 - 7; z += 4) {
                this.fillBlocksRotated(world, sbb, 7, 0, z, 7, this.height - 1, z, castleMagic, rotation);
                final int y = ((z - 7) % 8 == 0) ? decoRNG.nextInt(3) : (decoRNG.nextInt(3) + 4);
                this.fillBlocksRotated(world, sbb, 7, y, z + 1, 7, y, z + 3, castleMagic, rotation);
            }
        }
        return true;
    }
    
    protected BlockState getRuneColor(final BlockState forceFieldColor) {
        return (forceFieldColor == ((Block)TFBlocks.force_field_blue.get()).func_176223_P()) ? ((Block)TFBlocks.castle_rune_brick_blue.get()).func_176223_P() : ((Block)TFBlocks.castle_rune_brick_yellow.get()).func_176223_P();
    }
    
    protected BlockState getForceFieldColor(final Random decoRNG) {
        final int i = decoRNG.nextInt(2) + 3;
        if (i == 3) {
            return ((Block)TFBlocks.force_field_green.get()).func_176223_P();
        }
        return ((Block)TFBlocks.force_field_blue.get()).func_176223_P();
    }
    
    static {
        plateauBiomes = (biome -> true);
    }
}
