// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.IIcon;

public class GiantBlockIcon implements IIcon
{
    private IIcon baseIcon;
    private int myX;
    private int myY;
    
    public GiantBlockIcon(final IIcon blockIcon, final int x, final int y) {
        this.baseIcon = blockIcon;
        this.myX = x;
        this.myY = y;
    }
    
    public int func_94211_a() {
        return this.baseIcon.func_94211_a() / 4;
    }
    
    public int func_94216_b() {
        return this.baseIcon.func_94216_b() / 4;
    }
    
    public float func_94209_e() {
        final float f = this.baseIcon.func_94212_f() - this.baseIcon.func_94209_e();
        return this.baseIcon.func_94209_e() + f * 0.25f * this.myX;
    }
    
    public float func_94212_f() {
        final float f = this.baseIcon.func_94212_f() - this.baseIcon.func_94209_e();
        return this.baseIcon.func_94212_f() - f * 0.25f * (3 - this.myX);
    }
    
    public float func_94214_a(final double par1) {
        final float f = this.func_94212_f() - this.func_94209_e();
        return this.func_94209_e() + f * (float)par1 / 16.0f;
    }
    
    public float func_94206_g() {
        final float f = this.baseIcon.func_94210_h() - this.baseIcon.func_94206_g();
        return this.baseIcon.func_94206_g() + f * 0.25f * this.myY;
    }
    
    public float func_94210_h() {
        final float f = this.baseIcon.func_94210_h() - this.baseIcon.func_94206_g();
        return this.baseIcon.func_94210_h() - f * 0.25f * (3 - this.myY);
    }
    
    public float func_94207_b(final double par1) {
        final float f = this.func_94210_h() - this.func_94206_g();
        return this.func_94206_g() + f * ((float)par1 / 16.0f);
    }
    
    public String func_94215_i() {
        return this.baseIcon.func_94215_i();
    }
}
