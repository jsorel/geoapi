/*
 *    GeoAPI - Java interfaces for OGC/ISO standards
 *    http://www.geoapi.org
 *
 *    Copyright (C) 2004-2015 Open Geospatial Consortium, Inc.
 *    All Rights Reserved. http://www.opengeospatial.org/ogc/legal
 *
 *    Permission to use, copy, and modify this software and its documentation, with
 *    or without modification, for any purpose and without fee or royalty is hereby
 *    granted, provided that you include the following on ALL copies of the software
 *    and documentation or portions thereof, including modifications, that you make:
 *
 *    1. The full text of this NOTICE in a location viewable to users of the
 *       redistributed or derivative work.
 *    2. Notice of any changes or modifications to the OGC files, including the
 *       date changes were made.
 *
 *    THIS SOFTWARE AND DOCUMENTATION IS PROVIDED "AS IS," AND COPYRIGHT HOLDERS MAKE
 *    NO REPRESENTATIONS OR WARRANTIES, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 *    TO, WARRANTIES OF MERCHANTABILITY OR FITNESS FOR ANY PARTICULAR PURPOSE OR THAT
 *    THE USE OF THE SOFTWARE OR DOCUMENTATION WILL NOT INFRINGE ANY THIRD PARTY
 *    PATENTS, COPYRIGHTS, TRADEMARKS OR OTHER RIGHTS.
 *
 *    COPYRIGHT HOLDERS WILL NOT BE LIABLE FOR ANY DIRECT, INDIRECT, SPECIAL OR
 *    CONSEQUENTIAL DAMAGES ARISING OUT OF ANY USE OF THE SOFTWARE OR DOCUMENTATION.
 *
 *    The name and trademarks of copyright holders may NOT be used in advertising or
 *    publicity pertaining to the software without specific, written prior permission.
 *    Title to copyright in this software and any associated documentation will at all
 *    times remain with copyright holders.
 */
package org.opengis.tools.version;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Tests the {@link Version} class.
 *
 * @author  Martin Desruisseaux (Geomatys)
 * @version 3.1
 * @since   3.1
 */
public final strictfp class VersionTest {
    /**
     * Tests the version numbers having the documented pattern.
     * This is by contrast with informal pattern that we could
     * eventually support in a future version.
     */
    @Test
    public void testDocumentedVersions() {
        final Version v300 = new Version("3.0.0");
        assertEquals(3, v300.major);
        assertEquals(0, v300.minor);
        assertEquals(0, v300.third);
        assertFalse (v300.isMilestone());
        assertEquals("3.0.0", v300.toString());

        final Version v310 = new Version("3.1.0");
        assertEquals(3, v310.major);
        assertEquals(1, v310.minor);
        assertEquals(0, v310.third);
        assertFalse (v310.isMilestone());
        assertEquals("3.1.0", v310.toString());

        final Version v312 = new Version("3.1.2");
        assertEquals(3, v312.major);
        assertEquals(1, v312.minor);
        assertEquals(2, v312.third);
        assertFalse (v312.isMilestone());
        assertEquals("3.1.2", v312.toString());

        final Version v31M = new Version("3.1-M04");
        assertEquals(3, v31M.major);
        assertEquals(1, v31M.minor);
        assertEquals(0, v31M.third);
        assertTrue  (v31M.isMilestone());
        assertEquals("3.1-M04", v31M.toString());

        assertTrue(v300.compareTo(v300) == 0);
        assertTrue(v300.compareTo(v310) <  0);
        assertTrue(v300.compareTo(v312) <  0);
        assertTrue(v300.compareTo(v31M) <  0);
        assertTrue(v310.compareTo(v300) >  0);
        assertTrue(v310.compareTo(v310) == 0);
        assertTrue(v310.compareTo(v312) <  0);
        assertTrue(v310.compareTo(v31M) >  0);
        assertTrue(v312.compareTo(v300) >  0);
        assertTrue(v312.compareTo(v310) >  0);
        assertTrue(v312.compareTo(v312) == 0);
        assertTrue(v312.compareTo(v31M) >  0);
        assertTrue(v31M.compareTo(v300) >  0);
        assertTrue(v31M.compareTo(v310) <  0);
        assertTrue(v31M.compareTo(v312) <  0);
        assertTrue(v31M.compareTo(v31M) == 0);
    }
}
