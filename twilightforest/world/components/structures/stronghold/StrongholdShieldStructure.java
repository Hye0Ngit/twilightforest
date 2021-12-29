// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.DirectionalBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class StrongholdShieldStructure extends StructureTFStrongholdComponent
{
    public StrongholdShieldStructure(final ServerLevel level, final CompoundTag nbt) {
        super(StrongholdPieces.TFSShield, nbt);
        this.spawnListIndex = -1;
    }
    
    @Override
    public BoundingBox generateBoundingBox(final Direction facing, final int x, final int y, final int z) {
        return null;
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random randomIn, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState down = (BlockState)((Block)TFBlocks.STRONGHOLD_SHIELD.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.DOWN);
        final BlockState up = (BlockState)((Block)TFBlocks.STRONGHOLD_SHIELD.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.UP);
        final BlockState north = (BlockState)((Block)TFBlocks.STRONGHOLD_SHIELD.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.NORTH);
        final BlockState south = (BlockState)((Block)TFBlocks.STRONGHOLD_SHIELD.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.SOUTH);
        final BlockState west = (BlockState)((Block)TFBlocks.STRONGHOLD_SHIELD.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.WEST);
        final BlockState east = (BlockState)((Block)TFBlocks.STRONGHOLD_SHIELD.get()).m_49966_().m_61124_((Property)DirectionalBlock.f_52588_, (Comparable)Direction.EAST);
        this.m_73441_(world, sbb, this.f_73383_.m_71056_(), 0, 0, this.f_73383_.m_71056_(), this.f_73383_.m_71057_(), this.f_73383_.m_71058_(), west, west, false);
        this.m_73441_(world, sbb, 0, 0, 0, 0, this.f_73383_.m_71057_(), this.f_73383_.m_71058_(), east, east, false);
        this.m_73441_(world, sbb, 0, 0, this.f_73383_.m_71058_(), this.f_73383_.m_71056_(), this.f_73383_.m_71057_(), this.f_73383_.m_71058_(), north, north, false);
        this.m_73441_(world, sbb, 0, 0, 0, this.f_73383_.m_71056_(), this.f_73383_.m_71057_(), 0, south, south, false);
        this.m_73441_(world, sbb, 0, 0, 0, this.f_73383_.m_71056_(), 0, this.f_73383_.m_71058_(), up, up, false);
        this.m_73441_(world, sbb, 0, this.f_73383_.m_71057_(), 0, this.f_73383_.m_71056_(), this.f_73383_.m_71057_(), this.f_73383_.m_71058_(), down, down, false);
        return true;
    }
}
