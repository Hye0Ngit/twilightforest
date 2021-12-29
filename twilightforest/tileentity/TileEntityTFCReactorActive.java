// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.block.Block;
import twilightforest.entity.EntityTFMiniGhast;
import net.minecraft.entity.Entity;
import twilightforest.block.TFBlocks;
import java.util.Random;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFCReactorActive extends TileEntity
{
    int counter;
    int secX;
    int secY;
    int secZ;
    int terX;
    int terY;
    int terZ;
    
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
    
    public void func_70316_g() {
        ++this.counter;
        if (!this.field_70331_k.field_72995_K) {
            final int offset = 10;
            if (this.counter % 5 == 0) {
                if (this.counter == 5) {
                    this.field_70331_k.func_72832_d(this.field_70329_l + 1, this.field_70330_m + 1, this.field_70327_n + 1, TFBlocks.towerTranslucent.field_71990_ca, 7, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l + 1, this.field_70330_m + 1, this.field_70327_n - 1, TFBlocks.towerTranslucent.field_71990_ca, 7, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l - 1, this.field_70330_m + 1, this.field_70327_n + 1, TFBlocks.towerTranslucent.field_71990_ca, 7, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l - 1, this.field_70330_m + 1, this.field_70327_n - 1, TFBlocks.towerTranslucent.field_71990_ca, 7, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l + 0, this.field_70330_m + 1, this.field_70327_n + 1, TFBlocks.towerTranslucent.field_71990_ca, 6, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l + 0, this.field_70330_m + 1, this.field_70327_n - 1, TFBlocks.towerTranslucent.field_71990_ca, 6, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l + 1, this.field_70330_m + 1, this.field_70327_n + 0, TFBlocks.towerTranslucent.field_71990_ca, 6, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l - 1, this.field_70330_m + 1, this.field_70327_n + 0, TFBlocks.towerTranslucent.field_71990_ca, 6, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l + 1, this.field_70330_m + 0, this.field_70327_n + 1, TFBlocks.towerTranslucent.field_71990_ca, 6, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l + 1, this.field_70330_m + 0, this.field_70327_n - 1, TFBlocks.towerTranslucent.field_71990_ca, 6, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l - 1, this.field_70330_m + 0, this.field_70327_n + 1, TFBlocks.towerTranslucent.field_71990_ca, 6, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l - 1, this.field_70330_m + 0, this.field_70327_n - 1, TFBlocks.towerTranslucent.field_71990_ca, 6, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l + 0, this.field_70330_m + 0, this.field_70327_n + 1, TFBlocks.towerTranslucent.field_71990_ca, 7, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l + 0, this.field_70330_m + 0, this.field_70327_n - 1, TFBlocks.towerTranslucent.field_71990_ca, 7, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l + 1, this.field_70330_m + 0, this.field_70327_n + 0, TFBlocks.towerTranslucent.field_71990_ca, 7, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l - 1, this.field_70330_m + 0, this.field_70327_n + 0, TFBlocks.towerTranslucent.field_71990_ca, 7, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l + 1, this.field_70330_m - 1, this.field_70327_n + 1, TFBlocks.towerTranslucent.field_71990_ca, 7, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l + 1, this.field_70330_m - 1, this.field_70327_n - 1, TFBlocks.towerTranslucent.field_71990_ca, 7, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l - 1, this.field_70330_m - 1, this.field_70327_n + 1, TFBlocks.towerTranslucent.field_71990_ca, 7, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l - 1, this.field_70330_m - 1, this.field_70327_n - 1, TFBlocks.towerTranslucent.field_71990_ca, 7, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l + 0, this.field_70330_m - 1, this.field_70327_n + 1, TFBlocks.towerTranslucent.field_71990_ca, 6, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l + 0, this.field_70330_m - 1, this.field_70327_n - 1, TFBlocks.towerTranslucent.field_71990_ca, 6, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l + 1, this.field_70330_m - 1, this.field_70327_n + 0, TFBlocks.towerTranslucent.field_71990_ca, 6, 2);
                    this.field_70331_k.func_72832_d(this.field_70329_l - 1, this.field_70330_m - 1, this.field_70327_n + 0, TFBlocks.towerTranslucent.field_71990_ca, 6, 2);
                }
                final int primary = this.counter - 80;
                if (primary >= offset && primary <= 249) {
                    this.drawBlob(this.field_70329_l, this.field_70330_m, this.field_70327_n, (primary - offset) / 40, 0, 0, primary - offset, false);
                }
                if (primary <= 200) {
                    this.drawBlob(this.field_70329_l, this.field_70330_m, this.field_70327_n, primary / 40, TFBlocks.towerTranslucent.field_71990_ca, 5, this.counter, false);
                }
                final int secondary = this.counter - 120;
                if (secondary >= offset && secondary <= 129) {
                    this.drawBlob(this.field_70329_l + this.secX, this.field_70330_m + this.secY, this.field_70327_n + this.secZ, (secondary - offset) / 40, 0, 0, secondary - offset, false);
                }
                if (secondary >= 0 && secondary <= 160) {
                    this.drawBlob(this.field_70329_l + this.secX, this.field_70330_m + this.secY, this.field_70327_n + this.secZ, secondary / 40, 0, 0, secondary, true);
                }
                final int tertiary = this.counter - 160;
                if (tertiary >= offset && tertiary <= 129) {
                    this.drawBlob(this.field_70329_l + this.terX, this.field_70330_m + this.terY, this.field_70327_n + this.terZ, (tertiary - offset) / 40, 0, 0, tertiary - offset, false);
                }
                if (tertiary >= 0 && tertiary <= 160) {
                    this.drawBlob(this.field_70329_l + this.terX, this.field_70330_m + this.terY, this.field_70327_n + this.terZ, tertiary / 40, 0, 0, tertiary, true);
                }
            }
            if (this.counter >= 350) {
                for (int i = 0; i < 3; ++i) {
                    this.spawnGhastNear(this.field_70329_l + this.secX, this.field_70330_m + this.secY, this.field_70327_n + this.secZ);
                    this.spawnGhastNear(this.field_70329_l + this.terX, this.field_70330_m + this.terY, this.field_70327_n + this.terZ);
                }
                this.field_70331_k.func_72876_a((Entity)null, (double)this.field_70329_l, (double)this.field_70330_m, (double)this.field_70327_n, 2.0f, true);
                this.field_70331_k.func_72832_d(this.field_70329_l, this.field_70330_m, this.field_70327_n, 0, 0, 3);
            }
        }
        else if (this.counter % 5 == 0 && this.counter <= 250) {
            this.field_70331_k.func_72980_b(this.field_70329_l + 0.5, this.field_70330_m + 0.5, this.field_70327_n + 0.5, "portal.portal", this.counter / 100.0f, this.counter / 100.0f, false);
        }
    }
    
    private void spawnGhastNear(final int x, final int y, final int z) {
        final EntityTFMiniGhast ghast = new EntityTFMiniGhast(this.field_70331_k);
        ghast.func_70012_b(x - 1.5 + this.field_70331_k.field_73012_v.nextFloat() * 3.0, y - 1.5 + this.field_70331_k.field_73012_v.nextFloat() * 3.0, z - 1.5 + this.field_70331_k.field_73012_v.nextFloat() * 3.0, this.field_70331_k.field_73012_v.nextFloat() * 360.0f, 0.0f);
        this.field_70331_k.func_72838_d((Entity)ghast);
    }
    
    public void drawBlob(final int sx, final int sy, final int sz, final int rad, final int blockValue, final int metaValue, final int fuzz, final boolean netherTransform) {
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
                                this.transformBlock(sx + dx, sy + dy, sz + dz, blockValue, metaValue, fuzzY, netherTransform);
                                break;
                            }
                            case 1: {
                                this.transformBlock(sx + dx, sy + dy, sz - dz, blockValue, metaValue, fuzzY, netherTransform);
                                break;
                            }
                            case 2: {
                                this.transformBlock(sx - dx, sy + dy, sz + dz, blockValue, metaValue, fuzzY, netherTransform);
                                break;
                            }
                            case 3: {
                                this.transformBlock(sx - dx, sy + dy, sz - dz, blockValue, metaValue, fuzzY, netherTransform);
                                break;
                            }
                            case 4: {
                                this.transformBlock(sx + dx, sy - dy, sz + dz, blockValue, metaValue, fuzzY, netherTransform);
                                break;
                            }
                            case 5: {
                                this.transformBlock(sx + dx, sy - dy, sz - dz, blockValue, metaValue, fuzzY, netherTransform);
                                break;
                            }
                            case 6: {
                                this.transformBlock(sx - dx, sy - dy, sz + dz, blockValue, metaValue, fuzzY, netherTransform);
                                break;
                            }
                            case 7: {
                                this.transformBlock(sx - dx, sy - dy, sz - dz, blockValue, metaValue, fuzzY, netherTransform);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    protected void transformBlock(final int x, final int y, final int z, final int blockValue, final int metaValue, final int fuzz, final boolean netherTransform) {
        final int whatsThere = this.field_70331_k.func_72798_a(x, y, z);
        final int whatsMeta = this.field_70331_k.func_72805_g(x, y, z);
        if (whatsThere > 0 && Block.field_71973_m[whatsThere].func_71934_m(this.field_70331_k, x, y, z) == -1.0f) {
            return;
        }
        if (fuzz == 0 && whatsThere > 0) {
            this.field_70331_k.func_72926_e(2001, x, y, z, whatsThere + (whatsMeta << 12));
        }
        if (netherTransform && whatsThere > 0) {
            this.field_70331_k.func_72832_d(x, y, z, Block.field_72012_bb.field_71990_ca, 0, 3);
            if (this.field_70331_k.func_72798_a(x, y + 1, z) == 0 && fuzz % 3 == 0) {
                this.field_70331_k.func_72832_d(x, y + 1, z, Block.field_72067_ar.field_71990_ca, 0, 3);
            }
        }
        else {
            this.field_70331_k.func_72832_d(x, y, z, blockValue, metaValue, 3);
        }
    }
}
