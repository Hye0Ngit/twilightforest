// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.entity.EntityTFMiniGhast;
import twilightforest.block.TFBlocks;
import java.util.Random;

public class TileEntityTFCReactorActive extends asm
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
    
    public void h() {
        ++this.counter;
        if (!this.k.I) {
            final int offset = 10;
            if (this.counter % 5 == 0) {
                if (this.counter == 5) {
                    this.k.f(this.l + 1, this.m + 1, this.n + 1, TFBlocks.towerTranslucent.cF, 7, 2);
                    this.k.f(this.l + 1, this.m + 1, this.n - 1, TFBlocks.towerTranslucent.cF, 7, 2);
                    this.k.f(this.l - 1, this.m + 1, this.n + 1, TFBlocks.towerTranslucent.cF, 7, 2);
                    this.k.f(this.l - 1, this.m + 1, this.n - 1, TFBlocks.towerTranslucent.cF, 7, 2);
                    this.k.f(this.l + 0, this.m + 1, this.n + 1, TFBlocks.towerTranslucent.cF, 6, 2);
                    this.k.f(this.l + 0, this.m + 1, this.n - 1, TFBlocks.towerTranslucent.cF, 6, 2);
                    this.k.f(this.l + 1, this.m + 1, this.n + 0, TFBlocks.towerTranslucent.cF, 6, 2);
                    this.k.f(this.l - 1, this.m + 1, this.n + 0, TFBlocks.towerTranslucent.cF, 6, 2);
                    this.k.f(this.l + 1, this.m + 0, this.n + 1, TFBlocks.towerTranslucent.cF, 6, 2);
                    this.k.f(this.l + 1, this.m + 0, this.n - 1, TFBlocks.towerTranslucent.cF, 6, 2);
                    this.k.f(this.l - 1, this.m + 0, this.n + 1, TFBlocks.towerTranslucent.cF, 6, 2);
                    this.k.f(this.l - 1, this.m + 0, this.n - 1, TFBlocks.towerTranslucent.cF, 6, 2);
                    this.k.f(this.l + 0, this.m + 0, this.n + 1, TFBlocks.towerTranslucent.cF, 7, 2);
                    this.k.f(this.l + 0, this.m + 0, this.n - 1, TFBlocks.towerTranslucent.cF, 7, 2);
                    this.k.f(this.l + 1, this.m + 0, this.n + 0, TFBlocks.towerTranslucent.cF, 7, 2);
                    this.k.f(this.l - 1, this.m + 0, this.n + 0, TFBlocks.towerTranslucent.cF, 7, 2);
                    this.k.f(this.l + 1, this.m - 1, this.n + 1, TFBlocks.towerTranslucent.cF, 7, 2);
                    this.k.f(this.l + 1, this.m - 1, this.n - 1, TFBlocks.towerTranslucent.cF, 7, 2);
                    this.k.f(this.l - 1, this.m - 1, this.n + 1, TFBlocks.towerTranslucent.cF, 7, 2);
                    this.k.f(this.l - 1, this.m - 1, this.n - 1, TFBlocks.towerTranslucent.cF, 7, 2);
                    this.k.f(this.l + 0, this.m - 1, this.n + 1, TFBlocks.towerTranslucent.cF, 6, 2);
                    this.k.f(this.l + 0, this.m - 1, this.n - 1, TFBlocks.towerTranslucent.cF, 6, 2);
                    this.k.f(this.l + 1, this.m - 1, this.n + 0, TFBlocks.towerTranslucent.cF, 6, 2);
                    this.k.f(this.l - 1, this.m - 1, this.n + 0, TFBlocks.towerTranslucent.cF, 6, 2);
                }
                final int primary = this.counter - 80;
                if (primary >= offset && primary <= 249) {
                    this.drawBlob(this.l, this.m, this.n, (primary - offset) / 40, 0, 0, primary - offset, false);
                }
                if (primary <= 200) {
                    this.drawBlob(this.l, this.m, this.n, primary / 40, TFBlocks.towerTranslucent.cF, 5, this.counter, false);
                }
                final int secondary = this.counter - 120;
                if (secondary >= offset && secondary <= 129) {
                    this.drawBlob(this.l + this.secX, this.m + this.secY, this.n + this.secZ, (secondary - offset) / 40, 0, 0, secondary - offset, false);
                }
                if (secondary >= 0 && secondary <= 160) {
                    this.drawBlob(this.l + this.secX, this.m + this.secY, this.n + this.secZ, secondary / 40, 0, 0, secondary, true);
                }
                final int tertiary = this.counter - 160;
                if (tertiary >= offset && tertiary <= 129) {
                    this.drawBlob(this.l + this.terX, this.m + this.terY, this.n + this.terZ, (tertiary - offset) / 40, 0, 0, tertiary - offset, false);
                }
                if (tertiary >= 0 && tertiary <= 160) {
                    this.drawBlob(this.l + this.terX, this.m + this.terY, this.n + this.terZ, tertiary / 40, 0, 0, tertiary, true);
                }
            }
            if (this.counter >= 350) {
                for (int i = 0; i < 3; ++i) {
                    this.spawnGhastNear(this.l + this.secX, this.m + this.secY, this.n + this.secZ);
                    this.spawnGhastNear(this.l + this.terX, this.m + this.terY, this.n + this.terZ);
                }
                this.k.a((nm)null, (double)this.l, (double)this.m, (double)this.n, 2.0f, true);
                this.k.f(this.l, this.m, this.n, 0, 0, 3);
            }
        }
        else if (this.counter % 5 == 0 && this.counter <= 250) {
            this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, "portal.portal", this.counter / 100.0f, this.counter / 100.0f, false);
        }
    }
    
    private void spawnGhastNear(final int x, final int y, final int z) {
        final EntityTFMiniGhast ghast = new EntityTFMiniGhast(this.k);
        ghast.b(x - 1.5 + this.k.s.nextFloat() * 3.0, y - 1.5 + this.k.s.nextFloat() * 3.0, z - 1.5 + this.k.s.nextFloat() * 3.0, this.k.s.nextFloat() * 360.0f, 0.0f);
        this.k.d((nm)ghast);
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
        final int whatsThere = this.k.a(x, y, z);
        final int whatsMeta = this.k.h(x, y, z);
        if (whatsThere > 0 && aqw.s[whatsThere].l(this.k, x, y, z) == -1.0f) {
            return;
        }
        if (fuzz == 0 && whatsThere > 0) {
            this.k.e(2001, x, y, z, whatsThere + (whatsMeta << 12));
        }
        if (netherTransform && whatsThere > 0) {
            this.k.f(x, y, z, aqw.bg.cF, 0, 3);
            if (this.k.a(x, y + 1, z) == 0 && fuzz % 3 == 0) {
                this.k.f(x, y + 1, z, aqw.aw.cF, 0, 3);
            }
        }
        else {
            this.k.f(x, y, z, blockValue, metaValue, 3);
        }
    }
}
