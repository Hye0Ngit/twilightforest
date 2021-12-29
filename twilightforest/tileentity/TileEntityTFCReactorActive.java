// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import twilightforest.entity.EntityTFMiniGhast;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.TowerTranslucentVariant;
import twilightforest.block.BlockTFTowerTranslucent;
import twilightforest.block.TFBlocks;
import java.util.Random;
import net.minecraft.util.ITickable;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFCReactorActive extends TileEntity implements ITickable
{
    private int counter;
    private int secX;
    private int secY;
    private int secZ;
    private int terX;
    private int terY;
    private int terZ;
    
    public TileEntityTFCReactorActive() {
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
                    final IBlockState fakeGold = TFBlocks.tower_translucent.func_176223_P().func_177226_a((IProperty)BlockTFTowerTranslucent.VARIANT, (Comparable)TowerTranslucentVariant.FAKE_GOLD);
                    final IBlockState fakeDiamond = TFBlocks.tower_translucent.func_176223_P().func_177226_a((IProperty)BlockTFTowerTranslucent.VARIANT, (Comparable)TowerTranslucentVariant.FAKE_DIAMOND);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(1, 1, 1), fakeDiamond, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(1, 1, -1), fakeDiamond, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(-1, 1, 1), fakeDiamond, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(-1, 1, -1), fakeDiamond, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(0, 1, 1), fakeGold, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(0, 1, -1), fakeGold, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(1, 1, 0), fakeGold, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(-1, 1, 0), fakeGold, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(1, 0, 1), fakeGold, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(1, 0, -1), fakeGold, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(-1, 0, 1), fakeGold, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(-1, 0, -1), fakeGold, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(0, 0, 1), fakeDiamond, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(0, 0, -1), fakeDiamond, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(1, 0, 0), fakeDiamond, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(-1, 0, 0), fakeDiamond, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(1, -1, 1), fakeDiamond, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(1, -1, -1), fakeDiamond, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(-1, -1, 1), fakeDiamond, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(-1, -1, -1), fakeDiamond, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(0, -1, 1), fakeGold, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(0, -1, -1), fakeGold, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(1, -1, 0), fakeGold, 2);
                    this.field_145850_b.func_180501_a(this.field_174879_c.func_177982_a(-1, -1, 0), fakeGold, 2);
                }
                final int primary = this.counter - 80;
                if (primary >= offset && primary <= 249) {
                    this.drawBlob(this.field_174879_c, (primary - offset) / 40, Blocks.field_150350_a.func_176223_P(), primary - offset, false);
                }
                if (primary <= 200) {
                    this.drawBlob(this.field_174879_c, primary / 40, TFBlocks.tower_translucent.func_176223_P().func_177226_a((IProperty)BlockTFTowerTranslucent.VARIANT, (Comparable)TowerTranslucentVariant.REACTOR_DEBRIS), this.counter, false);
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
                this.field_145850_b.func_72876_a((Entity)null, (double)this.field_174879_c.func_177958_n(), (double)this.field_174879_c.func_177956_o(), (double)this.field_174879_c.func_177952_p(), 2.0f, true);
                this.field_145850_b.func_175698_g(this.field_174879_c);
            }
        }
        else if (this.counter % 5 == 0 && this.counter <= 250) {
            this.field_145850_b.func_184134_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.5, this.field_174879_c.func_177952_p() + 0.5, SoundEvents.field_187810_eg, SoundCategory.BLOCKS, this.counter / 100.0f, this.counter / 100.0f, false);
        }
    }
    
    private void spawnGhastNear(final int x, final int y, final int z) {
        final EntityTFMiniGhast ghast = new EntityTFMiniGhast(this.field_145850_b);
        ghast.func_70012_b(x - 1.5 + this.field_145850_b.field_73012_v.nextFloat() * 3.0, y - 1.5 + this.field_145850_b.field_73012_v.nextFloat() * 3.0, z - 1.5 + this.field_145850_b.field_73012_v.nextFloat() * 3.0, this.field_145850_b.field_73012_v.nextFloat() * 360.0f, 0.0f);
        this.field_145850_b.func_72838_d((Entity)ghast);
    }
    
    private void drawBlob(final BlockPos pos, final int rad, final IBlockState state, final int fuzz, final boolean netherTransform) {
        for (byte dx = 0; dx <= rad; ++dx) {
            final int fuzzX = (fuzz + dx) % 8;
            for (byte dy = 0; dy <= rad; ++dy) {
                final int fuzzY = (fuzz + dy) % 8;
                for (byte dz = 0; dz <= rad; ++dz) {
                    byte dist = 0;
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
    
    private void transformBlock(final BlockPos pos, final IBlockState state, final int fuzz, final boolean netherTransform) {
        final IBlockState stateThere = this.field_145850_b.func_180495_p(pos);
        if (stateThere.func_177230_c() != Blocks.field_150350_a && stateThere.func_185887_b(this.field_145850_b, pos) == -1.0f) {
            return;
        }
        if (fuzz == 0 && stateThere.func_177230_c() != Blocks.field_150350_a) {
            this.field_145850_b.func_175718_b(2001, pos, Block.func_176210_f(stateThere));
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
}
