// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import java.util.Random;

public class TFGenCaveStalactite extends TFGenerator
{
    public static TFGenCaveStalactite diamond;
    public static TFGenCaveStalactite lapis;
    public static TFGenCaveStalactite emerald;
    public static TFGenCaveStalactite gold;
    public static TFGenCaveStalactite redstone;
    public static TFGenCaveStalactite iron;
    public static TFGenCaveStalactite coal;
    public static TFGenCaveStalactite glowstone;
    public int blockID;
    public boolean hang;
    public float sizeFactor;
    public int maxLength;
    public int minHeight;
    
    public TFGenCaveStalactite(final int blockType, final float size, final boolean down) {
        this.blockID = blockType;
        this.sizeFactor = size;
        this.maxLength = -1;
        this.minHeight = -1;
        this.hang = down;
    }
    
    public TFGenCaveStalactite(final int blockType, final float size, final int maxLength, final int minHeight) {
        this.blockID = blockType;
        this.sizeFactor = size;
        this.maxLength = maxLength;
        this.minHeight = minHeight;
        this.hang = true;
    }
    
    public static TFGenCaveStalactite makeRandomOreStalactite(final Random rand, final int hillSize) {
        if (hillSize >= 3 || (hillSize >= 2 && rand.nextInt(5) == 0)) {
            final int s3 = rand.nextInt(13);
            if (s3 == 0 || s3 == 1) {
                return TFGenCaveStalactite.diamond;
            }
            if (s3 == 2 || s3 == 3) {
                return TFGenCaveStalactite.lapis;
            }
            if (s3 == 4) {
                return TFGenCaveStalactite.emerald;
            }
        }
        if (hillSize >= 2 || (hillSize >= 1 && rand.nextInt(5) == 0)) {
            final int s4 = rand.nextInt(6);
            if (s4 == 0) {
                return TFGenCaveStalactite.gold;
            }
            if (s4 == 1 || s4 == 2) {
                return TFGenCaveStalactite.redstone;
            }
        }
        final int s5 = rand.nextInt(5);
        if (s5 == 0 || s5 == 1) {
            return TFGenCaveStalactite.iron;
        }
        if (s5 == 2 || s5 == 3) {
            return TFGenCaveStalactite.coal;
        }
        return TFGenCaveStalactite.glowstone;
    }
    
    public boolean func_76484_a(final World world, final Random random, final int x, final int y, final int z) {
        int ceiling = Integer.MAX_VALUE;
        int floor = -1;
        int ty = y;
        while (ty < TFWorld.WORLDHEIGHT) {
            final Material m = world.func_72803_f(x, ty, z);
            if (m == Material.field_76249_a) {
                ++ty;
            }
            else {
                if (m != Material.field_76248_c && m != Material.field_76246_e) {
                    return false;
                }
                ceiling = ty;
                break;
            }
        }
        if (ceiling == Integer.MAX_VALUE) {
            return false;
        }
        ty = y;
        while (ty > 4) {
            final Material m = world.func_72803_f(x, ty, z);
            if (m == Material.field_76249_a) {
                --ty;
            }
            else {
                if (m != Material.field_76248_c && m != Material.field_76246_e && !this.hang && m != Material.field_76244_g && !this.hang && m != Material.field_76256_h) {
                    return false;
                }
                floor = ty;
                break;
            }
        }
        int length = (int)((ceiling - floor) * this.sizeFactor * random.nextFloat());
        if (this.maxLength > -1 && length > this.maxLength) {
            length = this.maxLength;
        }
        return (this.minHeight <= -1 || ceiling - floor - length >= this.minHeight) && this.makeSpike(world, random, x, this.hang ? ceiling : floor, z, length);
    }
    
    public boolean makeSpike(final World world, final Random random, final int x, final int y, final int z, final int maxLength) {
        for (int diameter = (int)(maxLength / 4.5), dx = -diameter; dx <= diameter; ++dx) {
            for (int dz = -diameter; dz <= diameter; ++dz) {
                final int absx = Math.abs(dx);
                final int absz = Math.abs(dz);
                final int dist = (int)(Math.max(absx, absz) + Math.min(absx, absz) * 0.5);
                int spikeLength = 0;
                if (dist == 0) {
                    spikeLength = maxLength;
                }
                if (dist > 0) {
                    spikeLength = random.nextInt((int)(maxLength / (dist + 0.25)));
                }
                final int dir = this.hang ? -1 : 1;
                if (!world.func_72803_f(x + dx, y - dir, z + dz).func_76220_a()) {
                    spikeLength = 0;
                }
                for (int dy = 0; dy != spikeLength * dir; dy += dir) {
                    this.func_76486_a(world, x + dx, y + dy, z + dz, this.blockID);
                }
            }
        }
        return true;
    }
    
    static {
        TFGenCaveStalactite.diamond = new TFGenCaveStalactite(Block.field_72073_aw.field_71990_ca, 0.5f, 4, 16);
        TFGenCaveStalactite.lapis = new TFGenCaveStalactite(Block.field_71947_N.field_71990_ca, 0.8f, 8, 1);
        TFGenCaveStalactite.emerald = new TFGenCaveStalactite(Block.field_72068_bR.field_71990_ca, 0.5f, 3, 12);
        TFGenCaveStalactite.gold = new TFGenCaveStalactite(Block.field_71941_G.field_71990_ca, 0.6f, 6, 1);
        TFGenCaveStalactite.redstone = new TFGenCaveStalactite(Block.field_72047_aN.field_71990_ca, 0.8f, 8, 1);
        TFGenCaveStalactite.iron = new TFGenCaveStalactite(Block.field_71949_H.field_71990_ca, 0.7f, 8, 1);
        TFGenCaveStalactite.coal = new TFGenCaveStalactite(Block.field_71950_I.field_71990_ca, 0.8f, 12, 1);
        TFGenCaveStalactite.glowstone = new TFGenCaveStalactite(Block.field_72014_bd.field_71990_ca, 0.5f, 8, 1);
    }
}
