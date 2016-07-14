package org.phenopackets.protobuf.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.phenopackets.protobuf.api.PhenopacketApi.PhenoPacket;

import org.phenopackets.protobuf.model.PhenopacketModel.Organism;
import org.phenopackets.protobuf.model.PhenopacketModel.Person;
import org.phenopackets.protobuf.model.PhenopacketModel.Variant;

/**
 * Unit test for PhenopacketApi.
 */
public final class PhenopacketApiTest {

    @Test
    public void testPhenoPacket() {
        Organism organism = Organism.newBuilder().build();
        Person person = Person.newBuilder().build();
        Variant variant = Variant.newBuilder().build();
        PhenoPacket packet = PhenoPacket.newBuilder()
            .setId("id")
            .setTitle("title")
            .addOrganisms(organism)
            .addPersons(person)
            .addVariants(variant)
            .build();

        assertEquals("id", packet.getId());
        assertEquals("title", packet.getTitle());
        assertTrue(packet.getOrganismsList().contains(organism));
        assertTrue(packet.getPersonsList().contains(person));
        assertTrue(packet.getVariantsList().contains(variant));
    }
}
