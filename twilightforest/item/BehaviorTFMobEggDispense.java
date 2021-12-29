// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemStack;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;

public class BehaviorTFMobEggDispense extends BehaviorDefaultDispenseItem
{
    final MinecraftServer mcServer;
    
    public BehaviorTFMobEggDispense(final MinecraftServer par1) {
        this.mcServer = par1;
    }
    
    public ItemStack func_82487_b(final IBlockSource par1IBlockSource, final ItemStack par2ItemStack) {
        final EnumFacing facing = EnumFacing.func_82600_a(par1IBlockSource.func_82620_h());
        final double x = par1IBlockSource.func_82615_a() + facing.func_82601_c();
        final double y = par1IBlockSource.func_82622_e() + 0.2f;
        final double z = par1IBlockSource.func_82616_c() + facing.func_82599_e();
        ItemTFSpawnEgg.func_77840_a(par1IBlockSource.func_82618_k(), par2ItemStack.func_77960_j(), x, y, z);
        par2ItemStack.func_77979_a(1);
        return par2ItemStack;
    }
}
