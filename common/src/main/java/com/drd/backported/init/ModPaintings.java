package com.drd.backported.init;

import com.drd.backported.Backported;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(Backported.MOD_ID, Registries.PAINTING_VARIANT);

    // Tricky Trials
    public static final RegistrySupplier<PaintingVariant> MEDITATIVE = registerPainting("meditative", 1, 1);
    public static final RegistrySupplier<PaintingVariant> PRAIRIE_RIDE = registerPainting("prairie_ride", 1, 2);
    public static final RegistrySupplier<PaintingVariant> BAROQUE = registerPainting("baroque", 2, 2);
    public static final RegistrySupplier<PaintingVariant> HUMBLE = registerPainting("humble", 2, 2);
    public static final RegistrySupplier<PaintingVariant> UNPACKED = registerPainting("unpacked", 4, 4);
    public static final RegistrySupplier<PaintingVariant> BOUQUET = registerPainting("bouquet", 3, 3);
    public static final RegistrySupplier<PaintingVariant> CAVEBIRD = registerPainting("cavebird", 3, 3);
    public static final RegistrySupplier<PaintingVariant> COTAN = registerPainting("cotan", 3, 3);
    public static final RegistrySupplier<PaintingVariant> ENDBOSS = registerPainting("endboss", 3, 3);
    public static final RegistrySupplier<PaintingVariant> FERN = registerPainting("fern", 3, 3);
    public static final RegistrySupplier<PaintingVariant> OWLEMONS = registerPainting("owlemons", 3, 3);
    public static final RegistrySupplier<PaintingVariant> SUNFLOWERS = registerPainting("sunflowers", 3, 3);
    public static final RegistrySupplier<PaintingVariant> TIDES = registerPainting("tides", 3, 3);
    public static final RegistrySupplier<PaintingVariant> BACKYARD = registerPainting("backyard", 3, 4);
    public static final RegistrySupplier<PaintingVariant> POND = registerPainting("pond", 3, 4);
    public static final RegistrySupplier<PaintingVariant> CHANGING = registerPainting("changing", 4, 2);
    public static final RegistrySupplier<PaintingVariant> FINDING = registerPainting("finding", 4, 2);
    public static final RegistrySupplier<PaintingVariant> LOWMIST = registerPainting("lowmist", 4, 2);
    public static final RegistrySupplier<PaintingVariant> PASSAGE = registerPainting("passage", 4, 2);
    public static final RegistrySupplier<PaintingVariant> ORB = registerPainting("orb", 4, 4);

    // Chase the Skies
    public static final RegistrySupplier<PaintingVariant> DENNIS = registerPainting("dennis", 3, 3);

    private static RegistrySupplier<PaintingVariant> registerPainting(String name, int width, int height) {
        return PAINTINGS.register(name, () -> new PaintingVariant(width * 16, height * 16));
    }

    public static void register() {
        PAINTINGS.register();
    }
}
