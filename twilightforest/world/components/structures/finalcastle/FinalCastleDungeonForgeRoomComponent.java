// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class FinalCastleDungeonForgeRoomComponent extends TFStructureComponentOld
{
    public FinalCastleDungeonForgeRoomComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCDunBoR, nbt);
    }
    
    public FinalCastleDungeonForgeRoomComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction direction) {
        super(FinalCastlePieces.TFFCDunBoR, feature, i, x, y, z);
        this.spawnListIndex = 3;
        this.m_73519_(direction);
        this.f_73383_ = TFStructureComponentOld.getComponentToAddBoundingBox2(x, y, z, -15, 0, -15, 50, 30, 50, direction);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.m_73535_(world, sbb, 0, 0, 0, 50, 30, 50);
        this.placeSignAtCurrentPosition(world, 25, 0, 25, "Mini-boss 2", "Gives talisman", sbb);
        return true;
    }
    
    @Override
    public NoiseEffect m_142318_() {
        return NoiseEffect.BURY;
    }
}
