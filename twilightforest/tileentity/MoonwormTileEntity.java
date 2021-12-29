// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class MoonwormTileEntity extends TileEntity implements ITickableTileEntity
{
    public int yawDelay;
    public int currentYaw;
    public int desiredYaw;
    
    public MoonwormTileEntity() {
        super((TileEntityType)TFTileEntities.MOONWORM.get());
        this.currentYaw = -1;
        this.yawDelay = 0;
        this.desiredYaw = 0;
    }
    
    public void func_73660_a() {
        if (this.field_145850_b.field_72995_K) {
            if (this.currentYaw == -1) {
                this.currentYaw = this.field_145850_b.field_73012_v.nextInt(4) * 90;
            }
            if (this.yawDelay > 0) {
                --this.yawDelay;
            }
            else {
                if (this.desiredYaw == 0) {
                    this.yawDelay = 200 + this.field_145850_b.field_73012_v.nextInt(200);
                    this.desiredYaw = this.field_145850_b.field_73012_v.nextInt(4) * 90;
                }
                ++this.currentYaw;
                if (this.currentYaw > 360) {
                    this.currentYaw = 0;
                }
                if (this.currentYaw == this.desiredYaw) {
                    this.desiredYaw = 0;
                }
            }
        }
    }
}
