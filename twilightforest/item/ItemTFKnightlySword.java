// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTFKnightlySword extends zk
{
    private static final int BONUS_DAMAGE = 2;
    private nm bonusDamageEntity;
    private ue bonusDamagePlayer;
    
    public ItemTFKnightlySword(final int par1, final yc par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.a((wv)TFItems.creativeTab);
    }
    
    public yp f(final yd par1ItemStack) {
        return yp.c;
    }
    
    public boolean a(final yd par1ItemStack, final yd par2ItemStack) {
        return par2ItemStack.d == TFItems.knightMetal.cv || super.a(par1ItemStack, par2ItemStack);
    }
    
    public boolean onLeftClickEntity(final yd stack, final ue player, final nm entity) {
        if (entity instanceof oe && ((oe)entity).aP() > 0) {
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
            return super.getDamageVsEntity(par1Entity, itemStack) + 2.0f;
        }
        return super.getDamageVsEntity(par1Entity, itemStack);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final yd par1ItemStack, final ue par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(bt.a(this.a() + ".tooltip"));
    }
}
