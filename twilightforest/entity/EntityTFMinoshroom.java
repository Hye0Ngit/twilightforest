// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.World;

public class EntityTFMinoshroom extends EntityTFMinotaur
{
    public EntityTFMinoshroom(final World par1World) {
        super(par1World);
        this.func_70105_a(1.49f, 2.9f);
        this.field_70728_aV = 100;
        this.func_70062_b(0, new ItemStack(TFItems.minotaurAxe));
        this.field_82174_bp[0] = 0.0f;
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(120.0);
    }
    
    @Override
    protected int func_70633_aT() {
        return TFItems.meefStroganoff.field_77779_bT;
    }
    
    @Override
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int numDrops = this.field_70146_Z.nextInt(4) + 2 + this.field_70146_Z.nextInt(1 + par2), i = 0; i < numDrops; ++i) {
            this.func_70025_b(TFItems.meefStroganoff.field_77779_bT, 1);
        }
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    protected void func_82160_b(final boolean par1, final int par2) {
        super.func_82160_b(par1, par2);
        this.func_70099_a(new ItemStack(TFItems.minotaurAxe), 0.0f);
    }
}
