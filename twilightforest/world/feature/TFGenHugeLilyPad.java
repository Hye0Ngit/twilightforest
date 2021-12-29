// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.block.material.Material;
import twilightforest.enums.HugeLilypadPiece;
import net.minecraft.state.Property;
import twilightforest.block.TFBlocks;
import twilightforest.block.HugeLilyPadBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenHugeLilyPad extends Feature<NoFeatureConfig>
{
    public TFGenHugeLilyPad(final Codec<NoFeatureConfig> config) {
        super((Codec)config);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random random, final BlockPos pos, final NoFeatureConfig config) {
        for (int i = 0; i < 10; ++i) {
            final BlockPos dPos = pos.func_177982_a(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            if (this.shouldPlacePadAt((IWorld)world, dPos) && world.isAreaLoaded(dPos, 1)) {
                final Direction horizontal = Direction.func_176731_b(random.nextInt(4));
                final BlockState lilypad = (BlockState)((HugeLilyPadBlock)TFBlocks.huge_lilypad.get()).func_176223_P().func_206870_a((Property)HugeLilyPadBlock.FACING, (Comparable)horizontal);
                world.func_180501_a(dPos, (BlockState)lilypad.func_206870_a((Property)HugeLilyPadBlock.PIECE, (Comparable)HugeLilypadPiece.NW), 18);
                world.func_180501_a(dPos.func_177974_f(), (BlockState)lilypad.func_206870_a((Property)HugeLilyPadBlock.PIECE, (Comparable)HugeLilypadPiece.NE), 18);
                world.func_180501_a(dPos.func_177974_f().func_177968_d(), (BlockState)lilypad.func_206870_a((Property)HugeLilyPadBlock.PIECE, (Comparable)HugeLilypadPiece.SE), 18);
                world.func_180501_a(dPos.func_177968_d(), (BlockState)lilypad.func_206870_a((Property)HugeLilyPadBlock.PIECE, (Comparable)HugeLilypadPiece.SW), 18);
            }
        }
        return true;
    }
    
    private boolean shouldPlacePadAt(final IWorld world, final BlockPos pos) {
        return world.func_175623_d(pos) && world.func_180495_p(pos.func_177977_b()).func_185904_a() == Material.field_151586_h && world.func_175623_d(pos.func_177974_f()) && world.func_180495_p(pos.func_177974_f().func_177977_b()).func_185904_a() == Material.field_151586_h && world.func_175623_d(pos.func_177968_d()) && world.func_180495_p(pos.func_177968_d().func_177977_b()).func_185904_a() == Material.field_151586_h && world.func_175623_d(pos.func_177974_f().func_177968_d()) && world.func_180495_p(pos.func_177974_f().func_177968_d().func_177977_b()).func_185904_a() == Material.field_151586_h;
    }
}
