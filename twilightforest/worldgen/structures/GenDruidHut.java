// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.structures;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.nbt.CompoundNBT;
import javax.annotation.Nullable;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.IWorldReader;
import twilightforest.structures.TFStructureProcessors;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import twilightforest.enums.StructureWoodVariant;
import twilightforest.structures.RandomizedTemplateProcessor;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ResourceLocation;
import twilightforest.loot.TFTreasure;
import net.minecraft.util.Direction;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.state.Property;
import net.minecraft.state.properties.ChestType;
import net.minecraft.block.ChestBlock;
import net.minecraft.entity.EntityType;
import twilightforest.entity.TFEntities;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.state.properties.StructureMode;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import java.util.Iterator;
import net.minecraft.block.BlockState;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.gen.Heightmap;
import com.google.common.math.StatsAccumulator;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class GenDruidHut extends Feature<NoFeatureConfig>
{
    public GenDruidHut(final Codec<NoFeatureConfig> config) {
        super((Codec)config);
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final NoFeatureConfig config) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokeinterface net/minecraft/world/ISeedReader.func_201674_k:()Ljava/util/Random;
        //     6: astore          random
        //     8: aload_1         /* world */
        //     9: invokeinterface net/minecraft/world/ISeedReader.func_201672_e:()Lnet/minecraft/world/server/ServerWorld;
        //    14: invokevirtual   net/minecraft/world/server/ServerWorld.func_73046_m:()Lnet/minecraft/server/MinecraftServer;
        //    17: invokevirtual   net/minecraft/server/MinecraftServer.func_240792_aT_:()Lnet/minecraft/world/gen/feature/template/TemplateManager;
        //    20: astore          templatemanager
        //    22: aload           templatemanager
        //    24: invokestatic    twilightforest/worldgen/structures/GenDruidHut$HutType.values:()[Ltwilightforest/worldgen/structures/GenDruidHut$HutType;
        //    27: aload           random
        //    29: invokestatic    twilightforest/worldgen/structures/GenDruidHut$HutType.access$000:()I
        //    32: invokevirtual   java/util/Random.nextInt:(I)I
        //    35: aaload         
        //    36: invokestatic    twilightforest/worldgen/structures/GenDruidHut$HutType.access$100:(Ltwilightforest/worldgen/structures/GenDruidHut$HutType;)Lnet/minecraft/util/ResourceLocation;
        //    39: invokevirtual   net/minecraft/world/gen/feature/template/TemplateManager.func_200219_b:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/world/gen/feature/template/Template;
        //    42: astore          template
        //    44: aload           template
        //    46: ifnonnull       51
        //    49: iconst_0       
        //    50: ireturn        
        //    51: invokestatic    net/minecraft/util/Rotation.values:()[Lnet/minecraft/util/Rotation;
        //    54: astore          rotations
        //    56: aload           rotations
        //    58: aload           random
        //    60: aload           rotations
        //    62: arraylength    
        //    63: invokevirtual   java/util/Random.nextInt:(I)I
        //    66: aaload         
        //    67: astore          rotation
        //    69: invokestatic    net/minecraft/util/Mirror.values:()[Lnet/minecraft/util/Mirror;
        //    72: astore          mirrors
        //    74: aload           mirrors
        //    76: aload           random
        //    78: aload           mirrors
        //    80: arraylength    
        //    81: iconst_1       
        //    82: iadd           
        //    83: invokevirtual   java/util/Random.nextInt:(I)I
        //    86: aload           mirrors
        //    88: arraylength    
        //    89: irem           
        //    90: aaload         
        //    91: astore          mirror
        //    93: new             Lnet/minecraft/util/math/ChunkPos;
        //    96: dup            
        //    97: aload           pos
        //    99: bipush          -8
        //   101: iconst_0       
        //   102: bipush          -8
        //   104: invokevirtual   net/minecraft/util/math/BlockPos.func_177982_a:(III)Lnet/minecraft/util/math/BlockPos;
        //   107: invokespecial   net/minecraft/util/math/ChunkPos.<init>:(Lnet/minecraft/util/math/BlockPos;)V
        //   110: astore          chunkpos
        //   112: new             Lnet/minecraft/util/math/MutableBoundingBox;
        //   115: dup            
        //   116: aload           chunkpos
        //   118: invokevirtual   net/minecraft/util/math/ChunkPos.func_180334_c:()I
        //   121: bipush          8
        //   123: iadd           
        //   124: iconst_0       
        //   125: aload           chunkpos
        //   127: invokevirtual   net/minecraft/util/math/ChunkPos.func_180333_d:()I
        //   130: bipush          8
        //   132: iadd           
        //   133: aload           chunkpos
        //   135: invokevirtual   net/minecraft/util/math/ChunkPos.func_180332_e:()I
        //   138: bipush          8
        //   140: iadd           
        //   141: sipush          255
        //   144: aload           chunkpos
        //   146: invokevirtual   net/minecraft/util/math/ChunkPos.func_180330_f:()I
        //   149: bipush          8
        //   151: iadd           
        //   152: invokespecial   net/minecraft/util/math/MutableBoundingBox.<init>:(IIIIII)V
        //   155: astore          structureboundingbox
        //   157: new             Lnet/minecraft/world/gen/feature/template/PlacementSettings;
        //   160: dup            
        //   161: invokespecial   net/minecraft/world/gen/feature/template/PlacementSettings.<init>:()V
        //   164: aload           mirror
        //   166: invokevirtual   net/minecraft/world/gen/feature/template/PlacementSettings.func_186214_a:(Lnet/minecraft/util/Mirror;)Lnet/minecraft/world/gen/feature/template/PlacementSettings;
        //   169: aload           rotation
        //   171: invokevirtual   net/minecraft/world/gen/feature/template/PlacementSettings.func_186220_a:(Lnet/minecraft/util/Rotation;)Lnet/minecraft/world/gen/feature/template/PlacementSettings;
        //   174: aload           structureboundingbox
        //   176: invokevirtual   net/minecraft/world/gen/feature/template/PlacementSettings.func_186223_a:(Lnet/minecraft/util/math/MutableBoundingBox;)Lnet/minecraft/world/gen/feature/template/PlacementSettings;
        //   179: aload           random
        //   181: invokevirtual   net/minecraft/world/gen/feature/template/PlacementSettings.func_189950_a:(Ljava/util/Random;)Lnet/minecraft/world/gen/feature/template/PlacementSettings;
        //   184: astore          placementsettings
        //   186: aload           chunkpos
        //   188: invokevirtual   net/minecraft/util/math/ChunkPos.func_206849_h:()Lnet/minecraft/util/math/BlockPos;
        //   191: bipush          8
        //   193: aload           pos
        //   195: invokevirtual   net/minecraft/util/math/BlockPos.func_177956_o:()I
        //   198: iconst_1       
        //   199: isub           
        //   200: bipush          8
        //   202: invokevirtual   net/minecraft/util/math/BlockPos.func_177982_a:(III)Lnet/minecraft/util/math/BlockPos;
        //   205: astore          posSnap
        //   207: aload           template
        //   209: aload           rotation
        //   211: invokevirtual   net/minecraft/world/gen/feature/template/Template.func_186257_a:(Lnet/minecraft/util/Rotation;)Lnet/minecraft/util/math/BlockPos;
        //   214: astore          transformedSize
        //   216: aload           random
        //   218: bipush          17
        //   220: aload           transformedSize
        //   222: invokevirtual   net/minecraft/util/math/BlockPos.func_177958_n:()I
        //   225: isub           
        //   226: invokevirtual   java/util/Random.nextInt:(I)I
        //   229: istore          dx
        //   231: aload           random
        //   233: bipush          17
        //   235: aload           transformedSize
        //   237: invokevirtual   net/minecraft/util/math/BlockPos.func_177952_p:()I
        //   240: isub           
        //   241: invokevirtual   java/util/Random.nextInt:(I)I
        //   244: istore          dz
        //   246: aload           posSnap
        //   248: iload           dx
        //   250: iconst_0       
        //   251: iload           dz
        //   253: invokevirtual   net/minecraft/util/math/BlockPos.func_177982_a:(III)Lnet/minecraft/util/math/BlockPos;
        //   256: pop            
        //   257: new             Lnet/minecraft/util/math/BlockPos$Mutable;
        //   260: dup            
        //   261: aload           posSnap
        //   263: invokevirtual   net/minecraft/util/math/BlockPos.func_177958_n:()I
        //   266: aload           posSnap
        //   268: invokevirtual   net/minecraft/util/math/BlockPos.func_177956_o:()I
        //   271: aload           posSnap
        //   273: invokevirtual   net/minecraft/util/math/BlockPos.func_177952_p:()I
        //   276: invokespecial   net/minecraft/util/math/BlockPos$Mutable.<init>:(III)V
        //   279: astore          startPos
        //   281: aload_1         /* world */
        //   282: aload           startPos
        //   284: aload           transformedSize
        //   286: invokestatic    twilightforest/worldgen/structures/GenDruidHut.offsetToAverageGroundLevel:(Lnet/minecraft/world/ISeedReader;Lnet/minecraft/util/math/BlockPos$Mutable;Lnet/minecraft/util/math/BlockPos;)Z
        //   289: ifne            294
        //   292: iconst_0       
        //   293: ireturn        
        //   294: aload           template
        //   296: aload           startPos
        //   298: aload           mirror
        //   300: aload           rotation
        //   302: invokevirtual   net/minecraft/world/gen/feature/template/Template.func_189961_a:(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/Mirror;Lnet/minecraft/util/Rotation;)Lnet/minecraft/util/math/BlockPos;
        //   305: astore          placementPos
        //   307: aload           template
        //   309: aload_1         /* world */
        //   310: aload           placementPos
        //   312: aload           placementPos
        //   314: aload           placementsettings
        //   316: invokevirtual   net/minecraft/world/gen/feature/template/PlacementSettings.func_215219_b:()Lnet/minecraft/world/gen/feature/template/PlacementSettings;
        //   319: new             Ltwilightforest/worldgen/structures/GenDruidHut$HutTemplateProcessor;
        //   322: dup            
        //   323: fconst_0       
        //   324: aload_3         /* rand */
        //   325: invokevirtual   java/util/Random.nextInt:()I
        //   328: aload_3         /* rand */
        //   329: invokevirtual   java/util/Random.nextInt:()I
        //   332: aload_3         /* rand */
        //   333: invokevirtual   java/util/Random.nextInt:()I
        //   336: invokespecial   twilightforest/worldgen/structures/GenDruidHut$HutTemplateProcessor.<init>:(FIII)V
        //   339: invokevirtual   net/minecraft/world/gen/feature/template/PlacementSettings.func_215222_a:(Lnet/minecraft/world/gen/feature/template/StructureProcessor;)Lnet/minecraft/world/gen/feature/template/PlacementSettings;
        //   342: aload           random
        //   344: bipush          20
        //   346: invokevirtual   net/minecraft/world/gen/feature/template/Template.func_237146_a_:(Lnet/minecraft/world/IServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/gen/feature/template/PlacementSettings;Ljava/util/Random;I)Z
        //   349: pop            
        //   350: new             Ljava/util/ArrayList;
        //   353: dup            
        //   354: aload           template
        //   356: aload           placementPos
        //   358: aload           placementsettings
        //   360: getstatic       net/minecraft/block/Blocks.field_185779_df:Lnet/minecraft/block/Block;
        //   363: invokevirtual   net/minecraft/world/gen/feature/template/Template.func_215381_a:(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/gen/feature/template/PlacementSettings;Lnet/minecraft/block/Block;)Ljava/util/List;
        //   366: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //   369: astore          data
        //   371: aload           random
        //   373: invokevirtual   java/util/Random.nextBoolean:()Z
        //   376: ifeq            525
        //   379: aload           templatemanager
        //   381: invokestatic    twilightforest/worldgen/structures/GenDruidHut$BasementType.values:()[Ltwilightforest/worldgen/structures/GenDruidHut$BasementType;
        //   384: aload           random
        //   386: invokestatic    twilightforest/worldgen/structures/GenDruidHut$BasementType.access$200:()I
        //   389: invokevirtual   java/util/Random.nextInt:(I)I
        //   392: aaload         
        //   393: aload           random
        //   395: invokevirtual   java/util/Random.nextBoolean:()Z
        //   398: invokestatic    twilightforest/worldgen/structures/GenDruidHut$BasementType.access$300:(Ltwilightforest/worldgen/structures/GenDruidHut$BasementType;Z)Lnet/minecraft/util/ResourceLocation;
        //   401: invokevirtual   net/minecraft/world/gen/feature/template/TemplateManager.func_200219_b:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/world/gen/feature/template/Template;
        //   404: astore          template
        //   406: aload           template
        //   408: ifnonnull       413
        //   411: iconst_0       
        //   412: ireturn        
        //   413: aload           placementPos
        //   415: bipush          12
        //   417: invokevirtual   net/minecraft/util/math/BlockPos.func_177979_c:(I)Lnet/minecraft/util/math/BlockPos;
        //   420: aload           rotation
        //   422: aload           mirror
        //   424: getstatic       net/minecraft/util/Direction.NORTH:Lnet/minecraft/util/Direction;
        //   427: invokevirtual   net/minecraft/util/Mirror.func_185803_b:(Lnet/minecraft/util/Direction;)Lnet/minecraft/util/Direction;
        //   430: invokevirtual   net/minecraft/util/Rotation.func_185831_a:(Lnet/minecraft/util/Direction;)Lnet/minecraft/util/Direction;
        //   433: iconst_1       
        //   434: invokevirtual   net/minecraft/util/math/BlockPos.func_177967_a:(Lnet/minecraft/util/Direction;I)Lnet/minecraft/util/math/BlockPos;
        //   437: aload           rotation
        //   439: aload           mirror
        //   441: getstatic       net/minecraft/util/Direction.EAST:Lnet/minecraft/util/Direction;
        //   444: invokevirtual   net/minecraft/util/Mirror.func_185803_b:(Lnet/minecraft/util/Direction;)Lnet/minecraft/util/Direction;
        //   447: invokevirtual   net/minecraft/util/Rotation.func_185831_a:(Lnet/minecraft/util/Direction;)Lnet/minecraft/util/Direction;
        //   450: iconst_1       
        //   451: invokevirtual   net/minecraft/util/math/BlockPos.func_177967_a:(Lnet/minecraft/util/Direction;I)Lnet/minecraft/util/math/BlockPos;
        //   454: astore          placementPos
        //   456: aload           template
        //   458: aload_1         /* world */
        //   459: aload           placementPos
        //   461: aload           placementPos
        //   463: aload           placementsettings
        //   465: invokevirtual   net/minecraft/world/gen/feature/template/PlacementSettings.func_215219_b:()Lnet/minecraft/world/gen/feature/template/PlacementSettings;
        //   468: new             Ltwilightforest/worldgen/structures/GenDruidHut$HutTemplateProcessor;
        //   471: dup            
        //   472: fconst_0       
        //   473: aload_3         /* rand */
        //   474: bipush          14
        //   476: invokevirtual   java/util/Random.nextInt:(I)I
        //   479: aload_3         /* rand */
        //   480: bipush          14
        //   482: invokevirtual   java/util/Random.nextInt:(I)I
        //   485: aload_3         /* rand */
        //   486: bipush          14
        //   488: invokevirtual   java/util/Random.nextInt:(I)I
        //   491: invokespecial   twilightforest/worldgen/structures/GenDruidHut$HutTemplateProcessor.<init>:(FIII)V
        //   494: invokevirtual   net/minecraft/world/gen/feature/template/PlacementSettings.func_215222_a:(Lnet/minecraft/world/gen/feature/template/StructureProcessor;)Lnet/minecraft/world/gen/feature/template/PlacementSettings;
        //   497: aload           random
        //   499: bipush          20
        //   501: invokevirtual   net/minecraft/world/gen/feature/template/Template.func_237146_a_:(Lnet/minecraft/world/IServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/gen/feature/template/PlacementSettings;Ljava/util/Random;I)Z
        //   504: pop            
        //   505: aload           data
        //   507: aload           template
        //   509: aload           placementPos
        //   511: aload           placementsettings
        //   513: getstatic       net/minecraft/block/Blocks.field_185779_df:Lnet/minecraft/block/Block;
        //   516: invokevirtual   net/minecraft/world/gen/feature/template/Template.func_215381_a:(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/gen/feature/template/PlacementSettings;Lnet/minecraft/block/Block;)Ljava/util/List;
        //   519: invokeinterface java/util/List.addAll:(Ljava/util/Collection;)Z
        //   524: pop            
        //   525: aload           data
        //   527: aload_1         /* world */
        //   528: aload           mirror
        //   530: aload           rotation
        //   532: invokedynamic   BootstrapMethod #0, accept:(Lnet/minecraft/world/ISeedReader;Lnet/minecraft/util/Mirror;Lnet/minecraft/util/Rotation;)Ljava/util/function/Consumer;
        //   537: invokeinterface java/util/List.forEach:(Ljava/util/function/Consumer;)V
        //   542: iconst_1       
        //   543: ireturn        
        //    StackMapTable: 00 04 FE 00 33 07 00 51 07 00 5B 07 00 1A FF 00 F2 00 15 07 00 02 07 00 33 07 00 B2 07 00 51 07 00 15 07 00 B4 07 00 51 07 00 5B 07 00 1A 07 00 B6 07 00 61 07 00 B8 07 00 66 07 00 6B 07 00 74 07 00 85 07 00 15 07 00 15 01 01 07 00 13 00 00 FD 00 76 07 00 15 07 00 EC FB 00 6F
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.languages.java.ast.NameVariables.generateNameForVariable(NameVariables.java:252)
        //     at com.strobel.decompiler.languages.java.ast.NameVariables.assignNamesToVariables(NameVariables.java:185)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.nameVariables(AstMethodBodyBuilder.java:1473)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.populateVariables(AstMethodBodyBuilder.java:1402)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:213)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:94)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:840)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:733)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:610)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:577)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:193)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:160)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:135)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:144)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static boolean offsetToAverageGroundLevel(final ISeedReader world, final BlockPos.Mutable startPos, final BlockPos size) {
        final StatsAccumulator heights = new StatsAccumulator();
        for (int dx2 = 0; dx2 < size.func_177958_n(); ++dx2) {
            for (int dz2 = 0; dz2 < size.func_177952_p(); ++dz2) {
                final int x = startPos.func_177958_n() + dx2;
                final int z = startPos.func_177952_p() + dz2;
                int y;
                for (y = world.func_201676_a(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, x, z); y >= 0; --y) {
                    final BlockState state = world.func_180495_p(new BlockPos(x, y, z));
                    if (isBlockNotOk(state)) {
                        return false;
                    }
                    if (isBlockOk(state)) {
                        break;
                    }
                }
                if (y < 0) {
                    return false;
                }
                heights.add((double)y);
            }
        }
        if (heights.populationStandardDeviation() > 2.0) {
            return false;
        }
        final int baseY = (int)Math.round(heights.mean());
        final int maxY = (int)heights.max();
        startPos.func_185336_p(baseY);
        return isAreaClear((IWorld)world, startPos.func_177981_b(maxY - baseY + 1), startPos.func_177971_a((Vector3i)size));
    }
    
    private static boolean isAreaClear(final IWorld world, final BlockPos min, final BlockPos max) {
        for (final BlockPos pos2 : BlockPos.func_218278_a(min, max)) {
            if (!world.func_180495_p(pos2).func_185904_a().func_76222_j()) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isBlockOk(final BlockState state) {
        final Material material = state.func_185904_a();
        return material == Material.field_151576_e || material == Material.field_151578_c || material == Material.field_151577_b || material == Material.field_151595_p;
    }
    
    private static boolean isBlockNotOk(final BlockState state) {
        final Material material = state.func_185904_a();
        return material == Material.field_151586_h || material == Material.field_151587_i || state.func_177230_c() == Blocks.field_150357_h;
    }
    
    private enum HutType
    {
        REGULAR(TwilightForestMod.prefix("landscape/druid_hut/druid_hut")), 
        SIDEWAYS(TwilightForestMod.prefix("landscape/druid_hut/druid_sideways")), 
        DOUBLE_DECK(TwilightForestMod.prefix("landscape/druid_hut/druid_doubledeck"));
        
        private final ResourceLocation RL;
        private static int size;
        
        private HutType(final ResourceLocation rl) {
            this.RL = rl;
            increment();
        }
        
        private static void increment() {
            ++HutType.size;
        }
    }
    
    private enum BasementType
    {
        STUDY(TwilightForestMod.prefix("landscape/druid_hut/basement_study"), TwilightForestMod.prefix("landscape/druid_hut/basement_study_trap")), 
        SHELVES(TwilightForestMod.prefix("landscape/druid_hut/basement_shelves"), TwilightForestMod.prefix("landscape/druid_hut/basement_shelves_trap")), 
        GALLERY(TwilightForestMod.prefix("landscape/druid_hut/basement_gallery"), TwilightForestMod.prefix("landscape/druid_hut/basement_gallery_trap"));
        
        private final ResourceLocation RL;
        private final ResourceLocation RL_TRAP;
        private static int size;
        
        private BasementType(final ResourceLocation rl, final ResourceLocation rlTrap) {
            this.RL = rl;
            this.RL_TRAP = rlTrap;
            increment();
        }
        
        private static void increment() {
            ++BasementType.size;
        }
        
        private ResourceLocation getBasement(final boolean trapped) {
            return trapped ? this.RL_TRAP : this.RL;
        }
    }
    
    public static class HutTemplateProcessor extends RandomizedTemplateProcessor
    {
        private final StructureWoodVariant OAK_SWIZZLE;
        private final StructureWoodVariant SPRUCE_SWIZZLE;
        private final StructureWoodVariant BIRCH_SWIZZLE;
        public int dummy;
        public static final Codec<HutTemplateProcessor> codecHutProcessor;
        
        public HutTemplateProcessor(final float integrity, final int oakSwizzle, final int spruceSwizzle, final int birchSwizzle) {
            super(integrity);
            this.dummy = 0;
            final int limit = StructureWoodVariant.values().length;
            this.OAK_SWIZZLE = StructureWoodVariant.values()[Math.floorMod(oakSwizzle, limit)];
            this.SPRUCE_SWIZZLE = StructureWoodVariant.values()[Math.floorMod(spruceSwizzle, limit)];
            this.BIRCH_SWIZZLE = StructureWoodVariant.values()[Math.floorMod(birchSwizzle, limit)];
        }
        
        protected IStructureProcessorType<?> func_215192_a() {
            return TFStructureProcessors.HUT;
        }
        
        @Nullable
        public Template.BlockInfo process(final IWorldReader worldIn, final BlockPos pos, final BlockPos piecepos, final Template.BlockInfo p_215194_3_, final Template.BlockInfo blockInfo, final PlacementSettings settings, @Nullable final Template template) {
            final Random random2 = settings.func_189947_a(pos);
            if (!this.shouldPlaceBlock(random2)) {
                return null;
            }
            final BlockState state = blockInfo.field_186243_b;
            final Block block = state.func_177230_c();
            if (block == Blocks.field_150347_e) {
                return random2.nextBoolean() ? blockInfo : new Template.BlockInfo(blockInfo.field_186242_a, Blocks.field_150341_Y.func_176223_P(), (CompoundNBT)null);
            }
            if (block == Blocks.field_150463_bK) {
                return random2.nextBoolean() ? blockInfo : new Template.BlockInfo(blockInfo.field_186242_a, Blocks.field_196723_eg.func_176223_P(), (CompoundNBT)null);
            }
            if (block == Blocks.field_196696_di) {
                return random2.nextBoolean() ? blockInfo : new Template.BlockInfo(blockInfo.field_186242_a, (random2.nextInt(2) == 0) ? Blocks.field_196700_dk.func_176223_P() : Blocks.field_196698_dj.func_176223_P(), (CompoundNBT)null);
            }
            final StructureWoodVariant type = StructureWoodVariant.getVariantFromBlock(block);
            if (type != null) {
                switch (type) {
                    case OAK: {
                        return new Template.BlockInfo(blockInfo.field_186242_a, StructureWoodVariant.modifyBlockWithType(state, this.OAK_SWIZZLE), (CompoundNBT)null);
                    }
                    case SPRUCE: {
                        return new Template.BlockInfo(blockInfo.field_186242_a, StructureWoodVariant.modifyBlockWithType(state, this.SPRUCE_SWIZZLE), (CompoundNBT)null);
                    }
                    case BIRCH: {
                        return new Template.BlockInfo(blockInfo.field_186242_a, StructureWoodVariant.modifyBlockWithType(state, this.BIRCH_SWIZZLE), (CompoundNBT)null);
                    }
                }
            }
            return blockInfo;
        }
        
        static {
            codecHutProcessor = RecordCodecBuilder.create(instance -> instance.group((App)Codec.FLOAT.fieldOf("integrity").orElse((Object)1.0f).forGetter(obj -> obj.integrity), (App)Codec.INT.fieldOf("integrity").orElse((Object)0).forGetter(obj -> obj.dummy), (App)Codec.INT.fieldOf("integrity").orElse((Object)0).forGetter(obj -> obj.dummy), (App)Codec.INT.fieldOf("integrity").orElse((Object)0).forGetter(obj -> obj.dummy)).apply((Applicative)instance, HutTemplateProcessor::new));
        }
    }
}
