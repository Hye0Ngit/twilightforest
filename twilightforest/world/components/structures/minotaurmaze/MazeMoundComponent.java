// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class MazeMoundComponent extends TFStructureComponentOld
{
    public static final int DIAMETER = 35;
    private int averageGroundLevel;
    private MazeUpperEntranceComponent mazeAbove;
    
    public MazeMoundComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MinotaurMazePieces.TFMMMound, nbt);
        this.averageGroundLevel = Integer.MIN_VALUE;
    }
    
    public MazeMoundComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMMound, feature, i, new BoundingBox(x, y, z, x + 35, y + 12, z + 35));
        this.averageGroundLevel = Integer.MIN_VALUE;
        this.m_73519_(Direction.Plane.HORIZONTAL.m_122560_(rand));
    }
    
    public void m_142537_(final StructurePiece structurecomponent, final StructurePieceAccessor list, final Random random) {
        super.m_142537_(structurecomponent, list, random);
        list.m_142679_((StructurePiece)(this.mazeAbove = new MazeUpperEntranceComponent(this.getFeatureType(), 3, random, this.f_73383_.m_162395_() + 10, this.f_73383_.m_162396_(), this.f_73383_.m_162398_() + 10)));
        this.mazeAbove.m_142537_(this, list, random);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (int x = 0; x < 35; ++x) {
            for (int z = 0; z < 35; ++z) {
                final int cx = x - 17;
                final int cz = z - 17;
                final int dist = (int)Mth.m_14116_((float)(cx * cx + cz * cz));
                final int hheight = (int)(Mth.m_14089_(dist / 35.0f * 3.1415927f) * 11.0f);
                if ((cx > 2 || cx < -1 || cz > 2 || cz < -1) && (((cx > 2 || cx < -1) && (cz > 2 || cz < -1)) || hheight > 6)) {
                    this.m_73434_(world, Blocks.f_50440_.m_49966_(), x, hheight, z, sbb);
                    if ((cx > 2 || cx < -1) && (cz > 2 || cz < -1)) {
                        this.m_73434_(world, Blocks.f_50493_.m_49966_(), x, hheight - 1, z, sbb);
                    }
                    else if (hheight > 6) {
                        this.m_73441_(world, sbb, x, 6, z, x, hheight - 1, z, Blocks.f_50493_.m_49966_(), MazeMoundComponent.AIR, false);
                    }
                }
            }
        }
        return true;
    }
}
