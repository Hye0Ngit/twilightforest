// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.block.Block;
import twilightforest.enums.TowerDeviceVariant;
import twilightforest.block.BlockTFTowerDevice;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.TowerTranslucentVariant;
import twilightforest.block.BlockTFTowerTranslucent;
import twilightforest.block.TFBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ITickable;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFTowerBuilder extends TileEntity implements ITickable
{
    private static final int RANGE = 16;
    private int ticksRunning;
    private int blockedCounter;
    private int ticksStopped;
    public boolean makingBlocks;
    private int blocksMade;
    private BlockPos lastBlockCoords;
    private EnumFacing nextFacing;
    private EntityPlayer trackedPlayer;
    private IBlockState blockBuiltState;
    
    public TileEntityTFTowerBuilder() {
        this.ticksRunning = 0;
        this.blockedCounter = 0;
        this.ticksStopped = 0;
        this.makingBlocks = false;
        this.blocksMade = 0;
        this.blockBuiltState = TFBlocks.tower_translucent.func_176223_P().func_177226_a((IProperty)BlockTFTowerTranslucent.VARIANT, (Comparable)TowerTranslucentVariant.BUILT_INACTIVE);
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
            this.nextFacing = this.findNextFacing();
            ++this.ticksRunning;
            if (this.ticksRunning % 10 == 0 && this.lastBlockCoords != null && this.nextFacing != null) {
                final BlockPos nextPos = this.lastBlockCoords.func_177972_a(this.nextFacing);
                if (this.blocksMade <= 16 && this.field_145850_b.func_175623_d(nextPos)) {
                    this.field_145850_b.func_180501_a(nextPos, this.blockBuiltState, 3);
                    this.field_145850_b.func_175718_b(1001, nextPos, 0);
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
                this.field_145850_b.func_180501_a(this.func_174877_v(), TFBlocks.tower_device.func_176223_P().func_177226_a((IProperty)BlockTFTowerDevice.VARIANT, (Comparable)TowerDeviceVariant.BUILDER_TIMEOUT), 3);
                this.field_145850_b.func_175684_a(this.func_174877_v(), (Block)TFBlocks.tower_device, 4);
            }
        }
    }
    
    private EnumFacing findNextFacing() {
        if (this.trackedPlayer == null) {
            return null;
        }
        final int pitch = MathHelper.func_76128_c(this.trackedPlayer.field_70125_A * 4.0f / 360.0f + 1.5) & 0x3;
        if (pitch == 0) {
            return EnumFacing.UP;
        }
        if (pitch == 2) {
            return EnumFacing.DOWN;
        }
        return this.trackedPlayer.func_174811_aO();
    }
    
    private EntityPlayer findClosestValidPlayer() {
        return this.field_145850_b.func_184137_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.5, this.field_174879_c.func_177952_p() + 0.5, 16.0, false);
    }
}
