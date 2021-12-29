// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;

public class HugeMushroomUtil
{
    public static BlockState getState(final HugeMushroomType type, final BlockState base) {
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)base.m_61124_((Property)HugeMushroomBlock.f_54131_, (Comparable)type.top)).m_61124_((Property)HugeMushroomBlock.f_54132_, (Comparable)type.bottom)).m_61124_((Property)HugeMushroomBlock.f_54127_, (Comparable)type.north)).m_61124_((Property)HugeMushroomBlock.f_54129_, (Comparable)type.south)).m_61124_((Property)HugeMushroomBlock.f_54128_, (Comparable)type.east)).m_61124_((Property)HugeMushroomBlock.f_54130_, (Comparable)type.west);
    }
    
    public enum HugeMushroomType
    {
        CENTER(true, false, false, false, false, false), 
        NORTH(true, false, true, false, false, false), 
        SOUTH(true, false, false, true, false, false), 
        EAST(true, false, false, false, true, false), 
        WEST(true, false, false, false, false, true), 
        NORTH_WEST(true, false, true, false, false, true), 
        NORTH_EAST(true, false, true, false, true, false), 
        SOUTH_WEST(true, false, false, true, false, true), 
        SOUTH_EAST(true, false, false, true, true, false);
        
        private final boolean top;
        private final boolean bottom;
        private final boolean north;
        private final boolean south;
        private final boolean east;
        private final boolean west;
        
        private HugeMushroomType(final boolean t, final boolean b, final boolean n, final boolean s, final boolean e, final boolean w) {
            this.top = t;
            this.bottom = b;
            this.north = n;
            this.south = s;
            this.east = e;
            this.west = w;
        }
    }
}
