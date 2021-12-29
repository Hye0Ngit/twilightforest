// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.tags.Tag;
import twilightforest.data.BlockTagGenerator;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.monster.CarminiteGhastling;
import twilightforest.entity.TFEntities;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import twilightforest.util.TFDamageSources;
import net.minecraft.world.level.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.block.CarminiteReactorBlock;
import net.minecraft.world.level.Level;
import java.util.Random;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

public class CarminiteReactorBlockEntity extends BlockEntity
{
    private int counter;
    private int secX;
    private int secY;
    private int secZ;
    private int terX;
    private int terY;
    private int terZ;
    
    public CarminiteReactorBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType)TFBlockEntities.CARMINITE_REACTOR.get(), pos, state);
        this.counter = 0;
        final Random rand = new Random();
        this.secX = 3 * (rand.nextBoolean() ? 1 : -1);
        this.secY = 3 * (rand.nextBoolean() ? 1 : -1);
        this.secZ = 3 * (rand.nextBoolean() ? 1 : -1);
        this.terX = 3 * (rand.nextBoolean() ? 1 : -1);
        this.terY = 3 * (rand.nextBoolean() ? 1 : -1);
        this.terZ = 3 * (rand.nextBoolean() ? 1 : -1);
        if (this.secX == this.terX && this.secY == this.terY && this.secZ == this.terZ) {
            this.terX = -this.terX;
            this.terY = -this.terY;
            this.terZ = -this.terZ;
        }
    }
    
    public static void tick(final Level level, final BlockPos pos, final BlockState state, final CarminiteReactorBlockEntity te) {
        if (state.m_61143_((Property)CarminiteReactorBlock.ACTIVE)) {
            ++te.counter;
            if (!level.f_46443_) {
                final int offset = 10;
                if (te.counter % 5 == 0) {
                    if (te.counter == 5) {
                        final BlockState fakeGold = ((Block)TFBlocks.FAKE_GOLD.get()).m_49966_();
                        final BlockState fakeDiamond = ((Block)TFBlocks.FAKE_DIAMOND.get()).m_49966_();
                        te.createFakeBlock(pos.m_142082_(1, 1, 1), fakeDiamond);
                        te.createFakeBlock(pos.m_142082_(1, 1, -1), fakeDiamond);
                        te.createFakeBlock(pos.m_142082_(-1, 1, 1), fakeDiamond);
                        te.createFakeBlock(pos.m_142082_(-1, 1, -1), fakeDiamond);
                        te.createFakeBlock(pos.m_142082_(0, 1, 0), fakeDiamond);
                        te.createFakeBlock(pos.m_142082_(0, 1, 1), fakeGold);
                        te.createFakeBlock(pos.m_142082_(0, 1, -1), fakeGold);
                        te.createFakeBlock(pos.m_142082_(1, 1, 0), fakeGold);
                        te.createFakeBlock(pos.m_142082_(-1, 1, 0), fakeGold);
                        te.createFakeBlock(pos.m_142082_(1, 0, 1), fakeGold);
                        te.createFakeBlock(pos.m_142082_(1, 0, -1), fakeGold);
                        te.createFakeBlock(pos.m_142082_(-1, 0, 1), fakeGold);
                        te.createFakeBlock(pos.m_142082_(-1, 0, -1), fakeGold);
                        te.createFakeBlock(pos.m_142082_(0, 0, 1), fakeDiamond);
                        te.createFakeBlock(pos.m_142082_(0, 0, -1), fakeDiamond);
                        te.createFakeBlock(pos.m_142082_(1, 0, 0), fakeDiamond);
                        te.createFakeBlock(pos.m_142082_(-1, 0, 0), fakeDiamond);
                        te.createFakeBlock(pos.m_142082_(0, -1, 0), fakeDiamond);
                        te.createFakeBlock(pos.m_142082_(1, -1, 1), fakeDiamond);
                        te.createFakeBlock(pos.m_142082_(1, -1, -1), fakeDiamond);
                        te.createFakeBlock(pos.m_142082_(-1, -1, 1), fakeDiamond);
                        te.createFakeBlock(pos.m_142082_(-1, -1, -1), fakeDiamond);
                        te.createFakeBlock(pos.m_142082_(0, -1, 1), fakeGold);
                        te.createFakeBlock(pos.m_142082_(0, -1, -1), fakeGold);
                        te.createFakeBlock(pos.m_142082_(1, -1, 0), fakeGold);
                        te.createFakeBlock(pos.m_142082_(-1, -1, 0), fakeGold);
                    }
                    final int primary = te.counter - 80;
                    if (primary >= offset && primary <= 249) {
                        te.drawBlob(pos, (primary - offset) / 40, Blocks.f_50016_.m_49966_(), primary - offset, false);
                    }
                    if (primary <= 200) {
                        te.drawBlob(pos, primary / 40, ((Block)TFBlocks.REACTOR_DEBRIS.get()).m_49966_(), te.counter, false);
                    }
                    final int secondary = te.counter - 120;
                    if (secondary >= offset && secondary <= 129) {
                        te.drawBlob(pos.m_142082_(te.secX, te.secY, te.secZ), (secondary - offset) / 40, Blocks.f_50016_.m_49966_(), secondary - offset, false);
                    }
                    if (secondary >= 0 && secondary <= 160) {
                        te.drawBlob(pos.m_142082_(te.secX, te.secY, te.secZ), secondary / 40, Blocks.f_50016_.m_49966_(), secondary, true);
                    }
                    final int tertiary = te.counter - 160;
                    if (tertiary >= offset && tertiary <= 129) {
                        te.drawBlob(pos.m_142082_(te.terX, te.terY, te.terZ), (tertiary - offset) / 40, Blocks.f_50016_.m_49966_(), tertiary - offset, false);
                    }
                    if (tertiary >= 0 && tertiary <= 160) {
                        te.drawBlob(pos.m_142082_(te.terX, te.terY, te.terZ), tertiary / 40, Blocks.f_50016_.m_49966_(), tertiary, true);
                    }
                }
                if (te.counter >= 350) {
                    level.m_7703_((Entity)null, TFDamageSources.REACTOR, (ExplosionDamageCalculator)null, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), 4.0f, true, Explosion.BlockInteraction.BREAK);
                    level.m_7471_(pos, false);
                    for (int i = 0; i < 3; ++i) {
                        te.spawnGhastNear(pos.m_123341_() + te.secX, pos.m_123342_() + te.secY, pos.m_123343_() + te.secZ);
                        te.spawnGhastNear(pos.m_123341_() + te.terX, pos.m_123342_() + te.terY, pos.m_123343_() + te.terZ);
                    }
                }
            }
            else if (te.counter % 5 == 0 && te.counter <= 250) {
                level.m_7785_(pos.m_123341_() + 0.5, pos.m_123342_() + 0.5, pos.m_123343_() + 0.5, TFSounds.REACTOR_AMBIENT, SoundSource.BLOCKS, te.counter / 100.0f, te.counter / 100.0f, false);
            }
        }
    }
    
    private void spawnGhastNear(final int x, final int y, final int z) {
        final CarminiteGhastling ghast = new CarminiteGhastling(TFEntities.CARMINITE_GHASTLING, this.f_58857_);
        ghast.m_7678_(x - 1.5 + this.f_58857_.f_46441_.nextFloat() * 3.0, y - 1.5 + this.f_58857_.f_46441_.nextFloat() * 3.0, z - 1.5 + this.f_58857_.f_46441_.nextFloat() * 3.0, this.f_58857_.f_46441_.nextFloat() * 360.0f, 0.0f);
        ghast.m_7292_(new MobEffectInstance(MobEffects.f_19607_, 200));
        this.f_58857_.m_7967_((Entity)ghast);
    }
    
    private void drawBlob(final BlockPos pos, final int rad, final BlockState state, final int fuzz, final boolean netherTransform) {
        for (byte dx = 0; dx <= rad; ++dx) {
            final int fuzzX = (fuzz + dx) % 8;
            for (byte dy = 0; dy <= rad; ++dy) {
                final int fuzzY = (fuzz + dy) % 8;
                for (byte dz = 0; dz <= rad; ++dz) {
                    byte dist;
                    if (dx >= dy && dx >= dz) {
                        dist = (byte)(dx + (byte)(Math.max(dy, dz) * 0.5 + Math.min(dy, dz) * 0.25));
                    }
                    else if (dy >= dx && dy >= dz) {
                        dist = (byte)(dy + (byte)(Math.max(dx, dz) * 0.5 + Math.min(dx, dz) * 0.25));
                    }
                    else {
                        dist = (byte)(dz + (byte)(Math.max(dx, dy) * 0.5 + Math.min(dx, dy) * 0.25));
                    }
                    if (dist == rad && (dx != 0 || dy != 0 || dz != 0)) {
                        switch (fuzzX) {
                            case 0: {
                                this.transformBlock(pos.m_142082_((int)dx, (int)dy, (int)dz), state, fuzzY, netherTransform);
                                break;
                            }
                            case 1: {
                                this.transformBlock(pos.m_142082_((int)dx, (int)dy, -dz), state, fuzzY, netherTransform);
                                break;
                            }
                            case 2: {
                                this.transformBlock(pos.m_142082_(-dx, (int)dy, (int)dz), state, fuzzY, netherTransform);
                                break;
                            }
                            case 3: {
                                this.transformBlock(pos.m_142082_(-dx, (int)dy, -dz), state, fuzzY, netherTransform);
                                break;
                            }
                            case 4: {
                                this.transformBlock(pos.m_142082_((int)dx, -dy, (int)dz), state, fuzzY, netherTransform);
                                break;
                            }
                            case 5: {
                                this.transformBlock(pos.m_142082_((int)dx, -dy, -dz), state, fuzzY, netherTransform);
                                break;
                            }
                            case 6: {
                                this.transformBlock(pos.m_142082_(-dx, -dy, (int)dz), state, fuzzY, netherTransform);
                                break;
                            }
                            case 7: {
                                this.transformBlock(pos.m_142082_(-dx, -dy, -dz), state, fuzzY, netherTransform);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void transformBlock(final BlockPos pos, final BlockState state, final int fuzz, final boolean netherTransform) {
        final BlockState stateThere = this.f_58857_.m_8055_(pos);
        if (stateThere.m_60734_() != Blocks.f_50016_ && (stateThere.m_60620_((Tag)BlockTagGenerator.CARMINITE_REACTOR_IMMUNE) || stateThere.m_60800_((BlockGetter)this.f_58857_, pos) == -1.0f)) {
            return;
        }
        if (fuzz == 0 && stateThere.m_60734_() != Blocks.f_50016_) {
            this.f_58857_.m_46796_(2001, pos, Block.m_49956_(stateThere));
        }
        if (netherTransform && stateThere.m_60734_() != Blocks.f_50016_) {
            this.f_58857_.m_7731_(pos, (this.f_58857_.f_46441_.nextInt(8) == 0) ? ((Block)BlockTagGenerator.CARMINITE_REACTOR_ORES.m_13288_(this.f_58857_.f_46441_)).m_49966_() : Blocks.f_50134_.m_49966_(), 3);
            if (this.f_58857_.m_46859_(pos.m_7494_()) && fuzz % 3 == 0) {
                this.f_58857_.m_7731_(pos.m_7494_(), Blocks.f_50083_.m_49966_(), 3);
            }
        }
        else {
            this.f_58857_.m_7731_(pos, state, 3);
        }
    }
    
    private void createFakeBlock(final BlockPos pos, final BlockState state) {
        final BlockState stateThere = this.f_58857_.m_8055_(pos);
        if (stateThere.m_60734_() != Blocks.f_50016_ && !stateThere.m_60620_((Tag)BlockTagGenerator.CARMINITE_REACTOR_IMMUNE) && stateThere.m_60800_((BlockGetter)this.f_58857_, pos) != -1.0f) {
            this.f_58857_.m_7731_(pos, state, 2);
        }
    }
}
