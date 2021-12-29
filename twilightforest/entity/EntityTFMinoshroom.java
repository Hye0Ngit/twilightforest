// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.world.World;

public class EntityTFMinoshroom extends EntityTFMinotaur
{
    public EntityTFMinoshroom(final World par1World) {
        super(par1World);
        this.field_70750_az = "/mods/twilightforest/textures/model/minoshroomtaur.png";
        this.func_70105_a(1.49f, 2.9f);
        this.field_70728_aV = 100;
        this.func_70062_b(0, new ItemStack(TFItems.minotaurAxe));
        this.field_82174_bp[0] = 1.0f;
    }
    
    @Override
    public int func_70667_aM() {
        return 120;
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
}
