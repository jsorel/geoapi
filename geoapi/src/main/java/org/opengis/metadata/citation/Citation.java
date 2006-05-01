/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $URL$
 **
 ** Copyright (C) 2004-2005 Open GIS Consortium, Inc.
 ** All Rights Reserved. http://www.opengis.org/legal/
 **
 *************************************************************************************************/
package org.opengis.metadata.citation;

// J2SE direct dependencies
import java.util.Collection;
import java.util.Date;

// OpenGIS direct dependencies
import org.opengis.util.InternationalString;

// Annotations
import org.opengis.annotation.UML;
import org.opengis.annotation.Profile;
import static org.opengis.annotation.Obligation.*;
import static org.opengis.annotation.Specification.*;
import static org.opengis.annotation.ComplianceLevel.*;
import static org.opengis.annotation.Specification.*;


/**
 * Standardized resource reference.
 *
 * @version <A HREF="http://www.opengis.org/docs/01-111.pdf">Abstract specification 5.0</A>
 * @author Martin Desruisseaux (IRD)
 * @since GeoAPI 1.0
 */
@Profile (level=CORE)
@UML(identifier="CI_Citation", specification=ISO_19115)
public interface Citation {
    /**
     * Name by which the cited resource is known.
     */
    @Profile (level=CORE)
    @UML(identifier="title", obligation=MANDATORY, specification=ISO_19115)
    InternationalString getTitle();

    /**
     * Short name or other language name by which the cited information is known.
     * Example: "DCW" as an alternative title for "Digital Chart of the World".
     */
    @UML(identifier="alternateTitle", obligation=OPTIONAL, specification=ISO_19115)
    Collection<InternationalString> getAlternateTitles();

    /**
     * Reference date for the cited resource.
     */
    @Profile (level=CORE)
    @UML(identifier="date", obligation=MANDATORY, specification=ISO_19115)
    Collection<CitationDate> getDates();

    /**
     * Version of the cited resource.
     */
    @UML(identifier="edition", obligation=OPTIONAL, specification=ISO_19115)
    InternationalString getEdition();

    /**
     * Date of the edition, or {@code null} if none.
     */
    @UML(identifier="editionDate", obligation=OPTIONAL, specification=ISO_19115)
    Date getEditionDate();

    /**
     * Unique identifier for the resource. Example: Universal Product Code (UPC),
     * National Stock Number (NSN).
     */
    @UML(identifier="identifier", obligation=OPTIONAL, specification=ISO_19115)
    Collection<String> getIdentifiers();

    /**
     * Reference form of the unique identifier (ID). Example: Universal Product Code (UPC),
     * National Stock Number (NSN).
     */
    @UML(identifier="identifierType", obligation=OPTIONAL, specification=ISO_19115)
    Collection<String> getIdentifierTypes();

    /**
     * Name and position information for an individual or organization that is responsible
     * for the resource. Returns an empty string if there is none.
     */
    @UML(identifier="citedResponsibleParty", obligation=OPTIONAL, specification=ISO_19115)
    Collection<ResponsibleParty> getCitedResponsibleParties();

    /**
     * Mode in which the resource is represented, or an empty string if none.
     */
    @UML(identifier="presentationForm", obligation=OPTIONAL, specification=ISO_19115)
    Collection<PresentationForm> getPresentationForm();

    /**
     * Information about the series, or aggregate dataset, of which the dataset is a part.
     * Returns {@code null} if none.
     */
    @UML(identifier="series", obligation=OPTIONAL, specification=ISO_19115)
    Series getSeries();

    /**
     * Other information required to complete the citation that is not recorded elsewhere.
     * Returns {@code null} if none.
     */
    @UML(identifier="otherCitationDetails", obligation=OPTIONAL, specification=ISO_19115)
    InternationalString getOtherCitationDetails();

    /**
     * Common title with holdings note. Note: title identifies elements of a series
     * collectively, combined with information about what volumes are available at the
     * source cited. Returns {@code null} if there is no title.
     */
    @UML(identifier="collectiveTitle", obligation=OPTIONAL, specification=ISO_19115)
    InternationalString getCollectiveTitle();

    /**
     * International Standard Book Number, or {@code null} if none.
     */
    @UML(identifier="ISBN", obligation=OPTIONAL, specification=ISO_19115)
    String getISBN();

    /**
     * International Standard Serial Number, or {@code null} if none.
     */
    @UML(identifier="ISSN", obligation=OPTIONAL, specification=ISO_19115)
    String getISSN();
}
