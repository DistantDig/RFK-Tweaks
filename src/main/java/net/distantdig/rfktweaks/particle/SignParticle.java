package net.distantdig.rfktweaks.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class SignParticle extends TextureSheetParticle {
    private float startQuadSize;

    protected SignParticle(ClientLevel level, double x, double y, double z, SpriteSet spriteSet) {
        super(level, x, y, z);

        this.gravity = 0.0f;
        this.lifetime = 40;
        this.rCol = 1.0f;
        this.gCol = 1.0f;
        this.bCol = 1.0f;
        this.quadSize = 0.7f;
        this.setSpriteFromAge(spriteSet);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.age == 1) {
            this.startQuadSize = this.quadSize;
        }

        float f = ((float) this.age) / (float) this.lifetime;
        float curve = 1.0f - (1.0f - f) * (1.0f - f);
        float endQuadSize = 0.4f;

        this.quadSize = startQuadSize + (endQuadSize - startQuadSize) * curve;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {
            return new SignParticle(level, x, y, z, this.spriteSet);
        }
    }
}
