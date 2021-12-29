// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.state.Property;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.block.BlockState;

public class MushroomUtil
{
    public static BlockState getState(final Type type, final BlockState base) {
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)base.func_206870_a((Property)HugeMushroomBlock.field_196465_z, (Comparable)type.top)).func_206870_a((Property)HugeMushroomBlock.field_196460_A, (Comparable)type.bottom)).func_206870_a((Property)HugeMushroomBlock.field_196459_a, (Comparable)type.north)).func_206870_a((Property)HugeMushroomBlock.field_196463_c, (Comparable)type.south)).func_206870_a((Property)HugeMushroomBlock.field_196461_b, (Comparable)type.east)).func_206870_a((Property)HugeMushroomBlock.field_196464_y, (Comparable)type.west);
    }
    
    public enum Type
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
        
        private boolean top;
        private boolean bottom;
        private boolean north;
        private boolean south;
        private boolean east;
        private boolean west;
        
        private Type(final boolean t, final boolean b, final boolean n, final boolean s, final boolean e, final boolean w) {
            this.top = t;
            this.bottom = b;
            this.north = n;
            this.south = s;
            this.east = e;
            this.west = w;
        }
    }
}
