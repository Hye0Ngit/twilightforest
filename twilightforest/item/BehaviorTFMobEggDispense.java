// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.server.MinecraftServer;

public class BehaviorTFMobEggDispense extends bb
{
    final MinecraftServer mcServer;
    
    public BehaviorTFMobEggDispense(final MinecraftServer par1) {
        this.mcServer = par1;
    }
    
    public wg b(final az par1IBlockSource, final wg par2ItemStack) {
        final bf facing = bf.a(par1IBlockSource.h());
        final double x = par1IBlockSource.a() + facing.c();
        final double y = par1IBlockSource.e() + 0.2f;
        final double z = par1IBlockSource.c() + facing.e();
        ItemTFSpawnEgg.spawnCreature(par1IBlockSource.k(), par2ItemStack.k(), x, y, z);
        par2ItemStack.a(1);
        return par2ItemStack;
    }
}
