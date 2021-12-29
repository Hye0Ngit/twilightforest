// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.icetower;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.components.structures.TFStructureComponent;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class IceTowerBridgeComponent extends TFStructureComponentOld
{
    private int length;
    
    public IceTowerBridgeComponent(final ServerLevel level, final CompoundTag nbt) {
        super(IceTowerPieces.TFITBri, nbt);
        this.length = nbt.m_128451_("bridgeLength");
    }
    
    public IceTowerBridgeComponent(final TFFeature feature, final int index, final int x, final int y, final int z, final int length, final Direction direction) {
        super(IceTowerPieces.TFITBri, feature, index, x, y, z);
        this.length = length;
        this.m_73519_(direction);
        this.f_73383_ = feature.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, length, 6, 5, direction);
    }
    
    @Override
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        super.m_142347_(level, tagCompound);
        tagCompound.m_128405_("bridgeLength", this.length);
    }
    
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponent) {
            final TFStructureComponent tfStructureComponent = (TFStructureComponent)parent;
            this.deco = tfStructureComponent.deco;
        }
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73535_(world, sbb, 0, 1, 0, this.length, 5, 4);
        this.m_73441_(world, sbb, 0, 0, 0, this.length, 0, 4, this.deco.blockState, this.deco.blockState, false);
        this.m_73441_(world, sbb, 0, 6, 0, this.length, 6, 4, this.deco.blockState, this.deco.blockState, false);
        for (int x = 2; x < this.length; x += 3) {
            this.m_73441_(world, sbb, x, 1, 0, x, 5, 0, this.deco.pillarState, this.deco.pillarState, false);
            this.m_73441_(world, sbb, x, 1, 4, x, 5, 4, this.deco.pillarState, this.deco.pillarState, false);
        }
        return true;
    }
}
