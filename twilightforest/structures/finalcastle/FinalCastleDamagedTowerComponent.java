// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import java.util.Iterator;
import java.util.ArrayList;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.BlockPos;
import twilightforest.structures.TFStructureComponentOld;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class FinalCastleDamagedTowerComponent extends FinalCastleMazeTower13Component
{
    public FinalCastleDamagedTowerComponent(final TemplateManager manager, final CompoundNBT nbt) {
        this(FinalCastlePieces.TFFCDamT, nbt);
    }
    
    public FinalCastleDamagedTowerComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
    }
    
    public FinalCastleDamagedTowerComponent(final IStructurePieceType piece, final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction) {
        super(piece, feature, rand, i, x, y, z, ((Block)TFBlocks.castle_rune_brick_yellow.get()).func_176223_P(), direction);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        final FinalCastleFoundation13Component foundation = new FinalCastleFoundation13Component(FinalCastlePieces.TFFCToF13, this.getFeatureType(), rand, 0, this);
        list.add(foundation);
        foundation.func_74861_a(this, list, rand);
        final FinalCastleFoundation13Component thorns = new FinalCastleFoundation13ComponentThorns(this.getFeatureType(), rand, 0, this);
        list.add(thorns);
        thorns.func_74861_a(this, list, rand);
        this.buildNonCriticalTowers(parent, list, rand);
    }
    
    @Override
    protected FinalCastleMazeTower13Component makeNewDamagedTower(final Random rand, final Direction facing, final BlockPos tc) {
        return new FinalCastleWreckedTowerComponent(this.getFeatureType(), rand, this.func_74877_c() + 1, tc.func_177958_n(), tc.func_177956_o(), tc.func_177952_p(), facing);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        super.func_230383_a_(world, manager, generator, rand, sbb, chunkPosIn, blockPos);
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.destroyTower(world, decoRNG, sbb);
        return true;
    }
    
    public void destroyTower(final ISeedReader world, final Random rand, final MutableBoundingBox sbb) {
        final ArrayList<DestroyArea> areas = this.makeInitialDestroyList(rand);
        boolean hitDeadRock = false;
        final BlockPos.Mutable pos = new BlockPos.Mutable();
        for (int y = this.field_74887_e.field_78894_e; !hitDeadRock && y > 64; --y) {
            for (int x = this.field_74887_e.field_78897_a - 2; x <= this.field_74887_e.field_78893_d + 2; ++x) {
                for (int z = this.field_74887_e.field_78896_c - 2; z <= this.field_74887_e.field_78892_f + 2; ++z) {
                    pos.func_181079_c(x, y, z);
                    if (sbb.func_175898_b((Vector3i)pos)) {
                        if (world.func_180495_p((BlockPos)pos).func_177230_c() == TFBlocks.deadrock.get()) {
                            hitDeadRock = true;
                        }
                        this.determineBlockDestroyed(world, areas, y, x, z);
                    }
                }
            }
            DestroyArea removeArea = null;
            for (final DestroyArea dArea : areas) {
                if (dArea == null || dArea.isEntirelyAbove(y)) {
                    removeArea = dArea;
                }
            }
            if (removeArea != null) {
                areas.remove(removeArea);
                areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, y, areas));
            }
        }
    }
    
    protected ArrayList<DestroyArea> makeInitialDestroyList(final Random rand) {
        final ArrayList<DestroyArea> areas = new ArrayList<DestroyArea>(2);
        areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
        areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
        return areas;
    }
    
    protected void determineBlockDestroyed(final ISeedReader world, final ArrayList<DestroyArea> areas, final int y, final int x, final int z) {
        final BlockPos pos = new BlockPos(x, y, z);
        for (final DestroyArea dArea : areas) {
            if (dArea != null && dArea.isVecInside(pos)) {
                world.func_217377_a(pos, false);
            }
        }
    }
}
