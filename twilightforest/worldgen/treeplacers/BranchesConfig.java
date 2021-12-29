// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.treeplacers;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.Codec;

public final class BranchesConfig
{
    public static final Codec<BranchesConfig> CODEC;
    public final int branchCount;
    public final int randomAddBranches;
    public final double length;
    public final double randomAddLength;
    public final double spacingYaw;
    public final double downwardsPitch;
    
    public BranchesConfig(final int branchCount, final int randomAddBranches, final double length, final double randomAddLength, final double spacingYaw, final double downwardsPitch) {
        this.branchCount = branchCount;
        this.randomAddBranches = randomAddBranches;
        this.length = length;
        this.randomAddLength = randomAddLength;
        this.spacingYaw = spacingYaw;
        this.downwardsPitch = downwardsPitch;
    }
    
    public BranchesConfig(final int branchCount, final double length) {
        this.branchCount = branchCount;
        this.randomAddBranches = 0;
        this.length = length;
        this.randomAddLength = 0.0;
        this.spacingYaw = 0.3;
        this.downwardsPitch = 0.2;
    }
    
    static {
        CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.intRange(0, 16).fieldOf("count_minimum").forGetter(o -> o.branchCount), (App)Codec.intRange(0, 16).fieldOf("random_add_count").orElse((Object)0).forGetter(o -> o.randomAddBranches), (App)Codec.doubleRange(1.0, 24.0).fieldOf("length").forGetter(o -> o.length), (App)Codec.doubleRange(0.0, 16.0).fieldOf("random_add_length").orElse((Object)0.0).forGetter(o -> o.randomAddLength), (App)Codec.doubleRange(0.0, 0.5).fieldOf("spacing_yaw").orElse((Object)0.3).forGetter(o -> o.spacingYaw), (App)Codec.doubleRange(0.0, 1.0).fieldOf("downwards_pitch").orElse((Object)0.2).forGetter(o -> o.downwardsPitch)).apply((Applicative)instance, BranchesConfig::new));
    }
}
