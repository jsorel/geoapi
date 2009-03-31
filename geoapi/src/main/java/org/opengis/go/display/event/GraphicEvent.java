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
package org.opengis.go.display.event;

import org.opengis.go.display.primitive.Graphic;


/**
 * Provides a common abstraction for the various event objects pertaining to
 * key, mouse, other implementation-specific controls, or change events on a
 * {@link org.opengis.go.display.primitive.Graphic}.
 *
 * @author <A HREF="http://www.opengis.org">OpenGIS&reg; consortium</A>
 */
public interface GraphicEvent {

    //*************************************************************************
    //  methods
    //*************************************************************************

    /**
     * Returns the <code>Graphic</code> this <code>GraphicEvent</code> initially occurred on.
     *
     * @return the <code>Graphic</code> source of this event or {@code null} if none.
     */
    Graphic getGraphic();

    /**
     * Consumes this <code>GraphicEvent</code> so that it will not be
     * processed in the default manner by the source from which it originated.
     */
    void consume();

    /**
     * Returns whether or not this event has been consumed.
     *
     * @return the consumed status.
     */
    boolean isConsumed();
}
