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
package org.opengis.geometry;

import java.awt.geom.Rectangle2D;                           // For javadoc
import org.opengis.go.display.canvas.Canvas;                // For javadoc
import org.opengis.referencing.cs.AxisDirection;            // For javadoc
import org.opengis.metadata.extent.GeographicBoundingBox;   // For javadoc
import org.opengis.referencing.crs.GeographicCRS;           // For javadoc
import org.opengis.referencing.crs.CRSAuthorityFactory;     // For javadoc
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.TransformException;
import org.opengis.annotation.Extension;


/**
 * Represents a two-dimensional {@linkplain Envelope envelope}.
 * This interface combines the ideas of {@link GeographicBoundingBox} with
 * those of {@link Envelope}. It provides convenience methods to assist
 * in accessing the formal properties of this object. Those methods
 * (for example {@link #getMinX()}) match common usage in existing libraries
 * like {@linkplain Rectangle2D Java2D}.
 * <p>
 * This object contains no additional information beyond that provided
 * by {@link Envelope}.
 * 
 * @author Jody Garnett (Refractions Research)
 * @author Martin Desruisseaux (Geomatys)
 * @since GeoAPI 2.1
 *
 * @todo Remove deprecated methods before release.
 */
@Extension
public interface BoundingBox extends Envelope {
    /**
     * Sets this bounding box to be the same as the specified box.
     */
    void setBounds(BoundingBox bounds);

    /**
     * Provides the minimum ordinate along the first axis.
     * This is equivalent to <code>{@linkplain #getMinimum getMinimum}(0)</code>.
     * There is no guarantee that this axis is oriented toward
     * {@linkplain AxisDirection#EAST East}.
     */
    double getMinX();

    /**
     * Provides the maximum ordinate along the first axis.
     * This is equivalent to <code>{@linkplain #getMaximum getMaximum}(0)</code>.
     * There is no guarantee that this axis is oriented toward
     * {@linkplain AxisDirection#EAST East}.
     */
    double getMaxX();

    /**
     * Provides the minimum ordinate along the second axis.
     * This is equivalent to <code>{@linkplain #getMinimum getMinimum}(1)</code>.
     * There is no guarantee that this axis is oriented toward
     * {@linkplain AxisDirection#NORTH North}.
     */
    double getMinY();

    /**
     * Provides the maximum ordinate along the second axis.
     * This is equivalent to <code>{@linkplain #getMaximum getMaximum}(1)</code>.
     * There is no guarantee that this axis is oriented toward
     * {@linkplain AxisDirection#NORTH North}.
     */
    double getMaxY();

    /**
     * Provides the difference between {@linkplain #getMinX minimum} and
     * {@linkplain #getMaxX maximum} ordinate along the first axis.
     * This is equivalent to <code>{@linkplain #getLength getLength}(0)</code>.
     * There is no guarantee that this axis is oriented toward
     * {@linkplain AxisDirection#EAST East}.
     */
    double getWidth();

    /**
     * Provides the difference between {@linkplain #getMinX minimum} and
     * {@linkplain #getMaxX maximum} ordinate along the second axis.
     * This is equivalent to <code>{@linkplain #getLength getLength}(1)</code>.
     * There is no guarantee that this axis is oriented toward
     * {@linkplain AxisDirection#NORTH North}.
     */
    double getHeight();

    /**
     * Returns {@code true} if {@linkplain #getLength lengths} along all dimension are zero.
     */
    boolean isEmpty();

    /**
     * Include the provided bounding box, expanding as necesary.
     */
    void include(BoundingBox bounds);

    /**
     * Include the provided coordinates, expanding as necessary.
     */
    void include(double x, double y);

    /**
     * Returns {@code true} if the interior of this bounds intersects the interior
     * of the provided bounds.
     */
    boolean intersects(BoundingBox bounds);

    /** 
     * Returns {@code true} if the provided bounds are contained by this bounding box.
     */
    boolean contains(BoundingBox bounds);

    /** 
     * Returns {@code true} if the provided location is contained by this bounding box.
     */
    boolean contains(DirectPosition location);

    /** 
     * Returns {@code true} if the provided location is contained by this bounding box.
     */
    boolean contains(double x, double y);

    /**
     * Transforms this box to the specified CRS and returns a new bounding box for the
     * transformed shape. This method provides a convenient (while not always efficient)
     * way to get {@linkplain #getMinimum minimum} and {@linkplain #getMaximum maximum}
     * ordinate values toward some specific axis directions, typically
     * {@linkplain AxisDirection#EAST East} and {@linkplain AxisDirection#NORTH North}.
     * <p>
     * <b>Example:</b> if {@code box} is a bounding box using a {@linkplain GeographicCRS
     * geographic CRS} with WGS84 datum, then one can write:
     *
     * <blockquote><pre>
     * GeographicCRS targetCRS   = crsAuthorityFactory.{@linkplain CRSAuthorityFactory#createGeographicCRS createGeographicCRS}("EPSG:4326");
     * BoundingBox   targetBox   = box.toBounds(targetCRS);
     * double        minEasting  = targetBox.getMinY();
     * double        minNorthing = targetBox.getMinX();
     * </pre></blockquote>
     *
     * Be aware that {@code "EPSG:4326"} has (<var>latitude</var>, <var>longitude</var>)
     * axis order, thus the inversion of <var>X</var> and <var>Y</var> in the above code.
     * <p>
     * Sophesticated applications will typically provide more efficient way to perform
     * similar transformations in their context. For example {@linkplain Canvas} store
     * precomputed {@linkplain Canvas#getObjectiveToDisplayTransform objective to display
     * transforms}.
     *
     * @param  targetCRS The target CRS for the bounding box to be returned.
     * @return A new bounding box wich includes the shape of this box transformed
     *         to the specified target CRS.
     * @throws TransformException if no transformation path has been found from
     *         {@linkplain #getCoordinateReferenceSystem this box CRS} to the specified
     *         target CRS, or if the transformation failed for an other reason.
     */
    BoundingBox toBounds(CoordinateReferenceSystem targetCRS) throws TransformException;

    /**
     * The coordinate reference system common direct positions defining
     * this bounding box.
     * 
     * @return CoordinateRefernceSystem of provided ordinates.
     *
     * @deprecated Replaced by {@link #getCoordinateReferenceSystem()}.
     */
    CoordinateReferenceSystem crs();

    /**
     * Provides the minimium easting ordinate.
     * <p>
     * This is a helper method for <code>{@linkplain #getMinimum getMinimum}(i)</code>
     * where <var>i</var> is the ordinate used to represent easting.
     *
     * @deprecated Replaced by {@link #getMinX}.
     */
    double minX();

    /**
     * Provides the maximum easting ordinate.
     * <p>
     * This is a helper method for <code>{@linkplain #getMaximum getMaximum}(i)</code>
     * where <var>i</var> is the ordinate used to represent easting.
     *
     * @deprecated Replaced by {@link #getMaxX}.
     */
    double maxX();

    /**
     * Provides the minimium northing ordinate.
     * <p>
     * This is a helper method for <code>{@linkplain #getMinimum getMinimum}(i)</code>
     * where <var>i</var> is the ordinate used to represent northing.
     *
     * @deprecated Replaced by {@link #getMinY}.
     */
    double minY();

    /**
     * Provides the northing easting ordinate.
     * <p>
     * This is a helper method for <code>{@linkplain #getMaximum getMaximum}(i)</code>
     * where <var>i</var> is the ordinate used to represent northing.
     *
     * @deprecated Replaced by {@link #getMaxY}.
     */
    double maxY();

    /**
     * Initialize the bounding box with another bounding box.
     *
     * @deprecated Renamed as {@link #setBounds}.
     */
    void init(BoundingBox bounds);
}
