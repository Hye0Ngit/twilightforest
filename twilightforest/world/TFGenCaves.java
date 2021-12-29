// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.biomes.TFBiomeHighlands;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import java.util.Random;
import net.minecraft.block.Block;

public class TFGenCaves extends MapGenBase4096
{
    protected void generateLargeCaveNode(final long caveSeed, final int centerX, final int centerZ, final Block[] blockStorage, final double randX, final double randY, final double randZ, final boolean isHighlands) {
        this.generateCaveNode(caveSeed, centerX, centerZ, blockStorage, randX, randY, randZ, 1.0f + this.field_75038_b.nextFloat() * 6.0f, 0.0f, 0.0f, -1, -1, 0.5, isHighlands);
    }
    
    protected void generateCaveNode(final long caveSeed, final int centerX, final int centerZ, final Block[] blockStorage, double randX, double randY, double randZ, float caveSize, float randPI, float angleToGenerate, int loopOne, int loopEnd, final double yScale, boolean isHighlands) {
        final double offsetCenterX = centerX * 16 + 8;
        final double offsetCenterZ = centerZ * 16 + 8;
        float var23 = 0.0f;
        float var24 = 0.0f;
        final Random caveRNG = new Random(caveSeed);
        final Random mossRNG = new Random(caveSeed);
        if (isHighlands) {
            isHighlands = false;
        }
        if (isHighlands && caveSize < 6.0f) {
            caveSize *= 2.5f;
        }
        if (loopEnd <= 0) {
            final int rangeInBlocks = this.field_75040_a * 16 - 16;
            loopEnd = rangeInBlocks - caveRNG.nextInt(rangeInBlocks / 4);
        }
        boolean shouldStop = false;
        if (loopOne == -1) {
            loopOne = loopEnd / 2;
            shouldStop = true;
        }
        final int var25 = caveRNG.nextInt(loopEnd / 2) + loopEnd / 4;
        final boolean var26 = caveRNG.nextInt(6) == 0;
        while (loopOne < loopEnd) {
            final double sizeVar = 1.5 + MathHelper.func_76126_a(loopOne * 3.1415927f / loopEnd) * caveSize * 1.0f;
            final double scaledSize = sizeVar * yScale;
            final float cosAngle = MathHelper.func_76134_b(angleToGenerate);
            final float sinAngle = MathHelper.func_76126_a(angleToGenerate);
            randX += MathHelper.func_76134_b(randPI) * cosAngle;
            randY += sinAngle;
            randZ += MathHelper.func_76126_a(randPI) * cosAngle;
            if (var26) {
                angleToGenerate *= 0.92f;
            }
            else {
                angleToGenerate *= 0.7f;
            }
            angleToGenerate += var24 * 0.1f;
            randPI += var23 * 0.1f;
            var24 *= 0.9f;
            var23 *= 0.75f;
            var24 += (caveRNG.nextFloat() - caveRNG.nextFloat()) * caveRNG.nextFloat() * 2.0f;
            var23 += (caveRNG.nextFloat() - caveRNG.nextFloat()) * caveRNG.nextFloat() * 4.0f;
            if (!shouldStop && loopOne == var25 && caveSize > 1.0f && loopEnd > 0) {
                this.generateCaveNode(caveRNG.nextLong(), centerX, centerZ, blockStorage, randX, randY, randZ, caveRNG.nextFloat() * 0.5f + 0.5f, randPI - 1.5707964f, angleToGenerate / 3.0f, loopOne, loopEnd, 1.0, isHighlands);
                this.generateCaveNode(caveRNG.nextLong(), centerX, centerZ, blockStorage, randX, randY, randZ, caveRNG.nextFloat() * 0.5f + 0.5f, randPI + 1.5707964f, angleToGenerate / 3.0f, loopOne, loopEnd, 1.0, isHighlands);
                return;
            }
            if (shouldStop || caveRNG.nextInt(4) != 0) {
                final double distX = randX - offsetCenterX;
                final double distZ = randZ - offsetCenterZ;
                final double var27 = loopEnd - loopOne;
                final double sizeSixteen = caveSize + 2.0f + 16.0f;
                if (distX * distX + distZ * distZ - var27 * var27 > sizeSixteen * sizeSixteen) {
                    return;
                }
                if (randX >= offsetCenterX - 16.0 - sizeVar * 2.0 && randZ >= offsetCenterZ - 16.0 - sizeVar * 2.0 && randX <= offsetCenterX + 16.0 + sizeVar * 2.0 && randZ <= offsetCenterZ + 16.0 + sizeVar * 2.0) {
                    int minX = MathHelper.func_76128_c(randX - sizeVar) - centerX * 16 - 1;
                    int maxX = MathHelper.func_76128_c(randX + sizeVar) - centerX * 16 + 1;
                    int maxY = MathHelper.func_76128_c(randY - scaledSize) - 1;
                    int minY = MathHelper.func_76128_c(randY + scaledSize) + 1;
                    int minZ = MathHelper.func_76128_c(randZ - sizeVar) - centerZ * 16 - 1;
                    int maxZ = MathHelper.func_76128_c(randZ + sizeVar) - centerZ * 16 + 1;
                    if (minX < 0) {
                        minX = 0;
                    }
                    if (maxX > 16) {
                        maxX = 16;
                    }
                    if (maxY < 1) {
                        maxY = 1;
                    }
                    if (minY > 120) {
                        minY = 120;
                    }
                    if (minZ < 0) {
                        minZ = 0;
                    }
                    if (maxZ > 16) {
                        maxZ = 16;
                    }
                    boolean hasHitWater = false;
                    for (int genX = minX; !hasHitWater && genX < maxX; ++genX) {
                        for (int genZ = minZ; !hasHitWater && genZ < maxZ; ++genZ) {
                            for (int genY = minY + 1; !hasHitWater && genY >= maxY - 1; --genY) {
                                final int waterIndex = (genX * 16 + genZ) * 128 + genY;
                                if (genY >= 0 && genY < 128) {
                                    if (this.isOceanBlock(blockStorage, waterIndex, genX, genY, genZ, centerX, centerZ)) {
                                        hasHitWater = true;
                                    }
                                    if (genY != maxY - 1 && genX != minX && genX != maxX - 1 && genZ != minZ && genZ != maxZ - 1) {
                                        genY = maxY;
                                    }
                                }
                            }
                        }
                    }
                    if (!hasHitWater) {
                        for (int genX = minX; genX < maxX; ++genX) {
                            final double var28 = (genX + centerX * 16 + 0.5 - randX) / sizeVar;
                            for (int genZ = minZ; genZ < maxZ; ++genZ) {
                                final double var29 = (genZ + centerZ * 16 + 0.5 - randZ) / sizeVar;
                                int caveIndex = (genX * 16 + genZ) * TFWorld.CHUNKHEIGHT + minY;
                                boolean hitGrass = false;
                                if (var28 * var28 + var29 * var29 < 1.0) {
                                    for (int caveY = minY - 1; caveY >= maxY; --caveY) {
                                        final double var30 = (caveY + 0.5 - randY) / scaledSize;
                                        if (var30 > -0.7 && var28 * var28 + var30 * var30 + var29 * var29 < 20.0) {
                                            final Block blockAt = blockStorage[caveIndex];
                                            if (blockAt == Blocks.field_150349_c) {
                                                hitGrass = true;
                                            }
                                            if (blockAt != null && (blockAt.func_149688_o() == Material.field_151576_e || blockAt.func_149688_o() == Material.field_151578_c || blockAt.func_149688_o() == Material.field_151577_b)) {
                                                if (var28 * var28 + var30 * var30 + var29 * var29 < 0.85) {
                                                    blockStorage[caveIndex] = ((caveY < 10) ? Blocks.field_150355_j : Blocks.field_150350_a);
                                                }
                                                else {
                                                    final Block localBlock = isHighlands ? ((mossRNG.nextInt(6) == 0) ? TFBlocks.trollSteinn : Blocks.field_150348_b) : Blocks.field_150346_d;
                                                    blockStorage[caveIndex] = (Block)(hitGrass ? Blocks.field_150349_c : localBlock);
                                                    hitGrass = false;
                                                }
                                                if (hitGrass && blockStorage[caveIndex - 1] == Blocks.field_150346_d) {
                                                    blockStorage[caveIndex - 1] = this.field_75039_c.func_72807_a(genX + centerX * 16, genZ + centerZ * 16).field_76752_A;
                                                }
                                            }
                                        }
                                        --caveIndex;
                                    }
                                }
                            }
                        }
                        if (shouldStop) {
                            break;
                        }
                    }
                }
            }
            ++loopOne;
        }
    }
    
    @Override
    protected void recursiveGenerate(final World par1World, final int genX, final int genZ, final int centerX, final int centerZ, final Block[] blockStorage) {
        int numberOfCaves = this.field_75038_b.nextInt(this.field_75038_b.nextInt(this.field_75038_b.nextInt(40) + 1) + 1);
        final boolean isHighlands = par1World.func_72807_a(genX * 16, genZ * 16) instanceof TFBiomeHighlands;
        if (this.field_75038_b.nextInt(15) != 0) {
            numberOfCaves = 0;
        }
        for (int i = 0; i < numberOfCaves; ++i) {
            final double randX = genX * 16 + this.field_75038_b.nextInt(16);
            final double randY = this.field_75038_b.nextInt(this.field_75038_b.nextInt(120) + 8);
            final double randZ = genZ * 16 + this.field_75038_b.nextInt(16);
            int numberOfNormalNodes = 1;
            if (this.field_75038_b.nextInt(4) == 0) {
                this.generateLargeCaveNode(this.field_75038_b.nextLong(), centerX, centerZ, blockStorage, randX, randY, randZ, isHighlands);
                numberOfNormalNodes += this.field_75038_b.nextInt(4);
            }
            for (int j = 0; j < numberOfNormalNodes; ++j) {
                final float randPi = this.field_75038_b.nextFloat() * 3.1415927f * 2.0f;
                final float randEight = (this.field_75038_b.nextFloat() - 0.5f) * 2.0f / 8.0f;
                float caveSize = this.field_75038_b.nextFloat() * 2.0f + this.field_75038_b.nextFloat();
                if (this.field_75038_b.nextInt(10) == 0) {
                    caveSize *= this.field_75038_b.nextFloat() * this.field_75038_b.nextFloat() * 3.0f + 1.0f;
                }
                this.generateCaveNode(this.field_75038_b.nextLong(), centerX, centerZ, blockStorage, randX, randY, randZ, caveSize, randPi, randEight, 0, 0, 1.0, isHighlands);
            }
        }
    }
    
    protected boolean isOceanBlock(final Block[] data, final int index, final int x, final int y, final int z, final int chunkX, final int chunkZ) {
        return data[index] == Blocks.field_150358_i || data[index] == Blocks.field_150355_j;
    }
}
