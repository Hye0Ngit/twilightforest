// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFFireJet;
import twilightforest.block.TFBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.enums.FireJetVariant;

public class TFGenFireJet extends TFGenerator
{
    private final FireJetVariant variant;
    
    public TFGenFireJet(final FireJetVariant variant) {
        this.variant = variant;
    }
    
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        for (int i = 0; i < 4; ++i) {
            final BlockPos dPos = pos.func_177982_a(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            if (world.func_175623_d(dPos) && world.func_175678_i(dPos) && world.func_180495_p(dPos.func_177977_b()).func_185904_a() == Material.field_151577_b && world.func_180495_p(dPos.func_177974_f().func_177977_b()).func_185904_a() == Material.field_151577_b && world.func_180495_p(dPos.func_177976_e().func_177977_b()).func_185904_a() == Material.field_151577_b && world.func_180495_p(dPos.func_177968_d().func_177977_b()).func_185904_a() == Material.field_151577_b && world.func_180495_p(dPos.func_177978_c().func_177977_b()).func_185904_a() == Material.field_151577_b) {
                world.func_180501_a(dPos.func_177977_b(), TFBlocks.fire_jet.func_176223_P().func_177226_a((IProperty)BlockTFFireJet.VARIANT, (Comparable)this.variant), 0);
                for (int rx = -2; rx <= 2; ++rx) {
                    for (int rz = -2; rz <= 2; ++rz) {
                        final BlockPos dPos2 = dPos.func_177982_a(rx, -2, rz);
                        if ((rx == 1 || rx == 0 || rx == -1) && (rz == 1 || rz == 0 || rz == -1)) {
                            world.func_180501_a(dPos2, Blocks.field_150356_k.func_176223_P(), 0);
                        }
                        else if (world.func_180495_p(dPos2).func_185904_a() != Material.field_151587_i) {
                            world.func_180501_a(dPos2, Blocks.field_150348_b.func_176223_P(), 0);
                        }
                        world.func_180501_a(dPos2.func_177977_b(), Blocks.field_150348_b.func_176223_P(), 0);
                    }
                }
            }
        }
        return true;
    }
}
