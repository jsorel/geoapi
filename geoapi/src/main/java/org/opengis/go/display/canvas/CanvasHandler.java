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
package org.opengis.go.display.canvas;


/**
 * The <code>CanvasHandler</code> interface provides programmers with a 
 * mechanism to change <code>Canvas</code> properties.  When a handler is 
 * passed in to <code>Canvas.enableHandler(CanvasHandler)</code>, the 
 * <code>Canvas</code> will give it the active 
 * <code>CanvasController</code>.  The active controller allows the handler to
 * change the canvas, until the handler is removed.
 *
 * @author Open GIS Consortium, Inc.
 * @version $Revision: 658 $, $Date: 2006-02-23 12:09:34 +1100 (jeu., 23 févr. 2006) $
 */
public interface CanvasHandler {
    /**
     * Enables this <code>CanvasHandler</code>, giving it the active 
     * <code>CanvasController<code> and thus the ability to modify the 
     * <code>Canvas</code> that enabled it.
     * @param controller the active <code>CanvasController</code>.
     */
    void handlerEnabled(CanvasController controller);

    /**
     * Removes this <code>CanvasHandler</code>, meaning that calling methods
     * on its <code>CanvasController</code> will no longer affect the 
     * <code>Canvas</code>.  A <code>CanvasHandler</code> should 
     * <b>never</b> attempt to re-enable itself after it has been removed.
     */
    void handlerRemoved();
}
