// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.mushroomtower;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.MutableBoundingBox;
import twilightforest.TwilightForestMod;
import net.minecraft.util.Rotation;
import twilightforest.structures.TFStructureComponentOld;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class MushroomTowerBridgeComponent extends MushroomTowerWingComponent
{
    int dSize;
    int dHeight;
    
    public MushroomTowerBridgeComponent(final TemplateManager manager, final CompoundNBT nbt) {
        this(MushroomTowerPieces.TFMTBri, nbt);
    }
    
    public MushroomTowerBridgeComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
        this.dSize = nbt.func_74762_e("destSize");
        this.dHeight = nbt.func_74762_e("destHeight");
    }
    
    protected MushroomTowerBridgeComponent(final IStructurePieceType piece, final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(piece, feature, i, x, y, z, pSize, pHeight, direction);
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, 3, direction);
        this.dSize = pSize;
        this.dHeight = pHeight;
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74768_a("destSize", this.dSize);
        tagCompound.func_74768_a("destHeight", this.dHeight);
    }
    
    @Override
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        final int[] dest = { this.dSize - 1, 1, 1 };
        final boolean madeWing = this.makeTowerWing(list, rand, this.func_74877_c(), dest[0], dest[1], dest[2], this.dSize, this.dHeight, Rotation.NONE);
        if (!madeWing) {
            final int[] dx = this.offsetTowerCoords(dest[0], dest[1], dest[2], this.dSize, Direction.SOUTH);
            TwilightForestMod.LOGGER.info("Making tower wing failed when bridge was already made.  Size = {}, x = {}, z = {}", (Object)this.dSize, (Object)dx[0], (Object)dx[2]);
        }
    }
    
    public MutableBoundingBox getWingBB() {
        final int[] dest = this.offsetTowerCoords(this.dSize - 1, 1, 1, this.dSize, this.func_186165_e());
        return this.feature.getComponentToAddBoundingBox(dest[0], dest[1], dest[2], 0, 0, 0, this.dSize - 1, this.dHeight - 1, this.dSize - 1, this.func_186165_e());
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 0; x < this.dSize; ++x) {
            this.func_175811_a(world, this.deco.fenceState, x, 1, 0, sbb);
            this.func_175811_a(world, this.deco.fenceState, x, 1, 2, sbb);
            this.func_175811_a(world, this.isAscender ? Blocks.field_196668_q.func_176223_P() : this.deco.floorState, x, 0, 1, sbb);
        }
        this.func_74878_a(world, sbb, 0, 1, 1, 2, 2, 1);
        return true;
    }
}
