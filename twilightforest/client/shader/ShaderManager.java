// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.shader;

import twilightforest.client.TFClientEvents;
import net.minecraftforge.client.resource.VanillaResourceType;
import java.util.function.Predicate;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.ARBShaderObjects;
import java.io.IOException;
import java.io.InputStream;
import org.lwjgl.BufferUtils;
import org.apache.commons.io.IOUtils;
import java.nio.ByteBuffer;
import twilightforest.TwilightForestMod;
import twilightforest.TFConfig;
import javax.annotation.Nullable;
import java.util.function.IntConsumer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraftforge.client.resource.ISelectiveResourceReloadListener;

public final class ShaderManager
{
    private static ISelectiveResourceReloadListener shaderReloadListener;
    private static final int VERT;
    private static final int FRAG;
    private static final String PREFIX = "/assets/twilightforest/shaders/";
    public static int enderPortalShader;
    public static int twilightSkyShader;
    public static int fireflyShader;
    public static int auroraShader;
    public static int carminiteShader;
    public static int towerDeviceShader;
    public static int yellowCircuitShader;
    public static int bloomShader;
    public static int starburstShader;
    public static int shieldShader;
    public static int outlineShader;
    private static final int INFO_LOG_LENGTH;
    private static final int VALIDATE_STATUS;
    
    public static void initShaders() {
        final IResourceManager iManager;
        if ((iManager = Minecraft.func_71410_x().func_110442_L()) instanceof SimpleReloadableResourceManager) {
            ((SimpleReloadableResourceManager)iManager).func_110542_a((IResourceManagerReloadListener)(ShaderManager.shaderReloadListener = ((manager, predicate) -> {
                if (predicate.test(VanillaResourceType.SHADERS)) {
                    reloadShaders();
                }
            })));
        }
    }
    
    public static ISelectiveResourceReloadListener getShaderReloadListener() {
        return ShaderManager.shaderReloadListener;
    }
    
    private static void reloadShaders() {
        deleteProgram(ShaderManager.twilightSkyShader);
        deleteProgram(ShaderManager.fireflyShader);
        deleteProgram(ShaderManager.auroraShader);
        deleteProgram(ShaderManager.carminiteShader);
        deleteProgram(ShaderManager.towerDeviceShader);
        deleteProgram(ShaderManager.yellowCircuitShader);
        deleteProgram(ShaderManager.starburstShader);
        initShaderList();
    }
    
    private static void deleteProgram(final int id) {
        if (id != 0) {
            OpenGlHelper.func_153187_e(id);
        }
    }
    
    private static void initShaderList() {
        ShaderManager.twilightSkyShader = createProgram("standard_texcoord.vert", "twilight_sky.frag");
        ShaderManager.fireflyShader = createProgram("standard_texcoord2.vert", "firefly.frag");
        ShaderManager.auroraShader = createProgram("standard_texcoord2.vert", "aurora.frag");
        ShaderManager.carminiteShader = createProgram("camera_fixed.vert", "spiral.frag");
        ShaderManager.towerDeviceShader = createProgram("camera_fixed.vert", "pulsing.frag");
        ShaderManager.yellowCircuitShader = createProgram("standard_texcoord2.vert", "pulsing_yellow.frag");
        ShaderManager.starburstShader = createProgram("standard_texcoord2.vert", "starburst.frag");
        ShaderManager.shieldShader = createProgram("standard_texcoord2.vert", "shield.frag");
    }
    
    public static void useShader(final int shader, @Nullable final IntConsumer callback) {
        if (!useShaders()) {
            return;
        }
        OpenGlHelper.func_153161_d(shader);
        if (shader != 0 && callback != null) {
            callback.accept(shader);
        }
    }
    
    public static void useShader(final int shader, final ShaderUniform uniform) {
        if (!useShaders()) {
            return;
        }
        OpenGlHelper.func_153161_d(shader);
        if (shader != 0) {
            uniform.assignUniform(shader);
        }
    }
    
    public static void useShader(final int shader, final ShaderUniform... uniforms) {
        if (!useShaders()) {
            return;
        }
        OpenGlHelper.func_153161_d(shader);
        if (shader != 0) {
            for (final ShaderUniform uniform : uniforms) {
                uniform.assignUniform(shader);
            }
        }
    }
    
    public static void useShader(final int shader) {
        if (!useShaders()) {
            return;
        }
        OpenGlHelper.func_153161_d(shader);
    }
    
    public static void releaseShader() {
        useShader(0);
    }
    
    public static boolean useShaders() {
        return TFConfig.performance.shadersSupported && OpenGlHelper.field_148824_g;
    }
    
    private static int createProgram(final String vert, final String frag) {
        final int program = OpenGlHelper.func_153183_d();
        if (program == 0) {
            return 0;
        }
        final int vertId = createShader("/assets/twilightforest/shaders/" + vert, ShaderManager.VERT);
        OpenGlHelper.func_153178_b(program, vertId);
        final int fragId = createShader("/assets/twilightforest/shaders/" + frag, ShaderManager.FRAG);
        OpenGlHelper.func_153178_b(program, fragId);
        OpenGlHelper.func_153179_f(program);
        if (OpenGlHelper.func_153175_a(program, OpenGlHelper.field_153207_o) == 0) {
            TwilightForestMod.LOGGER.error("Failed to create shader! (LINK) {} {}", (Object)vert, (Object)frag);
            TwilightForestMod.LOGGER.error(getProgramInfoLog(program));
            return 0;
        }
        glValidateProgram(program);
        if (OpenGlHelper.func_153175_a(program, ShaderManager.VALIDATE_STATUS) == 0) {
            TwilightForestMod.LOGGER.error("Failed to create shader! (VALIDATE) {} {}", (Object)vert, (Object)frag);
            TwilightForestMod.LOGGER.error(getProgramInfoLog(program));
            return 0;
        }
        return program;
    }
    
    private static int createShader(final String filename, final int shaderType) {
        int shader = 0;
        try {
            shader = OpenGlHelper.func_153195_b(shaderType);
            if (shader == 0) {
                return 0;
            }
            OpenGlHelper.func_153169_a(shader, readFile(filename));
            OpenGlHelper.func_153170_c(shader);
            if (OpenGlHelper.func_153157_c(shader, OpenGlHelper.field_153208_p) == 0) {
                TwilightForestMod.LOGGER.error("Failed to create shader! (COMPILE) {}", (Object)filename);
                throw new RuntimeException("Error creating shader: " + getShaderInfoLog(shader));
            }
            return shader;
        }
        catch (Exception e) {
            OpenGlHelper.func_153180_a(shader);
            e.printStackTrace();
            return -1;
        }
    }
    
    private static ByteBuffer readFile(final String path) throws IOException {
        try (final InputStream in = ShaderManager.class.getResourceAsStream(path)) {
            final byte[] bytes = IOUtils.toByteArray(in);
            return (ByteBuffer)BufferUtils.createByteBuffer(bytes.length).put(bytes).position(0);
        }
    }
    
    private static String getShaderInfoLog(final int shader) {
        return OpenGlHelper.func_153158_d(shader, OpenGlHelper.func_153157_c(shader, ShaderManager.INFO_LOG_LENGTH));
    }
    
    private static String getProgramInfoLog(final int program) {
        return OpenGlHelper.func_153166_e(program, OpenGlHelper.func_153175_a(program, ShaderManager.INFO_LOG_LENGTH));
    }
    
    private static void glValidateProgram(final int program) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glValidateProgramARB(program);
        }
        else {
            GL20.glValidateProgram(program);
        }
    }
    
    static void glUniform2i(final int location, final int v0, final int v1) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniform2iARB(location, v0, v1);
        }
        else {
            GL20.glUniform2i(location, v0, v1);
        }
    }
    
    static void glUniform1f(final int location, final float v0) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniform1fARB(location, v0);
        }
        else {
            GL20.glUniform1f(location, v0);
        }
    }
    
    static void glUniform2f(final int location, final float v0, final float v1) {
        if (OpenGlHelper.field_153214_y) {
            ARBShaderObjects.glUniform2fARB(location, v0, v1);
        }
        else {
            GL20.glUniform2f(location, v0, v1);
        }
    }
    
    static {
        VERT = (OpenGlHelper.field_153214_y ? 35633 : 35633);
        FRAG = (OpenGlHelper.field_153214_y ? 35632 : 35632);
        INFO_LOG_LENGTH = (OpenGlHelper.field_153214_y ? 35716 : 35716);
        VALIDATE_STATUS = (OpenGlHelper.field_153214_y ? 35715 : 35715);
    }
    
    public static final class Uniforms
    {
        public static final ShaderUniform TIME;
        public static final ShaderUniform YAW;
        public static final ShaderUniform PITCH;
        public static final ShaderUniform RESOLUTION;
        public static final ShaderUniform ZERO;
        public static final ShaderUniform ONE;
        public static final ShaderUniform TWO;
        public static final ShaderUniform[] STAR_UNIFORMS;
        public static final ShaderUniform[] TIME_UNIFORM;
        
        static {
            TIME = ShaderUniform.create("time", () -> TFClientEvents.time + Minecraft.func_71410_x().func_184121_ak());
            YAW = ShaderUniform.create("yaw", () -> Minecraft.func_71410_x().field_71439_g.field_70177_z * 2.0f * 3.1415927f / 360.0f);
            PITCH = ShaderUniform.create("pitch", () -> -(Minecraft.func_71410_x().field_71439_g.field_70125_A * 2.0f * 3.1415927f) / 360.0f);
            RESOLUTION = ShaderUniform.create("resolution", () -> Minecraft.func_71410_x().field_71443_c, () -> Minecraft.func_71410_x().field_71440_d);
            ZERO = ShaderUniform.create("zero", 0);
            ONE = ShaderUniform.create("one", 1);
            TWO = ShaderUniform.create("two", 2);
            STAR_UNIFORMS = new ShaderUniform[] { Uniforms.TIME, Uniforms.YAW, Uniforms.PITCH, Uniforms.RESOLUTION, Uniforms.ZERO, Uniforms.TWO };
            TIME_UNIFORM = new ShaderUniform[] { Uniforms.TIME };
        }
    }
}
