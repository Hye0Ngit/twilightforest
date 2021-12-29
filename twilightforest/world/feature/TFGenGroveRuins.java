// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;

public class TFGenGroveRuins extends TFGenerator
{
    private static final IBlockState MOSSY_STONEBRICK;
    private static final IBlockState CHISELED_STONEBRICK;
    
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        if (rand.nextBoolean()) {
            return this.generateLargeArch(world, rand, pos);
        }
        return this.generateSmallArch(world, rand, pos);
    }
    
    private boolean generateLargeArch(final World world, final Random rand, final BlockPos pos) {
        if (!TFGenerator.isAreaSuitable(world, rand, pos, 2, 7, 6)) {
            return false;
        }
        for (int dy = -2; dy <= 7; ++dy) {
            this.func_175903_a(world, pos.func_177982_a(0, dy, 1), TFGenGroveRuins.MOSSY_STONEBRICK);
            this.func_175903_a(world, pos.func_177982_a(1, dy, 1), TFGenGroveRuins.MOSSY_STONEBRICK);
            this.func_175903_a(world, pos.func_177982_a(0, dy, 2), TFGenGroveRuins.MOSSY_STONEBRICK);
            this.func_175903_a(world, pos.func_177982_a(1, dy, 2), TFGenGroveRuins.MOSSY_STONEBRICK);
        }
        this.func_175903_a(world, pos.func_177982_a(0, -1, 3), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(1, -1, 3), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(0, -2, 3), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(1, -2, 3), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(0, -1, 4), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(1, -1, 4), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(0, -2, 4), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(1, -2, 4), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(0, -1, 5), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(1, -2, 5), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(0, 6, 3), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(1, 6, 3), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(0, 7, 3), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(1, 7, 3), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(0, 6, 4), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(1, 6, 4), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(0, 7, 4), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(1, 7, 4), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(1, 7, 5), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(0, 5, 0), TFGenGroveRuins.CHISELED_STONEBRICK);
        return true;
    }
    
    private boolean generateSmallArch(final World world, final Random rand, final BlockPos pos) {
        if (!TFGenerator.isAreaSuitable(world, rand, pos, 7, 5, 9)) {
            return false;
        }
        this.func_175903_a(world, pos.func_177982_a(0, 4, 0), TFGenGroveRuins.CHISELED_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(0, 3, 0), TFGenGroveRuins.CHISELED_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(1, 4, 0), TFGenGroveRuins.CHISELED_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(2, 4, 0), TFGenGroveRuins.CHISELED_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(0, 4, 1), TFGenGroveRuins.CHISELED_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(0, 4, 2), TFGenGroveRuins.CHISELED_STONEBRICK);
        for (int dy = -1; dy <= 5; ++dy) {
            this.func_175903_a(world, pos.func_177982_a(3, dy, 0), TFGenGroveRuins.MOSSY_STONEBRICK);
        }
        this.func_175903_a(world, pos.func_177982_a(4, -1, 0), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(5, -1, 0), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(6, -1, 0), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(4, 5, 0), TFGenGroveRuins.MOSSY_STONEBRICK);
        this.func_175903_a(world, pos.func_177982_a(5, 5, 0), TFGenGroveRuins.MOSSY_STONEBRICK);
        for (int dy = -1; dy <= 5; ++dy) {
            this.func_175903_a(world, pos.func_177982_a(0, dy, 3), TFGenGroveRuins.MOSSY_STONEBRICK);
            this.func_175903_a(world, pos.func_177982_a(0, dy, 7), TFGenGroveRuins.MOSSY_STONEBRICK);
        }
        for (int dz = 4; dz < 7; ++dz) {
            this.func_175903_a(world, pos.func_177982_a(0, -1, dz), TFGenGroveRuins.MOSSY_STONEBRICK);
            this.func_175903_a(world, pos.func_177982_a(0, 5, dz), TFGenGroveRuins.MOSSY_STONEBRICK);
        }
        this.func_175903_a(world, pos.func_177982_a(0, 4, 8), TFGenGroveRuins.CHISELED_STONEBRICK);
        return true;
    }
    
    static {
        MOSSY_STONEBRICK = Blocks.field_150417_aV.func_176223_P().func_177226_a((IProperty)BlockStoneBrick.field_176249_a, (Comparable)BlockStoneBrick.EnumType.MOSSY);
        CHISELED_STONEBRICK = Blocks.field_150417_aV.func_176223_P().func_177226_a((IProperty)BlockStoneBrick.field_176249_a, (Comparable)BlockStoneBrick.EnumType.CHISELED);
    }
}
