// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class TFEnchantment extends yt
{
    public static final yt reactFire;
    
    protected TFEnchantment(final int par1, final int par2, final yu par3EnumEnchantmentType) {
        super(par1, par2, par3EnumEnchantmentType);
    }
    
    public static int getReactFireLevel(final si par0InventoryPlayer, final mg par1DamageSource) {
        int modifier = 0;
        for (int i = 0; i < par0InventoryPlayer.b.length; ++i) {
            final wg armor = par0InventoryPlayer.b[i];
            if (armor != null && armor.x()) {
                final int level = yv.a(TFEnchantment.reactFire.z, armor);
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
