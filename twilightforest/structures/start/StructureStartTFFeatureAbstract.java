// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.start;

import twilightforest.TwilightForestMod;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public abstract class StructureStartTFFeatureAbstract extends StructureStartTFAbstract
{
    private static int NUM_LOCKS;
    public boolean isConquered;
    public byte[] lockBytes;
    @Deprecated
    private TFFeature feature;
    
    public StructureStartTFFeatureAbstract() {
        this.lockBytes = new byte[StructureStartTFFeatureAbstract.NUM_LOCKS];
    }
    
    public StructureStartTFFeatureAbstract(final World world, final TFFeature feature, final Random rand, final int chunkX, final int chunkZ) {
        super(world, feature, rand, chunkX, chunkZ);
        this.lockBytes = new byte[StructureStartTFFeatureAbstract.NUM_LOCKS];
        this.isConquered = false;
        this.feature = feature;
    }
    
    public void func_143022_a(final NBTTagCompound compound) {
        super.func_143022_a(compound);
        compound.func_74757_a("Conquered", this.isConquered);
        compound.func_74773_a("Locks", this.lockBytes);
        compound.func_74768_a("FeatureID", this.feature.ordinal());
    }
    
    public void func_143017_b(final NBTTagCompound compound) {
        super.func_143017_b(compound);
        this.isConquered = compound.func_74767_n("Conquered");
        this.lockBytes = compound.func_74770_j("Locks");
        this.feature = TFFeature.getFeatureByID(compound.func_74762_e("FeatureID"));
    }
    
    public boolean isLocked(final int lockIndex) {
        if (lockIndex < this.lockBytes.length) {
            TwilightForestMod.LOGGER.debug("Checking locks for lockIndex {}", (Object)lockIndex);
            for (int i = 0; i < this.lockBytes.length; ++i) {
                TwilightForestMod.LOGGER.debug("Lock {} = {}", (Object)i, (Object)this.lockBytes[i]);
            }
            return this.lockBytes[lockIndex] != 0;
        }
        TwilightForestMod.LOGGER.warn("Current lock index {} is beyond array bounds {}", (Object)lockIndex, (Object)this.lockBytes.length);
        return false;
    }
    
    public boolean func_75069_d() {
        return this.feature.isStructureEnabled;
    }
    
    static {
        StructureStartTFFeatureAbstract.NUM_LOCKS = 4;
    }
}
