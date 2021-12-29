// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import twilightforest.data.BlockTagGenerator;
import net.minecraft.world.level.LevelAccessor;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import java.util.Random;
import net.minecraft.world.level.block.entity.BlockEntity;

public class AntibuilderBlockEntity extends BlockEntity
{
    private static final int REVERT_CHANCE = 10;
    private static final int RADIUS = 4;
    private static final int DIAMETER = 9;
    private static final double PLAYER_RANGE = 16.0;
    private final Random rand;
    private int tickCount;
    private boolean slowScan;
    private int ticksSinceChange;
    private BlockState[] blockData;
    
    public AntibuilderBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType)TFBlockEntities.ANTIBUILDER.get(), pos, state);
        this.rand = new Random();
    }
    
    public static void tick(final Level level, final BlockPos pos, final BlockState state, final AntibuilderBlockEntity te) {
        if (te.anyPlayerInRange()) {
            ++te.tickCount;
            if (level.f_46443_) {
                final double x = pos.m_123341_() + level.f_46441_.nextFloat();
                final double y = pos.m_123342_() + level.f_46441_.nextFloat();
                final double z = pos.m_123343_() + level.f_46441_.nextFloat();
                level.m_7106_((ParticleOptions)DustParticleOptions.f_123656_, x, y, z, 0.0, 0.0, 0.0);
                if (te.rand.nextInt(10) == 0) {
                    te.makeRandomOutline();
                    te.makeRandomOutline();
                    te.makeRandomOutline();
                }
            }
            else {
                if (te.blockData == null && level.isAreaLoaded(pos, 4)) {
                    te.captureBlockData();
                    te.slowScan = true;
                }
                if (te.blockData != null && (!te.slowScan || te.tickCount % 20 == 0)) {
                    if (te.scanAndRevertChanges()) {
                        te.slowScan = false;
                        te.ticksSinceChange = 0;
                    }
                    else {
                        ++te.ticksSinceChange;
                        if (te.ticksSinceChange > 20) {
                            te.slowScan = true;
                        }
                    }
                }
            }
        }
        else {
            te.blockData = null;
            te.tickCount = 0;
        }
    }
    
    private void makeRandomOutline() {
        this.makeOutline(this.rand.nextInt(12));
    }
    
    private void makeOutline(final int outline) {
        double sx = this.f_58858_.m_123341_();
        double sy = this.f_58858_.m_123342_();
        double sz = this.f_58858_.m_123343_();
        double dx = this.f_58858_.m_123341_();
        double dy = this.f_58858_.m_123342_();
        double dz = this.f_58858_.m_123343_();
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
            this.drawParticleLine(this.f_58858_.m_123341_() + 0.5, this.f_58858_.m_123342_() + 0.5, this.f_58858_.m_123343_() + 0.5, dx, dy, dz);
        }
        else {
            this.drawParticleLine(sx, sy, sz, this.f_58858_.m_123341_() + 0.5, this.f_58858_.m_123342_() + 0.5, this.f_58858_.m_123343_() + 0.5);
        }
        this.drawParticleLine(sx, sy, sz, dx, dy, dz);
    }
    
    private void drawParticleLine(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 16, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final double tx = srcX + (destX - srcX) * trailFactor + this.rand.nextFloat() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.rand.nextFloat() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.rand.nextFloat() * 0.005;
            this.f_58857_.m_7106_((ParticleOptions)DustParticleOptions.f_123656_, tx, ty, tz, 0.0, 0.0, 0.0);
        }
    }
    
    private boolean scanAndRevertChanges() {
        int index = 0;
        boolean reverted = false;
        for (int x = -4; x <= 4; ++x) {
            for (int y = -4; y <= 4; ++y) {
                for (int z = -4; z <= 4; ++z) {
                    final BlockState stateThere = this.f_58857_.m_8055_(this.f_58858_.m_142082_(x, y, z));
                    if (this.blockData[index].m_60734_() != stateThere.m_60734_()) {
                        if (this.revertBlock(this.f_58858_.m_142082_(x, y, z), stateThere, this.blockData[index])) {
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
    
    private boolean revertBlock(final BlockPos pos, final BlockState stateThere, BlockState replaceWith) {
        if (stateThere.m_60795_() && !replaceWith.m_60767_().m_76334_()) {
            return false;
        }
        if (stateThere.m_60800_((BlockGetter)this.f_58857_, pos) < 0.0f || this.isUnrevertable(stateThere, replaceWith)) {
            return false;
        }
        if (this.rand.nextInt(10) == 0) {
            if (!replaceWith.m_60795_()) {
                replaceWith = ((Block)TFBlocks.ANTIBUILT_BLOCK.get()).m_49966_();
            }
            if (stateThere.m_60795_()) {
                this.f_58857_.m_46796_(2001, pos, Block.m_49956_(replaceWith));
            }
            Block.m_49902_(stateThere, replaceWith, (LevelAccessor)this.f_58857_, pos, 2);
        }
        return true;
    }
    
    private boolean isUnrevertable(final BlockState stateThere, final BlockState replaceWith) {
        return BlockTagGenerator.ANTIBUILDER_IGNORES.m_8110_((Object)stateThere.m_60734_()) || BlockTagGenerator.ANTIBUILDER_IGNORES.m_8110_((Object)replaceWith.m_60734_());
    }
    
    private void captureBlockData() {
        this.blockData = new BlockState[729];
        int index = 0;
        for (int x = -4; x <= 4; ++x) {
            for (int y = -4; y <= 4; ++y) {
                for (int z = -4; z <= 4; ++z) {
                    this.blockData[index] = this.f_58857_.m_8055_(this.f_58858_.m_142082_(x, y, z));
                    ++index;
                }
            }
        }
    }
    
    private boolean anyPlayerInRange() {
        return this.f_58857_.m_45914_(this.f_58858_.m_123341_() + 0.5, this.f_58858_.m_123342_() + 0.5, this.f_58858_.m_123343_() + 0.5, 16.0);
    }
}
