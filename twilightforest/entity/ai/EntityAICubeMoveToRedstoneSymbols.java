// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import twilightforest.entity.EntityTFRovingCube;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAICubeMoveToRedstoneSymbols extends EntityAIBase
{
    private final EntityTFRovingCube myCube;
    private final double speed;
    private BlockPos targetPos;
    
    public EntityAICubeMoveToRedstoneSymbols(final EntityTFRovingCube entityTFRovingCube, final double d) {
        this.myCube = entityTFRovingCube;
        this.speed = d;
        this.func_75248_a(1);
    }
    
    public boolean func_75250_a() {
        if (this.myCube.func_70681_au().nextInt(20) != 0) {
            return false;
        }
        final BlockPos pos = this.searchForRedstoneSymbol(this.myCube, 16, 5);
        if (pos == null) {
            return false;
        }
        this.targetPos = pos;
        return true;
    }
    
    public boolean func_75253_b() {
        return !this.myCube.func_70661_as().func_75500_f();
    }
    
    public void func_75249_e() {
        this.myCube.func_70661_as().func_75492_a((double)this.targetPos.func_177958_n(), (double)this.targetPos.func_177956_o(), (double)this.targetPos.func_177952_p(), this.speed);
    }
    
    private BlockPos searchForRedstoneSymbol(final EntityTFRovingCube myCube2, final int xzRange, final int yRange) {
        final BlockPos curPos = new BlockPos((Entity)myCube2);
        for (int x = -xzRange; x < xzRange; ++x) {
            for (int z = -xzRange; z < xzRange; ++z) {
                for (int y = -yRange; y < yRange; ++y) {
                    if (this.isRedstoneSymbol(curPos.func_177982_a(x, y, z))) {
                        this.myCube.hasFoundSymbol = true;
                        this.myCube.symbolX = curPos.func_177958_n() + x;
                        this.myCube.symbolY = curPos.func_177956_o() + y;
                        this.myCube.symbolZ = curPos.func_177952_p() + z;
                        return curPos.func_177982_a(x, y, z);
                    }
                }
            }
        }
        return null;
    }
    
    private boolean isRedstoneSymbol(final BlockPos pos) {
        if (!this.myCube.field_70170_p.func_175667_e(pos) || !this.myCube.field_70170_p.func_175623_d(pos)) {
            return false;
        }
        for (final EnumFacing e : EnumFacing.field_82609_l) {
            if (this.myCube.field_70170_p.func_180495_p(pos.func_177972_a(e)).func_177230_c() != Blocks.field_150488_af) {
                return false;
            }
        }
        return true;
    }
}
