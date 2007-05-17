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
import java.util.Collection;
import org.opengis.geometry.Geometry;
import org.opengis.geometry.DirectPosition;
import org.opengis.temporal.Period;
import org.opengis.util.Record;
import org.opengis.util.RecordType;
import org.opengis.annotation.UML;

import static org.opengis.annotation.Obligation.*;
import static org.opengis.annotation.Specification.*;


/**
 * A coverage that returns a distinct record of feature attribute values for any direct position
 * within its domain. Although the domain of a continuous coverage is ordinarily bounded in terms
 * of its spatial and/or temporal extent, it can be subdivided into an infinite number of direct
 * positions.
 *
 * @author Martin Desruisseaux
 * @author Wim Koolhoven
 */
@UML(identifier="CV_ContinuousCoverage", specification=ISO_19123)
public interface ContinuousCoverage extends Coverage {
    /**
     * Returns the set of value objects used to evaluate the coverage. This
     * association is optional - an analytical coverage needs no value objects.
     */
    @UML(identifier="element", obligation=OPTIONAL, specification=ISO_19123)
    Set<? extends ValueObject> getElements();

    /**
     * Returns a code that identifies the interpolation method that shall be used to derive a
     * feature attribute value at any direct position within the {@linkplain ValueObject value
     * object}. This attribute is optional - no value is needed for an analytical coverage (one
     * that maps direct position to attribute value by using a mathematical function rather than
     * by interpolation).
     */
    @UML(identifier="interpolationType", obligation=OPTIONAL, specification=ISO_19123)
    InterpolationMethod getInterpolationMethod();

    /**
     * Returns the optional parameter types for interpolation. Although many interpolation methods
     * use only the values in the coverage range as input to the interpolation function, there are
     * some methods that require additional parameters. This optional attribute specifies the types
     * of parameters that are needed to support the interpolation method identified by the
     * {@linkplain #getInterpolationMethod interpolation method}. It is a dictionary of names
     * and data types.
     */
    @UML(identifier="interpolationParameterTypes", obligation=OPTIONAL, specification=ISO_19123)
    RecordType getInterpolationParameterTypes();

    /**
     * Returns the set of value objects that contains the specified direct position.
     * It shall return an empty set if the direct position is not on any of the
     * {@linkplain DomainObject objects} within the domain of the continuous coverage.
     */
    @UML(identifier="locate", obligation=OPTIONAL, specification=ISO_19123)
    Set<? extends ValueObject> locate(DirectPosition p);

    /**
     * Returns the set of <var>geometry</var>-<var>value</var> pairs associated with the
     * {@linkplain ValueObject value objects} of which this continuous coverage is composed.
     */
    @UML(identifier="select", obligation=MANDATORY, specification=ISO_19123)
    Set<? extends GeometryValuePair> select(Geometry s, Period t);

    /**
     * Returns a set of records of feature attribute values for the specified direct position. Most
     * evaluation methods involve interpolation within or around a {@linkplain ValueObject value object}.
     * Normally, the input direct position will fall within only one value object, and the operation will
     * return a record of feature attribute values interpolated within that value object. If the direct
     * position falls on the boundary between two value objects, or within two or more overlapping value
     * objects, the operation shall return a record of feature attribute values derived according to the
     * {@linkplain Coverage#getCommonPointRule common point rule}. It shall return an empty set if the direct
     * position is not on any {@linkplain ValueObject value object}.
     */
    @UML(identifier="evaluate", obligation=MANDATORY, specification=ISO_19123)
    Set<Record> evaluate(DirectPosition p, Set<String> list);

    /**
     * Locates the <var>geometry</var>-<var>value</var> pairs for which value equals the specified
     * record, and return the set of {@linkplain DomainObject domain objects} belonging to those pairs.
     * Normally, the {@linkplain DomainObject domain objects} that shall be returned are those belonging
     * to the <var>geometry</var>-<var>value</var> pairs associated with the {@linkplain ValueObject
     * value objects} of which this continuous coverage is composed. However, the operation may return
     * other domain objects derived from those in the domain, as specified by the application schema.
     * The operation shall return an empty set if none of the <var>geometry</var>-<var>value</var> pairs
     * associated with the continuous coverage has a value equal to the specified record.
     * <p>
     * <b>Example:</b>This operation could return a set of contours derived from the feature
     * attribute values associated with the {@linkplain org.opengis.coverage.grid.GridPoint
     * grid points} of a grid coverage.
     */
    @UML(identifier="evaluateInverse", obligation=MANDATORY, specification=ISO_19123)
    Set<? extends DomainObject> evaluateInverse(Record v);
}
