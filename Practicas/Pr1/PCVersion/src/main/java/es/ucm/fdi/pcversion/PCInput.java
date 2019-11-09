package es.ucm.fdi.pcversion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import es.ucm.fdi.interfaces.AbstractInput;

public class PCInput extends AbstractInput implements MouseListener, MouseMotionListener {

    public PCInput(){super();}

    synchronized public void mouseClicked(MouseEvent e){
        TouchEvent event = new TouchEvent(EventType.Clicked, e.getID(), e.getX(), e.getY());
        event.setMessage("mouse clicked on position: " + e.getX() + ", " + e.getY() + " by ID: " + e.getID());
        eventList_.add(event);
    }

    synchronized public void mouseEntered(MouseEvent e){
        TouchEvent event = new TouchEvent(EventType.Entered, e.getID(), e.getX(), e.getY());
        event.setMessage("mouse entered on position: " + e.getX() + ", " + e.getY() + " by ID: " + e.getID());
        eventList_.add(event);
    }

    synchronized public void mouseExited(MouseEvent e){
        TouchEvent event = new TouchEvent(EventType.Exited, e.getID(), e.getX(), e.getY());
        event.setMessage("mouse exited on position: " + e.getX() + ", " + e.getY() + " by ID: " + e.getID());
        eventList_.add(event);
    }

    synchronized public void mousePressed(MouseEvent e){
        TouchEvent event = new TouchEvent(EventType.Pressed, e.getID(), e.getX(), e.getY());
        event.setMessage("mouse pressed on position: " + e.getX() + ", " + e.getY() + " by ID: " + e.getID());
        eventList_.add(event);
    }

    synchronized public void mouseReleased(MouseEvent e){
        TouchEvent event = new TouchEvent(EventType.Released, e.getID(), e.getX(), e.getY());
        event.setMessage("mouse released on position: " + e.getX() + ", " + e.getY() + " by ID: " + e.getID());
        eventList_.add(event);
    }

    synchronized public void mouseDragged(MouseEvent e){
        TouchEvent event = new TouchEvent(EventType.Dragged, e.getID(), e.getX(), e.getY());
        event.setMessage("mouse dragged on position: " + e.getX() + ", " + e.getY() + " by ID: " + e.getID());
        eventList_.add(event);
    }

    synchronized public void mouseMoved(MouseEvent e){
        TouchEvent event = new TouchEvent(EventType.Moved, e.getID(), e.getX(), e.getY());
        event.setMessage("mouse moved on position: " + e.getX() + ", " + e.getY() + " by ID: " + e.getID());
        eventList_.add(event);
    }
}