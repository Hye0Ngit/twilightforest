// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.world.IBlockReader;
import net.minecraft.tags.ITag;
import twilightforest.data.BlockTagGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityType;
import twilightforest.entity.CarminiteGhastlingEntity;
import twilightforest.entity.TFEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import net.minecraft.entity.Entity;
import net.minecraft.world.Explosion;
import net.minecraft.world.ExplosionContext;
import twilightforest.util.TFDamageSources;
import net.minecraft.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class ActiveCarminiteReactorTileEntity extends TileEntity implements ITickableTileEntity
{
    private int counter;
    private int secX;
    private int secY;
    private int secZ;
    private int terX;
    private int terY;
    private int terZ;
    
    public ActiveCarminiteReactorTileEntity() {
        super((TileEntityType)TFTileEntities.CARMINITE_REACTOR.get());
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
    
    public void func_73660_a() {
        ++this.counter;
        if (!this.field_145850_b.field_72995_K) {
            final int offset = 10;
            if (this.counter % 5 == 0) {
                if (this.counter == 5) {
                    final BlockState fakeGold = ((Block)TFBlocks.fake_gold.get()).func_176223_P();
                    final BlockState fakeDiamond = ((Block)TFBlocks.fake_diamond.get()).func_176223_P();
                    this.createFakeBlock(this.field_174879_c.func_177982_a(1, 1, 1), fakeDiamond);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(1, 1, -1), fakeDiamond);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(-1, 1, 1), fakeDiamond);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(-1, 1, -1), fakeDiamond);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(0, 1, 0), fakeDiamond);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(0, 1, 1), fakeGold);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(0, 1, -1), fakeGold);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(1, 1, 0), fakeGold);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(-1, 1, 0), fakeGold);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(1, 0, 1), fakeGold);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(1, 0, -1), fakeGold);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(-1, 0, 1), fakeGold);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(-1, 0, -1), fakeGold);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(0, 0, 1), fakeDiamond);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(0, 0, -1), fakeDiamond);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(1, 0, 0), fakeDiamond);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(-1, 0, 0), fakeDiamond);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(0, -1, 0), fakeDiamond);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(1, -1, 1), fakeDiamond);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(1, -1, -1), fakeDiamond);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(-1, -1, 1), fakeDiamond);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(-1, -1, -1), fakeDiamond);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(0, -1, 1), fakeGold);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(0, -1, -1), fakeGold);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(1, -1, 0), fakeGold);
                    this.createFakeBlock(this.field_174879_c.func_177982_a(-1, -1, 0), fakeGold);
                }
                final int primary = this.counter - 80;
                if (primary >= offset && primary <= 249) {
                    this.drawBlob(this.field_174879_c, (primary - offset) / 40, Blocks.field_150350_a.func_176223_P(), primary - offset, false);
                }
                if (primary <= 200) {
                    this.drawBlob(this.field_174879_c, primary / 40, ((Block)TFBlocks.reactor_debris.get()).func_176223_P(), this.counter, false);
                }
                final int secondary = this.counter - 120;
                if (secondary >= offset && secondary <= 129) {
                    this.drawBlob(this.field_174879_c.func_177982_a(this.secX, this.secY, this.secZ), (secondary - offset) / 40, Blocks.field_150350_a.func_176223_P(), secondary - offset, false);
                }
                if (secondary >= 0 && secondary <= 160) {
                    this.drawBlob(this.field_174879_c.func_177982_a(this.secX, this.secY, this.secZ), secondary / 40, Blocks.field_150350_a.func_176223_P(), secondary, true);
                }
                final int tertiary = this.counter - 160;
                if (tertiary >= offset && tertiary <= 129) {
                    this.drawBlob(this.field_174879_c.func_177982_a(this.terX, this.terY, this.terZ), (tertiary - offset) / 40, Blocks.field_150350_a.func_176223_P(), tertiary - offset, false);
                }
                if (tertiary >= 0 && tertiary <= 160) {
                    this.drawBlob(this.field_174879_c.func_177982_a(this.terX, this.terY, this.terZ), tertiary / 40, Blocks.field_150350_a.func_176223_P(), tertiary, true);
                }
            }
            if (this.counter >= 350) {
                for (int i = 0; i < 3; ++i) {
                    this.spawnGhastNear(this.field_174879_c.func_177958_n() + this.secX, this.field_174879_c.func_177956_o() + this.secY, this.field_174879_c.func_177952_p() + this.secZ);
                    this.spawnGhastNear(this.field_174879_c.func_177958_n() + this.terX, this.field_174879_c.func_177956_o() + this.terY, this.field_174879_c.func_177952_p() + this.terZ);
                }
                this.field_145850_b.func_230546_a_((Entity)null, TFDamageSources.REACTOR, (ExplosionContext)null, (double)this.field_174879_c.func_177958_n(), (double)this.field_174879_c.func_177956_o(), (double)this.field_174879_c.func_177952_p(), 2.0f, true, Explosion.Mode.BREAK);
                this.field_145850_b.func_217377_a(this.field_174879_c, false);
            }
        }
        else if (this.counter % 5 == 0 && this.counter <= 250) {
            this.field_145850_b.func_184134_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.5, this.field_174879_c.func_177952_p() + 0.5, TFSounds.REACTOR_AMBIENT, SoundCategory.BLOCKS, this.counter / 100.0f, this.counter / 100.0f, false);
        }
    }
    
    private void spawnGhastNear(final int x, final int y, final int z) {
        final CarminiteGhastlingEntity ghast = new CarminiteGhastlingEntity(TFEntities.mini_ghast, this.field_145850_b);
        ghast.func_70012_b(x - 1.5 + this.field_145850_b.field_73012_v.nextFloat() * 3.0, y - 1.5 + this.field_145850_b.field_73012_v.nextFloat() * 3.0, z - 1.5 + this.field_145850_b.field_73012_v.nextFloat() * 3.0, this.field_145850_b.field_73012_v.nextFloat() * 360.0f, 0.0f);
        this.field_145850_b.func_217376_c((Entity)ghast);
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
                                this.transformBlock(pos.func_177982_a((int)dx, (int)dy, (int)dz), state, fuzzY, netherTransform);
                                break;
                            }
                            case 1: {
                                this.transformBlock(pos.func_177982_a((int)dx, (int)dy, -dz), state, fuzzY, netherTransform);
                                break;
                            }
                            case 2: {
                                this.transformBlock(pos.func_177982_a(-dx, (int)dy, (int)dz), state, fuzzY, netherTransform);
                                break;
                            }
                            case 3: {
                                this.transformBlock(pos.func_177982_a(-dx, (int)dy, -dz), state, fuzzY, netherTransform);
                                break;
                            }
                            case 4: {
                                this.transformBlock(pos.func_177982_a((int)dx, -dy, (int)dz), state, fuzzY, netherTransform);
                                break;
                            }
                            case 5: {
                                this.transformBlock(pos.func_177982_a((int)dx, -dy, -dz), state, fuzzY, netherTransform);
                                break;
                            }
                            case 6: {
                                this.transformBlock(pos.func_177982_a(-dx, -dy, (int)dz), state, fuzzY, netherTransform);
                                break;
                            }
                            case 7: {
                                this.transformBlock(pos.func_177982_a(-dx, -dy, -dz), state, fuzzY, netherTransform);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void transformBlock(final BlockPos pos, final BlockState state, final int fuzz, final boolean netherTransform) {
        final BlockState stateThere = this.field_145850_b.func_180495_p(pos);
        if (stateThere.func_177230_c() != Blocks.field_150350_a && (stateThere.func_177230_c().func_203417_a((ITag)BlockTagGenerator.CARMINITE_REACTOR_IMMUNE) || stateThere.func_185887_b((IBlockReader)this.field_145850_b, pos) == -1.0f)) {
            return;
        }
        if (fuzz == 0 && stateThere.func_177230_c() != Blocks.field_150350_a) {
            this.field_145850_b.func_217379_c(2001, pos, Block.func_196246_j(stateThere));
        }
        if (netherTransform && stateThere.func_177230_c() != Blocks.field_150350_a) {
            this.field_145850_b.func_180501_a(pos, Blocks.field_150424_aL.func_176223_P(), 3);
            if (this.field_145850_b.func_175623_d(pos.func_177984_a()) && fuzz % 3 == 0) {
                this.field_145850_b.func_180501_a(pos.func_177984_a(), Blocks.field_150480_ab.func_176223_P(), 3);
            }
        }
        else {
            this.field_145850_b.func_180501_a(pos, state, 3);
        }
    }
    
    private void createFakeBlock(final BlockPos pos, final BlockState state) {
        final BlockState stateThere = this.field_145850_b.func_180495_p(pos);
        if (stateThere.func_177230_c() != Blocks.field_150350_a && (stateThere.func_177230_c().func_203417_a((ITag)BlockTagGenerator.CARMINITE_REACTOR_IMMUNE) || stateThere.func_185887_b((IBlockReader)this.field_145850_b, pos) == -1.0f)) {
            return;
        }
        this.field_145850_b.func_180501_a(pos, state, 2);
    }
}
