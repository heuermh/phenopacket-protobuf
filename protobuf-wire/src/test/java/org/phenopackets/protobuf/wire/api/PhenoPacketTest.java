package org.phenopackets.protobuf.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;

import org.junit.Before;
import org.junit.Test;

import org.phenopackets.protobuf.wire.api.PhenoPacket;

import org.phenopackets.protobuf.wire.model.Organism;
import org.phenopackets.protobuf.wire.model.Person;
import org.phenopackets.protobuf.wire.model.Variant;

/**
 * Unit test for PhenoPacket.
 */
public final class PhenoPacketTest {
    private Organism organism;
    private Person person;
    private Variant variant;
    private PhenoPacket packet;

    @Before
    public void setUp() {
        organism = new Organism.Builder().build();
        person = new Person.Builder().build();
        variant = new Variant.Builder().build();
        packet = new PhenoPacket.Builder()
            .id("id")
            .title("title")
            .organisms(ImmutableList.of(organism))
            .persons(ImmutableList.of(person))
            .variants(ImmutableList.of(variant))
            .build();
    }

    @Test
    public void testPhenoPacket() {
        assertEquals("id", packet.id);
        assertEquals("title", packet.title);
        assertTrue(packet.organisms.contains(organism));
        assertTrue(packet.persons.contains(person));
        assertTrue(packet.variants.contains(variant));
    }

    @Test
    public void testRoundTrip() throws Exception {
        byte[] bytes = PhenoPacket.ADAPTER.encode(packet);
        PhenoPacket copy = PhenoPacket.ADAPTER.decode(bytes);
        assertEquals(packet.id, copy.id);
        assertEquals(packet.title, copy.title);
        assertEquals(packet.organisms, copy.organisms);
        assertEquals(packet.persons, copy.persons);
        assertEquals(packet.variants, copy.variants);
    }
}
