/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $URL$
 **
 ** Copyright (C) 2008 Open GIS Consortium, Inc.
 ** All Rights Reserved. http://www.opengis.org/legal/
 **
 *************************************************************************************************/
package org.opengis.style;

import javax.swing.Icon;
import org.opengis.annotation.XmlElement;
import org.opengis.metadata.citation.OnLineResource;

/**
 * The alternative to a WellKnownName is an external mark format. The MarkIndex
 * allows an individual mark in a mark archive to be selected. An example format for an
 * external mark achive would be a TrueType font file, with MarkIndex being used to
 * select an individual glyph from that file.
 *
 * @version <A HREF="http://www.opengeospatial.org/standards/symbol">Symbology Encoding Implementation Specification 1.1.0</A>
 * @author Open Geospatial Consortium
 * @author Johann Sorel (Geomatys)
 * @since GeoAPI 2.2
 */
public interface ExternalMark {

    /**
     * Returns on online resource defined by an URI.
     *
     * Both OnlineResource and InlineContent can't be null and both
     * can't be set at the same time.
     *
     * @return OnlineResource or null
     */
    @XmlElement("OnlineResource")
    OnLineResource getOnlineResource();

    /**
     * Returns on inline content.
     *
     * Both OnlineResource and InlineContent can't be null and both
     * can't be set at the same time.
     *
     * @return InlineContent or null
     */
    @XmlElement("InlineContent")
    Icon getInlineContent();

    /**
     * Returns the mime type of the onlineResource/InlineContent
     *
     * @return mime type
     */
    @XmlElement("Format")
    String getFormat();

    /**
     * Returns an integer value that can used for accesing a particular
     * Font caracter in a TTF file or a catalog for exemple.
     *
     * @return integer
     */
    @XmlElement("MarkIndex")
    int getMarkIndex();

    /**
     * calls the visit method of a StyleVisitor
     *
     * @param visitor the style visitor
     */
    void accept(StyleVisitor visitor);
    
}
