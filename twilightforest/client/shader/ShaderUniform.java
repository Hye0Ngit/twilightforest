// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.shader;

import java.util.function.IntSupplier;
import net.minecraft.client.renderer.OpenGlHelper;

public abstract class ShaderUniform
{
    protected final String name;
    
    protected ShaderUniform(final String name) {
        this.name = name;
    }
    
    public abstract void assignUniform(final int p0);
    
    public static ShaderUniform create(final String name, final int value) {
        return new ShaderUniform(name) {
            @Override
            public void assignUniform(final int shader) {
                OpenGlHelper.func_153163_f(OpenGlHelper.func_153194_a(shader, (CharSequence)this.name), value);
            }
        };
    }
    
    public static ShaderUniform create(final String name, final IntSupplier supplier) {
        return new ShaderUniform(name) {
            @Override
            public void assignUniform(final int shader) {
                OpenGlHelper.func_153163_f(OpenGlHelper.func_153194_a(shader, (CharSequence)this.name), supplier.getAsInt());
            }
        };
    }
    
    public static ShaderUniform create(final String name, final int value0, final int value1) {
        return new ShaderUniform(name) {
            @Override
            public void assignUniform(final int shader) {
                ShaderManager.glUniform2i(OpenGlHelper.func_153194_a(shader, (CharSequence)this.name), value0, value1);
            }
        };
    }
    
    public static ShaderUniform create(final String name, final IntSupplier supplier0, final IntSupplier supplier1) {
        return new ShaderUniform(name) {
            @Override
            public void assignUniform(final int shader) {
                ShaderManager.glUniform2i(OpenGlHelper.func_153194_a(shader, (CharSequence)this.name), supplier0.getAsInt(), supplier1.getAsInt());
            }
        };
    }
    
    public static ShaderUniform create(final String name, final float value) {
        return new ShaderUniform(name) {
            @Override
            public void assignUniform(final int shader) {
                ShaderManager.glUniform1f(OpenGlHelper.func_153194_a(shader, (CharSequence)this.name), value);
            }
        };
    }
    
    public static ShaderUniform create(final String name, final FloatSupplier supplier) {
        return new ShaderUniform(name) {
            @Override
            public void assignUniform(final int shader) {
                ShaderManager.glUniform1f(OpenGlHelper.func_153194_a(shader, (CharSequence)this.name), supplier.get());
            }
        };
    }
    
    public static ShaderUniform create(final String name, final float value0, final float value1) {
        return new ShaderUniform(name) {
            @Override
            public void assignUniform(final int shader) {
                ShaderManager.glUniform2f(OpenGlHelper.func_153194_a(shader, (CharSequence)this.name), value0, value1);
            }
        };
    }
    
    public static ShaderUniform create(final String name, final FloatSupplier supplier0, final FloatSupplier supplier1) {
        return new ShaderUniform(name) {
            @Override
            public void assignUniform(final int shader) {
                ShaderManager.glUniform2f(OpenGlHelper.func_153194_a(shader, (CharSequence)this.name), supplier0.get(), supplier1.get());
            }
        };
    }
}
