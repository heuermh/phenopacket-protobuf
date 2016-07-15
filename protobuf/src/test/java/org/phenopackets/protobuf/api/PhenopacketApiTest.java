package org.phenopackets.protobuf.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import org.phenopackets.protobuf.api.PhenopacketApi.PhenoPacket;

import org.phenopackets.protobuf.model.PhenopacketModel.Organism;
import org.phenopackets.protobuf.model.PhenopacketModel.Person;
import org.phenopackets.protobuf.model.PhenopacketModel.Variant;

/**
 * Unit test for PhenopacketApi.
 */
public final class PhenopacketApiTest {
    private Organism organism;
    private Person person;
    private Variant variant;
    private PhenoPacket packet;

    @Before
    public void setUp() {
        organism = Organism.newBuilder().build();
        person = Person.newBuilder().build();
        variant = Variant.newBuilder().build();
        packet = PhenoPacket.newBuilder()
            .setId("id")
            .setTitle("title")
            .addOrganisms(organism)
            .addPersons(person)
            .addVariants(variant)
            .build();
    }

    @Test
    public void testPhenoPacket() {
        assertEquals("id", packet.getId());
        assertEquals("title", packet.getTitle());
        assertTrue(packet.getOrganismsList().contains(organism));
        assertTrue(packet.getPersonsList().contains(person));
        assertTrue(packet.getVariantsList().contains(variant));
    }

    @Test
    public void testRoundTrip() throws Exception {
        byte[] bytes = packet.toByteArray();
        PhenoPacket copy = PhenoPacket.parseFrom(bytes);
        assertEquals(packet.getId(), copy.getId());
        assertEquals(packet.getTitle(), copy.getTitle());
        assertEquals(packet.getOrganismsList(), copy.getOrganismsList());
        assertEquals(packet.getPersonsList(), copy.getPersonsList());
        assertEquals(packet.getVariantsList(), copy.getVariantsList());
    }
}
