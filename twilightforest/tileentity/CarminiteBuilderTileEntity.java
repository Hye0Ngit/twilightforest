// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.Direction;
import twilightforest.enums.TowerDeviceVariant;
import twilightforest.block.BuilderBlock;
import net.minecraft.state.Property;
import twilightforest.block.TranslucentBuiltBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class CarminiteBuilderTileEntity extends TileEntity implements ITickableTileEntity
{
    private static final int RANGE = 16;
    private int ticksRunning;
    private int blockedCounter;
    private int ticksStopped;
    public boolean makingBlocks;
    private int blocksMade;
    private BlockPos lastBlockCoords;
    private PlayerEntity trackedPlayer;
    private BlockState blockBuiltState;
    
    public CarminiteBuilderTileEntity() {
        super((TileEntityType)TFTileEntities.TOWER_BUILDER.get());
        this.ticksRunning = 0;
        this.blockedCounter = 0;
        this.ticksStopped = 0;
        this.makingBlocks = false;
        this.blocksMade = 0;
        this.blockBuiltState = (BlockState)((Block)TFBlocks.built_block.get()).func_176223_P().func_206870_a((Property)TranslucentBuiltBlock.ACTIVE, (Comparable)false);
    }
    
    public void startBuilding() {
        this.makingBlocks = true;
        this.blocksMade = 0;
        this.lastBlockCoords = this.func_174877_v();
    }
    
    public void func_73660_a() {
        if (!this.field_145850_b.field_72995_K && this.makingBlocks) {
            if (this.trackedPlayer == null) {
                this.trackedPlayer = this.findClosestValidPlayer();
            }
            final Direction nextFacing = this.findNextFacing();
            ++this.ticksRunning;
            if (this.ticksRunning % 10 == 0 && this.lastBlockCoords != null && nextFacing != null) {
                final BlockPos nextPos = this.lastBlockCoords.func_177972_a(nextFacing);
                if (this.blocksMade <= 16 && this.field_145850_b.func_175623_d(nextPos)) {
                    this.field_145850_b.func_180501_a(nextPos, this.blockBuiltState, 3);
                    this.field_145850_b.func_217379_c(1001, nextPos, 0);
                    this.lastBlockCoords = nextPos;
                    this.blockedCounter = 0;
                    ++this.blocksMade;
                }
                else {
                    ++this.blockedCounter;
                }
            }
            if (this.blockedCounter > 0) {
                this.makingBlocks = false;
                this.trackedPlayer = null;
                this.ticksStopped = 0;
            }
        }
        else if (!this.field_145850_b.field_72995_K && !this.makingBlocks) {
            this.trackedPlayer = null;
            if (++this.ticksStopped == 60) {
                this.field_145850_b.func_175656_a(this.func_174877_v(), (BlockState)this.func_195044_w().func_206870_a((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_TIMEOUT));
                this.field_145850_b.func_205220_G_().func_205360_a(this.func_174877_v(), (Object)this.func_195044_w().func_177230_c(), 4);
            }
        }
    }
    
    private Direction findNextFacing() {
        if (this.trackedPlayer == null) {
            return null;
        }
        final int pitch = MathHelper.func_76128_c(this.trackedPlayer.field_70125_A * 4.0f / 360.0f + 1.5) & 0x3;
        if (pitch == 0) {
            return Direction.UP;
        }
        if (pitch == 2) {
            return Direction.DOWN;
        }
        return this.trackedPlayer.func_174811_aO();
    }
    
    private PlayerEntity findClosestValidPlayer() {
        return this.field_145850_b.func_217366_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.5, this.field_174879_c.func_177952_p() + 0.5, 16.0, false);
    }
}
