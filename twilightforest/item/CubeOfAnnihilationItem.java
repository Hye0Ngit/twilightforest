// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import javax.annotation.Nullable;
import java.util.UUID;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.CubeOfAnnihilation;
import twilightforest.entity.TFEntities;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class CubeOfAnnihilationItem extends Item
{
    private static final String THROWN_UUID_KEY = "cubeEntity";
    
    protected CubeOfAnnihilationItem(final Item.Properties props) {
        super(props);
    }
    
    public void m_6883_(final ItemStack stack, final Level world, final Entity holder, final int slot, final boolean isSelected) {
        if (!world.f_46443_ && getThrownUuid(stack) != null && getThrownEntity(world, stack) == null) {
            stack.m_41783_().m_128473_("cubeEntity");
        }
    }
    
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, final InteractionHand hand) {
        final ItemStack stack = player.m_21120_(hand);
        if (getThrownUuid(stack) != null) {
            return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.PASS, (Object)stack);
        }
        if (!world.f_46443_) {
            final CubeOfAnnihilation launchedCube = new CubeOfAnnihilation(TFEntities.CUBE_OF_ANNIHILATION, world, (LivingEntity)player);
            world.m_7967_((Entity)launchedCube);
            setThrownEntity(stack, launchedCube);
        }
        player.m_6672_(hand);
        return (InteractionResultHolder<ItemStack>)new InteractionResultHolder(InteractionResult.SUCCESS, (Object)stack);
    }
    
    @Nullable
    protected static UUID getThrownUuid(final ItemStack stack) {
        if (stack.m_41782_() && stack.m_41783_().m_128403_("cubeEntity")) {
            return stack.m_41783_().m_128342_("cubeEntity");
        }
        return null;
    }
    
    @Nullable
    private static CubeOfAnnihilation getThrownEntity(final Level world, final ItemStack stack) {
        if (world instanceof ServerLevel) {
            final UUID id = getThrownUuid(stack);
            if (id != null) {
                final Entity e = ((ServerLevel)world).m_8791_(id);
                if (e instanceof final CubeOfAnnihilation cubeOfAnnihilation) {
                    return cubeOfAnnihilation;
                }
            }
        }
        return null;
    }
    
    private static void setThrownEntity(final ItemStack stack, final CubeOfAnnihilation cube) {
        if (!stack.m_41782_()) {
            stack.m_41751_(new CompoundTag());
        }
        stack.m_41783_().m_128362_("cubeEntity", cube.m_142081_());
    }
    
    public int m_8105_(final ItemStack stack) {
        return 72000;
    }
    
    public UseAnim m_6164_(final ItemStack stack) {
        return UseAnim.BLOCK;
    }
    
    public boolean canDisableShield(final ItemStack stack, final ItemStack shield, final LivingEntity entity, final LivingEntity attacker) {
        return true;
    }
}
