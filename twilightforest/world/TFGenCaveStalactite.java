// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.block.Block;

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
    public Block blockID;
    public boolean hang;
    public float sizeFactor;
    public int maxLength;
    public int minHeight;
    
    public TFGenCaveStalactite(final Block blockType, final float size, final boolean down) {
        this.blockID = blockType;
        this.sizeFactor = size;
        this.maxLength = -1;
        this.minHeight = -1;
        this.hang = down;
    }
    
    public TFGenCaveStalactite(final Block blockType, final float size, final int maxLength, final int minHeight) {
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
        while (ty < TFWorld.CHUNKHEIGHT) {
            final Material m = world.func_147439_a(x, ty, z).func_149688_o();
            if (m == Material.field_151579_a) {
                ++ty;
            }
            else {
                if (m != Material.field_151578_c && m != Material.field_151576_e) {
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
            final Material m = world.func_147439_a(x, ty, z).func_149688_o();
            if (m == Material.field_151579_a) {
                --ty;
            }
            else {
                if (m != Material.field_151578_c && m != Material.field_151576_e && !this.hang && m != Material.field_151586_h && !this.hang && m != Material.field_151587_i) {
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
                if (!world.func_147439_a(x + dx, y - dir, z + dz).func_149688_o().func_76220_a()) {
                    spikeLength = 0;
                }
                for (int dy = 0; dy != spikeLength * dir; dy += dir) {
                    this.setBlock(world, x + dx, y + dy, z + dz, this.blockID);
                }
            }
        }
        return true;
    }
    
    static {
        TFGenCaveStalactite.diamond = new TFGenCaveStalactite(Blocks.field_150482_ag, 0.5f, 4, 16);
        TFGenCaveStalactite.lapis = new TFGenCaveStalactite(Blocks.field_150369_x, 0.8f, 8, 1);
        TFGenCaveStalactite.emerald = new TFGenCaveStalactite(Blocks.field_150412_bA, 0.5f, 3, 12);
        TFGenCaveStalactite.gold = new TFGenCaveStalactite(Blocks.field_150352_o, 0.6f, 6, 1);
        TFGenCaveStalactite.redstone = new TFGenCaveStalactite(Blocks.field_150450_ax, 0.8f, 8, 1);
        TFGenCaveStalactite.iron = new TFGenCaveStalactite(Blocks.field_150366_p, 0.7f, 8, 1);
        TFGenCaveStalactite.coal = new TFGenCaveStalactite(Blocks.field_150365_q, 0.8f, 12, 1);
        TFGenCaveStalactite.glowstone = new TFGenCaveStalactite(Blocks.field_150426_aN, 0.5f, 8, 1);
    }
}
