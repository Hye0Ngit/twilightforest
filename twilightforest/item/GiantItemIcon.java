// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.IIcon;

public class GiantItemIcon implements IIcon
{
    private IIcon baseIcon;
    private float myX;
    private float myY;
    
    public GiantItemIcon(final IIcon blockIcon, final float x, final float y) {
        this.baseIcon = blockIcon;
        this.myX = x;
        this.myY = y;
    }
    
    public int func_94211_a() {
        return this.baseIcon.func_94211_a() / 2;
    }
    
    public int func_94216_b() {
        return this.baseIcon.func_94216_b() / 2;
    }
    
    public float func_94209_e() {
        final float f = this.baseIcon.func_94212_f() - this.baseIcon.func_94209_e();
        return this.baseIcon.func_94209_e() + f * this.myX;
    }
    
    public float func_94212_f() {
        final float f = this.baseIcon.func_94212_f() - this.baseIcon.func_94209_e();
        return this.baseIcon.func_94209_e() + f * (this.myX + 0.5f);
    }
    
    public float func_94214_a(final double par1) {
        final float f = this.func_94212_f() - this.func_94209_e();
        return this.func_94209_e() + f * (float)par1 / 16.0f;
    }
    
    public float func_94206_g() {
        final float f = this.baseIcon.func_94210_h() - this.baseIcon.func_94206_g();
        return this.baseIcon.func_94206_g() + f * this.myY;
    }
    
    public float func_94210_h() {
        final float f = this.baseIcon.func_94210_h() - this.baseIcon.func_94206_g();
        return this.baseIcon.func_94206_g() + f * (this.myY + 0.5f);
    }
    
    public float func_94207_b(final double par1) {
        final float f = this.func_94210_h() - this.func_94206_g();
        return this.func_94206_g() + f * ((float)par1 / 16.0f);
    }
    
    public String func_94215_i() {
        return this.baseIcon.func_94215_i();
    }
}
