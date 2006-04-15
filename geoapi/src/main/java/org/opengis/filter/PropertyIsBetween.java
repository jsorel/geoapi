/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $Source$
 **
 ** Copyright (C) 2005 Open GIS Consortium, Inc.
 ** All Rights Reserved. http://www.opengis.org/legal/
 **
 *************************************************************************************************/
package org.opengis.filter;

// OpenGIS direct dependencies
import org.opengis.filter.expression.Expression;

// Annotations
import org.opengis.annotation.XmlElement;


/**
 * A compact way of encoding a range check. The lower and upper boundary values are inclusive.
 *
 * @version <A HREF="http://www.opengis.org/docs/02-059.pdf">Implementation specification 1.0</A>
 * @author Chris Dillard (SYS Technologies)
 * @since GeoAPI 2.0
 */
@XmlElement("PropertyIsBetween")
public interface PropertyIsBetween extends Filter {
    /**
     * Returns the expression to be compared by this operator.
     */
    @XmlElement("expression")
    Expression getExpression();

    /**
     * Returns the lower bounds (inclusive) an an expression.
     */
    @XmlElement("LowerBoundary")
    Expression getLowerBoundary();

    /**
     * Returns the upper bounds (inclusive) as an expression.
     */
    @XmlElement("UpperBoundary")
    Expression getUpperBoundary();
}
