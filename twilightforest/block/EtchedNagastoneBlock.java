// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import javax.annotation.Nullable;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.DirectionalBlock;

public class EtchedNagastoneBlock extends DirectionalBlock
{
    protected EtchedNagastoneBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)EtchedNagastoneBlock.field_176387_N, (Comparable)Direction.DOWN));
    }
    
    @Nullable
    public BlockState func_196258_a(final BlockItemUseContext context) {
        return (BlockState)this.func_176223_P().func_206870_a((Property)EtchedNagastoneBlock.field_176387_N, (Comparable)((context.func_195999_j() != null && context.func_195999_j().func_225608_bj_()) ? context.func_196010_d().func_176734_d() : context.func_196010_d()));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)EtchedNagastoneBlock.field_176387_N });
    }
    
    public BlockState func_185499_a(final BlockState state, final Rotation rot) {
        return (BlockState)state.func_206870_a((Property)EtchedNagastoneBlock.field_176387_N, (Comparable)rot.func_185831_a((Direction)state.func_177229_b((Property)EtchedNagastoneBlock.field_176387_N)));
    }
    
    public BlockState func_185471_a(final BlockState state, final Mirror mirrorIn) {
        return (BlockState)state.func_206870_a((Property)EtchedNagastoneBlock.field_176387_N, (Comparable)mirrorIn.func_185803_b((Direction)state.func_177229_b((Property)EtchedNagastoneBlock.field_176387_N)));
    }
}
