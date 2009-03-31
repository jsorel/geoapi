/**************************************************************************************************
 **
 ** $Id$
 **
 ** $URL$
 **
 ** Copyright (C) 2003-2005 Open GIS Consortium, Inc.
 ** All Rights Reserved. http://www.opengis.org/legal/
 **
 *************************************************************************************************/
package org.opengis.go.display.primitive;

import java.awt.geom.Point2D;
import javax.swing.Icon;
import javax.measure.unit.Unit;
import org.opengis.go.display.style.PointSymbolizer;
import org.opengis.geometry.DirectPosition;


/**
 * The GraphicIcon defines a common abstraction for implementations that render
 * icons on a drawing surface.
 * <p>
 * The rotation of the icon with respect to an external Coordinate Reference System is
 * measured positively as a clockwise angle, starting from a reference line within the
 * Coordinate Reference System and ending at the x-axis of the local Cartesian plane.
 *
 * @author Open GIS Consortium, Inc.
 */
public interface GraphicIcon extends Graphic {
    /**
     * Sets the icon represented by this GraphicIcon.
     * @param icon the icon to be rendered.
     */
    void setIcon(Icon icon);

    /**
     * Returns the icon represented by this GraphicIcon.
     * @return the icon to be rendered.
     */
    Icon getIcon();

    /**
     * Sets the DirectPosition corresponding to the position of the icon.
     * @param coord the wrapper for the positon.
     */
    void setPosition(DirectPosition coord);

    /**
     * Returns the DirectPosition corresponding to the position of the icon.
     * @return the wrapper for the position of the center point.
     */
    DirectPosition getPosition();

    /**
     * Sets the angle by which to rotate the icon. Use rotation to rotate
     * rotatable icons. For example, use the entity's course to rotate an icon
     * whose shape indicates the direction of the entity (e.g., top-down
     * view of a aircraft) Note: the actual drawing angle may differ from the
     * rotation angle once the GraphicIcon has been projected onto the drawing
     * surface.
     * @param angle the new rotation.
     * @param unit the Unit for the angle value.
     */
    void setRotation(double angle, Unit unit);

    /**
     * Gets the angle by which to rotate the icon.
     * @param unit the Unit for the angle value.
     * @return the rotation angle measured clockwise from the horizontal.
     */
    double getRotation(Unit unit);

    /**
     * Sets the location in the icon (as an offset from the upper left) that
     * will be drawn over the icon's position.  This will also be the point
     * about which rotation will occur.  If the offset coordinate is null, then
     * the icon will be centered over its position.
     */
    void setOffset(Point2D offset);

    /**
     * Returns the location in the icon (as an offset from the upper left)
     * that will be drawn over the icon's position.  This is the center
     * of rotation as well.  If the offset coordinate is null, then the icon
     * will be centered over its position.
     */
    Point2D getOffset();

    /**
     * Returns the <code>GraphicStyle</code> for this <code>GraphicIcon</code>,
     * which is required to be a <code>PointSymbolizer</code>.
     * @return the GraphicIcon's <code>GraphicStyle</code>.
     */
    PointSymbolizer getPointSymbolizer();

    /**
     * Indicates whether this primitive is displaying anchor handles that allow the
     * user to change the rotation of this icon.
     */
    boolean isAllowingRotation();

    /**
     * Sets the boolean that indicates whether this primitive is displaying
     * anchor handles that allow the user to change the rotation of this icon.
     */
    void setAllowingRotation(boolean newValue);
}
