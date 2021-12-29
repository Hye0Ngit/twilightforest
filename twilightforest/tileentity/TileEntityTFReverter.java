// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class TileEntityTFReverter extends aqj
{
    private static final int REVERT_CHANCE = 10;
    public int radius;
    public int diameter;
    public double requiredPlayerRange;
    public Random rand;
    private int tickCount;
    private boolean slowScan;
    private int ticksSinceChange;
    private short[] blockData;
    private byte[] metaData;
    
    public TileEntityTFReverter() {
        this.radius = 4;
        this.diameter = 2 * this.radius + 1;
        this.requiredPlayerRange = 16.0;
        this.rand = new Random();
    }
    
    public boolean canUpdate() {
        return true;
    }
    
    public void h() {
        if (this.anyPlayerInRange()) {
            ++this.tickCount;
            if (this.k.I) {
                final double var1 = this.l + this.k.s.nextFloat();
                final double var2 = this.m + this.k.s.nextFloat();
                final double var3 = this.n + this.k.s.nextFloat();
                this.k.a("reddust", var1, var2, var3, 0.0, 0.0, 0.0);
                if (this.rand.nextInt(10) == 0) {
                    this.makeRandomOutline();
                    this.makeRandomOutline();
                    this.makeRandomOutline();
                }
            }
            else {
                if (this.blockData == null || this.metaData == null) {
                    this.captureBlockData();
                    this.slowScan = true;
                }
                if (!this.slowScan || this.tickCount % 20 == 0) {
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
            this.metaData = null;
            this.tickCount = 0;
        }
    }
    
    private void makeRandomOutline() {
        this.makeOutline(this.rand.nextInt(12));
    }
    
    private void makeOutline(final int outline) {
        double sx = this.l;
        double sy = this.m;
        double sz = this.n;
        double dx = this.l;
        double dy = this.m;
        double dz = this.n;
        switch (outline) {
            case 0:
            case 8: {
                sx -= this.radius;
                dx += this.radius + 1;
                sz -= this.radius;
                dz -= this.radius;
                break;
            }
            case 1:
            case 9: {
                sx -= this.radius;
                dx -= this.radius;
                sz -= this.radius;
                dz += this.radius + 1;
                break;
            }
            case 2:
            case 10: {
                sx -= this.radius;
                dx += this.radius + 1;
                sz += this.radius + 1;
                dz += this.radius + 1;
                break;
            }
            case 3:
            case 11: {
                sx += this.radius + 1;
                dx += this.radius + 1;
                sz -= this.radius;
                dz += this.radius + 1;
                break;
            }
            case 4: {
                sx -= this.radius;
                dx -= this.radius;
                sz -= this.radius;
                dz -= this.radius;
                break;
            }
            case 5: {
                sx += this.radius + 1;
                dx += this.radius + 1;
                sz -= this.radius;
                dz -= this.radius;
                break;
            }
            case 6: {
                sx += this.radius + 1;
                dx += this.radius + 1;
                sz += this.radius + 1;
                dz += this.radius + 1;
                break;
            }
            case 7: {
                sx -= this.radius;
                dx -= this.radius;
                sz += this.radius + 1;
                dz += this.radius + 1;
                break;
            }
        }
        switch (outline) {
            case 0:
            case 1:
            case 2:
            case 3: {
                sy += this.radius + 1;
                dy += this.radius + 1;
                break;
            }
            case 4:
            case 5:
            case 6:
            case 7: {
                sy -= this.radius;
                dy += this.radius + 1;
                break;
            }
            case 8:
            case 9:
            case 10:
            case 11: {
                sy -= this.radius;
                dy -= this.radius;
                break;
            }
        }
        if (this.rand.nextBoolean()) {
            this.drawParticleLine(this.l + 0.5, this.m + 0.5, this.n + 0.5, dx, dy, dz);
        }
        else {
            this.drawParticleLine(sx, sy, sz, this.l + 0.5, this.m + 0.5, this.n + 0.5);
        }
        this.drawParticleLine(sx, sy, sz, dx, dy, dz);
    }
    
    protected void drawParticleLine(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 16, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final double tx = srcX + (destX - srcX) * trailFactor + this.rand.nextFloat() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.rand.nextFloat() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.rand.nextFloat() * 0.005;
            this.k.a("reddust", tx, ty, tz, 0.0, 0.0, 0.0);
        }
    }
    
    private boolean scanAndRevertChanges() {
        int index = 0;
        boolean reverted = false;
        for (int x = -this.radius; x <= this.radius; ++x) {
            for (int y = -this.radius; y <= this.radius; ++y) {
                for (int z = -this.radius; z <= this.radius; ++z) {
                    final short blockID = (short)this.k.a(this.l + x, this.m + y, this.n + z);
                    final byte meta = (byte)this.k.h(this.l + x, this.m + y, this.n + z);
                    if (this.blockData[index] != blockID) {
                        if (this.revertBlock(this.l + x, this.m + y, this.n + z, blockID, meta, this.blockData[index], this.metaData[index])) {
                            reverted = true;
                        }
                        else {
                            this.blockData[index] = blockID;
                            this.metaData[index] = meta;
                        }
                    }
                    ++index;
                }
            }
        }
        return reverted;
    }
    
    private boolean revertBlock(final int x, final int y, final int z, final short thereBlockID, final byte thereMeta, short replaceBlockID, byte replaceMeta) {
        if (thereBlockID == 0 && aou.r[replaceBlockID].b((aae)this.k, x, y, z)) {
            return false;
        }
        if (this.isUnrevertable(thereBlockID, thereMeta, replaceBlockID, replaceMeta)) {
            return false;
        }
        if (this.rand.nextInt(10) == 0) {
            if (replaceBlockID != 0) {
                replaceBlockID = (short)TFBlocks.towerTranslucent.cz;
                replaceMeta = 4;
            }
            this.k.f(x, y, z, (int)replaceBlockID, (int)replaceMeta, 3);
            if (thereBlockID == 0) {
                this.k.e(2001, x, y, z, replaceBlockID + (replaceMeta << 12));
            }
            else if (replaceBlockID == 0) {
                this.k.e(2001, x, y, z, thereBlockID + (thereMeta << 12));
                aou.r[thereBlockID].c(this.k, x, y, z, (int)thereMeta, 0);
            }
        }
        return true;
    }
    
    private boolean isUnrevertable(final short thereBlockID, final byte thereMeta, final short replaceBlockID, final byte replaceMeta) {
        return thereBlockID == TFBlocks.towerDevice.cz || replaceBlockID == TFBlocks.towerDevice.cz || ((thereBlockID == TFBlocks.towerTranslucent.cz && replaceBlockID != 4) || (replaceBlockID == TFBlocks.towerTranslucent.cz && replaceMeta != 4)) || (thereBlockID == aou.bP.cz && replaceBlockID == aou.bQ.cz) || (thereBlockID == aou.bQ.cz && replaceBlockID == aou.bP.cz) || (thereBlockID == aou.E.cz || replaceBlockID == aou.E.cz) || (thereBlockID == aou.F.cz || replaceBlockID == aou.F.cz) || replaceBlockID == aou.aq.cz;
    }
    
    private void captureBlockData() {
        this.blockData = new short[this.diameter * this.diameter * this.diameter];
        this.metaData = new byte[this.diameter * this.diameter * this.diameter];
        int index = 0;
        for (int x = -this.radius; x <= this.radius; ++x) {
            for (int y = -this.radius; y <= this.radius; ++y) {
                for (int z = -this.radius; z <= this.radius; ++z) {
                    final int blockID = this.k.a(this.l + x, this.m + y, this.n + z);
                    final int meta = this.k.h(this.l + x, this.m + y, this.n + z);
                    this.blockData[index] = (short)blockID;
                    this.metaData[index] = (byte)meta;
                    ++index;
                }
            }
        }
    }
    
    private boolean canEatBlock(final int thereBlockID, final int thereMeta) {
        return thereBlockID != TFBlocks.towerDevice.cz && thereBlockID != TFBlocks.towerTranslucent.cz;
    }
    
    public boolean anyPlayerInRange() {
        return this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, this.requiredPlayerRange) != null;
    }
}
