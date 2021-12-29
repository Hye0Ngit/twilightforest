// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.MathHelper;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.ICommand;
import net.minecraft.command.CommandBase;

public class CommandTFLocate extends CommandBase implements ICommand
{
    public String func_71517_b() {
        return "tflocate";
    }
    
    public void func_71515_b(final ICommandSender var1, final String[] var2) {
        final EntityPlayerMP player = func_71521_c(var1);
        final IChunkProvider provider = player.field_70170_p.func_72863_F();
        System.out.println("Got chunk provider " + provider);
        final int dx = MathHelper.func_76128_c(player.field_70165_t);
        final int dy = MathHelper.func_76128_c(player.field_70163_u);
        final int dz = MathHelper.func_76128_c(player.field_70161_v);
        final List<SpawnListEntry> possibleMonsters = provider.func_73155_a(EnumCreatureType.monster, dx, dy, dz);
        if (possibleMonsters != null) {
            for (final SpawnListEntry entry : possibleMonsters) {
                System.out.println("Finding monster " + entry.field_76300_b);
            }
        }
        else {
            System.out.println("No monsters!");
        }
    }
    
    public String func_71518_a(final ICommandSender icommandsender) {
        return null;
    }
}
