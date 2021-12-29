// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class TFEnchantment extends xc
{
    public static final xc reactFire;
    
    protected TFEnchantment(final int par1, final int par2, final xd par3EnumEnchantmentType) {
        super(par1, par2, par3EnumEnchantmentType);
    }
    
    public static int getReactFireLevel(final qw par0InventoryPlayer, final lh par1DamageSource) {
        int modifier = 0;
        for (int i = 0; i < par0InventoryPlayer.b.length; ++i) {
            final ur armor = par0InventoryPlayer.b[i];
            if (armor != null && armor.w()) {
                final int level = xe.a(TFEnchantment.reactFire.z, armor);
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
