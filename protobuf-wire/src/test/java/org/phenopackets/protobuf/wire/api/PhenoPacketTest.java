package org.phenopackets.protobuf.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import org.phenopackets.protobuf.wire.api.PhenoPacket;

import org.phenopackets.protobuf.wire.model.Organism;
import org.phenopackets.protobuf.wire.model.Person;
import org.phenopackets.protobuf.wire.model.Variant;

/**
 * Unit test for PhenoPacket.
 */
public final class PhenoPacketTest {

    @Test
    public void testPhenoPacket() {
        Organism organism = new Organism.Builder().build();
        Person person = new Person.Builder().build();
        Variant variant = new Variant.Builder().build();
        PhenoPacket packet = new PhenoPacket.Builder()
            .id("id")
            .title("title")
            .organisms(ImmutableList.of(organism))
            .persons(ImmutableList.of(person))
            .variants(ImmutableList.of(variant))
            .build();

        assertEquals("id", packet.id);
        assertEquals("title", packet.title);
        assertTrue(packet.organisms.contains(organism));
        assertTrue(packet.persons.contains(person));
        assertTrue(packet.variants.contains(variant));
    }
}
