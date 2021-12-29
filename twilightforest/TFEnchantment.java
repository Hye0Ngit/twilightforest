// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class TFEnchantment extends ww
{
    public static final ww reactFire;
    
    protected TFEnchantment(final int par1, final int par2, final wx par3EnumEnchantmentType) {
        super(par1, par2, par3EnumEnchantmentType);
    }
    
    public static int getReactFireLevel(final qw par0InventoryPlayer, final lh par1DamageSource) {
        int modifier = 0;
        for (int i = 0; i < par0InventoryPlayer.b.length; ++i) {
            final um armor = par0InventoryPlayer.b[i];
            if (armor != null && armor.w()) {
                final int level = wy.a(TFEnchantment.reactFire.x, armor);
                if (level > 0) {
                    modifier += (6 + level * level) / 2;
                }
            }
        }
        return modifier;
    }
    
    static {
        reactFire = new EnchantmentTFFireReact(136, 2);
    }
}
