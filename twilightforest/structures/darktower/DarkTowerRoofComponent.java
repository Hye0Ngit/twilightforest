// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.structures.TFStructureComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import twilightforest.structures.lichtower.TowerWingComponent;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.lichtower.TowerRoofComponent;

public class DarkTowerRoofComponent extends TowerRoofComponent
{
    public DarkTowerRoofComponent(final TemplateManager manager, final CompoundNBT nbt) {
        this(DarkTowerPieces.TFDTRooS, nbt);
    }
    
    public DarkTowerRoofComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
    }
    
    public DarkTowerRoofComponent(final IStructurePieceType piece, final TFFeature feature, final int i, final TowerWingComponent wing) {
        super(piece, feature, i);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size;
        this.height = 12;
        this.makeCapBB(wing);
        this.spawnListIndex = 1;
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 0; x <= this.size - 1; ++x) {
            for (int z = 0; z <= this.size - 1; ++z) {
                if (x == 0 || x == this.size - 1 || z == 0 || z == this.size - 1) {
                    this.func_175811_a(world, this.deco.fenceState, x, 1, z, sbb);
                }
            }
        }
        this.func_175811_a(world, this.deco.accentState, 0, 1, 0, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size - 1, 1, 0, sbb);
        this.func_175811_a(world, this.deco.accentState, 0, 1, this.size - 1, sbb);
        this.func_175811_a(world, this.deco.accentState, this.size - 1, 1, this.size - 1, sbb);
        return true;
    }
}
