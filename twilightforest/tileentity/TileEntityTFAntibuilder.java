// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import com.google.common.collect.ImmutableSet;
import twilightforest.TFConfig;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.TowerTranslucentVariant;
import twilightforest.block.BlockTFTowerTranslucent;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.state.IBlockState;
import java.util.Random;
import net.minecraft.util.ITickable;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFAntibuilder extends TileEntity implements ITickable
{
    private static final int REVERT_CHANCE = 10;
    private final int radius = 4;
    private final int diameter = 9;
    private final double requiredPlayerRange = 16.0;
    private final Random rand;
    private int tickCount;
    private boolean slowScan;
    private int ticksSinceChange;
    private IBlockState[] blockData;
    
    public TileEntityTFAntibuilder() {
        this.rand = new Random();
    }
    
    public void func_73660_a() {
        if (this.anyPlayerInRange()) {
            ++this.tickCount;
            if (this.field_145850_b.field_72995_K) {
                final double x = this.field_174879_c.func_177958_n() + this.field_145850_b.field_73012_v.nextFloat();
                final double y = this.field_174879_c.func_177956_o() + this.field_145850_b.field_73012_v.nextFloat();
                final double z = this.field_174879_c.func_177952_p() + this.field_145850_b.field_73012_v.nextFloat();
                this.field_145850_b.func_175688_a(EnumParticleTypes.REDSTONE, x, y, z, 0.0, 0.0, 0.0, new int[0]);
                if (this.rand.nextInt(10) == 0) {
                    this.makeRandomOutline();
                    this.makeRandomOutline();
                    this.makeRandomOutline();
                }
            }
            else {
                if (this.blockData == null) {
                    final World field_145850_b = this.field_145850_b;
                    final BlockPos field_174879_c = this.field_174879_c;
                    this.getClass();
                    if (field_145850_b.func_175697_a(field_174879_c, 4)) {
                        this.captureBlockData();
                        this.slowScan = true;
                    }
                }
                if (this.blockData != null && (!this.slowScan || this.tickCount % 20 == 0)) {
                    if (this.scanAndRevertChanges()) {
                        this.slowScan = false;
                        this.ticksSinceChange = 0;
                    }
                    else {
                        ++this.ticksSinceChange;
                        if (this.ticksSinceChange > 20) {
                            this.slowScan = true;
                        }
                    }
                }
            }
        }
        else {
            this.blockData = null;
            this.tickCount = 0;
        }
    }
    
    private void makeRandomOutline() {
        this.makeOutline(this.rand.nextInt(12));
    }
    
    private void makeOutline(final int outline) {
        double sx = this.field_174879_c.func_177958_n();
        double sy = this.field_174879_c.func_177956_o();
        double sz = this.field_174879_c.func_177952_p();
        double dx = this.field_174879_c.func_177958_n();
        double dy = this.field_174879_c.func_177956_o();
        double dz = this.field_174879_c.func_177952_p();
        switch (outline) {
            case 0:
            case 8: {
                sx -= 4.0;
                dx += 5.0;
                sz -= 4.0;
                dz -= 4.0;
                break;
            }
            case 1:
            case 9: {
                sx -= 4.0;
                dx -= 4.0;
                sz -= 4.0;
                dz += 5.0;
                break;
            }
            case 2:
            case 10: {
                sx -= 4.0;
                dx += 5.0;
                sz += 5.0;
                dz += 5.0;
                break;
            }
            case 3:
            case 11: {
                sx += 5.0;
                dx += 5.0;
                sz -= 4.0;
                dz += 5.0;
                break;
            }
            case 4: {
                sx -= 4.0;
                dx -= 4.0;
                sz -= 4.0;
                dz -= 4.0;
                break;
            }
            case 5: {
                sx += 5.0;
                dx += 5.0;
                sz -= 4.0;
                dz -= 4.0;
                break;
            }
            case 6: {
                sx += 5.0;
                dx += 5.0;
                sz += 5.0;
                dz += 5.0;
                break;
            }
            case 7: {
                sx -= 4.0;
                dx -= 4.0;
                sz += 5.0;
                dz += 5.0;
                break;
            }
        }
        switch (outline) {
            case 0:
            case 1:
            case 2:
            case 3: {
                sy += 5.0;
                dy += 5.0;
                break;
            }
            case 4:
            case 5:
            case 6:
            case 7: {
                sy -= 4.0;
                dy += 5.0;
                break;
            }
            case 8:
            case 9:
            case 10:
            case 11: {
                sy -= 4.0;
                dy -= 4.0;
                break;
            }
        }
        if (this.rand.nextBoolean()) {
            this.drawParticleLine(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.5, this.field_174879_c.func_177952_p() + 0.5, dx, dy, dz);
        }
        else {
            this.drawParticleLine(sx, sy, sz, this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.5, this.field_174879_c.func_177952_p() + 0.5);
        }
        this.drawParticleLine(sx, sy, sz, dx, dy, dz);
    }
    
    private void drawParticleLine(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 16, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final double tx = srcX + (destX - srcX) * trailFactor + this.rand.nextFloat() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.rand.nextFloat() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.rand.nextFloat() * 0.005;
            this.field_145850_b.func_175688_a(EnumParticleTypes.REDSTONE, tx, ty, tz, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    private boolean scanAndRevertChanges() {
        int index = 0;
        boolean reverted = false;
        for (int x = -4; x <= 4; ++x) {
            for (int y = -4; y <= 4; ++y) {
                for (int z = -4; z <= 4; ++z) {
                    final IBlockState stateThere = this.field_145850_b.func_180495_p(this.field_174879_c.func_177982_a(x, y, z));
                    if (this.blockData[index].func_177230_c() != stateThere.func_177230_c()) {
                        if (this.revertBlock(this.field_174879_c.func_177982_a(x, y, z), stateThere, this.blockData[index])) {
                            reverted = true;
                        }
                        else {
                            this.blockData[index] = stateThere;
                        }
                    }
                    ++index;
                }
            }
        }
        return reverted;
    }
    
    private boolean revertBlock(final BlockPos pos, final IBlockState stateThere, IBlockState replaceWith) {
        if (stateThere.func_177230_c() == Blocks.field_150350_a && !replaceWith.func_185904_a().func_76230_c()) {
            return false;
        }
        if (stateThere.func_185887_b(this.field_145850_b, pos) < 0.0f || this.isUnrevertable(stateThere, replaceWith)) {
            return false;
        }
        if (this.rand.nextInt(10) == 0) {
            if (replaceWith.func_177230_c() != Blocks.field_150350_a) {
                replaceWith = TFBlocks.tower_translucent.func_176223_P().func_177226_a((IProperty)BlockTFTowerTranslucent.VARIANT, (Comparable)TowerTranslucentVariant.REVERTER_REPLACEMENT);
            }
            this.field_145850_b.func_180501_a(pos, replaceWith, 2);
            if (stateThere.func_177230_c() == Blocks.field_150350_a) {
                this.field_145850_b.func_175718_b(2001, pos, Block.func_176210_f(replaceWith));
            }
            else if (replaceWith.func_177230_c() == Blocks.field_150350_a) {
                this.field_145850_b.func_175718_b(2001, pos, Block.func_176210_f(stateThere));
                stateThere.func_177230_c().func_176226_b(this.field_145850_b, pos, stateThere, 0);
            }
        }
        return true;
    }
    
    private boolean isUnrevertable(final IBlockState stateThere, final IBlockState replaceWith) {
        if (stateThere.func_177230_c() == TFBlocks.tower_device || replaceWith.func_177230_c() == TFBlocks.tower_device) {
            return true;
        }
        if ((stateThere.func_177230_c() == TFBlocks.tower_translucent && stateThere.func_177229_b((IProperty)BlockTFTowerTranslucent.VARIANT) != TowerTranslucentVariant.REVERTER_REPLACEMENT) || (replaceWith.func_177230_c() == TFBlocks.tower_translucent && replaceWith.func_177229_b((IProperty)BlockTFTowerTranslucent.VARIANT) != TowerTranslucentVariant.REVERTER_REPLACEMENT)) {
            return true;
        }
        if (stateThere.func_177230_c() == Blocks.field_150379_bu && replaceWith.func_177230_c() == Blocks.field_150374_bv) {
            return true;
        }
        if (stateThere.func_177230_c() == Blocks.field_150374_bv && replaceWith.func_177230_c() == Blocks.field_150379_bu) {
            return true;
        }
        if (stateThere.func_177230_c() == Blocks.field_150355_j || replaceWith.func_177230_c() == Blocks.field_150358_i) {
            return true;
        }
        if (stateThere.func_177230_c() == Blocks.field_150358_i || replaceWith.func_177230_c() == Blocks.field_150355_j) {
            return true;
        }
        if (replaceWith.func_177230_c() == Blocks.field_150335_W) {
            return true;
        }
        final ImmutableSet<IBlockState> blacklist = TFConfig.getDisallowedBlocks();
        return blacklist.contains((Object)stateThere) || blacklist.contains((Object)replaceWith);
    }
    
    private void captureBlockData() {
        this.blockData = new IBlockState[729];
        int index = 0;
        for (int x = -4; x <= 4; ++x) {
            for (int y = -4; y <= 4; ++y) {
                for (int z = -4; z <= 4; ++z) {
                    this.blockData[index] = this.field_145850_b.func_180495_p(this.field_174879_c.func_177982_a(x, y, z));
                    ++index;
                }
            }
        }
    }
    
    private boolean anyPlayerInRange() {
        final World field_145850_b = this.field_145850_b;
        final double n = this.field_174879_c.func_177958_n() + 0.5;
        final double n2 = this.field_174879_c.func_177956_o() + 0.5;
        final double n3 = this.field_174879_c.func_177952_p() + 0.5;
        this.getClass();
        return field_145850_b.func_175636_b(n, n2, n3, 16.0);
    }
}
