package com.drd.backported.init;

import com.drd.backported.Backported;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Backported.MOD_ID, Registries.SOUND_EVENT);

    // Bats and Pots
    public static final RegistrySupplier<SoundEvent> DECORATED_POT_BREAK = registerSoundEvents("block.decorated_pot.break");
    public static final RegistrySupplier<SoundEvent> DECORATED_POT_STEP = registerSoundEvents("block.decorated_pot.step");
    public static final RegistrySupplier<SoundEvent> DECORATED_POT_FALL = registerSoundEvents("block.decorated_pot.fall");
    public static final RegistrySupplier<SoundEvent> DECORATED_POT_PLACE = registerSoundEvents("block.decorated_pot.place");
    public static final RegistrySupplier<SoundEvent> DECORATED_POT_HIT = registerSoundEvents("block.decorated_pot.hit");
    public static final RegistrySupplier<SoundEvent> DECORATED_POT_INSERT = registerSoundEvents("block.decorated_pot.insert");
    public static final RegistrySupplier<SoundEvent> DECORATED_POT_INSERT_FAIL = registerSoundEvents("block.decorated_pot.insert_fail");
    public static final RegistrySupplier<SoundEvent> DECORATED_POT_SHATTER = registerSoundEvents("block.decorated_pot.shatter");

    // Armored Paws
    public static final RegistrySupplier<SoundEvent> ARMOR_EQUIP_WOLF = registerSoundEvents("item.armor.equip_wolf");
    public static final RegistrySupplier<SoundEvent> ARMOR_UNEQUIP_WOLF = registerSoundEvents("item.armor.unequip_wolf");
    public static final RegistrySupplier<SoundEvent> WOLF_ARMOR_BREAK = registerSoundEvents("item.wolf_armor.break");
    public static final RegistrySupplier<SoundEvent> WOLF_ARMOR_CRACK = registerSoundEvents("item.wolf_armor.crack");
    public static final RegistrySupplier<SoundEvent> WOLF_ARMOR_DAMAGE = registerSoundEvents("item.wolf_armor.damage");
    public static final RegistrySupplier<SoundEvent> WOLF_ARMOR_REPAIR = registerSoundEvents("item.wolf_armor.repair");

    // Tricky Trials
    public static final RegistrySupplier<SoundEvent> COPPER_BULB_BREAK = registerSoundEvents("block.copper_bulb.break");
    public static final RegistrySupplier<SoundEvent> COPPER_BULB_STEP = registerSoundEvents("block.copper_bulb.step");
    public static final RegistrySupplier<SoundEvent> COPPER_BULB_FALL = registerSoundEvents("block.copper_bulb.fall");
    public static final RegistrySupplier<SoundEvent> COPPER_BULB_PLACE = registerSoundEvents("block.copper_bulb.place");
    public static final RegistrySupplier<SoundEvent> COPPER_BULB_HIT = registerSoundEvents("block.copper_bulb.hit");
    public static final RegistrySupplier<SoundEvent> COPPER_BULB_TURN_ON = registerSoundEvents("block.copper_bulb.turn_on");
    public static final RegistrySupplier<SoundEvent> COPPER_BULB_TURN_OFF = registerSoundEvents("block.copper_bulb.turn_off");
    public static final RegistrySupplier<SoundEvent> COPPER_DOOR_CLOSE = registerSoundEvents("block.copper_door.close");
    public static final RegistrySupplier<SoundEvent> COPPER_DOOR_OPEN = registerSoundEvents("block.copper_door.open");
    public static final RegistrySupplier<SoundEvent> COPPER_GRATE_BREAK = registerSoundEvents("block.copper_grate.break");
    public static final RegistrySupplier<SoundEvent> COPPER_GRATE_STEP = registerSoundEvents("block.copper_grate.step");
    public static final RegistrySupplier<SoundEvent> COPPER_GRATE_FALL = registerSoundEvents("block.copper_grate.fall");
    public static final RegistrySupplier<SoundEvent> COPPER_GRATE_PLACE = registerSoundEvents("block.copper_grate.place");
    public static final RegistrySupplier<SoundEvent> COPPER_GRATE_HIT = registerSoundEvents("block.copper_grate.hit");
    public static final RegistrySupplier<SoundEvent> COPPER_TRAPDOOR_CLOSE = registerSoundEvents("block.copper_trapdoor.close");
    public static final RegistrySupplier<SoundEvent> COPPER_TRAPDOOR_OPEN = registerSoundEvents("block.copper_trapdoor.open");
    public static final RegistrySupplier<SoundEvent> HEAVY_CORE_BREAK = registerSoundEvents("block.heavy_core.break");
    public static final RegistrySupplier<SoundEvent> HEAVY_CORE_STEP = registerSoundEvents("block.heavy_core.step");
    public static final RegistrySupplier<SoundEvent> HEAVY_CORE_FALL = registerSoundEvents("block.heavy_core.fall");
    public static final RegistrySupplier<SoundEvent> HEAVY_CORE_PLACE = registerSoundEvents("block.heavy_core.place");
    public static final RegistrySupplier<SoundEvent> HEAVY_CORE_HIT = registerSoundEvents("block.heavy_core.hit");
    public static final RegistrySupplier<SoundEvent> POLISHED_TUFF_BREAK = registerSoundEvents("block.polished_tuff.break");
    public static final RegistrySupplier<SoundEvent> POLISHED_TUFF_STEP = registerSoundEvents("block.polished_tuff.step");
    public static final RegistrySupplier<SoundEvent> POLISHED_TUFF_FALL = registerSoundEvents("block.polished_tuff.fall");
    public static final RegistrySupplier<SoundEvent> POLISHED_TUFF_PLACE = registerSoundEvents("block.polished_tuff.place");
    public static final RegistrySupplier<SoundEvent> POLISHED_TUFF_HIT = registerSoundEvents("block.polished_tuff.hit");
    public static final RegistrySupplier<SoundEvent> TUFF_BRICKS_BREAK = registerSoundEvents("block.tuff_bricks.break");
    public static final RegistrySupplier<SoundEvent> TUFF_BRICKS_STEP = registerSoundEvents("block.tuff_bricks.step");
    public static final RegistrySupplier<SoundEvent> TUFF_BRICKS_FALL = registerSoundEvents("block.tuff_bricks.fall");
    public static final RegistrySupplier<SoundEvent> TUFF_BRICKS_PLACE = registerSoundEvents("block.tuff_bricks.place");
    public static final RegistrySupplier<SoundEvent> TUFF_BRICKS_HIT = registerSoundEvents("block.tuff_bricks.hit");
    public static final RegistrySupplier<SoundEvent> WIND_CHARGE_THROW = registerSoundEvents("entity.wind_charge.throw");
    public static final RegistrySupplier<SoundEvent> WIND_CHARGE_BURST = registerSoundEvents("entity.wind_charge.wind_burst");
    public static final RegistrySupplier<SoundEvent> MACE_SMASH_AIR = registerSoundEvents("item.mace.smash_air");
    public static final RegistrySupplier<SoundEvent> MACE_SMASH_GROUND = registerSoundEvents("item.mace.smash_ground");
    public static final RegistrySupplier<SoundEvent> MACE_SMASH_GROUND_HEAVY = registerSoundEvents("item.mace.smash_ground_heavy");
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_CREATOR = registerMusicDisc("creator");
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_CREATOR_MUSIC_BOX = registerMusicDisc("creator_music_box");
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_PRECIPICE = registerMusicDisc("precipice");

    // The Garden Awakens
    public static final RegistrySupplier<SoundEvent> RESIN_BREAK = registerSoundEvents("block.resin.break");
    public static final RegistrySupplier<SoundEvent> RESIN_STEP = registerSoundEvents("block.resin.step");
    public static final RegistrySupplier<SoundEvent> RESIN_FALL = registerSoundEvents("block.resin.fall");
    public static final RegistrySupplier<SoundEvent> RESIN_PLACE = registerSoundEvents("block.resin.place");
    public static final RegistrySupplier<SoundEvent> RESIN_HIT = registerSoundEvents("block.resin.hit");
    public static final RegistrySupplier<SoundEvent> RESIN_BRICKS_BREAK = registerSoundEvents("block.resin_bricks.break");
    public static final RegistrySupplier<SoundEvent> RESIN_BRICKS_STEP = registerSoundEvents("block.resin_bricks.step");
    public static final RegistrySupplier<SoundEvent> RESIN_BRICKS_FALL = registerSoundEvents("block.resin_bricks.fall");
    public static final RegistrySupplier<SoundEvent> RESIN_BRICKS_PLACE = registerSoundEvents("block.resin_bricks.place");
    public static final RegistrySupplier<SoundEvent> RESIN_BRICKS_HIT = registerSoundEvents("block.resin_bricks.hit");

    // Spring to Life
    public static final RegistrySupplier<SoundEvent> FIREFLY_BUSH_IDLE = registerSoundEvents("block.firefly_bush.idle");

    // Chase the Skies
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_LAVA_CHICKEN = registerMusicDisc("lava_chicken");
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_TEARS = registerMusicDisc("tears");

    // The Copper Age
    public static final RegistrySupplier<SoundEvent> SHELF_ACTIVATE = registerSoundEvents("block.shelf.activate");
    public static final RegistrySupplier<SoundEvent> SHELF_DEACTIVATE = registerSoundEvents("block.shelf.deactivate");
    public static final RegistrySupplier<SoundEvent> SHELF_MULTI_SWAP = registerSoundEvents("block.shelf.multi_swap");
    public static final RegistrySupplier<SoundEvent> SHELF_PLACE_ITEM = registerSoundEvents("block.shelf.place_item");
    public static final RegistrySupplier<SoundEvent> SHELF_SINGLE_SWAP = registerSoundEvents("block.shelf.single_swap");
    public static final RegistrySupplier<SoundEvent> SHELF_TAKE_ITEM = registerSoundEvents("block.shelf.take_item");
    public static final RegistrySupplier<SoundEvent> ARMOR_EQUIP_COPPER = registerSoundEvents("item.armor.equip_copper");

    // Mounts of Mayhem
    public static final RegistrySupplier<SoundEvent> SPEAR_ATTACK = registerSoundEvents("item.spear.attack");
    public static final RegistrySupplier<SoundEvent> SPEAR_HIT = registerSoundEvents("item.spear.hit");
    public static final RegistrySupplier<SoundEvent> SPEAR_LUNGE = registerSoundEvents("item.spear.lunge");
    public static final RegistrySupplier<SoundEvent> SPEAR_USE = registerSoundEvents("item.spear.use");
    public static final RegistrySupplier<SoundEvent> SPEAR_WOOD_ATTACK = registerSoundEvents("item.spear_wood.attack");
    public static final RegistrySupplier<SoundEvent> SPEAR_WOOD_HIT = registerSoundEvents("item.spear_wood.hit");
    public static final RegistrySupplier<SoundEvent> SPEAR_WOOD_USE = registerSoundEvents("item.spear_wood.use");

    private static RegistrySupplier<SoundEvent> registerSoundEvents(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Backported.MOD_ID, name)));
    }

    private static RegistrySupplier<SoundEvent> registerMusicDisc(String name) {
        return SOUNDS.register("music_disc." + name, () ->
                SoundEvent.createFixedRangeEvent(new ResourceLocation(Backported.MOD_ID, "music_disc." + name), 16f)
        );
    }

    public static void register() {
        SOUNDS.register();
    }
}
