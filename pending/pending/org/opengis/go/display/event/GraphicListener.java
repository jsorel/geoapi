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

import java.util.EventListener;

/**
 * The <code>GraphicListener</code> allows a program to listen to a 
 * <code>Graphic</code> for certain mouse and state events.
 * <p>
 * Note that a <code>Graphic</code>
 * is <i>editable</i> when it can be modified by a user via the display GUI
 * (generally by clicking on graphic editing handles).
 * 
 * @author  Open GIS Consortium, Inc.
 * @version $Revision$, $Date$
 */
public interface GraphicListener extends EventListener {
    
    /**
     * Invoked when the mouse has been clicked on a <code>Graphic</code>.
     */
    public void mouseClicked(GraphicMouseEvent ge);

    /**
     * Invoked when a mouse button has been pressed on a <code>Graphic</code>.
     */
    public void mousePressed(GraphicMouseEvent ge);

    /**
     * Invoked when a mouse button has been released on a <code>Graphic</code>.
     */
    public void mouseReleased(GraphicMouseEvent ge);
    
    /**
     * Invoked when the mouse dwells on a <code>Graphic</code>.  Dwelling 
     * occurs after a mouseEntered event transpires and only after mouseMoved 
     * events have ceased for an arbitrary length of time.  
     */
    public void mouseDwelled(GraphicMouseEvent ge);
    
    /**
     * Invoked when a <code>Graphic</code> is selected, either programmatically
     * or through a mouse gesture.
     */
    public void graphicSelected(GraphicChangeEvent ge);
    
    /**
     * Invoked when a <code>Graphic</code> is deselected, either 
     * programmatically or through a mouse gesture.
     */
    public void graphicDeselected(GraphicChangeEvent ge);
    
    /**
     * Invoked when a <code>Graphic</code> is disposed.
     */
    public void graphicDisposed(GraphicChangeEvent ge);
    
    /**
     * Invoked when a <code>Graphic</code> is put into an editable state.
     */
    public void graphicEditableStart(GraphicChangeEvent ge);
    
    /**
     * Invoked when a <code>Graphic</code> is edited by a gui user.
     */
    public void graphicEditableChanged(GraphicChangeEvent ge);
    
    /**
     * Invoked when a <code>Graphic</code> is no longer in an editable state.
     */
    public void graphicEditableEnd(GraphicChangeEvent ge);
    
    /**
     * Invoked when a <code>Graphic</code> changes in any way, other
     * than editing.
     */
    public void graphicChanged(GraphicChangeEvent ge);
}
