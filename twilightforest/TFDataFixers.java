// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.nbt.NBTTagCompound;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import net.minecraftforge.common.util.ModFixs;
import net.minecraft.util.datafix.IFixableData;
import net.minecraft.util.datafix.IFixType;
import net.minecraft.util.datafix.FixTypes;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class TFDataFixers
{
    public static final int DATA_FIXER_VERSION = 1;
    
    public static void init() {
        final ModFixs fixes = FMLCommonHandler.instance().getDataFixer().init("twilightforest", 1);
        fixes.registerFix((IFixType)FixTypes.BLOCK_ENTITY, (IFixableData)new NamespaceTEFixer());
        fixes.registerFix((IFixType)FixTypes.STRUCTURE, (IFixableData)new StructureStartIDFixer());
    }
    
    private static class NamespaceTEFixer implements IFixableData
    {
        private final Map<String, String> tileEntityNames;
        
        private NamespaceTEFixer() {
            final ImmutableMap.Builder<String, String> nameMap = (ImmutableMap.Builder<String, String>)ImmutableMap.builder();
            nameMap.put((Object)"minecraft:firefly", (Object)"twilightforest:firefly").put((Object)"minecraft:cicada", (Object)"twilightforest:cicada").put((Object)"minecraft:moonworm", (Object)"twilightforest:moonworm").put((Object)"minecraft:naga_spawner", (Object)"twilightforest:naga_spawner").put((Object)"minecraft:lich_spawner", (Object)"twilightforest:lich_spawner").put((Object)"minecraft:hydra_spawner", (Object)"twilightforest:hydra_spawner").put((Object)"minecraft:smoker", (Object)"twilightforest:smoker").put((Object)"minecraft:popping_jet", (Object)"twilightforest:popping_jet").put((Object)"minecraft:flame_jet", (Object)"twilightforest:flame_jet").put((Object)"minecraft:tower_builder", (Object)"twilightforest:tower_builder").put((Object)"minecraft:tower_reverter", (Object)"twilightforest:tower_reverter").put((Object)"minecraft:trophy", (Object)"twilightforest:trophy").put((Object)"minecraft:tower_boss_spawner", (Object)"twilightforest:tower_boss_spawner").put((Object)"minecraft:ghast_trap_inactive", (Object)"twilightforest:ghast_trap_inactive").put((Object)"minecraft:ghast_trap_active", (Object)"twilightforest:ghast_trap_active").put((Object)"minecraft:carminite_reactor_active", (Object)"twilightforest:carminite_reactor_active").put((Object)"minecraft:knight_phantom_spawner", (Object)"twilightforest:knight_phantom_spawner").put((Object)"minecraft:snow_queen_spawner", (Object)"twilightforest:snow_queen_spawner").put((Object)"minecraft:cinder_furnace", (Object)"twilightforest:cinder_furnace").put((Object)"minecraft:minoshroom_spawner", (Object)"twilightforest:minoshroom_spawner").put((Object)"minecraft:alpha_yeti_spawner", (Object)"twilightforest:alpha_yeti_spawner").put((Object)"firefly", (Object)"twilightforest:firefly").put((Object)"cicada", (Object)"twilightforest:cicada").put((Object)"moonworm", (Object)"twilightforest:moonworm").put((Object)"naga_spawner", (Object)"twilightforest:naga_spawner").put((Object)"lich_spawner", (Object)"twilightforest:lich_spawner").put((Object)"hydra_spawner", (Object)"twilightforest:hydra_spawner").put((Object)"smoker", (Object)"twilightforest:smoker").put((Object)"popping_jet", (Object)"twilightforest:popping_jet").put((Object)"flame_jet", (Object)"twilightforest:flame_jet").put((Object)"tower_builder", (Object)"twilightforest:tower_builder").put((Object)"tower_reverter", (Object)"twilightforest:tower_reverter").put((Object)"trophy", (Object)"twilightforest:trophy").put((Object)"tower_boss_spawner", (Object)"twilightforest:tower_boss_spawner").put((Object)"ghast_trap_inactive", (Object)"twilightforest:ghast_trap_inactive").put((Object)"ghast_trap_active", (Object)"twilightforest:ghast_trap_active").put((Object)"carminite_reactor_active", (Object)"twilightforest:carminite_reactor_active").put((Object)"knight_phantom_spawner", (Object)"twilightforest:knight_phantom_spawner").put((Object)"snow_queen_spawner", (Object)"twilightforest:snow_queen_spawner").put((Object)"cinder_furnace", (Object)"twilightforest:cinder_furnace").put((Object)"minoshroom_spawner", (Object)"twilightforest:minoshroom_spawner").put((Object)"alpha_yeti_spawner", (Object)"twilightforest:alpha_yeti_spawner");
            this.tileEntityNames = (Map<String, String>)nameMap.build();
        }
        
        public int func_188216_a() {
            return 1;
        }
        
        public NBTTagCompound func_188217_a(final NBTTagCompound compound) {
            final String tileEntityLocation = compound.func_74779_i("id");
            compound.func_74778_a("id", (String)this.tileEntityNames.getOrDefault(tileEntityLocation, tileEntityLocation));
            return compound;
        }
    }
    
    private static class StructureStartIDFixer implements IFixableData
    {
        private final String[] startIDs;
        
        private StructureStartIDFixer() {
            this.startIDs = new String[] { "TFNothing", "TFHill", "TFHill", "TFHill", "TFHedge", "TFNC", "TFLT", "TFAP", "TFNothing", "TFQuest1", "TFNothing", "TFNothing", "TFHydra", "TFLr", "TFDT", "TFKSt", "TFNothing", "TFYeti", "TFTC", "TFFC", "TFMT" };
        }
        
        public int func_188216_a() {
            return 1;
        }
        
        public NBTTagCompound func_188217_a(final NBTTagCompound compound) {
            final int featureID = compound.func_74762_e("FeatureID");
            compound.func_74778_a("id", (featureID < this.startIDs.length) ? this.startIDs[featureID] : "TFNothing");
            return compound;
        }
    }
}
