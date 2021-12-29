// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class ItemTFMinotaurAxe extends wc
{
    private static final int BONUS_CHARGING_DAMAGE = 7;
    private mp bonusDamageEntity;
    private sk bonusDamagePlayer;
    private int myDamageVsEntity;
    
    protected ItemTFMinotaurAxe(final int par1, final wf par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.myDamageVsEntity = 4 + par2EnumToolMaterial.c();
        this.a((uy)TFItems.creativeTab);
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        final wg istack = new wg(par1, 1, 0);
        par3List.add(istack);
    }
    
    public boolean onLeftClickEntity(final wg stack, final sk player, final mp entity) {
        if (player.ah()) {
            this.bonusDamageEntity = entity;
            this.bonusDamagePlayer = player;
        }
        return false;
    }
    
    public int a(final mp par1Entity) {
        if (this.bonusDamagePlayer != null && this.bonusDamageEntity != null && par1Entity == this.bonusDamageEntity) {
            this.bonusDamagePlayer.c(par1Entity);
            this.bonusDamagePlayer = null;
            this.bonusDamageEntity = null;
            return this.myDamageVsEntity + 7;
        }
        return this.myDamageVsEntity;
    }
    
    public int c() {
        return wf.e.e();
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final wg par1ItemStack, final sk par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add("Extra charge damage");
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
