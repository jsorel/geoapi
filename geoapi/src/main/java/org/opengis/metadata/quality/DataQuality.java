/*
 *    GeoAPI - Java interfaces for OGC/ISO standards
 *    http://www.geoapi.org
 *
 *    Copyright (C) 2004-2014 Open Geospatial Consortium, Inc.
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
package org.opengis.metadata.quality;

import java.util.Collection;
import org.opengis.metadata.lineage.Lineage;
import org.opengis.annotation.UML;
import org.opengis.annotation.Profile;

import static org.opengis.annotation.Obligation.*;
import static org.opengis.annotation.Specification.*;
import static org.opengis.annotation.ComplianceLevel.*;


/**
 * Quality information for the data specified by a data quality scope.
 * At least one of the {@linkplain #getReports() report} and {@linkplain #getLineage() lineage}
 * shall be provided.
 *
 * @author  Martin Desruisseaux (IRD)
 * @version 3.1
 * @since   2.0
 */
@UML(identifier="DQ_DataQuality", specification=ISO_19115)
public interface DataQuality {
    /**
     * The specific data to which the data quality information applies.
     *
     * <div class="warning"><b>Upcoming API change — renaming</b><br>
     * As of ISO 19115:2014, {@code DQ_Scope} (from {@link org.opengis.metadata.quality}) is replaced by
     * {@code MD_Scope} (from {@link org.opengis.metadata.maintenance}).
     * This change will be applied in GeoAPI 4.0.
     * </div>
     *
     * @return The specific data to which the data quality information applies.
     */
    @UML(identifier="scope", obligation=MANDATORY, specification=ISO_19115)
    Scope getScope();

    /**
     * Quantitative quality information for the data specified by the scope.
     *
     * @return Quantitative quality information for the data.
     *
     * @condition Mandatory if the {@linkplain #getLineage() lineage} is not provided.
     */
    @UML(identifier="report", obligation=CONDITIONAL, specification=ISO_19115)
    Collection<? extends Element> getReports();

    /**
     * Non-quantitative quality information about the lineage of the data specified by the scope.
     *
     * @return Non-quantitative quality information about the lineage of the data specified,
     *         or {@code null}.
     *
     * @condition Mandatory if the {@linkplain #getReports() report} is not provided.
     */
    @Profile(level=CORE)
    @UML(identifier="lineage", obligation=CONDITIONAL, specification=ISO_19115)
    Lineage getLineage();
}
