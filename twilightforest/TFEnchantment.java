// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class TFEnchantment extends aat
{
    public static final aat reactFire;
    
    protected TFEnchantment(final int par1, final int par2, final aau par3EnumEnchantmentType) {
        super(par1, par2, par3EnumEnchantmentType);
    }
    
    public static int getReactFireLevel(final uc par0InventoryPlayer, final na par1DamageSource) {
        int modifier = 0;
        for (int i = 0; i < par0InventoryPlayer.b.length; ++i) {
            final yd armor = par0InventoryPlayer.b[i];
            if (armor != null && armor.y()) {
                final int level = aav.a(TFEnchantment.reactFire.z, armor);
                if (level > 0) {
                    modifier += (6 + level * level) / 2;
                }
            }
        }
        return modifier;
    }
    
    static {
        reactFire = new EnchantmentTFFireReact(TwilightForestMod.idEnchantmentFieryAura, 2);
    }
}
