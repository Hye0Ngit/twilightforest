// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.EnumAction;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldServer;
import java.util.UUID;
import twilightforest.entity.EntityTFCubeOfAnnihilation;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.IItemPropertyGetter;
import twilightforest.TwilightForestMod;
import net.minecraft.item.EnumRarity;

public class ItemTFCubeOfAnnihilation extends ItemTF
{
    private static final String THROWN_UUID_KEY = "cubeEntity";
    
    protected ItemTFCubeOfAnnihilation(final EnumRarity rarity) {
        super(rarity);
        this.field_77777_bU = 1;
        this.func_185043_a(TwilightForestMod.prefix("thrown"), (IItemPropertyGetter)new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float func_185085_a(final ItemStack stack, @Nullable final World worldIn, @Nullable final EntityLivingBase entityIn) {
                return (getThrownUuid(stack) != null) ? 1.0f : 0.0f;
            }
        });
    }
    
    public void func_77663_a(final ItemStack stack, final World world, final Entity holder, final int slot, final boolean isSelected) {
        if (!world.field_72995_K && getThrownUuid(stack) != null && getThrownEntity(world, stack) == null) {
            stack.func_77978_p().func_82580_o("cubeEntityMost");
            stack.func_77978_p().func_82580_o("cubeEntityLeast");
        }
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final EntityPlayer player, final EnumHand hand) {
        final ItemStack stack = player.func_184586_b(hand);
        if (getThrownUuid(stack) != null) {
            return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.PASS, (Object)stack);
        }
        if (!world.field_72995_K) {
            final EntityTFCubeOfAnnihilation launchedCube = new EntityTFCubeOfAnnihilation(world, (EntityLivingBase)player);
            world.func_72838_d((Entity)launchedCube);
            setThrownEntity(stack, launchedCube);
        }
        player.func_184598_c(hand);
        return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.SUCCESS, (Object)stack);
    }
    
    @Nullable
    private static UUID getThrownUuid(final ItemStack stack) {
        if (stack.func_77942_o() && stack.func_77978_p().func_186855_b("cubeEntity")) {
            return stack.func_77978_p().func_186857_a("cubeEntity");
        }
        return null;
    }
    
    @Nullable
    private static EntityTFCubeOfAnnihilation getThrownEntity(final World world, final ItemStack stack) {
        if (world instanceof WorldServer) {
            final UUID id = getThrownUuid(stack);
            if (id != null) {
                final Entity e = ((WorldServer)world).func_175733_a(id);
                if (e instanceof EntityTFCubeOfAnnihilation) {
                    return (EntityTFCubeOfAnnihilation)e;
                }
            }
        }
        return null;
    }
    
    private static void setThrownEntity(final ItemStack stack, final EntityTFCubeOfAnnihilation cube) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new NBTTagCompound());
        }
        stack.func_77978_p().func_186854_a("cubeEntity", cube.func_110124_au());
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 72000;
    }
    
    public EnumAction func_77661_b(final ItemStack stack) {
        return EnumAction.BLOCK;
    }
    
    public boolean canDisableShield(final ItemStack stack, final ItemStack shield, final EntityLivingBase entity, final EntityLivingBase attacker) {
        return true;
    }
}
