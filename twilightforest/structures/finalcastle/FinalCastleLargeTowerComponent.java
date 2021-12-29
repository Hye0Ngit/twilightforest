// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.block.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.structures.TFStructureComponentOld;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.lichtower.TowerWingComponent;

public class FinalCastleLargeTowerComponent extends TowerWingComponent
{
    public FinalCastleLargeTowerComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCLaTo, nbt);
    }
    
    public FinalCastleLargeTowerComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(FinalCastlePieces.TFFCLaTo, feature, i);
        this.func_186164_a(rotation);
        this.size = 13;
        this.height = 61;
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, -6, 0, -6, 12, 60, 12, Direction.SOUTH);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        final FinalCastleRoof9CrenellatedComponent roof = new FinalCastleRoof9CrenellatedComponent(this.getFeatureType(), rand, 4, this);
        list.add(roof);
        roof.func_74861_a(this, list, rand);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.func_74882_a(world, sbb, 0, 0, 0, 12, 59, 12, false, rand, this.deco.randomBlocks);
        for (int numBranches = 6 + decoRNG.nextInt(4), i = 0; i < numBranches; ++i) {
            this.makeGlyphBranches(world, decoRNG, this.getGlyphMeta(), sbb);
        }
        for (int i = 1; i < 4; ++i) {
            this.func_74882_a(world, sbb, i, -(i * 2), i, 8 - i, 1 - i * 2, 8 - i, false, rand, this.deco.randomBlocks);
        }
        this.func_175811_a(world, this.deco.blockState, 4, -7, 4, sbb);
        final BlockState castleDoor = ((Block)TFBlocks.castle_door_pink.get()).func_176223_P();
        this.func_175804_a(world, sbb, 0, 1, 1, 0, 4, 3, castleDoor, FinalCastleLargeTowerComponent.AIR, false);
        this.placeSignAtCurrentPosition(world, 6, 1, 6, "Parkour area 1", "Unique monster?", sbb);
        return true;
    }
    
    public BlockState getGlyphMeta() {
        return ((Block)TFBlocks.castle_rune_brick_pink.get()).func_176223_P();
    }
}
