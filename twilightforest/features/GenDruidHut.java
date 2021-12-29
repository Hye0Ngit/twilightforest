// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.features;

import javax.annotation.Nullable;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockWall;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import twilightforest.enums.StructureWoodVariant;
import twilightforest.structures.RandomizedTemplateProcessor;
import twilightforest.TwilightForestMod;
import net.minecraft.util.ResourceLocation;
import twilightforest.loot.TFTreasure;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.entity.EntityList;
import twilightforest.entity.EntityTFSkeletonDruid;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import java.util.Iterator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.Vec3i;
import com.google.common.math.StatsAccumulator;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.world.feature.TFGenerator;

public class GenDruidHut extends TFGenerator
{
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_3         /* pos */
        //     2: invokevirtual   net/minecraft/world/World.func_175726_f:(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/chunk/Chunk;
        //     5: ldc2_w          987234911
        //     8: invokevirtual   net/minecraft/world/chunk/Chunk.func_76617_a:(J)Ljava/util/Random;
        //    11: astore          random
        //    13: aload_1         /* world */
        //    14: invokevirtual   net/minecraft/world/World.func_73046_m:()Lnet/minecraft/server/MinecraftServer;
        //    17: astore          minecraftserver
        //    19: aload_1         /* world */
        //    20: invokevirtual   net/minecraft/world/World.func_72860_G:()Lnet/minecraft/world/storage/ISaveHandler;
        //    23: invokeinterface net/minecraft/world/storage/ISaveHandler.func_186340_h:()Lnet/minecraft/world/gen/structure/template/TemplateManager;
        //    28: astore          templatemanager
        //    30: aload           templatemanager
        //    32: aload           minecraftserver
        //    34: invokestatic    twilightforest/features/GenDruidHut$HutType.values:()[Ltwilightforest/features/GenDruidHut$HutType;
        //    37: aload           random
        //    39: invokestatic    twilightforest/features/GenDruidHut$HutType.access$000:()I
        //    42: invokevirtual   java/util/Random.nextInt:(I)I
        //    45: aaload         
        //    46: invokestatic    twilightforest/features/GenDruidHut$HutType.access$100:(Ltwilightforest/features/GenDruidHut$HutType;)Lnet/minecraft/util/ResourceLocation;
        //    49: invokevirtual   net/minecraft/world/gen/structure/template/TemplateManager.func_186237_a:(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/world/gen/structure/template/Template;
        //    52: astore          template
        //    54: invokestatic    net/minecraft/util/Rotation.values:()[Lnet/minecraft/util/Rotation;
        //    57: astore          rotations
        //    59: aload           rotations
        //    61: aload           random
        //    63: aload           rotations
        //    65: arraylength    
        //    66: invokevirtual   java/util/Random.nextInt:(I)I
        //    69: aaload         
        //    70: astore          rotation
        //    72: invokestatic    net/minecraft/util/Mirror.values:()[Lnet/minecraft/util/Mirror;
        //    75: astore          mirrors
        //    77: aload           mirrors
        //    79: aload           random
        //    81: aload           mirrors
        //    83: arraylength    
        //    84: iconst_1       
        //    85: iadd           
        //    86: invokevirtual   java/util/Random.nextInt:(I)I
        //    89: aload           mirrors
        //    91: arraylength    
        //    92: irem           
        //    93: aaload         
        //    94: astore          mirror
        //    96: new             Lnet/minecraft/util/math/ChunkPos;
        //    99: dup            
        //   100: aload_3         /* pos */
        //   101: bipush          -8
        //   103: iconst_0       
        //   104: bipush          -8
        //   106: invokevirtual   net/minecraft/util/math/BlockPos.func_177982_a:(III)Lnet/minecraft/util/math/BlockPos;
        //   109: invokespecial   net/minecraft/util/math/ChunkPos.<init>:(Lnet/minecraft/util/math/BlockPos;)V
        //   112: astore          chunkpos
        //   114: new             Lnet/minecraft/world/gen/structure/StructureBoundingBox;
        //   117: dup            
        //   118: aload           chunkpos
        //   120: invokevirtual   net/minecraft/util/math/ChunkPos.func_180334_c:()I
        //   123: bipush          8
        //   125: iadd           
        //   126: iconst_0       
        //   127: aload           chunkpos
        //   129: invokevirtual   net/minecraft/util/math/ChunkPos.func_180333_d:()I
        //   132: bipush          8
        //   134: iadd           
        //   135: aload           chunkpos
        //   137: invokevirtual   net/minecraft/util/math/ChunkPos.func_180332_e:()I
        //   140: bipush          8
        //   142: iadd           
        //   143: sipush          255
        //   146: aload           chunkpos
        //   148: invokevirtual   net/minecraft/util/math/ChunkPos.func_180330_f:()I
        //   151: bipush          8
        //   153: iadd           
        //   154: invokespecial   net/minecraft/world/gen/structure/StructureBoundingBox.<init>:(IIIIII)V
        //   157: astore          structureboundingbox
        //   159: new             Lnet/minecraft/world/gen/structure/template/PlacementSettings;
        //   162: dup            
        //   163: invokespecial   net/minecraft/world/gen/structure/template/PlacementSettings.<init>:()V
        //   166: aload           mirror
        //   168: invokevirtual   net/minecraft/world/gen/structure/template/PlacementSettings.func_186214_a:(Lnet/minecraft/util/Mirror;)Lnet/minecraft/world/gen/structure/template/PlacementSettings;
        //   171: aload           rotation
        //   173: invokevirtual   net/minecraft/world/gen/structure/template/PlacementSettings.func_186220_a:(Lnet/minecraft/util/Rotation;)Lnet/minecraft/world/gen/structure/template/PlacementSettings;
        //   176: aload           structureboundingbox
        //   178: invokevirtual   net/minecraft/world/gen/structure/template/PlacementSettings.func_186223_a:(Lnet/minecraft/world/gen/structure/StructureBoundingBox;)Lnet/minecraft/world/gen/structure/template/PlacementSettings;
        //   181: aload           random
        //   183: invokevirtual   net/minecraft/world/gen/structure/template/PlacementSettings.func_189950_a:(Ljava/util/Random;)Lnet/minecraft/world/gen/structure/template/PlacementSettings;
        //   186: astore          placementsettings
        //   188: aload           chunkpos
        //   190: bipush          8
        //   192: aload_3         /* pos */
        //   193: invokevirtual   net/minecraft/util/math/BlockPos.func_177956_o:()I
        //   196: iconst_1       
        //   197: isub           
        //   198: bipush          8
        //   200: invokevirtual   net/minecraft/util/math/ChunkPos.func_180331_a:(III)Lnet/minecraft/util/math/BlockPos;
        //   203: astore          posSnap
        //   205: aload           template
        //   207: aload           rotation
        //   209: invokevirtual   net/minecraft/world/gen/structure/template/Template.func_186257_a:(Lnet/minecraft/util/Rotation;)Lnet/minecraft/util/math/BlockPos;
        //   212: astore          transformedSize
        //   214: aload           random
        //   216: bipush          17
        //   218: aload           transformedSize
        //   220: invokevirtual   net/minecraft/util/math/BlockPos.func_177958_n:()I
        //   223: isub           
        //   224: invokevirtual   java/util/Random.nextInt:(I)I
        //   227: istore          dx
        //   229: aload           random
        //   231: bipush          17
        //   233: aload           transformedSize
        //   235: invokevirtual   net/minecraft/util/math/BlockPos.func_177952_p:()I
        //   238: isub           
        //   239: invokevirtual   java/util/Random.nextInt:(I)I
        //   242: istore          dz
        //   244: new             Lnet/minecraft/util/math/BlockPos$MutableBlockPos;
        //   247: dup            
        //   248: aload           posSnap
        //   250: iload           dx
        //   252: iconst_0       
        //   253: iload           dz
        //   255: invokevirtual   net/minecraft/util/math/BlockPos.func_177982_a:(III)Lnet/minecraft/util/math/BlockPos;
        //   258: invokespecial   net/minecraft/util/math/BlockPos$MutableBlockPos.<init>:(Lnet/minecraft/util/math/BlockPos;)V
        //   261: astore          startPos
        //   263: aload_1         /* world */
        //   264: aload           startPos
        //   266: aload           transformedSize
        //   268: invokestatic    twilightforest/features/GenDruidHut.offsetToAverageGroundLevel:(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos$MutableBlockPos;Lnet/minecraft/util/math/BlockPos;)Z
        //   271: ifne            276
        //   274: iconst_0       
        //   275: ireturn        
        //   276: aload           template
        //   278: aload           startPos
        //   280: aload           mirror
        //   282: aload           rotation
        //   284: invokevirtual   net/minecraft/world/gen/structure/template/Template.func_189961_a:(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/Mirror;Lnet/minecraft/util/Rotation;)Lnet/minecraft/util/math/BlockPos;
        //   287: astore          placementPos
        //   289: aload           template
        //   291: aload_1         /* world */
        //   292: aload           placementPos
        //   294: new             Ltwilightforest/features/GenDruidHut$HutTemplateProcessor;
        //   297: dup            
        //   298: aload_0         /* this */
        //   299: aload           placementPos
        //   301: aload           placementsettings
        //   303: aload           random
        //   305: invokevirtual   java/util/Random.nextInt:()I
        //   308: aload           random
        //   310: invokevirtual   java/util/Random.nextInt:()I
        //   313: aload           random
        //   315: invokevirtual   java/util/Random.nextInt:()I
        //   318: invokespecial   twilightforest/features/GenDruidHut$HutTemplateProcessor.<init>:(Ltwilightforest/features/GenDruidHut;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/gen/structure/template/PlacementSettings;III)V
        //   321: aload           placementsettings
        //   323: bipush          20
        //   325: invokevirtual   net/minecraft/world/gen/structure/template/Template.func_189960_a:(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/gen/structure/template/ITemplateProcessor;Lnet/minecraft/world/gen/structure/template/PlacementSettings;I)V
        //   328: aload           template
        //   330: aload           placementPos
        //   332: aload           placementsettings
        //   334: invokevirtual   net/minecraft/world/gen/structure/template/Template.func_186258_a:(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/gen/structure/template/PlacementSettings;)Ljava/util/Map;
        //   337: astore          data
        //   339: aload           random
        //   341: invokevirtual   java/util/Random.nextBoolean:()Z
        //   344: ifeq            474
        //   347: aload           templatemanager
        //   349: aload           minecraftserver
        //   351: invokestatic    twilightforest/features/GenDruidHut$BasementType.values:()[Ltwilightforest/features/GenDruidHut$BasementType;
        //   354: aload           random
        //   356: invokestatic    twilightforest/features/GenDruidHut$BasementType.access$200:()I
        //   359: invokevirtual   java/util/Random.nextInt:(I)I
        //   362: aaload         
        //   363: aload           random
        //   365: invokevirtual   java/util/Random.nextBoolean:()Z
        //   368: invokestatic    twilightforest/features/GenDruidHut$BasementType.access$300:(Ltwilightforest/features/GenDruidHut$BasementType;Z)Lnet/minecraft/util/ResourceLocation;
        //   371: invokevirtual   net/minecraft/world/gen/structure/template/TemplateManager.func_186237_a:(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/world/gen/structure/template/Template;
        //   374: astore          template
        //   376: aload           placementPos
        //   378: bipush          12
        //   380: invokevirtual   net/minecraft/util/math/BlockPos.func_177979_c:(I)Lnet/minecraft/util/math/BlockPos;
        //   383: aload           rotation
        //   385: aload           mirror
        //   387: getstatic       net/minecraft/util/EnumFacing.NORTH:Lnet/minecraft/util/EnumFacing;
        //   390: invokevirtual   net/minecraft/util/Mirror.func_185803_b:(Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/EnumFacing;
        //   393: invokevirtual   net/minecraft/util/Rotation.func_185831_a:(Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/EnumFacing;
        //   396: iconst_1       
        //   397: invokevirtual   net/minecraft/util/math/BlockPos.func_177967_a:(Lnet/minecraft/util/EnumFacing;I)Lnet/minecraft/util/math/BlockPos;
        //   400: aload           rotation
        //   402: aload           mirror
        //   404: getstatic       net/minecraft/util/EnumFacing.EAST:Lnet/minecraft/util/EnumFacing;
        //   407: invokevirtual   net/minecraft/util/Mirror.func_185803_b:(Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/EnumFacing;
        //   410: invokevirtual   net/minecraft/util/Rotation.func_185831_a:(Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/EnumFacing;
        //   413: iconst_1       
        //   414: invokevirtual   net/minecraft/util/math/BlockPos.func_177967_a:(Lnet/minecraft/util/EnumFacing;I)Lnet/minecraft/util/math/BlockPos;
        //   417: astore          placementPos
        //   419: aload           template
        //   421: aload_1         /* world */
        //   422: aload           placementPos
        //   424: new             Ltwilightforest/features/GenDruidHut$HutTemplateProcessor;
        //   427: dup            
        //   428: aload_0         /* this */
        //   429: aload           placementPos
        //   431: aload           placementsettings
        //   433: aload           random
        //   435: invokevirtual   java/util/Random.nextInt:()I
        //   438: aload           random
        //   440: invokevirtual   java/util/Random.nextInt:()I
        //   443: aload           random
        //   445: invokevirtual   java/util/Random.nextInt:()I
        //   448: invokespecial   twilightforest/features/GenDruidHut$HutTemplateProcessor.<init>:(Ltwilightforest/features/GenDruidHut;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/gen/structure/template/PlacementSettings;III)V
        //   451: aload           placementsettings
        //   453: bipush          20
        //   455: invokevirtual   net/minecraft/world/gen/structure/template/Template.func_189960_a:(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/gen/structure/template/ITemplateProcessor;Lnet/minecraft/world/gen/structure/template/PlacementSettings;I)V
        //   458: aload           data
        //   460: aload           template
        //   462: aload           placementPos
        //   464: aload           placementsettings
        //   466: invokevirtual   net/minecraft/world/gen/structure/template/Template.func_186258_a:(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/gen/structure/template/PlacementSettings;)Ljava/util/Map;
        //   469: invokeinterface java/util/Map.putAll:(Ljava/util/Map;)V
        //   474: aload           data
        //   476: aload_1         /* world */
        //   477: aload           rotation
        //   479: aload           mirror
        //   481: invokedynamic   BootstrapMethod #0, accept:(Lnet/minecraft/world/World;Lnet/minecraft/util/Rotation;Lnet/minecraft/util/Mirror;)Ljava/util/function/BiConsumer;
        //   486: invokeinterface java/util/Map.forEach:(Ljava/util/function/BiConsumer;)V
        //   491: iconst_1       
        //   492: ireturn        
        //    StackMapTable: 00 02 FF 01 14 00 14 07 00 02 07 00 24 07 00 48 07 00 14 07 00 48 07 00 A6 07 00 52 07 00 95 07 00 A8 07 00 58 07 00 AA 07 00 5D 07 00 62 07 00 6B 07 00 7C 07 00 14 07 00 14 01 01 07 00 12 00 00 FD 00 C5 07 00 14 07 00 E3
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
    
    private static boolean offsetToAverageGroundLevel(final World world, final BlockPos.MutableBlockPos startPos, final BlockPos size) {
        final StatsAccumulator heights = new StatsAccumulator();
        for (int dx2 = 0; dx2 < size.func_177958_n(); ++dx2) {
            for (int dz2 = 0; dz2 < size.func_177952_p(); ++dz2) {
                final int x = startPos.func_177958_n() + dx2;
                final int z = startPos.func_177952_p() + dz2;
                int y;
                for (y = world.func_189649_b(x, z); y >= 0; --y) {
                    final IBlockState state = world.func_180495_p(new BlockPos(x, y, z));
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
        return isAreaClear((IBlockAccess)world, startPos.func_177981_b(maxY - baseY + 1), startPos.func_177971_a((Vec3i)size));
    }
    
    private static boolean isAreaClear(final IBlockAccess world, final BlockPos min, final BlockPos max) {
        for (final BlockPos pos2 : BlockPos.func_177975_b(min, max)) {
            if (!world.func_180495_p(pos2).func_177230_c().func_176200_f(world, pos2)) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isBlockOk(final IBlockState state) {
        final Material material = state.func_185904_a();
        return material == Material.field_151576_e || material == Material.field_151578_c || material == Material.field_151577_b || material == Material.field_151595_p;
    }
    
    private static boolean isBlockNotOk(final IBlockState state) {
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
    
    public class HutTemplateProcessor extends RandomizedTemplateProcessor
    {
        private final StructureWoodVariant OAK_SWIZZLE;
        private final StructureWoodVariant SPRUCE_SWIZZLE;
        private final StructureWoodVariant BIRCH_SWIZZLE;
        
        public HutTemplateProcessor(final BlockPos pos, final PlacementSettings settings, final int oakSwizzle, final int spruceSwizzle, final int birchSwizzle) {
            super(pos, settings);
            final int limit = StructureWoodVariant.values().length;
            this.OAK_SWIZZLE = StructureWoodVariant.values()[Math.floorMod(oakSwizzle, limit)];
            this.SPRUCE_SWIZZLE = StructureWoodVariant.values()[Math.floorMod(spruceSwizzle, limit)];
            this.BIRCH_SWIZZLE = StructureWoodVariant.values()[Math.floorMod(birchSwizzle, limit)];
        }
        
        @Nullable
        public Template.BlockInfo func_189943_a(final World worldIn, final BlockPos pos, final Template.BlockInfo blockInfo) {
            final IBlockState state = blockInfo.field_186243_b;
            final Block block = state.func_177230_c();
            if (block == Blocks.field_150347_e) {
                return this.random.nextBoolean() ? blockInfo : new Template.BlockInfo(pos, Blocks.field_150341_Y.func_176223_P(), (NBTTagCompound)null);
            }
            if (block == Blocks.field_150463_bK) {
                return this.random.nextBoolean() ? blockInfo : new Template.BlockInfo(pos, state.func_177226_a((IProperty)BlockWall.field_176255_P, (Comparable)BlockWall.EnumType.MOSSY), (NBTTagCompound)null);
            }
            if (block == Blocks.field_150417_aV && state != Blocks.field_150417_aV.func_176223_P().func_177226_a((IProperty)BlockStoneBrick.field_176249_a, (Comparable)BlockStoneBrick.EnumType.CHISELED)) {
                return this.random.nextBoolean() ? blockInfo : new Template.BlockInfo(pos, state.func_177226_a((IProperty)BlockStoneBrick.field_176249_a, (Comparable)BlockStoneBrick.EnumType.values()[this.random.nextInt(3)]), (NBTTagCompound)null);
            }
            final BlockPlanks.EnumType type = StructureWoodVariant.getTypeFromBlockState(state);
            if (type != null) {
                switch (type) {
                    case OAK: {
                        return new Template.BlockInfo(pos, StructureWoodVariant.modifyBlockWithType(state, this.OAK_SWIZZLE), (NBTTagCompound)null);
                    }
                    case SPRUCE: {
                        return new Template.BlockInfo(pos, StructureWoodVariant.modifyBlockWithType(state, this.SPRUCE_SWIZZLE), (NBTTagCompound)null);
                    }
                    case BIRCH: {
                        return new Template.BlockInfo(pos, StructureWoodVariant.modifyBlockWithType(state, this.BIRCH_SWIZZLE), (NBTTagCompound)null);
                    }
                }
            }
            return blockInfo;
        }
    }
}
