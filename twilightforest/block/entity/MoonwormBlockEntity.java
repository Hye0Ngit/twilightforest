// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

public class MoonwormBlockEntity extends BlockEntity
{
    public int yawDelay;
    public int currentYaw;
    public int desiredYaw;
    
    public MoonwormBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType)TFBlockEntities.MOONWORM.get(), pos, state);
        this.currentYaw = -1;
        this.yawDelay = 0;
        this.desiredYaw = 0;
    }
    
    public static void tick(final Level level, final BlockPos pos, final BlockState state, final MoonwormBlockEntity te) {
        if (level.f_46443_) {
            if (te.currentYaw == -1) {
                te.currentYaw = level.f_46441_.nextInt(4) * 90;
            }
            if (te.yawDelay > 0) {
                --te.yawDelay;
            }
            else {
                if (te.desiredYaw == 0) {
                    te.yawDelay = 200 + level.f_46441_.nextInt(200);
                    te.desiredYaw = level.f_46441_.nextInt(4) * 90;
                }
                ++te.currentYaw;
                if (te.currentYaw > 360) {
                    te.currentYaw = 0;
                }
                if (te.currentYaw == te.desiredYaw) {
                    te.desiredYaw = 0;
                }
            }
        }
    }
}
