// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class IceTowerBridgeComponent extends TFStructureComponentOld
{
    private int length;
    
    public IceTowerBridgeComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(IceTowerPieces.TFITBri, nbt);
        this.length = nbt.func_74762_e("bridgeLength");
    }
    
    public IceTowerBridgeComponent(final TFFeature feature, final int index, final int x, final int y, final int z, final int length, final Direction direction) {
        super(IceTowerPieces.TFITBri, feature, index);
        this.length = length;
        this.func_186164_a(direction);
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, length, 6, 5, direction);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74768_a("bridgeLength", this.length);
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_74878_a(world, sbb, 0, 1, 0, this.length, 5, 4);
        this.func_175804_a(world, sbb, 0, 0, 0, this.length, 0, 4, this.deco.blockState, this.deco.blockState, false);
        this.func_175804_a(world, sbb, 0, 6, 0, this.length, 6, 4, this.deco.blockState, this.deco.blockState, false);
        for (int x = 2; x < this.length; x += 3) {
            this.func_175804_a(world, sbb, x, 1, 0, x, 5, 0, this.deco.pillarState, this.deco.pillarState, false);
            this.func_175804_a(world, sbb, x, 1, 4, x, 5, 4, this.deco.pillarState, this.deco.pillarState, false);
        }
        return true;
    }
}
