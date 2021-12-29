// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.server.MinecraftServer;

public class BehaviorTFMobEggDispense extends bg
{
    final MinecraftServer mcServer;
    
    public BehaviorTFMobEggDispense(final MinecraftServer par1) {
        this.mcServer = par1;
    }
    
    public yd b(final be par1IBlockSource, final yd par2ItemStack) {
        final bk facing = bk.a(par1IBlockSource.h());
        final double x = par1IBlockSource.a() + facing.c();
        final double y = par1IBlockSource.e() + 0.2f;
        final double z = par1IBlockSource.c() + facing.e();
        ItemTFSpawnEgg.a(par1IBlockSource.k(), par2ItemStack.k(), x, y, z);
        par2ItemStack.a(1);
        return par2ItemStack;
    }
}
