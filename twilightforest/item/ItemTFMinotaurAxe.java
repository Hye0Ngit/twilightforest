// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class ItemTFMinotaurAxe extends xz
{
    private static final int BONUS_CHARGING_DAMAGE = 7;
    private nm bonusDamageEntity;
    private ue bonusDamagePlayer;
    
    protected ItemTFMinotaurAxe(final int par1, final yc par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.d = 4.0f + par2EnumToolMaterial.c();
        this.a((wv)TFItems.creativeTab);
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        final yd istack = new yd(par1, 1, 0);
        par3List.add(istack);
    }
    
    public boolean onLeftClickEntity(final yd stack, final ue player, final nm entity) {
        if (player.ah()) {
            this.bonusDamageEntity = entity;
            this.bonusDamagePlayer = player;
        }
        return false;
    }
    
    public float getDamageVsEntity(final nm par1Entity, final yd itemStack) {
        if (this.bonusDamagePlayer != null && this.bonusDamageEntity != null && par1Entity == this.bonusDamageEntity) {
            this.bonusDamagePlayer.c(par1Entity);
            this.bonusDamagePlayer = null;
            this.bonusDamageEntity = null;
            return this.d + 7.0f;
        }
        return this.d;
    }
    
    public int c() {
        return yc.e.e();
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final yd par1ItemStack, final ue par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(bt.a(this.a() + ".tooltip"));
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
