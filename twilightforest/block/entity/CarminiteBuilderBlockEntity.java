// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import net.minecraft.util.Mth;
import net.minecraft.core.Direction;
import twilightforest.enums.TowerDeviceVariant;
import twilightforest.block.BuilderBlock;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.block.TranslucentBuiltBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

public class CarminiteBuilderBlockEntity extends BlockEntity
{
    private static final int RANGE = 16;
    private int ticksRunning;
    private int blockedCounter;
    private int ticksStopped;
    public boolean makingBlocks;
    private int blocksMade;
    private BlockPos lastBlockCoords;
    private Player trackedPlayer;
    private BlockState blockBuiltState;
    
    public CarminiteBuilderBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType)TFBlockEntities.TOWER_BUILDER.get(), pos, state);
        this.ticksRunning = 0;
        this.blockedCounter = 0;
        this.ticksStopped = 0;
        this.makingBlocks = false;
        this.blocksMade = 0;
        this.blockBuiltState = (BlockState)((Block)TFBlocks.BUILT_BLOCK.get()).m_49966_().m_61124_((Property)TranslucentBuiltBlock.ACTIVE, (Comparable)false);
    }
    
    public void startBuilding() {
        this.makingBlocks = true;
        this.resetStats();
    }
    
    public void resetStats() {
        this.blocksMade = 0;
        this.lastBlockCoords = this.m_58899_();
        this.ticksStopped = 0;
        this.blockedCounter = 0;
    }
    
    public static void tick(final Level level, final BlockPos pos, final BlockState state, final CarminiteBuilderBlockEntity te) {
        if (!level.f_46443_ && te.makingBlocks) {
            if (te.trackedPlayer == null) {
                te.trackedPlayer = te.findClosestValidPlayer();
            }
            final Direction nextFacing = te.findNextFacing();
            ++te.ticksRunning;
            if (te.ticksRunning % 10 == 0 && te.lastBlockCoords != null && nextFacing != null) {
                final BlockPos nextPos = te.lastBlockCoords.m_142300_(nextFacing);
                if (te.blocksMade <= 16 && level.m_46859_(nextPos)) {
                    level.m_7731_(nextPos, te.blockBuiltState, 3);
                    level.m_5594_((Player)null, pos, TFSounds.BUILDER_CREATE, SoundSource.BLOCKS, 0.75f, 1.2f);
                    te.lastBlockCoords = nextPos;
                    te.blockedCounter = 0;
                    ++te.blocksMade;
                }
                else {
                    ++te.blockedCounter;
                }
            }
            if (te.blockedCounter > 0) {
                te.makingBlocks = false;
                te.trackedPlayer = null;
                te.ticksStopped = 0;
            }
        }
        else if (!level.f_46443_ && !te.makingBlocks) {
            te.trackedPlayer = null;
            if (++te.ticksStopped == 60) {
                level.m_46597_(pos, (BlockState)state.m_61124_((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_TIMEOUT));
                level.m_6219_().m_5945_(pos, (Object)state.m_60734_(), 4);
            }
        }
    }
    
    private Direction findNextFacing() {
        if (this.trackedPlayer == null) {
            return null;
        }
        final int pitch = Mth.m_14107_(this.trackedPlayer.m_146909_() * 4.0f / 360.0f + 1.5) & 0x3;
        if (pitch == 0) {
            return Direction.UP;
        }
        if (pitch == 2) {
            return Direction.DOWN;
        }
        return this.trackedPlayer.m_6350_();
    }
    
    private Player findClosestValidPlayer() {
        return this.f_58857_.m_45924_(this.f_58858_.m_123341_() + 0.5, this.f_58858_.m_123342_() + 0.5, this.f_58858_.m_123343_() + 0.5, 16.0, false);
    }
}
