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
import org.opengis.coverage.ValueObject;
import org.opengis.geometry.DirectPosition;
import org.opengis.geometry.primitive.Curve;
import org.opengis.annotation.UML;

import static org.opengis.annotation.Obligation.*;
import static org.opengis.annotation.Specification.*;


/**
 * Basis for interpolating within a {@linkplain SegmentedCurveCoverage segmented curve coverage}.
 * A value curve is composed of a {@linkplain Curve curve} with additional information that supports
 * the determination of feature attribute values at any position on that curve. Value curves depend
 * upon the arc-length parameterization operations defined for {@link Curve}.
 *
 * @author Alessio Fabiani
 * @author Martin Desruisseaux
 */
@UML(identifier="CV_ValueCurve", specification=ISO_19123)
public interface ValueCurve extends ValueObject {
    /**
     * Returns the cruve that is the basis of this value curve.
     *
     * @todo According ISO 19123, the return value should be {@link Curve}.
     */
    @UML(identifier="geometry", obligation=MANDATORY, specification=ISO_19123)
    DomainObject getGeometry();

    /**
     * Returns the set of <var>point</var>-<var>value</var> pairs that provide control
     * values for the interpolation along the value curve.
     */
    @UML(identifier="controlValue", obligation=MANDATORY, specification=ISO_19123)
    Set<PointValuePair> getControlValues();

    /**
     * Returns the set of value segments nearest to the specified direct position. This method
     * shall invoke the {@link Curve#getParamForPoint} method to obtain the distance parameter
     * corresponding to the input direct position. The method {@code getParamForPoint} returns
     * the parameter value for the position on the {@linkplain Curve curve} closest to the input
     * direct position.
     * <p>
     * This method will normally return a single value segment. There are three cases for which
     * it could return multiple value segments:
     * <p>
     * <ul>
     *   <li>The {@code ValueCurve} is not simple. The position on the curve that is closest to the
     *       input direct position is a point of self-intersection. The method {@code getParamForPoint}
     *       returns two or more parameter values. In this case, the method {@code segment} shall raise
     *       an exception.</li>
     *
     *   <li>There are two or more positions on the {@code ValueCurve} that are at the same minimal
     *       distance from the input direct position. The method {@code getParamForPoint} returns
     *       two or more parameter values. In this case, the method {@code segment} shall raise an
     *       exception.</li>
     * 
     *   <li>The position on the {@code ValueCurve} that is closest to the input direct position is
     *       at the end of one {@code ValueSegment} and the start of the next. In this case, the
     *       method shall return both value segments.</li>
     * </ul>
     *
     * @todo I'm not sure to understand how the exception clause is related to the first sentence
     *       in the two first points?
     */
    @UML(identifier="segment", obligation=MANDATORY, specification=ISO_19123)
    Set<ValueSegment> segment(DirectPosition p, Double tolerance);
}
