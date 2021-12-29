// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class ItemTFMinotaurAxe extends un
{
    private static final int BONUS_CHARGING_DAMAGE = 7;
    private lq bonusDamageEntity;
    private qx bonusDamagePlayer;
    private int myDamageVsEntity;
    
    protected ItemTFMinotaurAxe(final int par1, final uq par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.myDamageVsEntity = 4 + par2EnumToolMaterial.c();
        this.a((tj)TFItems.creativeTab);
    }
    
    public String getTextureFile() {
        return "/twilightforest/items.png";
    }
    
    public void a(final int par1, final tj par2CreativeTabs, final List par3List) {
        final ur istack = new ur(par1, 1, 0);
        par3List.add(istack);
    }
    
    public boolean onLeftClickEntity(final ur stack, final qx player, final lq entity) {
        if (player.ai()) {
            this.bonusDamageEntity = entity;
            this.bonusDamagePlayer = player;
        }
        return false;
    }
    
    public int a(final lq par1Entity) {
        if (this.bonusDamagePlayer != null && this.bonusDamageEntity != null && par1Entity == this.bonusDamageEntity) {
            this.bonusDamagePlayer.c(par1Entity);
            this.bonusDamagePlayer = null;
            this.bonusDamageEntity = null;
            return this.myDamageVsEntity + 7;
        }
        return this.myDamageVsEntity;
    }
    
    public int c() {
        return uq.e.e();
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ur par1ItemStack, final qx par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add("Extra charge damage");
    }
}
