// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import twilightforest.entity.EntityTFRovingCube;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAICubeMoveToRedstoneSymbols extends EntityAIBase
{
    private EntityTFRovingCube myCube;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private double speed;
    
    public EntityAICubeMoveToRedstoneSymbols(final EntityTFRovingCube entityTFRovingCube, final double d) {
        this.myCube = entityTFRovingCube;
        this.speed = d;
    }
    
    public boolean func_75250_a() {
        if (this.myCube.func_70681_au().nextInt(20) != 0) {
            return false;
        }
        final Vec3 vec3 = this.searchForRedstoneSymbol(this.myCube, 16, 5);
        if (vec3 == null) {
            return false;
        }
        this.xPosition = vec3.field_72450_a;
        this.yPosition = vec3.field_72448_b;
        this.zPosition = vec3.field_72449_c;
        return true;
    }
    
    public boolean func_75253_b() {
        return !this.myCube.func_70661_as().func_75500_f();
    }
    
    public void func_75249_e() {
        this.myCube.func_70661_as().func_75492_a(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }
    
    private Vec3 searchForRedstoneSymbol(final EntityTFRovingCube myCube2, final int xzRange, final int yRange) {
        final int curX = MathHelper.func_76128_c(myCube2.field_70165_t);
        final int curY = MathHelper.func_76128_c(myCube2.field_70163_u);
        final int curZ = MathHelper.func_76128_c(myCube2.field_70161_v);
        final boolean foundSymbol = false;
        for (int x = curX - xzRange; x < curX + xzRange; ++x) {
            for (int z = curZ - xzRange; z < curZ + xzRange; ++z) {
                for (int y = curY - yRange; y < curY + yRange; ++y) {
                    if (this.isRedstoneSymbol(x, y, z)) {
                        this.myCube.hasFoundSymbol = true;
                        this.myCube.symbolX = x;
                        this.myCube.symbolY = y;
                        this.myCube.symbolZ = z;
                        return Vec3.func_72443_a((double)x, (double)y, (double)z);
                    }
                }
            }
        }
        return null;
    }
    
    private boolean isRedstoneSymbol(final int x, final int y, final int z) {
        return this.myCube.field_70170_p.func_72899_e(x, y, z) && this.myCube.field_70170_p.func_147437_c(x, y, z) && (this.myCube.field_70170_p.func_147439_a(x + 1, y, z) == Blocks.field_150488_af && this.myCube.field_70170_p.func_147439_a(x - 1, y, z) == Blocks.field_150488_af && this.myCube.field_70170_p.func_147439_a(x, y, z + 1) == Blocks.field_150488_af && this.myCube.field_70170_p.func_147439_a(x, y, z - 1) == Blocks.field_150488_af && this.myCube.field_70170_p.func_147439_a(x + 1, y, z + 1) == Blocks.field_150488_af && this.myCube.field_70170_p.func_147439_a(x - 1, y, z + 1) == Blocks.field_150488_af && this.myCube.field_70170_p.func_147439_a(x + 1, y, z - 1) == Blocks.field_150488_af && this.myCube.field_70170_p.func_147439_a(x - 1, y, z - 1) == Blocks.field_150488_af);
    }
}
