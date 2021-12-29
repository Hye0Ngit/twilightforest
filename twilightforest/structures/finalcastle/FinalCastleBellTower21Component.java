// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.block.BlockState;
import twilightforest.util.RotationUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Rotation;
import twilightforest.structures.TFStructureComponentOld;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class FinalCastleBellTower21Component extends FinalCastleMazeTower13Component
{
    private static final int FLOORS = 8;
    
    public FinalCastleBellTower21Component(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCBelTo, nbt);
    }
    
    public FinalCastleBellTower21Component(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction) {
        super(FinalCastlePieces.TFFCBelTo, feature, rand, i, x, y, z, 8, 1, ((Block)TFBlocks.castle_rune_brick_blue.get()).func_176223_P(), direction);
        this.size = 21;
        final int floors = 8;
        this.height = floors * 8 + 1;
        this.field_74887_e = TFStructureComponentOld.getComponentToAddBoundingBox2(x, y, z, -6, -8, -this.size / 2, this.size - 1, this.height, this.size - 1, direction);
        this.openings.clear();
        this.addOpening(0, 9, this.size / 2, Rotation.CLOCKWISE_180);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        final FinalCastleBellFoundation21Component foundation = new FinalCastleBellFoundation21Component(this.getFeatureType(), rand, 4, this);
        list.add(foundation);
        foundation.func_74861_a(this, list, rand);
        final TFStructureComponentOld roof = new FinalCastleRoof13CrenellatedComponent(this.getFeatureType(), rand, 4, this);
        list.add(roof);
        roof.func_74861_a((StructurePiece)this, (List)list, rand);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        final BlockState fieldBlock = ((Block)TFBlocks.force_field_blue.get()).func_176223_P();
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            int y = 48;
            for (int x = 5; x < this.size - 4; x += 2) {
                this.fillBlocksRotated(world, sbb, x, y, 0, x, y + 14, 0, fieldBlock, rotation);
            }
            y = 24;
            for (int x = 1; x < this.size - 1; x += 8) {
                this.fillBlocksRotated(world, sbb, x, y, 0, x, y + 14, 0, fieldBlock, rotation);
                this.fillBlocksRotated(world, sbb, x + 2, y, 0, x + 2, y + 14, 0, fieldBlock, rotation);
            }
        }
        this.placeSignAtCurrentPosition(world, 7, 9, 8, "Parkour area 2", "mini-boss 1", sbb);
        return true;
    }
}
