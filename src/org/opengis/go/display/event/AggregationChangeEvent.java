/**************************************************************************************************
 **
 ** $Id$
 **
 ** $Source$
 **
 ** Copyright (C) 2003 Open GIS Consortium, Inc. All Rights Reserved. http://www.opengis.org/Legal/
 **
 *************************************************************************************************/
package org.opengis.go.display.event;

/**
 * Provides a mechanism for notification of additions, removals, and
 * reorderings of elements in an aggregation.
 * 
 * @version $Revision$, $Date$
 * @author <A HREF="http://www.opengis.org">OpenGIS&reg; consortium</A>
 */
public interface AggregationChangeEvent {

    /**
     * Flag for one or more elements added to the aggregation.
     */
    public static final int ELEMENT_ADDED = 0;

    /**
     * Flag for one or more elements removed from the aggregation.
     */
    public static final int ELEMENT_REMOVED = 1;

    /**
     * Flag for the case of the element order changing within the aggregation.
     */
    public static final int ELEMENTS_REORDERD = 2;

    /**
     * Get the ID flag for this event.
     *
     * @return The event type. One of the {@link #ELEMENT_ADDED},
     *         {@link #ELEMENT_REMOVED} or {@link #ELEMENTS_REORDERD}
     *         constants.
     */
    public int getID();
}
