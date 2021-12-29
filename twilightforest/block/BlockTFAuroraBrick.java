// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFAuroraBrick extends Block implements ModelRegisterCallback
{
    public static final IProperty<Integer> VARIANT;
    
    public BlockTFAuroraBrick() {
        super(Material.field_151598_x);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149711_c(2.0f);
        this.func_149752_b(10.0f);
    }
    
    private static float getFractalNoise(final int iteration, final float size, final BlockPos pos) {
        return (iteration == 0) ? 0.0f : ((SimplexNoise.noise((pos.func_177958_n() + iteration * size) / size, (pos.func_177956_o() + iteration * size) / size, (pos.func_177952_p() + iteration * size) / size) + 1.0f) * 0.5f + getFractalNoise(iteration - 1, size, pos));
    }
    
    public static float fractalNoise(final int iterations, final float size, final BlockPos pos) {
        return getFractalNoise(iterations, size, pos) / iterations;
    }
    
    public static float rippleFractialNoise(final int iterations, final float size, final BlockPos pos, final float minimum, final float maximum, final float frequency) {
        final float i = maximum - minimum;
        return Math.abs(getFractalNoise(iterations, size, pos) * frequency % (2.0f * i) - i) + minimum;
    }
    
    @Deprecated
    public IBlockState func_176221_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFAuroraBrick.VARIANT, (Comparable)((int)(fractalNoise(3, 48.0f, pos) * 120.0f % 16.0f) % 16));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFAuroraBrick.VARIANT });
    }
    
    public int func_176201_c(final IBlockState state) {
        return (int)state.func_177229_b((IProperty)BlockTFAuroraBrick.VARIANT);
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P();
    }
    
    public void func_149666_a(final CreativeTabs tab, final NonNullList<ItemStack> items) {
        items.add((Object)new ItemStack((Block)this, 1, 0));
    }
    
    public int func_180651_a(final IBlockState state) {
        return 0;
    }
    
    static {
        VARIANT = (IProperty)PropertyInteger.func_177719_a("variant", 0, 15);
    }
    
    private static class SimplexNoise
    {
        private static Grad[] grad3;
        private static short[] p;
        private static short[] perm;
        private static short[] permMod12;
        private static final float F3 = 0.33333334f;
        private static final float G3 = 0.16666667f;
        
        private static int fastfloor(final float x) {
            final int xi = (int)x;
            return (x < xi) ? (xi - 1) : xi;
        }
        
        private static float dot(final Grad g, final float x, final float y, final float z) {
            return g.x * x + g.y * y + g.z * z;
        }
        
        static float noise(final float xin, final float yin, final float zin) {
            final float s = (xin + yin + zin) * 0.33333334f;
            final int i = fastfloor(xin + s);
            final int j = fastfloor(yin + s);
            final int k = fastfloor(zin + s);
            final float t = (i + j + k) * 0.16666667f;
            final float X0 = i - t;
            final float Y0 = j - t;
            final float Z0 = k - t;
            final float x0 = xin - X0;
            final float y0 = yin - Y0;
            final float z0 = zin - Z0;
            int i2;
            int j2;
            int k2;
            int i3;
            int j3;
            int k3;
            if (x0 >= y0) {
                if (y0 >= z0) {
                    i2 = 1;
                    j2 = 0;
                    k2 = 0;
                    i3 = 1;
                    j3 = 1;
                    k3 = 0;
                }
                else if (x0 >= z0) {
                    i2 = 1;
                    j2 = 0;
                    k2 = 0;
                    i3 = 1;
                    j3 = 0;
                    k3 = 1;
                }
                else {
                    i2 = 0;
                    j2 = 0;
                    k2 = 1;
                    i3 = 1;
                    j3 = 0;
                    k3 = 1;
                }
            }
            else if (y0 < z0) {
                i2 = 0;
                j2 = 0;
                k2 = 1;
                i3 = 0;
                j3 = 1;
                k3 = 1;
            }
            else if (x0 < z0) {
                i2 = 0;
                j2 = 1;
                k2 = 0;
                i3 = 0;
                j3 = 1;
                k3 = 1;
            }
            else {
                i2 = 0;
                j2 = 1;
                k2 = 0;
                i3 = 1;
                j3 = 1;
                k3 = 0;
            }
            final float x2 = x0 - i2 + 0.16666667f;
            final float y2 = y0 - j2 + 0.16666667f;
            final float z2 = z0 - k2 + 0.16666667f;
            final float x3 = x0 - i3 + 0.33333334f;
            final float y3 = y0 - j3 + 0.33333334f;
            final float z3 = z0 - k3 + 0.33333334f;
            final float x4 = x0 - 1.0f + 0.5f;
            final float y4 = y0 - 1.0f + 0.5f;
            final float z4 = z0 - 1.0f + 0.5f;
            final int ii = i & 0xFF;
            final int jj = j & 0xFF;
            final int kk = k & 0xFF;
            final int gi0 = SimplexNoise.permMod12[ii + SimplexNoise.perm[jj + SimplexNoise.perm[kk]]];
            final int gi2 = SimplexNoise.permMod12[ii + i2 + SimplexNoise.perm[jj + j2 + SimplexNoise.perm[kk + k2]]];
            final int gi3 = SimplexNoise.permMod12[ii + i3 + SimplexNoise.perm[jj + j3 + SimplexNoise.perm[kk + k3]]];
            final int gi4 = SimplexNoise.permMod12[ii + 1 + SimplexNoise.perm[jj + 1 + SimplexNoise.perm[kk + 1]]];
            float t2 = 0.6f - x0 * x0 - y0 * y0 - z0 * z0;
            float n0;
            if (t2 < 0.0f) {
                n0 = 0.0f;
            }
            else {
                t2 *= t2;
                n0 = t2 * t2 * dot(SimplexNoise.grad3[gi0], x0, y0, z0);
            }
            float t3 = 0.6f - x2 * x2 - y2 * y2 - z2 * z2;
            float n2;
            if (t3 < 0.0f) {
                n2 = 0.0f;
            }
            else {
                t3 *= t3;
                n2 = t3 * t3 * dot(SimplexNoise.grad3[gi2], x2, y2, z2);
            }
            float t4 = 0.6f - x3 * x3 - y3 * y3 - z3 * z3;
            float n3;
            if (t4 < 0.0f) {
                n3 = 0.0f;
            }
            else {
                t4 *= t4;
                n3 = t4 * t4 * dot(SimplexNoise.grad3[gi3], x3, y3, z3);
            }
            float t5 = 0.6f - x4 * x4 - y4 * y4 - z4 * z4;
            float n4;
            if (t5 < 0.0f) {
                n4 = 0.0f;
            }
            else {
                t5 *= t5;
                n4 = t5 * t5 * dot(SimplexNoise.grad3[gi4], x4, y4, z4);
            }
            return 32.0f * (n0 + n2 + n3 + n4);
        }
        
        static {
            SimplexNoise.grad3 = new Grad[] { new Grad(1.0f, 1.0f, 0.0f), new Grad(-1.0f, 1.0f, 0.0f), new Grad(1.0f, -1.0f, 0.0f), new Grad(-1.0f, -1.0f, 0.0f), new Grad(1.0f, 0.0f, 1.0f), new Grad(-1.0f, 0.0f, 1.0f), new Grad(1.0f, 0.0f, -1.0f), new Grad(-1.0f, 0.0f, -1.0f), new Grad(0.0f, 1.0f, 1.0f), new Grad(0.0f, -1.0f, 1.0f), new Grad(0.0f, 1.0f, -1.0f), new Grad(0.0f, -1.0f, -1.0f) };
            SimplexNoise.p = new short[] { 151, 160, 137, 91, 90, 15, 131, 13, 201, 95, 96, 53, 194, 233, 7, 225, 140, 36, 103, 30, 69, 142, 8, 99, 37, 240, 21, 10, 23, 190, 6, 148, 247, 120, 234, 75, 0, 26, 197, 62, 94, 252, 219, 203, 117, 35, 11, 32, 57, 177, 33, 88, 237, 149, 56, 87, 174, 20, 125, 136, 171, 168, 68, 175, 74, 165, 71, 134, 139, 48, 27, 166, 77, 146, 158, 231, 83, 111, 229, 122, 60, 211, 133, 230, 220, 105, 92, 41, 55, 46, 245, 40, 244, 102, 143, 54, 65, 25, 63, 161, 1, 216, 80, 73, 209, 76, 132, 187, 208, 89, 18, 169, 200, 196, 135, 130, 116, 188, 159, 86, 164, 100, 109, 198, 173, 186, 3, 64, 52, 217, 226, 250, 124, 123, 5, 202, 38, 147, 118, 126, 255, 82, 85, 212, 207, 206, 59, 227, 47, 16, 58, 17, 182, 189, 28, 42, 223, 183, 170, 213, 119, 248, 152, 2, 44, 154, 163, 70, 221, 153, 101, 155, 167, 43, 172, 9, 129, 22, 39, 253, 19, 98, 108, 110, 79, 113, 224, 232, 178, 185, 112, 104, 218, 246, 97, 228, 251, 34, 242, 193, 238, 210, 144, 12, 191, 179, 162, 241, 81, 51, 145, 235, 249, 14, 239, 107, 49, 192, 214, 31, 181, 199, 106, 157, 184, 84, 204, 176, 115, 121, 50, 45, 127, 4, 150, 254, 138, 236, 205, 93, 222, 114, 67, 29, 24, 72, 243, 141, 128, 195, 78, 66, 215, 61, 156, 180 };
            SimplexNoise.perm = new short[512];
            SimplexNoise.permMod12 = new short[512];
            for (int i = 0; i < 512; ++i) {
                SimplexNoise.perm[i] = SimplexNoise.p[i & 0xFF];
                SimplexNoise.permMod12[i] = (short)(SimplexNoise.perm[i] % 12);
            }
        }
        
        private static class Grad
        {
            float x;
            float y;
            float z;
            
            Grad(final float x, final float y, final float z) {
                this.x = x;
                this.y = y;
                this.z = z;
            }
        }
    }
}
