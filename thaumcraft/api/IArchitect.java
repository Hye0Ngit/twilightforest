// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api;

import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;

public interface IArchitect
{
    ArrayList<BlockCoordinates> getArchitectBlocks(final ItemStack p0, final World p1, final int p2, final int p3, final int p4, final int p5, final EntityPlayer p6);
    
    boolean showAxis(final ItemStack p0, final World p1, final EntityPlayer p2, final int p3, final EnumAxis p4);
    
    public enum EnumAxis
    {
        X, 
        Y, 
        Z;
    }
}
