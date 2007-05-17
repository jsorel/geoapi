/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $URL$
 **
 ** Copyright (C) 2005 Open GIS Consortium, Inc.
 ** All Rights Reserved. http://www.opengis.org/legal/
 **
 *************************************************************************************************/
package org.opengis.coverage;

import java.util.Set;
import org.opengis.geometry.DirectPosition;
import org.opengis.geometry.primitive.Solid;
import org.opengis.annotation.UML;

import static org.opengis.annotation.Obligation.*;
import static org.opengis.annotation.Specification.*;


/**
 * A coverage whose domain consists of a collection of {@linkplain Solid solids}. Solids or their
 * boundaries may be of any shape. Generally, the solids that constitute the domain of a coverage
 * are mutually exclusive and exhaustively partition the extent of the coverage, but this is not
 * required.
 * <p>
 * <b>Example:</b> Buildings in an urban area could be represented as a set of unconnected
 *                 {@linkplain Solid solids} each with attributes such as building name,
 *                 address, floor space, and number of occupants.
 * <p>
 * As in the case of surfaces, the spatial domain of a discrete solid coverage may be a regular or
 * semiregular tessellation of the extent of the coverage. The tessellation can be defined in terms
 * of a 3 dimensional grid, where the set of grid cells is the spatial domain of the coverage.
 *
 * @author Alessio Fabiani
 * 
 * @todo evaluate and evaluateInverse
 */
@UML(identifier="CV_DiscreteSolidCoverage", specification=ISO_19123)
public interface DiscreteSolidCoverage extends DiscreteCoverage {
    /**
     * Returns the set of <var>solid</var>-<var>value</var> pairs included in this coverage.
     */
    @UML(identifier="element", obligation=OPTIONAL, specification=ISO_19123)
    Set<SolidValuePair> getElements();

    /**
     * Returns the set of <var>solid</var>-<var>value</var> pairs that include the
     * {@linkplain DomainObject domain objects} containing the specified direct position.
     */
    @UML(identifier="locate", obligation=OPTIONAL, specification=ISO_19123)
    Set<SolidValuePair> locate(DirectPosition p);

    /**
     * Returns the dictionary of <var>solid</var>-<var>value</var> pairs that contain the
     * {@linkplain DomainObject objects} in the domain of the coverage each paired with its
     * record of feature attribute values.
     */
    @UML(identifier="list", obligation=MANDATORY, specification=ISO_19123)
    Set<SolidValuePair> list();

    /**
     * Returns the nearest <var>solid</var>-<var>value</var> pair from the specified direct
     * position. This is a shortcut for <code>{@linkplain #find(DirectPosition,int) find}(p,1)</code>.
     */
/// @UML(identifier="find", obligation=MANDATORY, specification=ISO_19123)
/// SolidValuePair find(DirectPosition p); 
}
