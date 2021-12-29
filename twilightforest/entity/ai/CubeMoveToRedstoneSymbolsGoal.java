// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3i;
import java.util.EnumSet;
import net.minecraft.util.math.BlockPos;
import twilightforest.entity.RovingCubeEntity;
import net.minecraft.entity.ai.goal.Goal;

public class CubeMoveToRedstoneSymbolsGoal extends Goal
{
    private final RovingCubeEntity myCube;
    private final double speed;
    private BlockPos targetPos;
    
    public CubeMoveToRedstoneSymbolsGoal(final RovingCubeEntity entityTFRovingCube, final double d) {
        this.myCube = entityTFRovingCube;
        this.speed = d;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE));
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
    
    private BlockPos searchForRedstoneSymbol(final RovingCubeEntity myCube2, final int xzRange, final int yRange) {
        final BlockPos curPos = new BlockPos((Vector3i)myCube2.func_233580_cy_());
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
        for (final Direction e : Direction.values()) {
            if (this.myCube.field_70170_p.func_180495_p(pos.func_177972_a(e)).func_177230_c() != Blocks.field_150488_af) {
                return false;
            }
        }
        return true;
    }
}
