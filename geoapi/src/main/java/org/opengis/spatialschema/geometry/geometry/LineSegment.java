/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $URL$
 **
 ** Copyright (C) 2003-2005 Open GIS Consortium, Inc.
 ** All Rights Reserved. http://www.opengis.org/legal/
 **
 *************************************************************************************************/
package org.opengis.spatialschema.geometry.geometry;

// Annotations
import org.opengis.annotation.UML;
import static org.opengis.annotation.Obligation.*;
import static org.opengis.annotation.Specification.*;


/**
 * Two distinct {@linkplain org.opengis.spatialschema.geometry.DirectPosition direct positions}
 * (the {@linkplain #getStartPoint start point} and {@linkplain #getEndPoint end point}) joined
 * by a straight line. Thus its interpolation attribute shall be
 * {@link org.opengis.spatialschema.geometry.primitive.CurveInterpolation#LINEAR LINEAR}.
 * The default parameterization is:
 *
 * <blockquote><pre>
 * L = {@linkplain #getEndParam endParam} - {@linkplain #getStartParam startParam}
 * c(s) = ControlPoint[1]+((s-{@linkplain #getStartParam startParam})/L)*(ControlPoint[2]-ControlPoint[1])
 * </pre></blockquote>
 *
 * Any other point in the control point array must fall on this line. The control points of a
 * {@code LineSegment} shall all lie on the straight line between its start point and end
 * point. Between these two points, other positions may be interpolated linearly. The linear
 * interpolation, given using a constructive parameter <var>t</var>, 0 ? <var>t</var> ? 1.0,
 * where c(o) = c.{@linkplain #getStartPoint startPoint} and c(1)=c.{@link #getEndPoint endPoint},
 * is:
 *
 * <blockquote>
 * <var>c</var>(<var>t</var>) = <var>c</var>(0)(1-<var>t</var>) + <var>c</var>(1)<var>t</var>
 * </blockquote>
 *  
 * @version <A HREF="http://www.opengis.org/docs/01-101.pdf">Abstract specification 5</A>
 * @author Martin Desruisseaux (IRD)
 * @since GeoAPI 1.0
 *
 * @see GeometryFactory#createLineSegment
 */
@UML(identifier="GM_LineSegment", specification=ISO_19107)
public interface LineSegment extends LineString {
}
