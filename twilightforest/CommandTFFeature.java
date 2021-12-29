// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.util.ChunkCoordinates;
import twilightforest.world.ChunkProviderTwilightForest;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ChatComponentTranslation;
import twilightforest.world.TFWorldChunkManager;
import net.minecraft.command.WrongUsageException;
import twilightforest.world.WorldProviderTwilightForest;
import net.minecraft.util.MathHelper;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;

public class CommandTFFeature extends CommandBase
{
    public String func_71517_b() {
        return "tffeature";
    }
    
    public String func_71518_a(final ICommandSender sender) {
        return "tffeature accepts the following arguments: info";
    }
    
    public void func_71515_b(final ICommandSender sender, final String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("info")) {
                final EntityPlayerMP player = func_71521_c(sender);
                final int dx = MathHelper.func_76128_c(player.field_70165_t);
                final int dy = MathHelper.func_76128_c(player.field_70163_u);
                final int dz = MathHelper.func_76128_c(player.field_70161_v);
                if (!(player.field_70170_p.field_73011_w instanceof WorldProviderTwilightForest)) {
                    throw new WrongUsageException("commands.tffeature.not_in_twilight_forest", new Object[0]);
                }
                final TFFeature nearbyFeature = ((TFWorldChunkManager)player.field_70170_p.field_73011_w.field_76578_c).getFeatureAt(dx, dz, player.field_70170_p);
                sender.func_145747_a((IChatComponent)new ChatComponentTranslation("The nearest feature is %s", new Object[] { nearbyFeature.name }));
                final ChunkProviderTwilightForest chunkProvider = ((WorldProviderTwilightForest)player.field_70170_p.field_73011_w).getChunkProvider();
                if (chunkProvider.isBlockInStructureBB(dx, dy, dz)) {
                    sender.func_145747_a((IChatComponent)new ChatComponentTranslation("You are in the structure for that feature.", new Object[0]));
                    sender.func_145747_a((IChatComponent)new ChatComponentTranslation("Structure conquer flag = %s.", new Object[] { chunkProvider.isStructureConquered(dx, dy, dz) }));
                }
                else {
                    sender.func_145747_a((IChatComponent)new ChatComponentTranslation("You are not in the structure for that feature.", new Object[0]));
                }
            }
            else if (args[0].equalsIgnoreCase("reactivate")) {
                this.changeStructureActivity(sender, false);
            }
            else if (args[0].equalsIgnoreCase("conquer")) {
                this.changeStructureActivity(sender, true);
            }
            else {
                if (!args[0].equalsIgnoreCase("center")) {
                    throw new WrongUsageException("commands.tffeature.usage", new Object[0]);
                }
                final EntityPlayerMP player = func_71521_c(sender);
                final int dx = MathHelper.func_76128_c(player.field_70165_t);
                final int dz2 = MathHelper.func_76128_c(player.field_70161_v);
                final ChunkCoordinates cc = TFFeature.getNearestCenterXYZ(dx >> 4, dz2 >> 4, player.field_70170_p);
                final TFWorldChunkManager wcm = (TFWorldChunkManager)player.field_70170_p.field_73011_w.field_76578_c;
                final boolean fc = wcm.isInFeatureChunk(player.field_70170_p, dx, dz2);
                sender.func_145747_a((IChatComponent)new ChatComponentTranslation("Center of feature = %s.", new Object[] { cc }));
                sender.func_145747_a((IChatComponent)new ChatComponentTranslation("Are in feature chunk = %s.", new Object[] { fc }));
            }
            return;
        }
        throw new WrongUsageException("commands.tffeature.usage", new Object[0]);
    }
    
    private void changeStructureActivity(final ICommandSender sender, final boolean flag) throws WrongUsageException {
        final EntityPlayerMP player = func_71521_c(sender);
        final int dx = MathHelper.func_76128_c(player.field_70165_t);
        final int dy = MathHelper.func_76128_c(player.field_70163_u);
        final int dz = MathHelper.func_76128_c(player.field_70161_v);
        if (!(player.field_70170_p.field_73011_w instanceof WorldProviderTwilightForest)) {
            throw new WrongUsageException("commands.tffeature.not_in_twilight_forest", new Object[0]);
        }
        final ChunkProviderTwilightForest chunkProvider = ((WorldProviderTwilightForest)player.field_70170_p.field_73011_w).getChunkProvider();
        if (chunkProvider.isBlockInStructureBB(dx, dy, dz)) {
            sender.func_145747_a((IChatComponent)new ChatComponentTranslation("Structure conquer flag was %s.  Changing to %s.", new Object[] { chunkProvider.isStructureConquered(dx, dy, dz), flag }));
            chunkProvider.setStructureConquered(dx, dy, dz, flag);
        }
        else {
            sender.func_145747_a((IChatComponent)new ChatComponentTranslation("You are not in a structure.", new Object[0]));
        }
    }
}
