// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.UseAction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.server.ServerWorld;
import javax.annotation.Nullable;
import java.util.UUID;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import twilightforest.entity.CubeOfAnnihilationEntity;
import twilightforest.entity.TFEntities;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

public class CubeOfAnnihilationItem extends Item
{
    private static final String THROWN_UUID_KEY = "cubeEntity";
    
    protected CubeOfAnnihilationItem(final Item.Properties props) {
        super(props);
    }
    
    public void func_77663_a(final ItemStack stack, final World world, final Entity holder, final int slot, final boolean isSelected) {
        if (!world.field_72995_K && getThrownUuid(stack) != null && getThrownEntity(world, stack) == null) {
            stack.func_77978_p().func_82580_o("cubeEntity");
        }
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, final Hand hand) {
        final ItemStack stack = player.func_184586_b(hand);
        if (getThrownUuid(stack) != null) {
            return (ActionResult<ItemStack>)new ActionResult(ActionResultType.PASS, (Object)stack);
        }
        if (!world.field_72995_K) {
            final CubeOfAnnihilationEntity launchedCube = new CubeOfAnnihilationEntity(TFEntities.cube_of_annihilation, world, (LivingEntity)player);
            world.func_217376_c((Entity)launchedCube);
            setThrownEntity(stack, launchedCube);
        }
        player.func_184598_c(hand);
        return (ActionResult<ItemStack>)new ActionResult(ActionResultType.SUCCESS, (Object)stack);
    }
    
    @Nullable
    protected static UUID getThrownUuid(final ItemStack stack) {
        if (stack.func_77942_o() && stack.func_77978_p().func_186855_b("cubeEntity")) {
            return stack.func_77978_p().func_186857_a("cubeEntity");
        }
        return null;
    }
    
    @Nullable
    private static CubeOfAnnihilationEntity getThrownEntity(final World world, final ItemStack stack) {
        if (world instanceof ServerWorld) {
            final UUID id = getThrownUuid(stack);
            if (id != null) {
                final Entity e = ((ServerWorld)world).func_217461_a(id);
                if (e instanceof CubeOfAnnihilationEntity) {
                    return (CubeOfAnnihilationEntity)e;
                }
            }
        }
        return null;
    }
    
    private static void setThrownEntity(final ItemStack stack, final CubeOfAnnihilationEntity cube) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundNBT());
        }
        stack.func_77978_p().func_186854_a("cubeEntity", cube.func_110124_au());
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 72000;
    }
    
    public UseAction func_77661_b(final ItemStack stack) {
        return UseAction.BLOCK;
    }
    
    public boolean canDisableShield(final ItemStack stack, final ItemStack shield, final LivingEntity entity, final LivingEntity attacker) {
        return true;
    }
}
