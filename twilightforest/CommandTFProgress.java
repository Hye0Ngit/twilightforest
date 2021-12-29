// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.server.MinecraftServer;
import java.util.List;
import net.minecraft.stats.StatBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.command.ICommand;
import net.minecraft.command.WrongUsageException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;

public class CommandTFProgress extends CommandBase
{
    String[] bosses;
    
    public CommandTFProgress() {
        this.bosses = new String[] { "none", "naga", "lich", "mooshroom", "hydra", "knights", "urghast", "yeti", "snowqueen", "giants", "final" };
    }
    
    public String func_71517_b() {
        return "tfprogress";
    }
    
    public String func_71518_a(final ICommandSender sender) {
        return "tfprogress <player> <boss>";
    }
    
    public int func_82362_a() {
        return 2;
    }
    
    public void func_71515_b(final ICommandSender sender, final String[] args) {
        if (args.length < 2) {
            throw new WrongUsageException("tfprogress <player> <boss>", new Object[0]);
        }
        final EntityPlayerMP player = func_82359_c(sender, args[0]);
        final int bossIndex = this.getBossIndex(args[1]);
        func_152373_a(sender, (ICommand)this, "Setting player %s progress to past boss %s.", new Object[] { player.func_70005_c_(), this.bosses[bossIndex] });
        this.setProgress(player, bossIndex);
    }
    
    private void setProgress(final EntityPlayerMP player, final int bossIndex) {
        if (bossIndex > 0) {
            for (int i = 0; i < bossIndex; ++i) {
                this.setProgress(player, i);
            }
        }
        switch (bossIndex) {
            case 1: {
                player.func_71029_a((StatBase)TFAchievementPage.twilightPortal);
                player.func_71029_a((StatBase)TFAchievementPage.twilightArrival);
                player.func_71029_a((StatBase)TFAchievementPage.twilightHunter);
                player.func_71029_a((StatBase)TFAchievementPage.twilightKillNaga);
                player.func_71029_a((StatBase)TFAchievementPage.twilightProgressNaga);
                break;
            }
            case 2: {
                player.func_71029_a((StatBase)TFAchievementPage.twilightKillLich);
                player.func_71029_a((StatBase)TFAchievementPage.twilightProgressLich);
                break;
            }
            case 3: {
                player.func_71029_a((StatBase)TFAchievementPage.twilightProgressLabyrinth);
                break;
            }
            case 4: {
                player.func_71029_a((StatBase)TFAchievementPage.twilightKillHydra);
                player.func_71029_a((StatBase)TFAchievementPage.twilightProgressHydra);
                break;
            }
            case 5: {
                player.func_71029_a((StatBase)TFAchievementPage.twilightProgressTrophyPedestal);
                player.func_71029_a((StatBase)TFAchievementPage.twilightProgressKnights);
                break;
            }
            case 6: {
                player.func_71029_a((StatBase)TFAchievementPage.twilightProgressUrghast);
                break;
            }
            case 7: {
                player.func_71029_a((StatBase)TFAchievementPage.twilightProgressYeti);
                break;
            }
            case 8: {
                player.func_71029_a((StatBase)TFAchievementPage.twilightProgressGlacier);
                break;
            }
            case 9: {
                player.func_71029_a((StatBase)TFAchievementPage.twilightProgressTroll);
                break;
            }
            case 10: {
                player.func_71029_a((StatBase)TFAchievementPage.twilightProgressThorns);
                player.func_71029_a((StatBase)TFAchievementPage.twilightProgressCastle);
                break;
            }
        }
    }
    
    private int getBossIndex(final String string) {
        for (int i = 0; i < this.bosses.length; ++i) {
            if (this.bosses[i].equalsIgnoreCase(string)) {
                return i;
            }
        }
        return 0;
    }
    
    public List func_71516_a(final ICommandSender p_71516_1_, final String[] args) {
        return (args.length == 1) ? func_71530_a(args, this.getListOfPlayers()) : ((args.length == 2) ? func_71530_a(args, this.bosses) : null);
    }
    
    protected String[] getListOfPlayers() {
        return MinecraftServer.func_71276_C().func_71213_z();
    }
    
    public boolean func_82358_a(final String[] p_82358_1_, final int p_82358_2_) {
        return p_82358_2_ == 0;
    }
}
