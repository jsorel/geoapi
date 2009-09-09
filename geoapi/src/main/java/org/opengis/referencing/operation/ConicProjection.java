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
package org.opengis.referencing.operation;


/**
 * Base interface for conical map projections.
 *
 * <p>&nbsp;</p>
 * <p align="center"><img src="../doc-files/ConicProjection.png"></p>
 *
 * @departure extension
 *   This interface is not part of the ISO specification. It has been added in GeoAPI at user
 *   request, in order to provide a way to know the kind of map projection.
 *
 * @author  Martin Desruisseaux (IRD)
 * @since   GeoAPI 1.0
 *
 * @see org.opengis.referencing.crs.ProjectedCRS
 * @see <A HREF="http://mathworld.wolfram.com/ConicProjection.html">Conic projection on MathWorld</A>
 */
public interface ConicProjection extends Projection {
}
