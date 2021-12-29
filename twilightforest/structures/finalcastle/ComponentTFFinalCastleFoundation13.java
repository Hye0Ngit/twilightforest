// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import twilightforest.block.TFBlocks;
import net.minecraft.util.Rotation;
import twilightforest.util.RotationUtil;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.block.state.IBlockState;
import java.util.function.Predicate;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFFinalCastleFoundation13 extends StructureTFComponentOld
{
    protected int groundLevel;
    protected static final Predicate<IBlockState> isDeadrock;
    
    public ComponentTFFinalCastleFoundation13() {
        this.groundLevel = -1;
    }
    
    public ComponentTFFinalCastleFoundation13(final TFFeature feature, final Random rand, final int i, final StructureTFComponentOld sideTower) {
        super(feature, i);
        this.groundLevel = -1;
        this.func_186164_a(sideTower.func_186165_e());
        this.field_74887_e = new StructureBoundingBox(sideTower.func_74874_b().field_78897_a - 2, sideTower.func_74874_b().field_78895_b - 1, sideTower.func_74874_b().field_78896_c - 2, sideTower.func_74874_b().field_78893_d + 2, sideTower.func_74874_b().field_78895_b, sideTower.func_74874_b().field_78892_f + 2);
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.groundLevel < 0) {
            this.groundLevel = this.findGroundLevel(world, sbb, 150, ComponentTFFinalCastleFoundation13.isDeadrock);
            if (this.groundLevel < 0) {
                return true;
            }
        }
        final int height = this.field_74887_e.field_78894_e - this.groundLevel;
        final int mid = height / 2;
        final int size = this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a;
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 1, -1, 1, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 2, -1, 1, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 2, -mid, 0, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 1, -1, 2, rotation, sbb);
            this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, 0, -mid, 2, rotation, sbb);
            for (int x = 6; x < size - 3; x += 4) {
                this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, x, -1, 1, rotation, sbb);
                this.replaceAirAndLiquidDownwardsRotated(world, this.deco.blockState, x, -mid, 0, rotation, sbb);
            }
        }
        return true;
    }
    
    static {
        isDeadrock = (state -> state.func_177230_c() == TFBlocks.deadrock);
    }
}
