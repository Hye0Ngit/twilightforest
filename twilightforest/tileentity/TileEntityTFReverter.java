// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFReverter extends TileEntity
{
    private static final int REVERT_CHANCE = 10;
    public int radius;
    public int diameter;
    public double requiredPlayerRange;
    public Random rand;
    private int tickCount;
    private boolean slowScan;
    private int ticksSinceChange;
    private Block[] blockData;
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
    
    public void func_145845_h() {
        if (this.anyPlayerInRange()) {
            ++this.tickCount;
            if (this.field_145850_b.field_72995_K) {
                final double var1 = this.field_145851_c + this.field_145850_b.field_73012_v.nextFloat();
                final double var2 = this.field_145848_d + this.field_145850_b.field_73012_v.nextFloat();
                final double var3 = this.field_145849_e + this.field_145850_b.field_73012_v.nextFloat();
                this.field_145850_b.func_72869_a("reddust", var1, var2, var3, 0.0, 0.0, 0.0);
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
        double sx = this.field_145851_c;
        double sy = this.field_145848_d;
        double sz = this.field_145849_e;
        double dx = this.field_145851_c;
        double dy = this.field_145848_d;
        double dz = this.field_145849_e;
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
            this.drawParticleLine(this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5, dx, dy, dz);
        }
        else {
            this.drawParticleLine(sx, sy, sz, this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5);
        }
        this.drawParticleLine(sx, sy, sz, dx, dy, dz);
    }
    
    protected void drawParticleLine(final double srcX, final double srcY, final double srcZ, final double destX, final double destY, final double destZ) {
        for (int particles = 16, i = 0; i < particles; ++i) {
            final double trailFactor = i / (particles - 1.0);
            final double tx = srcX + (destX - srcX) * trailFactor + this.rand.nextFloat() * 0.005;
            final double ty = srcY + (destY - srcY) * trailFactor + this.rand.nextFloat() * 0.005;
            final double tz = srcZ + (destZ - srcZ) * trailFactor + this.rand.nextFloat() * 0.005;
            this.field_145850_b.func_72869_a("reddust", tx, ty, tz, 0.0, 0.0, 0.0);
        }
    }
    
    private boolean scanAndRevertChanges() {
        int index = 0;
        boolean reverted = false;
        for (int x = -this.radius; x <= this.radius; ++x) {
            for (int y = -this.radius; y <= this.radius; ++y) {
                for (int z = -this.radius; z <= this.radius; ++z) {
                    final Block blockID = this.field_145850_b.func_147439_a(this.field_145851_c + x, this.field_145848_d + y, this.field_145849_e + z);
                    final byte meta = (byte)this.field_145850_b.func_72805_g(this.field_145851_c + x, this.field_145848_d + y, this.field_145849_e + z);
                    if (this.blockData[index] != blockID) {
                        if (this.revertBlock(this.field_145851_c + x, this.field_145848_d + y, this.field_145849_e + z, blockID, meta, this.blockData[index], this.metaData[index])) {
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
    
    private boolean revertBlock(final int x, final int y, final int z, final Block thereBlockID, final byte thereMeta, Block replaceBlockID, byte replaceMeta) {
        if (thereBlockID == Blocks.field_150350_a && !replaceBlockID.func_149688_o().func_76230_c()) {
            System.out.println("Not replacing block " + replaceBlockID + " because it doesn't block movement");
            return false;
        }
        if (this.isUnrevertable(thereBlockID, thereMeta, replaceBlockID, replaceMeta)) {
            return false;
        }
        if (this.rand.nextInt(10) == 0) {
            if (replaceBlockID != Blocks.field_150350_a) {
                replaceBlockID = TFBlocks.towerTranslucent;
                replaceMeta = 4;
            }
            this.field_145850_b.func_147465_d(x, y, z, replaceBlockID, (int)replaceMeta, 2);
            if (thereBlockID == Blocks.field_150350_a) {
                this.field_145850_b.func_72926_e(2001, x, y, z, Block.func_149682_b(replaceBlockID) + (replaceMeta << 12));
            }
            else if (replaceBlockID == Blocks.field_150350_a) {
                this.field_145850_b.func_72926_e(2001, x, y, z, Block.func_149682_b(thereBlockID) + (thereMeta << 12));
                thereBlockID.func_149697_b(this.field_145850_b, x, y, z, (int)thereMeta, 0);
            }
        }
        return true;
    }
    
    private boolean isUnrevertable(final Block thereBlockID, final byte thereMeta, final Block replaceBlockID, final byte replaceMeta) {
        return thereBlockID == TFBlocks.towerDevice || replaceBlockID == TFBlocks.towerDevice || ((thereBlockID == TFBlocks.towerTranslucent && thereMeta != 4) || (replaceBlockID == TFBlocks.towerTranslucent && replaceMeta != 4)) || (thereBlockID == Blocks.field_150379_bu && replaceBlockID == Blocks.field_150374_bv) || (thereBlockID == Blocks.field_150374_bv && replaceBlockID == Blocks.field_150379_bu) || (thereBlockID == Blocks.field_150355_j || replaceBlockID == Blocks.field_150358_i) || (thereBlockID == Blocks.field_150358_i || replaceBlockID == Blocks.field_150355_j) || replaceBlockID == Blocks.field_150335_W;
    }
    
    private void captureBlockData() {
        this.blockData = new Block[this.diameter * this.diameter * this.diameter];
        this.metaData = new byte[this.diameter * this.diameter * this.diameter];
        int index = 0;
        for (int x = -this.radius; x <= this.radius; ++x) {
            for (int y = -this.radius; y <= this.radius; ++y) {
                for (int z = -this.radius; z <= this.radius; ++z) {
                    final Block blockID = this.field_145850_b.func_147439_a(this.field_145851_c + x, this.field_145848_d + y, this.field_145849_e + z);
                    final int meta = this.field_145850_b.func_72805_g(this.field_145851_c + x, this.field_145848_d + y, this.field_145849_e + z);
                    this.blockData[index] = blockID;
                    this.metaData[index] = (byte)meta;
                    ++index;
                }
            }
        }
    }
    
    public boolean anyPlayerInRange() {
        return this.field_145850_b.func_72977_a(this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5, this.requiredPlayerRange) != null;
    }
}
