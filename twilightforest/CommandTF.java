// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import twilightforest.capabilities.CapabilityList;
import twilightforest.capabilities.shield.IShieldCapability;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.ImmutableList;
import twilightforest.world.ChunkGeneratorTFBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.entity.Entity;
import twilightforest.world.TFWorld;
import net.minecraft.command.CommandException;
import net.minecraft.command.WrongUsageException;
import java.util.Collections;
import java.util.Locale;
import java.util.Arrays;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import java.util.List;
import net.minecraft.command.CommandBase;

public class CommandTF extends CommandBase
{
    private static final List<String> aliases;
    
    public List<String> func_71514_a() {
        return CommandTF.aliases;
    }
    
    public String func_71517_b() {
        return "tffeature";
    }
    
    public String func_71518_a(final ICommandSender sender) {
        return "commands.tffeature.usage";
    }
    
    public int func_82362_a() {
        return 2;
    }
    
    public List<String> func_184883_a(final MinecraftServer server, final ICommandSender sender, final String[] args, @Nullable final BlockPos targetPos) {
        if (args.length == 1) {
            return func_71530_a(args, EnumActions.ACTION_LIST);
        }
        if (args.length > 1) {
            try {
                final String[] argsMoved = Arrays.copyOfRange(args, 1, args.length);
                return EnumActions.valueOf(args[0].toUpperCase(Locale.ROOT)).tabCompletion(server, sender, argsMoved, targetPos);
            }
            catch (Throwable e) {
                return Collections.emptyList();
            }
        }
        return Collections.emptyList();
    }
    
    public void func_184881_a(final MinecraftServer server, final ICommandSender sender, final String[] args) throws CommandException {
        if (args.length > 0) {
            try {
                EnumActions.valueOf(args[0].toUpperCase(Locale.ROOT)).execute(server, sender, args);
                return;
            }
            catch (IllegalArgumentException e) {
                throw new WrongUsageException("commands.tffeature.usage", new Object[0]);
            }
            throw new CommandException("commands.tffeature.usage", new Object[0]);
        }
        throw new CommandException("commands.tffeature.usage", new Object[0]);
    }
    
    private static void changeStructureActivity(final ICommandSender sender, final boolean flag) throws CommandException {
        final EntityPlayerMP player = func_71521_c(sender);
        if (!TFWorld.isTwilightForest(player.field_70170_p)) {
            throw new CommandException("commands.tffeature.not_in_twilight_forest", new Object[0]);
        }
        final ChunkGeneratorTFBase chunkGenerator = TFWorld.getChunkGenerator(player.field_70170_p);
        final BlockPos pos = new BlockPos((Entity)player);
        if (chunkGenerator != null && chunkGenerator.isBlockInStructureBB(pos)) {
            sender.func_145747_a((ITextComponent)new TextComponentTranslation("commands.tffeature.structure.conquer.update", new Object[] { chunkGenerator.isStructureConquered(pos), flag }));
            chunkGenerator.setStructureConquered(pos, flag);
            return;
        }
        throw new CommandException("commands.tffeature.structure.required", new Object[0]);
    }
    
    public boolean func_82358_a(final String[] args, final int index) {
        try {
            return EnumActions.valueOf(args[0].toUpperCase(Locale.ROOT)).isUsernameIndex(args, index);
        }
        catch (Throwable t) {
            return false;
        }
    }
    
    static {
        aliases = (List)ImmutableList.of((Object)"tffeature", (Object)"twilightforest", (Object)"tf");
    }
    
    private enum EnumActions
    {
        CENTER {
            @Override
            protected void execute(final MinecraftServer server, final ICommandSender sender, final String[] args) throws CommandException {
                final EntityPlayerMP player = CommandBase.func_71521_c(sender);
                final int dx = MathHelper.func_76128_c(player.field_70165_t);
                final int dz = MathHelper.func_76128_c(player.field_70161_v);
                final BlockPos cc = TFFeature.getNearestCenterXYZ(dx >> 4, dz >> 4, player.field_70170_p);
                final boolean fc = TFFeature.isInFeatureChunk(player.field_70170_p, dx, dz);
                sender.func_145747_a((ITextComponent)new TextComponentTranslation("commands.tffeature.center", new Object[] { cc }));
                sender.func_145747_a((ITextComponent)new TextComponentTranslation("commands.tffeature.chunk", new Object[] { fc }));
            }
        }, 
        CONQUER {
            @Override
            protected void execute(final MinecraftServer server, final ICommandSender sender, final String[] args) throws CommandException {
                changeStructureActivity(sender, true);
            }
        }, 
        INFO {
            @Override
            protected void execute(final MinecraftServer server, final ICommandSender sender, final String[] args) throws CommandException {
                final EntityPlayerMP player = CommandBase.func_71521_c(sender);
                if (!TFWorld.isTwilightForest(player.field_70170_p)) {
                    throw new CommandException("commands.tffeature.not_in_twilight_forest", new Object[0]);
                }
                final BlockPos pos = new BlockPos((Entity)player);
                final TFFeature nearbyFeature = TFFeature.getFeatureAt(pos.func_177958_n(), pos.func_177952_p(), player.field_70170_p);
                sender.func_145747_a((ITextComponent)new TextComponentTranslation("commands.tffeature.nearest", new Object[] { nearbyFeature.name }));
                final ChunkGeneratorTFBase chunkGenerator = TFWorld.getChunkGenerator(player.field_70170_p);
                if (chunkGenerator != null && chunkGenerator.isBlockInStructureBB(pos)) {
                    sender.func_145747_a((ITextComponent)new TextComponentTranslation("commands.tffeature.structure.inside", new Object[0]));
                    sender.func_145747_a((ITextComponent)new TextComponentTranslation("commands.tffeature.structure.conquer.status", new Object[] { chunkGenerator.isStructureConquered(pos) }));
                }
                else {
                    sender.func_145747_a((ITextComponent)new TextComponentTranslation("commands.tffeature.structure.outside", new Object[0]));
                }
            }
        }, 
        LOCATE {
            private final String[] STRUCTURE_LIST;
            
            {
                this.STRUCTURE_LIST = new String[] { TFFeature.SMALL_HILL.name, TFFeature.MEDIUM_HILL.name, TFFeature.LARGE_HILL.name, TFFeature.HEDGE_MAZE.name, TFFeature.NAGA_COURTYARD.name, TFFeature.LICH_TOWER.name, TFFeature.ICE_TOWER.name, TFFeature.QUEST_GROVE.name, TFFeature.HYDRA_LAIR.name, TFFeature.LABYRINTH.name, TFFeature.DARK_TOWER.name, TFFeature.KNIGHT_STRONGHOLD.name, TFFeature.YETI_CAVE.name, TFFeature.TROLL_CAVE.name, TFFeature.FINAL_CASTLE.name, TFFeature.MUSHROOM_TOWER.name };
            }
            
            @Override
            protected void execute(final MinecraftServer server, final ICommandSender sender, final String[] args) throws CommandException {
                if (args.length != 2) {
                    throw new WrongUsageException("commands.tffeature.locate.usage", new Object[0]);
                }
                if (!TFWorld.isTwilightForest(CommandBase.func_71521_c(sender).field_70170_p)) {
                    throw new CommandException("commands.tffeature.not_in_twilight_forest", new Object[0]);
                }
                final String s = args[1];
                BlockPos blockpos = sender.func_130014_f_().func_190528_a(s, sender.func_180425_c(), false);
                if (blockpos != null) {
                    sender.func_145747_a((ITextComponent)new TextComponentTranslation("commands.locate.success", new Object[] { s, blockpos.func_177958_n(), blockpos.func_177952_p() }));
                }
                else {
                    blockpos = sender.func_130014_f_().func_190528_a("twilightforest:" + s, sender.func_180425_c(), false);
                    if (blockpos == null) {
                        throw new CommandException("commands.locate.failure", new Object[] { s });
                    }
                    sender.func_145747_a((ITextComponent)new TextComponentTranslation("commands.locate.success", new Object[] { s, blockpos.func_177958_n(), blockpos.func_177952_p() }));
                }
            }
            
            @Override
            protected List<String> tabCompletion(final MinecraftServer server, final ICommandSender sender, final String[] args, @Nullable final BlockPos targetPos) {
                return (args.length == 1) ? CommandBase.func_71530_a(args, this.STRUCTURE_LIST) : Collections.emptyList();
            }
        }, 
        REACTIVATE {
            @Override
            protected void execute(final MinecraftServer server, final ICommandSender sender, final String[] args) throws CommandException {
                changeStructureActivity(sender, false);
            }
        }, 
        SHIELD {
            @Override
            protected boolean isUsernameIndex(final String[] args, final int index) {
                return index == 1;
            }
            
            @Override
            protected void execute(final MinecraftServer server, final ICommandSender sender, final String[] args) throws CommandException {
                if (args.length < 4) {
                    return;
                }
                final EntityLivingBase entity = (EntityLivingBase)CommandBase.func_184884_a(server, sender, args[1], (Class)EntityLivingBase.class);
                final IShieldCapability cap = (IShieldCapability)entity.getCapability((Capability)CapabilityList.SHIELDS, (EnumFacing)null);
                if (cap != null) {
                    final boolean temp = args.length < 5 || Boolean.parseBoolean(args[4]);
                    if ("set".equals(args[2].toLowerCase(Locale.ROOT))) {
                        cap.setShields(Integer.parseInt(args[3]), temp);
                    }
                    else if ("add".equals(args[2].toLowerCase(Locale.ROOT))) {
                        cap.addShields(Integer.parseInt(args[3]), temp);
                    }
                }
            }
        };
        
        private static final String[] ACTION_LIST;
        
        protected abstract void execute(final MinecraftServer p0, final ICommandSender p1, final String[] p2) throws CommandException;
        
        protected List<String> tabCompletion(final MinecraftServer server, final ICommandSender sender, final String[] args, @Nullable final BlockPos targetPos) {
            return Collections.emptyList();
        }
        
        protected boolean isUsernameIndex(final String[] args, final int index) {
            return false;
        }
        
        static {
            final int length = values().length;
            final String[] list = new String[length];
            for (final EnumActions action : values()) {
                list[action.ordinal()] = action.toString().toLowerCase(Locale.ROOT);
            }
            ACTION_LIST = list;
        }
    }
}
