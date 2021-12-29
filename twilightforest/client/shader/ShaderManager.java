// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.shader;

import twilightforest.client.TFClientEvents;
import net.minecraftforge.resource.VanillaResourceType;
import java.util.function.Predicate;
import java.io.InputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import twilightforest.TwilightForestMod;
import twilightforest.TFConfig;
import javax.annotation.Nullable;
import java.util.function.IntConsumer;
import org.lwjgl.opengl.ARBShaderObjects;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IFutureReloadListener;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.SimpleReloadableResourceManager;
import net.minecraftforge.resource.ISelectiveResourceReloadListener;

public final class ShaderManager
{
    private static ISelectiveResourceReloadListener shaderReloadListener;
    private static final int VERT = 35633;
    private static final int FRAG = 35632;
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
    
    public static void initShaders() {
        final IResourceManager iManager;
        if ((iManager = Minecraft.func_71410_x().func_195551_G()) instanceof SimpleReloadableResourceManager) {
            ((SimpleReloadableResourceManager)iManager).func_219534_a((IFutureReloadListener)(ShaderManager.shaderReloadListener = ((manager, predicate) -> {
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
            ARBShaderObjects.glDeleteObjectARB(id);
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
        ARBShaderObjects.glUseProgramObjectARB(shader);
        if (shader != 0 && callback != null) {
            callback.accept(shader);
        }
    }
    
    public static void useShader(final int shader, final ShaderUniform uniform) {
        if (!useShaders()) {
            return;
        }
        ARBShaderObjects.glUseProgramObjectARB(shader);
        if (shader != 0) {
            uniform.assignUniform(shader);
        }
    }
    
    public static void useShader(final int shader, final ShaderUniform... uniforms) {
        if (!useShaders()) {
            return;
        }
        ARBShaderObjects.glUseProgramObjectARB(shader);
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
        ARBShaderObjects.glUseProgramObjectARB(shader);
    }
    
    public static void releaseShader() {
        useShader(0);
    }
    
    public static boolean useShaders() {
        return TFConfig.COMMON_CONFIG.PERFORMANCE.shadersSupported;
    }
    
    private static int createProgram(final String vert, final String frag) {
        int vertId = 0;
        int fragId = 0;
        if (vert != null) {
            vertId = createShader("/assets/twilightforest/shaders/" + vert, 35633);
        }
        if (frag != null) {
            fragId = createShader("/assets/twilightforest/shaders/" + frag, 35632);
        }
        final int program = ARBShaderObjects.glCreateProgramObjectARB();
        if (program == 0) {
            return 0;
        }
        if (vert != null) {
            ARBShaderObjects.glAttachObjectARB(program, vertId);
        }
        if (frag != null) {
            ARBShaderObjects.glAttachObjectARB(program, fragId);
        }
        ARBShaderObjects.glLinkProgramARB(program);
        if (ARBShaderObjects.glGetObjectParameteriARB(program, 35714) == 0) {
            TwilightForestMod.LOGGER.error("Failed to create shader! (LINK) {} {}", (Object)vert, (Object)frag);
            TwilightForestMod.LOGGER.error(getInfoLog(program));
            return 0;
        }
        ARBShaderObjects.glValidateProgramARB(program);
        if (ARBShaderObjects.glGetObjectParameteriARB(program, 35715) == 0) {
            TwilightForestMod.LOGGER.error("Failed to create shader! (VALIDATE) {} {}", (Object)vert, (Object)frag);
            TwilightForestMod.LOGGER.error(getInfoLog(program));
            return 0;
        }
        return program;
    }
    
    private static int createShader(final String filename, final int shaderType) {
        int shader = 0;
        try {
            shader = ARBShaderObjects.glCreateShaderObjectARB(shaderType);
            if (shader == 0) {
                return 0;
            }
            ARBShaderObjects.glShaderSourceARB(shader, (CharSequence)readFileAsString(filename));
            ARBShaderObjects.glCompileShaderARB(shader);
            if (ARBShaderObjects.glGetObjectParameteriARB(shader, 35713) == 0) {
                TwilightForestMod.LOGGER.error("Failed to create shader! (COMPILE) {}", (Object)filename);
                throw new RuntimeException("Error creating shader: " + getInfoLog(shader));
            }
            return shader;
        }
        catch (Exception e) {
            ARBShaderObjects.glDeleteObjectARB(shader);
            e.printStackTrace();
            return -1;
        }
    }
    
    private static String readFileAsString(final String path) throws Exception {
        final StringBuilder source = new StringBuilder();
        final InputStream in = ShaderManager.class.getResourceAsStream(path);
        Exception exception = null;
        if (in == null) {
            return "";
        }
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            Exception innerExc = null;
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    source.append(line).append('\n');
                }
            }
            catch (Exception exc) {
                exception = exc;
                try {
                    reader.close();
                }
                catch (Exception exc) {
                    if (innerExc == null) {
                        innerExc = exc;
                    }
                    else {
                        exc.printStackTrace();
                    }
                }
            }
            finally {
                try {
                    reader.close();
                }
                catch (Exception exc2) {
                    if (innerExc == null) {
                        innerExc = exc2;
                    }
                    else {
                        exc2.printStackTrace();
                    }
                }
            }
            if (innerExc != null) {
                throw innerExc;
            }
        }
        catch (Exception exc3) {
            exception = exc3;
        }
        finally {
            try {
                in.close();
            }
            catch (Exception exc4) {
                if (exception == null) {
                    exception = exc4;
                }
                else {
                    exc4.printStackTrace();
                }
            }
            if (exception != null) {
                throw exception;
            }
        }
        return source.toString();
    }
    
    private static String getInfoLog(final int program) {
        return ARBShaderObjects.glGetInfoLogARB(program, ARBShaderObjects.glGetObjectParameteriARB(program, 35716));
    }
    
    static void glUniform2i(final int location, final int v0, final int v1) {
        ARBShaderObjects.glUniform2iARB(location, v0, v1);
    }
    
    static void glUniform1f(final int location, final float v0) {
        ARBShaderObjects.glUniform1fARB(location, v0);
    }
    
    static void glUniform2f(final int location, final float v0, final float v1) {
        ARBShaderObjects.glUniform2fARB(location, v0, v1);
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
            RESOLUTION = ShaderUniform.create("resolution", () -> Minecraft.func_71410_x().func_228018_at_().func_198105_m(), () -> Minecraft.func_71410_x().func_228018_at_().func_198083_n());
            ZERO = ShaderUniform.create("zero", 0);
            ONE = ShaderUniform.create("one", 1);
            TWO = ShaderUniform.create("two", 2);
            STAR_UNIFORMS = new ShaderUniform[] { Uniforms.TIME, Uniforms.YAW, Uniforms.PITCH, Uniforms.RESOLUTION, Uniforms.ZERO, Uniforms.TWO };
            TIME_UNIFORM = new ShaderUniform[] { Uniforms.TIME };
        }
    }
}
